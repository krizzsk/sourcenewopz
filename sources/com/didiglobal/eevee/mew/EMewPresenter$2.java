package com.didiglobal.eevee.mew;

import com.didiglobal.common.common.model.EeveeRichText;
import com.didiglobal.eevee.mew.widget.VpTemplateModel;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.List;

class EMewPresenter$2 implements XEResponseCallback {
    final /* synthetic */ C16805a this$0;

    EMewPresenter$2(C16805a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        EeveeRichText eeveeRichText;
        int i;
        VpTemplateModel vpTemplateModel = (VpTemplateModel) new Gson().fromJson((JsonElement) xEngineData.jsonObject, VpTemplateModel.class);
        if (vpTemplateModel == null || vpTemplateModel.normal == null || vpTemplateModel.normal.data == null) {
            eeveeRichText = null;
            i = 0;
        } else {
            eeveeRichText = vpTemplateModel.normal.data.title;
            i = vpTemplateModel.normal.data.interval;
        }
        this.this$0.m36084a(list, eeveeRichText, i);
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        engineErrorException.printStackTrace();
    }
}
