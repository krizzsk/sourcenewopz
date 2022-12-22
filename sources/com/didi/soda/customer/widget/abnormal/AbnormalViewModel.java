package com.didi.soda.customer.widget.abnormal;

import android.view.View;

public class AbnormalViewModel {
    public int backgroundResId;
    public View.OnClickListener clickListener;
    public int resId;
    public String title;
    public int titleId;

    public static class Builder {

        /* renamed from: t */
        private AbnormalViewModel f41612t = new AbnormalViewModel();

        public AbnormalViewModel build() {
            return this.f41612t;
        }

        public Builder setClickListener(View.OnClickListener onClickListener) {
            this.f41612t.clickListener = onClickListener;
            return this;
        }

        public Builder setResId(int i) {
            this.f41612t.resId = i;
            return this;
        }

        public Builder setResTitle(int i) {
            this.f41612t.titleId = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.f41612t.title = str;
            return this;
        }

        public Builder setBackgroundResId(int i) {
            this.f41612t.backgroundResId = i;
            return this;
        }
    }
}
