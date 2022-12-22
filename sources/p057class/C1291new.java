package p057class;

import p094this.C3133if;

/* renamed from: class.new */
/* compiled from: FlashingShader */
public class C1291new extends C1286do {

    /* renamed from: a */
    private final int f510a = mo14157do("nextRGB");

    /* renamed from: b */
    private final int f511b = mo14157do("lineRGB");

    /* renamed from: c */
    private float[] f512c;

    /* renamed from: d */
    private float[] f513d;

    public C1291new(float[] fArr, float[] fArr2) {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\nvarying highp vec2 texCoord;\n\nuniform sampler2D iChannel0;\n\nuniform lowp vec3 nextRGB;\nuniform lowp vec3 lineRGB;\n\nvoid main()\n{\n    \n     lowp vec4 textureColor = texture2D(iChannel0, texCoord);\n    \n    gl_FragColor = vec4((lineRGB * textureColor.rgb * max(sign(1.0 - texCoord.y), 0.0)) \n                        + (nextRGB * (1.0 - textureColor.rgb) * max(sign(1.0 - texCoord.y), 0.0)) \n                        + (nextRGB * max(sign(texCoord.y - 1.0), 0.0))\n                        , 1.0);\n}\n");
        this.f512c = fArr;
        this.f513d = fArr2;
    }

    /* renamed from: do */
    public void mo14160do(float[] fArr) {
        this.f513d = fArr;
        C1286do.m1007if(this.f511b, fArr);
    }

    /* renamed from: for  reason: not valid java name */
    public void m46136for() {
        mo14160do(this.f513d);
        mo14161if(this.f512c);
    }

    /* renamed from: if */
    public void mo14161if(float[] fArr) {
        this.f512c = fArr;
        C1286do.m1007if(this.f510a, fArr);
    }
}
