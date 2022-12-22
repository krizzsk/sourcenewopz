package com.didiglobal.pay.paysecure.prepaidcard;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.pay.paysecure.prepaidcard.loading.ILoading;
import com.didiglobal.pay.paysecure.prepaidcard.loading.LineLoading;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: CardPwdManagerFragment.kt */
final class CardPwdManagerFragment$onViewCreated$3 implements View.OnClickListener {
    final /* synthetic */ CardPwdManagerFragment this$0;

    CardPwdManagerFragment$onViewCreated$3(CardPwdManagerFragment cardPwdManagerFragment) {
        this.this$0 = cardPwdManagerFragment;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("source", "10");
        linkedHashMap.put("scene", PrepaidConstant.SCENE_FORGET_PASSWORD);
        linkedHashMap.put("pre_apply", "0");
        linkedHashMap.put("full_kyc", "6");
        linkedHashMap.put(BaseCard.KEY_CARD_ID, this.this$0.getCardId());
        Request build = DRouter.build(UrlUtils.Companion.buildParamsUrl(PrepaidCardManager.PREPAID_CARD_URL, linkedHashMap));
        Intrinsics.checkExpressionValueIsNotNull(build, "DRouter.build(linkUrl)");
        RouterCallback cardPwdManagerFragment$onViewCreated$3$callback$1 = new CardPwdManagerFragment$onViewCreated$3$callback$1(this);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            LineLoading cardLoading = this.this$0.getCardLoading();
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            ILoading.DefaultImpls.showLoading$default(cardLoading, activity, this.this$0.getTitleBar(), (String) null, 4, (Object) null);
        }
        build.start(this.this$0.getActivity(), cardPwdManagerFragment$onViewCreated$3$callback$1);
        TrackerManager.Companion.trackForgetPwd();
    }
}
