package com.didi.soda.customer.foundation.rpc.entity;

public class DebtInfoEntity implements IEntity {
    private static final long serialVersionUID = -7331726169834727494L;
    public BiDataEntity biData;
    public String debtId;
    public String emphasizedText;
    public int isComplete;
    public int isStatusPaying;
    public String orderId;
    public int payBtnStatus;
    public PayChannelEntity payChannel;
    public int unpaidMoney;
    public String unpaidMoneyDisplay;
}
