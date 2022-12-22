package com.didi.soda.customer.biz.popdialog;

import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.model.InstantConfig;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IInstantService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/customer/biz/popdialog/AppsFlyerHelperKt$instantAction$1", "Lcom/didi/soda/customer/biz/popdialog/SimpleAFConversionListener;", "onConversionDataSuccess", "", "p0", "", "", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyerHelper.kt */
public final class AppsFlyerHelperKt$instantAction$1 extends SimpleAFConversionListener {
    AppsFlyerHelperKt$instantAction$1() {
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        String str = "";
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("track key:");
                sb.append((String) next.getKey());
                sb.append(",value:");
                Object value = next.getValue();
                sb.append(value == null ? null : value.toString());
                String sb2 = sb.toString();
                if (sb2 == null) {
                    sb2 = str;
                }
                LogUtil.m29100d("Instant", sb2);
            }
        }
        IInstantService iInstantService = (IInstantService) CustomerServiceManager.getService(IInstantService.class);
        if (iInstantService != null) {
            InstantConfig instantConfig = iInstantService.getInstantConfig();
            CharSequence charSequence = instantConfig.instant_app;
            if (!(charSequence == null || charSequence.length() == 0)) {
                OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Instant.HAS_CLICK_INSTANT);
                String instantStr = iInstantService.getInstantStr();
                if (instantStr == null) {
                    instantStr = str;
                }
                OmegaTracker.Builder addEventParam = create.addEventParam(Const.InstantSP.INSTALL_DATA, instantStr);
                String lowerCase = Const.InstantSP.URL_STRING.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                String str2 = instantConfig.urlString;
                if (str2 != null) {
                    str = str2;
                }
                addEventParam.addEventParam(lowerCase, str).build().track();
                LogUtil.m29100d("Instant", "clear");
                ((IInstantService) CustomerServiceManager.getService(IInstantService.class)).clearInstantConfig();
            }
        }
    }
}
