package com.jumio.ale.swig;

public class ALESettings {

    /* renamed from: a */
    public transient long f54511a;
    public transient boolean swigCMemOwn;

    public ALESettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f54511a = j;
    }

    public static long getCPtr(ALESettings aLESettings) {
        if (aLESettings == null) {
            return 0;
        }
        return aLESettings.f54511a;
    }

    public synchronized void delete() {
        long j = this.f54511a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALESettings(j);
            }
            this.f54511a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public String getDirectory() {
        return aleEngineJNI.ALESettings_getDirectory(this.f54511a, this);
    }

    public String getKeyID() {
        return aleEngineJNI.ALESettings_getKeyID(this.f54511a, this);
    }

    public String getPublicKey() {
        return aleEngineJNI.ALESettings_getPublicKey(this.f54511a, this);
    }

    public void setDirectory(String str) {
        aleEngineJNI.ALESettings_setDirectory(this.f54511a, this, str);
    }

    public void setKeyID(String str) {
        aleEngineJNI.ALESettings_setKeyID(this.f54511a, this, str);
    }

    public void setPublicKey(String str) {
        aleEngineJNI.ALESettings_setPublicKey(this.f54511a, this, str);
    }

    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        aleEngineJNI.ALESettings_change_ownership(this, this.f54511a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        aleEngineJNI.ALESettings_change_ownership(this, this.f54511a, true);
    }

    public ALESettings() {
        this(aleEngineJNI.new_ALESettings(), true);
        aleEngineJNI.ALESettings_director_connect(this, this.f54511a, true, true);
    }
}
