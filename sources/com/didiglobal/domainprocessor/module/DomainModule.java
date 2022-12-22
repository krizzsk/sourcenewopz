package com.didiglobal.domainprocessor.module;

import android.content.Context;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.model.PiiDomainSuffixModel;
import com.didiglobal.domainservice.model.SuffixType;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class DomainModule extends BaseHybridModule {

    /* renamed from: a */
    private Context f50027a;

    public DomainModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f50027a = hybridableContainer.getActivity();
    }

    @JsInterface({"getPiiInfo"})
    public void getPiiInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        PiiDomainSuffixModel piiDomainSuffixModel = (PiiDomainSuffixModel) DomainServiceManager.getInstance().getDomainSuffixModel(this.f50027a, SuffixType.PII);
        if (piiDomainSuffixModel == null || piiDomainSuffixModel.illegal()) {
            callbackFunction.onCallBack(jSONObject2);
            return;
        }
        try {
            jSONObject2.putOpt(ShareConstants.MEDIA_URI, piiDomainSuffixModel.getUris());
            jSONObject2.putOpt("idc_suffix", piiDomainSuffixModel.getSuffixWithHead());
            jSONObject2.putOpt("timeout", Integer.valueOf(piiDomainSuffixModel.getTimeout()));
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            callbackFunction.onCallBack(jSONObject2);
        }
    }
}
