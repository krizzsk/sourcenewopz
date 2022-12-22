package com.jumio.core.util;

import android.content.Context;
import com.jumio.core.environment.CpuInfo;
import com.jumio.core.environment.Environment;

public class DeviceUtil {
    public static String getCpuCount() {
        return Integer.toString(CpuInfo.getCpuCount());
    }

    public static String getCpuFamily() {
        int cpuFamily = CpuInfo.getCpuFamily();
        switch (cpuFamily) {
            case 1:
                return "ARM";
            case 2:
                return "X86";
            case 3:
                return "MIPS";
            case 4:
                return "ARM64";
            case 5:
                return "X86_64";
            case 6:
                return "MIPS64";
            default:
                return "UNKNOWN (" + cpuFamily + ")";
        }
    }

    public static String getCpuFeatures() {
        int cpuFamily = CpuInfo.getCpuFamily();
        int cpuFeatures = CpuInfo.getCpuFeatures();
        String str = "";
        if (cpuFamily == 1) {
            if ((cpuFeatures & 1) == 1) {
                str = str + "ARMv7 ";
            }
            if ((cpuFeatures & 2) == 2) {
                str = str + "VFPv3 ";
            }
            if ((cpuFeatures & 4) == 4) {
                str = str + "NEON ";
            }
            if ((cpuFeatures & 8) == 8) {
                str = str + "LDREX_STREX ";
            }
            if ((cpuFeatures & 16) == 16) {
                str = str + "VFPv2 ";
            }
            if ((cpuFeatures & 32) == 32) {
                str = str + "VFP_D32 ";
            }
            if ((cpuFeatures & 64) == 64) {
                str = str + "VFP_FP16 ";
            }
            if ((cpuFeatures & 128) == 128) {
                str = str + "VFP_FMA ";
            }
            if ((cpuFeatures & 256) == 256) {
                str = str + "NEON_FMA ";
            }
            if ((cpuFeatures & 512) == 512) {
                str = str + "IDIV_ARM ";
            }
            if ((cpuFeatures & 1024) == 1024) {
                str = str + "IDIV_THUMB2 ";
            }
            if ((cpuFeatures & 2048) == 2048) {
                str = str + "iWMMXt ";
            }
            if ((cpuFeatures & 4096) == 4096) {
                str = str + "AES ";
            }
            if ((cpuFeatures & 8192) == 8192) {
                str = str + "PMULL ";
            }
            if ((cpuFeatures & 16384) == 16384) {
                str = str + "SHA1 ";
            }
            if ((cpuFeatures & 32768) == 32768) {
                str = str + "SHA2 ";
            }
            if ((65536 & cpuFeatures) != 65536) {
                return str;
            }
            return str + "CRC32 ";
        } else if (cpuFamily == 2) {
            if ((cpuFeatures & 1) == 1) {
                str = str + "SSSE3 ";
            }
            if ((cpuFeatures & 2) == 2) {
                str = str + "POPCNT ";
            }
            if ((cpuFeatures & 4) != 4) {
                return str;
            }
            return str + "MOVBE ";
        } else if (cpuFamily != 4) {
            return str;
        } else {
            if ((cpuFeatures & 1) == 1) {
                str = str + "FP ";
            }
            if ((cpuFeatures & 2) == 2) {
                str = str + "ASIMD ";
            }
            if ((cpuFeatures & 4) == 4) {
                str = str + "AES ";
            }
            if ((cpuFeatures & 8) == 8) {
                str = str + "PMULL ";
            }
            if ((cpuFeatures & 16) == 16) {
                str = str + "SHA1 ";
            }
            if ((cpuFeatures & 32) == 32) {
                str = str + "SHA2 ";
            }
            if ((cpuFeatures & 64) != 64) {
                return str;
            }
            return str + "CRC32 ";
        }
    }

    public static boolean isDebug(Context context) {
        return (context == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static boolean isSupportedPlatform(boolean z) {
        Environment.loadCpuInfoLib();
        String cpuFeatures = getCpuFeatures();
        String cpuFamily = getCpuFamily();
        boolean z2 = cpuFamily.equals("ARM") && cpuFeatures.contains("ARMv7") && cpuFeatures.contains("NEON");
        boolean equals = cpuFamily.equals("ARM64");
        boolean z3 = cpuFamily.equals("X86") && z;
        boolean z4 = cpuFamily.equals("X86_64") && z;
        if (z2 || equals || z3 || z4) {
            return true;
        }
        return false;
    }
}
