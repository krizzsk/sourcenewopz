package com.didi.component.common.cache;

import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalApolloUtil;

public class CacheApolloUtils extends GlobalApolloUtil {

    /* renamed from: a */
    private static final String f11477a = "brazil_app_call_experience_imporve";

    /* renamed from: b */
    private static final String f11478b = "pre_rec";

    /* renamed from: c */
    private static final String f11479c = "pre_eta";

    /* renamed from: d */
    private static final String f11480d = "pre_poi";

    /* renamed from: e */
    private static final String f11481e = "post_send";

    /* renamed from: f */
    private static int f11482f = -1;

    /* renamed from: g */
    private static int f11483g = -1;

    public static boolean openConfirmEtaCache() {
        String str = f11477a + f11479c;
        int intValue = ((Integer) CacheStore.getInstance().getCache(str, -1)).intValue();
        if (intValue == -1) {
            intValue = ((Integer) getParam(f11477a, f11479c, 0)).intValue();
            CacheStore.getInstance().addCache(str, Integer.valueOf(intValue));
        }
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean openRecCache() {
        String str = f11477a + f11478b;
        int intValue = ((Integer) CacheStore.getInstance().getCache(str, -1)).intValue();
        if (intValue == -1) {
            intValue = ((Integer) getParam(f11477a, f11478b, 0)).intValue();
            CacheStore.getInstance().addCache(str, Integer.valueOf(intValue));
        }
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean openPOICache() {
        String str = f11477a + f11480d;
        int intValue = ((Integer) CacheStore.getInstance().getCache(str, -1)).intValue();
        if (intValue == -1) {
            intValue = ((Integer) getParam(f11477a, f11480d, 0)).intValue();
            CacheStore.getInstance().addCache(str, Integer.valueOf(intValue));
        }
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean openPostSend() {
        String str = f11477a + f11481e;
        int intValue = ((Integer) CacheStore.getInstance().getCache(str, -1)).intValue();
        if (intValue == -1) {
            intValue = ((Integer) getParam(f11477a, f11481e, 0)).intValue();
            CacheStore.getInstance().addCache(str, Integer.valueOf(intValue));
        }
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean openWaitRspOptimization() {
        return !FormStore.getInstance().isFromOpenRide();
    }

    public static int isNewCPFBlockingOpen() {
        return f11482f;
    }

    public static void setNewCPUBlockingOpen(int i) {
        f11482f = i;
    }

    public static int getCPFBlockingTypeV2() {
        return f11483g;
    }

    public static boolean isCPFBlockingTypeV2OpenOnHome() {
        return getCPFBlockingTypeV2() >= 2;
    }

    public static boolean isCPFBlockingTypeV2OpenOnRegist() {
        return getCPFBlockingTypeV2() == 1 || getCPFBlockingTypeV2() == 3;
    }

    public static void setCPFBlockingTypeV2(int i) {
        f11483g = i;
    }
}
