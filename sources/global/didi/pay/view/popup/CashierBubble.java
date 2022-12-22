package global.didi.pay.view.popup;

import android.content.Context;
import android.view.View;
import androidx.core.widget.PopupWindowCompat;
import com.didi.autotracker.AutoTrackHelper;
import global.didi.pay.view.popup.model.CashierBubbleBaseModel;

public class CashierBubble {
    private CashierPopup popup;

    public CashierBubble(Context context) {
        this.popup = new CashierPopup(context);
    }

    public void setBubbleContent(String str, int i, String str2, int i2, boolean z, BubbleCloseListener bubbleCloseListener) {
        setBubbleContent(str, i, str2, i2, "", -1, (View) null, 0, 0, z, bubbleCloseListener);
    }

    private void setBubbleContent(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, BubbleCloseListener bubbleCloseListener) {
        final BubbleCloseListener bubbleCloseListener2 = bubbleCloseListener;
        this.popup.setBubbleContent(str, i, str2, i2, str3, i3, view, i4, i5, z, new View.OnClickListener() {
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
        return this.popup.isShowing();
    }

    /* access modifiers changed from: package-private */
    public void setBgColor(int i) {
        this.popup.setBgColor(i);
    }

    /* access modifiers changed from: package-private */
    public void setText(String str) {
        this.popup.setText(str);
    }

    /* access modifiers changed from: package-private */
    public void setTextTypeface(int i) {
        this.popup.setTextTypeface(i);
    }

    /* access modifiers changed from: package-private */
    public void setTextProps(int i, int i2, int i3) {
        this.popup.setTextProps(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void setDirection(String str) {
        this.popup.setDirection(str, 0);
    }

    /* access modifiers changed from: package-private */
    public void setDirection(String str, int i) {
        this.popup.setDirection(str, i);
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(String str) {
        this.popup.setLeftDrawable(str);
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(int i) {
        this.popup.setLeftDrawable(i);
    }

    /* access modifiers changed from: package-private */
    public void setLeftView(View view) {
        this.popup.setLeftView(view);
    }

    /* access modifiers changed from: package-private */
    public void setContentView() {
        this.popup.setContentView();
    }

    /* access modifiers changed from: package-private */
    public void setLeftView(View view, int i, int i2) {
        this.popup.setLeftView(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void setCloseBtnVisible(boolean z) {
        this.popup.setCloseBtnVisible(z);
    }

    /* access modifiers changed from: package-private */
    public void setCloseBtnListener(final BubbleCloseListener bubbleCloseListener) {
        this.popup.setCloseBtnListener(new View.OnClickListener() {
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
    public void setOutSideTouch(boolean z) {
        this.popup.setOutsideTouch(z);
    }

    /* access modifiers changed from: package-private */
    public void setMaxLines(int i) {
        this.popup.setMaxLines(i);
    }

    /* access modifiers changed from: package-private */
    public void setContentViewOnClick(View.OnClickListener onClickListener) {
        this.popup.setContentViewOnClick(onClickListener);
    }

    public void setBubbleContent(final CashierBubbleBaseModel cashierBubbleBaseModel) {
        this.popup.setBubbleContent(new CashierPopupModel(cashierBubbleBaseModel, new View.OnClickListener() {
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
        this.popup.getContentView().measure(0, 0);
        return this.popup.getContentView();
    }

    public void show(View view) {
        show(view, 0, 0);
    }

    public void show(View view, int i, int i2) {
        show(view, i, i2, 1050);
    }

    public void show(View view, int i, int i2, int i3) {
        PopupWindowCompat.setWindowLayoutType(this.popup, i3);
        this.popup.show(view, i, i2);
    }

    public void dismiss() {
        this.popup.dismiss();
    }

    public int getPopupWidth() {
        return this.popup.getContentViewWidth();
    }

    public int[] getMeasureWidthAndHeight() {
        return this.popup.getMeasureWidthAndHeight();
    }

    public void setWidthAndHeight(int i, int i2) {
        this.popup.setWidthAndHeight(i, i2);
    }

    public int getPopupHeight() {
        return this.popup.getContentViewHeight();
    }

    public static class Builder {
        private CashierBubble bubble;

        public Builder(Context context) {
            this.bubble = new CashierBubble(context);
        }

        public CashierBubble build() {
            this.bubble.setContentView();
            return this.bubble;
        }

        public Builder setBgColor(int i) {
            this.bubble.setBgColor(i);
            return this;
        }

        public Builder setText(String str) {
            this.bubble.setText(str);
            return this;
        }

        public Builder setTextTypeface(int i) {
            this.bubble.setTextTypeface(i);
            return this;
        }

        public Builder setTextProps(int i, int i2, int i3) {
            this.bubble.setTextProps(i, i2, i3);
            return this;
        }

        public Builder setLeftDrawable(String str) {
            this.bubble.setLeftDrawable(str);
            return this;
        }

        public Builder setLeftDrawable(int i) {
            this.bubble.setLeftDrawable(i);
            return this;
        }

        public Builder setLeftView(View view) {
            this.bubble.setLeftView(view);
            return this;
        }

        public Builder setLeftView(View view, int i, int i2) {
            this.bubble.setLeftView(view, i, i2);
            return this;
        }

        public Builder setCloseBtnVisible(boolean z) {
            this.bubble.setCloseBtnVisible(z);
            return this;
        }

        public Builder setCloseBtnListener(BubbleCloseListener bubbleCloseListener) {
            this.bubble.setCloseBtnListener(bubbleCloseListener);
            return this;
        }

        public Builder setDirection(String str) {
            this.bubble.setDirection(str, 0);
            return this;
        }

        public Builder setDirection(String str, int i) {
            this.bubble.setDirection(str, i);
            return this;
        }

        public Builder setOutSideTouch(boolean z) {
            this.bubble.setOutSideTouch(z);
            return this;
        }

        public Builder setMaxLines(int i) {
            this.bubble.setMaxLines(i);
            return this;
        }

        public Builder setContentViewOnClick(View.OnClickListener onClickListener) {
            this.bubble.setContentViewOnClick(onClickListener);
            return this;
        }

        public Builder setWidthAndHeight(int i, int i2) {
            this.bubble.setWidthAndHeight(i, i2);
            return this;
        }
    }
}
