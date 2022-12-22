package com.didi.soda.customer.biz.popdialog.natived;

public enum PopupType {
    NO_TYPE_POP(0),
    SEND_COUPON_POP(1),
    HAVED_COUPON_POP(2),
    IMAGE_POP(3),
    PROMO_CODE_POP(4),
    NOT_LOGIN_POP(5),
    SHARE_COUPON_POP(6);
    
    int mType;

    private PopupType(int i) {
        this.mType = i;
    }

    public static PopupType getByValue(int i) {
        for (PopupType popupType : values()) {
            if (popupType.getType() == i) {
                return popupType;
            }
        }
        return null;
    }

    public int getType() {
        return this.mType;
    }
}
