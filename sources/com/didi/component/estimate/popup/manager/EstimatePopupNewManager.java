package com.didi.component.estimate.popup.manager;

import android.content.Context;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.common.util.GLog;
import com.didi.component.estimate.popup.request.EstimateComponentConfigNewRequest;
import com.didi.component.estimate.popup.request.EstimateConfuciusRequest;
import com.didi.component.estimate.popup.request.EstimatePopupRequest;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import java.util.ArrayList;
import java.util.List;

public class EstimatePopupNewManager {

    /* renamed from: a */
    private List<EstimatePopupRequest> f13234a;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());

    public EstimatePopupNewManager() {
        ArrayList arrayList = new ArrayList();
        this.f13234a = arrayList;
        arrayList.add(new EstimateComponentConfigNewRequest());
        this.f13234a.add(new EstimateConfuciusRequest());
    }

    public void doRequest(Context context, String str, int i) {
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            m8998a();
            m9000a(context, str, i);
        }
    }

    /* renamed from: a */
    private void m9000a(Context context, String str, int i) {
        for (EstimatePopupRequest next : this.f13234a) {
            if (next != null) {
                Logger logger = this.mLogger;
                logger.info("@requestByService, class:" + next.getClass().getCanonicalName(), new Object[0]);
                next.requestByService(context, BffConstants.Services.BFF_ESTIMATE_POP_RESULT_SERVICE_NEW, str, i);
            }
        }
    }

    public void doRequest(Context context, int i, int i2, int i3, String str, int i4) {
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            m8998a();
            m8999a(context, i, i2, i3, str, i4);
        }
    }

    /* renamed from: a */
    private void m8999a(Context context, int i, int i2, int i3, String str, int i4) {
        for (EstimatePopupRequest next : this.f13234a) {
            if (next != null) {
                GLog.m7965d("HomePopupManager", "@requestByService, class:" + next.getClass().getCanonicalName());
                next.requestByService(context, BffConstants.Services.BFF_ESTIMATE_POP_RESULT_SERVICE_NEW, i, i2, i3, str, i4);
            }
        }
    }

    /* renamed from: a */
    private void m8998a() {
        for (EstimatePopupRequest next : this.f13234a) {
            if (next != null) {
                Logger logger = this.mLogger;
                logger.info("@cancelRequestByGroup, class:" + next.getClass().getCanonicalName(), new Object[0]);
                next.cancelGroup();
            }
        }
    }
}
