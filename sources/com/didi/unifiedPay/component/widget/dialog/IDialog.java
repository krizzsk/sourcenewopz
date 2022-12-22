package com.didi.unifiedPay.component.widget.dialog;

public interface IDialog {
    public static final int ACTION_CLOSE = 4;
    public static final int ACTION_NEGATIVE = 1;
    public static final int ACTION_NEUTRAL = 3;
    public static final int ACTION_POSITIVE = 2;

    public interface DialogListener {
        void onAction(int i);
    }

    boolean cancelable();

    void dismiss();

    int getId();

    boolean isShowing();

    void show();

    void update(DialogInfo dialogInfo);
}
