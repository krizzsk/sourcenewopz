package com.didi.component.groupform.anycar.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmGetListener;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.IComponent;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.groupform.anycar.presenter.AbsAnycarGroupFormPresenter;
import com.didi.component.groupform.anycar.view.adapter.AnyCarFormViewOptionAdapter;
import com.didi.component.groupform.view.adapter.FormViewOptionAdapter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel3;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
import com.didi.travel.psnger.model.response.estimate.CarFareConfirmBreak;
import com.didi.travel.psnger.model.response.estimate.CarPayInfoModel;
import com.didi.travel.psnger.model.response.estimate.FormOperationModel;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.omega.sdk.Omega;
import com.didiglobal.travel.util.CollectionUtils;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnyCarGroupFormView implements IViewContainer, IAnycarGroupFormView {

    /* renamed from: a */
    private Logger f14020a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private View f14021b;

    /* renamed from: c */
    private View f14022c;

    /* renamed from: d */
    private TextView f14023d;

    /* renamed from: e */
    private TextView f14024e;

    /* renamed from: f */
    private AbsAnycarGroupFormPresenter f14025f;

    /* renamed from: g */
    private RecyclerView f14026g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Context f14027h;

    /* renamed from: i */
    private GridLayoutManager f14028i;

    /* renamed from: j */
    private LinearLayoutManager f14029j;

    /* renamed from: k */
    private AnyCarFormViewOptionAdapter f14030k;

    /* renamed from: l */
    private Drawable f14031l;

    /* renamed from: m */
    private LEGODrawer f14032m;

    /* renamed from: n */
    private List<Integer> f14033n;

    /* renamed from: o */
    private FrameLayout f14034o;

    /* renamed from: p */
    private IComponent f14035p;

    /* renamed from: q */
    private boolean f14036q;

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14037r = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            HashMap hashMap = new HashMap();
            hashMap.put("is_singletype", 1);
            AnyCarGroupFormView.this.m9788a((Map<String, Object>) hashMap);
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener != null) {
                AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
                if (selectedSingleAnyCarItem != null) {
                    hashMap.put("single_biz", Integer.valueOf(selectedSingleAnyCarItem.getCarBussinessId()));
                }
                if (selectedSingleAnyCarItem != null) {
                    hashMap.put("price_estimated", Float.valueOf(selectedSingleAnyCarItem.feeNumber));
                }
                if (!(selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.extraData == null)) {
                    selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.extraData.putAllExtraLog(hashMap);
                }
            }
            GlobalOmegaUtils.trackEvent("pas_carconfirm_submit_ck", (Map<String, Object>) hashMap);
            AnyCarGroupFormView.this.m9790b();
        }
    };

    /* renamed from: s */
    private FormOperationModel f14038s;

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f14025f.setComponentCreator(iComponentCreator);
    }

    public AnyCarGroupFormView(Context context, ViewGroup viewGroup) {
        this.f14027h = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.f14030k = new AnyCarFormViewOptionAdapter();
        View inflate = from.inflate(R.layout.anycar_group_form_layout, viewGroup, false);
        this.f14021b = inflate;
        this.f14022c = inflate.findViewById(R.id.anycar_form_btn_layout);
        this.f14023d = (TextView) this.f14021b.findViewById(R.id.form_btn);
        this.f14024e = (TextView) this.f14021b.findViewById(R.id.form_btn_price);
        this.f14034o = (FrameLayout) this.f14021b.findViewById(R.id.payway_container);
        this.f14023d.setText(R.string.global_confirm_btn_new);
        Drawable drawable = DidiThemeManager.getIns().getResPicker(context).getDrawable(R.attr.global_overall_main_button_selector);
        this.f14031l = drawable;
        this.f14022c.setBackground(drawable);
        try {
            this.f14023d.setTextColor(ContextCompat.getColorStateList(context, DidiThemeManager.getIns().getResPicker(context).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
            this.f14024e.setTextColor(ContextCompat.getColorStateList(context, DidiThemeManager.getIns().getResPicker(context).getResIdByTheme(R.attr.global_main_button_text_color_selector)));
        } catch (Resources.NotFoundException e) {
            Omega.trackError("comp-group-form", e);
        }
        RecyclerView recyclerView = (RecyclerView) this.f14021b.findViewById(R.id.global_form_option_container);
        this.f14026g = recyclerView;
        recyclerView.setAdapter(this.f14030k);
        this.f14022c.setOnClickListener(new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
                    PageCompDataTransfer.getInstance().getConfirmListener().setSelectedSingleAnyCarItem((AnyCarEstimateItemModel) null);
                }
                AnyCarGroupFormView.this.m9785a();
                AnyCarGroupFormView.this.m9790b();
            }
        });
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SINGLE_CLICK, this.f14037r);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9785a() {
        HashMap hashMap = new HashMap();
        ConfirmGetListener confirmGetListener = PageCompDataTransfer.getInstance().getConfirmGetListener();
        if (confirmGetListener != null && !TextUtils.isEmpty(confirmGetListener.getBtnSubText())) {
            hashMap.put("price_estimated", confirmGetListener.getBtnSubText());
        }
        m9788a((Map<String, Object>) hashMap);
        GlobalOmegaUtils.trackEvent("pas_carconfirm_submit_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9788a(Map<String, Object> map) {
        String str;
        int i;
        int i2;
        ConfirmGetListener confirmGetListener = PageCompDataTransfer.getInstance().getConfirmGetListener();
        if (confirmGetListener != null && !TextUtils.isEmpty(confirmGetListener.getTraceId())) {
            map.put("estimate_trace_id", confirmGetListener.getTraceId());
        }
        map.put("is_login", Integer.valueOf(OneLoginFacade.getStore().isLoginNow() ? 1 : 0));
        AnyCarPayModel anyCarPayModel = null;
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            anyCarPayModel = confirmListener.getAnycarPayModel();
        }
        int i3 = 1;
        if (anyCarPayModel != null && anyCarPayModel.payWayList != null) {
            Iterator<PayWayModel.PayWayItem> it = anyCarPayModel.payWayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PayWayModel.PayWayItem next = it.next();
                if (next.isSelected() == 1) {
                    str = next.title;
                    break;
                }
            }
        }
        str = "";
        map.put("payment", str);
        List<PayWayModel.PayWayItem> payWaySelectedItem = FormStore.getInstance().getPayWaySelectedItem();
        if (payWaySelectedItem == null || payWaySelectedItem.size() <= 0) {
            i = 0;
        } else {
            i = 0;
            for (PayWayModel.PayWayItem payWayItem : payWaySelectedItem) {
                i |= payWayItem.tag;
            }
        }
        if (anyCarPayModel == null || CollectionUtils.isEmpty((Collection<?>) anyCarPayModel.carPayInfo)) {
            i2 = 0;
        } else {
            i2 = 0;
            for (int i4 = 0; i4 < anyCarPayModel.carPayInfo.size(); i4++) {
                CarPayInfoModel carPayInfoModel = anyCarPayModel.carPayInfo.get(i4);
                if (carPayInfoModel.payTag == 256 && carPayInfoModel.payExtraItemInfos != null) {
                    int size = carPayInfoModel.payExtraItemInfos.size();
                    if (size == 1) {
                        i2 = 1;
                    }
                    if (size > 1) {
                        i2 = 2;
                    }
                }
            }
        }
        map.put("card_status", Integer.valueOf(i2));
        map.put("paytype", Integer.valueOf(i));
        map.put("type", 0);
        if (Long.valueOf(FormStore.getInstance().getTransportTime()).longValue() == 0) {
            i3 = 0;
        }
        map.put("order_type", Integer.valueOf(i3));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9790b() {
        List<AnyCarEstimateItemModel> list;
        AnyCarEstimateItemModel anyCarEstimateItemModel = null;
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            anyCarEstimateItemModel = PageCompDataTransfer.getInstance().getConfirmListener().getSelectedSingleAnyCarItem();
            list = PageCompDataTransfer.getInstance().getConfirmListener().getSelectedAnyCarItems();
        } else {
            list = null;
        }
        if (anyCarEstimateItemModel != null || !CollectionUtil.isEmpty((Collection<?>) list)) {
            AnyCarEstimateItemModel estimateNoPriceIntercept = estimateNoPriceIntercept();
            if (estimateNoPriceIntercept != null) {
                noPriceSendOrderDialog(estimateNoPriceIntercept.mAnyCarEstimateNetItem.carBreakModel.carFareConfirm);
            } else {
                onConfirmClick();
            }
        }
    }

    public void onConfirmClick() {
        this.f14025f.onConfirmPriceIntercept();
    }

    public AnyCarEstimateItemModel estimateNoPriceIntercept() {
        List<AnyCarEstimateItemModel> list;
        AnyCarEstimateItemModel anyCarEstimateItemModel;
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            anyCarEstimateItemModel = PageCompDataTransfer.getInstance().getConfirmListener().getSelectedSingleAnyCarItem();
            list = PageCompDataTransfer.getInstance().getConfirmListener().getSelectedAnyCarItems();
        } else {
            anyCarEstimateItemModel = null;
            list = null;
        }
        if (anyCarEstimateItemModel == null && CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        if (anyCarEstimateItemModel != null) {
            if (m9789a(anyCarEstimateItemModel)) {
                return anyCarEstimateItemModel;
            }
        } else if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (AnyCarEstimateItemModel next : list) {
                if (m9789a(next)) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m9789a(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carFareConfirm == null || TextUtils.isEmpty(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carFareConfirm.fareTitle) || TextUtils.isEmpty(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carFareConfirm.confirmText) || TextUtils.isEmpty(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carFareConfirm.cancelText)) {
            return false;
        }
        return true;
    }

    public void noPriceSendOrderDialog(final CarFareConfirmBreak carFareConfirmBreak) {
        LEGOBaseDrawerModel lEGOBaseDrawerModel;
        noPriceDialogDismiss();
        if (TextUtils.isEmpty(carFareConfirmBreak.linkText) || TextUtils.isEmpty(carFareConfirmBreak.link)) {
            lEGOBaseDrawerModel = new LEGODrawerModel1(carFareConfirmBreak.fareTitle, new LEGOBtnTextAndCallback(carFareConfirmBreak.confirmText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (AnyCarGroupFormView.this.estimateNoPriceIntercept() != null) {
                        AnyCarGroupFormView.this.onConfirmClick();
                    }
                    AnyCarGroupFormView.this.noPriceDialogDismiss();
                }
            }));
        } else {
            lEGOBaseDrawerModel = new LEGODrawerModel3(carFareConfirmBreak.fareTitle, carFareConfirmBreak.linkText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    Intent intent = new Intent(AnyCarGroupFormView.this.f14027h, GlobalWebActivity.class);
                    intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(carFareConfirmBreak.link));
                    AnyCarGroupFormView.this.f14027h.startActivity(intent);
                }
            }, new LEGOBtnTextAndCallback(carFareConfirmBreak.confirmText, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (AnyCarGroupFormView.this.estimateNoPriceIntercept() != null) {
                        AnyCarGroupFormView.this.onConfirmClick();
                    }
                    AnyCarGroupFormView.this.noPriceDialogDismiss();
                }
            }));
        }
        lEGOBaseDrawerModel.addMinorBtn(new LEGOBtnTextAndCallback(carFareConfirmBreak.cancelText, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                AnyCarGroupFormView.this.noPriceDialogDismiss();
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        }));
        if (!TextUtils.isEmpty(carFareConfirmBreak.farText)) {
            lEGOBaseDrawerModel.setSubTitle(carFareConfirmBreak.farText);
        }
        lEGOBaseDrawerModel.setClickOutsideCanCancel(false);
        lEGOBaseDrawerModel.setIsShowCloseImg(true);
        lEGOBaseDrawerModel.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                AnyCarGroupFormView.this.noPriceDialogDismiss();
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        });
        LEGODrawer showDrawerTemplate = LEGOUICreator.showDrawerTemplate(this.f14027h, lEGOBaseDrawerModel);
        this.f14032m = showDrawerTemplate;
        showDrawerTemplate.show();
    }

    public void noPriceDialogDismiss() {
        LEGODrawer lEGODrawer = this.f14032m;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f14032m.dismiss();
        }
    }

    public void setPresenter(AbsAnycarGroupFormPresenter absAnycarGroupFormPresenter) {
        this.f14030k.setPresenter(absAnycarGroupFormPresenter);
        this.f14025f = absAnycarGroupFormPresenter;
    }

    public View getView() {
        return this.f14021b;
    }

    public void setEnabled(boolean z) {
        this.f14022c.setEnabled(z);
        this.f14023d.setEnabled(z);
        this.f14024e.setEnabled(z);
    }

    public void setButtonText(CharSequence charSequence) {
        this.f14023d.setText(charSequence);
    }

    /* JADX WARNING: type inference failed for: r6v19, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOptionViews(java.util.List<java.lang.Integer> r6) {
        /*
            r5 = this;
            com.didi.global.globaluikit.drawer.LEGODrawer r0 = r5.f14032m
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x0013
            com.didi.component.core.event.BaseEventPublisher r0 = com.didi.component.core.event.BaseEventPublisher.getPublisher()
            java.lang.String r1 = "event_bottom_form_hinted"
            r0.publish(r1)
        L_0x0013:
            if (r6 != 0) goto L_0x0016
            return
        L_0x0016:
            java.util.List<java.lang.Integer> r6 = r5.f14033n
            if (r6 != 0) goto L_0x0022
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r5.f14033n = r6
            goto L_0x0025
        L_0x0022:
            r6.clear()
        L_0x0025:
            boolean r6 = r5.f14036q
            r0 = 1
            if (r6 != 0) goto L_0x0038
            com.didi.component.groupform.anycar.presenter.AbsAnycarGroupFormPresenter r6 = r5.f14025f
            android.widget.FrameLayout r1 = r5.f14034o
            java.lang.String r2 = "anycar_payway"
            com.didi.component.core.IComponent r6 = r6.inflateComponent(r2, r1)
            r5.f14035p = r6
            r5.f14036q = r0
        L_0x0038:
            com.didi.component.business.data.form.FormStore r6 = com.didi.component.business.data.form.FormStore.getInstance()
            r1 = 0
            r6.setHasSubstituteCall(r1)
            com.didi.travel.psnger.model.response.estimate.FormOperationModel r6 = r5.f14038s
            r2 = 0
            if (r6 == 0) goto L_0x0093
            java.util.List<com.didi.travel.psnger.model.response.estimate.FormOperationModels> r6 = r6.items
            boolean r6 = com.didi.component.common.util.CollectionUtils.isEmpty((java.util.Collection) r6)
            if (r6 != 0) goto L_0x0093
            com.didi.travel.psnger.model.response.estimate.FormOperationModel r6 = r5.f14038s
            java.util.List<com.didi.travel.psnger.model.response.estimate.FormOperationModels> r6 = r6.items
            java.util.Iterator r6 = r6.iterator()
        L_0x0055:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x0084
            java.lang.Object r3 = r6.next()
            com.didi.travel.psnger.model.response.estimate.FormOperationModels r3 = (com.didi.travel.psnger.model.response.estimate.FormOperationModels) r3
            int r4 = r3.mFormOperationType
            if (r4 != r0) goto L_0x0055
            java.util.List<java.lang.Integer> r6 = r5.f14033n
            r4 = 7
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.add(r4)
            com.didi.component.groupform.anycar.view.adapter.AnyCarFormViewOptionAdapter r6 = r5.f14030k
            java.lang.String r4 = r3.mScheme
            r6.setSubstituteCallScheme(r4)
            com.didi.component.groupform.anycar.presenter.AbsAnycarGroupFormPresenter r6 = r5.f14025f
            int r3 = r3.mEducationPopupCount
            r6.showNoviceGuidance(r3)
            com.didi.component.business.data.form.FormStore r6 = com.didi.component.business.data.form.FormStore.getInstance()
            r6.setHasSubstituteCall(r0)
        L_0x0084:
            com.didi.component.business.data.form.FormStore r6 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r6 = r6.isHasSubstituteCall()
            if (r6 != 0) goto L_0x0093
            int r6 = com.didi.component.business.tracker.anycar.AnycarTrack.mSceneSubstituteCall
            com.didi.component.business.tracker.anycar.AnycarTrack.anycarMonitorTrack(r6, r2)
        L_0x0093:
            com.didi.component.groupform.anycar.view.adapter.AnyCarFormViewOptionAdapter r6 = r5.f14030k
            java.util.List<java.lang.Integer> r0 = r5.f14033n
            r6.setModelList(r0)
            android.view.View r6 = r5.f14022c
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            boolean r6 = r6 instanceof android.widget.LinearLayout.LayoutParams
            if (r6 == 0) goto L_0x00ad
            android.view.View r6 = r5.f14022c
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            r2 = r6
            android.widget.LinearLayout$LayoutParams r2 = (android.widget.LinearLayout.LayoutParams) r2
        L_0x00ad:
            if (r2 == 0) goto L_0x00d3
            com.didi.component.groupform.anycar.view.adapter.AnyCarFormViewOptionAdapter r6 = r5.f14030k
            int r6 = r6.getModelListSize()
            r0 = -1
            if (r6 != 0) goto L_0x00c6
            r2.width = r0
            android.content.Context r6 = r5.f14027h
            r0 = 1099956224(0x41900000, float:18.0)
            int r6 = com.didi.component.business.util.UiUtils.dip2px(r6, r0)
            r2.setMarginStart(r6)
            goto L_0x00d3
        L_0x00c6:
            r2.width = r0
            android.content.Context r6 = r5.f14027h
            r0 = 1097859072(0x41700000, float:15.0)
            int r6 = com.didi.component.business.util.UiUtils.dip2px(r6, r0)
            r2.setMarginStart(r6)
        L_0x00d3:
            androidx.recyclerview.widget.LinearLayoutManager r6 = r5.f14029j
            if (r6 != 0) goto L_0x00e5
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r0 = r5.f14027h
            r6.<init>(r0, r1, r1)
            r5.f14029j = r6
            androidx.recyclerview.widget.RecyclerView r0 = r5.f14026g
            r0.setLayoutManager(r6)
        L_0x00e5:
            com.didi.component.groupform.anycar.view.adapter.AnyCarFormViewOptionAdapter r6 = r5.f14030k
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.groupform.anycar.view.AnyCarGroupFormView.setOptionViews(java.util.List):void");
    }

    /* renamed from: c */
    private void m9793c() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f14026g.getLayoutParams();
        layoutParams.setMarginEnd(UIUtils.dip2pxInt(this.f14027h, 30.0f));
        this.f14026g.setLayoutParams(layoutParams);
    }

    public void onDestroy() {
        AnyCarFormViewOptionAdapter anyCarFormViewOptionAdapter = this.f14030k;
        if (anyCarFormViewOptionAdapter != null) {
            anyCarFormViewOptionAdapter.onDestroy();
        }
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SINGLE_CLICK, this.f14037r);
    }

    public void setAnyCarFormOperationData(FormOperationModel formOperationModel) {
        this.f14038s = formOperationModel;
    }

    public void setPriceBtn(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f14024e.setVisibility(8);
            setEnabled(false);
        } else {
            this.f14024e.setVisibility(0);
            setEnabled(true);
        }
        this.f14024e.setText(str);
    }

    public void setMaxColCount(int i) {
        FormViewOptionAdapter.RECYCLER_VIEW_SINGLE_COL_SPANS = 6 / i;
    }

    public void setVisible(boolean z) {
        this.f14021b.setVisibility(z ? 0 : 8);
    }
}
