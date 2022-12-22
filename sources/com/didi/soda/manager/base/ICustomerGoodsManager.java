package com.didi.soda.manager.base;

import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.goods.repo.SelectItemState;

public interface ICustomerGoodsManager extends ICustomerManager {
    void clearSelectItemState(String str);

    ActInfoEntity getActInfo();

    String getActInfoStr();

    SelectItemState getSelectItemState(String str);

    void putSelectItemState(String str, SelectItemState selectItemState);

    void requestGoodsDetail(String str, String str2, ActInfoEntity actInfoEntity, CustomerRpcCallback<GoodsItemEntity> customerRpcCallback);

    void requestGoodsDetail(String str, String str2, String str3, String str4, ActInfoEntity actInfoEntity, CustomerRpcCallback<GoodsItemEntity> customerRpcCallback);

    void setActInfo(ActInfoEntity actInfoEntity);

    void setActInfoStr(String str);

    /* renamed from: com.didi.soda.manager.base.ICustomerGoodsManager$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$requestGoodsDetail(ICustomerGoodsManager _this, String str, String str2, ActInfoEntity actInfoEntity, CustomerRpcCallback customerRpcCallback) {
            _this.requestGoodsDetail(str, str2, "", "", actInfoEntity, customerRpcCallback);
        }
    }
}
