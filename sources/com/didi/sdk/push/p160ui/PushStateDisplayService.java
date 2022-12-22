package com.didi.sdk.push.p160ui;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.log.LogEventAdapter;
import com.didi.sdk.push.log.LogEventListener;
import com.didi.sdk.push.log.NativeLogEvent;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import global.didi.pay.newview.pix.IPixView;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.didi.sdk.push.ui.PushStateDisplayService */
public class PushStateDisplayService extends Service {
    public static boolean isStarted = false;
    private Handler.Callback changeImageCallback = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == 0) {
                PushStateDisplayService.this.updateInfo();
                PushStateDisplayService.this.changeImageHandler.sendEmptyMessageDelayed(0, 2000);
            }
            return false;
        }
    };
    /* access modifiers changed from: private */
    public Handler changeImageHandler;
    private View displayView;
    private TextView infoTv;
    /* access modifiers changed from: private */
    public WindowManager.LayoutParams layoutParams;
    /* access modifiers changed from: private */
    public TextView logTv;
    private LogEventListener mLogListener = new LogEventAdapter() {
        public void onPushNativeLog(final NativeLogEvent nativeLogEvent) {
            PushStateDisplayService.this.mMainHandler.post(new Runnable() {
                public void run() {
                    if (PushStateDisplayService.this.logTv != null) {
                        PushStateDisplayService.this.logTv.setText(nativeLogEvent.getMsg());
                    }
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    private Map<String, String> map = new LinkedHashMap();
    /* access modifiers changed from: private */
    public WindowManager windowManager;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        isStarted = true;
        this.windowManager = (WindowManager) getSystemService("window");
        this.layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            this.layoutParams.type = 2038;
        } else {
            this.layoutParams.type = 2002;
        }
        this.layoutParams.format = 1;
        this.layoutParams.gravity = 51;
        this.layoutParams.flags = 40;
        this.layoutParams.width = 700;
        this.layoutParams.height = 700;
        this.layoutParams.x = 0;
        this.layoutParams.y = 300;
        this.changeImageHandler = new Handler(getMainLooper(), this.changeImageCallback);
        LogEventStateHandler.addListener(this.mLogListener);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        showFloatingWindow();
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        LogEventStateHandler.removeListener(this.mLogListener);
    }

    private void showFloatingWindow() {
        if (Build.VERSION.SDK_INT >= 23 && Settings.canDrawOverlays(this)) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.window_push_state, (ViewGroup) null);
            this.displayView = inflate;
            inflate.setOnTouchListener(new FloatingOnTouchListener());
            this.infoTv = (TextView) this.displayView.findViewById(R.id.push_state);
            TextView textView = (TextView) this.displayView.findViewById(R.id.push_log);
            this.logTv = textView;
            textView.setText(IPixView.PAGE_STATUS_INIT);
            updateInfo();
            this.windowManager.addView(this.displayView, this.layoutParams);
            this.changeImageHandler.sendEmptyMessageDelayed(0, 2000);
        }
    }

    /* access modifiers changed from: private */
    public void updateInfo() {
        if (this.infoTv != null) {
            this.map.put(CheckStateActivity.NET_STATE, CheckStateActivity.getNetStateDesc(this));
            this.map.put(CheckStateActivity.PUSH_STATE, PushClient.getClient().isConnected() ? "已连接" : "已断开");
            this.map.put(CheckStateActivity.PUSH_CONN_IP, PushClient.getClient().getConnectIp());
            this.map.put(CheckStateActivity.PUSH_CONN_PORT, String.valueOf(PushClient.getClient().getConnectPort()));
            StringBuilder sb = new StringBuilder();
            Map<String, String> map2 = this.map;
            if (map2 != null) {
                for (Map.Entry next : map2.entrySet()) {
                    sb.append(Const.jaLeft + ((String) next.getKey()) + "]: " + ((String) next.getValue()));
                    sb.append("\n");
                }
            }
            this.infoTv.setText(sb.toString());
        }
    }

    /* renamed from: com.didi.sdk.push.ui.PushStateDisplayService$FloatingOnTouchListener */
    private class FloatingOnTouchListener implements View.OnTouchListener {

        /* renamed from: x */
        private int f37090x;

        /* renamed from: y */
        private int f37091y;

        private FloatingOnTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f37090x = (int) motionEvent.getRawX();
                this.f37091y = (int) motionEvent.getRawY();
                return false;
            } else if (action != 2) {
                return false;
            } else {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i = rawX - this.f37090x;
                int i2 = rawY - this.f37091y;
                this.f37090x = rawX;
                this.f37091y = rawY;
                PushStateDisplayService.this.layoutParams.x += i;
                PushStateDisplayService.this.layoutParams.y += i2;
                PushStateDisplayService.this.windowManager.updateViewLayout(view, PushStateDisplayService.this.layoutParams);
                return false;
            }
        }
    }
}
