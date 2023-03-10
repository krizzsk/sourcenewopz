package com.didi.dimina.webview.container;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.log.FusionLogHelper;
import com.didi.dimina.webview.log.LogFloatingView;
import com.didi.sdk.apm.SystemUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseHybridableActivity extends FragmentActivity implements UpdateUIHandler {
    public static final String PICKED_URL = "picked_url";
    public static final int PICK_URL_REQUEST = 10066;
    public static final String UI_TARGET_DEBUG_LOGVIEW = "debug_log";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LogFloatingView f18226a;

    /* renamed from: b */
    private Handler f18227b;

    public abstract FusionWebView getWebView();

    public Handler getHandler() {
        return this.f18227b;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        FusionLogHelper.isFusionLogOpen(this);
        FusionEngine.init(this);
        this.f18226a = new LogFloatingView(this);
        this.f18227b = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                String str = (String) message.obj;
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                if (BaseHybridableActivity.this.f18226a != null) {
                    LogFloatingView a = BaseHybridableActivity.this.f18226a;
                    a.writeLine(format + " : " + str);
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
            this.f18227b.sendMessage(message);
        }
    }

    public void showLogView() {
        this.f18226a.smartShow();
    }

    public void hideLogView() {
        this.f18226a.smartHide();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        FusionWebView webView = getWebView();
        if (webView != null) {
            webView.onDestroy();
        }
    }

    public void showLogViewWithoutCheck() {
        this.f18226a.smartShow();
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
