package com.wallet.flutter.wallet_flutter.function;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Observer;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingRenderType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, mo175979k = 3, mo175980mv = {1, 5, 1})
/* compiled from: LiveData.kt */
public final class FlutterToTopUpCreateOrder$createOrder$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ FlutterToTopUpCreateOrder this$0;

    public FlutterToTopUpCreateOrder$createOrder$$inlined$observe$1(FlutterToTopUpCreateOrder flutterToTopUpCreateOrder) {
        this.this$0 = flutterToTopUpCreateOrder;
    }

    public final void onChanged(T t) {
        Boolean bool = (Boolean) t;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            Context baseContext = this.this$0.getActivity().getBaseContext();
            LoadingRenderType loadingRenderType = LoadingRenderType.ANIMATION;
            View access$getRootView$p = this.this$0.f56049a;
            if (access$getRootView$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
                access$getRootView$p = null;
            }
            Loading.make(baseContext, loadingRenderType, access$getRootView$p, true, 48).show();
            return;
        }
        Loading.hide();
    }
}
