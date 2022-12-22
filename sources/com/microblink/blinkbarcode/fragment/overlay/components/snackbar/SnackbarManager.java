package com.microblink.blinkbarcode.fragment.overlay.components.snackbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.microblink.blinkbarcode.fragment.overlay.components.statusmsg.StatusTextStyler;
import com.microblink.blinkbarcode.library.R;

/* compiled from: line */
public class SnackbarManager {
    private Handler IlIllIlIIl;
    private boolean IllIIIllII;
    private Runnable llIIIlllll;
    /* access modifiers changed from: private */
    public ViewSwitcher llIIlIlIIl;

    public SnackbarManager(ViewSwitcher viewSwitcher, String str, Drawable drawable, StatusTextStyler statusTextStyler, int i, int i2) {
        this.IlIllIlIIl = new Handler(Looper.getMainLooper());
        this.IllIIIllII = false;
        this.llIIIlllll = new Runnable() {
            public void run() {
                SnackbarManager.IlIllIlIIl(SnackbarManager.this);
            }
        };
        this.llIIlIlIIl = viewSwitcher;
        Context context = viewSwitcher.getContext();
        this.llIIlIlIIl.removeAllViews();
        viewSwitcher.addView(new View(context), new ViewGroup.LayoutParams(0, 0));
        View inflate = LayoutInflater.from(context).inflate(R.layout.mb_snackbar_content, viewSwitcher, false);
        viewSwitcher.addView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.tvSnackbarMessage);
        textView.setText(str);
        textView.setBackground(drawable);
        statusTextStyler.applyStyle(textView);
        viewSwitcher.setInAnimation(AnimationUtils.loadAnimation(context, i));
        viewSwitcher.setOutAnimation(AnimationUtils.loadAnimation(context, i2));
    }

    public static void IlIllIlIIl(SnackbarManager snackbarManager) {
        snackbarManager.IllIIIllII = false;
        snackbarManager.IlIllIlIIl.post(new Runnable() {
            public void run() {
                SnackbarManager.this.llIIlIlIIl.setDisplayedChild(0);
            }
        });
    }

    public void hideSnackbar() {
        this.IlIllIlIIl.removeCallbacks(this.llIIIlllll);
        this.IllIIIllII = false;
        this.IlIllIlIIl.post(new Runnable() {
            public void run() {
                SnackbarManager.this.llIIlIlIIl.setDisplayedChild(0);
            }
        });
    }

    public boolean isSnackbarShown() {
        return this.IllIIIllII;
    }

    public void showSnackbar() {
        this.IlIllIlIIl.removeCallbacks(this.llIIIlllll);
        this.IllIIIllII = true;
        this.IlIllIlIIl.post(new Runnable() {
            public void run() {
                SnackbarManager.this.llIIlIlIIl.setDisplayedChild(1);
            }
        });
        this.IlIllIlIIl.postDelayed(this.llIIIlllll, 5000);
    }

    public SnackbarManager(ViewSwitcher viewSwitcher, String str, Drawable drawable, StatusTextStyler statusTextStyler) {
        this(viewSwitcher, str, drawable, statusTextStyler, R.anim.mb_snackbar_in, R.anim.mb_snackbar_out);
    }
}
