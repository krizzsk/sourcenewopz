package com.didi.component.framework.pages.promo.presenter;

import com.didi.component.framework.pages.promo.helper.MapToSharePlatform;
import com.didi.component.framework.pages.promo.model.PromoApplyRsp;
import com.didi.component.framework.pages.promo.model.PromoData;
import com.didi.component.framework.pages.promo.model.WaiMaiVo;
import com.didi.component.framework.pages.promo.view.IPromoShowView;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/framework/pages/promo/presenter/PromoShowPresenter$applyPromoCode$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/google/gson/JsonObject;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoShowPresenter.kt */
public final class PromoShowPresenter$applyPromoCode$1 implements RpcService.Callback<JsonObject> {
    final /* synthetic */ PromoShowPresenter this$0;

    PromoShowPresenter$applyPromoCode$1(PromoShowPresenter promoShowPresenter) {
        this.this$0 = promoShowPresenter;
    }

    public void onSuccess(JsonObject jsonObject) {
        String errmsg;
        WaiMaiVo waiMaiVo;
        Integer errno;
        Intrinsics.checkNotNullParameter(jsonObject, "value");
        PromoApplyRsp promoApplyRsp = (PromoApplyRsp) new Gson().fromJson((JsonElement) jsonObject, PromoApplyRsp.class);
        boolean z = false;
        if (!(promoApplyRsp == null || (errno = promoApplyRsp.getErrno()) == null || errno.intValue() != 0)) {
            z = true;
        }
        String str = null;
        if (z) {
            PromoShowPresenter promoShowPresenter = this.this$0;
            PromoData data = promoApplyRsp.getData();
            if (promoShowPresenter.m9675a(data == null ? null : data.getWaiMaiVo())) {
                HashMap hashMap = new HashMap();
                Map map = hashMap;
                PromoData data2 = promoApplyRsp.getData();
                map.put("traceId", (data2 == null || (waiMaiVo = data2.getWaiMaiVo()) == null) ? null : waiMaiVo.getTraceId());
                IPromoShowView iPromoShowView = (IPromoShowView) this.this$0.mView;
                if (iPromoShowView != null) {
                    PromoShowPresenter promoShowPresenter2 = this.this$0;
                    PromoData data3 = promoApplyRsp.getData();
                    iPromoShowView.onApplyH5Success(promoShowPresenter2.m9676b(data3 == null ? null : data3.getWaiMaiVo()), hashMap);
                }
            } else {
                IPromoShowView iPromoShowView2 = (IPromoShowView) this.this$0.mView;
                if (iPromoShowView2 != null) {
                    iPromoShowView2.onApplySuccess(promoApplyRsp.getData());
                }
            }
        } else {
            IPromoShowView iPromoShowView3 = (IPromoShowView) this.this$0.mView;
            if (iPromoShowView3 != null) {
                String str2 = "";
                if (!(promoApplyRsp == null || (errmsg = promoApplyRsp.getErrmsg()) == null)) {
                    str2 = errmsg;
                }
                iPromoShowView3.onApplyError(str2);
            }
        }
        PromoShowPresenter promoShowPresenter3 = this.this$0;
        Integer errno2 = promoApplyRsp == null ? null : promoApplyRsp.getErrno();
        if (promoApplyRsp != null) {
            str = promoApplyRsp.getErrmsg();
        }
        promoShowPresenter3.m9674a(MapToSharePlatform.PROMO_VALUE_BACK, errno2, str);
        IPromoShowView iPromoShowView4 = (IPromoShowView) this.this$0.mView;
        if (iPromoShowView4 != null) {
            iPromoShowView4.hideLoadingView();
        }
    }

    public void onFailure(IOException iOException) {
        IPromoShowView iPromoShowView = (IPromoShowView) this.this$0.mView;
        if (iPromoShowView != null) {
            String string = ResourcesHelper.getString(this.this$0.getContext(), R.string.df_no_net_connected_toast);
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …ast\n                    )");
            iPromoShowView.onApplyError(string);
        }
        IPromoShowView iPromoShowView2 = (IPromoShowView) this.this$0.mView;
        if (iPromoShowView2 != null) {
            iPromoShowView2.hideLoadingView();
        }
    }
}
