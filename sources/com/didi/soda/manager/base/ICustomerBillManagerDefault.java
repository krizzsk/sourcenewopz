package com.didi.soda.manager.base;

import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import java.util.List;

public class ICustomerBillManagerDefault implements ICustomerBillManager {
    public void billUpdate(String str, IEntity iEntity, String str2, int i, String str3, String str4, String str5, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
    }

    public void dispatchChange(IEntity iEntity) {
    }

    public void fastBuy(String str, String str2, List<ItemNodeEntity> list, int i, ActInfoEntity actInfoEntity, String str3, int i2, String str4, String str5, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
    }

    public void fetchBillInfo(String str, String str2, String str3, String str4, int i, int i2, SceneParamsEntity sceneParamsEntity, String str5, String str6, String str7, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
    }

    public ContactEntity getCurrentContact() {
        return null;
    }

    public String getManagerName() {
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

    public void setCurrentContact(ContactEntity contactEntity) {
    }
}
