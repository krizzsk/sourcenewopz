package com.didi.component.service.cancelreason;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.UIUtils;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.didi.sdk.app.DIDIApplication;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class CancelReasonAdapter extends RecyclerView.Adapter<CancelReasonBaseVH> {

    /* renamed from: a */
    private static final int f15735a = 0;

    /* renamed from: b */
    private static final int f15736b = 1;

    /* renamed from: c */
    private static final int f15737c = 2;
    protected CancelReasonInfo info;
    protected ArrayList<CRListModel> list;
    protected ISubmitReason submitReason;

    public CancelReasonAdapter(CancelReasonInfo cancelReasonInfo) {
        if (cancelReasonInfo != null) {
            this.info = cancelReasonInfo;
            this.list = m11489a(cancelReasonInfo);
        }
    }

    public CancelReasonBaseVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new CancelReasonTitleVH(viewGroup);
        }
        if (i == 1) {
            return new CancelReasonSubTitleVH(viewGroup);
        }
        if (i != 2) {
            return null;
        }
        CancelReasonContentVH cancelReasonContentVH = new CancelReasonContentVH(viewGroup);
        cancelReasonContentVH.setSubmitreason(this.submitReason);
        return cancelReasonContentVH;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r2 = r3.list;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.didi.component.service.cancelreason.CancelReasonBaseVH r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.getItemViewType(r5)
            int r1 = r5 + -1
            r2 = -1
            if (r1 <= r2) goto L_0x001c
            java.util.ArrayList<com.didi.component.service.cancelreason.model.CRListModel> r2 = r3.list
            if (r2 == 0) goto L_0x001c
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x001c
            java.util.ArrayList<com.didi.component.service.cancelreason.model.CRListModel> r2 = r3.list
            java.lang.Object r1 = r2.get(r1)
            com.didi.component.service.cancelreason.model.CRListModel r1 = (com.didi.component.service.cancelreason.model.CRListModel) r1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            if (r0 == 0) goto L_0x003e
            r2 = 1
            if (r0 == r2) goto L_0x0032
            r2 = 2
            if (r0 == r2) goto L_0x0026
            goto L_0x0045
        L_0x0026:
            r0 = r4
            com.didi.component.service.cancelreason.CancelReasonContentVH r0 = (com.didi.component.service.cancelreason.CancelReasonContentVH) r0
            r0.setData((com.didi.component.service.cancelreason.model.CRListModel) r1)
            android.view.View r4 = r4.itemView
            r3.setStyleBgAndMargin(r5, r4)
            goto L_0x0045
        L_0x0032:
            r0 = r4
            com.didi.component.service.cancelreason.CancelReasonSubTitleVH r0 = (com.didi.component.service.cancelreason.CancelReasonSubTitleVH) r0
            r0.setData((com.didi.component.service.cancelreason.model.CRListModel) r1)
            android.view.View r4 = r4.itemView
            r3.setStyleBgAndMargin(r5, r4)
            goto L_0x0045
        L_0x003e:
            com.didi.component.service.cancelreason.CancelReasonTitleVH r4 = (com.didi.component.service.cancelreason.CancelReasonTitleVH) r4
            com.didi.travel.psnger.model.response.CancelReasonInfo r5 = r3.info
            r4.setData((com.didi.travel.psnger.model.response.CancelReasonInfo) r5)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.cancelreason.CancelReasonAdapter.onBindViewHolder(com.didi.component.service.cancelreason.CancelReasonBaseVH, int):void");
    }

    public void setStyleBgAndMargin(int i, View view) {
        Application appContext = DIDIApplication.getAppContext();
        if (i == 1) {
            view.setBackgroundDrawable(appContext.getResources().getDrawable(R.drawable.global_cancel_reason_rv_top_dadius));
            m11490a(0, view);
        } else if (i == this.list.size()) {
            view.setBackgroundDrawable(appContext.getResources().getDrawable(R.drawable.cr_reason_click_selector_with_bottom_radius));
            m11490a(18, view);
        } else {
            view.setBackgroundDrawable(appContext.getResources().getDrawable(R.drawable.cr_reason_click_selector));
            m11490a(0, view);
        }
    }

    /* renamed from: a */
    private void m11490a(int i, View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        layoutParams.bottomMargin = UIUtils.dip2pxInt(view.getContext(), (float) i);
        view.setLayoutParams(layoutParams);
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return m11491a(i) ? 1 : 2;
    }

    /* renamed from: a */
    private boolean m11491a(int i) {
        int i2 = i - 1;
        ArrayList<CRListModel> arrayList = this.list;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        return TextUtils.isEmpty(this.list.get(i2).f15762id);
    }

    public int getItemCount() {
        return this.list.size() + 1;
    }

    /* renamed from: a */
    private ArrayList<CRListModel> m11489a(CancelReasonInfo cancelReasonInfo) {
        ArrayList<CRListModel> arrayList = new ArrayList<>();
        if (cancelReasonInfo.reason_list != null) {
            Iterator<CancelReasonInfo.CancelReasonItem> it = cancelReasonInfo.reason_list.iterator();
            while (it.hasNext()) {
                CancelReasonInfo.CancelReasonItem next = it.next();
                CRListModel cRListModel = new CRListModel();
                cRListModel.f15762id = "";
                cRListModel.text = next.title;
                cRListModel.reason_type = next.reason_type;
                cRListModel.icon = next.icon;
                arrayList.add(cRListModel);
                Iterator<CancelReasonInfo.CancelReasonSubItem> it2 = next.list.iterator();
                while (it2.hasNext()) {
                    CancelReasonInfo.CancelReasonSubItem next2 = it2.next();
                    CRListModel cRListModel2 = new CRListModel();
                    cRListModel2.f15762id = next2.reason_id;
                    cRListModel2.text = next2.text;
                    cRListModel.reason_type = next.reason_type;
                    cRListModel2.show_alert = next2.show_alert;
                    cRListModel2.operations = next2.operations;
                    arrayList.add(cRListModel2);
                }
            }
        }
        return arrayList;
    }

    public void setSubmitReason(ISubmitReason iSubmitReason) {
        this.submitReason = iSubmitReason;
    }
}
