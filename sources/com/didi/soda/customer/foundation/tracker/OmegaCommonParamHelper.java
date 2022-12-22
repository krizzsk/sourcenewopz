package com.didi.soda.customer.foundation.tracker;

import com.didi.soda.customer.foundation.tracker.param.GlobalParam;
import com.didi.soda.customer.foundation.tracker.param.GuideParam;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.UrlBuilder;
import java.util.Map;

public final class OmegaCommonParamHelper {

    /* renamed from: a */
    private static GlobalParam f41089a = new GlobalParam();

    /* renamed from: b */
    private static GuideParam f41090b;

    /* renamed from: c */
    private static GuideParam f41091c;

    static {
        GuideParam guideParam = new GuideParam();
        f41090b = guideParam;
        f41091c = guideParam.clone();
    }

    private OmegaCommonParamHelper() {
    }

    public static void setExternalGlobalParam(GlobalParam.ExternalGlobalParam externalGlobalParam) {
        f41089a.setExternalGlobalParam(externalGlobalParam);
    }

    public static GuideParam generateCurrentPageGuideParam() {
        GuideParam clone = f41090b.clone();
        f41091c = clone;
        return clone;
    }

    public static void updatePageGuideParam(GuideParam guideParam) {
        f41091c = guideParam;
        f41090b = guideParam.clone();
    }

    public static void refreshLv1GuideParam() {
        f41091c.refreshLv1GuideParam();
        f41090b.refreshLv1GuideParam();
    }

    public static void refreshLv3GuideParam() {
        f41091c.refreshLv3GuideParam();
        f41090b.refreshLv3GuideParam();
    }

    public static void refreshLv4GuideParam() {
        f41091c.refreshLv4GuideParam();
        f41090b.refreshLv4GuideParam();
    }

    public static void updateGuideParamByScheme(GuideParam guideParam) {
        f41090b = guideParam;
    }

    public static GuideParam.GuideParamsEntity getPageGuideParamsEntity() {
        return f41091c.generateEntity();
    }

    public static String getPageGuideParamsEntityJson() {
        return GsonUtil.toJson(f41091c.generateEntity());
    }

    public static Map<String, Object> getGuideParamMap() {
        return f41091c.getGuideParamMap();
    }

    public static String fillWebUrlWithGuideParam(String str) {
        return UrlBuilder.create(str).appendParam("traceParams", GsonUtil.toJson(getPageGuideParamsEntity())).build();
    }

    public static void setLv1Location(String str) {
        f41091c.setLv1Location(str);
        f41090b.setLv1Location(str);
    }

    public static void setLv1RecId(String str) {
        f41091c.setLv1RecId(str);
        f41090b.setLv1RecId(str);
    }

    public static void setLv1Body(String str) {
        f41091c.setLv1Body(str);
        f41090b.setLv1Body(str);
    }

    public static void setLv1Parameter(String str) {
        f41091c.setLv1Parameter(str);
        f41090b.setLv1Parameter(str);
    }

    public static void setLv1Filter(String str) {
        f41091c.setLv1Filter(str);
        f41090b.setLv1Filter(str);
    }

    public static void setLv3Location(String str) {
        f41091c.setLv3Location(str);
        f41090b.setLv3Location(str);
    }

    public static void setLv3RecId(String str) {
        f41091c.setLv3RecId(str);
        f41090b.setLv3RecId(str);
    }

    public static void setLv3Body(String str) {
        f41091c.setLv3Body(str);
        f41090b.setLv3Body(str);
    }

    public static void setLv4Body(String str) {
        f41091c.setLv4Body(str);
        f41090b.setLv4Body(str);
    }

    public static String getActivityId() {
        return f41089a.getActivityId();
    }

    public static String getChannelId() {
        return f41089a.getChannelId();
    }

    public static String getFirstActivityId() {
        return f41089a.getFirstActivityId();
    }

    public static String getFirstChannelId() {
        return f41089a.getFirstChannelId();
    }

    /* renamed from: a */
    static Map<String, Object> m29158a(String str, String str2, GuideParam guideParam, boolean z) {
        Map<String, Object> params = f41089a.getParams(str2);
        if (z) {
            params.putAll(guideParam.getParams(m29157a(str)));
        }
        return params;
    }

