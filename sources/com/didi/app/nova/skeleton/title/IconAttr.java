package com.didi.app.nova.skeleton.title;

import android.graphics.drawable.Drawable;
import android.view.View;

public class IconAttr implements Attr {

    /* renamed from: a */
    int f8516a;

    /* renamed from: b */
    Drawable f8517b;

    /* renamed from: c */
    View.OnClickListener f8518c;

    IconAttr(Builder builder) {
        this.f8516a = builder.iconRes;
        this.f8517b = builder.icon;
        this.f8518c = builder.listener;
    }

    public int getIconRes() {
        return this.f8516a;
    }

    public Drawable getIcon() {
        return this.f8517b;
    }

    public View.OnClickListener getListener() {
        return this.f8518c;
    }

    public static class Builder {
        Drawable icon;
        int iconRes;
        View.OnClickListener listener;

        public Builder(int i) {
            this.iconRes = i;
        }

        public Builder(Drawable drawable) {
            this.icon = drawable;
        }

        public Builder click(View.OnClickListener onClickListener) {
            this.listener = onClickListener;
            return this;
        }

        public IconAttr build() {
            return new IconAttr(this);
        }
    }
}
