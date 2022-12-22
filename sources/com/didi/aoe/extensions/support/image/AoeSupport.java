package com.didi.aoe.extensions.support.image;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/AoeSupport;", "", "()V", "Companion", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: AoeSupport.kt */
public final class AoeSupport {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final native byte[] convertNV21ToARGB8888(byte[] bArr, int i, int i2);

    @JvmStatic
    public static final native byte[] cropABGR(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6);

    @JvmStatic
    public static final native byte[] rotateARGB(byte[] bArr, int i, int i2, int i3);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H JA\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H J)\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H ¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/aoe/extensions/support/image/AoeSupport$Companion;", "", "()V", "convertNV21ToARGB8888", "", "nv21Src", "srcWidth", "", "srcHeight", "cropABGR", "abgrSrc", "cropX", "cropY", "cropWidth", "cropHeight", "rotateARGB", "argbSrc", "degree", "support_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: AoeSupport.kt */
    public static final class Companion {
        @JvmStatic
        public final byte[] convertNV21ToARGB8888(byte[] bArr, int i, int i2) {
            return AoeSupport.convertNV21ToARGB8888(bArr, i, i2);
        }

        @JvmStatic
        public final byte[] cropABGR(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
            return AoeSupport.cropABGR(bArr, i, i2, i3, i4, i5, i6);
        }

        @JvmStatic
        public final byte[] rotateARGB(byte[] bArr, int i, int i2, int i3) {
            return AoeSupport.rotateARGB(bArr, i, i2, i3);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        System.loadLibrary("aoe_support");
    }
}
