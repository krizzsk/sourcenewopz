package com.didi.component.evaluate.presenter.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.EndServiceTipPayEvent;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.util.SourceUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.business.xbanner.XBannerConstants;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.config.DynamicConfigManager;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.ApkUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.evaluate.model.EvaluateMode;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.presenter.AbsCommonEvaluatePresenter;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.didi.travel.psnger.model.response.CarHasEvaluateData;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.didi.travel.psnger.model.response.EvaluateModel;
import com.didi.travel.psnger.model.response.PrePayTipsModel;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommonEvaluatePresenter extends AbsCommonEvaluatePresenter {
    public static final String TIP_COMMON_EVALUATED = "tip_common_evaluated";

    /* renamed from: a */
    private static final int f13311a = 100;

    /* renamed from: b */
    private static final int f13312b = 200;

    /* renamed from: c */
    private static final int f13313c = 3;

    /* renamed from: d */
    private static final int f13314d = 5;

    /* renamed from: e */
    private String f13315e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CarNoEvaluateData f13316f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f13317g = false;

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13318h = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CarRequest.unMatch(CommonEvaluatePresenter.this.mContext, CommonEvaluatePresenter.this.mEvaluateModel.getOid(), new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    if (jsonObject.get("errno").getAsInt() == 0) {
                        CommonEvaluatePresenter.this.m9100f();
                    } else {
                        CommonEvaluatePresenter.this.m9092b(jsonObject.get("errmsg").getAsString());
                    }
                }

                public void onFailure(IOException iOException) {
                    CommonEvaluatePresenter.this.m9092b((String) null);
                }
            });
        }
    };

    /* access modifiers changed from: protected */
    public int getDefaultDriverIconRes() {
        return R.drawable.global_evaluate_default_driver_icon;
    }

    /* access modifiers changed from: protected */
    public abstract boolean isNeedShowThePlayStoreDialog();

    public void onEvaluateTagSelectChange(CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl, boolean z) {
    }

    public CommonEvaluatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (this.mView != null) {
            ((IEvaluateView) this.mView).setLevel(this.mEvaluateModel.getLevel());
            ((IEvaluateView) this.mView).setDefaultDriverIcon(getDefaultDriverIconRes());
            ((IEvaluateView) this.mView).setDriverIconAndName(this.mEvaluateModel.getDriverIconUrl(), this.mEvaluateModel.getDriverName());
            load();
        }
        subscribe(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_UNMATCH, this.f13318h);
    }

    public void onSubmit(List<EvaluateTag> list, String str, final String str2) {
        this.f13315e = str2;
        String oid = this.mEvaluateModel.getOid();
        String a = m9078a(list);
        m9087a(list, str, str2);
        ((IEvaluateView) this.mView).showLoading();
        CarRequest.doComment(this.mContext, oid, this.mEvaluateModel.getLevel(), a, str, new ResponseListener<CarHasEvaluateData>() {
            public void onSuccess(CarHasEvaluateData carHasEvaluateData) {
                super.onSuccess(carHasEvaluateData);
                CommonEvaluatePresenter.this.m9090b();
                if (GlobalApolloUtil.isHomeEngine()) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_HOME_REFACTOR_XBANNER_RELOAD_WITH_PAGE_STATE, 0);
                } else {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, XBannerConstants.PageState.HOME_KEEP_PAGE_STATE);
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Trip.EVENT_GLOBAL_XPANEL_FIVE_STAR_COMPLETED);
                if (GlobalApolloUtil.isNewEvaluate()) {
                    CommonEvaluatePresenter.this.doPublish(BaseEventKeys.Evaluate.SHOW_NEXT_EVALUATE, Boolean.TRUE);
                } else {
                    CommonEvaluatePresenter.this.doPublish(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_SUCCESS);
                    CommonEvaluatePresenter.this.doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.EVALUATE);
                }
                if (TextUtils.isEmpty(str2)) {
                    CommonEvaluatePresenter commonEvaluatePresenter = CommonEvaluatePresenter.this;
                    commonEvaluatePresenter.m9080a(commonEvaluatePresenter.mEvaluateModel.getLevel());
                } else {
                    CommonEvaluatePresenter.this.m9086a(str2);
                    CommonEvaluatePresenter.this.doPublish(BaseEventKeys.Service.EndService.EVENT_ENDSERVCIE_TIP_SOURCE, new EndServiceTipPayEvent(CommonEvaluatePresenter.TIP_COMMON_EVALUATED, str2));
                }
                if (OrderComManager.getInstance().evaluateModel == null) {
                    OrderComManager.getInstance().evaluateModel = new EvaluateModel();
                }
                OrderComManager.getInstance().evaluateModel.evaluateMark = 1;
                OrderComManager.getInstance().evaluateModel.evaluateScore = CommonEvaluatePresenter.this.mEvaluateModel.getLevel();
            }

            public void onError(CarHasEvaluateData carHasEvaluateData) {
                super.onError(carHasEvaluateData);
                ((IEvaluateView) CommonEvaluatePresenter.this.mView).showSubmitFail();
                ToastHelper.showLongCompleted(CommonEvaluatePresenter.this.mContext, CommonEvaluatePresenter.this.mContext.getString(R.string.submit_fail_retry));
            }

            public void onFail(CarHasEvaluateData carHasEvaluateData) {
                super.onFail(carHasEvaluateData);
                ((IEvaluateView) CommonEvaluatePresenter.this.mView).showSubmitFail();
                ToastHelper.showLongCompleted(CommonEvaluatePresenter.this.mContext, CommonEvaluatePresenter.this.mContext.getString(R.string.submit_fail_retry));
            }

            public void onFinish(CarHasEvaluateData carHasEvaluateData) {
                super.onFinish(carHasEvaluateData);
                ((IEvaluateView) CommonEvaluatePresenter.this.mView).hideLoading();
            }
        });
    }

    /* renamed from: a */
    private void m9087a(List<EvaluateTag> list, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("rate", Integer.valueOf(this.mEvaluateModel.getLevel() == 5 ? 1 : 0));
        String str3 = "";
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str3 = str3 + list.get(i).getText();
                if (i < list.size() - 1) {
                    str3 = str3 + ";";
                }
            }
        }
        hashMap.put("tag", str3);
        hashMap.put("comment", str);
        hashMap.put("tip", str2);
        hashMap.put("source", Integer.valueOf(getOrderSource()));
        GlobalOmegaUtils.trackEvent("pas_ratecard_submit_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public int getOrderSource() {
        return SourceUtils.getSource();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9090b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            order.evaluateModel.evaluateMark = 1;
            if (this.mEvaluateModel != null) {
                order.evaluateModel.evaluateScore = this.mEvaluateModel.getLevel();
            }
            CarOrderHelper.saveOrder(order);
        }
    }

    /* renamed from: a */
    private String m9078a(List<EvaluateTag> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(list.get(i).getId());
            if (i < size - 1) {
                stringBuffer.append("|");
            }
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9086a(String str) {
        if (!TextUtils.isEmpty(str)) {
            CarRequest.prePayTips(this.mContext, this.mEvaluateModel.getOid(), str, new ResponseListener<PrePayTipsModel>() {
                public void onSuccess(PrePayTipsModel prePayTipsModel) {
                    super.onSuccess(prePayTipsModel);
                    if (prePayTipsModel != null) {
                        CommonEvaluatePresenter.this.m9085a(prePayTipsModel);
                    }
                    CommonEvaluatePresenter.this.m9080a(5);
                }

                public void onError(PrePayTipsModel prePayTipsModel) {
                    super.onError(prePayTipsModel);
                    CommonEvaluatePresenter.this.m9094c();
                }

                public void onFail(PrePayTipsModel prePayTipsModel) {
                    super.onFail(prePayTipsModel);
                    CommonEvaluatePresenter.this.m9094c();
                }

                public void onFinish(PrePayTipsModel prePayTipsModel) {
                    super.onFinish(prePayTipsModel);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (i == 100) {
            if (i2 == 1) {
                onClose();
            } else if (i2 == 2) {
                m9086a(this.f13315e);
            }
        } else if (i != 200) {
        } else {
            if (i2 == 1) {
                GlobalOmegaUtils.trackEvent("pas_ratedidi_close_ck");
                dismissDialog(200);
            } else if (i2 == 2) {
                GlobalOmegaUtils.trackEvent("pas_ratedidi_rate_ck");
                GlobalSPUtil.setGooglePlayDialogShowTimes(this.mContext, 3);
                Utils.launchGooglePlayStoreAppDetail(this.mContext.getPackageName());
                dismissDialog(200);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9094c() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(100);
        normalDialogInfo.setMessage(this.mContext.getResources().getString(R.string.global_evaluate_failed_add_tip));
        normalDialogInfo.setPositiveText(this.mContext.getResources().getString(R.string.global_evaluate_pay_again));
        normalDialogInfo.setNegativeText(this.mContext.getResources().getString(R.string.cancel));
        normalDialogInfo.setCancelable(false);
        showDialog(normalDialogInfo);
    }

    /* renamed from: d */
    private boolean m9096d() {
        boolean isPackageCanBeLaunched = ApkUtils.isPackageCanBeLaunched(this.mContext, "com.android.vending");
        if (isPackageCanBeLaunched) {
            try {
                NormalDialogInfo normalDialogInfo = new NormalDialogInfo(200);
                Drawable appLauncherIcon = ApkUtils.getAppLauncherIcon(this.mContext);
                if (appLauncherIcon != null) {
                    normalDialogInfo.setIcon(appLauncherIcon);
                }
                normalDialogInfo.setTitle(this.mContext.getResources().getString(R.string.global_play_store_evaluate_dialog_title, new Object[]{ApkUtils.getAppName(this.mContext)}));
                normalDialogInfo.setMessage(this.mContext.getResources().getString(R.string.global_play_store_evaluate_dialog_sub_title));
                normalDialogInfo.setPositiveText(this.mContext.getResources().getString(R.string.global_play_store_evaluate_dialog_positive_btn));
                normalDialogInfo.setNegativeText(this.mContext.getResources().getString(R.string.global_play_store_evaluate_dialog_negative_btn));
                normalDialogInfo.setCancelable(false);
                showDialog(normalDialogInfo);
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                LoggerFactory.getLogger(getClass()).error("showGooglePlayStoreEvaluate", (Throwable) e);
            }
        }
        return isPackageCanBeLaunched;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m9098e() {
        ((IEvaluateView) this.mView).setTags(this.mEvaluateModel.getEvaluateTagList());
        ((IEvaluateView) this.mView).setCarEvaluateTags(this.mCarEvaluateTags);
        ((IEvaluateView) this.mView).setTagTitle(this.mEvaluateModel.getMainTagTitle(), this.mEvaluateModel.getSubTagTitlte());
        if (this.f13316f != null) {
            ((IEvaluateView) this.mView).setCardTitle(this.f13316f.title);
        } else {
            ((IEvaluateView) this.mView).setCardTitle(this.mEvaluateModel.getTitle());
        }
    }

    public void onLoadData() {
        if (this.mEvaluateModel.getMode() != EvaluateMode.Edit) {
            ((IEvaluateView) this.mView).showLoading();
            CarRequest.getCommentData(this.mContext, this.mEvaluateModel.getOid(), new ResponseListener<CarHasEvaluateData>() {
                public void onSuccess(CarHasEvaluateData carHasEvaluateData) {
                    super.onSuccess(carHasEvaluateData);
                    if (carHasEvaluateData != null) {
                        if (!CollectionUtils.isEmpty((Collection<?>) carHasEvaluateData.tags)) {
                            CommonEvaluatePresenter.this.mEvaluateModel.processTags(carHasEvaluateData.tags, true);
                            CommonEvaluatePresenter.this.m9098e();
                        }
                        if (!TextUtils.isEmpty(carHasEvaluateData.content)) {
                            ((IEvaluateView) CommonEvaluatePresenter.this.mView).setCommentContent(carHasEvaluateData.content);
                        }
                        if (!TextUtils.isEmpty(carHasEvaluateData.refine_guide)) {
                            ((IEvaluateView) CommonEvaluatePresenter.this.mView).setRefineGuide(carHasEvaluateData.refine_guide);
                        }
                    }
                    CommonEvaluatePresenter commonEvaluatePresenter = CommonEvaluatePresenter.this;
                    if (!commonEvaluatePresenter.loadThanksBonus(true, false, commonEvaluatePresenter.mEvaluateModel.getProductId())) {
                        ((IEvaluateView) CommonEvaluatePresenter.this.mView).hideLoading();
                    }
                    boolean unused = CommonEvaluatePresenter.this.f13317g = true;
                    CommonEvaluatePresenter commonEvaluatePresenter2 = CommonEvaluatePresenter.this;
                    commonEvaluatePresenter2.showUnMatch(commonEvaluatePresenter2.mUnMatchInfo, CommonEvaluatePresenter.this.f13317g);
                }

                public void onError(CarHasEvaluateData carHasEvaluateData) {
                    super.onError(carHasEvaluateData);
                    ((IEvaluateView) CommonEvaluatePresenter.this.mView).showLoadingFail(true);
                }

                public void onFail(CarHasEvaluateData carHasEvaluateData) {
                    super.onFail(carHasEvaluateData);
                    ((IEvaluateView) CommonEvaluatePresenter.this.mView).showLoadingFail(true);
                }

                public void onFinish(CarHasEvaluateData carHasEvaluateData) {
                    super.onFinish(carHasEvaluateData);
                }
            });
            doPublish(BaseEventKeys.Evaluate.EVALUATE_SHOWN);
        } else if (CollectionUtils.isEmpty((Collection<?>) this.mEvaluateModel.getEvaluateTagList())) {
            ((IEvaluateView) this.mView).showHeader();
            ((IEvaluateView) this.mView).showLoading();
            CarRequest.getCommentFlag(this.mContext, this.mEvaluateModel.getOid(), new ResponseListener<CarNoEvaluateData>() {
                public void onSuccess(CarNoEvaluateData carNoEvaluateData) {
                    super.onSuccess(carNoEvaluateData);
                    CarNoEvaluateData unused = CommonEvaluatePresenter.this.f13316f = carNoEvaluateData;
                    ((IEvaluateView) CommonEvaluatePresenter.this.mView).hideLoading();
                    CommonEvaluatePresenter.this.mEvaluateModel.processTags(CommonEvaluatePresenter.this.f13316f.tags, false);
                    CommonEvaluatePresenter commonEvaluatePresenter = CommonEvaluatePresenter.this;
                    List unused2 = commonEvaluatePresenter.mCarEvaluateTags = commonEvaluatePresenter.f13316f.tags;
                    CommonEvaluatePresenter.this.m9098e();
                    boolean unused3 = CommonEvaluatePresenter.this.f13317g = false;
                    CommonEvaluatePresenter commonEvaluatePresenter2 = CommonEvaluatePresenter.this;
                    commonEvaluatePresenter2.showUnMatch(commonEvaluatePresenter2.mUnMatchInfo, CommonEvaluatePresenter.this.f13317g);
                }

                public void onError(CarNoEvaluateData carNoEvaluateData) {
                    super.onError(carNoEvaluateData);
                    ((IEvaluateView) CommonEvaluatePresenter.this.mView).showLoadingFail(true);
                }

                public void onFail(CarNoEvaluateData carNoEvaluateData) {
                    super.onFail(carNoEvaluateData);
                    ((IEvaluateView) CommonEvaluatePresenter.this.mView).showLoadingFail(true);
                }

                public void onFinish(CarNoEvaluateData carNoEvaluateData) {
                    super.onFinish(carNoEvaluateData);
                }
            });
            if (!loadThanksBonus(false, false, this.mEvaluateModel.getProductId())) {
                ((IEvaluateView) this.mView).hideLoading();
            }
            doPublish(BaseEventKeys.Evaluate.EVALUATE_SHOWN);
        } else {
            m9098e();
            this.f13317g = false;
            showUnMatch(this.mUnMatchInfo, this.f13317g);
            ((IEvaluateView) this.mView).showHeader();
            ((IEvaluateView) this.mView).setCommentAreaVisibility(true);
            if (!loadThanksBonus(false, true, this.mEvaluateModel.getProductId())) {
                ((IEvaluateView) this.mView).hideLoading();
            }
            doPublish(BaseEventKeys.Evaluate.EVALUATE_SHOWN);
            TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), this.mEvaluateModel.getOid(), new ITravelOrderListener() {
                public void onError(int i, String str) {
                }

                public void onFail(int i, String str) {
                }

                public void onTimeout(String str) {
                }

                public void onSuccess(ICarOrder iCarOrder) {
                    CarOrder carOrder = (CarOrder) iCarOrder;
                    if (carOrder != null) {
                        CommonEvaluatePresenter.this.mEvaluateModel.setDriverIconUrl(carOrder.carDriver.avatarUrl);
                        CommonEvaluatePresenter.this.mEvaluateModel.setDriverName(carOrder.carDriver.name);
                        ((IEvaluateView) CommonEvaluatePresenter.this.mView).setDriverIconAndName(CommonEvaluatePresenter.this.mEvaluateModel.getDriverIconUrl(), CommonEvaluatePresenter.this.mEvaluateModel.getDriverName());
                        CarOrderHelper.saveOrder((CarOrder) null);
                    }
                }
            });
        }
    }

    public boolean loadThanksBonus(boolean z, final boolean z2, int i) {
        if (this.mEvaluateModel == null || !DynamicConfigManager.getInstance().checkConfigEnable(i, "tip", true)) {
            return false;
        }
        CarRequest.doGetTipInfo(this.mContext, this.mEvaluateModel.getOid(), new ResponseListener<CarTipInfo>() {
            public void onSuccess(CarTipInfo carTipInfo) {
                super.onSuccess(carTipInfo);
                if (!z2) {
                    ((IEvaluateView) CommonEvaluatePresenter.this.mView).hideLoading();
                }
                ((IEvaluateView) CommonEvaluatePresenter.this.mView).refreshThanksTipData(carTipInfo);
            }

            public void onError(CarTipInfo carTipInfo) {
                super.onError(carTipInfo);
                if (!z2) {
                    ((IEvaluateView) CommonEvaluatePresenter.this.mView).showLoadingFail(true);
                }
            }

            public void onFail(CarTipInfo carTipInfo) {
                super.onFail(carTipInfo);
                if (!z2) {
                    ((IEvaluateView) CommonEvaluatePresenter.this.mView).showLoadingFail(true);
                }
            }

            public void onFinish(CarTipInfo carTipInfo) {
                super.onFinish(carTipInfo);
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9080a(int i) {
        ((IEvaluateView) this.mView).showSubmitSuccess();
        int googlePlayDialogShowTimes = GlobalSPUtil.getGooglePlayDialogShowTimes(this.mContext);
        if (isNeedShowThePlayStoreDialog() && googlePlayDialogShowTimes < 3 && i >= 5) {
            int goodLevelTimes = GlobalSPUtil.getGoodLevelTimes(this.mContext, 5);
            if (goodLevelTimes < 5) {
                GlobalSPUtil.setGoodLevelTimes(this.mContext, (goodLevelTimes + 1) % 6);
            } else if (m9096d()) {
                GlobalOmegaUtils.trackEvent("pas_ratedidi_sw");
                GlobalSPUtil.setGooglePlayDialogShowTimes(this.mContext, googlePlayDialogShowTimes + 1);
                GlobalSPUtil.setGoodLevelTimes(this.mContext, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9085a(PrePayTipsModel prePayTipsModel) {
        try {
            Intent intent = new Intent();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("sign", prePayTipsModel.sign);
            jsonObject.addProperty(Const.PayParams.SIGN_TYPE, prePayTipsModel.signType);
            jsonObject.addProperty(Const.PayParams.BIZ_CONTENT, prePayTipsModel.bizContent);
            intent.setPackage(this.mContext.getPackageName());
            intent.setAction("com.didi.global.unifiedPay.entrance");
            intent.putExtra("uni_pay_param", jsonObject.toString());
            this.mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        if (isDialogShowing()) {
            dismissDialog(100);
        }
        unsubscribe(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_UNMATCH, this.f13318h);
    }

    /* access modifiers changed from: protected */
    public void showUnMatch(UnevaluatedViewModel.UnMatchInfo unMatchInfo, boolean z) {
        if (unMatchInfo != null && unMatchInfo.isShow) {
            if (unMatchInfo.isUnMatched) {
                ((IEvaluateView) this.mView).showUnMatchResult(unMatchInfo, z);
            } else {
                ((IEvaluateView) this.mView).showUnMatchSubmit(unMatchInfo, z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m9100f() {
        doPublish(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_UNMATCH_DONE);
        if (this.mUnMatchInfo != null) {
            this.mUnMatchInfo.isUnMatched = true;
            ((IEvaluateView) this.mView).showUnMatchResult(this.mUnMatchInfo, this.f13317g);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9092b(String str) {
        doPublish(BaseEventKeys.Evaluate.EVALUATE_SUBMIT_UNMATCH_DONE);
        if (!TextUtils.isEmpty(str)) {
            ToastHelper.showShortInfo(this.mContext, str);
        }
    }
}
