package com.didiglobal.xengine.data.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR6\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR6\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR6\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006#"}, mo175978d2 = {"Lcom/didiglobal/xengine/data/model/XEDataGsonModel;", "Ljava/io/Serializable;", "()V", "value", "", "action", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "", "action_modules", "getAction_modules", "()Ljava/util/List;", "setAction_modules", "(Ljava/util/List;)V", "action_url", "getAction_url", "setAction_url", "available_scenes", "getAvailable_scenes", "setAvailable_scenes", "current_scene_modules", "getCurrent_scene_modules", "setCurrent_scene_modules", "filter", "Lcom/google/gson/JsonArray;", "getFilter", "()Lcom/google/gson/JsonArray;", "setFilter", "(Lcom/google/gson/JsonArray;)V", "next_action", "getNext_action", "setNext_action", "Companion", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEDataGsonModel.kt */
public final class XEDataGsonModel implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private String action;
    private List<String> action_modules;
    private String action_url;
    private List<String> available_scenes;
    private List<String> current_scene_modules;
    private JsonArray filter;
    private String next_action;

    public final List<String> getCurrent_scene_modules() {
        return this.current_scene_modules;
    }

    public final void setCurrent_scene_modules(List<String> list) {
        this.current_scene_modules = list;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    public final String getAction_url() {
        return this.action_url;
    }

    public final void setAction_url(String str) {
        this.action_url = str;
    }

    public final List<String> getAction_modules() {
        return this.action_modules;
    }

    public final void setAction_modules(List<String> list) {
        this.action_modules = list;
    }

    public final String getNext_action() {
        return this.next_action;
    }

    public final void setNext_action(String str) {
        this.next_action = str;
    }

    public final List<String> getAvailable_scenes() {
        return this.available_scenes;
    }

    public final void setAvailable_scenes(List<String> list) {
        this.available_scenes = list;
    }

    public final JsonArray getFilter() {
        return this.filter;
    }

    public final void setFilter(JsonArray jsonArray) {
        this.filter = jsonArray;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/xengine/data/model/XEDataGsonModel$Companion;", "", "()V", "parse", "Lcom/didiglobal/xengine/data/model/XEDataGsonModel;", "jsonObject", "Lcom/google/gson/JsonObject;", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEDataGsonModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final XEDataGsonModel parse(JsonObject jsonObject) {
            JsonObject asJsonObject;
            JsonArray jsonArray = null;
            if (jsonObject == null || (asJsonObject = jsonObject.getAsJsonObject("data")) == null) {
                return null;
            }
            XEDataGsonModel xEDataGsonModel = (XEDataGsonModel) new Gson().fromJson((JsonElement) asJsonObject, XEDataGsonModel.class);
            if (asJsonObject.get("available_filter_list") != null) {
                JsonElement jsonElement = asJsonObject.get("available_filter_list");
                Intrinsics.checkExpressionValueIsNotNull(jsonElement, "jObj.get(\"available_filter_list\")");
                jsonArray = jsonElement.getAsJsonArray();
            }
            xEDataGsonModel.setFilter(jsonArray);
            return xEDataGsonModel;
        }
    }
}
