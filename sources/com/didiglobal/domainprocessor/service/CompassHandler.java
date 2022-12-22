package com.didiglobal.domainprocessor.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifylogin.base.net.pojo.response.JudgeResponse;
import com.didi.unifylogin.domain.CompassService;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.view.CompassPopup;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.model.PiiDomainSuffixModel;
import com.didiglobal.domainservice.model.SuffixType;
import com.didiglobal.domainservice.utils.DomainConstants;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.domainservice.utils.ELog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CompassHandler {

    /* renamed from: d */
    private static CompassHandler f50028d;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f50029a = true;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f50030b;

    /* renamed from: c */
    private LogoutListener f50031c;

    /* renamed from: e */
    private DomainUpdatePopupData f50032e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CustomCompassPopup f50033f;

    public interface LogoutListener {
        void onLogout();
    }

    private CompassHandler(Context context) {
        this.f50030b = context;
    }

    public static CompassHandler getInstance(Context context) {
        if (f50028d == null) {
            synchronized (CompassHandler.class) {
                if (f50028d == null) {
                    f50028d = new CompassHandler(context);
                }
            }
        }
        return f50028d;
    }

    public void setActivityState(boolean z) {
        this.f50029a = z;
    }

    public void verifyCompass(String str) {
        Context context = this.f50030b;
        if (context instanceof FragmentActivity) {
            verifyCompass(str, (FragmentActivity) context);
        } else {
            verifyCompass(str, (FragmentActivity) null);
        }
    }

    public void verifyCompass(String str, final FragmentActivity fragmentActivity) {
        ELog.debug("============== Begin verify compass service with SCENE[" + str + Const.jaRight);
        HashMap hashMap = new HashMap();
        String phone = LoginStore.getInstance().getPhone();
        if (!TextUtil.isEmpty(phone)) {
            hashMap.put("cell_phone", phone);
        }
        hashMap.put("invoke_scene", str);
        new CompassService().setCompassCheckCond(new CompassService.CompassCheckCondition() {
            public boolean haveCpsCKCondition() {
                return DomainUtil.isSupportDomainSwitch(CompassHandler.this.f50030b);
            }
        }).replaceCpsResponseHandler(new CompassService.ICpsResponseHandler<JudgeResponse>() {
            public void onHandleResponse(Context context, JudgeResponse judgeResponse) {
                ELog.debug("    verifyCompass() onHandleResp");
                if (CompassHandler.this.f50029a && judgeResponse != null && judgeResponse.data != null && judgeResponse.errno == 0) {
                    ArrayList<JudgeResponse.JudgeDataItem> arrayList = judgeResponse.data.idc_info;
                    if (CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                        ELog.error("    verifyCompass() onHandleResp return empty idc data");
                        return;
                    }
                    DomainServiceManager instance = DomainServiceManager.getInstance();
                    CompassHandler.this.m36029a(judgeResponse.data.pii_info, (PiiDomainSuffixModel) instance.getDomainSuffixModel(CompassHandler.this.f50030b, SuffixType.PII));
                    if (!DomainUtil.isSupportDomainSwitchForIdc(CompassHandler.this.f50030b)) {
                        ELog.debug("    *** verifyCompass() isSupportDomainSwitchForIdc == false");
                        return;
                    }
                    String domainSuffix = instance.getDomainSuffix(CompassHandler.this.f50030b);
                    ELog.debug("    *** verifyCompass() cache Domain-Suffix = " + domainSuffix);
                    if (arrayList.size() > 1) {
                        CompassHandler compassHandler = CompassHandler.this;
                        compassHandler.m36028a(context, new DomainUpdatePopupData(judgeResponse.data, domainSuffix), fragmentActivity);
                    } else if (arrayList.size() > 0) {
                        String str = arrayList.get(0).idc_sign;
                        if (TextUtils.isEmpty(str)) {
                            ELog.error("wtf! return single invalid idc from compass!");
                            return;
                        }
                        String lowerCase = str.toLowerCase();
                        if (lowerCase.equalsIgnoreCase(domainSuffix)) {
                            ELog.debug("Same idc: " + lowerCase + " return compare to cached one");
                            return;
                        }
                        CompassHandler compassHandler2 = CompassHandler.this;
                        if (compassHandler2.m36034a(compassHandler2.f50030b, domainSuffix, lowerCase)) {
                            ELog.debug("domain suffix auto change from " + domainSuffix + " to " + lowerCase);
                            instance.notifyAllDomainChange(lowerCase);
                        }
                        CompassHandler.this.m36027a();
                    }
                }
            }

            public void onHandleFailure(IOException iOException) {
                DomainServiceManager.getInstance().removeDomainSuffixModel(CompassHandler.this.f50030b, SuffixType.PII);
                ELog.debug("request compass failed catch exception: " + iOException);
            }
        }).getCompassJudge(this.f50030b, hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36029a(JudgeResponse.PiiDataItem piiDataItem, PiiDomainSuffixModel piiDomainSuffixModel) {
        DomainServiceManager instance = DomainServiceManager.getInstance();
        if (piiDataItem == null && piiDomainSuffixModel != null) {
            instance.removeDomainSuffixModel(this.f50030b, SuffixType.PII);
        }
        if (piiDataItem != null && !piiDataItem.illegal() && !m36040b(piiDataItem, piiDomainSuffixModel)) {
            PiiDomainSuffixModel piiDomainSuffixModel2 = new PiiDomainSuffixModel();
            piiDomainSuffixModel2.setSuffix(piiDataItem.idc_suffix);
            piiDomainSuffixModel2.setUris(piiDataItem.uri);
            piiDomainSuffixModel2.setTimeout(piiDataItem.timeout);
            instance.cacheDomainSuffixModel(this.f50030b, piiDomainSuffixModel2);
        }
        if (piiDataItem != null && piiDataItem.illegal()) {
            HashMap hashMap = new HashMap();
            hashMap.put("idc_suffix", piiDataItem.idc_suffix);
            hashMap.put("timeout", Integer.valueOf(piiDataItem.timeout));
            hashMap.put(ShareConstants.MEDIA_URI, piiDataItem.uri);
            OmegaSDKAdapter.trackEvent("tech_compass_pii_info_error", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36028a(final Context context, final DomainUpdatePopupData domainUpdatePopupData, FragmentActivity fragmentActivity) {
        if (domainUpdatePopupData == null || CollectionUtil.isEmpty((Collection<?>) domainUpdatePopupData.idc_info) || domainUpdatePopupData.idc_info.size() < 2) {
            ELog.error("wtf, compass return idc count less than 2");
        } else if (fragmentActivity == null) {
            ELog.error("buildPopupAndShow() activity parameter == null");
        } else {
            CustomCompassPopup customCompassPopup = this.f50033f;
            if (customCompassPopup == null || customCompassPopup.getDialog() == null || !this.f50033f.getDialog().isShowing()) {
                this.f50032e = domainUpdatePopupData;
                CustomCompassPopup instance = CustomCompassPopup.getInstance(domainUpdatePopupData);
                this.f50033f = instance;
                instance.setConfirmListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DomainUpdatePopupData domainUpdatePopupData = domainUpdatePopupData;
                        boolean z = false;
                        if (domainUpdatePopupData != null && !CollectionUtil.isEmpty((Collection<?>) domainUpdatePopupData.idc_info)) {
                            z = CompassHandler.this.m36035a(context, (ArrayList<JudgeResponse.JudgeDataItem>) domainUpdatePopupData.idc_info, 0, domainUpdatePopupData.domainSuffixInCache);
                        }
                        CompassHandler.this.m36033a("tone_p_x_roaming_yes_ck", z);
                        CompassHandler.this.f50033f.dismiss();
                    }
                });
                this.f50033f.setCancelListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DomainUpdatePopupData domainUpdatePopupData = domainUpdatePopupData;
                        CompassHandler.this.m36033a("tone_p_x_roaming_no_ck", (domainUpdatePopupData == null || CollectionUtil.isEmpty((Collection<?>) domainUpdatePopupData.idc_info) || domainUpdatePopupData.idc_info.size() < 2) ? false : CompassHandler.this.m36035a(context, (ArrayList<JudgeResponse.JudgeDataItem>) domainUpdatePopupData.idc_info, 1, domainUpdatePopupData.domainSuffixInCache));
                        CompassHandler.this.f50033f.dismiss();
                    }
                });
                this.f50033f.show(fragmentActivity.getSupportFragmentManager(), "");
                return;
            }
            ELog.debug("currently compass popup displaying, check idc data...");
            DomainUpdatePopupData domainUpdatePopupData2 = this.f50032e;
            if (domainUpdatePopupData2 != null && domainUpdatePopupData2.equalsTo(domainUpdatePopupData)) {
                ELog.debug("  Same idc data to choose, return!");
                return;
            }
            ELog.debug("  idc data change, refresh & return");
            this.f50032e = domainUpdatePopupData;
            this.f50033f.refreshData(domainUpdatePopupData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m36035a(Context context, ArrayList<JudgeResponse.JudgeDataItem> arrayList, int i, String str) {
        if (CollectionUtil.isEmpty((Collection<?>) arrayList) || i > arrayList.size() - 1) {
            ELog.error("second check invalid idcSign data");
            return false;
        }
        String str2 = arrayList.get(i).idc_sign;
        if (TextUtil.isEmpty(str2)) {
            ELog.error("choose idcSign at " + i + " invalid!");
            return false;
        }
        String lowerCase = str2.toLowerCase();
        if (lowerCase.equalsIgnoreCase(str)) {
            ELog.debug(String.format("choose same idc: %s at %d compare to cached-one.", new Object[]{lowerCase, Integer.valueOf(i)}));
            return true;
        }
        if (m36034a(context, str, lowerCase)) {
            ELog.debug(String.format("choose idc[%d]: %s different from cached-in: %s", new Object[]{Integer.valueOf(i), lowerCase, str}));
            DomainServiceManager.getInstance().notifyAllDomainChange(lowerCase);
        }
        m36027a();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36033a(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", Integer.valueOf(LoginStore.getInstance().getAppId()));
        hashMap.put("make-choice", Boolean.valueOf(z));
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m36034a(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("presuffix", str);
        hashMap.put("currsuffix", str2);
        hashMap.put("scene", "first_loc_valid");
        ELog.log(String.format("omega track suffix change from %s to %s.", new Object[]{str, str2}));
        OmegaSDKAdapter.trackEvent("tech_global_domainsuffix_changed", (Map<String, Object>) hashMap);
        DomainServiceManager.getInstance().notifyDomainSwitchEvent(0, new Bundle());
        return DomainServiceManager.getInstance().cacheDomainSuffix(context, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36027a() {
        LogoutListener logoutListener = this.f50031c;
        if (logoutListener != null) {
            logoutListener.onLogout();
        }
    }

    /* renamed from: b */
    private static boolean m36040b(JudgeResponse.PiiDataItem piiDataItem, PiiDomainSuffixModel piiDomainSuffixModel) {
        if (piiDataItem == null || piiDomainSuffixModel == null || piiDataItem.illegal() || piiDomainSuffixModel.illegal() || piiDataItem.uri.size() != piiDomainSuffixModel.getUris().size()) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < piiDataItem.uri.size(); i++) {
            if (!TextUtils.equals(piiDataItem.uri.get(i), piiDomainSuffixModel.getUris().get(i))) {
                z = false;
            }
        }
        if (!m36042c(piiDataItem, piiDomainSuffixModel) || piiDataItem.timeout != piiDomainSuffixModel.getTimeout() || !z) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m36042c(JudgeResponse.PiiDataItem piiDataItem, PiiDomainSuffixModel piiDomainSuffixModel) {
        if (piiDataItem == null && piiDomainSuffixModel == null) {
            return true;
        }
        if (piiDataItem == null || piiDomainSuffixModel == null || piiDataItem.illegal() || piiDomainSuffixModel.illegal() || !TextUtils.equals(piiDataItem.idc_suffix, piiDomainSuffixModel.getSuffixWithHead())) {
            return false;
        }
        return true;
    }

    private class DomainUpdatePopupData extends JudgeResponse.JudgeData implements CompassPopup.IPopupDataHandler {
        /* access modifiers changed from: private */
        public String domainSuffixInCache = "";

        public String getSubTitle() {
            return null;
        }

        public DomainUpdatePopupData(JudgeResponse.JudgeData judgeData, String str) {
            this.text = judgeData.text;
            this.idc_info = judgeData.idc_info;
            this.domainSuffixInCache = str;
        }

        public String getTitle() {
            if (CollectionUtil.isEmpty((Collection<?>) this.idc_info)) {
                return "";
            }
            return this.text;
        }

        public String getPositiveBtnText() {
            if (CollectionUtil.isEmpty((Collection<?>) this.idc_info)) {
                return "";
            }
            return ((JudgeResponse.JudgeDataItem) this.idc_info.get(0)).button_text;
        }

        public String getNegativeBtnText() {
            if (CollectionUtil.isEmpty((Collection<?>) this.idc_info)) {
                return "";
            }
            if (this.idc_info.size() > 1) {
                return ((JudgeResponse.JudgeDataItem) this.idc_info.get(1)).button_text;
            }
            return null;
        }

        public boolean equalsTo(DomainUpdatePopupData domainUpdatePopupData) {
            if (CollectionUtil.isEmpty((Collection<?>) this.idc_info) || CollectionUtil.isEmpty((Collection<?>) domainUpdatePopupData.idc_info) || this.idc_info.size() != domainUpdatePopupData.idc_info.size()) {
                return false;
            }
            for (int i = 0; i < this.idc_info.size(); i++) {
                String str = ((JudgeResponse.JudgeDataItem) this.idc_info.get(i)).idc_sign;
                if (TextUtil.isEmpty(str) || !str.equalsIgnoreCase(((JudgeResponse.JudgeDataItem) domainUpdatePopupData.idc_info.get(i)).idc_sign)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isCacheEmpty() {
            return TextUtils.isEmpty(this.domainSuffixInCache) || DomainConstants.DOMAIN_SUFFIX_G.equalsIgnoreCase(this.domainSuffixInCache);
        }
    }

    public void setLogoutListener(LogoutListener logoutListener) {
        this.f50031c = logoutListener;
    }
}
