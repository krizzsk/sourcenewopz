package com.didi.component.comp_selectseat.ticket;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.PresenterGroup;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.util.TextUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.HashMap;
import java.util.Map;

public class TicketPresenter extends PresenterGroup<ITicketView> {
    public TicketPresenter(Context context, Bundle bundle) {
        super(context, bundle);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    public void setData(String str) {
        if (!TextUtil.isEmpty(str)) {
            try {
                TicketModel ticketModel = (TicketModel) new Gson().fromJson(str, TicketModel.class);
                if (ticketModel != null) {
                    ((ITicketView) this.mView).setTitleBarText(ticketModel.mTitleBarText);
                    ((ITicketView) this.mView).setPayment(ticketModel.mPayment);
                    ((ITicketView) this.mView).setPrice(ticketModel.mPrice);
                    ((ITicketView) this.mView).setTicketHeadBgColor(ticketModel.mTicketHeadBgColor);
                    if (ticketModel.mPaymentMarkShow == 1) {
                        ((ITicketView) this.mView).showPaymentMark(ticketModel.mPaymentMark);
                    } else {
                        ((ITicketView) this.mView).showPaymentMark((String) null);
                    }
                    ((ITicketView) this.mView).setTicketNum(ticketModel.mTicketNum);
                    ((ITicketView) this.mView).setTicketIntro(ticketModel.mTicketIntro);
                    ((ITicketView) this.mView).setName(ticketModel.mName);
                    ((ITicketView) this.mView).setSeatNum(ticketModel.mSeatNum);
                    ((ITicketView) this.mView).setRole(ticketModel.mRole);
                    ((ITicketView) this.mView).setSeatUnits(ticketModel.mSeatUnits);
                    m8488b();
                    return;
                }
                GLog.m7967e("TicketPresenter setData>>ticketModel is null ");
            } catch (JsonSyntaxException e) {
                GLog.m7967e("TicketPresenter setData>> " + e.toString());
            }
        }
    }

    /* renamed from: b */
    private void m8488b() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put(RavenKey.VERSION, "ticketpage");
        GlobalOmegaUtils.trackEvent("ibt_ticketpage_sw", (Map<String, Object>) hashMap);
    }
}
