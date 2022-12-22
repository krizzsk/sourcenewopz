package com.didi.soda.order.component.tips;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity;
import java.util.HashMap;
import java.util.Map;

public class TipState implements IEntity {
    private static final long serialVersionUID = 331073511568139277L;
    public String mBubbleTxt;
    public String mBusinessId;
    public TipsConfigEntity mConfig;
    public String mCurrency;
    public Integer mCurrentSeleted = -1;
    public String mInput = "";
    public boolean mInputVisible = false;
    public boolean mIsFromOrder = false;
    public String mNewInput = "";
    public String mOrderId;
    public long mOrderPrice;
    public PayChannelEntity mPaychannel;
    public Map<Integer, Boolean> mSelectStatus = new HashMap();
    public TipFeeInfoEntity mTips;
}
