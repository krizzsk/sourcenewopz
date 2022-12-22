package com.didi.soda.customer.coordshop;

import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopModel;", "", "()V", "isCollaboration", "", "()Z", "setCollaboration", "(Z)V", "sourcePosition", "", "getSourcePosition", "()I", "setSourcePosition", "(I)V", "synergySeq", "getSynergySeq", "setSynergySeq", "synergyShopId", "", "getSynergyShopId", "()Ljava/lang/String;", "setSynergyShopId", "(Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CoordShopDisplayInfo.kt */
public final class CoordShopModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private boolean f40844a;

    /* renamed from: b */
    private int f40845b;

    /* renamed from: c */
    private String f40846c = "";

    /* renamed from: d */
    private int f40847d;

    public final boolean isCollaboration() {
        return this.f40844a;
    }

    public final void setCollaboration(boolean z) {
        this.f40844a = z;
    }

    public final int getSourcePosition() {
        return this.f40845b;
    }

    public final void setSourcePosition(int i) {
        this.f40845b = i;
    }

    public final String getSynergyShopId() {
        return this.f40846c;
    }

    public final void setSynergyShopId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40846c = str;
    }

    public final int getSynergySeq() {
        return this.f40847d;
    }

    public final void setSynergySeq(int i) {
        this.f40847d = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopModel$Companion;", "", "()V", "create", "Lcom/didi/soda/customer/coordshop/CoordShopModel;", "collaborationInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/BusinessInfoEntity$CollaborationInfo;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CoordShopDisplayInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoordShopModel create(BusinessInfoEntity.CollaborationInfo collaborationInfo) {
            if (collaborationInfo == null || !collaborationInfo.isCollaboration) {
                return null;
            }
            CoordShopModel coordShopModel = new CoordShopModel();
            coordShopModel.setCollaboration(collaborationInfo.isCollaboration);
            coordShopModel.setSourcePosition(collaborationInfo.sourcePosition);
            return coordShopModel;
        }
    }
}
