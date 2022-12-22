package com.didi.soda.blocks.entity;

import com.google.gson.JsonElement;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/blocks/entity/Template;", "Ljava/io/Serializable;", "()V", "componentsTree", "Lcom/google/gson/JsonElement;", "getComponentsTree", "()Lcom/google/gson/JsonElement;", "setComponentsTree", "(Lcom/google/gson/JsonElement;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "peer", "Lcom/didi/soda/blocks/entity/PeerEntity;", "getPeer", "()Lcom/didi/soda/blocks/entity/PeerEntity;", "setPeer", "(Lcom/didi/soda/blocks/entity/PeerEntity;)V", "templateId", "getTemplateId", "setTemplateId", "tmplId", "getTmplId", "setTmplId", "version", "getVersion", "setVersion", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TemplatesEntity.kt */
public final class Template implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 3935712433555645405L;
    private JsonElement componentsTree;
    private String content;
    private PeerEntity peer;
    private String templateId;
    private String tmplId;
    private String version = "1";

    public final String getTmplId() {
        return this.tmplId;
    }

    public final void setTmplId(String str) {
        this.tmplId = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.version = str;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }

    public final JsonElement getComponentsTree() {
        return this.componentsTree;
    }

    public final void setComponentsTree(JsonElement jsonElement) {
        this.componentsTree = jsonElement;
    }

    public final PeerEntity getPeer() {
        return this.peer;
    }

    public final void setPeer(PeerEntity peerEntity) {
        this.peer = peerEntity;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/entity/Template$Companion;", "", "()V", "serialVersionUID", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TemplatesEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
