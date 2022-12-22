package com.didi.global.globaluikit.popup;

import android.content.Context;
import android.view.View;
import androidx.core.widget.PopupWindowCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.popup.model.LEGOBubbleBaseModel;

public class LEGOBubble {

    /* renamed from: a */
    private C8665a f22591a;

    public LEGOBubble(Context context) {
        this.f22591a = new C8665a(context);
    }

    public void setBubbleContent(String str, int i, String str2, int i2, boolean z, BubbleCloseListener bubbleCloseListener) {
        m16239a(str, i, str2, i2, "", -1, (View) null, 0, 0, z, bubbleCloseListener);
    }

    /* renamed from: a */
    private void m16239a(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, BubbleCloseListener bubbleCloseListener) {
        final BubbleCloseListener bubbleCloseListener2 = bubbleCloseListener;
        this.f22591a.mo67062a(str, i, str2, i2, str3, i3, view, i4, i5, z, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BubbleCloseListener bubbleCloseListener = bubbleCloseListener2;
                if (bubbleCloseListener != null) {
                    bubbleCloseListener.onClick(LEGOBubble.this);
                } else {
                    LEGOBubble.this.dismiss();
                }
            }
        });
    }

    public boolean isShowing() {
        return this.f22591a.isShowing();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66985a(int i) {
        this.f22591a.mo67053a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66991a(String str) {
        this.f22591a.mo67060a(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66994b(int i) {
        this.f22591a.mo67066b(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66986a(int i, int i2, int i3) {
        this.f22591a.mo67055a(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66995b(String str) {
        this.f22591a.mo67061a(str, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66992a(String str, int i) {
        this.f22591a.mo67061a(str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo66998c(String str) {
        this.f22591a.mo67068b(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo66997c(int i) {
        this.f22591a.mo67071c(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66988a(View view) {
        this.f22591a.mo67057a(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66984a() {
        this.f22591a.mo67074d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66989a(View view, int i, int i2) {
        this.f22591a.mo67058a(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66993a(boolean z) {
        this.f22591a.mo67064a(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66990a(final BubbleCloseListener bubbleCloseListener) {
        this.f22591a.mo67056a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BubbleCloseListener bubbleCloseListener = bubbleCloseListener;
                if (bubbleCloseListener != null) {
                    bubbleCloseListener.onClick(LEGOBubble.this);
                } else {
                    LEGOBubble.this.dismiss();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66996b(boolean z) {
        this.f22591a.mo67069b(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo66999d(int i) {
        this.f22591a.mo67075d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66987a(View.OnClickListener onClickListener) {
        this.f22591a.mo67067b(onClickListener);
    }

    public void setBubbleContent(final LEGOBubbleBaseModel lEGOBubbleBaseModel) {
        this.f22591a.mo67059a(new C8666b(lEGOBubbleBaseModel, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (lEGOBubbleBaseModel.closeListener != null) {
                    lEGOBubbleBaseModel.closeListener.onClick(LEGOBubble.this);
                } else {
                    LEGOBubble.this.dismiss();
                }
            }
        }));
    }

    public View getView() {
        this.f22591a.getContentView().measure(0, 0);
        return this.f22591a.getContentView();
    }

    public void show(View view) {
        show(view, 0, 0);
    }

    public void show(View view, int i, int i2) {
        show(view, i, i2, 1000);
    }

    public void show(View view, int i, int i2, int i3) {
        PopupWindowCompat.setWindowLayoutType(this.f22591a, i3);
        this.f22591a.mo67070b(view, i, i2);
    }

    public void dismiss() {
        this.f22591a.dismiss();
    }

    public int getPopupWidth() {
        return this.f22591a.mo67052a();
    }

    public int[] getMeasureWidthAndHeight() {
        return this.f22591a.mo67073c();
    }

    public void setWidthAndHeight(int i, int i2) {
        this.f22591a.mo67054a(i, i2);
    }

    public int getPopupHeight() {
        return this.f22591a.mo67065b();
    }

    public static class Builder {
        private LEGOBubble bubble;

        public Builder(Context context) {
            this.bubble = new LEGOBubble(context);
        }

        public LEGOBubble build() {
            this.bubble.mo66984a();
            return this.bubble;
        }

        public Builder setBgColor(int i) {
            this.bubble.mo66985a(i);
            return this;
        }

        public Builder setText(String str) {
            this.bubble.mo66991a(str);
            return this;
        }

        public Builder setTextTypeface(int i) {
            this.bubble.mo66994b(i);
            return this;
        }

        public Builder setTextProps(int i, int i2, int i3) {
            this.bubble.mo66986a(i, i2, i3);
            return this;
        }

        public Builder setLeftDrawable(String str) {
            this.bubble.mo66998c(str);
            return this;
        }

        public Builder setLeftDrawable(int i) {
            this.bubble.mo66997c(i);
            return this;
        }

        public Builder setLeftView(View view) {
            this.bubble.mo66988a(view);
            return this;
        }

        public Builder setLeftView(View view, int i, int i2) {
            this.bubble.mo66989a(view, i, i2);
            return this;
        }

        public Builder setCloseBtnVisible(boolean z) {
            this.bubble.mo66993a(z);
            return this;
        }

        public Builder setCloseBtnListener(BubbleCloseListener bubbleCloseListener) {
            this.bubble.mo66990a(bubbleCloseListener);
            return this;
        }

        public Builder setDirection(String str) {
            this.bubble.mo66992a(str, 0);
            return this;
        }

        public Builder setDirection(String str, int i) {
            this.bubble.mo66992a(str, i);
            return this;
        }

        public Builder setOutSideTouch(boolean z) {
            this.bubble.mo66996b(z);
            return this;
        }

        public Builder setMaxLines(int i) {
            this.bubble.mo66999d(i);
            return this;
        }

        public Builder setContentViewOnClick(View.OnClickListener onClickListener) {
            this.bubble.mo66987a(onClickListener);
            return this;
        }

        public Builder setWidthAndHeight(int i, int i2) {
            this.bubble.setWidthAndHeight(i, i2);
            return this;
        }
    }
}
