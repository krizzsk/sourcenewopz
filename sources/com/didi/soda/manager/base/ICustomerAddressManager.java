package com.didi.soda.manager.base;

import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.address.manager.AddressTipInfo;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ICustomerAddressManager extends ICustomerManager {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectedAddressSence {
        public static final int AidEmpty = 7;
        public static final int AutoSelected = 6;
        public static final int Default = 0;
        public static final int FromBill = 2;
        public static final int FromBusiness = 9;
        public static final int FromH5 = 4;
        public static final int FromMain = 1;
        public static final int FromOrderDetail = 3;
        public static final int PoiEmpty = 8;
        public static final int SelectBubble = 5;
    }

    void clearAddressTip();

    void clearDeliveryAddress();

    void dispatchDeliveryAddress();

    AddressTipInfo getAddressTip();

    AddressEntity getCacheAddress();

    AddressEntity getDelieveryAddress();

    String getSelectedAid();

    int getSenceOfSelectedAddress();

    void hideAddressAbnormal();

    boolean isShowAddressAbnormal();

    void registerGpsReceiver(ScopeContext scopeContext, Context context);

    void setAddressTip(AddressTipInfo addressTipInfo);

    void setDeliveryAddress(AddressEntity addressEntity, boolean z, int i);

    void showAddressAbnormal();

    Subscription subscribeAddress(ScopeContext scopeContext, Action<AddressEntity> action);

    void subscribeAddress(Action<AddressEntity> action);

    void subscribeAddressAbnormalMessage(ScopeContext scopeContext, Action<Boolean> action);

    Subscription subscribeAddressNoViscous(ScopeContext scopeContext, Action<AddressEntity> action);

    void subscribeAddressOnce(Action2<AddressEntity> action2);

    Subscription subscribeAddressTip(ScopeContext scopeContext, Action<AddressTipInfo> action);

    void unRegisterGpsReceiver(Context context);

    void updateAddressTip(ScopeContext scopeContext, double d, double d2);
}
