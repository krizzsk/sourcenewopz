package com.didi.component.safetoolkit.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.model.SafeToolkitBean;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.ISafeToolkitView;
import com.didi.component.safetoolkit.api.requests.SafeToolkitBffRequest;
import com.didi.component.safetoolkit.utils.SafetoolkitOmegaUtils;
import com.didi.component.safetoolkit.views.MonitorInterceptPopup;
import com.didi.safetoolkit.api.SfConstant;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public abstract class AbsSafeToolkitPresenter extends BaseExpressPresenter<ISafeToolkitView> implements View.OnClickListener {

    /* renamed from: a */
    private static final int f15375a = 2;

    /* renamed from: b */
    private static final int f15376b = 3;

    /* renamed from: c */
    private static final int f15377c = 4;

    /* renamed from: d */
    private static final int f15378d = 3;

    /* renamed from: j */
    private static boolean f15379j = true;

    /* renamed from: k */
    private static boolean f15380k = true;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static String f15381l = null;

    /* renamed from: m */
    private static int f15382m = -1;

    /* renamed from: n */
    private static int f15383n = -1;

    /* renamed from: t */
    private static final int f15384t = 12;
    protected BaseEventPublisher.OnEventListener<Boolean> alphaListener = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            ((ISafeToolkitView) AbsSafeToolkitPresenter.this.mView).setDismissedByAlpha(bool.booleanValue());
        }
    };

    /* renamed from: e */
    private int f15385e;

    /* renamed from: f */
    private int f15386f;

    /* renamed from: g */
    private float f15387g = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<SafeToolkitBean.SafeToolkitData> f15388h = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f15389i = false;
    protected boolean isPause;
    protected ComponentParams mComponentParams;
    protected SafeToolkitBean.SafeToolkitData mCurrentSFData = null;
    protected BaseEventPublisher.OnEventListener mMonitorStatusChanged = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            boolean unused = AbsSafeToolkitPresenter.this.f15391q = true;
            AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
        }
    };
    protected BaseEventPublisher.OnEventListener mOnEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED)) {
                AbsSafeToolkitPresenter.this.onXPanelDefaultHeightChanged(num.intValue());
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnScrollEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER)) {
                AbsSafeToolkitPresenter.this.onXPanelScrollChanged(num.intValue());
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mRealTimeMonitorListener = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            String str3;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                JSONObject optJSONObject = jSONObject.optJSONObject("trip_monitor_push");
                if (optJSONObject != null) {
                    optJSONObject.optInt("level");
                    optJSONObject.optString("push_id");
                    optJSONObject.optString(ParamKeys.PARAM_DISTRICT);
                    str3 = optJSONObject.optString("text");
                } else {
                    str3 = "";
                }
                jSONObject.optString("order_id");
                NotificationUtils.getInstance(AbsSafeToolkitPresenter.this.mContext).showNotification("", str3);
                if (!AppUtils.isAppForeground(AbsSafeToolkitPresenter.this.mContext)) {
                    GlobalOmegaUtils.trackEvent("gp_apppush_message_sw");
                }
                AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
                GLog.m7971i("mRealTimeMonitorListener", "receive warning push:" + str3);
            } catch (Exception e) {
                GLog.m7971i("mRealTimeMonitorListener", e.getMessage());
            }
        }
    };
    protected SafeToolkitBean mSafeToolkitBean = null;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Handler f15390p = new BubbleDisplayHandler();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f15391q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public MonitorInterceptPopup f15392r = null;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f15393s;

    /* renamed from: u */
    private BroadcastReceiver f15394u = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                GLog.m7971i("mActionChangedReceiver", "action:" + action);
                if (action != null) {
                    char c = 65535;
                    switch (action.hashCode()) {
                        case -1698865573:
                            if (action.equals(SfConstant.SfAction.ACTION_EMERGENCY_ASSIST_ON)) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1217465591:
                            if (action.equals(SfConstant.SfAction.ACTION_SHARE_FAILED)) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1125225357:
                            if (action.equals(SfConstant.SfAction.ACTION_EMERGENCY_ASSIST_OFF)) {
                                c = 5;
                                break;
                            }
                            break;
                        case -17912362:
                            if (action.equals(SfConstant.SfAction.ACTION_START_SHARE)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 132692663:
                            if (action.equals(SfConstant.SfAction.ACTION_SHARE_SUCCESS)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 2062997172:
                            if (action.equals(BaseEventKeys.SafeToolkit.ACTION_UPDATE_SAFETY_SWITCH)) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (c != 2) {
                                if (c != 3) {
                                    if (c == 4) {
                                        GlobalSPUtil.setSFIsReportingPolice(AbsSafeToolkitPresenter.this.mContext, true);
                                        if (AbsSafeToolkitPresenter.this.refreshVisibility()) {
                                            AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
                                        }
                                    } else if (c == 5) {
                                        GlobalSPUtil.setSFIsReportingPolice(AbsSafeToolkitPresenter.this.mContext, false);
                                        if (AbsSafeToolkitPresenter.this.refreshVisibility()) {
                                            AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
                                        }
                                    } else if (AbsSafeToolkitPresenter.this.refreshVisibility()) {
                                        AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
                                    }
                                } else if (AbsSafeToolkitPresenter.this.refreshVisibility()) {
                                    AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
                                }
                            } else if (!AbsSafeToolkitPresenter.this.isPause) {
                                SafeToolkitBean.SafeToolkitData safeToolkitData = new SafeToolkitBean.SafeToolkitData();
                                safeToolkitData.show = 5;
                                safeToolkitData.state = 3;
                                safeToolkitData.content = AbsSafeToolkitPresenter.this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_do_sharing, new Object[]{AbsSafeToolkitPresenter.f15381l});
                                AbsSafeToolkitPresenter.this.m11055a(safeToolkitData);
                            }
                        } else if (!AbsSafeToolkitPresenter.this.isPause) {
                            SafeToolkitBean.SafeToolkitData safeToolkitData2 = new SafeToolkitBean.SafeToolkitData();
                            safeToolkitData2.show = 5;
                            safeToolkitData2.state = 2;
                            safeToolkitData2.content = AbsSafeToolkitPresenter.this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_share_sms_field, new Object[]{AbsSafeToolkitPresenter.f15381l});
                            AbsSafeToolkitPresenter.this.m11055a(safeToolkitData2);
                        }
                    } else if (!AbsSafeToolkitPresenter.this.isPause) {
                        SafeToolkitBean.SafeToolkitData safeToolkitData3 = new SafeToolkitBean.SafeToolkitData();
                        safeToolkitData3.show = 5;
                        safeToolkitData3.state = 4;
                        safeToolkitData3.content = AbsSafeToolkitPresenter.this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_share_sms_success, new Object[]{AbsSafeToolkitPresenter.f15381l});
                        AbsSafeToolkitPresenter.this.m11055a(safeToolkitData3);
                    }
                }
            }
        }
    };

    /* renamed from: v */
    private BaseEventPublisher.OnEventListener f15395v = new BaseEventPublisher.OnEventListener<Float>() {
        public void onEvent(String str, Float f) {
            if (BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA.equals(str)) {
                ((ISafeToolkitView) AbsSafeToolkitPresenter.this.mView).getView().setAlpha(f.floatValue());
            }
        }
    };

    /* renamed from: w */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15396w = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AbsSafeToolkitPresenter.this.mView != null && ((ISafeToolkitView) AbsSafeToolkitPresenter.this.mView).isBubbleShown()) {
                if (!(AbsSafeToolkitPresenter.this.mContext != null && GlobalSPUtil.getSFIsReportingPolice(AbsSafeToolkitPresenter.this.mContext))) {
                    ((ISafeToolkitView) AbsSafeToolkitPresenter.this.mView).dismissBubble((Runnable) null);
                }
            }
        }
    };

    /* renamed from: x */
    private BaseEventPublisher.OnEventListener<Boolean> f15397x = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                SafeToolkitBean.SafeToolkitData safeToolkitData = new SafeToolkitBean.SafeToolkitData();
                safeToolkitData.show = -1;
                safeToolkitData.state = 10;
                safeToolkitData.content = AbsSafeToolkitPresenter.this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_trip_audio_recording);
                AbsSafeToolkitPresenter.this.m11055a(safeToolkitData);
            }
        }
    };

    /* renamed from: y */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15398y = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AbsSafeToolkitPresenter.this.mSafeToolkitBean != null && AbsSafeToolkitPresenter.this.mSafeToolkitBean.sfViewMenuModelList != null) {
                Iterator<SfViewMenuModel> it = AbsSafeToolkitPresenter.this.mSafeToolkitBean.sfViewMenuModelList.iterator();
                while (it.hasNext()) {
                    SfViewMenuModel next = it.next();
                    if (next instanceof SfViewRecordMenuModel) {
                        String str2 = ((SfViewRecordMenuModel) next).detailLawUrl;
                        if (!TextUtils.isEmpty(str2)) {
                            Intent intent = new Intent(DIDIApplication.getAppContext(), BaseWebActivity.class);
                            WebViewModel webViewModel = new WebViewModel();
                            webViewModel.url = str2;
                            intent.putExtra("web_view_model", webViewModel);
                            intent.addFlags(268435456);
                            DIDIApplication.getAppContext().startActivity(intent);
                            return;
                        }
                    }
                }
            }
        }
    };

    /* renamed from: z */
    private ResponseListener<SafeToolkitBean> f15399z = new ResponseListener<SafeToolkitBean>() {
        public void onSuccess(SafeToolkitBean safeToolkitBean) {
            super.onSuccess(safeToolkitBean);
            AbsSafeToolkitPresenter.this.mSafeToolkitBean = safeToolkitBean;
            AbsSafeToolkitPresenter.this.f15388h.clear();
            if (AbsSafeToolkitPresenter.this.isValidBean(safeToolkitBean)) {
                if (safeToolkitBean.data.state == 5) {
                    AbsSafeToolkitPresenter.this.m11060a(safeToolkitBean.data.content);
                    safeToolkitBean.data.content = ResourcesHelper.getString(AbsSafeToolkitPresenter.this.mContext, R.string.sf_safe_toolkit_bubble_tap_to_share, AbsSafeToolkitPresenter.f15381l);
                }
                GLog.m7971i("showBubble", "requestSafeToolkitStatus 请求成功");
                AbsSafeToolkitPresenter.this.m11055a(safeToolkitBean.data);
            }
            if (AbsSafeToolkitPresenter.this.f15391q && safeToolkitBean != null) {
                SafeToolKit.getIns().updateSfDialogItem(safeToolkitBean.sfViewMenuModelList);
                if (SceneHelper.getInstance().monitorConfigCallback != null) {
                    SceneHelper.getInstance().monitorConfigCallback.onSuccess(safeToolkitBean.monitorMenuModel);
                }
            }
        }

        public void onError(SafeToolkitBean safeToolkitBean) {
            super.onError(safeToolkitBean);
            if (SceneHelper.getInstance().monitorConfigCallback != null && safeToolkitBean != null) {
                SceneHelper.getInstance().monitorConfigCallback.onFailed(safeToolkitBean.errmsg);
            }
        }

        public void onFail(SafeToolkitBean safeToolkitBean) {
            super.onFail(safeToolkitBean);
            if (SceneHelper.getInstance().monitorConfigCallback != null && safeToolkitBean != null) {
                SceneHelper.getInstance().monitorConfigCallback.onFailed(safeToolkitBean.errmsg);
            }
        }

        public void onFinish(SafeToolkitBean safeToolkitBean) {
            super.onFinish(safeToolkitBean);
            boolean unused = AbsSafeToolkitPresenter.this.f15391q = false;
            SceneHelper.getInstance().monitorConfigCallback = null;
        }
    };

    public boolean isValidData(SafeToolkitBean.SafeToolkitData safeToolkitData) {
        return safeToolkitData != null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean refreshVisibility();

    private static class BubbleDisplayHandler extends Handler {
        private WeakReference<AbsSafeToolkitPresenter> ref;

        private BubbleDisplayHandler(AbsSafeToolkitPresenter absSafeToolkitPresenter) {
            this.ref = new WeakReference<>(absSafeToolkitPresenter);
        }

        public void handleMessage(Message message) {
            WeakReference<AbsSafeToolkitPresenter> weakReference = this.ref;
            if (weakReference != null && weakReference.get() != null) {
                AbsSafeToolkitPresenter absSafeToolkitPresenter = (AbsSafeToolkitPresenter) this.ref.get();
                if (message.what == 8001) {
                    if (absSafeToolkitPresenter.f15388h.isEmpty()) {
                        absSafeToolkitPresenter.f15390p.removeMessages(8001);
                        if (absSafeToolkitPresenter.mCurrentSFData != null && absSafeToolkitPresenter.mCurrentSFData.show != -1) {
                            GLog.m7971i("showBubbleWithRules", "Handler 超时消失: isBubbleShown:" + ((ISafeToolkitView) absSafeToolkitPresenter.mView).isBubbleShown() + " isWelcomeShown:" + ((ISafeToolkitView) absSafeToolkitPresenter.mView).isWelcomeShown());
                            boolean unused = absSafeToolkitPresenter.f15389i = false;
                            absSafeToolkitPresenter.mCurrentSFData = null;
                            if (((ISafeToolkitView) absSafeToolkitPresenter.mView).isBubbleShown()) {
                                ((ISafeToolkitView) absSafeToolkitPresenter.mView).dismissBubble((Runnable) null);
                            } else if (((ISafeToolkitView) absSafeToolkitPresenter.mView).isWelcomeShown()) {
                                ((ISafeToolkitView) absSafeToolkitPresenter.mView).dismissWelcome((Runnable) null);
                            }
                        }
                    } else {
                        absSafeToolkitPresenter.mCurrentSFData = (SafeToolkitBean.SafeToolkitData) absSafeToolkitPresenter.f15388h.remove(0);
                        if (!absSafeToolkitPresenter.isPause) {
                            ((ISafeToolkitView) absSafeToolkitPresenter.mView).setSafeToolkitStatusAndShow(absSafeToolkitPresenter.mCurrentSFData);
                            if (absSafeToolkitPresenter.mCurrentSFData.state == 12) {
                                absSafeToolkitPresenter.f15390p.sendEmptyMessageDelayed(12, (long) (absSafeToolkitPresenter.mCurrentSFData.show * 1000));
                            }
                        }
                        if (absSafeToolkitPresenter.mCurrentSFData.show == -1) {
                            absSafeToolkitPresenter.f15388h.clear();
                            absSafeToolkitPresenter.f15390p.removeMessages(8001);
                            return;
                        }
                        absSafeToolkitPresenter.f15390p.sendEmptyMessageDelayed(8001, (long) (absSafeToolkitPresenter.mCurrentSFData.show * 1000));
                    }
                } else if (message.what == 12 && absSafeToolkitPresenter.mCurrentSFData != null && absSafeToolkitPresenter.mView != null && ((ISafeToolkitView) absSafeToolkitPresenter.mView).isBubbleShown()) {
                    absSafeToolkitPresenter.m11070d();
                }
            }
        }
    }

    public AbsSafeToolkitPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (f15382m == -1) {
            f15382m = GlobalSPUtil.getSFLeadAddPeopleBubbleShowTimes(this.mContext);
        }
        if (f15383n == -1) {
            f15383n = GlobalSPUtil.getSFWelcomeBubbleShowTimes(this.mContext);
        }
        PresenterHolder.getIns().onAdd(this);
        register();
        this.f15387g = TypedValue.applyDimension(1, 4.0f, this.mContext.getResources().getDisplayMetrics());
        ((ISafeToolkitView) this.mView).setOnClickListener(this);
        ((ISafeToolkitView) this.mView).setVisibility(false);
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_HEIGHT);
        doPublish(BaseEventKeys.XPanel.EVENT_REQUEST_FETCH_DEFAULT_SCROLL_HEIGHT);
    }

    /* access modifiers changed from: protected */
    public void requestSafeToolkitStatus() {
        if (!((ISafeToolkitView) this.mView).isVisibility()) {
            GLog.m7971i("showBubble", "requestSafeToolkitStatus 气泡未显示,不请求");
            return;
        }
        if (GlobalSPUtil.getSFIsReportingPolice(this.mContext)) {
            SafeToolkitBean.SafeToolkitData safeToolkitData = new SafeToolkitBean.SafeToolkitData();
            safeToolkitData.state = 1;
            safeToolkitData.show = -1;
            safeToolkitData.content = this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_reporting);
            m11055a(safeToolkitData);
        } else {
            SafeToolkitBean.SafeToolkitData safeToolkitData2 = this.mCurrentSFData;
            if (safeToolkitData2 != null && safeToolkitData2.state == 1 && !GlobalSPUtil.getSFIsReportingPolice(this.mContext)) {
                SafeToolkitBean.SafeToolkitData safeToolkitData3 = new SafeToolkitBean.SafeToolkitData();
                safeToolkitData3.state = 1;
                safeToolkitData3.show = 0;
                safeToolkitData3.content = this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_reporting);
                m11055a(safeToolkitData3);
            }
        }
        if (GlobalSPUtil.getSFIsReportingPolice(this.mContext)) {
            GLog.m7971i("showBubble", "requestSafeToolkitStatus 正在报警中不请求");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("new_guidecnt", Integer.valueOf(f15383n));
        hashMap.put("add_contactcnt", Integer.valueOf(f15382m));
        CarRequest.getSafetoolkitStatus(this.mContext, f15383n, f15382m, false, (!(this instanceof OnServiceSafeToolkitPresenter) && (this instanceof EndSafeToolkitPresenter)) ? 4 : 3, this.f15399z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11060a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = null;
            if (str.contains(",")) {
                int indexOf = str.indexOf(44);
                String substring = str.substring(0, indexOf);
                int i = indexOf + 1;
                if (i < str.length()) {
                    str2 = str.substring(i, str.length());
                }
                if (TextUtils.isEmpty(str2)) {
                    f15381l = substring;
                    return;
                }
                f15381l = String.format(this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_name_string), new Object[]{substring, str2});
                return;
            }
            f15381l = str;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11055a(SafeToolkitBean.SafeToolkitData safeToolkitData) {
        if (safeToolkitData.show != 0 || GlobalSPUtil.getSFIsReportingPolice(this.mContext)) {
            if (safeToolkitData.state == 1) {
                this.f15388h.clear();
                if (!((ISafeToolkitView) this.mView).isVisibility()) {
                    ((ISafeToolkitView) this.mView).setVisibility(true);
                }
                this.f15390p.removeMessages(8001);
                SfOmegaUtil.addEventId("gp_safetyToolkit_inHelpBub_sw").report();
            }
            if (safeToolkitData.state == 8) {
                OmegaSDKAdapter.trackEvent("gp_addAreaCode_popup_sw");
            } else if (safeToolkitData.state == 11) {
                this.f15393s = safeToolkitData.bubbleId;
                m11056a(this.mSafeToolkitBean);
            }
            if (m11068c(safeToolkitData)) {
                if (m11064b(safeToolkitData)) {
                    this.f15388h.add(safeToolkitData);
                    GLog.m7971i("showBubbleWithRules", "state:" + safeToolkitData.state + " 添加到队列:" + this.f15388h.size());
                } else {
                    if (!this.isPause) {
                        GLog.m7971i("showBubbleWithRules", "state:" + safeToolkitData.state + " 直接显示");
                        ((ISafeToolkitView) this.mView).setSafeToolkitStatusAndShow(safeToolkitData);
                        if (safeToolkitData.state == 12) {
                            this.f15390p.sendEmptyMessageDelayed(12, (long) (safeToolkitData.show * 1000));
                        }
                    } else {
                        GLog.m7971i("showBubbleWithRules", "state:" + safeToolkitData.state + " 仅记录状态");
                    }
                    this.mCurrentSFData = safeToolkitData;
                    this.f15389i = true;
                    if (safeToolkitData.show > 0) {
                        this.f15390p.sendEmptyMessageDelayed(8001, (long) (safeToolkitData.show * 1000));
                    }
                }
                SafeToolkitBean safeToolkitBean = this.mSafeToolkitBean;
                if (safeToolkitBean != null && safeToolkitBean.sfViewMenuModelList != null) {
                    List<SafeToolkitBean.SafeToolkitData> list = this.mSafeToolkitBean.dataList;
                    list.remove(safeToolkitData);
                    if (list.size() > 0 && safeToolkitData.show >= 0) {
                        m11055a(list.get(0));
                        return;
                    }
                    return;
                }
                return;
            }
            GLog.m7971i("showBubbleWithRules", "state:" + safeToolkitData.state + " 判断不可显示");
            return;
        }
        GLog.m7971i("showBubbleWithRules", "收到通知消失:" + safeToolkitData.state + " 消失");
        this.f15388h.clear();
        this.f15390p.removeMessages(8001);
        if (((ISafeToolkitView) this.mView).isBubbleShown()) {
            ((ISafeToolkitView) this.mView).dismissBubble((Runnable) null);
        } else if (((ISafeToolkitView) this.mView).isWelcomeShown()) {
            ((ISafeToolkitView) this.mView).dismissWelcome((Runnable) null);
        }
        this.f15389i = false;
        this.mCurrentSFData = null;
    }

    /* renamed from: b */
    private boolean m11064b(SafeToolkitBean.SafeToolkitData safeToolkitData) {
        SafeToolkitBean.SafeToolkitData safeToolkitData2 = this.mCurrentSFData;
        if (safeToolkitData2 != null && safeToolkitData2.show == -1) {
            GLog.m7971i("isShouldPutItInToQueue", "state:" + safeToolkitData.state + " current_state:" + safeToolkitData2.state);
            return false;
        } else if (safeToolkitData.state == 1 || safeToolkitData.state == 10) {
            return false;
        } else {
            GLog.m7971i("isShouldPutItInToQueue", "state:" + safeToolkitData.state + " isShown:" + this.f15389i + " size:" + this.f15388h.size());
            if (this.f15389i || !this.f15388h.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: c */
    private boolean m11068c(SafeToolkitBean.SafeToolkitData safeToolkitData) {
        if (safeToolkitData.state == 1) {
            return true;
        }
        if (!((ISafeToolkitView) this.mView).isVisibility()) {
            GLog.m7971i("showBubbleWithRules", "isShouldShow state:" + safeToolkitData.state + " 入口不可见,所以不显示");
            return false;
        } else if (safeToolkitData.show == 0) {
            GLog.m7971i("showBubbleWithRules", "isShouldShow state:" + safeToolkitData.state + " 消失");
            return false;
        } else {
            SafeToolkitBean.SafeToolkitData safeToolkitData2 = this.mCurrentSFData;
            if (TripRecordingManager.Companion.getInstance().isRecording() && safeToolkitData.state != 10) {
                return false;
            }
            if (safeToolkitData2 == null || safeToolkitData2 == null || safeToolkitData2.state != 1) {
                if (safeToolkitData.state == 7) {
                    int i = f15383n;
                    if (i >= 3) {
                        GLog.m7971i("showBubbleWithRules", "isShouldShow state:" + safeToolkitData.state + " 新手引导超过显示次数,不显示了,当前次数为:" + i);
                        return false;
                    } else if (f15379j) {
                        f15379j = false;
                        StringBuilder sb = new StringBuilder();
                        sb.append("isShouldShow state:");
                        sb.append(safeToolkitData.state);
                        sb.append(" 新手引导次数加一,加一后次数为:");
                        int i2 = i + 1;
                        sb.append(i2);
                        GLog.m7971i("showBubbleWithRules", sb.toString());
                        GlobalSPUtil.setSFWelcomeBubbleShowTimes(this.mContext, i2);
                    }
                }
                if (safeToolkitData.state == 6) {
                    int i3 = f15382m;
                    if (i3 >= 3) {
                        GLog.m7971i("showBubbleWithRules", "isShouldShow state:" + safeToolkitData.state + " 添加联系人超过显示次数,不显示了,当前次数为:" + i3);
                        return false;
                    } else if (f15380k) {
                        f15380k = false;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("isShouldShow state:");
                        sb2.append(safeToolkitData.state);
                        sb2.append(" 添加联系人次数加一,加一后次数为:");
                        int i4 = i3 + 1;
                        sb2.append(i4);
                        GLog.m7971i("showBubbleWithRules", sb2.toString());
                        GlobalSPUtil.setSFLeadAddPeopleBubbleShowTimes(this.mContext, i4);
                    }
                }
                return true;
            }
            GLog.m7971i("showBubbleWithRules", "isShouldShow currentBean.state:" + safeToolkitData2.state + " 当前在报警中,不显示其他的");
            return false;
        }
    }

    public boolean isValidBean(SafeToolkitBean safeToolkitBean) {
        if (safeToolkitBean == null || safeToolkitBean.data == null || safeToolkitBean.errno != 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        PresenterHolder.getIns().onRemove();
        unRegister();
    }

    /* access modifiers changed from: protected */
    public void register() {
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f15395v);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_DISMISS_BUBBLE, this.f15396w);
        subscribe("event_record_status_changed", this.f15397x);
        subscribe(BaseEventKeys.Push.EVENT_ON_SERVICE_MONITOR_TRIGGER, this.mRealTimeMonitorListener);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_MONITOR_STATUS_CHANGED, this.mMonitorStatusChanged);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_OPEN_LAW_URL, this.f15398y);
        subscribe(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, this.alphaListener);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SfConstant.SfAction.ACTION_EMERGENCY_ASSIST_ON);
        intentFilter.addAction(SfConstant.SfAction.ACTION_EMERGENCY_ASSIST_OFF);
        intentFilter.addAction(SfConstant.SfAction.ACTION_SHARE_SUCCESS);
        intentFilter.addAction(SfConstant.SfAction.ACTION_SHARE_FAILED);
        intentFilter.addAction(SfConstant.SfAction.ACTION_START_SHARE);
        intentFilter.addAction(SfConstant.SfAction.ACTION_ADD_CONTACTS_FAIL);
        intentFilter.addAction(SfConstant.SfAction.ACTION_ADD_CONTACTS_SUCCESS);
        intentFilter.addAction(SfConstant.SfAction.ACTION_DELETE_CONTACTS_FAIL);
        intentFilter.addAction(SfConstant.SfAction.ACTION_DELETE_CONTACT_SUCCESS);
        intentFilter.addAction(BaseEventKeys.SafeToolkit.ACTION_UPDATE_SAFETY_SWITCH);
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.f15394u, intentFilter);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f15395v);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_DISMISS_BUBBLE, this.f15396w);
        unsubscribe("event_record_status_changed", this.f15397x);
        unsubscribe(BaseEventKeys.Push.EVENT_ON_SERVICE_MONITOR_TRIGGER, this.mRealTimeMonitorListener);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_MONITOR_STATUS_CHANGED, this.mMonitorStatusChanged);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_OPEN_LAW_URL, this.f15398y);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, this.alphaListener);
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.f15394u);
    }

    /* access modifiers changed from: protected */
    public void onXPanelDefaultHeightChanged(int i) {
        if (i >= 0) {
            this.f15386f = i;
            int i2 = this.f15385e;
            if (i2 > i) {
                onXPanelScrollChanged(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onXPanelScrollChanged(int i) {
        ((ISafeToolkitView) this.mView).getView().animate().cancel();
        this.f15385e = i;
        ((ISafeToolkitView) this.mView).setTranslationY(-getNewHeightWithUIOffset(i));
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        this.isPause = false;
        if (this.mCurrentSFData != null) {
            GLog.m7971i("showBubbleWithRules", "onPageResume state:" + this.mCurrentSFData.state + "显示");
            if (this.mCurrentSFData.state != 7 && ((ISafeToolkitView) this.mView).isWelcomeShown()) {
                ((ISafeToolkitView) this.mView).dismissWelcome(new Runnable() {
                    public void run() {
                        if (AbsSafeToolkitPresenter.this.mCurrentSFData != null) {
                            ((ISafeToolkitView) AbsSafeToolkitPresenter.this.mView).setSafeToolkitStatusAndShow(AbsSafeToolkitPresenter.this.mCurrentSFData);
                        }
                    }
                });
            } else if (this.mCurrentSFData.state != 7 || !((ISafeToolkitView) this.mView).isBubbleShown()) {
                ((ISafeToolkitView) this.mView).setSafeToolkitStatusAndShow(this.mCurrentSFData);
                if (this.mCurrentSFData.state == 12) {
                    this.f15390p.sendEmptyMessageDelayed(12, (long) (this.mCurrentSFData.show * 1000));
                }
            } else {
                ((ISafeToolkitView) this.mView).dismissBubble(new Runnable() {
                    public void run() {
                        if (AbsSafeToolkitPresenter.this.mCurrentSFData != null) {
                            ((ISafeToolkitView) AbsSafeToolkitPresenter.this.mView).setSafeToolkitStatusAndShow(AbsSafeToolkitPresenter.this.mCurrentSFData);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        this.isPause = true;
        this.f15390p.removeMessages(12);
    }

    /* access modifiers changed from: protected */
    public int getNewHeightWithUIOffset(int i) {
        if (this.mView == null) {
            return i;
        }
        float f = (float) i;
        float f2 = this.f15387g;
        return f > f2 ? (int) (f + f2) : i;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        m11073e();
        m11054a(2);
        GlobalOmegaUtils.trackEvent("gp_safetIcon_btn_ck");
        m11067c();
    }

    /* renamed from: c */
    private void m11067c() {
        if (this.mView != null && this.mCurrentSFData != null && ((ISafeToolkitView) this.mView).isBubbleShown() && this.mCurrentSFData.state == 12) {
            this.f15390p.removeMessages(12);
            this.f15390p.removeMessages(8001);
            ((ISafeToolkitView) this.mView).dismissBubble((Runnable) null);
            this.f15389i = false;
            this.f15388h.clear();
            ((ISafeToolkitView) this.mView).resetBreathAnim();
            m11070d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11070d() {
        if (this.mCurrentSFData != null) {
            SafeToolkitBffRequest.reportUserState(this.mContext, new RpcService.Callback<JsonObject>() {
                public void onFailure(IOException iOException) {
                }

                public void onSuccess(JsonObject jsonObject) {
                    AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
                }
            }, this.mCurrentSFData.bubbleId);
        }
    }

    public ComponentParams getComponentParams() {
        return this.mComponentParams;
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        PresenterHolder.getIns().onAdd(this);
        requestSafeToolkitStatus();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        PresenterHolder.getIns().onRemove();
    }

    public void onActionClick() {
        if (isValidData(this.mCurrentSFData)) {
            SafetoolkitOmegaUtils.sendBubbleClick(this.mCurrentSFData.state);
            int i = this.mCurrentSFData.state;
            if (i == 2) {
                SfOmegaUtil.addEventId("gp_SafetyToolkit_popShare_ck").addKeyValue("type", 2).report();
                SafeToolKit.getIns().retryShareBySMS();
            } else if (i == 13) {
                m11075f();
            } else if (i != 5) {
                if (i != 6) {
                    switch (i) {
                        case 8:
                            OmegaSDKAdapter.trackEvent("gp_addAreaCode_popup_ck");
                            break;
                        case 9:
                        case 10:
                            CarOrder order = CarOrderHelper.getOrder();
                            if (order != null) {
                                boolean z = false;
                                SafeToolkitBean safeToolkitBean = this.mSafeToolkitBean;
                                if (!(safeToolkitBean == null || safeToolkitBean.sfViewMenuModelList == null)) {
                                    Iterator<SfViewMenuModel> it = this.mSafeToolkitBean.sfViewMenuModelList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            SfViewMenuModel next = it.next();
                                            if (SfViewMenuModel.TYPE_AUDIO_RECORD.equals(next.type)) {
                                                SafeToolKit.getIns().startTripRecordingPage(this.mContext, order.oid, (SfViewRecordMenuModel) next);
                                                z = true;
                                            }
                                        }
                                    }
                                }
                                if (!z) {
                                    SafeToolKit.getIns().startTripRecordingPage(this.mContext, order.oid, !TextUtils.isEmpty(order.oid));
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                SafeToolKit.getIns().startContactsManagerPage(this.mContext);
            } else {
                SfOmegaUtil.addEventId("gp_SafetyToolkit_popShare_ck").addKeyValue("type", 1).report();
                SafeToolKit.getIns().shareToSOSContacts();
            }
        }
    }

    /* renamed from: a */
    private void m11056a(SafeToolkitBean safeToolkitBean) {
        MonitorInterceptPopup monitorInterceptPopup = this.f15392r;
        if (monitorInterceptPopup != null) {
            monitorInterceptPopup.updateContent(safeToolkitBean);
            return;
        }
        final MonitorInterceptPopup newInstance = MonitorInterceptPopup.newInstance();
        if (safeToolkitBean != null) {
            SfViewMonitorMenuModel sfViewMonitorMenuModel = safeToolkitBean.monitorMenuModel;
            newInstance.setContent(sfViewMonitorMenuModel.alertTile);
            newInstance.setOkText(sfViewMonitorMenuModel.btnOkText);
            newInstance.setDangerText(sfViewMonitorMenuModel.btnJumpText);
        }
        newInstance.setClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str;
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.risk_dialog_danger_btn) {
                    AbsSafeToolkitPresenter.this.m11073e();
                    AbsSafeToolkitPresenter.this.m11054a(2);
                    GlobalOmegaUtils.trackEvent("gp_safetyHighRisk_tosafety_ck");
                } else {
                    AbsSafeToolkitPresenter.this.m11054a(1);
                    GlobalOmegaUtils.trackEvent("gp_safetyHighRisk_ok_ck");
                }
                CarOrder order = CarOrderHelper.getOrder();
                if (order == null) {
                    str = null;
                } else {
                    str = order.oid;
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Evaluate.CLICK_TRACE_CHECK_DIALOG_HIDE_EVALUATE_NEW_CARD, str);
                newInstance.dismissAllowingStateLoss();
                MonitorInterceptPopup unused = AbsSafeToolkitPresenter.this.f15392r = null;
                SafeToolkitBffRequest.reportUserState(AbsSafeToolkitPresenter.this.mContext, new RpcService.Callback<JsonObject>() {
                    public void onFailure(IOException iOException) {
                    }

                    public void onSuccess(JsonObject jsonObject) {
                        AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
                    }
                }, AbsSafeToolkitPresenter.this.f15393s);
            }
        });
        newInstance.show(((FragmentActivity) this.mContext).getSupportFragmentManager(), SfViewMenuModel.TYPE_REALTIME_MONITOR);
        this.f15392r = newInstance;
        GlobalOmegaUtils.trackEvent("gp_safetyHighRisk_view_sw");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11073e() {
        CarOrder order = CarOrderHelper.getOrder();
        String oid = order != null ? order.getOid() : "";
        boolean z = !TextUtils.isEmpty(oid);
        SafeToolKit ins = SafeToolKit.getIns();
        FragmentActivity fragmentActivity = (FragmentActivity) this.mContext;
        SafeToolkitBean safeToolkitBean = this.mSafeToolkitBean;
        ins.startToolkitDialog(fragmentActivity, z, oid, safeToolkitBean != null ? safeToolkitBean.sfViewMenuModelList : null);
    }

    /* renamed from: d */
    private void m11071d(SafeToolkitBean.SafeToolkitData safeToolkitData) {
        if (this.f15388h != null && safeToolkitData != null) {
            int i = safeToolkitData.state;
            if (i == 3 || i == 4 || i == 5 || i == 10) {
                this.f15388h.add(0, safeToolkitData);
            } else {
                this.f15388h.add(safeToolkitData);
            }
        }
    }

    /* renamed from: f */
    private void m11075f() {
        GlobalOmegaUtils.trackEvent("gd_safetyBubble_turnon_ck");
        SafeToolkitBffRequest.reportMonitorState(this.mContext, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
                JsonElement jsonElement = jsonObject.get("errno");
                JsonElement jsonElement2 = jsonObject.get("errmsg");
                if (jsonElement != null && jsonElement.getAsInt() == 0) {
                    AbsSafeToolkitPresenter.this.requestSafeToolkitStatus();
                } else if (jsonElement != null && jsonElement.getAsInt() != 0) {
                    ToastHelper.showShortInfo(AbsSafeToolkitPresenter.this.mContext, jsonElement2 == null ? "" : jsonElement2.getAsString());
                }
            }
        }, 1, 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11054a(int i) {
        String str;
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            str = "";
        } else {
            str = order.oid;
        }
        SafeToolkitBffRequest.reportEvent(this.mContext, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
            }
        }, str, i);
    }
}
