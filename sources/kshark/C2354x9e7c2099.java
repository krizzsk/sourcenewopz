package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "", "Lkshark/AndroidBuildMirror;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* renamed from: kshark.AndroidReferenceMatchers$MEDIA_SESSION_LEGACY_HELPER__SINSTANCE$add$1 */
/* compiled from: AndroidReferenceMatchers.kt */
final class C2354x9e7c2099 extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
    public static final C2354x9e7c2099 INSTANCE = new C2354x9e7c2099();

    C2354x9e7c2099() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
    }

    public final boolean invoke(AndroidBuildMirror androidBuildMirror) {
        Intrinsics.checkParameterIsNotNull(androidBuildMirror, "$receiver");
        return androidBuildMirror.getSdkInt() == 21;
    }
}
