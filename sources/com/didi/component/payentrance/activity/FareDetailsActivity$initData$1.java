package com.didi.component.payentrance.activity;

import android.os.SystemClock;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.payentrance.model.FareDetailsModel;
import com.didiglobal.travel.biz.callback.LoadCallbackWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didiglobal/travel/biz/callback/LoadCallbackWrapper;", "Lcom/didi/component/payentrance/model/FareDetailsModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailsActivity.kt */
final class FareDetailsActivity$initData$1 extends Lambda implements Function1<LoadCallbackWrapper<FareDetailsModel>, Unit> {
    final /* synthetic */ FareDetailsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FareDetailsActivity$initData$1(FareDetailsActivity fareDetailsActivity) {
        super(1);
        this.this$0 = fareDetailsActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LoadCallbackWrapper<FareDetailsModel>) (LoadCallbackWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LoadCallbackWrapper<FareDetailsModel> loadCallbackWrapper) {
        Intrinsics.checkNotNullParameter(loadCallbackWrapper, "$this$load");
        final FareDetailsActivity fareDetailsActivity = this.this$0;
        loadCallbackWrapper.onSuccess(new Function1<FareDetailsModel, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FareDetailsModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FareDetailsModel fareDetailsModel) {
                Intrinsics.checkNotNullParameter(fareDetailsModel, "data");
                Collection feeList = fareDetailsModel.getFeeList();
                if (!(feeList == null || feeList.isEmpty())) {
                    fareDetailsActivity.f14869e = fareDetailsModel.getFeeList();
                }
                Map hashMap = new HashMap();
                hashMap.put("load_time", Long.valueOf(SystemClock.uptimeMillis() - fareDetailsActivity.f14870f));
                GlobalOmegaUtils.trackEvent("gp_endservice_feedetail", (Map<String, Object>) hashMap);
                fareDetailsActivity.m10686f().setMData(fareDetailsModel.getFeeList());
                fareDetailsActivity.m10686f().notifyDataSetChanged();
                fareDetailsActivity.m10683c().setVisibility(8);
                if (fareDetailsActivity.isFareDoubtEntryOpen()) {
                    fareDetailsActivity.m10685e().setVisibility(0);
                    GlobalOmegaUtils.trackEvent("ibt_farefeepage_help_sw");
                    return;
                }
                fareDetailsActivity.m10685e().setVisibility(8);
            }
        });
        final FareDetailsActivity fareDetailsActivity2 = this.this$0;
        loadCallbackWrapper.onError(new Function2<FareDetailsModel, Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((FareDetailsModel) obj, (Throwable) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(FareDetailsModel fareDetailsModel, Throwable th) {
                Intrinsics.checkNotNullParameter(th, "$noName_1");
                fareDetailsActivity2.m10688h();
            }
        });
        final FareDetailsActivity fareDetailsActivity3 = this.this$0;
        loadCallbackWrapper.onFinish(new Function0<Unit>() {
            public final void invoke() {
                fareDetailsActivity3.closePDialog();
            }
        });
    }
}
