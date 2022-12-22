package com.didi.component.splitfare.presenter.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.common.dialog.GlobalCommonBottomPop;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.splitfare.event.SplitFareEventTracker;
import com.didi.component.splitfare.model.SplitFareManager;
import com.didi.component.splitfare.model.UpdateSplitFareInfo;
import com.didi.component.splitfare.model.UpdateSplitFarePartner;
import com.didi.component.splitfare.presenter.AbsSplitFarePresenter;
import com.didi.component.splitfare.view.ISplitFareOnServiceView;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.service.CoreHttpRequest;
import com.didi.travel.psnger.model.OrderStatus;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.taxis99.R;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SplitFareOnServicePresenter extends AbsSplitFarePresenter<ISplitFareOnServiceView> {

    /* renamed from: b */
    private static int f15986b = 1;

    /* renamed from: c */
    private static int f15987c = 2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f15988e = 1;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static int f15989f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GlobalCommonBottomPop f15990a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Logger f15991d = LoggerFactory.getLogger("SplitFareOnServicePresenter");
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LEGODrawer f15992g;

    /* renamed from: h */
    private IServingController f15993h;

    public void onItemClicked(DTSDKSplitFareInfo.SplitUser splitUser) {
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        CarOrder order = CarOrderHelper.getOrder();
        if (order.splitFareInfo == null) {
            ((ISplitFareOnServiceView) this.mView).hide();
        } else {
            ((ISplitFareOnServiceView) this.mView).show(order);
        }
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                if (!SplitFareOnServicePresenter.this.mRemoved) {
                    ((ISplitFareOnServiceView) SplitFareOnServicePresenter.this.mView).show(CarOrderHelper.getOrder());
                }
            }
        });
        subscribe(BaseEventKeys.OnService.FARE_SUCCESS_UPDATE, new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                if (!SplitFareOnServicePresenter.this.mRemoved) {
                    ((ISplitFareOnServiceView) SplitFareOnServicePresenter.this.mView).show(CarOrderHelper.getOrder());
                }
            }
        });
        subscribe(BaseEventKeys.Push.EVENT_SPLIT_FARE_USER_LIST_UPDATE, new BaseEventPublisher.OnEventListener<String>() {
            public void onEvent(String str, String str2) {
                if (!SplitFareOnServicePresenter.this.mRemoved) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        String optString = jSONObject.optString("msg", "");
                        int optInt = jSONObject.optInt("code");
                        if (optInt == OrderStatus.QUIT_SPLIT_FARE_CODE) {
                            SplitFareOnServicePresenter.this.m11732a(optString);
                        } else if (optInt == SplitFareOnServicePresenter.f15989f) {
                            SplitFareOnServicePresenter.this.m11739d();
                        } else if (optInt == SplitFareOnServicePresenter.f15988e) {
                            SplitFareOnServicePresenter.this.m11739d();
                            if (SplitFareOnServicePresenter.this.f15992g == null || (SplitFareOnServicePresenter.this.f15992g != null && !SplitFareOnServicePresenter.this.f15992g.isShowing())) {
                                LEGODrawer unused = SplitFareOnServicePresenter.this.f15992g = LEGOUICreator.showDrawerTemplate(SplitFareOnServicePresenter.this.mContext, new LEGODrawerModel1("", new LEGOBtnTextAndCallback(ResourcesHelper.getString(SplitFareOnServicePresenter.this.mContext, R.string.car_me_known), new LEGOOnAntiShakeClickListener() {
                                    public void onAntiShakeClick(View view) {
                                        if (SplitFareOnServicePresenter.this.f15992g != null && SplitFareOnServicePresenter.this.f15992g.isShowing()) {
                                            SplitFareOnServicePresenter.this.f15992g.dismiss();
                                            LEGODrawer unused = SplitFareOnServicePresenter.this.f15992g = null;
                                        }
                                    }
                                })).setIsShowCloseImg(false).setClickOutsideCanCancel(false).setSubTitle(HighlightUtil.highlight(SplitFareOnServicePresenter.this.mContext, optString).toString()));
                            }
                        }
                    } catch (JSONException e) {
                        SplitFareOnServicePresenter.this.f15991d.error("", (Throwable) e);
                    }
                }
            }
        });
        subscribe(BaseEventKeys.OnService.SPLIT_FARE_OWNER_CANCEL, new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_CANCEL_BTN_CK);
                GlobalCommonBottomPop.BottomPopModel bottomPopModel = new GlobalCommonBottomPop.BottomPopModel();
                bottomPopModel.isShowNegative = true;
                bottomPopModel.positive = ResourcesHelper.getString(SplitFareOnServicePresenter.this.mContext, R.string.car_confirm);
                bottomPopModel.negative = ResourcesHelper.getString(SplitFareOnServicePresenter.this.mContext, R.string.global_share_cancel_btn_text);
                bottomPopModel.title = ResourcesHelper.getString(SplitFareOnServicePresenter.this.mContext, R.string.g_splitfare_owner_stop_title);
                bottomPopModel.content = ResourcesHelper.getString(SplitFareOnServicePresenter.this.mContext, R.string.g_splitfare_owner_stop_sub_title);
                SplitFareOnServicePresenter splitFareOnServicePresenter = SplitFareOnServicePresenter.this;
                GlobalCommonBottomPop unused = splitFareOnServicePresenter.f15990a = new GlobalCommonBottomPop(splitFareOnServicePresenter.mContext, bottomPopModel);
                SplitFareOnServicePresenter.this.f15990a.setBottomActionListener(new GlobalCommonBottomPop.GlobalBottomPopActionListener() {
                    public void onPositiveClick() {
                        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_CANCELYES_BTN_CK);
                        new SplitFareManager(SplitFareOnServicePresenter.this.mContext).stopSplitFare(CarOrderHelper.getOrder(), new ResponseListener<UpdateSplitFarePartner>() {
                            public void onSuccess(UpdateSplitFarePartner updateSplitFarePartner) {
                                super.onSuccess(updateSplitFarePartner);
                                if (!SplitFareOnServicePresenter.this.mRemoved) {
                                    DTSDKOrderDetail dTSDKOrderDetail = updateSplitFarePartner.data.orderDetail;
                                    if (dTSDKOrderDetail.isAvailable()) {
                                        CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, (ITravelOrderListener) null);
                                    }
                                    SplitFareOnServicePresenter.this.doPublish(BaseEventKeys.OnService.FARE_SUCCESS_UPDATE);
                                }
                            }

                            public void onError(UpdateSplitFarePartner updateSplitFarePartner) {
                                super.onError(updateSplitFarePartner);
                                ToastHelper.showShortInfo(SplitFareOnServicePresenter.this.mContext, updateSplitFarePartner.errmsg);
                            }

                            public void onFail(UpdateSplitFarePartner updateSplitFarePartner) {
                                super.onFail(updateSplitFarePartner);
                                ToastHelper.showShortInfo(SplitFareOnServicePresenter.this.mContext, updateSplitFarePartner.errmsg);
                            }
                        });
                        SplitFareOnServicePresenter.this.f15990a.dismiss();
                    }

                    public void onNegativeClick() {
                        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_CANCELNO_BTN_CK);
                        SplitFareOnServicePresenter.this.f15990a.dismiss();
                    }
                });
                SplitFareOnServicePresenter.this.f15990a.show();
            }
        });
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                if (!SplitFareOnServicePresenter.this.mRemoved && CarOrderHelper.getOrderCode() == OrderStatus.QUIT_SPLIT_FARE_CODE) {
                    SplitFareOnServicePresenter.this.m11732a(CarOrderHelper.getOrder().orderState.msg);
                }
            }
        });
        subscribe(BaseEventKeys.OnService.SPLIT_FARE_USER_REFUSE_SPLIT, new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                SplitFareOnServicePresenter.this.onStopSplitFare();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11739d() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), order.oid, new ITravelOrderListener() {
                public void onError(int i, String str) {
                }

                public void onFail(int i, String str) {
                }

                public void onTimeout(String str) {
                }

                public void onSuccess(ICarOrder iCarOrder) {
                    if (!SplitFareOnServicePresenter.this.mRemoved) {
                        SplitFareOnServicePresenter.this.doPublish(BaseEventKeys.OnService.FARE_SUCCESS_UPDATE);
                        SplitFareOnServicePresenter.this.doPublish(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11732a(String str) {
        if (TextUtils.isEmpty(str)) {
            m11740e();
        } else if (!isDialogShowing()) {
            NormalDialogInfo normalDialogInfo = new NormalDialogInfo(f15986b);
            normalDialogInfo.setMessage(HighlightUtil.highlight(this.mContext, str));
            normalDialogInfo.setCloseVisible(false);
            normalDialogInfo.setCancelable(false);
            normalDialogInfo.setIconVisible(false);
            normalDialogInfo.setPositiveText(ResourcesHelper.getString(this.mContext, R.string.car_me_known));
            showDialog(normalDialogInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        if (i == f15986b) {
            m11740e();
        }
    }

    public SplitFareOnServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        GlobalCommonBottomPop globalCommonBottomPop = this.f15990a;
        if (globalCommonBottomPop == null || !globalCommonBottomPop.isShowing()) {
            return super.onBackPressed(backType);
        }
        this.f15990a.dismiss();
        return true;
    }

    public void onStopSplitFare() {
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_STOP_BTN_CK);
        final CarOrder order = CarOrderHelper.getOrder();
        GlobalCommonBottomPop.BottomPopModel bottomPopModel = new GlobalCommonBottomPop.BottomPopModel();
        bottomPopModel.isShowNegative = true;
        bottomPopModel.positive = ResourcesHelper.getString(this.mContext, R.string.car_confirm);
        bottomPopModel.negative = ResourcesHelper.getString(this.mContext, R.string.global_share_cancel_btn_text);
        DTSDKSplitFareInfo.SplitUser splitFareOwner = SplitFareManager.getSplitFareOwner(order);
        bottomPopModel.title = ResourcesHelper.getString(this.mContext, R.string.g_splitfare_user_exit_title, splitFareOwner != null ? splitFareOwner.nick : "");
        bottomPopModel.content = ResourcesHelper.getString(this.mContext, R.string.g_splitfare_user_exit_sub_title);
        GlobalCommonBottomPop globalCommonBottomPop = new GlobalCommonBottomPop(this.mContext, bottomPopModel);
        this.f15990a = globalCommonBottomPop;
        globalCommonBottomPop.setBottomActionListener(new GlobalCommonBottomPop.GlobalBottomPopActionListener() {
            public void onPositiveClick() {
                SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_QUITCFM_BTN_CK);
                SplitFareOnServicePresenter.this.f15990a.dismiss();
                ((ISplitFareOnServiceView) SplitFareOnServicePresenter.this.mView).loading(true);
                HashMap hashMap = new HashMap();
                hashMap.put("order_id", order.getOid());
                new SplitFareManager(SplitFareOnServicePresenter.this.mContext).rejectSplitFare(hashMap, new ResponseListener<UpdateSplitFareInfo>() {
                    public void onSuccess(UpdateSplitFareInfo updateSplitFareInfo) {
                        if (!SplitFareOnServicePresenter.this.mRemoved) {
                            ((ISplitFareOnServiceView) SplitFareOnServicePresenter.this.mView).loading(false);
                            SplitFareOnServicePresenter.this.m11740e();
                        }
                    }

                    public void onError(UpdateSplitFareInfo updateSplitFareInfo) {
                        if (!SplitFareOnServicePresenter.this.mRemoved) {
                            ((ISplitFareOnServiceView) SplitFareOnServicePresenter.this.mView).loading(false);
                            ToastHelper.showShortInfo(SplitFareOnServicePresenter.this.mContext, updateSplitFareInfo.errmsg);
                        }
                    }

                    public void onFail(UpdateSplitFareInfo updateSplitFareInfo) {
                        if (!SplitFareOnServicePresenter.this.mRemoved) {
                            ((ISplitFareOnServiceView) SplitFareOnServicePresenter.this.mView).loading(false);
                            if (updateSplitFareInfo.errno == 700017) {
                                SplitFareOnServicePresenter.this.m11740e();
                            } else {
                                ToastHelper.showShortInfo(SplitFareOnServicePresenter.this.mContext, updateSplitFareInfo.errmsg);
                            }
                        }
                    }
                });
            }

            public void onNegativeClick() {
                SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_QUITCANCEL_BTN_CK);
                SplitFareOnServicePresenter.this.f15990a.dismiss();
            }
        });
        this.f15990a.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11740e() {
        NotificationUtils.getInstance(this.mContext).hideNotification();
        goBackRoot();
        DDTravelOrderStore.setOrder((ICarOrder) null);
    }
}
