package com.jumio.core.extraction.linefinder.environment;

import android.content.Context;
import com.jumio.core.environment.Environment;
import java.io.File;

public class LinefinderEnvironment extends Environment {
    public static final String BUILD_VERSION = "4.1.0";
    private static final String CARD_DETECTOR_CONFIG_FILE = "card_detector/card_detection_engine.xml";
    private static boolean JNI_JV_CARD_FIND_LIB_IS_LOADED = false;
    public static final String JVISION_VERSION = "0.16.0";

    public static String getCardDetectionSettingsPath(Context context) {
        Class<LinefinderEnvironment> cls = LinefinderEnvironment.class;
        Environment.extractFile(context, cls, "card_detector/card_detection_engine", "55008866990a7ac4b4eb782d8110a1d54e9d9725e814f41c23e12421ab73d664", ".xml");
        Environment.extractFile(context, cls, "card_detector/fast_findcard_config", "883c940b7493ee4322cc1f30cbdb079226245a520905acb1a5f48bcdd82710f7", ".xml");
        return new File(Environment.getDataDirectory(context), CARD_DETECTOR_CONFIG_FILE).getAbsolutePath();
    }

    public static synchronized boolean loadJniJvCardFindLib() {
        synchronized (LinefinderEnvironment.class) {
            if (!JNI_JV_CARD_FIND_LIB_IS_LOADED) {
                System.loadLibrary("JVCardFindJava");
                JNI_JV_CARD_FIND_LIB_IS_LOADED = true;
            }
        }
        return true;
    }
}
