package com.didi.component.memberpoint.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.memberpoint.AbsMemberPointPresenter;
import com.didi.component.memberpoint.IMemberPointView;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.model.response.estimate.CarPayInfoModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MemberPointPresenter extends AbsMemberPointPresenter {

    /* renamed from: a */
    private final BaseEventPublisher.OnEventListener<String> f14579a = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.memberpoint != null && newEstimateItem.memberpoint.operationData != null) {
                String str3 = newEstimateItem.memberpoint.operationData.operationIcon;
                if (!TextUtils.isEmpty(newEstimateItem.memberpoint.iconUrl)) {
                    str3 = newEstimateItem.memberpoint.iconUrl;
                }
                GlobalRichInfo globalRichInfo = newEstimateItem.memberpoint.operationData.operationText;
                if (newEstimateItem.memberpoint.selectedText != null && !TextUtils.isEmpty(newEstimateItem.memberpoint.selectedText.getContent())) {
                    globalRichInfo = newEstimateItem.memberpoint.selectedText;
                }
                globalRichInfo.updateText(str2);
                newEstimateItem.memberpoint.selectedText = globalRichInfo;
                newEstimateItem.memberpoint.iconUrl = str3;
                ((IMemberPointView) MemberPointPresenter.this.mView).setIcon(str3);
                ((IMemberPointView) MemberPointPresenter.this.mView).bindRichInfo(globalRichInfo);
            }
        }
    };

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<Boolean> f14580b = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            MemberPointPresenter.this.m10361b();
        }
    };

    public MemberPointPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m10362c();
        m10361b();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m10364d();
    }

    public void onMemberpointClick() {
        try {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.carConfig != null) {
                if (newEstimateItem.memberpoint != null) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("cartype", Integer.valueOf(newEstimateItem.carConfig.carLevel));
                    GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_points_ck", (Map<String, Object>) hashMap);
                    int i = -1;
                    if (!CollectionUtil.isEmpty((Collection<?>) newEstimateItem.carPayInfo)) {
                        Iterator<CarPayInfoModel> it = newEstimateItem.carPayInfo.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CarPayInfoModel next = it.next();
                            if (next.payIsSelected == 1) {
                                i = next.payTag;
                                break;
                            }
                        }
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(ParamConst.PARAM_PAY_TYPE, Integer.valueOf(i));
                    hashMap2.put("product_id_jptaxi", Integer.valueOf(newEstimateItem.carConfig.carBussinessId));
                    String str = newEstimateItem.memberpoint.operationData.link;
                    if (!TextUtils.isEmpty(str)) {
                        Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
                        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(GlobalWebUrl.buildUrl(str, hashMap2)));
                        this.mContext.startActivity(intent);
                        ((Activity) this.mContext).overridePendingTransition(R.anim.side_right_in, R.anim.anim_none);
                        FormStore.getInstance().setSkipEstimateGet(true);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10361b() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.memberpoint != null && newEstimateItem.memberpoint.operationData != null) {
            String str = newEstimateItem.memberpoint.operationData.operationIcon;
            if (!TextUtils.isEmpty(newEstimateItem.memberpoint.iconUrl)) {
                str = newEstimateItem.memberpoint.iconUrl;
            }
            GlobalRichInfo globalRichInfo = newEstimateItem.memberpoint.operationData.operationText;
            if (newEstimateItem.memberpoint.selectedText != null && !TextUtils.isEmpty(newEstimateItem.memberpoint.selectedText.getContent())) {
                globalRichInfo = newEstimateItem.memberpoint.selectedText;
            }
            ((IMemberPointView) this.mView).setIcon(str);
            ((IMemberPointView) this.mView).bindRichInfo(globalRichInfo);
        }
    }

    /* renamed from: c */
    private void m10362c() {
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f14580b);
        subscribe(BaseEventKeys.GroupForm.EVENT_GROUP_FORM_UPDATE_POINT_INFO, this.f14579a);
    }

    /* renamed from: d */
    private void m10364d() {
        unsubscribe(BaseEventKeys.GroupForm.EVENT_GROUP_FORM_UPDATE_POINT_INFO, this.f14579a);
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f14580b);
    }
}
