package com.didiglobal.p205sa.biz.component.drainageguide;

import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.guide.IGuide;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.didiglobal.p205sa.biz.util.GsonUtils;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideCardPresenter */
public class SADrainageGuideCardPresenter extends ComponentPresenterImpl<SADrainageGuideCardView> implements IGuide {

    /* renamed from: a */
    private boolean f50887a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SADrainageModel f50888b;

    /* renamed from: c */
    private XEResponseCallback f50889c = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            SystemUtils.log(6, "tagtagtag", "GuidCardPresenter onSuccess ", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideCardPresenter$1", 50);
            try {
                JsonObject jsonObject = xEngineData.jsonObject;
                if (jsonObject != null) {
                    SADrainageModel unused = SADrainageGuideCardPresenter.this.f50888b = (SADrainageModel) GsonUtils.fromJson(jsonObject.getAsJsonObject("data").toString(), SADrainageModel.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            SystemUtils.log(6, "tagtagtag", "GuidCardPresenter onFailed ", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideCardPresenter$1", 65);
        }
    };

    /* renamed from: d */
    private XEReqJSONParamsCallbackImpl f50890d = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            SADrainageParam sADrainageParam = new SADrainageParam();
            sADrainageParam.setScene("home");
            hashMap.put(ComponentType.COMPONENT_DRAINAGE_GUIDE, sADrainageParam);
            return new JSONObject(hashMap);
        }
    };

    public SADrainageGuideCardPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f50887a = false;
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_DRAINAGE_GUIDE, "sa_home", this.f50889c);
        xERegisterModel.requestParams = this.f50890d;
        XERegister.registerTemplate(xERegisterModel);
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMPONENT_DRAINAGE_GUIDE);
    }

    public void showGuid(Context context, RecyclerView recyclerView, List<SACardProperty> list) {
        if (!this.f50887a && this.f50888b != null && SuperAppBusinessManager.INSTANCE.isSaRealShow()) {
            this.f50887a = true;
            new SADrainageGuider(context, recyclerView, list, this.f50888b).showGuides();
        }
    }
}
