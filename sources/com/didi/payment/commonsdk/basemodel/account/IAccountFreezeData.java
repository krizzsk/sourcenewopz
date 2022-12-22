package com.didi.payment.commonsdk.basemodel.account;

import java.util.Map;

public interface IAccountFreezeData {
    public static final int FREEZE_STATUS_1 = 1;
    public static final int FREEZE_STATUS_2 = 2;
    public static final int FREEZE_STATUS_BPP_5K_3 = 3;
    public static final int FREEZE_STATUS_NORMAL_0 = 0;
    public static final int TYPE_BANNER = 0;
    public static final int TYPE_DIALOG = 1;

    public enum DataType {
        TYPE_BTN_POS,
        TYPE_BTN_NEG
    }

    public interface IBuilder<T extends IAccountFreezeData> {
        IBuilder btnNeg(String str);

        IBuilder btnPos(String str);

        T build();
    }

    Map<String, Object> getExtras();

    String getLink(int i);

    String getNegBtnText();

    String getPosBtnText();

    String getSubTitle(int i);

    String getText(DataType dataType);

    String getTitle(int i);

    boolean isBlocked();

    boolean isFrozen();

    boolean isJumpable(int i);

    <T> void putExtraData(String str, T t);

    void putExtras(Map<String, Object> map);

    void putIntExtra(String str, int i);

    void putStringExtra(String str, String str2);
}
