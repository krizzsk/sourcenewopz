package com.didi.soda.customer.foundation.skin;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ColorUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ISkinService;
import com.taxis99.R;
import org.json.JSONException;
import rui.config.RConfigEngine;
import rui.config.model.color.ColorFill;

public final class SkinUtil {

    /* renamed from: a */
    private static final String f41069a = "SkinUtil";

    private SkinUtil() {
    }

    public static void initSkinConfig() {
        try {
            RConfigEngine.setConfig(GlobalContext.getContext(), ((ISkinService) CustomerServiceManager.getService(ISkinService.class)).loadConfig());
        } catch (JSONException | RConfigEngine.ConfigEmptyException e) {
            e.printStackTrace();
            LogUtil.m29100d(f41069a, "initSkinConfig fails with exception");
        }
    }

    public static String getPlatformDiscount() {
        try {
            return GlobalContext.getContext().getResources().getString(R.string.customer_order_platform_discount, new Object[]{"99"});
        } catch (Exception e) {
            LogUtil.m29100d(f41069a, "getPlatformDiscount fails with exception");
            e.printStackTrace();
            return "";
        }
    }

    public static int getBrandPrimaryColor() {
        int a = m29145a("customer_brand_primary_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_brands_1_100) : a;
    }

    public static int getUponBrandPrimaryTextColor() {
        int a = m29145a("customer_upon_brand_primary_text_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_button_text) : a;
    }

    public static ColorStateList getUponBrandPrimaryTextColorStateList() {
        int[][] iArr = {new int[]{16842919}, new int[]{-16842919}};
        int uponBrandPrimaryTextColor = getUponBrandPrimaryTextColor();
        return new ColorStateList(iArr, new int[]{ColorUtil.getColorWithAlpha(0.5f, uponBrandPrimaryTextColor), ColorUtil.getColorWithAlpha(1.0f, uponBrandPrimaryTextColor)});
    }

    public static int getMainButtonSideTextColor() {
        int a = m29145a("customer_main_button_side_text_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_button_text) : a;
    }

    public static int getMainButtonSideNumTextColor() {
        int a = m29145a("customer_main_button_side_num_text_color");
        return a == 0 ? ResourceHelper.getColor(R.color.customer_skin_main_button_side_num_text_color) : a;
    }

    public static int getDotLoadingHighlightColor() {
        int a = m29145a("customer_dot_loading_highlight_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_brands_1_100) : a;
    }

    public static int getDotLoadingNormalColor() {
        int a = m29145a("customer_dot_loading_normal_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_disable_1_100) : a;
    }

    public static int getTagStrokeColor() {
        int a = m29145a("customer_tag_stroke_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_background_1_100) : a;
    }

    public static int getTagTextColor() {
        return getBrandPrimaryColor();
    }

    public static int getTagBackgroundColor() {
        int a = m29145a("customer_tag_background_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_background_1_100) : a;
    }

    public static int getDialogMainActionTextColor() {
        int a = m29145a("customer_dialog_main_action_color");
        return a == 0 ? ResourceHelper.getColor(R.color.rf_color_jianbian_2) : a;
    }

    /* renamed from: a */
    private static int m29145a(String str) {
        try {
            return ((ColorFill) RConfigEngine.get(str)).getColorValue();
        } catch (RConfigEngine.ConfigParseException e) {
            LogUtil.m29100d(f41069a, "getColor fails with ConfigParseException");
            e.printStackTrace();
            return 0;
        } catch (Exception e2) {
            LogUtil.m29100d(f41069a, "getColor fails with exception");
            e2.printStackTrace();
            return 0;
        }
    }

    public static GradientDrawable getGradientBg(int i, int i2, int i3, float f) {
        if (i2 < 0) {
            return getGradientBg(new int[]{i, i3}, f, GradientDrawable.Orientation.BOTTOM_TOP);
        }
        return getGradientBg(new int[]{i, i2, i3}, f, GradientDrawable.Orientation.BOTTOM_TOP);
    }

    public static GradientDrawable getGradientBg(int[] iArr, float f, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColors(iArr);
        if (orientation != null) {
            gradientDrawable.setOrientation(orientation);
        }
        return gradientDrawable;
    }

    public static GradientDrawable getGradientBg(int i, int i2, float f) {
        return getGradientBg(i, -1, i2, f);
    }
}
