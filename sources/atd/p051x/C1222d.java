package atd.p051x;

import atd.p044r0.C1160g;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: atd.x.d */
public final class C1222d {

    /* renamed from: a */
    private static final Map<String, String> f381a = Collections.unmodifiableMap(m907a());

    /* renamed from: a */
    private static Map<String, String> m907a() {
        HashMap hashMap = new HashMap();
        hashMap.put(C1172a.m764a(-634526036740782L), C1172a.m764a(-634697835432622L));
        hashMap.put(C1172a.m764a(-641075861867182L), C1172a.m764a(-641247660559022L));
        hashMap.put(C1172a.m764a(-643811756034734L), C1172a.m764a(-643983554726574L));
        hashMap.put(C1172a.m764a(-650361581161134L), C1172a.m764a(-650533379852974L));
        hashMap.put(C1172a.m764a(-657439687264942L), C1172a.m764a(-657611485956782L));
        hashMap.put(C1172a.m764a(-663521360956078L), C1172a.m764a(-663693159647918L));
        hashMap.put(C1172a.m764a(-669603034647214L), C1172a.m764a(-669774833339054L));
        hashMap.put(C1172a.m764a(-676152859773614L), C1172a.m764a(-676324658465454L));
        hashMap.put(C1172a.m764a(-682324727777966L), C1172a.m764a(-682496526469806L));
        return hashMap;
    }

    /* renamed from: b */
    public static String m908b(String str) {
        for (Map.Entry next : f381a.entrySet()) {
            if (m906a((String) next.getKey()).equalsIgnoreCase(str)) {
                return m906a((String) next.getValue());
            }
        }
        throw C1225c.UNKNOWN_DIRECTORY_SERVER.mo13982a();
    }

    /* renamed from: a */
    private static String m906a(String str) {
        return C1160g.m734a(str);
    }
}
