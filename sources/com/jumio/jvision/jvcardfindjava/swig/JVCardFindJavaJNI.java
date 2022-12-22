package com.jumio.jvision.jvcardfindjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class JVCardFindJavaJNI {
    public static final native long DetectionEngine_processImage(long j, DetectionEngine detectionEngine, long j2, ImageSource imageSource);

    public static final native void DetectionEngine_resetSession(long j, DetectionEngine detectionEngine);

    public static final native long DetectionInternalSettingsFactory_createFromFileSystem(String str);

    public static final native long DetectionInternalSettingsImpl_SWIGSmartPtrUpcast(long j);

    public static final native long DetectionInternalSettingsImpl__config_get(long j, DetectionInternalSettingsImpl detectionInternalSettingsImpl);

    public static final native void DetectionInternalSettingsImpl__config_set(long j, DetectionInternalSettingsImpl detectionInternalSettingsImpl, long j2, CardDetectorConfiguration cardDetectorConfiguration);

    public static final native int DetectionResult_getCardImageQualityScore(long j, DetectionResult detectionResult);

    public static final native long DetectionResult_getCardQuadrangle(long j, DetectionResult detectionResult);

    public static final native long DetectionResult_getExposurePointOfInterest(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_getFlashTurnOn(long j, DetectionResult detectionResult);

    public static final native long DetectionResult_getFocusPointOfInterest(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_hasBottomOfCard(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_hasLeftOfCard(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_hasRightOfCard(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_hasTopOfCard(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_isCardImageOfGoodQuality(long j, DetectionResult detectionResult);

    public static final native boolean DetectionResult_isCardInRoi(long j, DetectionResult detectionResult);

    public static final native double DetectionSettings_getRoiBottomMargin(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiHorizontalDeviation(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiLeftMargin(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiRightMargin(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiTopMargin(long j, DetectionSettings detectionSettings);

    public static final native double DetectionSettings_getRoiVerticalDeviation(long j, DetectionSettings detectionSettings);

    public static final native void DetectionSettings_setRoiBottomMargin(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiHorizontalDeviation(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiLeftMargin(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiRightMargin(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiTopMargin(long j, DetectionSettings detectionSettings, double d);

    public static final native void DetectionSettings_setRoiVerticalDeviation(long j, DetectionSettings detectionSettings, double d);

    public static final native int IntPoint_getX(long j, IntPoint intPoint);

    public static final native int IntPoint_getY(long j, IntPoint intPoint);

    public static final native void IntQuadrangleVector_add(long j, IntQuadrangleVector intQuadrangleVector, long j2, IntQuadrangle intQuadrangle);

    public static final native long IntQuadrangleVector_capacity(long j, IntQuadrangleVector intQuadrangleVector);

    public static final native void IntQuadrangleVector_clear(long j, IntQuadrangleVector intQuadrangleVector);

    public static final native long IntQuadrangleVector_get(long j, IntQuadrangleVector intQuadrangleVector, int i);

    public static final native boolean IntQuadrangleVector_isEmpty(long j, IntQuadrangleVector intQuadrangleVector);

    public static final native void IntQuadrangleVector_reserve(long j, IntQuadrangleVector intQuadrangleVector, long j2);

    public static final native void IntQuadrangleVector_set(long j, IntQuadrangleVector intQuadrangleVector, int i, long j2, IntQuadrangle intQuadrangle);

    public static final native long IntQuadrangleVector_size(long j, IntQuadrangleVector intQuadrangleVector);

    public static final native long IntQuadrangle_getBottomLeft(long j, IntQuadrangle intQuadrangle);

    public static final native long IntQuadrangle_getBottomRight(long j, IntQuadrangle intQuadrangle);

    public static final native long IntQuadrangle_getTopLeft(long j, IntQuadrangle intQuadrangle);

    public static final native long IntQuadrangle_getTopRight(long j, IntQuadrangle intQuadrangle);

    public static final native long ToOcrPoint(long j, MinPoint2d minPoint2d);

    public static final native void delete_CardDetectorConfiguration(long j);

    public static final native void delete_DetectionEngine(long j);

    public static final native void delete_DetectionInternalSettings(long j);

    public static final native void delete_DetectionInternalSettingsFactory(long j);

    public static final native void delete_DetectionInternalSettingsImpl(long j);

    public static final native void delete_DetectionResult(long j);

    public static final native void delete_DetectionSettings(long j);

    public static final native void delete_IntPoint(long j);

    public static final native void delete_IntQuadrangle(long j);

    public static final native void delete_IntQuadrangleVector(long j);

    public static final native void delete_MinPoint2d(long j);

    public static final native long new_CardDetectorConfiguration();

    public static final native long new_DetectionEngine(long j, DetectionSettings detectionSettings, long j2, DetectionInternalSettingsImpl detectionInternalSettingsImpl);

    public static final native long new_DetectionInternalSettings();

    public static final native long new_DetectionInternalSettingsFactory();

    public static final native long new_DetectionInternalSettingsImpl(String str);

    public static final native long new_DetectionResult__SWIG_0();

    public static final native long new_DetectionResult__SWIG_1(boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, long j, IntPoint intPoint, long j2, IntPoint intPoint2, boolean z7, long j3, IntQuadrangle intQuadrangle);

    public static final native long new_DetectionSettings();

    public static final native long new_IntPoint__SWIG_0(int i, int i2);

    public static final native long new_IntPoint__SWIG_1(int i);

    public static final native long new_IntPoint__SWIG_2();

    public static final native long new_IntQuadrangleVector__SWIG_0();

    public static final native long new_IntQuadrangleVector__SWIG_1(long j);

    public static final native long new_IntQuadrangle__SWIG_0();

    public static final native long new_IntQuadrangle__SWIG_1(long j, IntPoint intPoint, long j2, IntPoint intPoint2, long j3, IntPoint intPoint3, long j4, IntPoint intPoint4);

    public static final native long new_MinPoint2d();
}
