package com.didi.beatles.p099im.access.callback;

/* renamed from: com.didi.beatles.im.access.callback.IMAccessSendMessageCallback */
public interface IMAccessSendMessageCallback {
    public static final int STATUS_ERR_INNER_CREATE_SESSION = -3;
    public static final int STATUS_ERR_INNER_SEND = 100;
    public static final int STATUS_INVALID_PARAMS = -2;
    public static final int STATUS_OK = 0;
    public static final IMAccessSendMessageCallback empty = new IMAccessSendMessageCallback() {
        public void onSendStatusChanged(int i, String str, String str2) {
        }
    };

    void onSendStatusChanged(int i, String str, String str2);
}
