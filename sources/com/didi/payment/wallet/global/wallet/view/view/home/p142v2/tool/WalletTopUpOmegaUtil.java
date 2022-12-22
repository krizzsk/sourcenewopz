package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletTopUpOmegaUtil;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletTopUpOmegaUtil */
/* compiled from: WalletTopUpOmegaUtil.kt */
public final class WalletTopUpOmegaUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/tool/WalletTopUpOmegaUtil$Companion;", "", "()V", "trackEvent", "", "eventId", "", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletTopUpOmegaUtil$Companion */
    /* compiled from: WalletTopUpOmegaUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackEvent(String str, HashMap<String, Object> hashMap) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            Intrinsics.checkNotNullParameter(hashMap, "map");
            hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            hashMap.put("pub_subbiz", "payment");
            hashMap.put(LogBase.KEY_UID, PayBaseParamUtil.getStringParam(ApplicationContextProvider.Companion.getContext(), "uid"));
            FinOmegaSDK.trackEvent(str, hashMap);
        }
    }
}
