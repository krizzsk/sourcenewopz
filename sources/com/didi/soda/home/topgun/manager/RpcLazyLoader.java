package com.didi.soda.home.topgun.manager;

import android.text.TextUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.ServerConfigManager;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.PrivacyContentStorage;
import com.didi.soda.customer.foundation.tracker.FirebaseAnalyticsHelper;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.home.policy.model.PrivacyContentEntity;

public class RpcLazyLoader {

    /* renamed from: a */
    private static RpcLazyLoader f43006a = new RpcLazyLoader();
    public boolean mIsInit = false;

    public static RpcLazyLoader getLoader() {
        return f43006a;
    }

    public void lazyRpc() {
        if (!this.mIsInit) {
            this.mIsInit = true;
            ServerConfigManager.getInstance().initConfig((ServerConfigManager.OnInitConfigCallback) null);
            m30431a();
            ServerConfigManager.getInstance().initTabIn();
            if (!GlobalContext.isEmbed()) {
                FirebaseAnalyticsHelper.initRemoteConfig();
            }
        }
    }

    /* renamed from: a */
    private void m30431a() {
        final String langTag = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
        final String countryCode = LocationUtil.getCountryCode();
        CustomerRpcManagerProxy.get().checkPrivacyContent(50032, new CustomerRpcCallback<PrivacyContentEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
            }

            public void onRpcSuccess(PrivacyContentEntity privacyContentEntity, long j) {
                if (privacyContentEntity != null) {
                    PrivacyContentStorage privacyContentStorage = (PrivacyContentStorage) SingletonFactory.get(PrivacyContentStorage.class);
                    PrivacyContentEntity data = privacyContentStorage.getData();
                    if (!TextUtils.equals(privacyContentEntity.getVersion(), data.getVersion()) || !TextUtils.equals(countryCode, data.getCountryCode()) || !TextUtils.equals(langTag, data.getLang())) {
                        privacyContentEntity.setLang(langTag);
                        privacyContentEntity.setCountryCode(countryCode);
                        boolean z = true;
                        boolean z2 = ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mHomePolicyAccepted && TextUtils.isEmpty(data.getAcceptedVersion());
                        boolean z3 = !TextUtils.isEmpty(data.getCountryCode()) && !TextUtils.equals(countryCode, data.getCountryCode());
                        if (TextUtils.isEmpty(data.getLang()) || TextUtils.equals(langTag, data.getLang())) {
                            z = false;
                        }
                        if (z2 || z3 || z) {
                            data.setAcceptedVersion(privacyContentEntity.getVersion());
                        }
                        data.refreshCacheData(privacyContentEntity);
                        privacyContentStorage.setData(data);
                    }
                }
            }
        });
    }
}
