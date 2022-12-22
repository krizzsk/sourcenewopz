package com.didi.component.common.util;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.p071io.FileUtils;
import org.mozilla.javascript.typedarrays.Conversions;

public class PhoneYearClass {
    public static final int CLASS_2012 = 2012;
    public static final int CLASS_2013 = 2013;
    public static final int CLASS_2014 = 2014;
    public static final int CLASS_2015 = 2015;
    public static final int CLASS_2016 = 2016;
    public static final int CLASS_2017 = 2017;
    public static final int CLASS_2018 = 2018;
    public static final int CLASS_2019 = 2019;
    public static final int CLASS_UNKNOWN = -1;

    /* renamed from: a */
    private static final long f11798a = 1048576;

    /* renamed from: b */
    private static final int f11799b = 1000;

    /* renamed from: c */
    private static volatile Integer f11800c;

    public static int get(Context context) {
        if (f11800c == null) {
            synchronized (PhoneYearClass.class) {
                if (f11800c == null) {
                    f11800c = Integer.valueOf(m7993a(context));
                    SystemUtils.log(3, "PhoneYearClass", "get: ", (Throwable) null, "com.didi.component.common.util.PhoneYearClass", 46);
                }
            }
        }
        return f11800c.intValue();
    }

    /* renamed from: a */
    private static void m7994a(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    /* renamed from: a */
    private static int m7993a(Context context) {
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory == -1) {
            return m7996b(context);
        }
        if (totalMemory <= FileUtils.ONE_GB) {
            return 2012;
        }
        if (totalMemory <= 1610612736) {
            if (DeviceInfo.getCPUMaxFreqKHz() < 1800000) {
                return 2012;
            }
            return 2013;
        } else if (totalMemory <= 2147483648L) {
            return 2014;
        } else {
            if (totalMemory <= 3221225472L) {
                return 2015;
            }
            if (totalMemory <= Conversions.THIRTYTWO_BIT) {
                return 2016;
            }
            if (totalMemory <= 6442450944L) {
                return 2017;
            }
            return totalMemory <= 8589934592L ? 2018 : 2019;
        }
    }

    /* renamed from: b */
    private static int m7996b(Context context) {
        ArrayList arrayList = new ArrayList();
        m7994a(arrayList, m7992a());
        m7994a(arrayList, m7995b());
        m7994a(arrayList, m7997c(context));
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        if ((arrayList.size() & 1) == 1) {
            return ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
        }
        int size = (arrayList.size() / 2) - 1;
        return ((Integer) arrayList.get(size)).intValue() + ((((Integer) arrayList.get(size + 1)).intValue() - ((Integer) arrayList.get(size)).intValue()) / 2);
    }

    /* renamed from: a */
    private static int m7992a() {
        int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
        if (numberOfCPUCores <= 3) {
            return 2012;
        }
        if (numberOfCPUCores <= 4) {
            return 2015;
        }
        if (numberOfCPUCores <= 6) {
            return 2017;
        }
        return numberOfCPUCores <= 8 ? 2018 : 2019;
    }

    /* renamed from: b */
    private static int m7995b() {
        long cPUMaxFreqKHz = (long) DeviceInfo.getCPUMaxFreqKHz();
        if (cPUMaxFreqKHz == -1) {
            return -1;
        }
        if (cPUMaxFreqKHz <= 1520000) {
            return 2012;
        }
        if (cPUMaxFreqKHz <= 2020000) {
            return 2013;
        }
        if (cPUMaxFreqKHz <= 2300000) {
            return 2014;
        }
        if (cPUMaxFreqKHz <= 2400000) {
            return 2015;
        }
        if (cPUMaxFreqKHz <= 2600000) {
            return 2016;
        }
        if (cPUMaxFreqKHz <= 2800000) {
            return 2017;
        }
        return cPUMaxFreqKHz <= 3000000 ? 2018 : 2019;
    }

    /* renamed from: c */
    private static int m7997c(Context context) {
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory <= 0) {
            return -1;
        }
        if (totalMemory <= 1610612736) {
            return 2012;
        }
        return totalMemory <= 2147483648L ? 2013 : 2014;
    }
}
