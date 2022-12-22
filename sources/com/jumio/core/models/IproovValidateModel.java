package com.jumio.core.models;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, mo175978d2 = {"Lcom/jumio/core/models/IproovValidateModel;", "Lcom/jumio/core/model/StaticModel;", "", "component1", "", "component2", "passed", "failureReason", "copy", "toString", "", "hashCode", "", "other", "equals", "a", "Z", "getPassed", "()Z", "b", "Ljava/lang/String;", "getFailureReason", "()Ljava/lang/String;", "<init>", "(ZLjava/lang/String;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("IproovValidateModel")
/* compiled from: IproovValidateModel.kt */
public final class IproovValidateModel implements StaticModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public final boolean f54844a;

    /* renamed from: b */
    public final String f54845b;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/core/models/IproovValidateModel$Companion;", "", "", "string", "Lcom/jumio/core/models/IproovValidateModel;", "fromString", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: IproovValidateModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IproovValidateModel fromString(String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("passed", false);
            String optString = jSONObject.optString("failureReason", "");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"failureReason\", \"\")");
            return new IproovValidateModel(optBoolean, optString);
        }
    }

    public IproovValidateModel() {
        this(false, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public IproovValidateModel(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "failureReason");
        this.f54844a = z;
        this.f54845b = str;
    }

    public static /* synthetic */ IproovValidateModel copy$default(IproovValidateModel iproovValidateModel, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = iproovValidateModel.f54844a;
        }
        if ((i & 2) != 0) {
            str = iproovValidateModel.f54845b;
        }
        return iproovValidateModel.copy(z, str);
    }

    public final boolean component1() {
        return this.f54844a;
    }

    public final String component2() {
        return this.f54845b;
    }

    public final IproovValidateModel copy(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "failureReason");
        return new IproovValidateModel(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IproovValidateModel)) {
            return false;
        }
        IproovValidateModel iproovValidateModel = (IproovValidateModel) obj;
        return this.f54844a == iproovValidateModel.f54844a && Intrinsics.areEqual((Object) this.f54845b, (Object) iproovValidateModel.f54845b);
    }

    public final String getFailureReason() {
        return this.f54845b;
    }

    public final boolean getPassed() {
        return this.f54844a;
    }

    public int hashCode() {
        boolean z = this.f54844a;
        if (z) {
            z = true;
        }
        return ((z ? 1 : 0) * true) + this.f54845b.hashCode();
    }

    public String toString() {
        return "IproovValidateModel(passed=" + this.f54844a + ", failureReason=" + this.f54845b + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IproovValidateModel(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
    }
}
