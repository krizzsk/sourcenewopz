package com.didiglobal.enginecore.data.parser.model;

import com.android.didi.bfflib.BffExtra;
import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.XEngineCommitCallback;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\n\u0012\u0004\u0012\u00020*\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006;"}, mo175978d2 = {"Lcom/didiglobal/enginecore/data/parser/model/EngineParseModel;", "", "()V", "callback", "Lcom/didiglobal/enginecore/XEngineCallback;", "getCallback", "()Lcom/didiglobal/enginecore/XEngineCallback;", "setCallback", "(Lcom/didiglobal/enginecore/XEngineCallback;)V", "commitCallback", "Lcom/didiglobal/enginecore/XEngineCommitCallback;", "getCommitCallback", "()Lcom/didiglobal/enginecore/XEngineCommitCallback;", "setCommitCallback", "(Lcom/didiglobal/enginecore/XEngineCommitCallback;)V", "data", "Lcom/google/gson/JsonObject;", "getData", "()Lcom/google/gson/JsonObject;", "setData", "(Lcom/google/gson/JsonObject;)V", "dataHandleCallback", "Lcom/didiglobal/enginecore/XEngineDataHandleCallback;", "getDataHandleCallback", "()Lcom/didiglobal/enginecore/XEngineDataHandleCallback;", "setDataHandleCallback", "(Lcom/didiglobal/enginecore/XEngineDataHandleCallback;)V", "extra", "Lcom/android/didi/bfflib/BffExtra;", "getExtra", "()Lcom/android/didi/bfflib/BffExtra;", "setExtra", "(Lcom/android/didi/bfflib/BffExtra;)V", "isCache", "", "()Z", "setCache", "(Z)V", "isSimpleRequest", "setSimpleRequest", "requireSet", "", "", "getRequireSet", "()Ljava/util/Set;", "setRequireSet", "(Ljava/util/Set;)V", "scene", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "templateKeyList", "", "getTemplateKeyList", "()Ljava/util/List;", "setTemplateKeyList", "(Ljava/util/List;)V", "Companion", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: EngineParseModel.kt */
public final class EngineParseModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f50169a;

    /* renamed from: b */
    private List<String> f50170b;

    /* renamed from: c */
    private Set<String> f50171c;

    /* renamed from: d */
    private JsonObject f50172d;

    /* renamed from: e */
    private XEngineCallback f50173e;

    /* renamed from: f */
    private XEngineCommitCallback f50174f;

    /* renamed from: g */
    private BffExtra f50175g;

    /* renamed from: h */
    private XEngineDataHandleCallback f50176h;

    /* renamed from: i */
    private boolean f50177i;

    /* renamed from: j */
    private boolean f50178j;

    public final String getScene() {
        return this.f50169a;
    }

    public final void setScene(String str) {
        this.f50169a = str;
    }

    public final List<String> getTemplateKeyList() {
        return this.f50170b;
    }

    public final void setTemplateKeyList(List<String> list) {
        this.f50170b = list;
    }

    public final Set<String> getRequireSet() {
        return this.f50171c;
    }

    public final void setRequireSet(Set<String> set) {
        this.f50171c = set;
    }

    public final JsonObject getData() {
        return this.f50172d;
    }

    public final void setData(JsonObject jsonObject) {
        this.f50172d = jsonObject;
    }

    public final XEngineCallback getCallback() {
        return this.f50173e;
    }

    public final void setCallback(XEngineCallback xEngineCallback) {
        this.f50173e = xEngineCallback;
    }

    public final XEngineCommitCallback getCommitCallback() {
        return this.f50174f;
    }

    public final void setCommitCallback(XEngineCommitCallback xEngineCommitCallback) {
        this.f50174f = xEngineCommitCallback;
    }

    public final BffExtra getExtra() {
        return this.f50175g;
    }

    public final void setExtra(BffExtra bffExtra) {
        this.f50175g = bffExtra;
    }

    public final XEngineDataHandleCallback getDataHandleCallback() {
        return this.f50176h;
    }

    public final void setDataHandleCallback(XEngineDataHandleCallback xEngineDataHandleCallback) {
        this.f50176h = xEngineDataHandleCallback;
    }

    public final boolean isCache() {
        return this.f50177i;
    }

    public final void setCache(boolean z) {
        this.f50177i = z;
    }

    public final boolean isSimpleRequest() {
        return this.f50178j;
    }

    public final void setSimpleRequest(boolean z) {
        this.f50178j = z;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JX\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012Jb\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/enginecore/data/parser/model/EngineParseModel$Companion;", "", "()V", "createDataHandleModel", "Lcom/didiglobal/enginecore/data/parser/model/EngineParseModel;", "scene", "", "theData", "Lcom/google/gson/JsonObject;", "list", "", "requiredSet", "", "callback", "Lcom/didiglobal/enginecore/XEngineCallback;", "commitCallback", "Lcom/didiglobal/enginecore/XEngineCommitCallback;", "extra", "Lcom/android/didi/bfflib/BffExtra;", "createParseModel", "templateKeyList", "data", "dataHandleCallback", "Lcom/didiglobal/enginecore/XEngineDataHandleCallback;", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: EngineParseModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EngineParseModel createParseModel(String str, List<String> list, Set<String> set, JsonObject jsonObject, XEngineCallback xEngineCallback, XEngineCommitCallback xEngineCommitCallback, BffExtra bffExtra, XEngineDataHandleCallback xEngineDataHandleCallback) {
            EngineParseModel engineParseModel = new EngineParseModel();
            engineParseModel.setScene(str);
            engineParseModel.setTemplateKeyList(list);
            engineParseModel.setRequireSet(set);
            engineParseModel.setData(jsonObject);
            engineParseModel.setCallback(xEngineCallback);
            engineParseModel.setCommitCallback(xEngineCommitCallback);
            engineParseModel.setDataHandleCallback(xEngineDataHandleCallback);
            engineParseModel.setExtra(bffExtra);
            return engineParseModel;
        }

        public final EngineParseModel createDataHandleModel(String str, JsonObject jsonObject, List<String> list, Set<String> set, XEngineCallback xEngineCallback, XEngineCommitCallback xEngineCommitCallback, BffExtra bffExtra) {
            EngineParseModel engineParseModel = new EngineParseModel();
            engineParseModel.setScene(str);
            engineParseModel.setTemplateKeyList(list);
            engineParseModel.setRequireSet(set);
            engineParseModel.setData(jsonObject);
            engineParseModel.setCallback(xEngineCallback);
            engineParseModel.setCommitCallback(xEngineCommitCallback);
            engineParseModel.setExtra(bffExtra);
            return engineParseModel;
        }
    }
}
