package com.sdk.poibase.util;

import android.text.TextUtils;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;
import java.util.Iterator;

public class BizUtil {
    public static String convert2CoordinateType(int i) {
        return i != 1 ? (i == 2 || i != 3) ? "gcj02" : "wgs84" : "bd09";
    }

    public static int getCommonType(AddressParam addressParam) {
        if (addressParam.addressType == 3) {
            return 1;
        }
        if (addressParam.addressType == 4) {
            return 2;
        }
        if (addressParam.addressType == 5) {
            return 3;
        }
        return -1;
    }

    public static void insertCountryInfoToPoi(int i, String str, ArrayList<RpcPoi>... arrayListArr) {
        if (arrayListArr != null) {
            for (ArrayList<RpcPoi> arrayList : arrayListArr) {
                if (arrayList != null) {
                    Iterator<RpcPoi> it = arrayList.iterator();
                    while (it.hasNext()) {
                        RpcPoi next = it.next();
                        if (next.base_info != null) {
                            next.base_info.countryId = i;
                            next.base_info.countryCode = str;
                        }
                    }
                }
            }
        }
    }

    public static void insertCountryInfoToRecSugPoi(int i, String str, ArrayList<RpcPoi>... arrayListArr) {
        if (arrayListArr != null) {
            for (ArrayList<RpcPoi> arrayList : arrayListArr) {
                if (arrayList != null) {
                    Iterator<RpcPoi> it = arrayList.iterator();
                    while (it.hasNext()) {
                        RpcPoi next = it.next();
                        if (next.base_info != null) {
                            next.base_info.countryId = i;
                            next.base_info.countryCode = str;
                        }
                    }
                }
            }
        }
    }

    public static int convert2Cotype(String str) {
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 3017163) {
            if (hashCode != 98175376) {
                if (hashCode == 113079775 && str.equals("wgs84")) {
                    c = 2;
                }
            } else if (str.equals("gcj02")) {
                c = 1;
            }
        } else if (str.equals("bd09")) {
            c = 0;
        }
        if (c == 0) {
            return 1;
        }
        if (c == 1 || c != 2) {
            return 2;
        }
        return 3;
    }
}
