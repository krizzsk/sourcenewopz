package p092super;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.didi.raven.config.RavenConfigKey;
import com.didi.raven.config.RavenKey;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.facebook.appevents.UserDataStore;
import com.iproov.sdk.core.C19900new;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import p092super.C3089break;
import p093switch.C3126this;
import p093switch.C3127throw;
import p232do.C20822goto;
import p232do.C20825this;

/* renamed from: super.try */
/* compiled from: LightingModel */
public class C3104try {

    /* renamed from: a */
    private static final String f6892a = ("🕯 " + C3104try.class.getSimpleName());

    /* renamed from: A */
    private Double f6893A = null;

    /* renamed from: B */
    private boolean f6894B = false;

    /* renamed from: C */
    private boolean f6895C = false;

    /* renamed from: D */
    private boolean f6896D = false;

    /* renamed from: E */
    private double f6897E = 1.0d;

    /* renamed from: F */
    private boolean f6898F = false;

    /* renamed from: G */
    private boolean f6899G = false;

    /* renamed from: H */
    private double f6900H = 0.0d;

    /* renamed from: I */
    private C3101if f6901I;

    /* renamed from: J */
    private C3101if f6902J;

    /* renamed from: b */
    private final C3097else f6903b;

    /* renamed from: c */
    private final C20822goto f6904c;

    /* renamed from: d */
    private final C3126this f6905d = new C3126this(0.4d);

    /* renamed from: e */
    private final C3126this f6906e = new C3126this(0.4d);

    /* renamed from: f */
    private Double f6907f = null;

    /* renamed from: g */
    private double f6908g = 0.01d;

    /* renamed from: h */
    private double f6909h = 0.0d;

    /* renamed from: i */
    private double f6910i = 0.0d;

    /* renamed from: j */
    private double f6911j = 1.8d;

    /* renamed from: k */
    private double f6912k = 100.0d;

    /* renamed from: l */
    private double f6913l = 0.0d;

    /* renamed from: m */
    private C20825this f6914m = null;

    /* renamed from: n */
    private boolean f6915n = false;

    /* renamed from: o */
    private boolean f6916o = false;

    /* renamed from: p */
    private boolean f6917p = false;

    /* renamed from: q */
    private C3089break f6918q;

    /* renamed from: r */
    private C3089break f6919r;

    /* renamed from: s */
    private C3089break f6920s;

    /* renamed from: t */
    private C3089break f6921t;

    /* renamed from: u */
    private C3089break f6922u;

    /* renamed from: v */
    private C3089break f6923v;

    /* renamed from: w */
    private C3089break f6924w;

    /* renamed from: x */
    private C3089break f6925x;

    /* renamed from: y */
    private double f6926y = 0.0d;

    /* renamed from: z */
    private double f6927z = 0.0d;

