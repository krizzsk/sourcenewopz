package com.didi.addressnew.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.PermissionChecker;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.address.util.PoiidCompleteUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.sdk.poibase.model.AddressParam;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class CommonUtils {
    public static int poiid_count;

    public static boolean isValidLocation(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return isValidLocation(addressParam.currentAddress);
    }

    public static boolean isValidLocation(Address address) {
        return address != null && LatLngUtils.locateCorrect(address.latitude, address.longitude);
    }

    public static boolean isFromSetting(FromType fromType) {
        return fromType == FromType.SETTING;
    }

    public static boolean isFromHomePage(FromType fromType) {
        return fromType == FromType.HOME;
    }

    public static boolean isFromNewConfirmPage(FromType fromType) {
        return fromType != null && (fromType == FromType.CONFIRM_NEW || fromType == FromType.OPEN_RIDE_CONFIRM);
    }

    public static boolean isFromConfirmPage(FromType fromType) {
        return fromType == FromType.CONFIRM;
    }

    public static boolean isFromGetOnPage(FromType fromType) {
        return fromType != null && isGetOnFromType(fromType);
    }

    public static boolean isFromRouteEditor(FromType fromType) {
        return fromType == FromType.ROUTE_EDITOR || fromType == FromType.FROM_HOME_ROUTE_EDITOR || fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR;
    }

    public static int getPageLevel(FromType fromType, int i) {
        if (!isFromGetOnPage(fromType) && !isFromNewConfirmPage(fromType) && !isFromHomePage(fromType)) {
            return AddressTrack.page_level_two;
        }
        if (i == 3 || i == 4 || i == 5 || i == 101 || i == 102) {
            return AddressTrack.page_level_two;
        }
        return AddressTrack.page_level_one;
    }

    public static boolean checkPermissionIsGranted(Context context, String str) {
        int a;
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 23 || (a = m4731a(context)) <= 0) {
            return true;
        }
        if (a >= 23) {
            if (context.checkSelfPermission(str) == 0) {
                return true;
            }
        } else if (PermissionChecker.checkSelfPermission(context, str) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static int m4731a(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static boolean isGetOnFromType(FromType fromType) {
        return fromType == FromType.GET_ON || fromType == FromType.DRIVING || fromType == FromType.WAITRSP;
    }

    public static void checkOrCorrectPoiid(Address address) {
        if (isValidLocation(address)) {
            PoiidCompleteUtils.completePoiid(address);
        }
    }

    public static String getFromPageTrack(SugParams sugParams) {
        if (sugParams == null || sugParams.addressParam == null) {
            return "";
        }
        switch (C33311.$SwitchMap$com$didi$address$FromType[sugParams.fromType.ordinal()]) {
            case 1:
                return "homepage";
            case 2:
            case 3:
                return sugParams.addressParam.addressType == 1 ? "start_bubble" : "end_bubble";
            case 4:
                return "piconf_page";
            case 5:
                return Const.CALL_FROM_DEPARTURE_PAGE;
            case 6:
                return "ontrip_page";
            case 7:
                return "other_page";
            default:
                return "";
        }
    }

    /* renamed from: com.didi.addressnew.util.CommonUtils$1 */
    static /* synthetic */ class C33311 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$address$FromType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.address.FromType[] r0 = com.didi.address.FromType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$address$FromType = r0
                com.didi.address.FromType r1 = com.didi.address.FromType.HOME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM_NEW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.address.FromType r1 = com.didi.address.FromType.GET_ON     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.address.FromType r1 = com.didi.address.FromType.WAITRSP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.address.FromType r1 = com.didi.address.FromType.DRIVING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.address.FromType r1 = com.didi.address.FromType.SETTING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.util.CommonUtils.C33311.<clinit>():void");
        }
    }

    public static boolean checkDuplicateWithoutValideAddressCheck(ArrayList<WayPoint> arrayList) {
        if (arrayList == null) {
            return true;
        }
        int i = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            if (i2 < arrayList.size()) {
                WayPoint wayPoint = arrayList.get(i);
                WayPoint wayPoint2 = arrayList.get(i2);
                if (wayPoint != null && wayPoint2 != null && isValidLocation(wayPoint.getAddress()) && isValidLocation(wayPoint.getAddress()) && isTwoAddressEqual(wayPoint.getAddress(), wayPoint2.getAddress())) {
                    return true;
                }
            }
            i = i2;
        }
        return false;
    }

    public static boolean checkDuplicate(ArrayList<WayPoint> arrayList) {
        if (arrayList == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<WayPoint> it = arrayList.iterator();
        while (it.hasNext()) {
            WayPoint next = it.next();
            if (next != null && isValidLocation(next.getAddress())) {
                arrayList2.add(next);
            }
        }
        return checkDuplicateWithoutValideAddressCheck(arrayList2);
    }

    public static void showDuplicateAlert(Context context) {
        if (context != null) {
            try {
                ToastHelper.showFail(context, context.getString(R.string.GRider_1102_The_same_LaNx));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isTwoAddressEqual(Address address, Address address2) {
        usingUidOrPoiid(address);
        usingUidOrPoiid(address2);
        if (address == null || address2 == null || !isValidLocation(address) || !isValidLocation(address2)) {
            return false;
        }
        if ((address.poiId == null || address2.poiId == null || !address.poiId.equals(address2.poiId)) && DDSphericalUtil.computeDistanceBetween(new LatLng(address.latitude, address.longitude), new LatLng(address2.latitude, address2.longitude)) > 5.0d) {
            return false;
        }
        return true;
    }

    public static void usingUidOrPoiid(Address address) {
        if (address != null && TextUtils.isEmpty(address.poiId) && !TextUtils.isEmpty(address.uid)) {
            address.poiId = address.uid;
        }
    }
}
