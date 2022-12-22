package com.didi.sdk.push.p160ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.log.LogEventAdapter;
import com.didi.sdk.push.log.LogEventListener;
import com.didi.sdk.push.log.NativeLogEvent;
import com.didi.sdk.push.log.NetworkChangeEvent;
import com.didi.sdk.push.thread.MainHandler;
import com.taxis99.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* renamed from: com.didi.sdk.push.ui.LogPrinterActivity */
public class LogPrinterActivity extends Activity {
    public static StringBuilder mReceiveString = new StringBuilder();
    private Button mButton;
    /* access modifiers changed from: private */
    public TextView mInfoTv;
    private LogEventListener mLogListener = new LogEventAdapter() {
        public void onNetworkChange(NetworkChangeEvent networkChangeEvent) {
            Map<String, Object> map = networkChangeEvent.toMap();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    LogPrinterActivity logPrinterActivity = LogPrinterActivity.this;
                    logPrinterActivity.addInfo("net_status_change : " + entry);
                }
            }
        }

        public void onPushNativeLog(NativeLogEvent nativeLogEvent) {
            LogPrinterActivity logPrinterActivity = LogPrinterActivity.this;
            logPrinterActivity.addInfo("native log : " + nativeLogEvent.getMsg());
        }
    };
    public Handler mMainHandler = new MainHandler();
    /* access modifiers changed from: private */
    public ScrollView mScrollView;
    /* access modifiers changed from: private */
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_print_log);
        LogEventStateHandler.addListener(this.mLogListener);
        this.mScrollView = (ScrollView) findViewById(R.id.scroll_view);
        this.mInfoTv = (TextView) findViewById(R.id.log_infos);
        Button button = (Button) findViewById(R.id.copy_button);
        this.mButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        addInfo("--------------------------------");
        addInfo("当前网络连接状态: " + CheckStateActivity.getNetStateDesc(this));
        StringBuilder sb = new StringBuilder();
        sb.append("当前Push连接状态: ");
        sb.append(PushClient.getClient().isConnected() ? "已连接" : "已断开");
        addInfo(sb.toString());
        addInfo("Push IP: " + PushClient.getClient().getConnectIp());
        addInfo("Push Port: " + PushClient.getClient().getConnectPort());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LogEventStateHandler.removeListener(this.mLogListener);
    }

    /* access modifiers changed from: private */
    public void addInfo(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    StringBuilder sb = LogPrinterActivity.mReceiveString;
                    sb.append(IMTextUtils.STREET_IMAGE_TAG_START + LogPrinterActivity.this.simpleDateFormat.format(new Date()) + ">: ");
                    sb.append(str);
                    sb.append("\n");
                    LogPrinterActivity.this.mInfoTv.setText(LogPrinterActivity.mReceiveString.toString());
                    LogPrinterActivity.this.mScrollView.post(new Runnable() {
                        public void run() {
                            LogPrinterActivity.this.mScrollView.fullScroll(130);
                        }
                    });
                }
            });
        }
    }
}
