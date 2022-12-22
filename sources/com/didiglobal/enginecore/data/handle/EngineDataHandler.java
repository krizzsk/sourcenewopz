package com.didiglobal.enginecore.data.handle;

import android.text.TextUtils;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.didiglobal.enginecore.utils.EngineDataHandleUtil;
import com.didiglobal.xengine.data.model.XEDataGsonModel;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/enginecore/data/handle/EngineDataHandler;", "", "()V", "dataHandle", "Lcom/google/gson/JsonObject;", "theData", "scene", "", "dataHandleCallback", "Lcom/didiglobal/enginecore/XEngineDataHandleCallback;", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: EngineDataHandler.kt */
public final class EngineDataHandler {
    public static final EngineDataHandler INSTANCE = new EngineDataHandler();

    private EngineDataHandler() {
    }

    public final JsonObject dataHandle(JsonObject jsonObject, String str, XEngineDataHandleCallback xEngineDataHandleCallback) {
        XEDataGsonModel parse;
        Intrinsics.checkParameterIsNotNull(jsonObject, "theData");
        if (!jsonObject.has(XENetConstant.XE_KEY_ENGINE_DATA_HANDLER) || (parse = XEDataGsonModel.Companion.parse(jsonObject.getAsJsonObject(XENetConstant.XE_KEY_ENGINE_DATA_HANDLER))) == null) {
            return jsonObject;
        }
        if (TextUtils.equals(parse.getAction(), XENetConstant.DataHandlerAction.ACTION_INTERCEPT)) {
            XEDataHandleModel createDataModel = XEDataHandleModel.Companion.createDataModel(parse, jsonObject, str, XENetConstant.DataHandlerAction.ACTION_INTERCEPT);
            if (xEngineDataHandleCallback != null) {
                xEngineDataHandleCallback.onDataHandle(createDataModel);
            }
            JsonObject reconstructOriginData = EngineDataHandleUtil.reconstructOriginData(parse.getCurrent_scene_modules(), jsonObject);
            Intrinsics.checkExpressionValueIsNotNull(reconstructOriginData, "EngineDataHandleUtil.rec…rent_scene_modules, data)");
            return reconstructOriginData;
        } else if (!TextUtils.equals(parse.getAction(), XENetConstant.DataHandlerAction.ACTION_DISPATCH)) {
            return jsonObject;
        } else {
            XEDataHandleModel createDataModel2 = XEDataHandleModel.Companion.createDataModel(parse, jsonObject, str, XENetConstant.DataHandlerAction.ACTION_DISPATCH);
            if (xEngineDataHandleCallback != null) {
                xEngineDataHandleCallback.onDataHandle(createDataModel2);
                if (xEngineDataHandleCallback.isFiltered(createDataModel2.getFilter())) {
                    return jsonObject;
                }
            }
            return null;
        }
    }
}
