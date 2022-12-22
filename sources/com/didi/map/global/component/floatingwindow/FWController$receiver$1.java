package com.didi.map.global.component.floatingwindow;

import com.didi.map.global.component.floatingwindow.OrientationStateChangeCallback;
import com.didi.map.global.component.floatingwindow.util.C9502Util;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/map/global/component/floatingwindow/FWController$receiver$1", "Lcom/didi/map/global/component/floatingwindow/OrientationStateChangeCallback;", "stateChange", "", "state", "Lcom/didi/map/global/component/floatingwindow/OrientationStateChangeCallback$OrientationState;", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FWController.kt */
public final class FWController$receiver$1 implements OrientationStateChangeCallback {
    final /* synthetic */ FWController this$0;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FWController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OrientationStateChangeCallback.OrientationState.values().length];
            iArr[OrientationStateChangeCallback.OrientationState.VERTICAL.ordinal()] = 1;
            iArr[OrientationStateChangeCallback.OrientationState.OTHER.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    FWController$receiver$1(FWController fWController) {
        this.this$0 = fWController;
    }

    public void stateChange(OrientationStateChangeCallback.OrientationState orientationState) {
        Intrinsics.checkNotNullParameter(orientationState, "state");
        SystemUtils.log(3, C9502Util.TAG, Intrinsics.stringPlus("stateChange: state=", orientationState), (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController$receiver$1", 145);
        int i = WhenMappings.$EnumSwitchMapping$0[orientationState.ordinal()];
        if (i != 1 && i != 2) {
            this.this$0.m18304j();
        } else if (this.this$0.f25583G) {
            this.this$0.m18303i();
        }
    }
}
