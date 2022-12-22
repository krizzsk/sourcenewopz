package com.didiglobal.eevee.comp.sug;

import com.didiglobal.eevee.comp.sug.model.EOpenSugModel;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.List;

class ESugPresenter$2 implements XEResponseCallback {
    final /* synthetic */ C16782a this$0;

    ESugPresenter$2(C16782a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        try {
            if (xEngineData.jsonObject != null && xEngineData.jsonObject.has("data")) {
                EOpenSugModel unused = this.this$0.f50069b = (EOpenSugModel) new Gson().fromJson((JsonElement) xEngineData.jsonObject.get("data").getAsJsonObject(), EOpenSugModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        engineErrorException.printStackTrace();
    }
}
