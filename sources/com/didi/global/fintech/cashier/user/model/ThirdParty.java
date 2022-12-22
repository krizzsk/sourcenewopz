package com.didi.global.fintech.cashier.user.model;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/ThirdParty;", "Ljava/io/Serializable;", "three_ds", "Lcom/didi/global/fintech/cashier/user/model/ThirdParty$ThreeDS;", "(Lcom/didi/global/fintech/cashier/user/model/ThirdParty$ThreeDS;)V", "getThree_ds", "()Lcom/didi/global/fintech/cashier/user/model/ThirdParty$ThreeDS;", "setThree_ds", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ThreeDS", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayCashierEnv.kt */
public final class ThirdParty implements Serializable {
    private ThreeDS three_ds;

    public static /* synthetic */ ThirdParty copy$default(ThirdParty thirdParty, ThreeDS threeDS, int i, Object obj) {
        if ((i & 1) != 0) {
            threeDS = thirdParty.three_ds;
        }
        return thirdParty.copy(threeDS);
    }

    public final ThreeDS component1() {
        return this.three_ds;
    }

    public final ThirdParty copy(ThreeDS threeDS) {
        Intrinsics.checkNotNullParameter(threeDS, CashierAction.ACTION_THREE_DS);
        return new ThirdParty(threeDS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThirdParty) && Intrinsics.areEqual((Object) this.three_ds, (Object) ((ThirdParty) obj).three_ds);
    }

    public int hashCode() {
        return this.three_ds.hashCode();
    }

    public String toString() {
        return "ThirdParty(three_ds=" + this.three_ds + VersionRange.RIGHT_OPEN;
    }

    public ThirdParty(ThreeDS threeDS) {
        Intrinsics.checkNotNullParameter(threeDS, CashierAction.ACTION_THREE_DS);
        this.three_ds = threeDS;
    }

    public final ThreeDS getThree_ds() {
        return this.three_ds;
    }

    public final void setThree_ds(ThreeDS threeDS) {
        Intrinsics.checkNotNullParameter(threeDS, "<set-?>");
        this.three_ds = threeDS;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/ThirdParty$ThreeDS;", "Ljava/io/Serializable;", "()V", "callback_schema", "", "getCallback_schema", "()Ljava/lang/String;", "setCallback_schema", "(Ljava/lang/String;)V", "support_vendor", "", "getSupport_vendor", "()Ljava/util/List;", "setSupport_vendor", "(Ljava/util/List;)V", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayCashierEnv.kt */
    public static final class ThreeDS implements Serializable {
        private String callback_schema;
        private List<String> support_vendor;

        public final List<String> getSupport_vendor() {
            return this.support_vendor;
        }

        public final void setSupport_vendor(List<String> list) {
            this.support_vendor = list;
        }

        public final String getCallback_schema() {
            return this.callback_schema;
        }

        public final void setCallback_schema(String str) {
            this.callback_schema = str;
        }
    }
}
