package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class NAPopDialogEntity implements IEntity {
    private static final long serialVersionUID = -4868458714266753189L;
    public int animationEffect;

    /* renamed from: id */
    public String f41041id;
    public PopDialogInfo info;
    public boolean needPopup;
    public int popupType;
    public String popupUrl;
    public String resourceId;

    public static class PopDialogInfo implements IEntity {
        private static final long serialVersionUID = -3450015371311948738L;
        public String btnText;
        public String btnUrl;
        public List<ShareCouponInfoEntity> buttons;
        public String color;
        public List<CouponEntity> couponList;
        public int couponStyle;
        public String imgUrl;
        public String optNote;
        public String promoCode;
        public String redirect;
        public String skinUrl;
        public String text;
        public String textBackground;
        public String textColor;
        public String treatmentGroup;
    }
}
