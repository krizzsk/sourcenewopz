package p057class;

import p094this.C3133if;

/* renamed from: class.catch */
/* compiled from: SobelShader */
public class C1283catch extends C1286do {

    /* renamed from: a */
    private final int f485a = mo14157do("threshold");

    /* renamed from: b */
    private final float f486b;

    /* renamed from: c */
    private final int f487c = mo14157do("uWindow");

    /* renamed from: d */
    private final float[] f488d;

    public C1283catch(float f, float[] fArr) {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\n\nuniform sampler2D iChannel0;\nuniform vec2 uWindow;\nuniform float threshold;\n\nvarying vec2 texCoord;\n\nvoid main() {\n\n    vec2 offset = threshold / uWindow;\n\n    float bottomLeftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, offset.y)).r;\n    float topRightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, -offset.y)).r;\n    float topLeftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, -offset.y)).r;\n    float bottomRightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, offset.y)).r;\n    float leftIntensity = texture2D(iChannel0, texCoord + vec2(-offset.x, 0.0)).r;\n    float rightIntensity = texture2D(iChannel0, texCoord + vec2(offset.x, 0.0)).r;\n    float bottomIntensity = texture2D(iChannel0, texCoord + vec2(0.0, offset.y)).r;\n    float topIntensity = texture2D(iChannel0, texCoord + vec2(0.0, -offset.y)).r;\n\n    vec2 gradientDirection;\n    gradientDirection.x = -bottomLeftIntensity - 2.0 * leftIntensity - topLeftIntensity + bottomRightIntensity + 2.0 * rightIntensity + topRightIntensity;\n    gradientDirection.y = -topLeftIntensity - 2.0 * topIntensity - topRightIntensity + bottomLeftIntensity + 2.0 * bottomIntensity + bottomRightIntensity;\n\n    float gradientMagnitude = length(gradientDirection);\n    vec2 normalizedDirection = normalize(gradientDirection);\n\n    normalizedDirection = sign(normalizedDirection) * floor(abs(normalizedDirection) + 0.617316);\n    normalizedDirection = (normalizedDirection + 1.0) * 0.5;\n\n    gl_FragColor = vec4(gradientMagnitude, normalizedDirection.x, normalizedDirection.y, 1.0);\n}\n");
        this.f486b = f;
        this.f488d = fArr;
    }

    /* renamed from: for  reason: not valid java name */
    public void m46126for() {
        C1286do.m1005do(this.f485a, this.f486b);
        C1286do.m1006do(this.f487c, this.f488d);
    }
}
