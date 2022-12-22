package com.adyen.checkout.adyen3ds2.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001e"}, mo175978d2 = {"Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintResponse;", "Lcom/adyen/checkout/core/model/ModelObject;", "action", "Lcom/adyen/checkout/components/model/payments/response/Action;", "type", "", "details", "(Lcom/adyen/checkout/components/model/payments/response/Action;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Lcom/adyen/checkout/components/model/payments/response/Action;", "getDetails", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "3ds2_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubmitFingerprintResponse.kt */
public final class SubmitFingerprintResponse extends ModelObject {
    public static final Parcelable.Creator<SubmitFingerprintResponse> CREATOR = new ModelObject.Creator(SubmitFingerprintResponse.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final String f575d = "action";

    /* renamed from: e */
    private static final String f576e = "type";

    /* renamed from: f */
    private static final String f577f = "details";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final ModelObject.Serializer<SubmitFingerprintResponse> f578g = new SubmitFingerprintResponse$Companion$SERIALIZER$1();

    /* renamed from: a */
    private final Action f579a;

    /* renamed from: b */
    private final String f580b;

    /* renamed from: c */
    private final String f581c;

    public static /* synthetic */ SubmitFingerprintResponse copy$default(SubmitFingerprintResponse submitFingerprintResponse, Action action, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            action = submitFingerprintResponse.f579a;
        }
        if ((i & 2) != 0) {
            str = submitFingerprintResponse.f580b;
        }
        if ((i & 4) != 0) {
            str2 = submitFingerprintResponse.f581c;
        }
        return submitFingerprintResponse.copy(action, str, str2);
    }

    public static final ModelObject.Serializer<SubmitFingerprintResponse> getSERIALIZER() {
        return Companion.getSERIALIZER();
    }

    public final Action component1() {
        return this.f579a;
    }

    public final String component2() {
        return this.f580b;
    }

    public final String component3() {
        return this.f581c;
    }

    public final SubmitFingerprintResponse copy(Action action, String str, String str2) {
        return new SubmitFingerprintResponse(action, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitFingerprintResponse)) {
            return false;
        }
        SubmitFingerprintResponse submitFingerprintResponse = (SubmitFingerprintResponse) obj;
        return Intrinsics.areEqual((Object) this.f579a, (Object) submitFingerprintResponse.f579a) && Intrinsics.areEqual((Object) this.f580b, (Object) submitFingerprintResponse.f580b) && Intrinsics.areEqual((Object) this.f581c, (Object) submitFingerprintResponse.f581c);
    }

    public int hashCode() {
        Action action = this.f579a;
        int i = 0;
        int hashCode = (action == null ? 0 : action.hashCode()) * 31;
        String str = this.f580b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f581c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SubmitFingerprintResponse(action=" + this.f579a + ", type=" + this.f580b + ", details=" + this.f581c + VersionRange.RIGHT_OPEN;
    }

    public final Action getAction() {
        return this.f579a;
    }

    public final String getType() {
        return this.f580b;
    }

    public final String getDetails() {
        return this.f581c;
    }

    public SubmitFingerprintResponse(Action action, String str, String str2) {
        this.f579a = action;
        this.f580b = str;
        this.f581c = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        JsonUtils.writeToParcel(parcel, f578g.serialize(this));
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintResponse$Companion;", "", "()V", "ACTION", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintResponse;", "DETAILS", "SERIALIZER", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "getSERIALIZER$annotations", "getSERIALIZER", "()Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "TYPE", "3ds2_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SubmitFingerprintResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSERIALIZER$annotations() {
        }

        private Companion() {
        }

        public final ModelObject.Serializer<SubmitFingerprintResponse> getSERIALIZER() {
            return SubmitFingerprintResponse.f578g;
        }
    }
}
