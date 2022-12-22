package com.didi.dqrutil;

import com.didi.dqr.qrcode.detector.BestPatternMethodEnum;

public class DqrConfigHelper {

    /* renamed from: a */
    private DqrDecodeConfig f19111a;

    public static int useNativeDecodeRate() {
        return 0;
    }

    private static class InstanceHolder {
        public static DqrConfigHelper instance = new DqrConfigHelper();

        private InstanceHolder() {
        }
    }

    private DqrConfigHelper() {
    }

    public static void init(DqrDecodeConfig dqrDecodeConfig) {
        InstanceHolder.instance.f19111a = dqrDecodeConfig;
    }

    public static boolean useContourFinder() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.useContourFinder();
        }
        return false;
    }

    public static boolean useDynamicCVBlocksize() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.useDynamicCVBlocksize();
        }
        return true;
    }

    public static int contourDilateCount() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.contourDilateCount();
        }
        return 1;
    }

    public static int opencvBlockBulking() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.opencvBlockBulking();
        }
        return 1;
    }

    public static BestPatternMethodEnum findBestPatternType() {
        int findBestPatternType;
        if (InstanceHolder.instance.f19111a == null || (findBestPatternType = InstanceHolder.instance.f19111a.findBestPatternType()) < 0 || findBestPatternType >= BestPatternMethodEnum.values().length) {
            return BestPatternMethodEnum.TYPE_MIX;
        }
        return BestPatternMethodEnum.values()[findBestPatternType];
    }

    public static boolean usePatternAutoComple() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.usePatternAutoComple();
        }
        return true;
    }

    public static boolean usePatternCorrect() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.usePatternCorrect();
        }
        return false;
    }

    public static float patternCorrectLimit() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.patternCorrectLimit();
        }
        return 10.0f;
    }

    public static int newFinderRate() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.newFinderRate();
        }
        return 10;
    }

    public static int contourFinderRate() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.contourFinderRate();
        }
        return 15;
    }

    public static int patternCorrectRate() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.patternCorrectRate();
        }
        return 0;
    }

    public static boolean caculateIncline() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.caculateIncline();
        }
        return true;
    }

    public static float patternTolerant() {
        if (InstanceHolder.instance.f19111a == null) {
            return 0.4f;
        }
        float patternTolerant = InstanceHolder.instance.f19111a.patternTolerant();
        if (patternTolerant > 0.0f) {
            return patternTolerant;
        }
        return 0.4f;
    }

    public static int patternMinValidCount() {
        int patternMinValidCount;
        if (InstanceHolder.instance.f19111a == null || (patternMinValidCount = InstanceHolder.instance.f19111a.patternMinValidCount()) <= 0) {
            return 3;
        }
        return patternMinValidCount;
    }

    public static float cvBlockSizeFact() {
        if (InstanceHolder.instance.f19111a == null) {
            return 1.0f;
        }
        float cvBlockSizeFact = InstanceHolder.instance.f19111a.cvBlockSizeFact();
        if (cvBlockSizeFact > 0.0f) {
            return cvBlockSizeFact;
        }
        return 1.0f;
    }

    public static int binarizerType() {
        if (InstanceHolder.instance.f19111a == null) {
            return 3;
        }
        int binarizerType = InstanceHolder.instance.f19111a.binarizerType();
        if (binarizerType > 0) {
            return binarizerType;
        }
        return 4;
    }

    public static boolean analysisDqr() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.analysisDqr();
        }
        return false;
    }

    public static boolean cropRect() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.cropRect();
        }
        return false;
    }

    public static int cropRedundancy() {
        if (InstanceHolder.instance.f19111a == null) {
            return 20;
        }
        int cropRedundancy = InstanceHolder.instance.f19111a.cropRedundancy();
        if (cropRedundancy > 0) {
            return cropRedundancy;
        }
        return 4;
    }

    public static boolean useFilter() {
        if (InstanceHolder.instance.f19111a != null) {
            return InstanceHolder.instance.f19111a.useFilter();
        }
        return false;
    }
}
