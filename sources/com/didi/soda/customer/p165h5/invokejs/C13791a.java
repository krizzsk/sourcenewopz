package com.didi.soda.customer.p165h5.invokejs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/invokejs/JSMethodInfo;", "", "moduleName", "", "jsMethodName", "(Ljava/lang/String;Ljava/lang/String;)V", "getJsMethodName", "()Ljava/lang/String;", "setJsMethodName", "(Ljava/lang/String;)V", "getModuleName", "setModuleName", "checkInvalid", "", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.invokejs.a */
/* compiled from: TriggerManager.kt */
final class C13791a {

    /* renamed from: a */
    private String f41342a;

    /* renamed from: b */
    private String f41343b;

    public C13791a() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public C13791a(String str, String str2) {
        this.f41342a = str;
        this.f41343b = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C13791a(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    /* renamed from: a */
    public final String mo105212a() {
        return this.f41342a;
    }

    /* renamed from: a */
    public final void mo105213a(String str) {
        this.f41342a = str;
    }

    /* renamed from: b */
    public final String mo105214b() {
        return this.f41343b;
    }

    /* renamed from: b */
    public final void mo105215b(String str) {
        this.f41343b = str;
    }

    /* renamed from: c */
    public final boolean mo105216c() {
        CharSequence charSequence = this.f41342a;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        CharSequence charSequence2 = this.f41343b;
        return !(charSequence2 == null || charSequence2.length() == 0);
    }

    public String toString() {
        return "JSMethodInfo(moduleName=" + this.f41342a + ", jsMethodName=" + this.f41343b + VersionRange.RIGHT_OPEN;
    }
}
