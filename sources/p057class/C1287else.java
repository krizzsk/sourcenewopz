package p057class;

import p094this.C3133if;

/* renamed from: class.else */
/* compiled from: InclusionShader */
public class C1287else extends C1286do {

    /* renamed from: a */
    private int f500a = mo14157do("threshold");

    /* renamed from: b */
    private float f501b;

    /* renamed from: c */
    private int f502c = mo14157do("uWindow");

    /* renamed from: d */
    private float[] f503d;

    public C1287else(float f, float[] fArr) {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\n\nuniform sampler2D iChannel0;\nuniform vec2 uWindow;\nuniform float threshold;\n\nvarying vec2 texCoord;\n\nvoid main() {\n\n    vec2 offset = threshold / uWindow;\n\n    float bottomLeftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, offset.y)).r;\n    float topRightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, -offset.y)).r;\n    float topLeftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, -offset.y)).r;\n    float bottomRightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, offset.y)).r;\n    float leftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, 0.0)).r;\n    float rightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, 0.0)).r;\n    float bottomIntensity = texture2D(iChannel0, texCoord + vec2(0.0, offset.y)).r;\n    float topIntensity = texture2D(iChannel0, texCoord + vec2(0.0, -offset.y)).r;\n    float centerIntensity = texture2D(iChannel0, texCoord).r;\n\n    float pixelIntensitySum = bottomLeftIntensity + topRightIntensity + topLeftIntensity + bottomRightIntensity + leftIntensity + rightIntensity + bottomIntensity + topIntensity + centerIntensity;\n    float sumTest = step(1.5, pixelIntensitySum);\n    float pixelTest = step(0.01, centerIntensity);\n\n    gl_FragColor = vec4(vec3(sumTest * pixelTest, sumTest * pixelTest, sumTest * pixelTest), 1.0);\n\n}\n");
        this.f501b = f;
        this.f503d = fArr;
    }

    /* renamed from: for  reason: not valid java name */
    public void m46131for() {
        C1286do.m1005do(this.f500a, this.f501b);
        C1286do.m1006do(this.f502c, this.f503d);
    }
}
