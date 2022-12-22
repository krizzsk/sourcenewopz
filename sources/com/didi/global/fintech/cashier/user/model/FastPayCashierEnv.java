package com.didi.global.fintech.cashier.user.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/FastPayCashierEnv;", "Ljava/io/Serializable;", "()V", "third_party", "Lcom/didi/global/fintech/cashier/user/model/ThirdParty;", "getThird_party", "()Lcom/didi/global/fintech/cashier/user/model/ThirdParty;", "setThird_party", "(Lcom/didi/global/fintech/cashier/user/model/ThirdParty;)V", "third_party_ability", "Lcom/didi/global/fintech/cashier/user/model/ThirdPartyAbility;", "getThird_party_ability", "()Lcom/didi/global/fintech/cashier/user/model/ThirdPartyAbility;", "setThird_party_ability", "(Lcom/didi/global/fintech/cashier/user/model/ThirdPartyAbility;)V", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayCashierEnv.kt */
public final class FastPayCashierEnv implements Serializable {
    private ThirdParty third_party;
    private ThirdPartyAbility third_party_ability;

    public final ThirdParty getThird_party() {
        return this.third_party;
    }

    public final void setThird_party(ThirdParty thirdParty) {
        this.third_party = thirdParty;
    }

    public final ThirdPartyAbility getThird_party_ability() {
        return this.third_party_ability;
    }

    public final void setThird_party_ability(ThirdPartyAbility thirdPartyAbility) {
        this.third_party_ability = thirdPartyAbility;
    }
}
