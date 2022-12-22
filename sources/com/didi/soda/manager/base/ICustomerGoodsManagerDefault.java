package com.didi.soda.manager.base;

import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.goods.repo.SelectItemState;
import com.didi.soda.manager.base.ICustomerGoodsManager;

public class ICustomerGoodsManagerDefault implements ICustomerGoodsManager {
    public void clearSelectItemState(String str) {
    }

    public ActInfoEntity getActInfo() {
        return null;
    }

    public String getActInfoStr() {
        return null;
    }

    public String getManagerName() {
        return null;
    }

    public SelectItemState getSelectItemState(String str) {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void putSelectItemState(String str, SelectItemState selectItemState) {
    }

    public /* synthetic */ void requestGoodsDetail(String str, String str2, ActInfoEntity actInfoEntity, CustomerRpcCallback<GoodsItemEntity> customerRpcCallback) {
        ICustomerGoodsManager.CC.$default$requestGoodsDetail(this, str, str2, actInfoEntity, customerRpcCallback);
    }

    public void requestGoodsDetail(String str, String str2, String str3, String str4, ActInfoEntity actInfoEntity, CustomerRpcCallback<GoodsItemEntity> customerRpcCallback) {
    }

    public void setActInfo(ActInfoEntity actInfoEntity) {
    }

    public void setActInfoStr(String str) {
    }
}
