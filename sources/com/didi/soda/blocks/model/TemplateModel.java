package com.didi.soda.blocks.model;

import com.didi.soda.blocks.entity.WidgetNodeEntity;
import com.didi.soda.blocks.parse.Peer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/blocks/model/TemplateModel;", "", "()V", "peer", "Lcom/didi/soda/blocks/parse/Peer;", "getPeer", "()Lcom/didi/soda/blocks/parse/Peer;", "setPeer", "(Lcom/didi/soda/blocks/parse/Peer;)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "templateInterface", "Lcom/didi/soda/blocks/entity/WidgetNodeEntity;", "getTemplateInterface", "()Lcom/didi/soda/blocks/entity/WidgetNodeEntity;", "setTemplateInterface", "(Lcom/didi/soda/blocks/entity/WidgetNodeEntity;)V", "templateVersion", "getTemplateVersion", "setTemplateVersion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TemplateModel.kt */
public final class TemplateModel {
    private Peer peer;
    private String templateId = "";
    private WidgetNodeEntity templateInterface;
    private String templateVersion = "1";

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.templateId = str;
    }

    public final String getTemplateVersion() {
        return this.templateVersion;
    }

    public final void setTemplateVersion(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.templateVersion = str;
    }

    public final WidgetNodeEntity getTemplateInterface() {
        return this.templateInterface;
    }

    public final void setTemplateInterface(WidgetNodeEntity widgetNodeEntity) {
        this.templateInterface = widgetNodeEntity;
    }

    public final Peer getPeer() {
        return this.peer;
    }

    public final void setPeer(Peer peer2) {
        this.peer = peer2;
    }
}
