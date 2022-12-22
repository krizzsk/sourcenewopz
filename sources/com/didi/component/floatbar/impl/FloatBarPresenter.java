package com.didi.component.floatbar.impl;

import android.os.Bundle;
import android.view.View;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.floatbar.AbsFloatBarPresenter;
import com.didi.component.floatbar.IFloatBarContainerView;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.xml.XMLComponent;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FloatBarPresenter extends AbsFloatBarPresenter<IFloatBarContainerView> {
    public static final String XE_COMPONENT_ID_FLOAT_BAR = "ride_float_bar";

    /* renamed from: a */
    private XEResponseCallback f13732a = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            FloatBarPresenter.this.m9487a(list);
        }
    };

    public void onFloatBarClicked() {
    }

    public FloatBarPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_FLOAT_BAR, XERequestKey.SCENE_TRIP, this.f13732a);
        xERegisterModel.requestParams = new XEReqParamsCallback() {
            public Object getRequestParams() {
                HashMap hashMap = new HashMap();
                CarOrder order = CarOrderHelper.getOrder();
                if (order != null) {
                    hashMap.put("oid", order.oid);
                }
                return hashMap;
            }
        };
        XERegister.registerTemplate(xERegisterModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9487a(List<XEComponent> list) {
        XEComponent xEComponent;
        if (!CollectionUtils.isEmpty((Collection) list) && (xEComponent = list.get(0)) != null && (xEComponent instanceof XMLComponent)) {
            String id = xEComponent.getId();
            View view = xEComponent.getView();
            if (XE_COMPONENT_ID_FLOAT_BAR.equals(id) && view != null) {
                ((IFloatBarContainerView) this.mView).setContentView(view);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_FLOAT_BAR);
    }
}
