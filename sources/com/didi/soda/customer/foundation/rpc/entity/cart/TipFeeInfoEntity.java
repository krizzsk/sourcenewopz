package com.didi.soda.customer.foundation.rpc.entity.cart;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;

public class TipFeeInfoEntity implements IEntity {
    private static final long serialVersionUID = -203531207466117858L;
    public int maxTipFeePrice;
    public int maxTipFeeRate;
    public TipFeeSuggestionEntity suggestion;
    public List<Long> tipFeeConfig;
    public int tipFeeType;
    public long tipFeeValue;
    public long tipPayValue;

    public static class TipFeeSuggestionEntity implements IEntity {
        private static final long serialVersionUID = 5755995199299515364L;
        public int iconPosition;
        public String iconUrl;
    }
}
