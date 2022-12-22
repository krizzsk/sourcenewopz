package com.didi.soda.manager.base;

import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.address.manager.AddressTipInfo;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;

public class ICustomerAddressManagerDefault implements ICustomerAddressManager {
    public void clearAddressTip() {
    }

    public void clearDeliveryAddress() {
    }

    public void dispatchDeliveryAddress() {
    }

    public AddressTipInfo getAddressTip() {
        return null;
    }

    public AddressEntity getCacheAddress() {
        return null;
    }

    public AddressEntity getDelieveryAddress() {
        return null;
    }

    public String getManagerName() {
        return null;
    }

    public String getSelectedAid() {
        return null;
    }

    public int getSenceOfSelectedAddress() {
        return 0;
    }

    public void hideAddressAbnormal() {
    }

    public boolean isShowAddressAbnormal() {
        return false;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void registerGpsReceiver(ScopeContext scopeContext, Context context) {
    }

    public void setAddressTip(AddressTipInfo addressTipInfo) {
    }

    public void setDeliveryAddress(AddressEntity addressEntity, boolean z, int i) {
    }

    public void showAddressAbnormal() {
    }

    public Subscription subscribeAddress(ScopeContext scopeContext, Action<AddressEntity> action) {
        return null;
    }

    public void subscribeAddress(Action<AddressEntity> action) {
    }

    public void subscribeAddressAbnormalMessage(ScopeContext scopeContext, Action<Boolean> action) {
    }

    public Subscription subscribeAddressNoViscous(ScopeContext scopeContext, Action<AddressEntity> action) {
        return null;
    }

    public void subscribeAddressOnce(Action2<AddressEntity> action2) {
    }

    public Subscription subscribeAddressTip(ScopeContext scopeContext, Action<AddressTipInfo> action) {
        return null;
    }

    public void unRegisterGpsReceiver(Context context) {
    }

    public void updateAddressTip(ScopeContext scopeContext, double d, double d2) {
    }
}
