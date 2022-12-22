package com.didi.component.comp_travel_detail_new;

import android.os.Bundle;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.comp_travel_detail_new.view.widget.TravelDetailNewModel;
import com.didi.component.core.IPresenter;
import com.didi.sdk.app.BusinessContext;
import com.google.gson.Gson;
import java.util.Collection;
import org.json.JSONObject;

public abstract class AbsTravelDetailNewPresenter extends IPresenter<AbsTravelDetailNewView> implements XpNewAdapter {

    /* renamed from: a */
    private final String f12499a = getClass().getSimpleName();
    protected BusinessContext mBizCtx;

    public AbsTravelDetailNewPresenter(BusinessContext businessContext) {
        super(businessContext.getContext());
        this.mBizCtx = businessContext;
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (jSONObject == null) {
            iXpCardBindDataReadyCallback.ready(false);
            return;
        }
        TravelDetailNewModel travelDetailNewModel = (TravelDetailNewModel) new Gson().fromJson(jSONObject.toString(), TravelDetailNewModel.class);
        if (travelDetailNewModel == null || travelDetailNewModel.normal == null || travelDetailNewModel.normal.data == null || CollectionUtils.isEmpty((Collection) travelDetailNewModel.normal.data.addressData)) {
            iXpCardBindDataReadyCallback.ready(false);
            return;
        }
        ((AbsTravelDetailNewView) this.mView).bindData(travelDetailNewModel.normal.data.addressData);
        iXpCardBindDataReadyCallback.ready(true);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }
}
