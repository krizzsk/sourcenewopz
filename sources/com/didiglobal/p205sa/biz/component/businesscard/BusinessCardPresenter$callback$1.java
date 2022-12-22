package com.didiglobal.p205sa.biz.component.businesscard;

import com.compatible.old.topbar.PriConfManager;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.misconfig.p153v2.model.PriConfModel;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineLoggerUtils;
import com.didiglobal.p205sa.biz.util.GsonUtils;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didiglobal/sa/biz/component/businesscard/BusinessCardPresenter$callback$1", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "onFailed", "", "scene", "", "e", "Lcom/didiglobal/enginecore/data/exception/EngineErrorException;", "onSuccess", "data", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.businesscard.BusinessCardPresenter$callback$1 */
/* compiled from: BusinessCardPresenter.kt */
public final class BusinessCardPresenter$callback$1 implements XEResponseCallback {
    final /* synthetic */ BusinessCardPresenter this$0;

    BusinessCardPresenter$callback$1(BusinessCardPresenter businessCardPresenter) {
        this.this$0 = businessCardPresenter;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<? extends XEComponent> list) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(xEngineData, "data");
        Intrinsics.checkNotNullParameter(list, "list");
        try {
            SAXEngineLoggerUtils.INSTANCE.info("BusinessCard onSuccess");
            SAXEngineLoggerUtils.INSTANCE.info(Intrinsics.stringPlus("BusinessCard data ", xEngineData));
            BusinessCardPresenter businessCardPresenter = this.this$0;
            businessCardPresenter.m36471a(xEngineData.traceId + " json = " + xEngineData.jsonObject);
            if (xEngineData.jsonObject != null && xEngineData.jsonObject.has("normal") && xEngineData.jsonObject.get("normal").getAsJsonObject().has("data")) {
                JsonObject asJsonObject = xEngineData.jsonObject.get("normal").getAsJsonObject().get("data").getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(asJsonObject, "data.jsonObject.get(\"nor….get(\"data\").asJsonObject");
                BusinessCardModel businessCardModel = (BusinessCardModel) GsonUtils.fromJson(asJsonObject.toString(), BusinessCardModel.class);
                PriConfManager priConfManager = PriConfManager.INSTANCE;
                PriConfModel priConfModel = null;
                if (businessCardModel != null) {
                    PriConfModel priConfModel2 = businessCardModel.primaryMenu;
                    if (priConfModel2 != null) {
                        priConfModel = priConfModel2;
                    }
                }
                priConfManager.handResponse(priConfModel);
                SuperAppBusinessManager.INSTANCE.update();
                ((BusinessCardView) this.this$0.mView).setDate(businessCardModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(engineErrorException, "e");
        engineErrorException.printStackTrace();
    }
}
