package com.didi.rfusion.widget.floating;

import android.view.View;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;

public class RFFloatingIconAttr implements Cloneable {
    public static final int ICON_BACK = 2;
    public static final int ICON_CLOSE = 1;

    /* renamed from: a */
    int f33550a;

    /* renamed from: b */
    int f33551b;

    /* renamed from: c */
    View.OnClickListener f33552c;

    private RFFloatingIconAttr() {
    }

    public RFFloatingIconAttr(Builder builder) {
        this.f33550a = builder.iconType;
        this.f33551b = builder.iconColor;
        this.f33552c = builder.listener;
    }

    public int getIconType() {
        return this.f33550a;
    }

    public String getIcon() {
        return RFResUtils.getString(this.f33550a != 2 ? R.string.rf_icon_close : R.string.rf_icon_back);
    }

    public int getColor() {
        return this.f33551b;
    }

    public View.OnClickListener getListener() {
        return this.f33552c;
    }

    public static class Builder {
        int iconColor = -1;
        int iconType;
        View.OnClickListener listener;

        public Builder(int i) {
            this.iconType = i;
        }

        public Builder color(int i) {
            this.iconColor = i;
            return this;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public RFFloatingIconAttr build() {
            return new RFFloatingIconAttr(this);
        }
    }

    /* access modifiers changed from: protected */
    public RFFloatingIconAttr clone() {
        try {
            RFFloatingIconAttr rFFloatingIconAttr = (RFFloatingIconAttr) super.clone();
            rFFloatingIconAttr.f33552c = this.f33552c;
            return rFFloatingIconAttr;
        } catch (Exception e) {
            RFFloatingIconAttr rFFloatingIconAttr2 = new RFFloatingIconAttr();
            e.printStackTrace();
            return rFFloatingIconAttr2;
        }
    }
}
