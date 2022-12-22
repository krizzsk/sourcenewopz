package com.didi.component.business.data.form;

import android.text.TextUtils;
import com.didi.travel.psnger.model.response.PayWayModel;
import java.util.ArrayList;
import java.util.List;

public class PayWayForm {
    public String cardIndex;
    public List<PayWayModel.PayWayItem> mPayWaySelectedItem = new ArrayList();

    public PayWayForm(List<PayWayModel.PayWayItem> list) {
        if (list == null || list.isEmpty()) {
            this.cardIndex = "";
            return;
        }
        this.mPayWaySelectedItem = list;
        for (PayWayModel.PayWayItem next : list) {
            if (next != null && !TextUtils.isEmpty(next.cardIndex)) {
                this.cardIndex = next.cardIndex;
            }
        }
    }

    public void clear() {
        this.mPayWaySelectedItem.clear();
        this.cardIndex = "";
    }
}
