package com.didi.dimina.container.secondparty.bundle.util;

import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.LogUtil;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PmBundleUtil {
    public static final String TAG = "Dimina-PM PmBundleUtil";

    public static boolean isAppIntegral(List<InstallModuleFileDescribe> list) {
        boolean z;
        DebugExceptionUtil.log("isAppIntegral()", "", (List<?>) list);
        Iterator<InstallModuleFileDescribe> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!isModuleExist(it.next())) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        LogUtil.iRelease(TAG, "isAppIntegral: " + z);
        return z;
    }

    public static boolean isModuleExist(InstallModuleFileDescribe installModuleFileDescribe) {
        return isModuleExist(new File(installModuleFileDescribe.getFilesAbsolutePath()));
    }

    public static boolean isModuleExist(File file) {
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            LogUtil.iRelease(TAG, file.getAbsolutePath() + " 的child 是 ->" + Arrays.toString(list));
            if (list != null && list.length > 0) {
                return new File(file, PmFileConstant.MODULE_UNZIP_SUCCESS_FLAG).exists();
            }
        }
        return false;
    }

    public static int compareVersion(String str, String str2) {
        return m12660a(str, str2, "\\.", "_");
    }

    /* renamed from: a */
    private static int m12660a(String str, String str2, String str3, String str4) {
        boolean z = str == null || str.length() == 0;
        boolean z2 = str2 == null || str2.length() == 0;
        if (z && z2) {
            return 0;
        }
        if (z) {
            return -1;
        }
        if (z2) {
            return 1;
        }
        if (str.equals(str2)) {
            return 0;
        }
        try {
            String[] split = str.split(str3);
            String[] split2 = str2.split(str3);
            int min = Math.min(split.length, split2.length);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= min) {
                    break;
                }
                if (!split[i].contains(str4)) {
                    if (!split2[i].contains(str4)) {
                        i2 = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                        if (i2 != 0) {
                            break;
                        }
                        i++;
                    }
                }
                i2 = m12660a(split[i], split2[i], str4, str4);
                if (i2 != 0) {
                    break;
                }
                i++;
            }
            if (i2 == 0) {
                int i3 = i;
                while (i3 < split.length) {
                    if (!split[i3].contains(str4)) {
                        if (Integer.parseInt(split[i3]) <= 0) {
                            i3++;
                        }
                    }
                    return 1;
                }
                while (i < split2.length) {
                    if (split2[i].contains(str4) || Integer.parseInt(split2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            } else if (i2 > 0) {
                return 1;
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
