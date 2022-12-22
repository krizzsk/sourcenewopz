package com.didi.rfusion.widget.tips;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.tips.RFTips;
import com.didi.rfusion.widget.tips.RFTipsPopupWindow;
import com.taxis99.R;

public class RFTipsPopupWindow extends PopupWindow {

    /* renamed from: a */
    private static final String f33943a = "RFTipsPopupWindow";

    /* renamed from: b */
    private final RFTips f33944b;

    public interface OnCloseListener {
        void onClick(RFTipsPopupWindow rFTipsPopupWindow);
    }

    public RFTipsPopupWindow(Context context) {
        super(context);
        RFTips rFTips = new RFTips(context);
        this.f33944b = rFTips;
        rFTips.setTransitionListener(new RFTips.OnTransitionListener() {
            public void onTipsShow() {
            }

            public void onTipsHide() {
                RFTipsPopupWindow.super.dismiss();
            }
        });
        setContentView(this.f33944b);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.rf_window_transition_none);
        setBackgroundDrawable(new ColorDrawable(RFResUtils.getColor(context, R.color.rf_color_white_100_alpha_0)));
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        super.showAsDropDown(view, i, i2, i3);
    }

    public void dismiss() {
        this.f33944b.setVisibility(8);
    }

    public void setIcon(int i) {
        this.f33944b.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f33944b.setIcon(drawable);
    }

    public void setText(CharSequence charSequence) {
        this.f33944b.setText(charSequence);
    }

    public void setText(int i) {
        this.f33944b.setText(i);
    }

    public void startShake() {
        this.f33944b.startShake();
    }

    public void stopShake() {
        this.f33944b.stopShake();
    }

    public void setEnableTransition(boolean z) {
        this.f33944b.setEnableTransition(z);
    }

    public void setArrowLocation(int i) {
        this.f33944b.setArrowLocation(i);
    }

    public void setType(int i) {
        this.f33944b.setType(i);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.f33944b.setOnCloseListener(onClickListener);
    }

    public static class Builder {
        private Integer arrowLoc = null;
        private final Context context;
        private boolean dismissable = true;
        private boolean enableShake = false;
        private Drawable iconDrawable = null;
        private Integer iconResId = null;
        private boolean isEnableTransitionAnim = true;
        private OnCloseListener onCloseListener = null;
        private CharSequence text = null;
        private Integer textResId = null;
        private Integer type = null;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder setIcon(int i) {
            this.iconResId = Integer.valueOf(i);
            this.iconDrawable = null;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.iconResId = null;
            this.iconDrawable = drawable;
            return this;
        }

        public Builder setText(int i) {
            this.textResId = Integer.valueOf(i);
            this.text = null;
            return this;
        }

        public Builder setText(CharSequence charSequence) {
            this.textResId = null;
            this.text = charSequence;
            return this;
        }

        public Builder setArrowLocation(int i) {
            this.arrowLoc = Integer.valueOf(i);
            return this;
        }

        public Builder setType(int i) {
            this.type = Integer.valueOf(i);
            return this;
        }

        public Builder setDismissible(boolean z) {
            this.dismissable = z;
            return this;
        }

        public Builder shake() {
            this.enableShake = true;
            return this;
        }

        public Builder setEnableTransition(boolean z) {
            this.isEnableTransitionAnim = z;
            return this;
        }

        public Builder setOnCloseListener(OnCloseListener onCloseListener2) {
            this.onCloseListener = onCloseListener2;
            return this;
        }

        public RFTipsPopupWindow build() {
            if (this.context == null) {
                return null;
            }
            RFTipsPopupWindow rFTipsPopupWindow = new RFTipsPopupWindow(this.context);
            Integer num = this.iconResId;
            if (num != null) {
                rFTipsPopupWindow.setIcon(num.intValue());
            }
            Drawable drawable = this.iconDrawable;
            if (drawable != null) {
                rFTipsPopupWindow.setIcon(drawable);
            }
            Integer num2 = this.textResId;
            if (num2 != null) {
                rFTipsPopupWindow.setText(num2.intValue());
            }
            CharSequence charSequence = this.text;
            if (charSequence != null) {
                rFTipsPopupWindow.setText(charSequence);
            }
            if (this.enableShake) {
                rFTipsPopupWindow.startShake();
            }
            rFTipsPopupWindow.setEnableTransition(this.isEnableTransitionAnim);
            Integer num3 = this.arrowLoc;
            if (num3 != null) {
                rFTipsPopupWindow.setArrowLocation(num3.intValue());
            }
            Integer num4 = this.type;
            if (num4 != null) {
                rFTipsPopupWindow.setType(num4.intValue());
            }
            if (this.onCloseListener != null || this.dismissable) {
                rFTipsPopupWindow.setOnCloseListener(new View.OnClickListener(rFTipsPopupWindow) {
                    public final /* synthetic */ RFTipsPopupWindow f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        RFTipsPopupWindow.Builder.this.lambda$build$0$RFTipsPopupWindow$Builder(this.f$1, view);
                    }
                });
            }
            return rFTipsPopupWindow;
        }

        public /* synthetic */ void lambda$build$0$RFTipsPopupWindow$Builder(RFTipsPopupWindow rFTipsPopupWindow, View view) {
            OnCloseListener onCloseListener2 = this.onCloseListener;
            if (onCloseListener2 != null) {
                onCloseListener2.onClick(rFTipsPopupWindow);
            }
            if (this.dismissable) {
                rFTipsPopupWindow.dismiss();
            }
        }
    }
}
