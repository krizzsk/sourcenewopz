package com.didi.component.payentrance.activity;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarRequest;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FareDetailsActivity.kt */
final class FareDetailsActivity$initObjects$2 implements View.OnClickListener {
    final /* synthetic */ FareDetailsActivity this$0;

    FareDetailsActivity$initObjects$2(FareDetailsActivity fareDetailsActivity) {
        this.this$0 = fareDetailsActivity;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        GlobalOmegaUtils.trackEvent("ibt_farefeepage_help_ck");
        CharSequence access$getMFareDoubtUrl$p = this.this$0.f14867c;
        if (access$getMFareDoubtUrl$p == null || access$getMFareDoubtUrl$p.length() == 0) {
            CarOrder order = CarOrderHelper.getOrder();
            String str = order == null ? null : order.oid;
            final FareDetailsActivity fareDetailsActivity = this.this$0;
            CarRequest.getFareDoubtUrl(fareDetailsActivity, str, "fare_detail_page", new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    String str = null;
                    JsonElement jsonElement = jsonObject == null ? null : jsonObject.get("data");
                    if (jsonElement instanceof JsonObject) {
                        JsonElement jsonElement2 = ((JsonObject) jsonElement).get("kefuButtonUrl");
                        if (jsonElement2 instanceof JsonPrimitive) {
                            str = ((JsonPrimitive) jsonElement2).getAsString();
                        }
                    }
                    fareDetailsActivity.f14867c = str;
                    fareDetailsActivity.jumpFareDoubtUrl(str);
                }

                public void onFailure(IOException iOException) {
                    fareDetailsActivity.jumpFareDoubtUrl((String) null);
                }
            });
            return;
        }
        FareDetailsActivity fareDetailsActivity2 = this.this$0;
        fareDetailsActivity2.jumpFareDoubtUrl(fareDetailsActivity2.f14867c);
    }
}
