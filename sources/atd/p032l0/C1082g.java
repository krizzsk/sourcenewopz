package atd.p032l0;

import android.content.Context;
import atd.p034m0.C1113g;
import com.adyen.threeds2.Warning;
import com.adyen.threeds2.internal.C1417j;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: atd.l0.g */
public final class C1082g {

    /* renamed from: a */
    private final List<Warning> f326a;

    private C1082g(Context context, ConfigParameters configParameters) {
        this.f326a = m527a(context, AdyenConfigParameters.getParamValue(configParameters, AdyenConfigParameters.SECURITY_APP_SIGNATURE), AdyenConfigParameters.getParamValues(configParameters, AdyenConfigParameters.SECURITY_TRUSTED_APP_STORES), AdyenConfigParameters.getParamValues(configParameters, AdyenConfigParameters.SECURITY_MALICIOUS_APPS));
    }

    /* renamed from: a */
    public static C1082g m526a(Context context, ConfigParameters configParameters) {
        return new C1082g(context.getApplicationContext(), configParameters);
    }

    /* renamed from: a */
    public List<Warning> mo13819a() {
        return this.f326a;
    }

    /* renamed from: a */
    private List<Warning> m527a(Context context, String str, Collection<String> collection, Collection<String> collection2) {
        ArrayList arrayList = new ArrayList();
        for (C1081f a : m528a(str, collection, collection2)) {
            C1417j a2 = a.mo13815a(context);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C1081f> m528a(String str, Collection<String> collection, Collection<String> collection2) {
        ArrayList arrayList = new ArrayList();
        C1113g gVar = new C1113g();
        arrayList.add(new C1077b(gVar));
        arrayList.add(new C1080e(str, collection, collection2, gVar));
        arrayList.add(new C1078c(gVar));
        arrayList.add(new C1076a(gVar));
        arrayList.add(new C1079d(gVar));
        return arrayList;
    }
}
