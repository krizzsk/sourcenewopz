package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/StringWrapperSection;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "Ljava/io/Serializable;", "string", "", "isTcExists", "", "(Ljava/lang/String;Z)V", "()Z", "getString", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.StringWrapperSection */
/* compiled from: WalletHomeModel.kt */
public final class StringWrapperSection implements IData, Serializable {
    private final boolean isTcExists;
    private final String string;

    public static /* synthetic */ StringWrapperSection copy$default(StringWrapperSection stringWrapperSection, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stringWrapperSection.string;
        }
        if ((i & 2) != 0) {
            z = stringWrapperSection.isTcExists;
        }
        return stringWrapperSection.copy(str, z);
    }

    public final String component1() {
        return this.string;
    }

    public final boolean component2() {
        return this.isTcExists;
    }

    public final StringWrapperSection copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        return new StringWrapperSection(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringWrapperSection)) {
            return false;
        }
        StringWrapperSection stringWrapperSection = (StringWrapperSection) obj;
        return Intrinsics.areEqual((Object) this.string, (Object) stringWrapperSection.string) && this.isTcExists == stringWrapperSection.isTcExists;
    }

    public int hashCode() {
        int hashCode = this.string.hashCode() * 31;
        boolean z = this.isTcExists;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "StringWrapperSection(string=" + this.string + ", isTcExists=" + this.isTcExists + VersionRange.RIGHT_OPEN;
    }

    public StringWrapperSection(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        this.string = str;
        this.isTcExists = z;
    }

    public final String getString() {
        return this.string;
    }

    public final boolean isTcExists() {
        return this.isTcExists;
    }
}
