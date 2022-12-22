package com.didi.entrega.customer.widget.extra;

public class TextWrapper {
    public int mColorId;
    public int mSize;
    public String mText;
    public int mUnit = 1;

    public static class Builder {
        private TextWrapper mTextWrapper = new TextWrapper();

        public TextWrapper build() {
            return this.mTextWrapper;
        }

        public Builder setColorId(int i) {
            this.mTextWrapper.mColorId = i;
            return this;
        }

        public Builder setSize(int i) {
            this.mTextWrapper.mSize = i;
            return this;
        }

        public Builder setText(String str) {
            this.mTextWrapper.mText = str;
            return this;
        }

        public Builder setUnit(int i) {
            this.mTextWrapper.mUnit = i;
            return this;
        }
    }
}
