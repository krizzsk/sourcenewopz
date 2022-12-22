package com.didi.soda.customer.widget.abnormal.topgun;

import android.view.View;

public class TopGunAbnormalViewModel {
    public View.OnClickListener clickListener;
    public int resId;
    public String retryText;
    public String subTitle;
    public String title;

    public static class Builder {

        /* renamed from: t */
        private TopGunAbnormalViewModel f41632t = new TopGunAbnormalViewModel();

        public TopGunAbnormalViewModel build() {
            return this.f41632t;
        }

        public Builder setClickListener(View.OnClickListener onClickListener) {
            this.f41632t.clickListener = onClickListener;
            return this;
        }

        public Builder setResId(int i) {
            this.f41632t.resId = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.f41632t.title = str;
            return this;
        }

        public Builder setSubTitle(String str) {
            this.f41632t.subTitle = str;
            return this;
        }

        public Builder setRetryText(String str) {
            this.f41632t.retryText = str;
            return this;
        }
    }
}
