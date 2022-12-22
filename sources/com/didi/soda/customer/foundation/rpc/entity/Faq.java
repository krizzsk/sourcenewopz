package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/Faq;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "title", "", "wordChain", "Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;", "btns", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderBtns;", "(Ljava/lang/String;Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;Ljava/util/List;)V", "getBtns", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getWordChain", "()Lcom/didi/soda/customer/foundation/rpc/entity/WordChain;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class Faq implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 8670122635068323058L;
    private final List<OrderBtns> btns;
    private final String title;
    private final WordChain wordChain;

    public Faq() {
        this((String) null, (WordChain) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Faq copy$default(Faq faq, String str, WordChain wordChain2, List<OrderBtns> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = faq.title;
        }
        if ((i & 2) != 0) {
            wordChain2 = faq.wordChain;
        }
        if ((i & 4) != 0) {
            list = faq.btns;
        }
        return faq.copy(str, wordChain2, list);
    }

    public final String component1() {
        return this.title;
    }

    public final WordChain component2() {
        return this.wordChain;
    }

    public final List<OrderBtns> component3() {
        return this.btns;
    }

    public final Faq copy(String str, WordChain wordChain2, List<OrderBtns> list) {
        return new Faq(str, wordChain2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Faq)) {
            return false;
        }
        Faq faq = (Faq) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) faq.title) && Intrinsics.areEqual((Object) this.wordChain, (Object) faq.wordChain) && Intrinsics.areEqual((Object) this.btns, (Object) faq.btns);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        WordChain wordChain2 = this.wordChain;
        int hashCode2 = (hashCode + (wordChain2 == null ? 0 : wordChain2.hashCode())) * 31;
        List<OrderBtns> list = this.btns;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Faq(title=" + this.title + ", wordChain=" + this.wordChain + ", btns=" + this.btns + VersionRange.RIGHT_OPEN;
    }

    public Faq(String str, WordChain wordChain2, List<OrderBtns> list) {
        this.title = str;
        this.wordChain = wordChain2;
        this.btns = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Faq(String str, WordChain wordChain2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : wordChain2, (i & 4) != 0 ? null : list);
    }

    public final String getTitle() {
        return this.title;
    }

    public final WordChain getWordChain() {
        return this.wordChain;
    }

    public final List<OrderBtns> getBtns() {
        return this.btns;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/Faq$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
