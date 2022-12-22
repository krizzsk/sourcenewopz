package com.didi.component.savingcenter;

import android.text.TextUtils;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/component/savingcenter/HomeSavingCenterPresenter$mXELogicCallback$1", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "onFailed", "", "scene", "", "e", "Lcom/didiglobal/enginecore/data/exception/EngineErrorException;", "onSuccess", "engineData", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "comp-savingcenter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeSavingCenterPresenter.kt */
public final class HomeSavingCenterPresenter$mXELogicCallback$1 implements XEResponseCallback {
    final /* synthetic */ HomeSavingCenterPresenter this$0;

    HomeSavingCenterPresenter$mXELogicCallback$1(HomeSavingCenterPresenter homeSavingCenterPresenter) {
        this.this$0 = homeSavingCenterPresenter;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        Intrinsics.checkNotNullParameter(xEngineData, "engineData");
        try {
            JsonObject jsonObject = xEngineData.jsonObject;
            if (jsonObject == null) {
                ((ISavingCenterView) this.this$0.mView).setVisible(false);
                return;
            }
            JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
            boolean z = true;
            if (Intrinsics.areEqual((Object) asJsonObject == null ? null : Boolean.valueOf(asJsonObject.has("deeplink")), (Object) true)) {
                String asString = jsonObject.getAsJsonObject("data").get("deeplink").getAsString();
                ISavingCenterView iSavingCenterView = (ISavingCenterView) this.this$0.mView;
                if (TextUtils.isEmpty(asString)) {
                    z = false;
                }
                Intrinsics.checkNotNullExpressionValue(asString, SDKConstants.PARAM_DEEP_LINK);
                iSavingCenterView.setScanVisible(z, asString);
                return;
            }
            this.this$0.setInfo(((SavingCenterInfoData) new Gson().fromJson((JsonElement) jsonObject, SavingCenterInfoData.class)).getScInfo());
        } catch (Exception e) {
            e.printStackTrace();
            ISavingCenterView iSavingCenterView2 = (ISavingCenterView) this.this$0.mView;
            if (iSavingCenterView2 != null) {
                iSavingCenterView2.setVisible(false);
            }
        }
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        ((ISavingCenterView) this.this$0.mView).setVisible(false);
    }
}
