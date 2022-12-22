package com.didi.lockscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.IPresenter;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.framework.template.common.CommonTemplatePresenter;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.template.nat.NativeComponent;
import java.util.List;

public class LockScreenTemplatePresenter extends CommonTemplatePresenter {

    /* renamed from: a */
    private XEResponseCallback f24396a = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                int i = order.status;
                int i2 = order.substatus;
                if (i != 4 || (i2 != 4001 && i2 != 4002 && i2 != 4003 && i2 != 4004 && i2 != 4005)) {
                    LockScreenTemplatePresenter.this.doPublish(BaseEventKeys.LockScreen.EVENT_ACTIVITY_CLOSE);
                } else if (list != null && list.size() != 0) {
                    for (XEComponent next : list) {
                        if ((next instanceof NativeComponent) && TextUtils.equals(((NativeComponent) next).getId(), "new_driver_bar")) {
                            DriverBarV2Model driverBarV2Model = new DriverBarV2Model();
                            driverBarV2Model.parse(next.getData());
                            LockScreenTemplatePresenter.this.doPublish(BaseEventKeys.LockScreen.EVENT_REFRESH_DRIVER_BAR, driverBarV2Model);
                        }
                    }
                }
            }
        }
    };

    public LockScreenTemplatePresenter(Context context, Bundle bundle) {
        super(context, bundle);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerCallback(XERequestKey.REQUEST_KEY_XPANEL, this.f24396a);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterCallback(XERequestKey.REQUEST_KEY_XPANEL, this.f24396a);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        return super.onBackPressed(backType);
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        super.registerListener();
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        super.unregisterListener();
    }
}
