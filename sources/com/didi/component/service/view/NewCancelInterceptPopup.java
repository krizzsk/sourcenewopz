package com.didi.component.service.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.cancelintercept.CancelInterceptRequest;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.WaitRspCancelEvent;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.util.UiHelper;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.OnServiceOmegaUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.monitor.PubSIDManager;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.log.LogOutput;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class NewCancelInterceptPopup extends SimplePopupBase implements View.OnClickListener {
    public static final String KEY_CANCEL_TRIP = "key_cancel_trip";
    public static final String KEY_SUB_TITLE = "key_sub_title";

    /* renamed from: c */
    private static final String f15801c = "CancelInterceptPopup";

    /* renamed from: o */
    private static final int f15802o = 30000;

    /* renamed from: p */
    private static final int f15803p = 1;

    /* renamed from: q */
    private static final int f15804q = 2;

    /* renamed from: r */
    private static final String f15805r = "cancellation_fee_waived";

    /* renamed from: A */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15806A = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (NewCancelInterceptPopup.this.isAdded() && !NewCancelInterceptPopup.this.isDetached() && !NewCancelInterceptPopup.this.isRemoving()) {
                NewCancelInterceptPopup.this.dismissAllowingStateLoss();
            }
        }
    };

    /* renamed from: B */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15807B = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (NewCancelInterceptPopup.this.isAdded() && !NewCancelInterceptPopup.this.isDetached() && !NewCancelInterceptPopup.this.isRemoving()) {
                NewCancelInterceptPopup.this.dismissAllowingStateLoss();
            }
        }
    };

    /* renamed from: C */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15808C = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (NewCancelInterceptPopup.this.isAdded() && !NewCancelInterceptPopup.this.isDetached() && !NewCancelInterceptPopup.this.isRemoving()) {
                NewCancelInterceptPopup.this.m11539c();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: D */
    public Runnable f15809D = new Runnable() {
        public void run() {
            NewCancelInterceptPopup.this.m11527a(1);
        }
    };

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15810a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            NewCancelInterceptPopup.this.m11543d();
            if (!CarOrderHelper.isOnService()) {
                NewCancelInterceptPopup.this.m11549g();
            } else if (NewCancelInterceptPopup.this.isAdded() && !NewCancelInterceptPopup.this.isDetached() && !NewCancelInterceptPopup.this.isRemoving()) {
                NewCancelInterceptPopup.this.dismissAllowingStateLoss();
            }
        }
    };

    /* renamed from: b */
    ResponseListener<CarCancelTrip> f15811b = new ResponseListener<CarCancelTrip>() {
        public void onError(CarCancelTrip carCancelTrip) {
            super.onError(carCancelTrip);
            CarHttpHelper.validate(NewCancelInterceptPopup.this.getActivity(), carCancelTrip);
        }

        public void onFail(CarCancelTrip carCancelTrip) {
            super.onFail(carCancelTrip);
            if (!CarHttpHelper.validate(NewCancelInterceptPopup.this.getActivity(), carCancelTrip) && carCancelTrip != null && carCancelTrip.errno == 22152) {
                new CancelInterceptRequest(NewCancelInterceptPopup.this.f15824t).loadOrderDetailAndJump(NewCancelInterceptPopup.this.f15826v, carCancelTrip.reassignOid, new ResponseListener<CarOrder>() {
                    public void onFinish(CarOrder carOrder) {
                        super.onFinish(carOrder);
                        NewCancelInterceptPopup.this.dismissAllowingStateLoss();
                        if (NewCancelInterceptPopup.this.f15827w != null) {
                            NewCancelInterceptPopup.this.f15827w.onCancel();
                        }
                    }
                });
            }
        }

        public void onFinish(CarCancelTrip carCancelTrip) {
            GLog.m7965d(NewCancelInterceptPopup.f15801c, carCancelTrip != null ? carCancelTrip.toString() : "");
            NewCancelInterceptPopup.this.m11532a(carCancelTrip);
            if (NewCancelInterceptPopup.this.f15825u != null) {
                NewCancelInterceptPopup.this.f15825u.removeCallbacks(NewCancelInterceptPopup.this.f15809D);
                NewCancelInterceptPopup.this.f15825u.postDelayed(NewCancelInterceptPopup.this.f15809D, 30000);
            }
        }
    };

    /* renamed from: d */
    private final Logger f15812d = LoggerFactory.getLogger(getClass());

    /* renamed from: e */
    private CancelInterceptScene f15813e = CancelInterceptScene.wait_rsp;

    /* renamed from: f */
    private View f15814f;

    /* renamed from: g */
    private TextView f15815g;

    /* renamed from: h */
    private TextView f15816h;

    /* renamed from: i */
    private View f15817i;

    /* renamed from: j */
    private TextView f15818j;

    /* renamed from: k */
    private TextView f15819k;

    /* renamed from: l */
    private View f15820l;

    /* renamed from: m */
    private ImageView f15821m;

    /* renamed from: n */
    private String f15822n;

    /* renamed from: s */
    private String f15823s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Context f15824t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Handler f15825u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ComponentParams f15826v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public IStateListener f15827w;

    /* renamed from: x */
    private String f15828x;

    /* renamed from: y */
    private LottieAnimationView f15829y;

    /* renamed from: z */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15830z = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (NewCancelInterceptPopup.this.isAdded() && !NewCancelInterceptPopup.this.isDetached() && !NewCancelInterceptPopup.this.isRemoving()) {
                NewCancelInterceptPopup.this.dismissAllowingStateLoss();
            }
        }
    };

    public enum CancelInterceptScene {
        wait_rsp,
        on_service
    }

    public interface IStateListener {
        void onBack();

        void onCancel();
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_new_cancel_intercept_popup;
    }

    public static void show(FragmentManager fragmentManager, CancelInterceptScene cancelInterceptScene, ComponentParams componentParams, Bundle bundle, String str, IStateListener iStateListener) {
        NewCancelInterceptPopup newCancelInterceptPopup = new NewCancelInterceptPopup();
        newCancelInterceptPopup.f15813e = cancelInterceptScene;
        newCancelInterceptPopup.f15826v = componentParams;
        newCancelInterceptPopup.f15825u = new Handler();
        newCancelInterceptPopup.f15827w = iStateListener;
        newCancelInterceptPopup.f15828x = str;
        newCancelInterceptPopup.setCancelable(false);
        if (bundle != null) {
            newCancelInterceptPopup.setArguments(bundle);
        }
        newCancelInterceptPopup.show(fragmentManager, f15801c);
    }

    public static void show(FragmentManager fragmentManager, CancelInterceptScene cancelInterceptScene, ComponentParams componentParams, Bundle bundle, IStateListener iStateListener) {
        show(fragmentManager, cancelInterceptScene, componentParams, bundle, (String) null, iStateListener);
    }

    public static void show(FragmentManager fragmentManager, CancelInterceptScene cancelInterceptScene, ComponentParams componentParams, Bundle bundle) {
        show(fragmentManager, cancelInterceptScene, componentParams, bundle, (IStateListener) null);
    }

    /* renamed from: a */
    private void m11526a() {
        if (isAdded() && !isDetached() && !isRemoving()) {
            if (!TextUtils.isEmpty(this.f15822n)) {
                this.f15816h.setVisibility(0);
                this.f15816h.setText(this.f15822n);
                return;
            }
            this.f15816h.setVisibility(8);
        }
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.f15822n = bundle.getString("key_sub_title", "");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f15824t = context;
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f15810a);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LEAVE_PAGE, this.f15830z);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_LEAVE_PAGE, this.f15807B);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LOAD_ORDERDETAIL_SUCCESS, this.f15808C);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.WaitRsp.EVENT_CANCEL_ORDER_FINISH, this.f15806A);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST, this.f15807B);
    }

    public void onDetach() {
        super.onDetach();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f15810a);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LEAVE_PAGE, this.f15830z);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_LEAVE_PAGE, this.f15807B);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LOAD_ORDERDETAIL_SUCCESS, this.f15808C);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.WaitRsp.EVENT_CANCEL_ORDER_FINISH, this.f15806A);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST, this.f15807B);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(true);
        return onCreateDialog;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!m11551h()) {
            if (view.getId() == R.id.tv_cancel_intercept_no) {
                dismissAllowingStateLoss();
                if (this.f15813e == CancelInterceptScene.wait_rsp) {
                    dialogClickNoEvent();
                }
            } else if (view.getId() == R.id.tv_cancel_intercept_cancel) {
                if (this.f15813e == CancelInterceptScene.wait_rsp) {
                    postCancelOrder();
                    dialogClickYesEvent();
                } else {
                    postCancelTrip(2, "");
                }
                m11535b();
            } else if (view.getId() == R.id.tv_cancel_rule) {
                String buildUrl = GlobalWebUrl.buildUrl(this.f15823s, m11525a(CarOrderHelper.getOrder()));
                if (!TextUtils.isEmpty(buildUrl)) {
                    m11534a(buildUrl, ResourcesHelper.getString(this.f15824t, R.string.global_cancel_intercept_policy));
                }
            } else if (view.getId() == R.id.tv_cancel_intercept_update) {
                GlobalOmegaUtils.trackEvent("gp_cancel_panel_change_pickup_point_ck");
                OnServiceOmegaUtil.setOmegaParamUpdatePickUpChannelPreCancel();
                dismissAllowingStateLoss();
                IStateListener iStateListener = this.f15827w;
                if (iStateListener != null) {
                    iStateListener.onBack();
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_ONSERVICE_FORWARD_PICKUP_PAGE);
            }
        }
    }

    /* renamed from: b */
    private void m11535b() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FILE_OOM_KEY, 2);
        PubSIDManager.getInstance().setPubSID(hashMap);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f15814f = this.mRootView.findViewById(R.id.ll_cancel_intercept_content);
        this.f15815g = (TextView) this.mRootView.findViewById(R.id.tv_cancel_intercept_title);
        this.f15816h = (TextView) this.mRootView.findViewById(R.id.tv_cancel_intercept_subtitle);
        this.f15817i = this.mRootView.findViewById(R.id.tv_cancel_rule);
        this.f15820l = this.mRootView.findViewById(R.id.ll_cancel_pickup);
        this.f15818j = (TextView) this.mRootView.findViewById(R.id.tv_cancel_intercept_no);
        this.f15819k = (TextView) this.mRootView.findViewById(R.id.tv_cancel_intercept_cancel);
        this.f15821m = (ImageView) this.mRootView.findViewById(R.id.ll_reminder_img);
        this.f15829y = (LottieAnimationView) this.mRootView.findViewById(R.id.animation_view);
        m11543d();
        this.f15818j.setOnClickListener(this);
        this.f15819k.setOnClickListener(this);
        this.mRootView.findViewById(R.id.tv_cancel_intercept_update).setOnClickListener(this);
        this.f15817i.setOnClickListener(this);
        m11539c();
        m11526a();
        CarCancelTrip carCancelTrip = (CarCancelTrip) getArguments().getSerializable(KEY_CANCEL_TRIP);
        if (carCancelTrip != null) {
            m11532a(carCancelTrip);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11539c() {
        if (this.f15813e == CancelInterceptScene.wait_rsp) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order == null || order.cancelInfo == null || TextUtils.isEmpty(order.cancelInfo.cancelTitle)) {
                this.f15815g.setText(R.string.global_cancel_intercept_waitrsp_title);
            } else {
                this.f15815g.setText(order.cancelInfo.cancelTitle);
            }
        }
    }

    public void onResume() {
        TextView textView;
        super.onResume();
        if (this.f15813e == CancelInterceptScene.on_service && (textView = this.f15815g) != null && TextUtils.isEmpty(textView.getText())) {
            this.f15815g.setText(R.string.global_cancel_intercept_waitrsp_title);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11543d() {
        boolean z = false;
        if (!m11545e() || this.f15820l == null || this.f15813e != CancelInterceptScene.on_service) {
            this.f15820l.setVisibility(8);
        } else {
            this.f15820l.setVisibility(0);
            z = true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("change_pickup_point_show", z ? "1" : "0");
        GlobalOmegaUtils.trackEvent("gp_precancel_panel_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11527a(int i) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && getContext() != null && !m11551h()) {
            showLoading();
            HashMap hashMap = null;
            if (!TextUtils.isEmpty(this.f15828x)) {
                hashMap = new HashMap();
                hashMap.put(ParamKeys.PARAM_CANCEL_REASON, this.f15828x);
            }
            CarRequest.cancelTrip(getContext(), order.oid, 1, i, "", hashMap, this.f15811b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11532a(CarCancelTrip carCancelTrip) {
        TextView textView;
        TextView textView2;
        hideLoading();
        if (carCancelTrip != null && !m11551h()) {
            View view = this.f15814f;
            if (view != null) {
                view.setVisibility(0);
            }
            if (!TextUtils.isEmpty(carCancelTrip.feeMsg)) {
                this.f15815g.setText(carCancelTrip.feeMsg);
            }
            if (TextUtils.isEmpty(carCancelTrip.feeExplainMsg)) {
                this.f15816h.setVisibility(8);
            } else {
                this.f15816h.setVisibility(0);
                this.f15816h.setText(carCancelTrip.feeExplainMsg);
            }
            if (TextUtils.isEmpty(carCancelTrip.controlReminderImage)) {
                this.f15821m.setVisibility(8);
            } else {
                this.f15821m.setVisibility(0);
                Glide.with(getContext()).asBitmap().load((Object) new GlideUrl(carCancelTrip.controlReminderImage)).into(this.f15821m);
            }
            m11543d();
            this.f15817i.setVisibility(0);
            if (!TextUtils.isEmpty(carCancelTrip.uncancelButton) && (textView2 = this.f15818j) != null) {
                textView2.setText(carCancelTrip.uncancelButton);
            }
            if (!TextUtils.isEmpty(carCancelTrip.cancelButton) && (textView = this.f15819k) != null) {
                textView.setText(carCancelTrip.cancelButton);
            }
            if (carCancelTrip.show_alert_img == 1) {
                this.f15823s = carCancelTrip.cancelruleUrl;
            }
            if (TextUtils.isEmpty(carCancelTrip.cancelruleUrl)) {
                this.f15817i.setVisibility(8);
            } else {
                this.f15817i.setVisibility(0);
            }
        }
    }

    /* renamed from: e */
    private boolean m11545e() {
        if (CarOrderHelper.isCarPoolLineHaveOrder() || CarOrderHelper.isOnService() || CarOrderHelper.isDriverArrival()) {
            return false;
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.showUpdatePickUpPop) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11538b(CarCancelTrip carCancelTrip) {
        hideLoading();
        if (carCancelTrip != null) {
            int errorCode = carCancelTrip.getErrorCode();
            String errorMsg = carCancelTrip.getErrorMsg();
            NotificationUtils.getInstance(this.f15824t).hideNotification();
            this.f15812d.info(LogOutput.showOutputLog(carCancelTrip, "get cancel trip result"), new Object[0]);
            if (errorCode == 1035) {
                if (!TextUtil.isEmpty(errorMsg)) {
                    ToastHelper.showShortInfo(getContext(), errorMsg);
                }
                m11533a((CarCancelTrip) null, errorCode);
            } else if (errorCode == 596) {
                Context context = this.f15824t;
                ToastHelper.showShortInfo(context, ResourcesHelper.getString(context, R.string.global_system_busy_click_toast), (int) R.drawable.global_toast_error);
            } else if (CarHttpHelper.validate(getActivity(), carCancelTrip)) {
                m11547f();
                ToastHelper.showShortInfo(getContext(), ResourcesHelper.getString(getContext(), R.string.global_rider_cancel_success));
                m11541c(carCancelTrip);
            }
        }
    }

    /* renamed from: c */
    private void m11541c(final CarCancelTrip carCancelTrip) {
        String str = carCancelTrip.title;
        String str2 = carCancelTrip.explainText;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            m11533a(carCancelTrip, 0);
        } else if (((FragmentActivity) this.f15824t).getSupportFragmentManager() != null) {
            AlertDialogFragment.Builder alertDialogBuilder = UiHelper.getAlertDialogBuilder(this.f15824t);
            alertDialogBuilder.setTitle(str).setMessage(str2).setPositiveButton((CharSequence) ResourcesHelper.getString(this.f15824t, R.string.cancellation_fee_waived_dialog_confirm), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    NewCancelInterceptPopup.this.m11533a(carCancelTrip, 0);
                    alertDialogFragment.dismiss();
                }
            }).setPositiveButtonDefault();
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.create().show(((FragmentActivity) this.f15824t).getSupportFragmentManager(), f15805r);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11533a(CarCancelTrip carCancelTrip, int i) {
        CarOrder order;
        Runnable runnable;
        Handler handler = this.f15825u;
        if (!(handler == null || (runnable = this.f15809D) == null)) {
            handler.removeCallbacks(runnable);
        }
        if (!(carCancelTrip == null || carCancelTrip.errno != 0 || (order = CarOrderHelper.getOrder()) == null)) {
            order.carCancelTrip = carCancelTrip;
            CarOrderHelper.saveOrder(order);
        }
        if (carCancelTrip == null) {
            carCancelTrip = new CarCancelTrip();
        }
        carCancelTrip.errno = i;
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseExtras.CancelService.EXTRA_CANCEL_TRIP_CONTENT, carCancelTrip);
        Intent intent = new Intent();
        intent.putExtra(BaseExtras.CancelService.EXTRA_CANCEL_TRIP_DATA, bundle);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_ONSERVICE_NATIVE_CANCEL_INTERCEPT_RESULT, intent);
        dismissAllowingStateLoss();
        IStateListener iStateListener = this.f15827w;
        if (iStateListener != null) {
            iStateListener.onCancel();
        }
    }

    /* renamed from: f */
    private void m11547f() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.comboType == 500 && order.carDriver != null) {
            CarRequest.notifyDriverStateOfPsg(this.f15824t, 2, order.carDriver.did, (ResponseListener<BaseObject>) null);
        }
    }

    /* renamed from: a */
    private Map<String, Object> m11525a(CarOrder carOrder) {
        ArrayMap arrayMap = new ArrayMap();
        String valueOf = carOrder.startAddress != null ? String.valueOf(carOrder.startAddress.getCityId()) : null;
        if (valueOf == null) {
            valueOf = String.valueOf(LocationController.getCurrentLocationCityId());
        }
        double latitude = carOrder.startAddress != null ? carOrder.startAddress.getLatitude() : LocationController.getInstance().getLat(this.f15824t);
        double longitude = carOrder.startAddress != null ? carOrder.startAddress.getLongitude() : LocationController.getInstance().getLng(this.f15824t);
        arrayMap.put("token", NationComponentDataUtil.getToken());
        arrayMap.put("area", valueOf);
        arrayMap.put("lat", Double.valueOf(latitude));
        arrayMap.put("lng", Double.valueOf(longitude));
        if (carOrder.carLevel != null) {
            arrayMap.put("car_level", carOrder.carLevel);
        }
        arrayMap.put("appversion", SystemUtil.getVersionName(this.f15824t));
        arrayMap.put("oid", carOrder.oid);
        arrayMap.put("car_pool", Integer.valueOf(carOrder.flierFeature.carPool));
        arrayMap.put(ParamKeys.PARAM_CONTROL, 0);
        arrayMap.put(ParamKeys.PARAM_DISTRICT, carOrder.disTrict);
        arrayMap.put("business_id", Integer.valueOf(carOrder.productid));
        return arrayMap;
    }

    /* renamed from: a */
    private void m11534a(String str, String str2) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.title = str2;
        webViewModel.url = str;
        webViewModel.isSupportCache = false;
        webViewModel.isPostBaseParams = false;
        Intent intent = new Intent(getActivity(), WebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        startActivity(intent);
    }

    public void postCancelOrder() {
        if (CarOrderHelper.getOrder() != null) {
            showLoading();
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.CancelOrder.EVENT_REQUEST_ACTION_CANCEL_ORDER, new WaitRspCancelEvent(true));
        }
    }

    public void postCancelTrip(int i, String str) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            showLoading();
            C70669 r7 = new ResponseListener<CarCancelTrip>() {
                public void onError(CarCancelTrip carCancelTrip) {
                    super.onError(carCancelTrip);
                    CarHttpHelper.validate(NewCancelInterceptPopup.this.getActivity(), carCancelTrip);
                }

                public void onFail(CarCancelTrip carCancelTrip) {
                    super.onFail(carCancelTrip);
                    if (!CarHttpHelper.validate(NewCancelInterceptPopup.this.getActivity(), carCancelTrip) && carCancelTrip != null && carCancelTrip.errno == 22152) {
                        new CancelInterceptRequest(NewCancelInterceptPopup.this.f15824t).loadOrderDetailAndJump(NewCancelInterceptPopup.this.f15826v, carCancelTrip.reassignOid, new ResponseListener<CarOrder>() {
                            public void onFinish(CarOrder carOrder) {
                                super.onFinish(carOrder);
                                NewCancelInterceptPopup.this.dismissAllowingStateLoss();
                                if (NewCancelInterceptPopup.this.f15827w != null) {
                                    NewCancelInterceptPopup.this.f15827w.onCancel();
                                }
                            }
                        });
                    }
                }

                public void onFinish(CarCancelTrip carCancelTrip) {
                    NewCancelInterceptPopup.this.m11538b(carCancelTrip);
                }
            };
            HashMap hashMap = null;
            if (!TextUtils.isEmpty(this.f15828x)) {
                hashMap = new HashMap();
                hashMap.put(ParamKeys.PARAM_CANCEL_REASON, this.f15828x);
            }
            CarRequest.cancelTrip(this.f15824t, order.oid, 1, i, str, hashMap, r7);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m11549g() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && 4 == order.status && 4003 == order.substatus && this.f15813e == CancelInterceptScene.on_service) {
            m11527a(1);
        }
    }

    /* renamed from: h */
    private boolean m11551h() {
        return !isAdded() || isDetached() || isRemoving();
    }

    public void dismissAllowingStateLoss() {
        Runnable runnable;
        super.dismissAllowingStateLoss();
        Handler handler = this.f15825u;
        if (handler != null && (runnable = this.f15809D) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void showLoading() {
        this.f15819k.setVisibility(8);
        this.f15829y.setRepeatCount(-1);
        this.f15829y.setVisibility(0);
        this.f15829y.playAnimation();
    }

    public void hideLoading() {
        this.f15819k.setVisibility(0);
        this.f15829y.cancelAnimation();
        this.f15829y.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void dialogClickYesEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(CarOrderHelper.getReAssignOrderType()));
        hashMap.put("fixed", FormStore.getInstance().isCountPriceTypeFixed() ? "1" : "0");
        hashMap.put(ParamConst.PARAM_WAIT_TIME, String.valueOf((System.currentTimeMillis() - CarOrderHelper.getOrderCreateTime()) / 1000));
        GlobalOmegaUtils.trackEvent("pas_waitforresponse_cancelconfdlgyes_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void dialogClickNoEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(CarOrderHelper.getReAssignOrderType()));
        hashMap.put("fixed", FormStore.getInstance().isCountPriceTypeFixed() ? "1" : "0");
        hashMap.put(ParamConst.PARAM_WAIT_TIME, String.valueOf((TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - CarOrderHelper.getOrderCreateTime()) / 1000));
        GlobalOmegaUtils.trackEvent("pas_waitforresponse_cancelconfdlgno_ck", (Map<String, Object>) hashMap);
    }
}
