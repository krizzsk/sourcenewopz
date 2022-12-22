package com.didi.soda.customer.biz.popdialog;

import com.didi.soda.customer.foundation.rpc.entity.PromoCodeEntity;
import com.didi.soda.customer.foundation.storage.CustomerStorage;

public class PromoCodeStorage extends CustomerStorage<PromoCodeEntity> {
    public PromoCodeEntity getData() {
        PromoCodeEntity promoCodeEntity = (PromoCodeEntity) super.getData();
        return promoCodeEntity == null ? new PromoCodeEntity() : promoCodeEntity;
    }
}
