package p057class;

import p094this.C3133if;

/* renamed from: class.if */
/* compiled from: CropShader */
public class C1290if extends C1286do {
    public C1290if() {
        this.f499do = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\nuniform mediump float scaleX;\nuniform mediump float scaleY;\nuniform mediump float offsetX;\nuniform mediump float offsetY;\n\nvarying vec2 texCoord;\nvarying vec2 croppedTexCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n    vec2 newTexCoord = vec2(texCoord.x, texCoord.y);\n\n    newTexCoord.y -= (1.0 - scaleY) * offsetY;\n    newTexCoord.x -= (1.0 - scaleX) *  offsetX;\n\n    newTexCoord.x /= scaleX;\n    newTexCoord.y /= scaleY;\n    croppedTexCoord = newTexCoord;\n}", "precision mediump float;\n\nuniform mediump sampler2D iChannel0;\nvarying mediump vec2 texCoord;\nvarying mediump vec2 croppedTexCoord;\n\nvoid main(){\n\n    if (croppedTexCoord.x > 1.0 || croppedTexCoord.y > 1.0 || croppedTexCoord.x < 0.0 || croppedTexCoord.y < 0.0) gl_FragColor = vec4(0,0,0,1);\n    else gl_FragColor = texture2D(iChannel0, croppedTexCoord);\n}");
    }

    /* renamed from: for  reason: not valid java name */
    public void m46135for() {
    }
}
