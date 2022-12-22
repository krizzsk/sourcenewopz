package atd.p051x;

import atd.p044r0.C1160g;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: atd.x.b */
public final class C1220b {

    /* renamed from: a */
    private static final Map<String, List<String>> f380a = Collections.unmodifiableMap(m900a());

    /* renamed from: a */
    private static Map<String, List<String>> m900a() {
        HashMap hashMap = new HashMap();
        hashMap.put(C1172a.m764a(-348008768424622L), Collections.singletonList(C1172a.m764a(-348180567116462L)));
        hashMap.put(C1172a.m764a(-379654087461550L), Collections.singletonList(C1172a.m764a(-379825886153390L)));
        hashMap.put(C1172a.m764a(-410509132516014L), Collections.singletonList(C1172a.m764a(-410680931207854L)));
        hashMap.put(C1172a.m764a(-441364177570478L), Arrays.asList(new String[]{C1172a.m764a(-441535976262318L), C1172a.m764a(-460605631056558L)}));
        hashMap.put(C1172a.m764a(-482677467990702L), Collections.singletonList(C1172a.m764a(-482849266682542L)));
        hashMap.put(C1172a.m764a(-513098721348270L), Collections.singletonList(C1172a.m764a(-513270520040110L)));
        hashMap.put(C1172a.m764a(-532408894311086L), Collections.singletonList(C1172a.m764a(-532580693002926L)));
        hashMap.put(C1172a.m764a(-550125634407086L), Collections.singletonList(C1172a.m764a(-550297433098926L)));
        hashMap.put(C1172a.m764a(-579571930188462L), Collections.singletonList(C1172a.m764a(-579743728880302L)));
        hashMap.put(C1172a.m764a(-603761185999534L), Collections.singletonList(C1172a.m764a(-603932984691374L)));
        return hashMap;
    }

    /* renamed from: b */
    public static List<String> m901b(String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : f380a.entrySet()) {
            if (m899a((String) next.getKey()).equalsIgnoreCase(str)) {
                for (String a : (List) next.getValue()) {
                    arrayList.add(m899a(a));
                }
                return arrayList;
            }
        }
        throw C1225c.UNKNOWN_DIRECTORY_SERVER.mo13982a();
    }

    /* renamed from: a */
    private static String m899a(String str) {
        return C1160g.m734a(str);
    }
}
