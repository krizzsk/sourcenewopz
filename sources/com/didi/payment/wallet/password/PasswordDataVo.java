package com.didi.payment.wallet.password;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JY\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, mo175978d2 = {"Lcom/didi/payment/wallet/password/PasswordDataVo;", "", "type", "", "data", "", "paySessionId", "title", "content", "confirmButton", "cancelButton", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancelButton", "()Ljava/lang/String;", "getConfirmButton", "getContent", "getData", "getPaySessionId", "getTitle", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PasswordDataVo.kt */
public final class PasswordDataVo {

    /* renamed from: a */
    private final int f32856a;

    /* renamed from: b */
    private final String f32857b;

    /* renamed from: c */
    private final String f32858c;

    /* renamed from: d */
    private final String f32859d;

    /* renamed from: e */
    private final String f32860e;

    /* renamed from: f */
    private final String f32861f;

    /* renamed from: g */
    private final String f32862g;

    public static /* synthetic */ PasswordDataVo copy$default(PasswordDataVo passwordDataVo, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = passwordDataVo.f32856a;
        }
        if ((i2 & 2) != 0) {
            str = passwordDataVo.f32857b;
        }
        String str7 = str;
        if ((i2 & 4) != 0) {
            str2 = passwordDataVo.f32858c;
        }
        String str8 = str2;
        if ((i2 & 8) != 0) {
            str3 = passwordDataVo.f32859d;
        }
        String str9 = str3;
        if ((i2 & 16) != 0) {
            str4 = passwordDataVo.f32860e;
        }
        String str10 = str4;
        if ((i2 & 32) != 0) {
            str5 = passwordDataVo.f32861f;
        }
        String str11 = str5;
        if ((i2 & 64) != 0) {
            str6 = passwordDataVo.f32862g;
        }
        return passwordDataVo.copy(i, str7, str8, str9, str10, str11, str6);
    }

    public final int component1() {
        return this.f32856a;
    }

    public final String component2() {
        return this.f32857b;
    }

    public final String component3() {
        return this.f32858c;
    }

    public final String component4() {
        return this.f32859d;
    }

    public final String component5() {
        return this.f32860e;
    }

    public final String component6() {
        return this.f32861f;
    }

    public final String component7() {
        return this.f32862g;
    }

    public final PasswordDataVo copy(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "data");
        return new PasswordDataVo(i, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PasswordDataVo)) {
            return false;
        }
        PasswordDataVo passwordDataVo = (PasswordDataVo) obj;
        return this.f32856a == passwordDataVo.f32856a && Intrinsics.areEqual((Object) this.f32857b, (Object) passwordDataVo.f32857b) && Intrinsics.areEqual((Object) this.f32858c, (Object) passwordDataVo.f32858c) && Intrinsics.areEqual((Object) this.f32859d, (Object) passwordDataVo.f32859d) && Intrinsics.areEqual((Object) this.f32860e, (Object) passwordDataVo.f32860e) && Intrinsics.areEqual((Object) this.f32861f, (Object) passwordDataVo.f32861f) && Intrinsics.areEqual((Object) this.f32862g, (Object) passwordDataVo.f32862g);
    }

    public int hashCode() {
        int hashCode = ((this.f32856a * 31) + this.f32857b.hashCode()) * 31;
        String str = this.f32858c;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f32859d;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f32860e;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f32861f;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f32862g;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "PasswordDataVo(type=" + this.f32856a + ", data=" + this.f32857b + ", paySessionId=" + this.f32858c + ", title=" + this.f32859d + ", content=" + this.f32860e + ", confirmButton=" + this.f32861f + ", cancelButton=" + this.f32862g + VersionRange.RIGHT_OPEN;
    }

    public PasswordDataVo(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "data");
        this.f32856a = i;
        this.f32857b = str;
        this.f32858c = str2;
        this.f32859d = str3;
        this.f32860e = str4;
        this.f32861f = str5;
        this.f32862g = str6;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PasswordDataVo(int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6);
    }

    public final int getType() {
        return this.f32856a;
    }

    public final String getData() {
        return this.f32857b;
    }

    public final String getPaySessionId() {
        return this.f32858c;
    }

    public final String getTitle() {
        return this.f32859d;
    }

    public final String getContent() {
        return this.f32860e;
    }

    public final String getConfirmButton() {
        return this.f32861f;
    }

    public final String getCancelButton() {
        return this.f32862g;
    }
}
