package com.didiglobal.enginecore;

import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.google.gson.JsonArray;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XEngineDataHandleCallback;", "", "isFiltered", "", "filter", "Lcom/google/gson/JsonArray;", "onDataHandle", "", "model", "Lcom/didiglobal/enginecore/data/model/XEDataHandleModel;", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEngineDataHandleCallback.kt */
public interface XEngineDataHandleCallback {
    boolean isFiltered(JsonArray jsonArray);

    void onDataHandle(XEDataHandleModel xEDataHandleModel);
}
