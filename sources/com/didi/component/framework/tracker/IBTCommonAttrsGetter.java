package com.didi.component.framework.tracker;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.tracker.OmegaCommonParamsTrackUtil;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.util.GLog;
import com.didi.component.framework.template.confirm.ConfirmTemplateFragment;
import com.didi.component.framework.template.home.HomeTemplateFragment;
import com.didi.component.framework.template.trip.TripTemplateFragment;
import com.didi.reactive.tracker.AttrsGetter;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.monitor.PubSIDManager;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IBTCommonAttrsGetter implements AttrsGetter {

    /* renamed from: a */
    private final Application f14000a;

    public IBTCommonAttrsGetter(Application application) {
        this.f14000a = application;
    }

    public Map getAttrs() {
        HashMap hashMap = new HashMap();
        Fragment a = m9765a();
        CarOrder order = CarOrderHelper.getOrder();
        if (a instanceof BizEntranceFragment) {
            if (((BizEntranceFragment) a).getBusinessContext() != null) {
                String productId = BusinessDataUtil.getProductId();
                if (!TextUtils.isEmpty(productId)) {
                    hashMap.put("g_BizId", productId);
                    OmegaSDK.putGlobalAttr("g_BizId", productId);
                }
            }
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener != null) {
                if (confirmListener.getIsAnyCar()) {
                    ArrayList arrayList = new ArrayList();
                    int currentPage = confirmListener.getCurrentPage();
                    if (currentPage == 1) {
                        if (confirmListener.getSelectedAnyCarItems() != null && confirmListener.getSelectedAnyCarItems().size() > 0) {
                            for (AnyCarEstimateItemModel next : confirmListener.getSelectedAnyCarItems()) {
                                if (!(next == null || next.mAnyCarEstimateNetItem == null || next.mAnyCarEstimateNetItem.carConfig == null)) {
                                    arrayList.add(Integer.valueOf(next.mAnyCarEstimateNetItem.carConfig.carBussinessId));
                                }
                            }
                        }
                    } else if (currentPage == 3) {
                        if (confirmListener.getSelectedSingleAnyCarItem() != null) {
                            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
                            if (!(selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig == null)) {
                                arrayList.add(Integer.valueOf(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.carBussinessId));
                            }
                        } else if (confirmListener.getSelectedAnyCarItems() != null && confirmListener.getSelectedAnyCarItems().size() > 0) {
                            for (AnyCarEstimateItemModel next2 : confirmListener.getSelectedAnyCarItems()) {
                                if (!(next2 == null || next2.mAnyCarEstimateNetItem == null || next2.mAnyCarEstimateNetItem.carConfig == null)) {
                                    arrayList.add(Integer.valueOf(next2.mAnyCarEstimateNetItem.carConfig.carBussinessId));
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        String obj = arrayList.toString();
                        String replace = obj.replace(obj.charAt(obj.length() - 1) + "", "");
                        OmegaSDK.putGlobalAttr("pub_allbiz", replace.replace(replace.charAt(0) + "", ""));
                    } else {
                        OmegaSDK.removeGlobalAttr("pub_allbiz");
                    }
                    PubSIDManager.getInstance().setPubSID("is_anycar", 1);
                } else {
                    PubSIDManager.getInstance().removePubSID("is_anycar", 1);
                }
            }
            TripListener tripListener = PageCompDataTransfer.getInstance().getTripListener();
            if (tripListener != null) {
                if (!tripListener.getIsAnyCar()) {
                    OmegaSDK.removeGlobalAttr("pub_allbiz");
                } else if (tripListener.getSelectedSingleAnyCarItem() != null) {
                    OmegaSDK.removeGlobalAttr("pub_allbiz");
                }
            }
            if (confirmListener == null && tripListener == null) {
                OmegaSDK.removeGlobalAttr("pub_allbiz");
                PubSIDManager.getInstance().removePubSID("is_anycar", 1);
            }
        }
        String a2 = m9766a(a);
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put("g_PageId", a2);
            OmegaSDK.putGlobalAttr("g_PageId", a2);
            GLog.m7965d("g_PageIdLog", a2);
        }
        if (order != null) {
            hashMap.put("g_OrderId", order.getOid());
            if (order.comboType != 0) {
                hashMap.put("g_ComboType", Integer.valueOf(order.comboType));
                OmegaSDK.putGlobalAttr("g_ComboType", Integer.valueOf(order.comboType));
            } else {
                OmegaSDK.removeGlobalAttr("g_ComboType");
            }
        }
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f14000a).getLastKnownLocation();
        if (lastKnownLocation != null) {
            hashMap.put("g_lat", Double.valueOf(lastKnownLocation.getLatitude()));
            hashMap.put("g_lng", Double.valueOf(lastKnownLocation.getLongitude()));
            OmegaSDK.putGlobalAttr("g_lat", Double.valueOf(lastKnownLocation.getLatitude()));
            OmegaSDK.putGlobalAttr("g_lng", Double.valueOf(lastKnownLocation.getLongitude()));
        }
        return hashMap;
    }

    /* renamed from: a */
    private String m9766a(Fragment fragment) {
        CarOrder order = CarOrderHelper.getOrder();
        if ((order != null && order.orderSource == 1) || (fragment instanceof HistoryRecordFragment)) {
            return GPageIdConstant.G_PAGE_ID_MY_TRIP;
        }
        if (fragment instanceof TripTemplateFragment) {
            return m9768c(fragment);
        }
        if ((fragment instanceof ConfirmTemplateFragment) && !TextUtils.isEmpty(OmegaCommonParamsTrackUtil.getCurrentStateInConfirmPage())) {
            return OmegaCommonParamsTrackUtil.getCurrentStateInConfirmPage();
        }
        String str = OmegaSDK.getGlobalAttr("g_PageId") instanceof String ? (String) OmegaSDK.getGlobalAttr("g_PageId") : null;
        return TextUtils.isEmpty(str) ? m9769d(fragment) : str;
    }

    /* renamed from: b */
    private String m9767b(Fragment fragment) {
        if (fragment instanceof HistoryRecordFragment) {
            return GPageIdConstant.G_PAGE_ID_MY_TRIP;
        }
        String str = OmegaSDK.getGlobalAttr("g_PageId") instanceof String ? (String) OmegaSDK.getGlobalAttr("g_PageId") : null;
        return TextUtils.isEmpty(str) ? m9769d(fragment) : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (com.didi.component.business.util.BusinessDataUtil.isCancelOrder(r0) != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return "cancel";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return com.didi.component.business.tracker.GPageIdConstant.G_PAGE_ID_ENDS;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        if (com.didi.component.business.util.BusinessDataUtil.isCancelOrder(r0) != false) goto L_0x0021;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m9768c(androidx.fragment.app.Fragment r7) {
        /*
            r6 = this;
            com.didi.travel.psnger.model.response.CarOrder r0 = com.didi.component.business.util.CarOrderHelper.getOrder()
            com.didi.component.framework.template.trip.TripTemplateFragment r7 = (com.didi.component.framework.template.trip.TripTemplateFragment) r7
            int r7 = r7.currentScene()
            java.lang.String r1 = "pick"
            java.lang.String r2 = "cancel"
            java.lang.String r3 = "ends"
            r4 = 0
            switch(r7) {
                case 10401: goto L_0x0047;
                case 10402: goto L_0x0025;
                case 10403: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0045
        L_0x0015:
            boolean r7 = com.didi.component.business.util.BusinessDataUtil.isEndService()
            if (r7 == 0) goto L_0x0045
            boolean r7 = com.didi.component.business.util.BusinessDataUtil.isCancelOrder(r0)
            if (r7 == 0) goto L_0x0023
        L_0x0021:
            r1 = r2
            goto L_0x0049
        L_0x0023:
            r1 = r3
            goto L_0x0049
        L_0x0025:
            if (r0 == 0) goto L_0x0045
            int r7 = r0.status
            r5 = 4
            if (r7 != r5) goto L_0x0038
            int r7 = r0.substatus
            switch(r7) {
                case 4001: goto L_0x0049;
                case 4002: goto L_0x0049;
                case 4003: goto L_0x0035;
                case 4004: goto L_0x0035;
                case 4005: goto L_0x0032;
                case 4006: goto L_0x0032;
                case 4007: goto L_0x0045;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x0049
        L_0x0032:
            java.lang.String r1 = "proc"
            goto L_0x0049
        L_0x0035:
            java.lang.String r1 = "arrival"
            goto L_0x0049
        L_0x0038:
            boolean r7 = com.didi.component.business.util.BusinessDataUtil.isEndService()
            if (r7 == 0) goto L_0x0045
            boolean r7 = com.didi.component.business.util.BusinessDataUtil.isCancelOrder(r0)
            if (r7 == 0) goto L_0x0023
            goto L_0x0021
        L_0x0045:
            r1 = r4
            goto L_0x0049
        L_0x0047:
            java.lang.String r1 = "wait"
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.tracker.IBTCommonAttrsGetter.m9768c(androidx.fragment.app.Fragment):java.lang.String");
    }

    /* renamed from: d */
    private String m9769d(Fragment fragment) {
        if (fragment instanceof HomeTemplateFragment) {
            return "home";
        }
        return null;
    }

    /* renamed from: a */
    private Fragment m9765a() {
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        if (!(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        List<Fragment> fragments = ((FragmentActivity) currentActivity).getSupportFragmentManager().getFragments();
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment.isVisible() && fragment.getUserVisibleHint()) {
                return fragment;
            }
        }
        return null;
    }
}
