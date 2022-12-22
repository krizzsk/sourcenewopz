package com.didi.component.evaluate.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.core.IPresenter;
import com.didi.component.evaluate.model.EvaluateModel;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.util.TempUtil;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.UnMatchConfirmDialog;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.util.CollectionUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbsCommonEvaluatePresenter extends AbsEvaluatePresenter {
    protected boolean isInFiveStar = true;
    protected BusinessContext mBusinessContext;
    /* access modifiers changed from: protected */
    public List<CarNoEvaluateData.CarEvaluateTag> mCarEvaluateTags;
    /* access modifiers changed from: protected */
    public EvaluateModel mEvaluateModel;
    /* access modifiers changed from: protected */
    public UnevaluatedViewModel.UnMatchInfo mUnMatchInfo = null;

    public boolean isShowTagInFlow() {
        return false;
    }

    public void onCancel() {
    }

    public void onTagSelected(EvaluateTag evaluateTag, boolean z) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AbsCommonEvaluatePresenter(com.didi.component.core.ComponentParams r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r18.<init>(r19)
            r0 = 1
            r1.isInFiveStar = r0
            r3 = 0
            r1.mUnMatchInfo = r3
            java.lang.String r4 = "extras_unevaluated_comment_data"
            java.lang.Object r4 = r2.getExtra(r4)
            com.didi.travel.psnger.model.response.CommentOnPanel r4 = (com.didi.travel.psnger.model.response.CommentOnPanel) r4
            r5 = 0
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
            if (r4 != 0) goto L_0x008b
            java.lang.String r4 = "extras_unevaluated_json"
            java.lang.Object r4 = r2.getExtra(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L_0x005c
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0056 }
            r7.<init>(r4)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r4 = "comment_status"
            int r4 = r7.optInt(r4)     // Catch:{ Exception -> 0x0056 }
            if (r4 != r0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r0 = "avatar"
            java.lang.String r4 = r7.optString(r0)     // Catch:{ Exception -> 0x0056 }
            com.didi.travel.psnger.model.UnevaluatedViewModel$UnMatchInfo r0 = new com.didi.travel.psnger.model.UnevaluatedViewModel$UnMatchInfo     // Catch:{ Exception -> 0x0054 }
            r0.<init>()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r8 = "unmatch"
            org.json.JSONObject r7 = r7.optJSONObject(r8)     // Catch:{ Exception -> 0x0054 }
            r0.parse(r7)     // Catch:{ Exception -> 0x0054 }
            r1.mUnMatchInfo = r0     // Catch:{ Exception -> 0x0054 }
            goto L_0x005d
        L_0x0054:
            r0 = move-exception
            goto L_0x0058
        L_0x0056:
            r0 = move-exception
            r4 = r3
        L_0x0058:
            r0.printStackTrace()
            goto L_0x005d
        L_0x005c:
            r4 = r3
        L_0x005d:
            com.didi.component.business.util.OrderComManager r0 = com.didi.component.business.util.OrderComManager.getInstance()
            com.didi.travel.psnger.model.response.OrderCom r0 = r0.getOrderCom()
            r7 = 5
            if (r0 == 0) goto L_0x0081
            java.lang.String r8 = r0.getOid()
            com.didi.component.business.util.OrderComManager r9 = com.didi.component.business.util.OrderComManager.getInstance()
            com.didi.travel.psnger.model.response.EvaluateModel r9 = r9.evaluateModel
            if (r9 == 0) goto L_0x007c
            com.didi.component.business.util.OrderComManager r7 = com.didi.component.business.util.OrderComManager.getInstance()
            com.didi.travel.psnger.model.response.EvaluateModel r7 = r7.evaluateModel
            int r7 = r7.evaluateScore
        L_0x007c:
            int r0 = r0.getBusinessId()
            goto L_0x0083
        L_0x0081:
            r8 = r3
            r0 = 0
        L_0x0083:
            r17 = r0
            r16 = r3
            r14 = r4
            r12 = r7
            r11 = r8
            goto L_0x00bd
        L_0x008b:
            java.lang.String r0 = "extras_unevaluated_satisfied"
            java.lang.Object r0 = r2.getExtra(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r7 = r0.intValue()
            com.didi.travel.psnger.model.response.CommentOnPanelOrderInfo r0 = r4.orderInfo
            java.lang.String r8 = r0.order_id
            com.didi.travel.psnger.model.response.CarNoEvaluateData r0 = r4.carNoEvaluateData
            java.util.List<com.didi.travel.psnger.model.response.CarNoEvaluateData$CarEvaluateTag> r0 = r0.tags
            r1.mCarEvaluateTags = r0
            com.didi.travel.psnger.model.response.CommentOnPanelOrderInfo r0 = r4.orderInfo
            int r0 = r0.productId
            com.didi.component.config.BusinessRegistry.bid2ParentSid(r0)
            com.didi.travel.psnger.model.response.CarNoEvaluateData r0 = r4.carNoEvaluateData
            java.lang.String r0 = r0.title
            com.didi.travel.psnger.model.response.CommentOnPanelOrderInfo r9 = r4.orderInfo
            int r9 = r9.productId
            com.didi.travel.psnger.model.UnevaluatedViewModel r4 = r4.evaluatedViewModel
            com.didi.travel.psnger.model.UnevaluatedViewModel$UnMatchInfo r4 = r4.unMatchInfo
            r1.mUnMatchInfo = r4
            r16 = r0
            r14 = r3
            r12 = r7
            r11 = r8
            r17 = r9
        L_0x00bd:
            com.didi.component.evaluate.model.EvaluateModel r0 = new com.didi.component.evaluate.model.EvaluateModel
            boolean r3 = r6.booleanValue()
            if (r3 == 0) goto L_0x00c8
            com.didi.component.evaluate.model.EvaluateMode r3 = com.didi.component.evaluate.model.EvaluateMode.View
            goto L_0x00ca
        L_0x00c8:
            com.didi.component.evaluate.model.EvaluateMode r3 = com.didi.component.evaluate.model.EvaluateMode.Edit
        L_0x00ca:
            r13 = r3
            r15 = 0
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            java.util.List<com.didi.travel.psnger.model.response.CarNoEvaluateData$CarEvaluateTag> r3 = r1.mCarEvaluateTags
            boolean r3 = com.didiglobal.travel.util.CollectionUtils.isNotEmpty((java.util.Collection<?>) r3)
            if (r3 == 0) goto L_0x00dd
            java.util.List<com.didi.travel.psnger.model.response.CarNoEvaluateData$CarEvaluateTag> r3 = r1.mCarEvaluateTags
            r0.processTags(r3, r5)
        L_0x00dd:
            com.didi.sdk.app.BusinessContext r2 = r2.bizCtx
            r1.mBusinessContext = r2
            r1.mEvaluateModel = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.evaluate.presenter.AbsCommonEvaluatePresenter.<init>(com.didi.component.core.ComponentParams):void");
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        ((IEvaluateView) this.mView).onAdd();
        ((IEvaluateView) this.mView).initIsInFiveStar(this.isInFiveStar);
        TempUtil.setSoftInputMode(getHost(), 16);
    }

    /* access modifiers changed from: protected */
    public void load() {
        onLoadData();
    }

    public void onRetry() {
        onLoadData();
    }

    public void setOrderLevel(int i) {
        this.mEvaluateModel.setLevel(i);
        if (!GlobalApolloUtil.isNewEvaluate() && !CollectionUtils.isEmpty((Collection<?>) this.mCarEvaluateTags)) {
            this.mEvaluateModel.processTags(this.mCarEvaluateTags, false);
            ((IEvaluateView) this.mView).setCarEvaluateTags(this.mCarEvaluateTags);
            ((IEvaluateView) this.mView).setTags(this.mEvaluateModel.getEvaluateTagList());
            ((IEvaluateView) this.mView).setTagTitle(this.mEvaluateModel.getMainTagTitle(), this.mEvaluateModel.getSubTagTitlte());
        }
    }

    public void onClose() {
        GlobalOmegaUtils.trackEvent("pas_ratecard_close_ck");
        onCloseWithOutOmega();
    }

    public void onCloseWithOutOmega() {
        doPublish(BaseEventKeys.Evaluate.EVALUATE_CLOSED);
        doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.EVALUATE);
    }

    /* access modifiers changed from: protected */
    public void notifyEvaluateSuccess() {
        ((IEvaluateView) this.mView).showSubmitSuccess();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        UiThreadHandler.removeCallbacks((Runnable) null);
        ((IEvaluateView) this.mView).onRemove();
        TempUtil.restoreSoftInputMode(getHost());
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        ((IEvaluateView) this.mView).close();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        ((IEvaluateView) this.mView).onResume();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        ((IEvaluateView) this.mView).onPause();
    }

    public void submitUnMatch() {
        if (getHost() != null && getHost().getFragmentManager() != null) {
            UnMatchConfirmDialog unMatchConfirmDialog = new UnMatchConfirmDialog();
            unMatchConfirmDialog.setStyle(((IEvaluateView) this.mView).getStyle());
            UnevaluatedViewModel.UnMatchInfo unMatchInfo = this.mUnMatchInfo;
            if (!(unMatchInfo == null || unMatchInfo.unMatchGuideMsg == null)) {
                unMatchConfirmDialog.setUnMatchPopUp(this.mUnMatchInfo.unMatchGuideMsg.unMatchPopUp);
            }
            EvaluateModel evaluateModel = this.mEvaluateModel;
            String oid = evaluateModel != null ? evaluateModel.getOid() : "";
            unMatchConfirmDialog.setOrderId(oid);
            unMatchConfirmDialog.show(getHost().getFragmentManager(), "unmatch_dialog");
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", oid);
            OmegaSDKAdapter.trackEvent("gulf_p_f_compblack_pv_ck", (Map<String, Object>) hashMap);
        }
    }
}
