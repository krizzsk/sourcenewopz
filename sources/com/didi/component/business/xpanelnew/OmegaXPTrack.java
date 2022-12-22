package com.didi.component.business.xpanelnew;

import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.enginecore.template.temp.IXEViewModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;

public class OmegaXPTrack {
    public static void omegaTrackWhenClickCard(IXEViewModel iXEViewModel) {
        m7734a("xpanel_card_ck", iXEViewModel, (String) null);
    }

    public static void omegaTrackWhenClickBtn(IXEViewModel iXEViewModel, String str) {
        m7734a("xpanel_button_ck", iXEViewModel, str);
    }

    /* renamed from: a */
    private static void m7734a(String str, IXEViewModel iXEViewModel, String str2) {
        if (iXEViewModel != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(BaseCard.KEY_CARD_ID, iXEViewModel.f50198id);
            if (str2 != null) {
                hashMap.put(Const.BUTTON_ID, str2);
            }
            try {
                if (!(iXEViewModel.extension == null || iXEViewModel.extension.log_data == null)) {
                    String jSONObject = iXEViewModel.extension.log_data.toString();
                    HashMap hashMap2 = new HashMap();
                    if (iXEViewModel.extension.extra != null) {
                        for (String str3 : iXEViewModel.extension.extra.keySet()) {
                            hashMap.put(str3, iXEViewModel.extension.extra.get(str3));
                        }
                    }
                    hashMap.putAll((Map) new Gson().fromJson((JsonElement) new JsonParser().parse(jSONObject).getAsJsonObject(), hashMap2.getClass()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
        }
    }
}
