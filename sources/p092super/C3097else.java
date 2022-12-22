package p092super;

import android.content.Context;
import kotlin.text.Typography;
import org.json.JSONObject;
import p066native.C2381if;
import p093switch.C3128try;

/* renamed from: super.else */
/* compiled from: LightingModelParameters */
public class C3097else {

    /* renamed from: a */
    private String f6874a = "s > 0.9";

    /* renamed from: b */
    private String f6875b = "s < 0.55";

    /* renamed from: c */
    private String f6876c = "(i*A)<(400*(v+4)*(11-s)^2)";

    /* renamed from: d */
    private String f6877d = "clamp(0.5*(c*h(0.75)^2),0.95,1)";

    /* renamed from: e */
    private String f6878e = "vo*(1+(min(abs(h(0.5)-ho(0.5)),0.6)))";

    /* renamed from: f */
    private String f6879f = "(s<0) || (p > 5) || (abs(h(0.5)-ho(0.5))>0.3 && p > 2)";

    /* renamed from: g */
    private String f6880g = "p > 4";

    /* renamed from: h */
    private String f6881h = "(3*n^2)/(t*i)";

    private C3097else(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f6874a = m3929a(str, "s > 0.9", str8);
        this.f6875b = m3929a(str2, this.f6875b, str8);
        this.f6876c = m3929a(str3, this.f6876c, str8);
        this.f6877d = m3929a(str4, this.f6877d, str8);
        this.f6878e = m3929a(str5, this.f6878e, str8);
        this.f6879f = m3929a(str6, this.f6879f, str8);
        this.f6880g = m3929a(str7, this.f6880g, str8);
        this.f6881h = m3929a(str8, this.f6881h, str8);
    }

    /* renamed from: a */
    private String m3929a(String str, String str2, String str3) {
        return (str == null || str3 == null) ? str2 : str;
    }

    /* renamed from: do */
    public static C3097else m3930do(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        C2381if ifVar = new C2381if(context);
        String str = ifVar.m46155this();
        String str2 = ifVar.m46152goto();
        String str3 = ifVar.m46144break();
        String str4 = ifVar.m46157try();
        String str5 = ifVar.m46153new();
        String str6 = ifVar.m46149else();
        String str7 = ifVar.m46145case();
        String str8 = ifVar.m46151for();
        if (str == null) {
            str = C3128try.m4081if(jSONObject2, "tc");
        }
        String str9 = str;
        if (str3 == null) {
            str3 = C3128try.m4081if(jSONObject2, "tf");
        }
        String str10 = str3;
        if (str2 == null) {
            str2 = C3128try.m4081if(jSONObject2, "tb");
        }
        String str11 = str2;
        if (str4 == null) {
            str4 = C3128try.m4081if(jSONObject2, "sd");
        }
        String str12 = str4;
        if (str5 == null) {
            str5 = C3128try.m4081if(jSONObject2, "ev");
        }
        String str13 = str5;
        if (str6 == null) {
            str6 = C3128try.m4081if(jSONObject2, "su");
        }
        String str14 = str6;
        if (str7 == null) {
            str7 = C3128try.m4081if(jSONObject2, "sl");
        }
        String str15 = str7;
        if (str8 == null) {
            str8 = C3128try.m4081if(jSONObject2, "cl");
        }
        return new C3097else(str9, str10, str11, str12, str13, str14, str15, str8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo38567a() {
        return m3928a(this.f6874a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo38568b() {
        return m3928a(this.f6875b);
    }

    /* renamed from: break  reason: not valid java name */
    public String m46189break() {
        return this.f6875b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo38570c() {
        return m3928a(this.f6876c);
    }

    /* renamed from: case  reason: not valid java name */
    public String m46190case() {
        return this.f6880g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo38572d() {
        return m3928a(this.f6877d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo38573e() {
        return m3928a(this.f6878e);
    }

    /* renamed from: else  reason: not valid java name */
    public String m46191else() {
        return this.f6879f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo38575f() {
        return m3928a(this.f6879f);
    }

    /* renamed from: for  reason: not valid java name */
    public String m46192for() {
        return this.f6881h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo38577g() {
        return m3928a(this.f6880g);
    }

    /* renamed from: goto  reason: not valid java name */
    public String m46193goto() {
        return this.f6876c;
    }

    /* renamed from: new  reason: not valid java name */
    public String m46194new() {
        return this.f6878e;
    }

    /* renamed from: this  reason: not valid java name */
    public String m46195this() {
        return this.f6874a;
    }

    public String toString() {
        return "LightingModelParameters{tooCloseExpression='" + mo38567a() + '\'' + ", tooFarExpression='" + mo38568b() + '\'' + ", tooBrightExpression='" + mo38570c() + '\'' + ", screenBrightnessExpression='" + mo38572d() + '\'' + ", estimatedBrightnessExpression='" + mo38573e() + '\'' + ", shouldUnlockAndPhotoExpression='" + mo38575f() + '\'' + ", shouldLockAndPhotoExpression='" + mo38577g() + '\'' + ", cluxExpression='" + mo38579h() + '\'' + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public String m46196try() {
        return this.f6877d;
    }

    /* renamed from: a */
    private static String m3928a(String str) {
        return str.replace("&&", String.valueOf(Typography.amp)).replace("||", String.valueOf('|')).replace("<=", String.valueOf(Typography.euro)).replace(">=", String.valueOf(Typography.pound));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo38579h() {
        return m3928a(this.f6881h);
    }
}
