package com.didi.component.substitute.call.present;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.substitute.call.addPassenger.AddPassengerActivity;
import com.didi.component.substitute.call.contacts.SubstituteCallHistorySheet;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "style", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallPresent.kt */
final class SubstituteCallPresent$mOpenHistoryLis$1<T> implements BaseEventPublisher.OnEventListener {
    final /* synthetic */ SubstituteCallPresent this$0;

    SubstituteCallPresent$mOpenHistoryLis$1(SubstituteCallPresent substituteCallPresent) {
        this.this$0 = substituteCallPresent;
    }

    public final void onEvent(String str, Integer num) {
        Context access$getMContext$p$s1395138403;
        if (num != null && num.intValue() == 1) {
            SubstituteCallHistorySheet newInstance = SubstituteCallHistorySheet.Companion.newInstance();
            Context access$getMContext$p$s13951384032 = this.this$0.mContext;
            if (access$getMContext$p$s13951384032 != null) {
                newInstance.show(((FragmentActivity) access$getMContext$p$s13951384032).getSupportFragmentManager(), "substitute_call_history_sheet");
                Map hashMap = new HashMap();
                hashMap.put("k", "access");
                hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "history_list_page");
                GlobalOmegaUtils.trackEvent("ibt_gp_history_list_page_sw", (Map<String, Object>) hashMap);
            }
        } else if (num != null && num.intValue() == 0 && (access$getMContext$p$s1395138403 = this.this$0.mContext) != null) {
            this.this$0.startActivity(AddPassengerActivity.Companion.getIntent(access$getMContext$p$s1395138403));
        }
    }
}
