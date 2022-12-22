package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/Faq;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "wordChain", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/WordChain;", "btns", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBtns;", "(Lcom/didi/entrega/customer/foundation/rpc/entity/order/WordChain;Ljava/util/List;)V", "getBtns", "()Ljava/util/List;", "getWordChain", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/WordChain;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class Faq implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 165963979796239575L;
    private final List<OrderBtns> btns;
    private final WordChain wordChain;

    public Faq() {
        this((WordChain) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Faq copy$default(Faq faq, WordChain wordChain2, List<OrderBtns> list, int i, Object obj) {
        if ((i & 1) != 0) {
            wordChain2 = faq.wordChain;
        }
        if ((i & 2) != 0) {
            list = faq.btns;
        }
        return faq.copy(wordChain2, list);
    }

    public final WordChain component1() {
        return this.wordChain;
    }

    public final List<OrderBtns> component2() {
        return this.btns;
    }

    public final Faq copy(WordChain wordChain2, List<OrderBtns> list) {
        return new Faq(wordChain2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Faq)) {
            return false;
        }
        Faq faq = (Faq) obj;
        return Intrinsics.areEqual((Object) this.wordChain, (Object) faq.wordChain) && Intrinsics.areEqual((Object) this.btns, (Object) faq.btns);
    }

    public int hashCode() {
        WordChain wordChain2 = this.wordChain;
        int i = 0;
        int hashCode = (wordChain2 == null ? 0 : wordChain2.hashCode()) * 31;
        List<OrderBtns> list = this.btns;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Faq(wordChain=" + this.wordChain + ", btns=" + this.btns + VersionRange.RIGHT_OPEN;
    }

    public Faq(WordChain wordChain2, List<OrderBtns> list) {
        this.wordChain = wordChain2;
        this.btns = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Faq(WordChain wordChain2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : wordChain2, (i & 2) != 0 ? null : list);
    }

    public final WordChain getWordChain() {
        return this.wordChain;
    }

    public final List<OrderBtns> getBtns() {
        return this.btns;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/Faq$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
