package p055case;

import org.json.JSONObject;
import p093switch.C3128try;

/* renamed from: case.a */
/* compiled from: EncoderFactors */
class C1266a {

    /* renamed from: a */
    private Double f446a;

    /* renamed from: b */
    private Integer f447b = 6144000;

    /* renamed from: c */
    private String f448c = null;

    /* renamed from: d */
    private Integer f449d = 30;

    /* renamed from: e */
    private Integer f450e = 50;

    C1266a() {
    }

    /* renamed from: a */
    public Double mo14130a() {
        return this.f446a;
    }

    /* renamed from: b */
    public Integer mo14132b() {
        return this.f447b;
    }

    /* renamed from: c */
    public String mo14133c() {
        return this.f448c;
    }

    /* renamed from: d */
    public Integer mo14134d() {
        return this.f449d;
    }

    /* renamed from: e */
    public Integer mo14135e() {
        return this.f450e;
    }

    /* renamed from: a */
    public void mo14131a(JSONObject jSONObject) {
        this.f447b = C3128try.m4073do(jSONObject, "video_bitrate", this.f447b);
        this.f449d = C3128try.m4073do(jSONObject, "frame_rate", this.f449d);
        this.f450e = C3128try.m4073do(jSONObject, "i_frame_interval", this.f450e);
        this.f446a = C3128try.m4071do(jSONObject, "video_quality", this.f446a);
        this.f448c = jSONObject.optString("video_profile", this.f448c);
    }
}