    public static Map<String, Object> getCommonParam() {
        return f41089a.getParams((String) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m29157a(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -2068260152: goto L_0x0102;
                case -1704385925: goto L_0x00f7;
                case -1381016746: goto L_0x00eb;
                case -1225033043: goto L_0x00e0;
                case -1122385092: goto L_0x00d5;
                case -966188689: goto L_0x00ca;
                case -962544798: goto L_0x00be;
                case -962544290: goto L_0x00b2;
                case -897104151: goto L_0x00a6;
                case -621598183: goto L_0x009a;
                case -599052576: goto L_0x008d;
                case -529188601: goto L_0x0080;
                case -417840527: goto L_0x0074;
                case -238177092: goto L_0x0067;
                case 96960353: goto L_0x005b;
                case 605012129: goto L_0x004e;
                case 605012637: goto L_0x0041;
                case 848267034: goto L_0x0034;
                case 1112091360: goto L_0x0027;
                case 1340211216: goto L_0x001a;
                case 2069813575: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x010d
        L_0x000e:
            java.lang.String r0 = "sailing_c_x_orderdetail_common_sw"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 0
            goto L_0x010e
        L_0x001a:
            java.lang.String r0 = "sailing_c_x_top_shop_realexposure_sw"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 13
            goto L_0x010e
        L_0x0027:
            java.lang.String r0 = "sailing_c_x_shop_item2cart_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 18
            goto L_0x010e
        L_0x0034:
            java.lang.String r0 = "sailing_c_x_shop_item_add_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 17
            goto L_0x010e
        L_0x0041:
            java.lang.String r0 = "sailing_c_x_shop_item_sold_out_put_away_sw"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 11
            goto L_0x010e
        L_0x004e:
            java.lang.String r0 = "sailing_c_x_shop_item_sold_out_put_away_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 8
            goto L_0x010e
        L_0x005b:
            java.lang.String r0 = "sailing_c_x_homepage_topic_shop_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 2
            goto L_0x010e
        L_0x0067:
            java.lang.String r0 = "sailing_c_x_shop_item_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 15
            goto L_0x010e
        L_0x0074:
            java.lang.String r0 = "sailing_c_x_homepage_shop_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 1
            goto L_0x010e
        L_0x0080:
            java.lang.String r0 = "sailing_c_x_specselection_item2cart_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 20
            goto L_0x010e
        L_0x008d:
            java.lang.String r0 = "sailing_c_x_shop_common_sw"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 14
            goto L_0x010e
        L_0x009a:
            java.lang.String r0 = "sailing_c_x_specselection_common_sw"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 16
            goto L_0x010e
        L_0x00a6:
            java.lang.String r0 = "sailing_c_x_shop_item_photo_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 19
            goto L_0x010e
        L_0x00b2:
            java.lang.String r0 = "sailing_c_x_shop_item_sold_out_show_sw"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 10
            goto L_0x010e
        L_0x00be:
            java.lang.String r0 = "sailing_c_x_shop_item_sold_out_show_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 9
            goto L_0x010e
        L_0x00ca:
            java.lang.String r0 = "sailing_c_x_shop_search_hotword_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 6
            goto L_0x010e
        L_0x00d5:
            java.lang.String r0 = "sailing_c_x_shop_item_large_sw"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 5
            goto L_0x010e
        L_0x00e0:
            java.lang.String r0 = "sailing_c_x_realexposure_sw"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 7
            goto L_0x010e
        L_0x00eb:
            java.lang.String r0 = "sailing_c_x_top_shop_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 12
            goto L_0x010e
        L_0x00f7:
            java.lang.String r0 = "sailing_c_x_homepage_banner_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 3
            goto L_0x010e
        L_0x0102:
            java.lang.String r0 = "sailing_c_x_searchresult_shop_ck"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x010d
            r6 = 4
            goto L_0x010e
        L_0x010d:
            r6 = -1
        L_0x010e:
            switch(r6) {
                case 0: goto L_0x0115;
                case 1: goto L_0x0115;
                case 2: goto L_0x0115;
                case 3: goto L_0x0115;
                case 4: goto L_0x0115;
                case 5: goto L_0x0115;
                case 6: goto L_0x0115;
                case 7: goto L_0x0115;
                case 8: goto L_0x0115;
                case 9: goto L_0x0115;
                case 10: goto L_0x0115;
                case 11: goto L_0x0115;
                case 12: goto L_0x0115;
                case 13: goto L_0x0115;
                case 14: goto L_0x0114;
                case 15: goto L_0x0113;
                case 16: goto L_0x0113;
                case 17: goto L_0x0113;
                case 18: goto L_0x0113;
                case 19: goto L_0x0113;
                case 20: goto L_0x0112;
                default: goto L_0x0111;
            }
        L_0x0111:
            return r1
        L_0x0112:
            return r2
        L_0x0113:
            return r3
        L_0x0114:
            return r4
        L_0x0115:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.m29157a(java.lang.String):int");
    }
}
