package com.didi.soda.blocks.parse;

import com.appsflyer.internal.referrer.Payload;
import com.didi.soda.blocks.entity.PeerEntity;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010&\u001a\u00020\u0000J\u0010\u0010'\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010)R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR:\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000f¨\u0006+"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/Peer;", "", "()V", "businessConfig", "Lcom/google/gson/JsonObject;", "getBusinessConfig", "()Lcom/google/gson/JsonObject;", "setBusinessConfig", "(Lcom/google/gson/JsonObject;)V", "event", "", "", "getEvent", "()Ljava/util/Map;", "setEvent", "(Ljava/util/Map;)V", "global", "getGlobal", "setGlobal", "local", "getLocal", "setLocal", "logic", "getLogic", "setLogic", "scope", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getScope", "()Ljava/util/HashMap;", "setScope", "(Ljava/util/HashMap;)V", "store", "getStore", "setStore", "widget", "getWidget", "setWidget", "copy", "mergeWithPlatformConfig", "peerEntity", "Lcom/didi/soda/blocks/entity/PeerEntity;", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Peer.kt */
public final class Peer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> invariableKeyList = CollectionsKt.listOf(Payload.TYPE_STORE, "businessConfig", "widget", "logic", "event", "global", "local", "scope");
    private JsonObject businessConfig;
    private Map<String, String> event;

    /* renamed from: global  reason: collision with root package name */
    private JsonObject f61869global;
    private JsonObject local;
    private Map<String, String> logic;
    private HashMap<String, Object> scope;
    private JsonObject store;
    private Map<String, String> widget;

    public final JsonObject getStore() {
        return this.store;
    }

    public final void setStore(JsonObject jsonObject) {
        this.store = jsonObject;
    }

    public final JsonObject getBusinessConfig() {
        return this.businessConfig;
    }

    public final void setBusinessConfig(JsonObject jsonObject) {
        this.businessConfig = jsonObject;
    }

    public final Map<String, String> getWidget() {
        return this.widget;
    }

    public final void setWidget(Map<String, String> map) {
        this.widget = map;
    }

    public final Map<String, String> getLogic() {
        return this.logic;
    }

    public final void setLogic(Map<String, String> map) {
        this.logic = map;
    }

    public final Map<String, String> getEvent() {
        return this.event;
    }

    public final void setEvent(Map<String, String> map) {
        this.event = map;
    }

    public final JsonObject getGlobal() {
        return this.f61869global;
    }

    public final void setGlobal(JsonObject jsonObject) {
        this.f61869global = jsonObject;
    }

    public final JsonObject getLocal() {
        return this.local;
    }

    public final void setLocal(JsonObject jsonObject) {
        this.local = jsonObject;
    }

    public final HashMap<String, Object> getScope() {
        return this.scope;
    }

    public final void setScope(HashMap<String, Object> hashMap) {
        this.scope = hashMap;
    }

    public final Peer mergeWithPlatformConfig(PeerEntity peerEntity) {
        this.businessConfig = peerEntity != null ? peerEntity.getBusinessConfig() : null;
        return this;
    }

    public final Peer copy() {
        Peer peer = new Peer();
        peer.store = this.store;
        peer.widget = this.widget;
        peer.logic = this.logic;
        peer.event = this.event;
        peer.f61869global = this.f61869global;
        peer.local = this.local;
        peer.scope = this.scope;
        return peer;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/Peer$Companion;", "", "()V", "invariableKeyList", "", "", "getInvariableKeyList", "()Ljava/util/List;", "deepCopy", "Lcom/google/gson/JsonObject;", "fromPeer", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Peer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<String> getInvariableKeyList() {
            return Peer.invariableKeyList;
        }

        public final JsonObject deepCopy(JsonObject jsonObject) {
            Intrinsics.checkParameterIsNotNull(jsonObject, "fromPeer");
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry next : jsonObject.entrySet()) {
                String str = (String) next.getKey();
                JsonElement jsonElement = (JsonElement) next.getValue();
                if (Peer.Companion.getInvariableKeyList().contains(str)) {
                    jsonObject2.add(str, jsonElement);
                } else {
                    jsonObject2.add(str, jsonElement.deepCopy());
                }
            }
            return jsonObject2;
        }
    }
}
