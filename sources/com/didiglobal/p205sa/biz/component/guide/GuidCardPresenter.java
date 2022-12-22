package com.didiglobal.p205sa.biz.component.guide;

import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.guide.view.Guider;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.didiglobal.p205sa.biz.util.GsonUtils;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.didiglobal.sa.biz.component.guide.GuidCardPresenter */
public class GuidCardPresenter extends ComponentPresenterImpl<GuideCardView> implements IGuide {
    public static final String key = "guide_shown";
    public static final String name = "sa_guider";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GuideTipModel f50932a;

    /* renamed from: b */
    private XEResponseCallback f50933b = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            JsonObject asJsonObject;
            SystemUtils.log(6, "tagtagtag", "GuidCardPresenter onSuccess ", (Throwable) null, "com.didiglobal.sa.biz.component.guide.GuidCardPresenter$1", 53);
            try {
                JsonObject jsonObject = xEngineData.jsonObject;
                if (jsonObject != null && (asJsonObject = jsonObject.getAsJsonObject("normal")) != null) {
                    GuideTipModel unused = GuidCardPresenter.this.f50932a = (GuideTipModel) GsonUtils.fromJson(asJsonObject.getAsJsonObject("data").toString(), GuideTipModel.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            SystemUtils.log(6, "tagtagtag", "GuidCardPresenter onFailed ", (Throwable) null, "com.didiglobal.sa.biz.component.guide.GuidCardPresenter$1", 71);
        }
    };

    /* renamed from: c */
    private XEReqJSONParamsCallbackImpl f50934c = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            GuidCardPresenter guidCardPresenter = GuidCardPresenter.this;
            hashMap.put("sa_guide_show", Integer.valueOf(guidCardPresenter.m36511a(guidCardPresenter.mContext) ? 1 : 0));
            hashMap.put("is_sa_tab", Integer.valueOf(SaApolloUtil.INSTANCE.getSaOneState() ? 1 : 0));
            return new JSONObject(hashMap);
        }
    };

    public GuidCardPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_SA_GUIDE, "sa_home", this.f50933b);
        xERegisterModel.requestParams = this.f50934c;
        XERegister.registerTemplate(xERegisterModel);
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMPONENT_SA_GUIDE);
    }

    public void showGuid(Context context, RecyclerView recyclerView, List<SACardProperty> list) {
        m36513b(context);
        if (this.f50932a != null && SuperAppBusinessManager.INSTANCE.isSaRealShow()) {
            new Guider(context, recyclerView, list, this.f50932a).showGuides();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m36511a(Context context) {
        return SystemUtils.getSharedPreferences(context, "sa_guider", 0).getBoolean(key, false);
    }

    /* renamed from: b */
    private void m36513b(Context context) {
        SystemUtils.getSharedPreferences(context, "sa_guider", 0).edit().putBoolean(key, true).commit();
    }
}
