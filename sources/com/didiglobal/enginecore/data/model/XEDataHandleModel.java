package com.didiglobal.enginecore.data.model;

import com.didiglobal.xengine.data.model.XEDataGsonModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006%"}, mo175978d2 = {"Lcom/didiglobal/enginecore/data/model/XEDataHandleModel;", "Ljava/io/Serializable;", "()V", "actionModules", "", "", "getActionModules", "()Ljava/util/List;", "setActionModules", "(Ljava/util/List;)V", "actionUrl", "getActionUrl", "()Ljava/lang/String;", "setActionUrl", "(Ljava/lang/String;)V", "filter", "Lcom/google/gson/JsonArray;", "getFilter", "()Lcom/google/gson/JsonArray;", "setFilter", "(Lcom/google/gson/JsonArray;)V", "handleType", "getHandleType", "setHandleType", "nextAction", "getNextAction", "setNextAction", "nextActionJsonObject", "Lcom/google/gson/JsonObject;", "getNextActionJsonObject", "()Lcom/google/gson/JsonObject;", "setNextActionJsonObject", "(Lcom/google/gson/JsonObject;)V", "scene", "getScene", "setScene", "Companion", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEDataHandleModel.kt */
public final class XEDataHandleModel implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private List<String> actionModules;
    private String actionUrl;
    private JsonArray filter;
    private String handleType = "";
    private String nextAction;
    private JsonObject nextActionJsonObject;
    private String scene;

    public final String getHandleType() {
        return this.handleType;
    }

    public final void setHandleType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.handleType = str;
    }

    public final JsonObject getNextActionJsonObject() {
        return this.nextActionJsonObject;
    }

    public final void setNextActionJsonObject(JsonObject jsonObject) {
        this.nextActionJsonObject = jsonObject;
    }

    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public final List<String> getActionModules() {
        return this.actionModules;
    }

    public final void setActionModules(List<String> list) {
        this.actionModules = list;
    }

    public final String getNextAction() {
        return this.nextAction;
    }

    public final void setNextAction(String str) {
        this.nextAction = str;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        this.scene = str;
    }

    public final JsonArray getFilter() {
        return this.filter;
    }

    public final void setFilter(JsonArray jsonArray) {
        this.filter = jsonArray;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nJ \u0010\f\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/enginecore/data/model/XEDataHandleModel$Companion;", "", "()V", "createDataModel", "Lcom/didiglobal/enginecore/data/model/XEDataHandleModel;", "dataGsonModel", "Lcom/didiglobal/xengine/data/model/XEDataGsonModel;", "theData", "Lcom/google/gson/JsonObject;", "scene", "", "handleType", "createNextActionJsonObject", "actionModules", "", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEDataHandleModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final XEDataHandleModel createDataModel(XEDataGsonModel xEDataGsonModel, JsonObject jsonObject, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(xEDataGsonModel, "dataGsonModel");
            Intrinsics.checkParameterIsNotNull(jsonObject, "theData");
            Intrinsics.checkParameterIsNotNull(str2, "handleType");
            XEDataHandleModel xEDataHandleModel = new XEDataHandleModel();
            xEDataHandleModel.setNextAction(xEDataGsonModel.getNext_action());
            xEDataHandleModel.setActionUrl(xEDataGsonModel.getAction_url());
            xEDataHandleModel.setActionModules(xEDataGsonModel.getAction_modules());
            xEDataHandleModel.setScene(str);
            xEDataHandleModel.setHandleType(str2);
            xEDataHandleModel.setFilter(xEDataGsonModel.getFilter());
            xEDataHandleModel.setNextActionJsonObject(createNextActionJsonObject(xEDataGsonModel.getAction_modules(), jsonObject));
            return xEDataHandleModel;
        }

        private final JsonObject createNextActionJsonObject(List<String> list, JsonObject jsonObject) {
            JsonObject jsonObject2 = new JsonObject();
            if (list != null && !list.isEmpty()) {
                for (String next : list) {
                    jsonObject.get(next);
                    jsonObject2.add(next, jsonObject.get(next));
                }
            }
            return jsonObject2;
        }
    }
}
