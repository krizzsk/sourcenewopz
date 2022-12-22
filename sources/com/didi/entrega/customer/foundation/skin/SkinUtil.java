package com.didi.entrega.customer.foundation.skin;

import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ISkinService;
import com.taxis99.R;
import org.json.JSONException;
import rui.config.RConfigEngine;
import rui.config.model.color.ColorFill;

public final class SkinUtil {

    /* renamed from: a */
    private static final String f20032a = "SkinUtil";

    private SkinUtil() {
    }

    public static void initSkinConfig() {
        try {
            RConfigEngine.setConfig(GlobalContext.getContext(), ((ISkinService) CustomerServiceManager.getService(ISkinService.class)).loadConfig());
        } catch (JSONException | RConfigEngine.ConfigEmptyException e) {
            e.printStackTrace();
            LogUtil.m14761d(f20032a, "initSkinConfig fails with exception");
        }
    }

    public static int getBrandPrimaryColor() {
        int a = m14798a("customer_brand_primary_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_brands_1_100) : a;
    }

    public static int getDotLoadingHighlightColor() {
        int a = m14798a("customer_dot_loading_highlight_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_brands_1_100) : a;
    }

    public static int getDotLoadingNormalColor() {
        int a = m14798a("customer_dot_loading_normal_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_disable_1_100) : a;
    }

    public static int getDialogMainActionTextColor() {
        int a = m14798a("customer_dialog_main_action_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_jianbian_2) : a;
    }

    /* renamed from: a */
    private static int m14798a(String str) {
        try {
            return ((ColorFill) RConfigEngine.get(str)).getColorValue();
        } catch (RConfigEngine.ConfigParseException e) {
            LogUtil.m14761d(f20032a, "getColor fails with ConfigParseException");
            e.printStackTrace();
            return 0;
        } catch (Exception e2) {
            LogUtil.m14761d(f20032a, "getColor fails with exception");
            e2.printStackTrace();
            return 0;
        }
    }
}
