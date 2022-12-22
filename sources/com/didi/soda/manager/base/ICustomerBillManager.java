package com.didi.soda.manager.base;

import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import java.util.List;

public interface ICustomerBillManager extends ICustomerManager {
    void billUpdate(String str, IEntity iEntity, String str2, int i, String str3, String str4, String str5, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId);

    void dispatchChange(IEntity iEntity);

    void fastBuy(String str, String str2, List<ItemNodeEntity> list, int i, ActInfoEntity actInfoEntity, String str3, int i2, String str4, String str5, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId);

    void fetchBillInfo(String str, String str2, String str3, String str4, int i, int i2, SceneParamsEntity sceneParamsEntity, String str5, String str6, String str7, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId);

    ContactEntity getCurrentContact();

    void setCurrentContact(ContactEntity contactEntity);
}
