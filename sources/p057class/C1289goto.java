package p057class;

import p094this.C3133if;

/* renamed from: class.goto */
/* compiled from: LuminanceShader */
public class C1289goto extends C1286do {
    public C1289goto() {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "precision highp float;\n\nconst vec3 W = vec3(0.2125, 0.7154, 0.0721);\n\nuniform sampler2D iChannel0;\n\nvarying vec2 texCoord;\n\nvoid main() {\n\n    vec4 textureColor = texture2D(iChannel0, texCoord);\n    float luminance = dot(textureColor.rgb, W);\n\n    gl_FragColor = vec4(vec3(luminance), textureColor.a);\n\n}\n");
    }

    /* renamed from: for  reason: not valid java name */
    public void m46134for() {
    }
}
