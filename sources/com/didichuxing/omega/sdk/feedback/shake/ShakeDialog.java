package com.didichuxing.omega.sdk.feedback.shake;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.didichuxing.omega.sdk.feedback.FeedbackActivator;
import com.didichuxing.omega.sdk.feedback.FeedbackBitmap;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.swarm.toolkit.ScreenshotService;
import com.taxis99.R;
import org.osgi.framework.BundleContext;

class ShakeDialog extends Dialog {
    /* access modifiers changed from: private */
    public static ProgressDialog dialog;
    private final Button cancel_button;
    private final Activity context;
    private final Button feedback_button;
    private boolean isDialogShow = false;
    private final Window loadingWindow;
    private final Button my_feedback_button;
    private final RelativeLayout root_layout;
    /* access modifiers changed from: private */
    public String ticket;

    /* access modifiers changed from: private */
    public void takeScreenShot() {
        BundleContext bundleContext = FeedbackActivator.getInstance().getBundle().getBundleContext();
        ((ScreenshotService) bundleContext.getService(bundleContext.getServiceReference(ScreenshotService.class))).takeScreenshot(2, new ScreenshotService.Callback() {
            public void onScreenshotTaken(Uri uri) {
                FeedbackBitmap.getInstance().setScreenshot_uri(uri);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (ShakeDialog.dialog != null && ShakeDialog.dialog.isShowing()) {
                            ShakeDialog.dialog.dismiss();
                        }
                    }
                });
                ShakeDialog.this.startFeedbackWebview(ShakeConfig.getTiyanUrl() + "tiyan_from=shake&tab=1&ticket=" + ShakeDialog.this.ticket);
            }
        });
    }

    public ShakeDialog(Activity activity, int i) {
        super(activity, i);
        this.context = activity;
        Window window = getWindow();
        this.loadingWindow = window;
        window.setContentView(R.layout.dialog_assign_bug);
        this.feedback_button = (Button) this.loadingWindow.findViewById(R.id.dab_feedback_button);
        this.my_feedback_button = (Button) this.loadingWindow.findViewById(R.id.dab_my_feedback_button);
        this.cancel_button = (Button) this.loadingWindow.findViewById(R.id.dab_cancel_button);
        this.root_layout = (RelativeLayout) this.loadingWindow.findViewById(R.id.dab_root_layout);
        this.feedback_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity currentActivity;
                ShakeDialog.this.dismiss();
                String unused = ShakeDialog.this.ticket = SwarmUtil.getUserToken();
                if (ShakeDialog.this.ticket != null && ShakeDialog.this.ticket.length() > 0 && (currentActivity = SwarmUtil.getCurrentActivity()) != null) {
                    ProgressDialog unused2 = ShakeDialog.dialog = ProgressDialog.show(currentActivity, (CharSequence) null, (CharSequence) null, true, false);
                    ShakeDialog.this.takeScreenShot();
                }
            }
        });
        this.my_feedback_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ShakeDialog.this.dismiss();
                String unused = ShakeDialog.this.ticket = SwarmUtil.getUserToken();
                if (ShakeDialog.this.ticket != null && ShakeDialog.this.ticket.length() > 0) {
                    ShakeDialog.this.startFeedbackWebview(ShakeConfig.getTiyanUrl() + "tiyan_from=shake&tab=2&ticket=" + ShakeDialog.this.ticket);
                }
            }
        });
        this.root_layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ShakeDialog.this.dismiss();
            }
        });
        this.cancel_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ShakeDialog.this.dismiss();
            }
        });
    }

    public void dismiss() {
        if (this.isDialogShow) {
            super.dismiss();
            this.isDialogShow = false;
        }
    }

    public void show() {
        View currentFocus;
        if (!this.isDialogShow) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
            if (!(inputMethodManager == null || (currentFocus = this.context.getCurrentFocus()) == null)) {
                currentFocus.clearFocus();
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 0);
            }
            super.show();
            this.isDialogShow = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        dismiss();
        return false;
    }

    /* access modifiers changed from: private */
    public void startFeedbackWebview(String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("didi.passenger.intent.action.WebActivity");
            intent.putExtra("url", str);
            this.context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
