package com.datadog.android.core.internal.persistence;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "", "prefix", "", "suffix", "separator", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "getPrefix", "()Ljava/lang/CharSequence;", "prefixBytes", "", "getPrefixBytes", "()[B", "getSeparator", "separatorBytes", "getSeparatorBytes", "getSuffix", "suffixBytes", "getSuffixBytes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayloadDecoration.kt */
public final class PayloadDecoration {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final PayloadDecoration f3507g = new PayloadDecoration(Const.jaLeft, Const.jaRight, ",");
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final PayloadDecoration f3508h = new PayloadDecoration("", "", "\n");

    /* renamed from: a */
    private final CharSequence f3509a;

    /* renamed from: b */
    private final CharSequence f3510b;

    /* renamed from: c */
    private final CharSequence f3511c;

    /* renamed from: d */
    private final byte[] f3512d;

    /* renamed from: e */
    private final byte[] f3513e;

    /* renamed from: f */
    private final byte[] f3514f;

    public static /* synthetic */ PayloadDecoration copy$default(PayloadDecoration payloadDecoration, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = payloadDecoration.f3509a;
        }
        if ((i & 2) != 0) {
            charSequence2 = payloadDecoration.f3510b;
        }
        if ((i & 4) != 0) {
            charSequence3 = payloadDecoration.f3511c;
        }
        return payloadDecoration.copy(charSequence, charSequence2, charSequence3);
    }

    public final CharSequence component1() {
        return this.f3509a;
    }

    public final CharSequence component2() {
        return this.f3510b;
    }

    public final CharSequence component3() {
        return this.f3511c;
    }

    public final PayloadDecoration copy(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "prefix");
        Intrinsics.checkNotNullParameter(charSequence2, AbsDomainSuffixModel.SUFFIX);
        Intrinsics.checkNotNullParameter(charSequence3, "separator");
        return new PayloadDecoration(charSequence, charSequence2, charSequence3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayloadDecoration)) {
            return false;
        }
        PayloadDecoration payloadDecoration = (PayloadDecoration) obj;
        return Intrinsics.areEqual((Object) this.f3509a, (Object) payloadDecoration.f3509a) && Intrinsics.areEqual((Object) this.f3510b, (Object) payloadDecoration.f3510b) && Intrinsics.areEqual((Object) this.f3511c, (Object) payloadDecoration.f3511c);
    }

    public int hashCode() {
        return (((this.f3509a.hashCode() * 31) + this.f3510b.hashCode()) * 31) + this.f3511c.hashCode();
    }

    public String toString() {
        return "PayloadDecoration(prefix=" + this.f3509a + ", suffix=" + this.f3510b + ", separator=" + this.f3511c + VersionRange.RIGHT_OPEN;
    }

    public PayloadDecoration(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "prefix");
        Intrinsics.checkNotNullParameter(charSequence2, AbsDomainSuffixModel.SUFFIX);
        Intrinsics.checkNotNullParameter(charSequence3, "separator");
        this.f3509a = charSequence;
        this.f3510b = charSequence2;
        this.f3511c = charSequence3;
        String obj = charSequence3.toString();
        Charset charset = Charsets.UTF_8;
        if (obj != null) {
            byte[] bytes = obj.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            this.f3512d = bytes;
            String obj2 = this.f3509a.toString();
            Charset charset2 = Charsets.UTF_8;
            if (obj2 != null) {
                byte[] bytes2 = obj2.getBytes(charset2);
                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                this.f3513e = bytes2;
                String obj3 = this.f3510b.toString();
                Charset charset3 = Charsets.UTF_8;
                if (obj3 != null) {
                    byte[] bytes3 = obj3.getBytes(charset3);
                    Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                    this.f3514f = bytes3;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final CharSequence getPrefix() {
        return this.f3509a;
    }

    public final CharSequence getSuffix() {
        return this.f3510b;
    }

    public final CharSequence getSeparator() {
        return this.f3511c;
    }

    public final byte[] getSeparatorBytes() {
        return this.f3512d;
    }

    public final byte[] getPrefixBytes() {
        return this.f3513e;
    }

    public final byte[] getSuffixBytes() {
        return this.f3514f;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/PayloadDecoration$Companion;", "", "()V", "JSON_ARRAY_DECORATION", "Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "getJSON_ARRAY_DECORATION", "()Lcom/datadog/android/core/internal/persistence/PayloadDecoration;", "NEW_LINE_DECORATION", "getNEW_LINE_DECORATION", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayloadDecoration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PayloadDecoration getJSON_ARRAY_DECORATION() {
            return PayloadDecoration.f3507g;
        }

        public final PayloadDecoration getNEW_LINE_DECORATION() {
            return PayloadDecoration.f3508h;
        }
    }
}
