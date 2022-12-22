package com.didi.soda.goods.manager;

import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.goods.repo.SelectItemState;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import java.util.HashMap;

public class CustomerGoodsManager implements ICustomerGoodsManager {

    /* renamed from: a */
    private static final String f42426a = "GoodsManager";

    /* renamed from: b */
    private final HashMap<String, SelectItemState> f42427b = new HashMap<>();

    public String getManagerName() {
        return f42426a;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public /* synthetic */ void requestGoodsDetail(String str, String str2, ActInfoEntity actInfoEntity, CustomerRpcCallback<GoodsItemEntity> customerRpcCallback) {
        ICustomerGoodsManager.CC.$default$requestGoodsDetail(this, str, str2, actInfoEntity, customerRpcCallback);
    }

    public void putSelectItemState(String str, SelectItemState selectItemState) {
        this.f42427b.put(str, selectItemState);
    }

    public SelectItemState getSelectItemState(String str) {
        return this.f42427b.get(str);
    }

    public void clearSelectItemState(String str) {
        this.f42427b.remove(str);
    }

    public void requestGoodsDetail(String str, String str2, String str3, String str4, ActInfoEntity actInfoEntity, CustomerRpcCallback<GoodsItemEntity> customerRpcCallback) {
        new GoodsDetailRepo().requestGoodsDetail(str, str2, str3, str4, 0, actInfoEntity, customerRpcCallback);
    }

    public void setActInfo(ActInfoEntity actInfoEntity) {
        ((ActInfoRepo) RepoFactory.getRepo(ActInfoRepo.class)).setValue(actInfoEntity);
    }

    public void setActInfoStr(String str) {
        ((ActInfoRepo) RepoFactory.getRepo(ActInfoRepo.class)).setValueStr(str);
    }

    public ActInfoEntity getActInfo() {
        return (ActInfoEntity) ((ActInfoRepo) RepoFactory.getRepo(ActInfoRepo.class)).getValue();
    }

    public String getActInfoStr() {
        return ((ActInfoRepo) RepoFactory.getRepo(ActInfoRepo.class)).getValueStr();
    }
}
