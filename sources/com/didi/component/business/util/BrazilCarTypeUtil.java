package com.didi.component.business.util;

import com.didi.component.business.data.form.FormStore;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.List;

public class BrazilCarTypeUtil {

    /* renamed from: a */
    private static OptionsApollo f11371a;

    public static void initOptionsApollo() {
        f11371a = m7694a();
    }

    static class OptionsApollo {
        int param;
        List<String> supportCarType = new ArrayList();

        OptionsApollo() {
        }
    }

    public static boolean isSupportAccessibleCar() {
        OptionsApollo optionsApollo;
        if (!FormStore.getInstance().isFromOpenRide() && (optionsApollo = f11371a) != null) {
            List<String> list = optionsApollo.supportCarType;
            if (list.contains(FormStore.getInstance().getCarLevel() + "")) {
                return true;
            }
        }
        return false;
    }

    public static int getAccessibleCarCode() {
        OptionsApollo optionsApollo = f11371a;
        if (optionsApollo != null) {
            return optionsApollo.param;
        }
        return 0;
    }

    /* renamed from: a */
    private static OptionsApollo m7694a() {
        String[] split;
        try {
            IToggle toggle = Apollo.getToggle("guarana_accessible_car");
            if (toggle != null && toggle.allow()) {
                OptionsApollo optionsApollo = new OptionsApollo();
                IExperiment experiment = toggle.getExperiment();
                String str = (String) experiment.getParam("car_type", "");
                optionsApollo.param = ((Integer) experiment.getParam("sid", 1004)).intValue();
                if (!TextUtil.isEmpty(str) && str.length() > 2) {
                    String substring = str.substring(1, str.length() - 1);
                    if (!TextUtil.isEmpty(substring) && (split = substring.split(",")) != null && split.length > 0) {
                        for (String add : split) {
                            optionsApollo.supportCarType.add(add);
                        }
                    }
                }
                return optionsApollo;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
