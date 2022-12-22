package com.didi.entrega.customer.widget.abnormal;

import android.view.View;

public class AbnormalViewModel {
    public View.OnClickListener clickListener;
    public int resId;
    public String retryText;
    public String subTitle;
    public String title;

    public static class Builder {

        /* renamed from: t */
        private AbnormalViewModel f20369t = new AbnormalViewModel();

        public AbnormalViewModel build() {
            return this.f20369t;
        }

        public Builder setClickListener(View.OnClickListener onClickListener) {
            this.f20369t.clickListener = onClickListener;
            return this;
        }

        public Builder setResId(int i) {
            this.f20369t.resId = i;
            return this;
        }

        public Builder setTitle(String str) {
            this.f20369t.title = str;
            return this;
        }

        public Builder setSubTitle(String str) {
            this.f20369t.subTitle = str;
            return this;
        }

        public Builder setRetryText(String str) {
            this.f20369t.retryText = str;
            return this;
        }
    }
}
