package com.didi.sdk.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import didihttpdns.HttpDnsManager;
import didihttpdns.model.DnsRecord;
import didihttpdns.model.DnsResponse;
import didihttpdns.model.IpRecord;
import java.util.Iterator;
import java.util.List;

class PushDnsRefresh {
    private static final String APOLLO_KEY_INTERVAL = "interval";
    private static final String APOLLO_KEY_PUSH_MULTI_ACCESS = "push_multi_access";
    private static final int DELAY = 60;
    private static final int MILLISECOND = 1000;
    private static final int MIN_INTERVAL = 180;
    private static final int MSG_POLLING_HTTPDNS = 1;
    private static final String TAG = "PushDnsRefresh";
    /* access modifiers changed from: private */
    public int interval;
    private boolean mAllow;

    PushDnsRefresh() {
        IToggle toggle = Apollo.getToggle(APOLLO_KEY_PUSH_MULTI_ACCESS, true);
        this.mAllow = toggle.allow();
        PushLog.m26280d(TAG, "httpdns polling enabled ? " + this.mAllow);
        if (this.mAllow) {
            int intValue = ((Integer) toggle.getExperiment().getParam(APOLLO_KEY_INTERVAL, 180)).intValue();
            this.interval = intValue;
            this.interval = Math.max(intValue, 180);
        }
    }

    /* access modifiers changed from: package-private */
    public void start() {
        if (this.mAllow) {
            HandlerThread handlerThread = new HandlerThread(TAG);
            handlerThread.start();
            new PollingHandler(handlerThread.getLooper()).sendEmptyMessageDelayed(1, 60000);
        }
    }

    class PollingHandler extends Handler {
        PollingHandler(Looper looper) {
            super(looper);
        }

        public void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            if (message.what == 1) {
                startPolling();
            }
        }

        private void startPolling() {
            PushLog.m26280d(PushDnsRefresh.TAG, "start polling");
            if (PushClient.getClient().getOption() == null) {
                sendEmptyMessageDelayed(1, 60000);
                return;
            }
            final String ip = PushClient.getClient().getOption().getIp();
            final String connectIp = PushClient.getClient().getConnectIp();
            if (ip.equals(connectIp)) {
                sendEmptyMessageDelayed(1, (long) (PushDnsRefresh.this.interval * 1000));
            } else {
                HttpDnsManager.getInstance().queryHost(ip, new HttpDnsManager.HttpDnsResponseListener() {
                    public void onSuccess(DnsResponse dnsResponse) {
                        if (dnsResponse == null || dnsResponse.getErrno() != 0 || dnsResponse.getList() == null) {
                            PollingHandler.this.sendEmptyMessageDelayed(1, 60000);
                            return;
                        }
                        PollingHandler.this.compare(ip, connectIp, dnsResponse);
                        PollingHandler pollingHandler = PollingHandler.this;
                        pollingHandler.sendEmptyMessageDelayed(1, (long) (PushDnsRefresh.this.interval * 1000));
                    }

                    public void onFailure(Exception exc) {
                        PollingHandler.this.sendEmptyMessageDelayed(1, 60000);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void compare(String str, String str2, DnsResponse dnsResponse) {
            boolean z;
            for (DnsRecord next : dnsResponse.getList()) {
                if (str.equals(next.getHost())) {
                    List<IpRecord> ips = next.getIps();
                    if (ips != null && !ips.isEmpty()) {
                        Iterator<IpRecord> it = ips.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (str2.equals(it.next().getIp())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (!z) {
                            PushClient.getClient().stopPushInternal();
                            PushClient.getClient().startPushInternal();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }
}
