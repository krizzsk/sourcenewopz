package com.didi.component.payway;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaywayGuidanceActivity.kt */
final class PaywayGuidanceActivity$initView$1 implements View.OnClickListener {
    final /* synthetic */ PaywayGuidanceActivity this$0;

    PaywayGuidanceActivity$initView$1(PaywayGuidanceActivity paywayGuidanceActivity) {
        this.this$0 = paywayGuidanceActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        FormStore.getInstance().setSkipEstimateGet(true);
        this.this$0.finish();
        this.this$0.overridePendingTransition(0, 0);
        GlobalSPUtil.savePaywayGuideShown(this.this$0);
        HashMap hashMap = new HashMap();
        hashMap.put("type", "pay_guide");
        hashMap.put("status", 1);
        GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_paymentnewlearn_close_ck", (Map<String, Object>) hashMap);
    }
}
