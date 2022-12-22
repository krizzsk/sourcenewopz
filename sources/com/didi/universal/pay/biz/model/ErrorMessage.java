package com.didi.universal.pay.biz.model;

import android.view.View;

public class ErrorMessage {
    public static final int ICON_INFO = 2131689490;
    public static final int ICON_NETWORK_ERROR = 2131689489;
    public static final int ICON_SMILE = 2131689492;
    public ErrorButton cancelBtn;
    public ErrorButton confirmBtn;
    public int errorCode;
    public int icon = ICON_INFO;
    public String message;

    public class ErrorButton {
        public String btnText;
        public View.OnClickListener onClickListener;

        public ErrorButton(String str, View.OnClickListener onClickListener2) {
            this.btnText = str;
            this.onClickListener = onClickListener2;
        }
    }
}
