package com.didi.sdk.push.p160ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushConnResult;
import com.didi.sdk.push.PushConnectionListener;
import com.didi.sdk.push.log.LogEventAdapter;
import com.didi.sdk.push.log.LogEventListener;
import com.didi.sdk.push.log.NetworkChangeEvent;
import com.didi.sdk.push.thread.MainHandler;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.taxis99.R;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.didi.sdk.push.ui.CheckStateActivity */
public class CheckStateActivity extends Activity {
    public static final String NET_STATE = "当前网络连接状态";
    public static final String PUSH_CONN_IP = "Push IP";
    public static final String PUSH_CONN_PORT = "Push Port";
    public static final String PUSH_STATE = "当前Push连接状态";
    private PushConnectionListener mConnectionListener = new PushConnectionListener() {
        public void onConnection(PushConnResult pushConnResult) {
            CheckStateActivity.this.updateInfo();
            new Thread(new Runnable() {
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (System.currentTimeMillis() - currentTimeMillis < 10000) {
                        CheckStateActivity.this.updateInfo();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }).start();
        }
    };
    /* access modifiers changed from: private */
    public TextView mInfoTv;
    private Button mLogButton;
    private LogEventListener mLogListener = new LogEventAdapter() {
        public void onNetworkChange(NetworkChangeEvent networkChangeEvent) {
            CheckStateActivity.this.updateInfo();
        }
    };
    private Handler mMainHandler = new MainHandler();
    private Button mRefreshBtn;
    /* access modifiers changed from: private */
    public ScrollView mScrollView;
    private Button mShowWindowBtn;
    private Button mStartPushBtn;
    private Button mStopPushBtn;
    /* access modifiers changed from: private */
    public Map<String, String> map = new LinkedHashMap();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_check_state);
        this.mScrollView = (ScrollView) findViewById(R.id.scroll_view);
        this.mInfoTv = (TextView) findViewById(R.id.info);
        this.mStartPushBtn = (Button) findViewById(R.id.start_push);
        this.mStopPushBtn = (Button) findViewById(R.id.stop_push);
        this.mShowWindowBtn = (Button) findViewById(R.id.show_push_window);
        this.mRefreshBtn = (Button) findViewById(R.id.refresh_btn);
        Button button = (Button) findViewById(R.id.log_activity);
        this.mLogButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CheckStateActivity.this.startActivity(new Intent(CheckStateActivity.this, LogPrinterActivity.class));
            }
        });
        this.mStartPushBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PushClient.getClient().startPush();
            }
        });
        this.mStopPushBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PushClient.getClient().stopPush();
            }
        });
        this.mShowWindowBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CheckStateActivity.this.startPushWindowService();
            }
        });
        this.mRefreshBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CheckStateActivity.this.updateInfo();
            }
        });
        updateInfo();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LogEventStateHandler.addListener(this.mLogListener);
        PushClient.getClient().registerConnectionListener(this.mConnectionListener);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LogEventStateHandler.removeListener(this.mLogListener);
        PushClient.getClient().unregisterConnectionListener(this.mConnectionListener);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)) {
            SystemUtils.showToast(Toast.makeText(this, "授权成功", 0));
            startService(new Intent(this, PushStateDisplayService.class));
            return;
        }
        SystemUtils.showToast(Toast.makeText(this, "授权失败", 0));
    }

    public void startPushWindowService() {
        if (!PushStateDisplayService.isStarted) {
            if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this)) {
                startService(new Intent(this, PushStateDisplayService.class));
                return;
            }
            SystemUtils.showToast(Toast.makeText(this, "当前无权限，请授权", 0));
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 1);
        }
    }

    /* access modifiers changed from: private */
    public void updateInfo() {
        this.map.put(NET_STATE, getNetStateDesc(this));
        this.map.put(PUSH_STATE, PushClient.getClient().isConnected() ? "已连接" : "已断开");
        this.map.put(PUSH_CONN_IP, PushClient.getClient().getConnectIp());
        this.map.put(PUSH_CONN_PORT, String.valueOf(PushClient.getClient().getConnectPort()));
        this.mMainHandler.post(new Runnable() {
            public void run() {
                StringBuilder sb = new StringBuilder();
                if (CheckStateActivity.this.map != null) {
                    for (Map.Entry entry : CheckStateActivity.this.map.entrySet()) {
                        sb.append(Const.jaLeft + ((String) entry.getKey()) + "]: " + ((String) entry.getValue()));
                        sb.append("\n");
                    }
                }
                CheckStateActivity.this.mInfoTv.setText(sb.toString());
                CheckStateActivity.this.mScrollView.post(new Runnable() {
                    public void run() {
                        CheckStateActivity.this.mScrollView.fullScroll(130);
                    }
                });
            }
        });
    }

    public static String getNetStateDesc(Context context) {
        return WsgSecInfo.networkType(context);
    }
}
