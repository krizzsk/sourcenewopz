package com.jumio.jvision.jvcardfindjava.swig;

public class DetectionResult {

    /* renamed from: a */
    public transient long f55047a;
    public transient boolean swigCMemOwn;

    public DetectionResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55047a = j;
    }

    public static long getCPtr(DetectionResult detectionResult) {
        if (detectionResult == null) {
            return 0;
        }
        return detectionResult.f55047a;
    }

    public synchronized void delete() {
        long j = this.f55047a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_DetectionResult(j);
            }
            this.f55047a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getCardImageQualityScore() {
        return JVCardFindJavaJNI.DetectionResult_getCardImageQualityScore(this.f55047a, this);
    }

    public IntQuadrangle getCardQuadrangle() {
        return new IntQuadrangle(JVCardFindJavaJNI.DetectionResult_getCardQuadrangle(this.f55047a, this), true);
    }

    public IntPoint getExposurePointOfInterest() {
        return new IntPoint(JVCardFindJavaJNI.DetectionResult_getExposurePointOfInterest(this.f55047a, this), true);
    }

    public boolean getFlashTurnOn() {
        return JVCardFindJavaJNI.DetectionResult_getFlashTurnOn(this.f55047a, this);
    }

    public IntPoint getFocusPointOfInterest() {
        return new IntPoint(JVCardFindJavaJNI.DetectionResult_getFocusPointOfInterest(this.f55047a, this), true);
    }

    public boolean hasBottomOfCard() {
        return JVCardFindJavaJNI.DetectionResult_hasBottomOfCard(this.f55047a, this);
    }

    public boolean hasLeftOfCard() {
        return JVCardFindJavaJNI.DetectionResult_hasLeftOfCard(this.f55047a, this);
    }

    public boolean hasRightOfCard() {
        return JVCardFindJavaJNI.DetectionResult_hasRightOfCard(this.f55047a, this);
    }

    public boolean hasTopOfCard() {
        return JVCardFindJavaJNI.DetectionResult_hasTopOfCard(this.f55047a, this);
    }

    public boolean isCardImageOfGoodQuality() {
        return JVCardFindJavaJNI.DetectionResult_isCardImageOfGoodQuality(this.f55047a, this);
    }

    public boolean isCardInRoi() {
        return JVCardFindJavaJNI.DetectionResult_isCardInRoi(this.f55047a, this);
    }

    public DetectionResult() {
        this(JVCardFindJavaJNI.new_DetectionResult__SWIG_0(), true);
    }

    public DetectionResult(boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, IntPoint intPoint, IntPoint intPoint2, boolean z7, IntQuadrangle intQuadrangle) {
        this(JVCardFindJavaJNI.new_DetectionResult__SWIG_1(z, z2, i, z3, z4, z5, z6, IntPoint.getCPtr(intPoint), intPoint, IntPoint.getCPtr(intPoint2), intPoint2, z7, IntQuadrangle.getCPtr(intQuadrangle), intQuadrangle), true);
    }
}
