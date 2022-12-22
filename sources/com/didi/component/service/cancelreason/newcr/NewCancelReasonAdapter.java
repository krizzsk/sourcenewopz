package com.didi.component.service.cancelreason.newcr;

import android.view.ViewGroup;
import com.didi.component.service.cancelreason.CancelReasonAdapter;
import com.didi.component.service.cancelreason.CancelReasonBaseVH;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.didi.travel.psnger.model.response.CancelReasonInfo;

public class NewCancelReasonAdapter extends CancelReasonAdapter {

    /* renamed from: a */
    private static final int f15769a = 0;

    /* renamed from: b */
    private static final int f15770b = 1;

    /* renamed from: c */
    private static final int f15771c = 2;

    public NewCancelReasonAdapter(CancelReasonInfo cancelReasonInfo) {
        super(cancelReasonInfo);
    }

    public CancelReasonBaseVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new NewCancelReasonTitleVH(viewGroup);
        }
        if (i == 1) {
            return new NewCancelReasonSubTitleVH(viewGroup);
        }
        if (i != 2) {
            return null;
        }
        NewCancelReasonContentVH newCancelReasonContentVH = new NewCancelReasonContentVH(viewGroup);
        newCancelReasonContentVH.setSubmitreason(this.submitReason);
        return newCancelReasonContentVH;
    }

    public void onBindViewHolder(CancelReasonBaseVH cancelReasonBaseVH, int i) {
        int itemViewType = getItemViewType(i);
        int i2 = i - 1;
        CRListModel cRListModel = (i2 <= -1 || this.list == null || this.list.isEmpty()) ? null : (CRListModel) this.list.get(i2);
        if (itemViewType == 0) {
            cancelReasonBaseVH.setData(this.info);
        } else if (itemViewType == 1) {
            cancelReasonBaseVH.setData(cRListModel);
        } else if (itemViewType == 2) {
            cancelReasonBaseVH.setData(cRListModel);
        }
    }
}
