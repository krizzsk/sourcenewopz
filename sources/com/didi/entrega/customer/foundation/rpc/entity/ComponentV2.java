package com.didi.entrega.customer.foundation.rpc.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "tmplId", "", "getTmplId", "()Ljava/lang/String;", "setTmplId", "(Ljava/lang/String;)V", "tmplTag", "getTmplTag", "setTmplTag", "tmplType", "", "getTmplType", "()Ljava/lang/Integer;", "setTmplType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ComponentV2.kt */
public final class ComponentV2 implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6366596296564676625L;
    @SerializedName("tmplId")
    private String tmplId;
    @SerializedName("tmplTag")
    private String tmplTag;
    @SerializedName("tmplType")
    private Integer tmplType;

    public final String getTmplId() {
        return this.tmplId;
    }

    public final void setTmplId(String str) {
        this.tmplId = str;
    }

    public final String getTmplTag() {
        return this.tmplTag;
    }

    public final void setTmplTag(String str) {
        this.tmplTag = str;
    }

    public final Integer getTmplType() {
        return this.tmplType;
    }

    public final void setTmplType(Integer num) {
        this.tmplType = num;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/ComponentV2$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ComponentV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
