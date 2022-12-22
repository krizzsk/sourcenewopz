package com.didi.app.nova.skeleton.title;

import android.graphics.drawable.Drawable;
import android.view.View;

public class TitleAttr implements Attr {

    /* renamed from: a */
    String f8524a;

    /* renamed from: b */
    int f8525b;

    /* renamed from: c */
    Drawable f8526c;

    /* renamed from: d */
    View.OnClickListener f8527d;

    TitleAttr(Builder builder) {
        this.f8524a = builder.text;
        this.f8525b = builder.iconRes;
        this.f8526c = builder.icon;
        this.f8527d = builder.listener;
    }

    public String getText() {
        return this.f8524a;
    }

    public int getIconRes() {
        return this.f8525b;
    }

    public Drawable getIcon() {
        return this.f8526c;
    }

    public View.OnClickListener getListener() {
        return this.f8527d;
    }

    public static class Builder {
        Drawable icon;
        int iconRes;
        View.OnClickListener listener;
        String text;

        public Builder(String str) {
            this.text = str;
        }

        public Builder(String str, int i) {
            this.text = str;
            this.iconRes = i;
        }

        public Builder(String str, Drawable drawable) {
            this.text = str;
            this.icon = drawable;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public TitleAttr build() {
            return new TitleAttr(this);
        }
    }
}
