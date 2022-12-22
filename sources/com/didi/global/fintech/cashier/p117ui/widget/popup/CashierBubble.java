package com.didi.global.fintech.cashier.p117ui.widget.popup;

import android.content.Context;
import android.view.View;
import androidx.core.widget.PopupWindowCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.fintech.cashier.p117ui.widget.popup.model.CashierBubbleBaseModel;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.CashierBubble */
public class CashierBubble {

    /* renamed from: a */
    private C8518a f21929a;

    public CashierBubble(Context context) {
        this.f21929a = new C8518a(context);
    }

    public void setBubbleContent(String str, int i, String str2, int i2, boolean z, BubbleCloseListener bubbleCloseListener) {
        m15855a(str, i, str2, i2, "", -1, (View) null, 0, 0, z, bubbleCloseListener);
    }

    /* renamed from: a */
    private void m15855a(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, BubbleCloseListener bubbleCloseListener) {
        final BubbleCloseListener bubbleCloseListener2 = bubbleCloseListener;
        this.f21929a.mo66259a(str, i, str2, i2, str3, i3, view, i4, i5, z, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BubbleCloseListener bubbleCloseListener = bubbleCloseListener2;
                if (bubbleCloseListener != null) {
                    bubbleCloseListener.onClick(CashierBubble.this);
                } else {
                    CashierBubble.this.dismiss();
                }
            }
        });
    }

    public boolean isShowing() {
        return this.f21929a.isShowing();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66182a(int i) {
        this.f21929a.mo66250a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66188a(String str) {
        this.f21929a.mo66257a(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66191b(int i) {
        this.f21929a.mo66263b(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66183a(int i, int i2, int i3) {
        this.f21929a.mo66252a(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66192b(String str) {
        this.f21929a.mo66258a(str, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66189a(String str, int i) {
        this.f21929a.mo66258a(str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo66195c(String str) {
        this.f21929a.mo66265b(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo66194c(int i) {
        this.f21929a.mo66268c(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66185a(View view) {
        this.f21929a.mo66254a(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66181a() {
        this.f21929a.mo66271d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66186a(View view, int i, int i2) {
        this.f21929a.mo66255a(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66190a(boolean z) {
        this.f21929a.mo66261a(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66187a(final BubbleCloseListener bubbleCloseListener) {
        this.f21929a.mo66253a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BubbleCloseListener bubbleCloseListener = bubbleCloseListener;
                if (bubbleCloseListener != null) {
                    bubbleCloseListener.onClick(CashierBubble.this);
                } else {
                    CashierBubble.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66193b(boolean z) {
        this.f21929a.mo66266b(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo66196d(int i) {
        this.f21929a.mo66272d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66184a(View.OnClickListener onClickListener) {
        this.f21929a.mo66264b(onClickListener);
    }

    public void setBubbleContent(final CashierBubbleBaseModel cashierBubbleBaseModel) {
        this.f21929a.mo66256a(new C8519b(cashierBubbleBaseModel, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (cashierBubbleBaseModel.closeListener != null) {
                    cashierBubbleBaseModel.closeListener.onClick(CashierBubble.this);
                } else {
                    CashierBubble.this.dismiss();
                }
            }
        }));
    }

    public View getView() {
        this.f21929a.getContentView().measure(0, 0);
        return this.f21929a.getContentView();
    }

    public void show(View view) {
        show(view, 0, 0);
    }

    public void show(View view, int i, int i2) {
        show(view, i, i2, 1050);
    }

    public void show(View view, int i, int i2, int i3) {
        PopupWindowCompat.setWindowLayoutType(this.f21929a, i3);
        this.f21929a.mo66267b(view, i, i2);
    }

    public void dismiss() {
        this.f21929a.dismiss();
    }

    public int getPopupWidth() {
        return this.f21929a.mo66249a();
    }

    public int[] getMeasureWidthAndHeight() {
        return this.f21929a.mo66270c();
    }

    public void setWidthAndHeight(int i, int i2) {
        this.f21929a.mo66251a(i, i2);
    }

    public int getPopupHeight() {
        return this.f21929a.mo66262b();
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.CashierBubble$Builder */
    public static class Builder {
        private CashierBubble bubble;

        public Builder(Context context) {
            this.bubble = new CashierBubble(context);
        }

        public CashierBubble build() {
            this.bubble.mo66181a();
            return this.bubble;
        }

        public Builder setBgColor(int i) {
            this.bubble.mo66182a(i);
            return this;
        }

        public Builder setText(String str) {
            this.bubble.mo66188a(str);
            return this;
        }

        public Builder setTextTypeface(int i) {
            this.bubble.mo66191b(i);
            return this;
        }

        public Builder setTextProps(int i, int i2, int i3) {
            this.bubble.mo66183a(i, i2, i3);
            return this;
        }

        public Builder setLeftDrawable(String str) {
            this.bubble.mo66195c(str);
            return this;
        }

        public Builder setLeftDrawable(int i) {
            this.bubble.mo66194c(i);
            return this;
        }

        public Builder setLeftView(View view) {
            this.bubble.mo66185a(view);
            return this;
        }

        public Builder setLeftView(View view, int i, int i2) {
            this.bubble.mo66186a(view, i, i2);
            return this;
        }

        public Builder setCloseBtnVisible(boolean z) {
            this.bubble.mo66190a(z);
            return this;
        }

        public Builder setCloseBtnListener(BubbleCloseListener bubbleCloseListener) {
            this.bubble.mo66187a(bubbleCloseListener);
            return this;
        }

        public Builder setDirection(String str) {
            this.bubble.mo66189a(str, 0);
            return this;
        }

        public Builder setDirection(String str, int i) {
            this.bubble.mo66189a(str, i);
            return this;
        }

        public Builder setOutSideTouch(boolean z) {
            this.bubble.mo66193b(z);
            return this;
        }

        public Builder setMaxLines(int i) {
            this.bubble.mo66196d(i);
            return this;
        }

        public Builder setContentViewOnClick(View.OnClickListener onClickListener) {
            this.bubble.mo66184a(onClickListener);
            return this;
        }

        public Builder setWidthAndHeight(int i, int i2) {
            this.bubble.setWidthAndHeight(i, i2);
            return this;
        }
    }
}
