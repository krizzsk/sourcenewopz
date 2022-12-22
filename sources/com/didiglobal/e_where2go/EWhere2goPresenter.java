package com.didiglobal.e_where2go;

import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.xengine.register.XERegister;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.common.never.component.EeveeCompPresenterImpl;
import com.didiglobal.e_where2go.model.Where2GoModel;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EWhere2goPresenter extends EeveeCompPresenterImpl<EWhere2goView> {
    public static final String WHERE_TO_GO_CK = "WheretoClick";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Where2GoModel f50047a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public JsonObject f50048b;

    /* renamed from: c */
    private XEResponseCallback f50049c = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            try {
                if (xEngineData.jsonObject != null) {
                    if (xEngineData.jsonObject.has("extension") && xEngineData.jsonObject.get("extension").isJsonObject()) {
                        JsonObject unused = EWhere2goPresenter.this.f50048b = xEngineData.jsonObject.get("extension").getAsJsonObject();
                    }
                    if (xEngineData.jsonObject.has("normal") && xEngineData.jsonObject.get("normal").getAsJsonObject().has("data")) {
                        Where2GoModel unused2 = EWhere2goPresenter.this.f50047a = (Where2GoModel) new Gson().fromJson((JsonElement) xEngineData.jsonObject.get("normal").getAsJsonObject().get("data").getAsJsonObject(), Where2GoModel.class);
                        ((EWhere2goView) EWhere2goPresenter.this.mView).setView();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public EWhere2goPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerTemplate(new XERegisterModel(ComponentType.COMP_WHERE2GO, getNodeEeveeID(), this.f50049c));
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMP_WHERE2GO);
    }

    public Where2GoModel getModel() {
        return this.f50047a;
    }

    public void omegaTrack(String str) {
        if (str.equals(WHERE_TO_GO_CK)) {
            HashMap hashMap = new HashMap();
            JsonObject jsonObject = this.f50048b;
            if (jsonObject != null && jsonObject.has("log_data") && this.f50048b.get("log_data").isJsonObject()) {
                JsonObject asJsonObject = this.f50048b.get("log_data").getAsJsonObject();
                for (String next : asJsonObject.keySet()) {
                    try {
                        hashMap.put(next, asJsonObject.get(next));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            OmegaSDKAdapter.trackEvent("ibt_gp_whereto_ck", (Map<String, Object>) hashMap);
        }
    }
}
