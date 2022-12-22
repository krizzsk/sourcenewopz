package com.microblink.blinkbarcode.fragment.overlay.components.statusmsg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.didi.trackupload.sdk.Constants;
import com.microblink.blinkbarcode.library.R;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: line */
public class StatusTextManager {
    private boolean IIlIIIllIl;
    private CharSequence IlIllIlIIl;
    private Runnable IlIllIlllI;
    private boolean IllIIIIllI;
    private CharSequence IllIIIllII;
    private Animation lIIIIIllll;
    private Handler lIlIIIIlIl;
    private AtomicBoolean llIIIlllll;
    private boolean llIIlIIlll;
    private TextSwitcher llIIlIlIIl;
    private Animation lllIIIlIlI;

    public StatusTextManager(TextSwitcher textSwitcher, final StatusTextStyler statusTextStyler, int i, int i2) {
        this.IlIllIlIIl = null;
        this.IllIIIllII = null;
        this.llIIIlllll = new AtomicBoolean(false);
        this.IllIIIIllI = true;
        this.lIlIIIIlIl = new Handler(Looper.getMainLooper());
        this.llIIlIIlll = false;
        this.IIlIIIllIl = false;
        this.IlIllIlllI = new Runnable() {
            public void run() {
                StatusTextManager.llIIlIlIIl(StatusTextManager.this);
            }
        };
        this.llIIlIlIIl = textSwitcher;
        final Context context = textSwitcher.getContext();
        this.llIIlIlIIl.setFactory(new ViewSwitcher.ViewFactory(this) {
            public View makeView() {
                TextView textView = new TextView(context);
                textView.setGravity(17);
                statusTextStyler.applyStyle(textView);
                return textView;
            }
        });
        this.lllIIIlIlI = AnimationUtils.loadAnimation(context, i);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, i2);
        this.lIIIIIllll = loadAnimation;
        if (!this.IIlIIIllIl) {
            loadAnimation.setStartOffset(this.lllIIIlIlI.getDuration() + 150);
        }
    }

    private void llIIlIlIIl(CharSequence charSequence, boolean z) {
        if (this.IllIIIIllI) {
            CharSequence charSequence2 = this.IlIllIlIIl;
            if (charSequence2 == null) {
                z = true;
            }
            this.IllIIIllII = charSequence;
            if (z) {
                this.lIlIIIIlIl.removeCallbacks(this.IlIllIlllI);
                this.lIlIIIIlIl.post(this.IlIllIlllI);
            } else if (!charSequence.equals(charSequence2) && this.llIIIlllll.compareAndSet(false, true)) {
                this.lIlIIIIlIl.postDelayed(this.IlIllIlllI, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
            }
        }
    }

    public void setShouldAnimate(boolean z) {
        this.llIIlIIlll = z;
        if (z) {
            this.llIIlIlIIl.setInAnimation(this.lIIIIIllll);
            this.llIIlIlIIl.setOutAnimation(this.lllIIIlIlI);
            return;
        }
        this.llIIlIlIIl.setInAnimation((Animation) null);
        this.llIIlIlIIl.setOutAnimation((Animation) null);
    }

    public void setSimultaneouslyStartAnimations(boolean z) {
        this.IIlIIIllIl = z;
        if (z) {
            this.lIIIIIllll.setStartOffset(0);
        } else {
            this.lIIIIIllll.setStartOffset(this.lllIIIlIlI.getDuration() + 150);
        }
    }

    public void setStatusMessagesEnabled(boolean z) {
        this.IllIIIIllI = z;
        if (!z) {
            this.llIIlIlIIl.setVisibility(4);
        } else {
            this.llIIlIlIIl.setVisibility(0);
        }
    }

    public boolean shouldAnimate() {
        return this.llIIlIIlll;
    }

    public void updateStatus(int i) {
        if (i == 0) {
            updateStatus("");
        } else {
            updateStatus(this.llIIlIlIIl.getContext().getString(i));
        }
    }

    public void updateStatusImmediately(int i) {
        if (i == 0) {
            updateStatusImmediately((CharSequence) "");
        } else {
            updateStatusImmediately((CharSequence) this.llIIlIlIIl.getContext().getString(i));
        }
    }

    public void updateStatus(String str) {
        llIIlIlIIl(str, false);
    }

    public void updateStatusImmediately(CharSequence charSequence) {
        llIIlIlIIl(charSequence, true);
    }

    public static void llIIlIlIIl(StatusTextManager statusTextManager) {
        if (!statusTextManager.IllIIIllII.equals(statusTextManager.IlIllIlIIl)) {
            if (statusTextManager.IlIllIlIIl != null) {
                statusTextManager.llIIlIlIIl.setText(statusTextManager.IllIIIllII);
            } else {
                statusTextManager.llIIlIlIIl.setCurrentText(statusTextManager.IllIIIllII);
            }
            statusTextManager.IlIllIlIIl = statusTextManager.IllIIIllII;
        }
        statusTextManager.llIIIlllll.set(false);
        if (TextUtils.isEmpty(statusTextManager.IlIllIlIIl)) {
            statusTextManager.llIIlIlIIl.setVisibility(4);
        } else {
            statusTextManager.llIIlIlIIl.setVisibility(0);
        }
    }

    public StatusTextManager(TextSwitcher textSwitcher, StatusTextStyler statusTextStyler) {
        this(textSwitcher, statusTextStyler, R.anim.mb_hide_text, R.anim.mb_show_text);
    }
}
