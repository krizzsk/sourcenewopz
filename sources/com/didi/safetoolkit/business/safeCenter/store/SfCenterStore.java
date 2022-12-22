package com.didi.safetoolkit.business.safeCenter.store;

import com.didi.safetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.safetoolkit.business.safeCenter.request.SfSafeCenterRequest;
import com.didi.safetoolkit.business.safeCenter.response.SfSafetyCenterResponse;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.net.ISfRpcRequestParamListener;
import com.didi.safetoolkit.net.SfHttpManager;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.net.SfRpcCallback;
import com.didi.safetoolkit.net.SfServerParam;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SfCenterStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<SfCenterCardModel> f34417a;

    public interface Callback {
        void onFailed(SfSafetyCenterResponse sfSafetyCenterResponse);

        void onSuccess(List<SfCenterCardModel> list);
    }

    public void request(final Callback callback) {
        SfSafeCenterRequest sfSafeCenterRequest = new SfSafeCenterRequest();
        sfSafeCenterRequest.vamosDriver = SafeToolKit.getIns().isVamosDriver() ? 1 : 0;
        ISfRpcRequestParamListener requestParamListener = SafeToolKit.getIns().getRequestParamListener();
        if (requestParamListener != null) {
            sfSafeCenterRequest.token = (String) requestParamListener.getParam(SfServerParam.SERVICE_SAFETY_CENTER, "token");
            sfSafeCenterRequest.lang = (String) requestParamListener.getParam(SfServerParam.SERVICE_SAFETY_CENTER, "lang");
            sfSafeCenterRequest.originId = (String) requestParamListener.getParam(SfServerParam.SERVICE_SAFETY_CENTER, "origin_id");
        }
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfSafeCenterRequest, new SfRpcCallback<SfSafetyCenterResponse>(new SfResponseListener<SfSafetyCenterResponse>() {
            public void onSuccess(SfSafetyCenterResponse sfSafetyCenterResponse) {
                if (sfSafetyCenterResponse.data == null) {
                    SfLog.m24403e("safety center data is null!");
                    callback.onFailed((SfSafetyCenterResponse) null);
                    return;
                }
                SfSafetyCenterResponse.SfSafetyCenterData sfSafetyCenterData = sfSafetyCenterResponse.data;
                if (sfSafetyCenterData.safetyContent == null) {
                    List unused = SfCenterStore.this.f34417a = new ArrayList();
                } else {
                    List unused2 = SfCenterStore.this.f34417a = sfSafetyCenterData.safetyContent;
                }
                SfCenterStore sfCenterStore = SfCenterStore.this;
                List a = sfCenterStore.f34417a;
                boolean z = true;
                if (sfSafetyCenterData.showAdd != 1) {
                    z = false;
                }
                sfCenterStore.m24336a((List<SfCenterCardModel>) a, z);
                callback.onSuccess(SfCenterStore.this.f34417a);
            }

            public void onError(SfSafetyCenterResponse sfSafetyCenterResponse) {
                callback.onFailed(sfSafetyCenterResponse);
            }
        }) {
        });
    }

    public void getLocalData(Callback callback) {
        ArrayList arrayList = new ArrayList();
        m24336a((List<SfCenterCardModel>) arrayList, false);
        callback.onSuccess(arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24336a(List<SfCenterCardModel> list, boolean z) {
        SfCenterCardModel sfCenterCardModel = new SfCenterCardModel();
        sfCenterCardModel.typeLocal = 2;
        sfCenterCardModel.title = SfStringGetter.getString(R.string.sf_trusted_contacts_title);
        sfCenterCardModel.content = SfStringGetter.getString(R.string.sf_safety_center_share_trip);
        if (z) {
            sfCenterCardModel.btnText = SfStringGetter.getString(R.string.sf_add);
        }
        list.add(0, sfCenterCardModel);
    }

    public List<SfCenterCardModel> getData() {
        return this.f34417a;
    }
}
