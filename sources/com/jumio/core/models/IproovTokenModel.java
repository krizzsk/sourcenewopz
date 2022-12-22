package com.jumio.core.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, mo175978d2 = {"Lcom/jumio/core/models/IproovTokenModel;", "Lcom/jumio/core/model/StaticModel;", "", "component1", "component2", "component3", "token", "url", "productType", "copy", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "b", "getUrl", "c", "getProductType", "d", "Z", "getUsed", "()Z", "setUsed", "(Z)V", "used", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("IproovTokenModel")
/* compiled from: IproovTokenModel.kt */
public final class IproovTokenModel implements StaticModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public final String f54840a;

    /* renamed from: b */
    public final String f54841b;

    /* renamed from: c */
    public final String f54842c;

    /* renamed from: d */
    public boolean f54843d;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/core/models/IproovTokenModel$Companion;", "", "", "string", "Lcom/jumio/core/models/IproovTokenModel;", "fromString", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: IproovTokenModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IproovTokenModel fromString(String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("token");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"token\")");
            String string2 = jSONObject.getString("url");
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"url\")");
            String string3 = jSONObject.getString("productType");
            Intrinsics.checkNotNullExpressionValue(string3, "json.getString(\"productType\")");
            return new IproovTokenModel(string, string2, string3);
        }
    }

    public IproovTokenModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public IproovTokenModel(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "productType");
        this.f54840a = str;
        this.f54841b = str2;
        this.f54842c = str3;
    }

    public static /* synthetic */ IproovTokenModel copy$default(IproovTokenModel iproovTokenModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iproovTokenModel.f54840a;
        }
        if ((i & 2) != 0) {
            str2 = iproovTokenModel.f54841b;
        }
        if ((i & 4) != 0) {
            str3 = iproovTokenModel.f54842c;
        }
        return iproovTokenModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.f54840a;
    }

    public final String component2() {
        return this.f54841b;
    }

    public final String component3() {
        return this.f54842c;
    }

    public final IproovTokenModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "productType");
        return new IproovTokenModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IproovTokenModel)) {
            return false;
        }
        IproovTokenModel iproovTokenModel = (IproovTokenModel) obj;
        return Intrinsics.areEqual((Object) this.f54840a, (Object) iproovTokenModel.f54840a) && Intrinsics.areEqual((Object) this.f54841b, (Object) iproovTokenModel.f54841b) && Intrinsics.areEqual((Object) this.f54842c, (Object) iproovTokenModel.f54842c);
    }

    public final String getProductType() {
        return this.f54842c;
    }

    public final String getToken() {
        return this.f54840a;
    }

    public final String getUrl() {
        return this.f54841b;
    }

    public final boolean getUsed() {
        return this.f54843d;
    }

    public int hashCode() {
        return (((this.f54840a.hashCode() * 31) + this.f54841b.hashCode()) * 31) + this.f54842c.hashCode();
    }

    public final void setUsed(boolean z) {
        this.f54843d = z;
    }

    public String toString() {
        return "IproovTokenModel(token=" + this.f54840a + ", url=" + this.f54841b + ", productType=" + this.f54842c + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IproovTokenModel(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "iproov_standard" : str3);
    }
}
