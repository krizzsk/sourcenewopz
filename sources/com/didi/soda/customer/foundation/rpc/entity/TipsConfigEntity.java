package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class TipsConfigEntity implements IEntity {
    private static final long serialVersionUID = -5223874404528254218L;
    public int cash;
    public int isOpen;
    public int maxTipFeePrice;
    public int maxTipFeeRate;
    public long paid;
    public int payChannel;
    public PayChannelEntity payment;
    public List<Long> tipFeeConfig;
    public int tipFeeType;
}
