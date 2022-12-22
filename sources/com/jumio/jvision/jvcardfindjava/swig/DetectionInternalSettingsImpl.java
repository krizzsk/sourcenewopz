package com.jumio.jvision.jvcardfindjava.swig;

public class DetectionInternalSettingsImpl extends DetectionInternalSettings {

    /* renamed from: c */
    public transient long f55045c;

    /* renamed from: d */
    public transient boolean f55046d;

    public DetectionInternalSettingsImpl(long j, boolean z) {
        super(JVCardFindJavaJNI.DetectionInternalSettingsImpl_SWIGSmartPtrUpcast(j), true);
        this.f55046d = z;
        this.f55045c = j;
    }

    public static long getCPtr(DetectionInternalSettingsImpl detectionInternalSettingsImpl) {
        if (detectionInternalSettingsImpl == null) {
            return 0;
        }
        return detectionInternalSettingsImpl.f55045c;
    }

    public synchronized void delete() {
        long j = this.f55045c;
        if (j != 0) {
            if (this.f55046d) {
                this.f55046d = false;
                JVCardFindJavaJNI.delete_DetectionInternalSettingsImpl(j);
            }
            this.f55045c = 0;
        }
        super.delete();
    }

    public void finalize() {
        delete();
    }

    public CardDetectorConfiguration get_config() {
        long DetectionInternalSettingsImpl__config_get = JVCardFindJavaJNI.DetectionInternalSettingsImpl__config_get(this.f55045c, this);
        if (DetectionInternalSettingsImpl__config_get == 0) {
            return null;
        }
        return new CardDetectorConfiguration(DetectionInternalSettingsImpl__config_get, false);
    }

    public void set_config(CardDetectorConfiguration cardDetectorConfiguration) {
        JVCardFindJavaJNI.DetectionInternalSettingsImpl__config_set(this.f55045c, this, CardDetectorConfiguration.getCPtr(cardDetectorConfiguration), cardDetectorConfiguration);
    }

    public DetectionInternalSettingsImpl(String str) {
        this(JVCardFindJavaJNI.new_DetectionInternalSettingsImpl(str), true);
    }
}
