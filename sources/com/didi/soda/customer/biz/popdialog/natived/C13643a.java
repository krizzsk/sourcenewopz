package com.didi.soda.customer.biz.popdialog.natived;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.biz.popdialog.PromoCodeStorage;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.repo.CustomerResource;

/* renamed from: com.didi.soda.customer.biz.popdialog.natived.a */
/* compiled from: NAPopDialogRepo */
class C13643a extends Repo<CustomerResource<NAPopDialogEntity>> {

    /* renamed from: a */
    private CustomerRpcService f40494a = CustomerRpcManagerProxy.get();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo102150a(NAPopUpParamsEntity nAPopUpParamsEntity, CustomerRpcCallback<NAPopDialogEntity> customerRpcCallback) {
        String str = ((PromoCodeStorage) SingletonFactory.get(PromoCodeStorage.class)).getData().promoCode;
        if (CustomerApolloUtil.isSkipPromoCode()) {
            this.f40494a.fetchPopDialog(nAPopUpParamsEntity.position, GsonUtil.toJson(nAPopUpParamsEntity.popUpExtEntity), customerRpcCallback);
        } else {
            this.f40494a.fetchPopDialog(nAPopUpParamsEntity.position, GsonUtil.toJson(nAPopUpParamsEntity.popUpExtEntity), str, customerRpcCallback);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo102151a(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        this.f40494a.reportPopDialogExposure(str, customerRpcCallback);
    }
}
