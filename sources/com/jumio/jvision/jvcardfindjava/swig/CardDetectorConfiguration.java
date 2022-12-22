package com.jumio.jvision.jvcardfindjava.swig;

public class CardDetectorConfiguration {

    /* renamed from: a */
    public transient long f55040a;
    public transient boolean swigCMemOwn;

    public CardDetectorConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f55040a = j;
    }

    public static long getCPtr(CardDetectorConfiguration cardDetectorConfiguration) {
        if (cardDetectorConfiguration == null) {
            return 0;
        }
        return cardDetectorConfiguration.f55040a;
    }

    public synchronized void delete() {
        long j = this.f55040a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_CardDetectorConfiguration(j);
            }
            this.f55040a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public CardDetectorConfiguration() {
        this(JVCardFindJavaJNI.new_CardDetectorConfiguration(), true);
    }
}
