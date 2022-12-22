package p057class;

import p094this.C3133if;

/* renamed from: class.class */
/* compiled from: SupressionShader */
public class C1284class extends C1286do {

    /* renamed from: a */
    private final int f489a = mo14157do("upperThreshold");

    /* renamed from: b */
    private final int f490b = mo14157do("lowerThreshold");

    /* renamed from: c */
    private final int f491c = mo14157do("texelHeight");

    /* renamed from: d */
    private final int f492d = mo14157do("texelWidth");

    /* renamed from: e */
    private final float f493e;

    /* renamed from: f */
    private final float f494f;

    /* renamed from: g */
    private final float f495g;

    /* renamed from: h */
    private final float f496h;

    public C1284class(float f, float f2, float f3, float f4) {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\n\nuniform sampler2D iChannel0;\nuniform highp float texelWidth;\nuniform highp float texelHeight;\nuniform mediump float upperThreshold;\nuniform mediump float lowerThreshold;\n\nvarying highp vec2 texCoord;\n\nvoid main() {\n\n    vec3 currentGradientAndDirection = texture2D(iChannel0, texCoord).rgb;\n    vec2 gradientDirection = ((currentGradientAndDirection.gb * 2.0) - 1.0) * vec2(texelWidth, texelHeight);\n\n    float firstSampledGradientMagnitude = texture2D(iChannel0, texCoord + gradientDirection).r;\n    float secondSampledGradientMagnitude = texture2D(iChannel0, texCoord - gradientDirection).r;\n\n    float multiplier = step(firstSampledGradientMagnitude, currentGradientAndDirection.r);\n    multiplier = multiplier * step(secondSampledGradientMagnitude, currentGradientAndDirection.r);\n\n    float thresholdCompliance = smoothstep(lowerThreshold, upperThreshold, currentGradientAndDirection.r);\n    multiplier = multiplier * thresholdCompliance;\n\n    gl_FragColor = vec4(multiplier, multiplier, multiplier, 1.0);\n\n}\n");
        this.f493e = f;
        this.f494f = f2;
        this.f496h = f3;
        this.f495g = f4;
    }

    /* renamed from: for  reason: not valid java name */
    public void m46127for() {
        C1286do.m1005do(this.f489a, this.f493e);
        C1286do.m1005do(this.f490b, this.f494f);
        C1286do.m1005do(this.f491c, this.f495g);
        C1286do.m1005do(this.f492d, this.f496h);
    }
}
