package p057class;

import com.didi.raven.config.RavenKey;
import p094this.C3133if;

/* renamed from: class.const */
/* compiled from: VerticalBlurShader */
public class C1285const extends C1286do {

    /* renamed from: a */
    private final int f497a;

    /* renamed from: b */
    private final float f498b;

    public C1285const(float f) {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\n\nuniform sampler2D iChannel0;\nuniform float v;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    \n    vec4 sum = vec4( 0.0 );\n    \n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y - 4.0 * v ) ) * 0.0276305489;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y - 3.0 * v ) ) * 0.0662822425;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y - 2.0 * v ) ) * 0.123831533;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y - 1.0 * v ) ) * 0.180173814;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y ) ) * 0.204163685;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y + 1.0 * v ) ) * 0.180173814;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y + 2.0 * v ) ) * 0.123831533;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y + 3.0 * v ) ) * 0.0662822425;\n    sum += texture2D( iChannel0, vec2( texCoord.x, texCoord.y + 4.0 * v ) ) * 0.0276305489;\n    \n    gl_FragColor = sum;\n    \n}\n");
        this.f498b = f;
        int i = mo14157do(RavenKey.VERSION);
        this.f497a = i;
        C1286do.m1005do(i, f);
    }

    /* renamed from: for  reason: not valid java name */
    public void m46128for() {
        C1286do.m1005do(this.f497a, this.f498b);
    }
}
