package com.didi.component.service.cancelreason;

import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.didi.soda.customer.app.constant.Const;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class AbsCancelReasonContentVH extends CancelReasonBaseVH<CRListModel> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ISubmitReason f15728a;
    protected TextView tv_cancel_reason_content;

    public AbsCancelReasonContentVH(View view) {
        super(view);
    }

    public void setSubmitreason(ISubmitReason iSubmitReason) {
        this.f15728a = iSubmitReason;
    }

    public void setData(final CRListModel cRListModel) {
        if (cRListModel != null && cRListModel.text != null) {
            this.tv_cancel_reason_content.setText(cRListModel.text);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HashMap hashMap = new HashMap();
                    hashMap.put("reason_id", cRListModel.f15762id);
                    hashMap.put(Const.CampaignKey.KEY_CLICK_TIME, Long.valueOf(System.currentTimeMillis()));
                    hashMap.put("u_id", Long.valueOf(NationComponentDataUtil.getUid()));
                    if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().oid == null)) {
                        hashMap.put("o_id", CarOrderHelper.getOrder().oid);
                    }
                    OmegaSDKAdapter.trackEvent("gp_cancelreason_reason_ck", (Map<String, Object>) hashMap);
                    if (AbsCancelReasonContentVH.this.f15728a != null) {
                        AbsCancelReasonContentVH.this.f15728a.submit(cRListModel);
                    }
                }
            });
        }
    }
}
