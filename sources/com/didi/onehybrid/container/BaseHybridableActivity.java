package com.didi.onehybrid.container;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.log.FusionDebugActivity;
import com.didi.onehybrid.log.FusionLogHelper;
import com.didi.onehybrid.log.LogFloatingView;
import com.didi.sdk.apm.SystemUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseHybridableActivity extends FragmentActivity implements UpdateUIHandler {
    public static final String PICKED_URL = "picked_url";
    public static final int PICK_URL_REQUEST = 10066;
    private static final String TAG = "BaseHybridableActivity";
    public static final String UI_TARGET_DEBUG_LOGVIEW = "debug_log";
    private static boolean isLogViewShow = false;
    /* access modifiers changed from: private */
    public LogFloatingView logFloatingView;
    private BusinessAgent mBusinessAgent;
    private Handler mHandler;

    public abstract FusionWebView getWebView();

    public Handler getHandler() {
        return this.mHandler;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        FusionLogHelper.isFusionLogOpen(this);
        FusionEngine.init(this);
        this.mBusinessAgent = FusionEngine.getBusinessAgent();
        this.logFloatingView = new LogFloatingView(this);
        this.mHandler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                String str = (String) message.obj;
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                if (BaseHybridableActivity.this.logFloatingView != null) {
                    LogFloatingView access$000 = BaseHybridableActivity.this.logFloatingView;
                    access$000.writeLine(format + " : " + str);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (FusionLogHelper.isFusionLogOpen(this)) {
            showLogView();
        } else {
            hideLogView();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        hideLogView();
    }

    public void updateUI(String str, Object... objArr) {
        if (!TextUtils.isEmpty(str) && objArr != null && "debug_log".equals(str) && (objArr[0] instanceof String)) {
            Message message = new Message();
            message.obj = objArr[0];
            this.mHandler.sendMessage(message);
        }
    }

    public void showLogView() {
        this.logFloatingView.smartShow();
    }

    public void hideLogView() {
        this.logFloatingView.smartHide();
    }

    public void openDebugActivity() {
        startActivity(new Intent(this, FusionDebugActivity.class));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        FusionWebView webView = getWebView();
        if (webView != null) {
            webView.onDestory();
        }
    }

    public void showLogViewWithoutCheck() {
        this.logFloatingView.smartShow();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Bundle extras;
        super.onActivityResult(i, i2, intent);
        if (i2 == 10066 && intent != null && (extras = intent.getExtras()) != null) {
            String string = extras.getString("picked_url");
            FusionWebView webView = getWebView();
            if (webView != null) {
                webView.loadUrl(string);
            }
        }
    }
}
