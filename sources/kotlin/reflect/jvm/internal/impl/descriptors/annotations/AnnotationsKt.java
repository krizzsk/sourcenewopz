package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.didi.sdk.push.ServerParam;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Annotations.kt */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations annotations, Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations, ServerParam.PARAM_FIRST);
        Intrinsics.checkNotNullParameter(annotations2, "second");
        if (annotations.isEmpty()) {
            return annotations2;
        }
        if (annotations2.isEmpty()) {
            return annotations;
        }
        return new CompositeAnnotations(annotations, annotations2);
    }
}
