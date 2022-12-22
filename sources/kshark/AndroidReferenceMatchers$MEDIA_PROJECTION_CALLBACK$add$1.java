package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "", "Lkshark/AndroidBuildMirror;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidReferenceMatchers.kt */
final class AndroidReferenceMatchers$MEDIA_PROJECTION_CALLBACK$add$1 extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
    public static final AndroidReferenceMatchers$MEDIA_PROJECTION_CALLBACK$add$1 INSTANCE = new AndroidReferenceMatchers$MEDIA_PROJECTION_CALLBACK$add$1();

    AndroidReferenceMatchers$MEDIA_PROJECTION_CALLBACK$add$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((AndroidBuildMirror) obj));
    }

    public final boolean invoke(AndroidBuildMirror androidBuildMirror) {
        Intrinsics.checkParameterIsNotNull(androidBuildMirror, "$receiver");
        int sdkInt = androidBuildMirror.getSdkInt();
        return 22 <= sdkInt && 28 >= sdkInt;
    }
}
