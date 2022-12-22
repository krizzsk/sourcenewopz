package com.didi.component.comp_flex.option;

import android.os.Bundle;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.common.common.xengine.XEngineRegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;

public class FlexOptionPresenter extends IPresenter<AbsFlexOptionView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f12198a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private XEResponseCallback f12199b = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null && xEngineData.jsonObject != null) {
                JsonObject jsonObject = xEngineData.jsonObject;
                Logger a = FlexOptionPresenter.this.f12198a;
                a.info("onSuccess:FlexOptionPresenter " + jsonObject, new Object[0]);
                if (jsonObject.has("data")) {
                    JsonObject asJsonObject = jsonObject.get("data").getAsJsonObject();
                    ((AbsFlexOptionView) FlexOptionPresenter.this.mView).setOperationPanelModel((OperationPanelModel) new Gson().fromJson(asJsonObject.toString(), OperationPanelModel.class));
                }
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            FlexOptionPresenter.this.f12198a.info("onFailed: FlexOptionPresenter ", new Object[0]);
        }
    };

    public FlexOptionPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XEngineRegister.register(m8256b());
    }

    /* renamed from: b */
    private XERegisterModel m8256b() {
        return new XERegisterModel(XERequestKey.REQUEST_KEY_FLEX_OPERATION_PANEL, XERequestKey.SCENE_TRIP, this.f12199b);
    }

    public void onRemove() {
        super.onRemove();
        ((AbsFlexOptionView) this.mView).onDestroy();
        XEngineRegister.unregister(XERequestKey.REQUEST_KEY_FLEX_OPERATION_PANEL);
    }
}
