package p057class;

import p094this.C3133if;

/* renamed from: class.break */
/* compiled from: ShadeShader */
public class C1281break extends C1286do {

    /* renamed from: a */
    private final int f481a = mo14157do("blend");

    /* renamed from: b */
    private final float[] f482b;

    public C1281break(float f, int i, int i2) {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\nuniform mediump float scaleX;\nuniform mediump float scaleY;\nuniform mediump float offsetX;\nuniform mediump float offsetY;\n\nvarying vec2 texCoord;\nvarying vec2 croppedTexCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n    vec2 newTexCoord = vec2(texCoord.x, texCoord.y);\n\n    newTexCoord.y -= (1.0 - scaleY) * offsetY;\n    newTexCoord.x -= (1.0 - scaleX) *  offsetX;\n\n    newTexCoord.x /= scaleX;\n    newTexCoord.y /= scaleY;\n    croppedTexCoord = newTexCoord;\n}", "precision highp float;\nuniform sampler2D iChannel0;\nuniform sampler2D iChannel1;\nuniform vec4 blend;\n\nvarying vec2 texCoord;\nvarying vec2 croppedTexCoord;\n\nvoid main(void) {\n\n    float step1 = 0.8;\n    float step2 = 0.6;\n    float step3 = 0.3;\n    float step4 = 0.15;\n    float alpha = 1.0;\n\n    vec3 shade = vec3(1.0);\n    vec4 color = vec4(1.0);\n\n    vec4 texelLines = texture2D(iChannel0, texCoord);\n    vec4 texelShade = texture2D(iChannel1, croppedTexCoord );\n\n    float brightness = (0.2126 * texelShade.r) + (0.7152 * texelShade.g) + (0.0722 * texelShade.b);\n    float brightest = max(max(texelShade.r, texelShade.g), texelShade.b);\n    float dimmest = min(min(texelShade.r, texelShade.g), texelShade.b);\n    float delta = brightest - dimmest;\n\n    if (delta > 0.1) {\n        texelShade = texelShade * (1.0 / brightest);\n    } else {\n        texelShade.rgb = vec3(1.0);\n    }\n\n    if (brightness < step1) {\n        shade = vec3(texelShade.rgb * step1);\n    }\n\n    if (brightness < step2) {\n        shade = vec3(texelShade.rgb * step2);\n    }\n\n    if (brightness < step3) {\n        shade = vec3(texelShade.rgb * step3);\n    }\n\n    if (brightness < step4) {\n        shade = vec3(texelShade.rgb * step4);\n    }\n\n    if (texelLines.rgb == vec3(0.0)) {\n        color = 1.0 - vec4(mix(shade, blend.rgb, blend.a), 0.0);\n    }\n\n    gl_FragColor = color;\n\n}\n");
        this.f482b = new float[]{1.0f, 1.0f, 1.0f, f};
    }

    /* renamed from: a */
    private void m1002a() {
        C1286do.m46129for(this.f481a, this.f482b);
    }

    /* renamed from: do */
    public void mo14153do(float f) {
        this.f482b[3] = f;
    }

    /* renamed from: for  reason: not valid java name */
    public void m46124for() {
        m1002a();
    }

    /* renamed from: if */
    public boolean mo14155if() {
        return true;
    }
}
