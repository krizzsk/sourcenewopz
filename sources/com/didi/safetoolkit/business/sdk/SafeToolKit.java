package com.didi.safetoolkit.business.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.safetoolkit.activity.ActivityStack;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.flutter.nacho.Nacho;
import com.didi.global.safetoolkit.SafetoolkitPlugin;
import com.didi.safetoolkit.api.ISFTripRecordingService;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.business.areaCode.MandatoryGuideActivity;
import com.didi.safetoolkit.business.areaCode.ManuallyAddCodeActivity;
import com.didi.safetoolkit.business.areaCode.constant.AreaCodeConstant;
import com.didi.safetoolkit.business.contacts.SfContactsManageActivity;
import com.didi.safetoolkit.business.contacts.SfContactsManageOptActivity;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.emergency.SfEmergencyAssistanceActivity;
import com.didi.safetoolkit.business.emergency.store.SfEmergencyAssistanceStore;
import com.didi.safetoolkit.business.monitor.MonitorActivity;
import com.didi.safetoolkit.business.safeCenter.SfSafeCenterActivity;
import com.didi.safetoolkit.business.share.SfContactsActivity;
import com.didi.safetoolkit.business.share.model.SfContactsParam;
import com.didi.safetoolkit.business.share.store.SfContactsStore;
import com.didi.safetoolkit.business.toolkit.SfToolkitDialog;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewSafeCenterMenuModel;
import com.didi.safetoolkit.business.triprecording.TripRecordingActivity;
import com.didi.safetoolkit.business.triprecording.TripRecordingActivityKt;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.safetoolkit.model.SfBaseObject;
import com.didi.safetoolkit.net.ISfRpcRequestParamListener;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfOmegaOptListener;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.widget.SfBaseDialog;
import com.didi.sdk.app.tap.BusinessConstants;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SafeToolKit {

    /* renamed from: a */
    private SfToolkitDialog f34418a;

    /* renamed from: b */
    private Application f34419b;

    /* renamed from: c */
    private boolean f34420c;

    /* renamed from: d */
    private JSONObject f34421d;

    /* renamed from: e */
    private int f34422e;

    /* renamed from: f */
    private String f34423f;

    /* renamed from: g */
    private boolean f34424g;

    /* renamed from: h */
    private ISfRpcRequestParamListener f34425h;

    /* renamed from: i */
    private SfOmegaOptListener f34426i;

    /* renamed from: j */
    private boolean f34427j;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final SafeToolKit m_This = new SafeToolKit();

        private Holder() {
        }
    }

    private SafeToolKit() {
        this.f34427j = false;
    }

    public static SafeToolKit getIns() {
        return Holder.m_This;
    }

    public void initialization(Application application) {
        this.f34419b = application;
        ActivityStack.init(application);
        SfContextHelper.setContext(this.f34419b);
        this.f34420c = true;
    }

    public void startToolkitDialog(FragmentActivity fragmentActivity, String str, ArrayList<SfViewMenuModel> arrayList) {
        startToolkitDialog(fragmentActivity, true, str, arrayList);
    }

    public void startToolkitDialog(FragmentActivity fragmentActivity, boolean z, String str, ArrayList<SfViewMenuModel> arrayList) {
        if (this.f34420c) {
            if (this.f34418a == null) {
                this.f34418a = new SfToolkitDialog();
            }
            if (!this.f34418a.isShowing()) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (arrayList.size() == 0) {
                    arrayList.add(SfViewSafeCenterMenuModel.buildFallbackModel());
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("isShareCanUse", z);
                bundle.putString("orderId", str);
                bundle.putSerializable("menuList", arrayList);
                this.f34418a.setArguments(bundle);
                this.f34418a.show(fragmentActivity.getSupportFragmentManager(), "SfToolkitDialog");
            }
        }
    }

    public void dismissToolkitDialog() {
        SfToolkitDialog sfToolkitDialog;
        if (this.f34420c && (sfToolkitDialog = this.f34418a) != null) {
            sfToolkitDialog.dismissAllowingStateLoss();
        }
    }

    @Deprecated
    public void startSafeCenterPage(Context context) {
        if (this.f34420c) {
            context.startActivity(new Intent(context, SfSafeCenterActivity.class));
        }
    }

    public void startSharePage(Activity activity, int i) {
        if (this.f34420c) {
            String str = null;
            ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, getIns().getBusinessType()).get();
            if (iSfInfoService != null) {
                str = iSfInfoService.getCarOrderId();
            }
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(1).setOrderId(str));
        }
    }

    public void startAreaCodeAddPage(Activity activity, int i, SfContactsManageModel sfContactsManageModel) {
        startAreaCodeAddPage(activity, i, 0, sfContactsManageModel);
    }

    public void startAreaCodeAddPage(Context context, int i, int i2, SfContactsManageModel sfContactsManageModel) {
        if (this.f34420c) {
            Intent intent = new Intent(context, MandatoryGuideActivity.class);
            intent.putExtra(MandatoryGuideActivity.SF_CONSTANT_MANAGER_KEY, sfContactsManageModel);
            intent.putExtra(AreaCodeConstant.PARAM_KEY_OPEN_WAY_SOURCE, i2);
            if (i == 150 || i2 == 1) {
                intent.putExtra(AreaCodeConstant.PARAM_KEY_OPEN_FROM_SHARE_DIALOG, true);
            }
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i);
                return;
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void startManuallyAddPage(Activity activity, int i, SfContactsManageModel sfContactsManageModel) {
        startManuallyAddPage(activity, i, 0, sfContactsManageModel);
    }

    public void startManuallyAddPage(Activity activity, int i, int i2, SfContactsManageModel sfContactsManageModel) {
        if (this.f34420c) {
            Intent intent = new Intent(activity, ManuallyAddCodeActivity.class);
            intent.putExtra("manually_add_code_key", sfContactsManageModel);
            intent.putExtra(AreaCodeConstant.PARAM_KEY_OPEN_WAY_SOURCE, i2);
            if (i == 150) {
                intent.putExtra(AreaCodeConstant.PARAM_KEY_OPEN_FROM_SHARE_DIALOG, true);
            }
            activity.startActivityForResult(intent, i);
        }
    }

    public void startGetContactsPage(Activity activity, int i, int i2) {
        if (this.f34420c) {
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(2).setThreshold(i2));
        }
    }

    public void startGetContactsPageByNewShare(Activity activity, int i, int i2) {
        if (this.f34420c) {
            SfContactsActivity.startActivityForResult(activity, i, new SfContactsParam().setTarget(3).setThreshold(i2));
        }
    }

    public void startContactsManagerPage(Context context) {
        if (this.f34420c) {
            context.startActivity(new Intent(context, SfContactsManageActivity.class));
        }
    }

    public void startContactsManagerOptPage(Activity activity, int i, int i2) {
        if (this.f34420c) {
            Intent intent = new Intent(activity, SfContactsManageOptActivity.class);
            intent.putExtra("target", 2);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startContactsManagerOptPageByNewShare(Activity activity, int i, int i2) {
        if (this.f34420c) {
            Intent intent = new Intent(activity, SfContactsManageOptActivity.class);
            intent.putExtra("target", 3);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startContactsManagerPageForResult(Activity activity, int i) {
        if (this.f34420c) {
            activity.startActivityForResult(new Intent(activity, SfContactsManageActivity.class), i);
        }
    }

    public void startContactsManagerPageForResultByNewShare(Activity activity, int i, int i2) {
        if (this.f34420c) {
            Intent intent = new Intent(activity, SfContactsManageActivity.class);
            intent.putExtra("target", 3);
            intent.putExtra("threshold", i2);
            activity.startActivityForResult(intent, i);
        }
    }

    public void startEmergencyAssistanceActivity(Context context) {
        if (this.f34420c) {
            context.startActivity(new Intent(context, SfEmergencyAssistanceActivity.class));
        }
    }

    public void startEmergencyAssistanceActivity(Context context, boolean z) {
        if (this.f34420c) {
            Intent intent = new Intent(context, SfEmergencyAssistanceActivity.class);
            intent.putExtra("isNotAccepted", z);
            context.startActivity(intent);
        }
    }

    public void startSafetyCenter(Context context) {
        if (this.f34420c) {
            context.startActivity(new Intent(context, SfSafeCenterActivity.class));
        }
    }

    public void retryShareBySMS() {
        SfContactsStore.getInstance().shareRetry();
    }

    public void shareToSOSContacts() {
        SfContactsStore.getInstance().shareToSOSContacts();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24338a(final Context context) {
        if (context instanceof FragmentActivity) {
            new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_cancel_fail)).setButtonLayoutGravity(1).setRightBtn(SfStringGetter.getString(R.string.sf_retry), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                        public void onError(SfBaseObject sfBaseObject) {
                            SafeToolKit.this.m24338a(context);
                        }

                        public void onFail(int i, String str) {
                            SafeToolKit.this.m24338a(context);
                        }
                    });
                }
            }).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(true).build().show(((FragmentActivity) context).getSupportFragmentManager(), "RetryCancelPoliceDialog");
            return;
        }
        SfLog.m24403e("context must be derived from the FragmentActivity");
    }

    public void showPoliceDialog(final Context context, final String str) {
        if (context instanceof FragmentActivity) {
            new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_title)).setTitleTypeface(1).setContent(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_message)).setLeftBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_confirm_stop_btn), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SafetoolkitPlugin safetoolkitPlugin = (SafetoolkitPlugin) Nacho.getInstance().getPlugin(SafetoolkitPlugin.class);
                    if (safetoolkitPlugin != null) {
                        safetoolkitPlugin.buttonStatusChanged(str, "loading");
                    }
                    SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                        public void onError(SfBaseObject sfBaseObject) {
                            SafeToolKit.this.m24338a(context);
                        }

                        public void onFail(int i, String str) {
                            SafeToolKit.this.m24338a(context);
                        }
                    });
                }
            }).setLeftBtnTextColorRes(R.color.sf_color_999999).setRightBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_no_stop_btn)).setRightBtnTypeface(1).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(false).build().show(((FragmentActivity) context).getSupportFragmentManager(), "StopEmerAssistConfirmDialog");
            return;
        }
        SfLog.m24403e("context must be derived from the FragmentActivity");
    }

    public void showRecoverPoliceDialog(final Context context, String str) {
        if (!inVamosBizLine()) {
            if (context instanceof FragmentActivity) {
                new SfBaseDialog.DialogBuilder(context).setTitle(SfStringGetter.getString(R.string.sf_continue)).setTitleTypeface(1).setContent(SfStringGetter.getString(R.string.sf_emergency_report)).setButtonLayoutGravity(1).setLeftBtn(SfStringGetter.getString(R.string.sf_cancel_report), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        SfEmergencyAssistanceStore.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
                            public void onError(SfBaseObject sfBaseObject) {
                                SafeToolKit.this.m24338a(context);
                            }

                            public void onFail(int i, String str) {
                                SafeToolKit.this.m24338a(context);
                            }
                        });
                    }
                }).setLeftBtnTextColorRes(R.color.sf_color_999999).setRightBtn(SfStringGetter.getString(R.string.sf_going), (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        SafeToolKit.this.startEmergencyAssistanceActivity(context);
                    }
                }).setRightBtnTypeface(1).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(false).build().show(((FragmentActivity) context).getSupportFragmentManager(), "RecoverPoliceDialog");
                return;
            }
            SfLog.m24403e("context must be derived from the FragmentActivity");
        }
    }

    public JSONObject getPolicePhoneFromPGetConfig() {
        return this.f34421d;
    }

    public void setPolicePhoneFromPGetConfig(JSONObject jSONObject) {
        this.f34421d = jSONObject;
    }

    public int getProductId() {
        return this.f34422e;
    }

    public void setProductId(int i) {
        this.f34422e = i;
    }

    public String getBusinessType() {
        return this.f34423f;
    }

    public void setBusinessType(String str) {
        this.f34423f = str;
        m24337a();
    }

    /* renamed from: a */
    private void m24337a() {
        ISFTripRecordingService bussinessCallback = TripRecordingManager.Companion.getInstance().getBussinessCallback();
        if (bussinessCallback != null) {
            String alias = bussinessCallback.getAlias();
            if (!TextUtils.isEmpty(alias)) {
                AudioRecordManager.get().setBusinessAlias(alias);
                TripRecordingManager.Companion.getInstance().updateListener();
            }
        }
    }

    public boolean isVamosDriver() {
        return this.f34424g;
    }

    public void setVamosDriver(boolean z) {
        this.f34424g = z;
    }

    public ISfRpcRequestParamListener getRequestParamListener() {
        return this.f34425h;
    }

    public void setRequestParamListener(ISfRpcRequestParamListener iSfRpcRequestParamListener) {
        this.f34425h = iSfRpcRequestParamListener;
    }

    public static boolean inVamosBizLine() {
        return TextUtils.equals(getIns().getBusinessType(), BusinessConstants.TYPE_VAMOS);
    }

    public void startTripRecordingPage(Context context, String str, boolean z) {
        Intent intent = new Intent(context, TripRecordingActivity.class);
        intent.putExtra(TripRecordingActivityKt.RECORDING_ACTIVITY_EXTRA_OID, str);
        SfViewRecordMenuModel sfViewRecordMenuModel = new SfViewRecordMenuModel();
        sfViewRecordMenuModel.canRecord = z;
        intent.putExtra(TripRecordingActivityKt.RECORDING_ACTIVITY_EXTRA_RECORD_MODEL, sfViewRecordMenuModel);
        context.startActivity(intent);
    }

    public void startTripRecordingPage(Context context, String str, SfViewRecordMenuModel sfViewRecordMenuModel) {
        Intent intent = new Intent(context, TripRecordingActivity.class);
        intent.putExtra(TripRecordingActivityKt.RECORDING_ACTIVITY_EXTRA_OID, str);
        intent.putExtra(TripRecordingActivityKt.RECORDING_ACTIVITY_EXTRA_RECORD_MODEL, sfViewRecordMenuModel);
        context.startActivity(intent);
    }

    public void startJarvisTripRecordingPage(Context context, String str, SfViewRecordMenuModel sfViewRecordMenuModel) {
        Intent intent = new Intent(context, TripRecordingActivity.class);
        intent.putExtra(TripRecordingActivityKt.RECORDING_ACTIVITY_EXTRA_OID, str);
        intent.putExtra(TripRecordingActivityKt.RECORDING_ACTIVITY_EXTRA_RECORD_MODEL, sfViewRecordMenuModel);
        context.startActivity(intent);
    }

    public void startMonitorDetails(Context context, SfViewMonitorMenuModel sfViewMonitorMenuModel) {
        Intent intent = new Intent(context, MonitorActivity.class);
        intent.putExtra(MonitorActivity.MONITOR_STATE, sfViewMonitorMenuModel);
        context.startActivity(intent);
    }

    public void updateSfDialogItem(List<SfViewMenuModel> list) {
        if (this.f34418a != null && list != null && !list.isEmpty()) {
            this.f34418a.updateSfViewMenuModelList(list);
        }
    }

    public void setOmegaOptListener(SfOmegaOptListener sfOmegaOptListener) {
        this.f34426i = sfOmegaOptListener;
    }

    public SfOmegaOptListener getSfSpListener() {
        return this.f34426i;
    }
}
