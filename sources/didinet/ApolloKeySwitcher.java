package didinet;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ApolloKeySwitcher {

    /* renamed from: A */
    private static final String f57044A = "didihttp_transreq_driver";

    /* renamed from: B */
    private static final String f57045B = "didihttp_transreq_brazil_driver";

    /* renamed from: C */
    private static final String f57046C = "esapp_network_trans_toggle";

    /* renamed from: D */
    private static final String f57047D = "push_toggle";

    /* renamed from: E */
    private static final String f57048E = "http_log_psnger";

    /* renamed from: F */
    private static final String f57049F = "http_log_driver";

    /* renamed from: a */
    private static final String f57050a = "HTTP_DNS";

    /* renamed from: b */
    private static final String f57051b = "TRANS";

    /* renamed from: c */
    private static final String f57052c = "didi_http_log";

    /* renamed from: d */
    private static final String f57053d = "_";

    /* renamed from: l */
    private static final String f57054l = "com.didi.passenger";

    /* renamed from: m */
    private static final String f57055m = "com.sdu.didi.psnger";

    /* renamed from: n */
    private static final String f57056n = "com.didi.passenger.global";

    /* renamed from: o */
    private static final String f57057o = "com.sdu.didi.beatles";

    /* renamed from: p */
    private static final String f57058p = "com.taxis99";

    /* renamed from: q */
    private static final String f57059q = "com.sdu.didi.gsui";

    /* renamed from: r */
    private static final String f57060r = "com.app99.driver";

    /* renamed from: s */
    private static final String f57061s = "com.didi.es.psngr";

    /* renamed from: t */
    private static final String f57062t = "com.qingqikeji.operator";

    /* renamed from: u */
    private static final String f57063u = "httpdns_android_v5";

    /* renamed from: v */
    private static final String f57064v = "httpdns_brazil_psnger";

    /* renamed from: w */
    private static final String f57065w = "httpdns_android_driver";

    /* renamed from: x */
    private static final String f57066x = "httpdns_android_brazil_driver";

    /* renamed from: y */
    private static final String f57067y = "didihttp_transreq";

    /* renamed from: z */
    private static final String f57068z = "didihttp_transreq_brazil_psnger";

    /* renamed from: e */
    private String f57069e;

    /* renamed from: f */
    private String f57070f;

    /* renamed from: g */
    private String f57071g;

    /* renamed from: h */
    private Map<String, String> f57072h = new HashMap();

    /* renamed from: i */
    private Map<String, String> f57073i = new HashMap();

    /* renamed from: j */
    private Map<String, String> f57074j = new HashMap();

    /* renamed from: k */
    private Context f57075k;

    public void init(Context context) {
        this.f57072h.put(f57054l, f57063u);
        this.f57072h.put("com.sdu.didi.psnger", f57063u);
        this.f57072h.put(f57056n, f57063u);
        this.f57072h.put(f57057o, f57063u);
        this.f57072h.put("com.taxis99", f57064v);
        this.f57072h.put("com.sdu.didi.gsui", f57065w);
        this.f57072h.put("com.app99.driver", f57066x);
        this.f57073i.put(f57054l, f57067y);
        this.f57073i.put("com.sdu.didi.psnger", f57067y);
        this.f57073i.put(f57056n, f57067y);
        this.f57073i.put(f57057o, f57067y);
        this.f57073i.put("com.taxis99", f57068z);
        this.f57073i.put("com.sdu.didi.gsui", f57044A);
        this.f57073i.put("com.app99.driver", f57045B);
        this.f57073i.put("com.didi.es.psngr", f57046C);
        this.f57073i.put(f57062t, f57047D);
        this.f57074j.put(f57054l, f57048E);
        this.f57074j.put("com.sdu.didi.psnger", f57048E);
        this.f57074j.put(f57056n, f57048E);
        this.f57074j.put("com.sdu.didi.gsui", f57049F);
        this.f57075k = context.getApplicationContext();
    }

    public String getHttpDnsKey() {
        if (TextUtils.isEmpty(this.f57069e)) {
            Context context = this.f57075k;
            if (context != null) {
                this.f57069e = this.f57072h.get(context.getPackageName());
            }
            String terminalTag = NetEngine.getInstance().getTerminalTag();
            if (TextUtils.isEmpty(this.f57069e) && !TextUtils.isEmpty(terminalTag)) {
                this.f57069e = "HTTP_DNS_" + terminalTag;
            }
        }
        return this.f57069e;
    }

    public String getHttpTransReqKey() {
        if (TextUtils.isEmpty(this.f57070f)) {
            Context context = this.f57075k;
            if (context != null) {
                this.f57070f = this.f57073i.get(context.getPackageName());
            }
            String terminalTag = NetEngine.getInstance().getTerminalTag();
            if (TextUtils.isEmpty(this.f57070f) && !TextUtils.isEmpty(terminalTag)) {
                this.f57070f = "TRANS_" + terminalTag;
            }
        }
        return this.f57070f;
    }

    public String getHttpLogKey() {
        Context context;
        String terminalTag = NetEngine.getInstance().getTerminalTag();
        if (TextUtils.isEmpty(this.f57071g) && !TextUtils.isEmpty(terminalTag)) {
            this.f57071g = "didi_http_log_" + terminalTag;
        }
        if (TextUtils.isEmpty(this.f57071g) && (context = this.f57075k) != null) {
            this.f57071g = this.f57074j.get(context.getPackageName());
        }
        return this.f57071g;
    }

    static class SingletonHolder {
        static ApolloKeySwitcher INSTANCE = new ApolloKeySwitcher();

        SingletonHolder() {
        }
    }

    public static ApolloKeySwitcher getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
