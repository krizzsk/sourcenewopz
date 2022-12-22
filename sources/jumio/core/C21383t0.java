package jumio.core;

import com.jumio.core.persistence.DataManager;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.t0 */
/* compiled from: UserConsent.kt */
public final class C21383t0 {

    /* renamed from: a */
    public static final C21383t0 f59674a = new C21383t0();

    /* renamed from: a */
    public final boolean mo175877a(DataManager dataManager, C21363k kVar) {
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        if (kVar == null || !kVar.isConsentRequired()) {
            return false;
        }
        String stateForIp = kVar.getStateForIp();
        String a = C21388x.m42217a((C21340b) dataManager.get(C21340b.class));
        List<String> consentStates = kVar.getConsentStates();
        if (!(consentStates != null && CollectionsKt.contains(consentStates, stateForIp))) {
            List<String> consentStates2 = kVar.getConsentStates();
            if (consentStates2 != null && consentStates2.contains(a)) {
                return true;
            }
            return false;
        }
        return true;
    }
}
