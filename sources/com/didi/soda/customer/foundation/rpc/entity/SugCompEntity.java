package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/SugCompEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "componentV2", "Lcom/didi/soda/customer/foundation/rpc/entity/TemplateTagEntity;", "getComponentV2", "()Lcom/didi/soda/customer/foundation/rpc/entity/TemplateTagEntity;", "setComponentV2", "(Lcom/didi/soda/customer/foundation/rpc/entity/TemplateTagEntity;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "recId", "", "getRecId", "()Ljava/lang/String;", "setRecId", "(Ljava/lang/String;)V", "shop", "Lcom/didi/soda/customer/foundation/rpc/entity/SugBusinessEntity;", "getShop", "()Lcom/didi/soda/customer/foundation/rpc/entity/SugBusinessEntity;", "setShop", "(Lcom/didi/soda/customer/foundation/rpc/entity/SugBusinessEntity;)V", "traceId", "getTraceId", "setTraceId", "word", "getWord", "setWord", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SugCompEntity.kt */
public final class SugCompEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = -3755450266087567780L;
    private TemplateTagEntity componentV2;
    private int position;
    private String recId;
    private SugBusinessEntity shop;
    private String traceId;
    private String word;

    public final String getWord() {
        return this.word;
    }

    public final void setWord(String str) {
        this.word = str;
    }

    public final SugBusinessEntity getShop() {
        return this.shop;
    }

    public final void setShop(SugBusinessEntity sugBusinessEntity) {
        this.shop = sugBusinessEntity;
    }

    public final TemplateTagEntity getComponentV2() {
        return this.componentV2;
    }

    public final void setComponentV2(TemplateTagEntity templateTagEntity) {
        this.componentV2 = templateTagEntity;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final void setRecId(String str) {
        this.recId = str;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/SugCompEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SugCompEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
