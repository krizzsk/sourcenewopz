package com.didi.app.nova.skeleton.title;

public class TitleBarAttr {

    /* renamed from: a */
    private int f8528a;

    /* renamed from: b */
    private int f8529b;

    /* renamed from: c */
    private int f8530c;

    /* renamed from: d */
    private int f8531d;

    private TitleBarAttr(int i, int i2, int i3, int i4) {
        this.f8528a = i;
        this.f8529b = i2;
        this.f8530c = i3;
        this.f8531d = i4;
    }

    public int backIcon() {
        return this.f8528a;
    }

    public int backgroundColor() {
        return this.f8529b;
    }

    public int backgroundDrawable() {
        return this.f8530c;
    }

    public int height() {
        return this.f8531d;
    }

    public static class Builder {
        private int backIcon;
        private int backgroundColor;
        private int backgroundDrawable;
        private int height = -1;

        public Builder backIconRes(int i) {
            this.backIcon = i;
            return this;
        }

        public Builder backgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder backgroundDrawable(int i) {
            this.backgroundDrawable = i;
            return this;
        }

        public Builder height(int i) {
            this.height = i;
            return this;
        }

        public TitleBarAttr build() {
            return new TitleBarAttr(this.backIcon, this.backgroundColor, this.backgroundDrawable, this.height);
        }
    }
}
