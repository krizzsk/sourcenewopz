package com.didi.sdk.view.picker;

public class Style {
    public int backgroundResource = -1;
    public int lineColor = -1;
    public int paddingBottom = -1;
    public int paddingTop = -1;
    public String[] suffix;
    public String[] suffixScope;
    public int textColor = -1;
    public int[] weight;

    public static class Builder {
        private Style mStyle = new Style();

        public Builder setWeight(int... iArr) {
            this.mStyle.weight = iArr;
            return this;
        }

        public Builder setSuffix(String... strArr) {
            this.mStyle.suffix = strArr;
            return this;
        }

        public Builder setSuffixScope(String... strArr) {
            this.mStyle.suffixScope = strArr;
            return this;
        }

        public Builder setTextColor(int i) {
            this.mStyle.textColor = i;
            return this;
        }

        public Builder setLineColor(int i) {
            this.mStyle.lineColor = i;
            return this;
        }

        public Builder setBackgroundResource(int i) {
            this.mStyle.backgroundResource = i;
            return this;
        }

        public Builder setPaddingVertical(int i, int i2) {
            this.mStyle.paddingTop = i;
            this.mStyle.paddingBottom = i2;
            return this;
        }

        public Style build() {
            return this.mStyle;
        }
    }
}
