package com.wallet.flutter.wallet_flutter.function;

import com.didi.drouter.api.Extend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterToTopUpCreateOrder.kt */
final class FlutterToTopUpCreateOrder$requestCode$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ FlutterToTopUpCreateOrder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlutterToTopUpCreateOrder$requestCode$2(FlutterToTopUpCreateOrder flutterToTopUpCreateOrder) {
        super(0);
        this.this$0 = flutterToTopUpCreateOrder;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.this$0.getActivity().getIntent().getIntExtra(Extend.START_ACTIVITY_REQUEST_CODE, -1));
    }
}
