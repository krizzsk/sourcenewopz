package com.didi.entrega.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/TopMapInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "etaTips", "", "receiverPoi", "Lcom/didi/entrega/customer/foundation/rpc/entity/ReceiverPoi;", "senderPoi", "Lcom/didi/entrega/customer/foundation/rpc/entity/SenderPoi;", "(Ljava/lang/String;Lcom/didi/entrega/customer/foundation/rpc/entity/ReceiverPoi;Lcom/didi/entrega/customer/foundation/rpc/entity/SenderPoi;)V", "getEtaTips", "()Ljava/lang/String;", "getReceiverPoi", "()Lcom/didi/entrega/customer/foundation/rpc/entity/ReceiverPoi;", "getSenderPoi", "()Lcom/didi/entrega/customer/foundation/rpc/entity/SenderPoi;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillEntity.kt */
public final class TopMapInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -2811806157138064941L;
    private final String etaTips;
    private final ReceiverPoi receiverPoi;
    private final SenderPoi senderPoi;

    public TopMapInfo() {
        this((String) null, (ReceiverPoi) null, (SenderPoi) null, 7, (DefaultConstructorMarker) null);
    }

    public TopMapInfo(String str, ReceiverPoi receiverPoi2, SenderPoi senderPoi2) {
        this.etaTips = str;
        this.receiverPoi = receiverPoi2;
        this.senderPoi = senderPoi2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopMapInfo(String str, ReceiverPoi receiverPoi2, SenderPoi senderPoi2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : receiverPoi2, (i & 4) != 0 ? null : senderPoi2);
    }

    public final String getEtaTips() {
        return this.etaTips;
    }

    public final ReceiverPoi getReceiverPoi() {
        return this.receiverPoi;
    }

    public final SenderPoi getSenderPoi() {
        return this.senderPoi;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/TopMapInfo$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
