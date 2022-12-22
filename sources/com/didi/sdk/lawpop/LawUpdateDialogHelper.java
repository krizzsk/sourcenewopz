package com.didi.sdk.lawpop;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.privacysdk.law.update.LawPopDialogManager;
import java.util.HashMap;
import java.util.Map;

public class LawUpdateDialogHelper {
    public static void postTaskDelayed(FragmentActivity fragmentActivity) {
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        String locCountry = nationComponentData.getLocCountry();
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow() && !TextUtils.isEmpty(locCountry) && fragmentActivity != null && !fragmentActivity.isFinishing()) {
            LawPopDialogManager.postTaskDelayed(fragmentActivity, new LawPopDialogManager.OnDialogClickListener() {
                public void onAgreeBtnCLicked() {
                    NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
                    HashMap hashMap = new HashMap();
                    hashMap.put("g_country", nationComponentData.getLocCountry());
                    hashMap.put("g_cityid", nationComponentData.getCityId());
                    hashMap.put("g_lang", nationComponentData.getGLang());
                    OmegaSDKAdapter.trackEvent("gp_lawcomm_acceptbtn_ck", (Map<String, Object>) hashMap);
                }

                public void onLinkClicked(String str) {
                    DRouter.build(str).start();
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("g_country", nationComponentData.getLocCountry());
            hashMap.put("g_cityid", nationComponentData.getCityId());
            hashMap.put("g_lang", nationComponentData.getGLang());
            OmegaSDKAdapter.trackEvent("gp_lawcomm_window_sw", (Map<String, Object>) hashMap);
        }
    }

    public static void resetShowDialogStatus() {
        LawPopDialogManager.resetShowDialogStatus();
    }
}
