package com.didi.app.nova.skeleton.title;

import android.graphics.Typeface;
import android.view.View;

public class TextAttr implements Attr {

    /* renamed from: a */
    String f8519a;

    /* renamed from: b */
    int f8520b;

    /* renamed from: c */
    int f8521c;

    /* renamed from: d */
    Typeface f8522d;

    /* renamed from: e */
    View.OnClickListener f8523e;

    TextAttr(Builder builder) {
        this.f8519a = builder.text;
        this.f8520b = builder.textSize;
        this.f8521c = builder.textColor;
        this.f8522d = builder.textType;
        this.f8523e = builder.listener;
    }

    public String getText() {
        return this.f8519a;
    }

    public int getTextSize() {
        return this.f8520b;
    }

    public int getTextColor() {
        return this.f8521c;
    }

    public Typeface getTextType() {
        return this.f8522d;
    }

    public View.OnClickListener getListener() {
        return this.f8523e;
    }

    public static class Builder {
        View.OnClickListener listener;
        String text;
        int textColor;
        int textSize;
        Typeface textType;

        public Builder(String str) {
            this.text = str;
        }

        public Builder size(int i) {
            this.textSize = i;
            return this;
        }

        public Builder color(int i) {
            this.textColor = i;
            return this;
        }

        public Builder type(Typeface typeface) {
            this.textType = typeface;
            return this;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public TextAttr build() {
            return new TextAttr(this);
        }
    }
}
