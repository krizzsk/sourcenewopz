package com.didiglobal.privacy.disclosure;

import android.content.Context;
import java.util.Map;

public interface IPrivacyDisclosureInitParam {
    int getAppId();

    PrivacyDisclosureBaseDialog getDialog();

    int getDialogLayoutResInt();

    PrivacyDisclosureBaseDialog getLocalDialog();

    int getMostDisclosureTimesApolloDefaultValue();

    int getNegativeBtnResInt();

    String getNegativeBtnText(Context context);

    int getNegativeBtnTextColor();

    int getPositionBtnTextColor();

    int getPositiveBtnResInt();

    String getPositiveBtnText(Context context);

    Map<String, Boolean> getPrivacyTypeIdApolloEnableDefautValue();

    Map<String, String> getPrivacyTypeIdDescMap();

    Map<String, Integer> getPrivacyTypeIdPermIconMap();

    Map<String, String> getPrivacyTypeIdPermNameMap();

    Map<String, String> getPrivacyTypeIdTitleMap();
}
