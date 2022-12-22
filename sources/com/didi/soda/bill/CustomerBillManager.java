package com.didi.soda.bill;

import android.text.TextUtils;
import com.didi.soda.bill.BillUpDataHelper;
import com.didi.soda.bill.repo.BillMessageRepo;
import com.didi.soda.bill.repo.CustomerContactRepo;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerBillManager;
import java.util.List;

public class CustomerBillManager implements ICustomerBillManager {
    public String getManagerName() {
        return "bill";
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void fetchBillInfo(String str, String str2, String str3, String str4, int i, int i2, SceneParamsEntity sceneParamsEntity, String str5, String str6, String str7, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
        CustomerRpcManagerProxy.get().fetchBillInfo(str, str2, str3, str4, i, i2, sceneParamsEntity, str5, str6, str7, cRpcCallBackWithTraceId);
    }

    public void fastBuy(String str, String str2, List<ItemNodeEntity> list, int i, ActInfoEntity actInfoEntity, String str3, int i2, String str4, String str5, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
        CustomerRpcManagerProxy.get().fastBuy(str, str2, list, i, actInfoEntity, str3, i2, str4, str5, cRpcCallBackWithTraceId);
    }

    public void dispatchChange(IEntity iEntity) {
        ((BillMessageRepo) RepoFactory.getRepo(BillMessageRepo.class)).setValue(iEntity);
    }

    public void billUpdate(String str, IEntity iEntity, String str2, int i, String str3, String str4, String str5, CRpcCallBackWithTraceId<BillInfoEntity> cRpcCallBackWithTraceId) {
        BillUpDataHelper.BillUpDataModel upDataEntity;
        IEntity iEntity2 = iEntity;
        if (iEntity2 != null && (upDataEntity = BillUpDataHelper.Companion.getUpDataEntity(iEntity2)) != null) {
            String str6 = str;
            String str7 = str2;
            int i2 = i;
            String str8 = str3;
            String str9 = str4;
            CustomerRpcManagerProxy.get().billUpdate(((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress().aid, str6, upDataEntity.getIndex(), upDataEntity.getPayChannel(), upDataEntity.getTipFeeInfo(), upDataEntity.getShopCouponInfo(), upDataEntity.getCouponInfo(), upDataEntity.getFollowingInfo(), upDataEntity.getRemark(), upDataEntity.getItemsInfo(), upDataEntity.getDelItem(), upDataEntity.getDeliveryMethod(), upDataEntity.getAbnormalItemOpt(), upDataEntity.getRCouponInfo(), str7, i2, str8, str9, upDataEntity.getCutleryEntity(), upDataEntity.getAddTyingEntity(), str5, cRpcCallBackWithTraceId);
        }
    }

    public void setCurrentContact(ContactEntity contactEntity) {
        ((CustomerContactRepo) RepoFactory.getRepo(CustomerContactRepo.class)).setValue(contactEntity);
    }

    public ContactEntity getCurrentContact() {
        ContactEntity contactEntity = (ContactEntity) ((CustomerContactRepo) RepoFactory.getRepo(CustomerContactRepo.class)).getValue();
        if (contactEntity == null) {
            contactEntity = new ContactEntity();
            contactEntity.lastModifyFrom = 1;
        }
        UserInfoEntity userInfo = ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).getUserInfo();
        if (StringUtils.isEmpty(contactEntity.getFirstName()) && StringUtils.isEmpty(contactEntity.getLastName()) && userInfo != null) {
            contactEntity.setName(userInfo.firstName, userInfo.lastName);
        }
        if (TextUtils.isEmpty(contactEntity.phone)) {
            contactEntity.phone = LoginUtil.getPhone();
        }
        if (TextUtils.isEmpty(contactEntity.callingCode)) {
            contactEntity.callingCode = LoginUtil.getCallingCode();
        }
        if (contactEntity.countryId <= 0) {
            contactEntity.countryId = LoginUtil.getCountryId();
        }
        return contactEntity;
    }
}
