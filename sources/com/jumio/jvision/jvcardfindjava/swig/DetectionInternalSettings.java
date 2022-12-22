package com.jumio.jvision.jvcardfindjava.swig;

public class DetectionInternalSettings {

    /* renamed from: a */
    public transient long f55042a;

    /* renamed from: b */
    public transient boolean f55043b;

    public DetectionInternalSettings(long j, boolean z) {
        this.f55043b = z;
        this.f55042a = j;
    }

    public static long getCPtr(DetectionInternalSettings detectionInternalSettings) {
        if (detectionInternalSettings == null) {
            return 0;
        }
        return detectionInternalSettings.f55042a;
    }

    public synchronized void delete() {
        long j = this.f55042a;
        if (j != 0) {
            if (this.f55043b) {
                this.f55043b = false;
                JVCardFindJavaJNI.delete_DetectionInternalSettings(j);
            }
            this.f55042a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public DetectionInternalSettings() {
        this(JVCardFindJavaJNI.new_DetectionInternalSettings(), true);
    }
}
