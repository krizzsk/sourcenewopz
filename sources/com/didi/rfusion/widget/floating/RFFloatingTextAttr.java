package com.didi.rfusion.widget.floating;

import android.view.View;

public class RFFloatingTextAttr implements Cloneable {

    /* renamed from: a */
    String f33567a;

    /* renamed from: b */
    int f33568b;

    /* renamed from: c */
    View.OnClickListener f33569c;

    private RFFloatingTextAttr() {
    }

    public RFFloatingTextAttr(Builder builder) {
        this.f33567a = builder.text;
        this.f33568b = builder.textColor;
        this.f33569c = builder.listener;
    }

    public String getText() {
        return this.f33567a;
    }

    public int getColor() {
        return this.f33568b;
    }

    public View.OnClickListener getListener() {
        return this.f33569c;
    }

    public static class Builder {
        View.OnClickListener listener;
        String text;
        int textColor = -1;

        public Builder(String str) {
            this.text = str;
        }

        public Builder color(int i) {
            this.textColor = i;
            return this;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public RFFloatingTextAttr build() {
            return new RFFloatingTextAttr(this);
        }
    }

    /* access modifiers changed from: protected */
    public RFFloatingTextAttr clone() {
        try {
            RFFloatingTextAttr rFFloatingTextAttr = (RFFloatingTextAttr) super.clone();
            rFFloatingTextAttr.f33569c = this.f33569c;
            return rFFloatingTextAttr;
        } catch (Exception e) {
            RFFloatingTextAttr rFFloatingTextAttr2 = new RFFloatingTextAttr();
            e.printStackTrace();
            return rFFloatingTextAttr2;
        }
    }
}
