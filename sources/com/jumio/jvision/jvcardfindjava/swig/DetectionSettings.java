package com.jumio.jvision.jvcardfindjava.swig;

public class DetectionSettings {

    /* renamed from: a */
    public transient long f55048a;
    public transient boolean swigCMemOwn;

    public DetectionSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55048a = j;
    }

    public static long getCPtr(DetectionSettings detectionSettings) {
        if (detectionSettings == null) {
            return 0;
        }
        return detectionSettings.f55048a;
    }

    public synchronized void delete() {
        long j = this.f55048a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_DetectionSettings(j);
            }
            this.f55048a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public double getRoiBottomMargin() {
        return JVCardFindJavaJNI.DetectionSettings_getRoiBottomMargin(this.f55048a, this);
    }

    public double getRoiHorizontalDeviation() {
        return JVCardFindJavaJNI.DetectionSettings_getRoiHorizontalDeviation(this.f55048a, this);
    }

    public double getRoiLeftMargin() {
        return JVCardFindJavaJNI.DetectionSettings_getRoiLeftMargin(this.f55048a, this);
    }

    public double getRoiRightMargin() {
        return JVCardFindJavaJNI.DetectionSettings_getRoiRightMargin(this.f55048a, this);
    }

    public double getRoiTopMargin() {
        return JVCardFindJavaJNI.DetectionSettings_getRoiTopMargin(this.f55048a, this);
    }

    public double getRoiVerticalDeviation() {
        return JVCardFindJavaJNI.DetectionSettings_getRoiVerticalDeviation(this.f55048a, this);
    }

    public void setRoiBottomMargin(double d) {
        JVCardFindJavaJNI.DetectionSettings_setRoiBottomMargin(this.f55048a, this, d);
    }

    public void setRoiHorizontalDeviation(double d) {
        JVCardFindJavaJNI.DetectionSettings_setRoiHorizontalDeviation(this.f55048a, this, d);
    }

    public void setRoiLeftMargin(double d) {
        JVCardFindJavaJNI.DetectionSettings_setRoiLeftMargin(this.f55048a, this, d);
    }

    public void setRoiRightMargin(double d) {
        JVCardFindJavaJNI.DetectionSettings_setRoiRightMargin(this.f55048a, this, d);
    }

    public void setRoiTopMargin(double d) {
        JVCardFindJavaJNI.DetectionSettings_setRoiTopMargin(this.f55048a, this, d);
    }

    public void setRoiVerticalDeviation(double d) {
        JVCardFindJavaJNI.DetectionSettings_setRoiVerticalDeviation(this.f55048a, this, d);
    }

    public DetectionSettings() {
        this(JVCardFindJavaJNI.new_DetectionSettings(), true);
    }
}
