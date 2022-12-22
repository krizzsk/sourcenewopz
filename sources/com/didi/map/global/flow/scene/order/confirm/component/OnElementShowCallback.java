package com.didi.map.global.flow.scene.order.confirm.component;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/component/OnElementShowCallback;", "", "onBubbleAvoidSuccess", "", "onBubbleShowSuccess", "onLineShowSuccess", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OnElementShowCallback.kt */
public interface OnElementShowCallback {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OnElementShowCallback.kt */
    public static final class DefaultImpls {
        public static void onBubbleAvoidSuccess(OnElementShowCallback onElementShowCallback) {
            Intrinsics.checkNotNullParameter(onElementShowCallback, "this");
        }

        public static void onBubbleShowSuccess(OnElementShowCallback onElementShowCallback) {
            Intrinsics.checkNotNullParameter(onElementShowCallback, "this");
        }

        public static void onLineShowSuccess(OnElementShowCallback onElementShowCallback) {
            Intrinsics.checkNotNullParameter(onElementShowCallback, "this");
        }
    }

    void onBubbleAvoidSuccess();

    void onBubbleShowSuccess();

    void onLineShowSuccess();
}
