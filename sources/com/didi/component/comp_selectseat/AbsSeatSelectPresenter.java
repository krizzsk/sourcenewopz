package com.didi.component.comp_selectseat;

import android.os.Bundle;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.IPresenter;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract class AbsSeatSelectPresenter extends IPresenter<AbsSeatSelectView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f12376a = getClass().getSimpleName();

    /* renamed from: b */
    private XEReqJSONParamsCallbackImpl f12377b = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            return new JSONObject(new HashMap());
        }
    };
    protected BusinessContext mBizCtx;
    protected XEResponseCallback mXELogicCallbackSelectSeat = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                String a = AbsSeatSelectPresenter.this.f12376a;
                LogUtils.m31493i(a, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
                AbsSeatSelectPresenter.this.onSuccess(xEngineData.jsonObject);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String a = AbsSeatSelectPresenter.this.f12376a;
            LogUtils.m31493i(a, "onFailed:e = " + engineErrorException);
            AbsSeatSelectPresenter.this.onFail(engineErrorException);
        }
    };

    /* access modifiers changed from: protected */
    public void onFail(Exception exc) {
    }

    public AbsSeatSelectPresenter(BusinessContext businessContext) {
        super(businessContext.getContext());
        this.mBizCtx = businessContext;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerTemplate(new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_SELECT_SEAT, XERequestKey.SCENE_ESTIMATE, this.mXELogicCallbackSelectSeat));
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterCallback(XERequestKey.SingleCompRefresh.REQUEST_KEY_SELECT_SEAT, this.mXELogicCallbackSelectSeat);
    }

    /* access modifiers changed from: protected */
    public void onSuccess(JsonObject jsonObject) {
        if (getHost() != null && getHost().getActivity() != null && jsonObject != null) {
            FormStore.getInstance().setSelectedSeat(jsonObject.toString());
        }
    }
}
