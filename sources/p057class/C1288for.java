package p057class;

import com.didi.raven.config.RavenConfigKey;
import p054break.C1250do;
import p094this.C3133if;

/* renamed from: class.for */
/* compiled from: FadeShader */
public class C1288for extends C1286do {

    /* renamed from: a */
    private static final float[] f504a = {0.1f, 0.1f};

    /* renamed from: b */
    private static final float[] f505b = {3.0f, 3.0f};

    /* renamed from: c */
    private final int f506c;

    /* renamed from: d */
    private final int f507d;

    /* renamed from: e */
    private final float[] f508e = {0.0f, 0.0f};

    /* renamed from: f */
    private final C1250do f509f;

    public C1288for() {
        C1250do doVar = new C1250do(1000, 1200, f504a, f505b);
        this.f509f = doVar;
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\nuniform sampler2D iChannel0;\nvarying vec2 texCoord;\nuniform vec2 p;\nuniform vec2 q;\nvoid main() {\n    vec3 col = texture2D(iChannel0, texCoord).rgb;\n    float a = abs(((2.0 * texCoord.x) - 1.0) / (2.0 * q.x)) - ((1.0 - (2.0 * p.x) - (2.0 * q.x)) / (2.0 * q.x));\n    float b = abs(((2.0 * texCoord.y) - 1.0) / (2.0 * q.y)) - ((1.0 - (2.0 * p.y) - (2.0 * q.y)) / (2.0 * q.y));\n    vec3 newcol = mix(col.rgb, vec3(0), clamp(max(a,b), 0.0, 1.0));\n    gl_FragColor = vec4(newcol, 1.0);\n}");
        this.f506c = mo14157do(RavenConfigKey.PHONE);
        this.f507d = mo14157do("q");
        doVar.mo14073if();
    }

    /* renamed from: do */
    public void mo14158do(float f, float f2) {
        float[] fArr = this.f508e;
        fArr[0] = f;
        fArr[1] = f2;
    }

    /* renamed from: for  reason: not valid java name */
    public void m46132for() {
        float[] fArr = this.f509f.mo14071do();
        C1286do.m1006do(this.f506c, this.f508e);
        C1286do.m1006do(this.f507d, fArr);
    }

    /* renamed from: new  reason: not valid java name */
    public void m46133new() {
        this.f509f.m46120for();
    }
}
