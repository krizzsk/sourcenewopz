package com.didi.sdk.audiorecorder.service.multiprocess.socket;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.text.TextUtils;
import com.didi.sdk.audiorecorder.utils.ByteArrayAllocator;
import com.didi.sdk.audiorecorder.utils.IOUtil;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataTransferClient {

    /* renamed from: a */
    private static final String f35539a = "DataTransferClient -> ";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Set<DataReceivedListener> f35540b = Collections.newSetFromMap(new HashMap());

    /* renamed from: c */
    private String f35541c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f35542d;

    /* renamed from: e */
    private LocalSocket f35543e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public InputStream f35544f;

    /* renamed from: g */
    private Thread f35545g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f35546h;

    public interface DataReceivedListener {
        void onReceived(byte[] bArr, int i);
    }

    public DataTransferClient(String str, int i) {
        this.f35541c = str;
        this.f35542d = i;
        LogUtil.log(f35539a, "setup. server = ", str, ", mReadBuffSize = " + i);
    }

    public void addDataReceivedListener(DataReceivedListener dataReceivedListener) {
        this.f35540b.add(dataReceivedListener);
    }

    public void removeDataReceivedListener(DataReceivedListener dataReceivedListener) {
        this.f35540b.remove(dataReceivedListener);
    }

    public void updateServerName(String str) {
        if (!m25156a(str)) {
            this.f35541c = str;
            if (this.f35543e != null) {
                disconnect();
                connect();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r2 = r1.f35543e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m25156a(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = r1.f35541c
            boolean r2 = android.text.TextUtils.equals(r0, r2)
            if (r2 == 0) goto L_0x0014
            android.net.LocalSocket r2 = r1.f35543e
            if (r2 == 0) goto L_0x0014
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferClient.m25156a(java.lang.String):boolean");
    }

    public void connect() {
        if (!this.f35546h && !TextUtils.isEmpty(this.f35541c)) {
            LocalSocket localSocket = this.f35543e;
            if (localSocket == null || !localSocket.isConnected()) {
                try {
                    LocalSocket localSocket2 = new LocalSocket();
                    this.f35543e = localSocket2;
                    localSocket2.connect(new LocalSocketAddress(this.f35541c));
                    this.f35544f = this.f35543e.getInputStream();
                    this.f35546h = true;
                    LogUtil.log(f35539a, "connect to server: " + this.f35541c);
                    if (this.f35544f != null) {
                        ReceiveDataThread receiveDataThread = new ReceiveDataThread();
                        this.f35545g = receiveDataThread;
                        receiveDataThread.start();
                    }
                } catch (Exception e) {
                    LogUtil.log("DataTransferClient -> failed to connect server: " + this.f35541c, e);
                }
            }
        }
    }

    public void disconnect() {
        if (this.f35546h) {
            this.f35546h = false;
            LocalSocket localSocket = this.f35543e;
            if (localSocket != null) {
                try {
                    localSocket.close();
                } catch (IOException unused) {
                }
                this.f35543e = null;
            }
            InputStream inputStream = this.f35544f;
            if (inputStream != null) {
                IOUtil.close(inputStream);
                this.f35544f = null;
            }
            Thread thread = this.f35545g;
            if (thread != null) {
                thread.interrupt();
                this.f35545g = null;
            }
            LogUtil.log(f35539a, "disconnect from server: " + this.f35541c);
        }
    }

    private class ReceiveDataThread extends Thread {
        private final byte[] buffer = new byte[DataTransferClient.this.f35542d];

        public ReceiveDataThread() {
            super("didi-recorder-data-transfer-client");
            setPriority(1);
        }

        public void run() {
            InputStream c;
            int i;
            byte[] allocate;
            super.run();
            LogUtil.log(DataTransferClient.f35539a, "start receive server data.");
            while (DataTransferClient.this.f35546h && (c = DataTransferClient.this.f35544f) != null) {
                try {
                    i = c.read(this.buffer);
                } catch (IOException unused) {
                    i = 0;
                }
                if (i <= 0 || (allocate = ByteArrayAllocator.allocate(i)) == null) {
                    break;
                }
                try {
                    System.arraycopy(this.buffer, 0, allocate, 0, i);
                    dispatch(allocate, i);
                } catch (Exception e) {
                    LogUtil.log("DataTransferClient -> Failed to dispatch server data. ", e);
                }
            }
            LogUtil.log(DataTransferClient.f35539a, "stop receive server data.");
        }

        private void dispatch(byte[] bArr, int i) {
            Iterator it = DataTransferClient.this.f35540b.iterator();
            while (it.hasNext()) {
                DataReceivedListener dataReceivedListener = (DataReceivedListener) it.next();
                if (dataReceivedListener == null) {
                    it.remove();
                } else {
                    dataReceivedListener.onReceived(bArr, i);
                }
            }
        }
    }
}
