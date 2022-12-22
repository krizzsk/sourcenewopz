package kotlin.reflect.jvm.internal.impl.renderer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DescriptorRenderer.kt */
public enum RenderingFormat {
    ;

    public abstract String escape(String str);

    /* compiled from: DescriptorRenderer.kt */
    static final class PLAIN extends RenderingFormat {
        public String escape(String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            return str;
        }

        PLAIN(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    static final class HTML extends RenderingFormat {
        HTML(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
        }

        public String escape(String str) {
            Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
            return StringsKt.replace$default(StringsKt.replace$default(str, IMTextUtils.STREET_IMAGE_TAG_START, "&lt;", false, 4, (Object) null), IMTextUtils.STREET_IMAGE_TAG_END, "&gt;", false, 4, (Object) null);
        }
    }
}
