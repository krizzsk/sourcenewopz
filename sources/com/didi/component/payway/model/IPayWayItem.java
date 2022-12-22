package com.didi.component.payway.model;

import java.io.Serializable;

public interface IPayWayItem extends Serializable {
    public static final int ACTION_TYPE_BIND_CARD = 2;
    public static final int ACTION_TYPE_PAYWAY_SELECT = 3;
    public static final int ACTION_TYPE_SWITCH_PAYWAY = 1;
    public static final int IS_PAY_OFFLINE = 1;
    public static final int IS_SINGED = 1;
    public static final int ITEM_ENABLED = 0;
    public static final int ITEM_SELECTED = 1;
    public static final int PAY_ONLINE = 0;

    String getCard();

    String getCardOrg();

    int getChannelID();

    int getDisabled();

    String getIconUrl();

    String getLabel();

    int getPayType();

    String getSubLabel();

    int getTag();

    int getViewType();

    boolean isEnable();

    int isOffline();

    int isSelected();

    int isSigned();

    void setPayType(int i);

    void setSigned(int i);
}
