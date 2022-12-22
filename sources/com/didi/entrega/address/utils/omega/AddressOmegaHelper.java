package com.didi.entrega.address.utils.omega;

import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J.\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/entrega/address/utils/omega/AddressOmegaHelper;", "", "()V", "trackDeliverySearchExposureSw", "", "from_page", "", "hasNearbyAddress", "", "sodaAddressCount", "entregaAddressCount", "trackDeliverySearchInputCk", "trackDeliverySearchResultCk", "search_term", "", "result_num", "index", "clickType", "fromPage", "trackDeliverySearchResultSw", "trackDeliverySearchResultToastSw", "toast_type", "trackDeliverySearchReturnCK", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressOmegaHelper.kt */
public final class AddressOmegaHelper {
    public static final AddressOmegaHelper INSTANCE = new AddressOmegaHelper();

    private AddressOmegaHelper() {
    }

    public final void trackDeliverySearchExposureSw(int i, boolean z, int i2, int i3) {
        int i4 = z ? 1 : 2;
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Address.SAILING_C_E_DELIVERYPAGE_SEARCH_COMMON_SW);
        create.addEventParam("from_page", Integer.valueOf(i));
        create.addEventParam(ParamConst.HAS_NEARBY, Integer.valueOf(i4));
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append(',');
        sb.append(i2);
        create.addEventParam("record_cnt", sb.toString());
        create.build().track();
    }

    public final void trackDeliverySearchInputCk() {
        OmegaTracker.Builder.create(EventConst.Address.SAILING_C_E_DELIVERYPAGE_SEARCH_INPUT_CK).build().track();
    }

    public final void trackDeliverySearchResultSw(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "search_term");
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Address.SAILING_C_E_DELIVERYPAGE_SEARCH_RESULT_SW);
        create.addEventParam("search_term", str);
        create.addEventParam("result_num", Integer.valueOf(i));
        create.build().track();
    }

    public final void trackDeliverySearchResultCk(String str, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "search_term");
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Address.SAILING_C_E_DELIVERYPAGE_SEARCH_RESULT_CK);
        create.addEventParam("search_term", str);
        create.addEventParam("result_num", Integer.valueOf(i));
        create.addEventParam("index", Integer.valueOf(i2));
        create.addEventParam("from_page", Integer.valueOf(i4));
        create.addEventParam("click_type", Integer.valueOf(i3));
        create.build().track();
    }

    public final void trackDeliverySearchResultToastSw(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "search_term");
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Address.SAILING_C_E_DELIVERYPAGE_SEARCH_TOAST_SW);
        create.addEventParam("search_term", str);
        create.addEventParam(ParamConst.TOAST_TYPE, Integer.valueOf(i));
        create.addEventParam("from_page", Integer.valueOf(i2));
        create.build().track();
    }

    public final void trackDeliverySearchReturnCK(int i) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Address.SAILING_C_E_DELIVERYPAGE_SEARCH_RETURN_CK);
        create.addEventParam("from_page", Integer.valueOf(i));
        create.build().track();
    }
}
