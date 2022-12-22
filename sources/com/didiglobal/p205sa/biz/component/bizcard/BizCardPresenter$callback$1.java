package com.didiglobal.p205sa.biz.component.bizcard;

import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.p205sa.biz.component.bizcard.model.BizCardModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didiglobal/sa/biz/component/bizcard/BizCardPresenter$callback$1", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "onFailed", "", "scene", "", "e", "Lcom/didiglobal/enginecore/data/exception/EngineErrorException;", "onSuccess", "data", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "list", "", "Lcom/didiglobal/enginecore/component/XEComponent;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardPresenter$callback$1 */
/* compiled from: BizCardPresenter.kt */
public final class BizCardPresenter$callback$1 implements XEResponseCallback {
    final /* synthetic */ BizCardPresenter this$0;

    BizCardPresenter$callback$1(BizCardPresenter bizCardPresenter) {
        this.this$0 = bizCardPresenter;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<? extends XEComponent> list) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(xEngineData, "data");
        Intrinsics.checkNotNullParameter(list, "list");
        this.this$0.f50801a.debug("dispatch BizCardPresenter presenter success", new Object[0]);
        try {
            ArrayList arrayList = new ArrayList();
            JsonObject jsonObject = xEngineData.jsonObject;
            if (jsonObject != null) {
                JsonElement jsonElement = jsonObject.get("list");
                if (jsonElement != null) {
                    JsonArray<JsonElement> asJsonArray = jsonElement.getAsJsonArray();
                    if (asJsonArray != null) {
                        for (JsonElement jsonElement2 : asJsonArray) {
                            if (jsonElement2 != null) {
                                JsonObject asJsonObject = jsonElement2.getAsJsonObject();
                                if (asJsonObject != null) {
                                    JsonElement jsonElement3 = asJsonObject.get("normal");
                                    if (jsonElement3 != null) {
                                        JsonObject asJsonObject2 = jsonElement3.getAsJsonObject();
                                        if (asJsonObject2 != null) {
                                            JsonElement jsonElement4 = asJsonObject2.get("data");
                                            if (jsonElement4 != null) {
                                                JsonObject asJsonObject3 = jsonElement4.getAsJsonObject();
                                                if (asJsonObject3 != null) {
                                                    arrayList.add((BizCardModel) new Gson().fromJson((JsonElement) asJsonObject3, BizCardModel.class));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!list.isEmpty()) {
                BizCardView bizCardView = (BizCardView) this.this$0.mView;
                if (bizCardView != null) {
                    bizCardView.refreshData(list, arrayList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(engineErrorException, "e");
        this.this$0.f50801a.debug("dispatch BizCardPresenter presenter failed", new Object[0]);
        engineErrorException.printStackTrace();
    }
}
