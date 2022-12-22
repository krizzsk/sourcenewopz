package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class PayTipConfigEntity implements IEntity {
    private static final long serialVersionUID = 3212057610615545844L;
    public int cash;
    public int isOpen;
    public int maxTipFeePrice;
    public int maxTipFeeRate;
    public int paid;
    public int payChannel;
    public List<String> tipFeeConfig;
    public int tipFeeType;
}
