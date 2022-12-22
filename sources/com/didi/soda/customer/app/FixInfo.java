package com.didi.soda.customer.app;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/customer/app/FixInfo;", "", "isFix", "", "phoneBrands", "", "withBrand", "(ZLjava/lang/String;Z)V", "hitBrands", "", "getHitBrands", "()Ljava/util/List;", "setHitBrands", "(Ljava/util/List;)V", "()Z", "getPhoneBrands", "()Ljava/lang/String;", "getWithBrand", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FixInfo.kt */
public final class FixInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final boolean f40322a;

    /* renamed from: b */
    private final String f40323b;

    /* renamed from: c */
    private final boolean f40324c;

    /* renamed from: d */
    private List<String> f40325d;

    public FixInfo(boolean z, String str, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "phoneBrands");
        this.f40322a = z;
        this.f40323b = str;
        this.f40324c = z2;
        this.f40325d = StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FixInfo(boolean z, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i & 4) != 0 ? false : z2);
    }

    public final boolean isFix() {
        return this.f40322a;
    }

    public final String getPhoneBrands() {
        return this.f40323b;
    }

    public final boolean getWithBrand() {
        return this.f40324c;
    }

    public final List<String> getHitBrands() {
        return this.f40325d;
    }

    public final void setHitBrands(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f40325d = list;
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/app/FixInfo$Companion;", "", "()V", "create", "Lcom/didi/soda/customer/app/FixInfo;", "isFix", "", "phoneBrands", "", "withBrand", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FixInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ FixInfo create$default(Companion companion, boolean z, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                str = "";
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return companion.create(z, str, z2);
        }

        public final FixInfo create(boolean z, String str, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "phoneBrands");
            return new FixInfo(z, str, z2);
        }
    }
}
