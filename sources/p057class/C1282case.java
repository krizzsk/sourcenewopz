package p057class;

import p094this.C3133if;

/* renamed from: class.case */
/* compiled from: HorizontalBlurShader */
public class C1282case extends C1286do {

    /* renamed from: a */
    private final int f483a = mo14157do("h");

    /* renamed from: b */
    private final float f484b;

    public C1282case(float f) {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\n\nuniform sampler2D iChannel0;\nuniform float h;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    \n    vec4 sum = vec4( 0.0 );\n    \n    sum += texture2D( iChannel0, vec2( texCoord.x - 4.0 * h, texCoord.y ) ) * 0.0276305489;\n    sum += texture2D( iChannel0, vec2( texCoord.x - 3.0 * h, texCoord.y ) ) * 0.0662822425;\n    sum += texture2D( iChannel0, vec2( texCoord.x - 2.0 * h, texCoord.y ) ) * 0.123831533;\n    sum += texture2D( iChannel0, vec2( texCoord.x - 1.0 * h, texCoord.y ) ) * 0.180173814;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y ) ) * 0.204163685;\n    sum += texture2D( iChannel0, vec2( texCoord.x + 1.0 * h, texCoord.y ) ) * 0.180173814;\n    sum += texture2D( iChannel0, vec2( texCoord.x + 2.0 * h, texCoord.y ) ) * 0.123831533;\n    sum += texture2D( iChannel0, vec2( texCoord.x + 3.0 * h, texCoord.y ) ) * 0.0662822425;\n    sum += texture2D( iChannel0, vec2( texCoord.x + 4.0 * h, texCoord.y ) ) * 0.0276305489;\n    \n    gl_FragColor = sum;\n    \n}\n");
        this.f484b = f;
    }

    /* renamed from: for  reason: not valid java name */
    public void m46125for() {
        C1286do.m1005do(this.f483a, this.f484b);
    }
}
