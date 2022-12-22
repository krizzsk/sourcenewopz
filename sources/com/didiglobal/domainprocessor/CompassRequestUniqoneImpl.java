package com.didiglobal.domainprocessor;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.unifylogin.spi.CompassRequestInterface;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider({CompassRequestInterface.class})
public class CompassRequestUniqoneImpl implements CompassRequestInterface {
    public void compassRequestBegin() {
        ELog.log("Comp-Req-Interf receive compassRequestBegin from compass ");
        DomainServiceManager.getInstance().notifyDomainSwitchEvent(0, new Bundle());
    }

    public void compassResponse(String str) {
        ELog.debug("Comp-Req-Interf receive domain suffix from compass with " + str);
        if (!TextUtils.isEmpty(str) && DomainUtil.isSupportDomainSwitch(DomainProcessor.getInstance().getApplication())) {
            DomainServiceManager.getInstance().notifyAllDomainChange(str.toLowerCase());
        }
    }

    public boolean cacheDomainSuffixModel(Context context, AbsDomainSuffixModel absDomainSuffixModel) {
        return DomainServiceManager.getInstance().cacheDomainSuffixModel(context, absDomainSuffixModel);
    }

    public void removeDomainSuffixModel(Context context, String str) {
        DomainServiceManager.getInstance().removeDomainSuffixModel(context, str);
    }

    public AbsDomainSuffixModel getCacheDomainSuffixModel(Context context, String str, String str2) {
        return DomainServiceManager.getInstance().getDomainSuffixModel(context, str, str2);
    }

    public boolean cacheDomainSuffix(Context context, String str) {
        ELog.debug("Comp-Req-Interf cache domain from passport_compass");
        HashMap hashMap = new HashMap();
        String domainSuffix = DomainServiceManager.getInstance().getDomainSuffix(context);
        hashMap.put("presuffix", domainSuffix);
        hashMap.put("currsuffix", str);
        hashMap.put("scene", "login");
        ELog.log(String.format("omega track suffix change from %s to %s.", new Object[]{domainSuffix, str}));
        OmegaSDKAdapter.trackEvent("tech_global_domainsuffix_changed", (Map<String, Object>) hashMap);
        return DomainServiceManager.getInstance().cacheDomainSuffix(context, str);
    }

    public String getCacheDomainSuffix(Context context, String str) {
        String domainSuffix = DomainServiceManager.getInstance().getDomainSuffix(context, str);
        ELog.log("Comp-Req-Interf get cache domain CMD from passport_compass will return " + domainSuffix);
        return domainSuffix;
    }

    public boolean isDynamicDomainSupport(Context context) {
        return DomainUtil.isSupportDomainSwitch(context);
    }
}
