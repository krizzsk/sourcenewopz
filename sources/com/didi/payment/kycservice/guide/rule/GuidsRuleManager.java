package com.didi.payment.kycservice.guide.rule;

import android.util.SparseArray;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/kycservice/guide/rule/GuidsRuleManager;", "", "()V", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GuidsRuleManager.kt */
public final class GuidsRuleManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static SparseArray<IKycGuidesRule> f30621a;

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/guide/rule/GuidsRuleManager$Companion;", "", "()V", "guidesRules", "Landroid/util/SparseArray;", "Lcom/didi/payment/kycservice/guide/rule/IKycGuidesRule;", "getGuidesRules", "()Landroid/util/SparseArray;", "setGuidesRules", "(Landroid/util/SparseArray;)V", "init", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GuidsRuleManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SparseArray<IKycGuidesRule> getGuidesRules() {
            return GuidsRuleManager.f30621a;
        }

        public final void setGuidesRules(SparseArray<IKycGuidesRule> sparseArray) {
            GuidsRuleManager.f30621a = sparseArray;
        }

        public final void init() {
            SparseArray<IKycGuidesRule> guidesRules;
            setGuidesRules(new SparseArray());
            Iterator<S> it = ServiceLoader.load(IKycGuidesRule.class).iterator();
            while (it.hasNext()) {
                IKycGuidesRule iKycGuidesRule = (IKycGuidesRule) it.next();
                if (!(iKycGuidesRule == null || (guidesRules = getGuidesRules()) == null)) {
                    guidesRules.put(Integer.parseInt(iKycGuidesRule.key()), iKycGuidesRule);
                }
            }
        }
    }
}
