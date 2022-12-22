package p057class;

import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import p056catch.C1279do;
import p094this.C3133if;

/* renamed from: class.this */
/* compiled from: ScannerShader */
public class C1292this extends C1286do {

    /* renamed from: a */
    private final int f514a = mo14157do(SameLayerRenderingUtil.KEY_COMP_Y);

    /* renamed from: b */
    private Float f515b;

    /* renamed from: c */
    private C1279do f516c;

    public C1292this() {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\nuniform sampler2D iChannel0;\nvarying vec2 texCoord;\nuniform float y;\nvoid main() {\n    float colorAdd = step(0.995, 1. - abs(texCoord.y - y));\n    gl_FragColor = vec4(texture2D(iChannel0, texCoord).rgb + colorAdd, 1.);\n}");
    }

    /* renamed from: do */
    public void mo14162do(float f, long j) {
        C1279do doVar = new C1279do(j, this.f515b, Float.valueOf(f));
        this.f516c = doVar;
        doVar.mo14152if();
    }

    /* renamed from: for  reason: not valid java name */
    public void m46137for() {
        C1279do doVar = this.f516c;
        if (doVar != null) {
            m1014a(((Float) doVar.mo14151do()).floatValue());
        } else if (this.f515b == null) {
            m1014a(-1.0f);
        }
    }

    /* renamed from: a */
    private void m1014a(float f) {
        Float valueOf = Float.valueOf(f);
        this.f515b = valueOf;
        C1286do.m1005do(this.f514a, 1.0f - valueOf.floatValue());
    }
}
