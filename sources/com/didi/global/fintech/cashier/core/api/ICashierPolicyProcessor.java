package com.didi.global.fintech.cashier.core.api;

import com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/api/ICashierPolicyProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierBaseProcessor;", "onPolicyProcess", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "onShowPrivacyPolicy", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ICashierPolicyProcessor.kt */
public interface ICashierPolicyProcessor extends ICashierBaseProcessor {
    void onPolicyProcess(AgreePolicyResponse agreePolicyResponse);

    void onShowPrivacyPolicy(PayInfoResponse payInfoResponse);
}