    C3104try(Context context, C3097else elseR, C20822goto gotoR) {
        this.f6904c = gotoR;
        this.f6903b = elseR;
        m3979i();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ double m3965a(double d, char c, double d2) throws C3096do {
        return d <= d2 ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ double m3966a(String str, C3089break.C3090do doVar) throws C3096do {
        return m3969b(doVar.m46188new());
    }

    /* renamed from: a */
    private double m3967a(C3089break breakR, String str) throws C3095case {
        try {
            return breakR.mo38561if(Constants.FILE_ANR_KEY, this.f6909h).mo38561if("c", m3982l()).mo38561if("e", this.f6926y).mo38561if("i", this.f6912k).mo38561if(CampaignValue.f40469b, this.f6911j).mo38561if(RavenKey.STACK, m3983m()).mo38561if("so", m3984n()).mo38561if(RavenKey.TYPE, this.f6908g).mo38561if(RavenKey.VERSION, this.f6927z).mo38562if("vo", this.f6893A).mo38561if("z", m3977g()).mo38555do(str);
        } catch (C3096do e) {
            throw new C3095case(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ double m3970b(double d, char c, double d2) throws C3096do {
        return d >= d2 ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ double m3971b(String str, C3089break.C3090do doVar) throws C3096do {
        return m3964a(doVar.m46188new());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ double m3972c(double d, char c, double d2) throws C3096do {
        return (1.0d == d || 1.0d == d2) ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ double m3974d(double d, char c, double d2) throws C3096do {
        return (1.0d == d && 1.0d == d2) ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ double m3975e(double d, char c, double d2) throws C3096do {
        return d < d2 ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ double m3976f(double d, char c, double d2) throws C3096do {
        return d > d2 ? 1.0d : 0.0d;
    }

    /* renamed from: g */
    private double m3977g() {
        Double d = this.f6904c.mo162093do();
        if (d == null) {
            return 1.0d;
        }
        return d.doubleValue();
    }

    /* renamed from: h */
    private C3089break m3978h() {
        return new C3089break().mo38558do("clamp", (C3089break.C3091for) $$Lambda$try$kozmd1uJiryx6KSmvIadJxruVQ.INSTANCE).mo38560do(new C3089break.C3093new(Typography.greater, 10, 10, 66, false, $$Lambda$try$Q3PRFwOYFZaSyUyUULJqkEDdcro.INSTANCE)).mo38560do(new C3089break.C3093new(Typography.less, 10, 10, 66, false, $$Lambda$try$aeqZ9oOdZGftGBc4HXyftfOVEk.INSTANCE)).mo38560do(new C3089break.C3093new(Typography.amp, 5, 5, 66, false, $$Lambda$try$kqP4vL7z98n6oRLBoOSnw9odGEo.INSTANCE)).mo38560do(new C3089break.C3093new('|', 5, 5, 66, false, $$Lambda$try$zL41xe9pXdqbnsOqqR_06aM93IM.INSTANCE)).mo38560do(new C3089break.C3093new(Typography.pound, 10, 10, 66, false, $$Lambda$try$E9G8bZUgcDOxXx_q7K0wTwdVbk.INSTANCE)).mo38560do(new C3089break.C3093new(Typography.euro, 10, 10, 66, false, $$Lambda$try$XdQ__PUdIdtNPoD4lqfa4y328xo.INSTANCE)).mo38558do("h", (C3089break.C3091for) new C3089break.C3091for() {
            /* renamed from: do */
            public final double mo38554do(String str, C3089break.C3090do doVar) {
                return C3104try.this.m3971b(str, doVar);
            }
        }).mo38558do("ho", (C3089break.C3091for) new C3089break.C3091for() {
            /* renamed from: do */
            public final double mo38554do(String str, C3089break.C3090do doVar) {
                return C3104try.this.m3966a(str, doVar);
            }
        }).mo38556do(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, C3100goto.m3947a()).mo38561if("F", this.f6913l);
    }

    /* renamed from: i */
    private void m3979i() {
        this.f6918q = m3978h();
        this.f6919r = m3978h();
        this.f6920s = m3978h();
        this.f6921t = m3978h();
        this.f6922u = m3978h();
        this.f6923v = m3978h();
        this.f6924w = m3978h();
        this.f6925x = m3978h();
    }

    /* renamed from: l */
    private double m3982l() {
        return ((Double) C3127throw.m4049do(this.f6905d.mo38626do(), Double.valueOf(-1.0d))).doubleValue();
    }

    /* renamed from: m */
    private double m3983m() {
        return ((Double) C3127throw.m4049do(this.f6906e.mo38626do(), Double.valueOf(-1.0d))).doubleValue();
    }

    /* renamed from: n */
    private double m3984n() {
        return ((Double) C3127throw.m4049do(this.f6907f, Double.valueOf(m3983m()))).doubleValue();
    }

    /* renamed from: p */
    private synchronized Map<String, Double> m3986p() {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put("F", Double.valueOf(this.f6913l));
        hashMap.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, Double.valueOf(C3100goto.m3947a()));
        hashMap.put(Constants.FILE_ANR_KEY, Double.valueOf(this.f6909h));
        hashMap.put("c", Double.valueOf(m3982l()));
        hashMap.put("e", Double.valueOf(this.f6926y));
        hashMap.put("hMedian", Double.valueOf(m3964a(0.5d)));
        hashMap.put("hoMedian", Double.valueOf(m3969b(0.5d)));
        hashMap.put("i", Double.valueOf(this.f6912k));
        double d = 1.0d;
        hashMap.put("qi", Double.valueOf(this.f6915n ? 1.0d : 0.0d));
        hashMap.put(CampaignValue.f40469b, Double.valueOf(this.f6911j));
        hashMap.put("qn", Double.valueOf(this.f6916o ? 1.0d : 0.0d));
        hashMap.put(RavenKey.STACK, Double.valueOf(m3983m()));
        hashMap.put("so", Double.valueOf(m3984n()));
        hashMap.put(RavenKey.TYPE, Double.valueOf(this.f6908g));
        hashMap.put("qt", Double.valueOf(this.f6917p ? 1.0d : 0.0d));
        hashMap.put(RavenKey.VERSION, Double.valueOf(this.f6927z));
        hashMap.put("z", Double.valueOf(m3977g()));
        hashMap.put("vo", this.f6893A);
        hashMap.put("tb", Double.valueOf(this.f6896D ? 1.0d : 0.0d));
        hashMap.put("tc", Double.valueOf(this.f6894B ? 1.0d : 0.0d));
        hashMap.put("tf", Double.valueOf(this.f6895C ? 1.0d : 0.0d));
        hashMap.put("sd", Double.valueOf(this.f6897E));
        hashMap.put("su", Double.valueOf(this.f6898F ? 1.0d : 0.0d));
        if (!this.f6899G) {
            d = 0.0d;
        }
        hashMap.put("sl", Double.valueOf(d));
        hashMap.put(RavenConfigKey.PHONE, Double.valueOf(this.f6900H));
        C20825this thisR = this.f6914m;
        if (thisR != null) {
            m3968a((Map<String, Double>) hashMap, "sa", thisR.m47634throw());
            m3968a((Map<String, Double>) hashMap, "sb", this.f6914m.m47636while());
            m3968a((Map<String, Double>) hashMap, "eb", this.f6914m.m47620case());
            m3968a((Map<String, Double>) hashMap, "mm", this.f6914m.m47622class());
            m3968a((Map<String, Double>) hashMap, "cs", this.f6914m.m47626for());
            m3968a((Map<String, Double>) hashMap, "sm", this.f6914m.m47625final());
            m3968a((Map<String, Double>) hashMap, "cc", this.f6914m.m47630new());
            m3968a((Map<String, Double>) hashMap, UserDataStore.STATE, this.f6914m.m47623const());
            m3968a((Map<String, Double>) hashMap, UserDataStore.CITY, this.f6914m.m47635try());
            m3968a((Map<String, Double>) hashMap, "gc", this.f6914m.m47633this());
            m3968a((Map<String, Double>) hashMap, "wb", this.f6914m.m47629native());
            m3968a((Map<String, Double>) hashMap, "dr", this.f6914m.m47628import());
            m3968a((Map<String, Double>) hashMap, "ma", this.f6914m.m47621catch());
            m3968a((Map<String, Double>) hashMap, "sf", this.f6914m.m47632super());
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo38604a() {
        return this.f6894B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo38606b() {
        return this.f6895C;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized boolean mo38608c() {
        return this.f6896D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized double mo38609d() {
        return this.f6897E;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized void mo38610e() {
        this.f6902J = this.f6901I;
        this.f6907f = this.f6906e.mo38626do();
        this.f6893A = Double.valueOf(this.f6927z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo38611f() {
        Map<String, Double> p = m3986p();
        return TextUtils.join("\n", new String[]{"<- tc: " + this.f6903b.m46195this(), "<- tf: " + this.f6903b.m46189break(), "<- tb: " + this.f6903b.m46193goto(), "<- sd: " + this.f6903b.m46196try(), "<- ev: " + this.f6903b.m46194new(), "<- su: " + this.f6903b.m46191else(), "<- sl: " + this.f6903b.m46190case(), "<- cl: " + this.f6903b.m46192for(), "A = " + C19900new.m39244if(p.get(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)), "F = " + C19900new.m39244if(p.get("F")) + " z = " + C19900new.m39244if(p.get("z")), "a = " + C19900new.m39244if(p.get(Constants.FILE_ANR_KEY)), "c = " + C19900new.m39244if(p.get("c")), "e = " + C19900new.m39244if(p.get("e")), "h[o](0.5) = " + C19900new.m39244if(p.get("hMedian")) + " [" + C19900new.m39244if(p.get("hoMedian")) + Const.jaRight, "i = " + C19900new.m39244if(p.get("i")), "n = " + C19900new.m39244if(p.get(CampaignValue.f40469b)), "s[o] = " + C19900new.m39244if(p.get(RavenKey.STACK)) + " [" + C19900new.m39244if(p.get("so")) + Const.jaRight, "t = " + C19900new.m39244if(p.get(RavenKey.TYPE)), "v[o] = " + C19900new.m39244if(p.get(RavenKey.VERSION)) + " [" + C19900new.m39244if(p.get("vo")) + Const.jaRight, "p = " + C19900new.m39244if(p.get(RavenConfigKey.PHONE)), "ld = " + C19900new.m39244if(p.get("ld")), "-> tc = " + C19900new.m39242do(p.get("tc")) + " tf = " + C19900new.m39242do(p.get("tf")) + " tb = " + C19900new.m39242do(p.get("tb")) + " sd = " + C19900new.m39242do(p.get("sd")) + " su = " + C19900new.m39242do(p.get("su")) + " sl = " + C19900new.m39242do(p.get("sl"))});
    }

    /* renamed from: b */
    private double m3969b(double d) {
        Double d2 = this.f6907f;
        if (d2 == null) {
            d2 = this.f6906e.mo38626do();
        }
        C3101if ifVar = this.f6902J;
        if (ifVar == null) {
            ifVar = this.f6901I;
        }
        if (d2 == null || ifVar == null) {
            return -1.0d;
        }
        return ((double) ifVar.mo38593do(d)) / 255.0d;
    }

    /* renamed from: j */
    private double m3980j() {
        double d = this.f6908g;
        double d2 = 0.0d;
        if (d > 0.0d) {
            double d3 = this.f6911j;
            if (d3 > 0.0d) {
                d2 = Math.log((d3 * d3) / d) / Math.log(2.0d);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("C.Lux calculateExposureValue: ");
        sb.append(d2);
        return d2;
    }

    /* renamed from: o */
    private void m3985o() throws C3095case {
        double a = m3967a(this.f6925x, this.f6903b.mo38579h());
        if (a < 0.0d || a > 100000.0d || this.f6908g > 10.0d) {
            String.format("C.Lux error: the value of %f is out of range!", new Object[]{Double.valueOf(a)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("C.Lux calculated: ");
        sb.append(a);
        this.f6905d.mo38627do(Double.valueOf(a));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo38605a(long j) throws C3095case {
        boolean z;
        double d = ((double) j) / 1000.0d;
        this.f6900H = d;
        z = m3967a(this.f6923v.mo38561if(RavenConfigKey.PHONE, d), this.f6903b.mo38575f()) == 1.0d;
        this.f6898F = z;
        return z;
    }

    /* renamed from: k */
    private double m3981k() {
        Double d = this.f6905d.mo38626do();
        if (d == null) {
            return -1.0d;
        }
        return Math.log(d.doubleValue()) / Math.log(2.0d);
    }

    /* renamed from: a */
    private double m3964a(double d) {
        C3101if ifVar;
        if (this.f6906e.mo38626do() == null || (ifVar = this.f6901I) == null) {
            return -1.0d;
        }
        return ((double) ifVar.mo38593do(d)) / 255.0d;
    }

    /* renamed from: a */
    private void m3968a(Map<String, Double> map, String str, Double d) {
        if (d != null && !d.isNaN() && !d.isInfinite()) {
            map.put(str, d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C3103this mo38599a(boolean z) throws C3095case {
        this.f6926y = m3980j();
        double d = this.f6910i;
        if (d == 0.0d) {
            d = m3981k();
        }
        this.f6927z = d;
        this.f6893A = Double.valueOf(d);
        if (z) {
            this.f6927z = m3967a(this.f6922u, this.f6903b.mo38573e());
        }
        m3985o();
        boolean z2 = true;
        this.f6894B = m3967a(this.f6919r, this.f6903b.mo38567a()) == 1.0d;
        this.f6895C = m3967a(this.f6918q, this.f6903b.mo38568b()) == 1.0d;
        if (m3967a(this.f6920s, this.f6903b.mo38570c()) != 1.0d) {
            z2 = false;
        }
        this.f6896D = z2;
        this.f6897E = m3967a(this.f6921t, this.f6903b.mo38572d());
        return new C3103this(m3986p());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo38607b(long j) throws C3095case {
        boolean z;
        double d = ((double) j) / 1000.0d;
        this.f6900H = d;
        z = m3967a(this.f6924w.mo38561if(RavenConfigKey.PHONE, d), this.f6903b.mo38577g()) == 1.0d;
        this.f6899G = z;
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo38600a(C20825this thisR) {
        StringBuilder sb = new StringBuilder();
        sb.append("C.Lux exifData: ");
        sb.append(thisR);
        this.f6909h = ((Double) C3127throw.m4049do(thisR.mo170645do(), Double.valueOf(0.0d))).doubleValue();
        Double d = thisR.m47619break();
        boolean z = true;
        this.f6915n = d != null;
        this.f6912k = ((Double) C3127throw.m4049do(d, Double.valueOf(100.0d))).doubleValue();
        Double d2 = thisR.m47631public();
        this.f6916o = d2 != null;
        this.f6911j = ((Double) C3127throw.m4049do(d2, Double.valueOf(1.8d))).doubleValue();
        this.f6910i = ((Double) C3127throw.m4049do(thisR.mo170650if(), Double.valueOf(0.0d))).doubleValue();
        Double d3 = thisR.m47624else();
        if (d3 == null) {
            z = false;
        }
        this.f6917p = z;
        this.f6908g = ((Double) C3127throw.m4049do(d3, Double.valueOf(0.01d))).doubleValue();
        this.f6913l = ((Double) C3127throw.m4049do(thisR.m47627goto(), Double.valueOf(this.f6913l))).doubleValue();
        this.f6914m = thisR;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo38601a(Double d) {
        if (d != null) {
            this.f6906e.mo38627do(d);
        } else {
            this.f6906e.mo38628if();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo38602a(Float f) {
        if (f != null) {
            this.f6913l = (double) f.floatValue();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo38603a(C3101if ifVar) {
        this.f6901I = ifVar;
    }
}
