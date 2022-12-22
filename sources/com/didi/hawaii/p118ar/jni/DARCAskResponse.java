package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.DARCAskResponse */
public class DARCAskResponse extends DARCObject {
    private transient long swigCPtr;

    /* access modifiers changed from: protected */
    public void finalize() {
        DARCObject.release(this);
    }

    protected DARCAskResponse(long j, boolean z) {
        super(AREngineJNIBridge.DARCAskResponse_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(DARCAskResponse dARCAskResponse) {
        if (dARCAskResponse == null) {
            return 0;
        }
        return dARCAskResponse.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (!this.swigCMemOwn) {
                this.swigCPtr = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
        super.delete();
    }

    public static DARCAskResponse alloc() {
        long DARCAskResponse_alloc = AREngineJNIBridge.DARCAskResponse_alloc();
        if (DARCAskResponse_alloc == 0) {
            return null;
        }
        return new DARCAskResponse(DARCAskResponse_alloc, false);
    }

    public boolean isInGeoFence(int i, float f, float f2) {
        return AREngineJNIBridge.DARCAskResponse_isInGeoFence(this.swigCPtr, this, i, f, f2);
    }

    public boolean isNearbyFence(float f, float f2) {
        return AREngineJNIBridge.DARCAskResponse_isNearbyFence(this.swigCPtr, this, f, f2);
    }

    public void setIsSupport(boolean z) {
        AREngineJNIBridge.DARCAskResponse_isSupport_set(this.swigCPtr, this, z);
    }

    public boolean getIsSupport() {
        return AREngineJNIBridge.DARCAskResponse_isSupport_get(this.swigCPtr, this);
    }

    public void setErrorCode(int i) {
        AREngineJNIBridge.DARCAskResponse_errorCode_set(this.swigCPtr, this, i);
    }

    public int getErrorCode() {
        return AREngineJNIBridge.DARCAskResponse_errorCode_get(this.swigCPtr, this);
    }

    public void setQuality(float f) {
        AREngineJNIBridge.DARCAskResponse_quality_set(this.swigCPtr, this, f);
    }

    public float getQuality() {
        return AREngineJNIBridge.DARCAskResponse_quality_get(this.swigCPtr, this);
    }

    public void setSession(String str) {
        AREngineJNIBridge.DARCAskResponse_session_set(this.swigCPtr, this, str);
    }

    public String getSession() {
        return AREngineJNIBridge.DARCAskResponse_session_get(this.swigCPtr, this);
    }

    public void setModel(String str) {
        AREngineJNIBridge.DARCAskResponse_model_set(this.swigCPtr, this, str);
    }

    public String getModel() {
        return AREngineJNIBridge.DARCAskResponse_model_get(this.swigCPtr, this);
    }

    public void setDestLoc(DARCLocationInScene dARCLocationInScene) {
        AREngineJNIBridge.DARCAskResponse_destLoc_set(this.swigCPtr, this, DARCLocationInScene.getCPtr(dARCLocationInScene), dARCLocationInScene);
    }

    public DARCLocationInScene getDestLoc() {
        long DARCAskResponse_destLoc_get = AREngineJNIBridge.DARCAskResponse_destLoc_get(this.swigCPtr, this);
        if (DARCAskResponse_destLoc_get == 0) {
            return null;
        }
        return new DARCLocationInScene(DARCAskResponse_destLoc_get, false);
    }

    public void setDestName(String str) {
        AREngineJNIBridge.DARCAskResponse_destName_set(this.swigCPtr, this, str);
    }

    public String getDestName() {
        return AREngineJNIBridge.DARCAskResponse_destName_get(this.swigCPtr, this);
    }

    public void setAlertMessage(String str) {
        AREngineJNIBridge.DARCAskResponse_alertMessage_set(this.swigCPtr, this, str);
    }

    public String getAlertMessage() {
        return AREngineJNIBridge.DARCAskResponse_alertMessage_get(this.swigCPtr, this);
    }

    public void setHelpText(String str) {
        AREngineJNIBridge.DARCAskResponse_helpText_set(this.swigCPtr, this, str);
    }

    public String getHelpText() {
        return AREngineJNIBridge.DARCAskResponse_helpText_get(this.swigCPtr, this);
    }

    public void setLocFailMessage(String str) {
        AREngineJNIBridge.DARCAskResponse_locFailMessage_set(this.swigCPtr, this, str);
    }

    public String getLocFailMessage() {
        return AREngineJNIBridge.DARCAskResponse_locFailMessage_get(this.swigCPtr, this);
    }

    public void setMotionlessHintMessage(String str) {
        AREngineJNIBridge.DARCAskResponse_motionlessHintMessage_set(this.swigCPtr, this, str);
    }

    public String getMotionlessHintMessage() {
        return AREngineJNIBridge.DARCAskResponse_motionlessHintMessage_get(this.swigCPtr, this);
    }

    /* renamed from: com.didi.hawaii.ar.jni.DARCAskResponse$GeoFence */
    public static class GeoFence {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        protected GeoFence(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        protected static long getCPtr(GeoFence geoFence) {
            if (geoFence == null) {
                return 0;
            }
            return geoFence.swigCPtr;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            delete();
        }

        public synchronized void delete() {
            if (this.swigCPtr != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    AREngineJNIBridge.delete_DARCAskResponse_GeoFence(this.swigCPtr);
                }
                this.swigCPtr = 0;
            }
        }

        public GeoFence() {
            this(AREngineJNIBridge.new_DARCAskResponse_GeoFence(), true);
        }

        /* renamed from: com.didi.hawaii.ar.jni.DARCAskResponse$GeoFence$TimeLimit */
        public static class TimeLimit {
            protected transient boolean swigCMemOwn;
            private transient long swigCPtr;

            protected TimeLimit(long j, boolean z) {
                this.swigCMemOwn = z;
                this.swigCPtr = j;
            }

            protected static long getCPtr(TimeLimit timeLimit) {
                if (timeLimit == null) {
                    return 0;
                }
                return timeLimit.swigCPtr;
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                delete();
            }

            public synchronized void delete() {
                if (this.swigCPtr != 0) {
                    if (this.swigCMemOwn) {
                        this.swigCMemOwn = false;
                        AREngineJNIBridge.delete_DARCAskResponse_GeoFence_TimeLimit(this.swigCPtr);
                    }
                    this.swigCPtr = 0;
                }
            }

            public TimeLimit() {
                this(AREngineJNIBridge.new_DARCAskResponse_GeoFence_TimeLimit(), true);
            }

            public void setStart(int i) {
                AREngineJNIBridge.DARCAskResponse_GeoFence_TimeLimit_start_set(this.swigCPtr, this, i);
            }

            public int getStart() {
                return AREngineJNIBridge.DARCAskResponse_GeoFence_TimeLimit_start_get(this.swigCPtr, this);
            }

            public void setEnd(int i) {
                AREngineJNIBridge.DARCAskResponse_GeoFence_TimeLimit_end_set(this.swigCPtr, this, i);
            }

            public int getEnd() {
                return AREngineJNIBridge.DARCAskResponse_GeoFence_TimeLimit_end_get(this.swigCPtr, this);
            }
        }

        public void setRadius(float f) {
            AREngineJNIBridge.DARCAskResponse_GeoFence_radius_set(this.swigCPtr, this, f);
        }

        public float getRadius() {
            return AREngineJNIBridge.DARCAskResponse_GeoFence_radius_get(this.swigCPtr, this);
        }

        public void setCenter(DARCGeoPoint dARCGeoPoint) {
            AREngineJNIBridge.DARCAskResponse_GeoFence_center_set(this.swigCPtr, this, DARCGeoPoint.getCPtr(dARCGeoPoint), dARCGeoPoint);
        }

        public DARCGeoPoint getCenter() {
            long DARCAskResponse_GeoFence_center_get = AREngineJNIBridge.DARCAskResponse_GeoFence_center_get(this.swigCPtr, this);
            if (DARCAskResponse_GeoFence_center_get == 0) {
                return null;
            }
            return new DARCGeoPoint(DARCAskResponse_GeoFence_center_get, false);
        }

        public boolean hasFenceData() {
            return AREngineJNIBridge.DARCAskResponse_GeoFence_hasFenceData(this.swigCPtr, this);
        }
    }

    public void setFence(GeoFence geoFence) {
        AREngineJNIBridge.DARCAskResponse_fence_set(this.swigCPtr, this, GeoFence.getCPtr(geoFence), geoFence);
    }

    public GeoFence getFence() {
        long DARCAskResponse_fence_get = AREngineJNIBridge.DARCAskResponse_fence_get(this.swigCPtr, this);
        if (DARCAskResponse_fence_get == 0) {
            return null;
        }
        return new GeoFence(DARCAskResponse_fence_get, false);
    }

    public float locPmMinRadian() {
        return AREngineJNIBridge.DARCAskResponse_locPmMinRadian(this.swigCPtr, this);
    }

    public float locPmMaxRadian() {
        return AREngineJNIBridge.DARCAskResponse_locPmMaxRadian(this.swigCPtr, this);
    }

    public void setEntranceType(DARCNaviType dARCNaviType) {
        AREngineJNIBridge.DARCAskResponse_entranceType_set(this.swigCPtr, this, dARCNaviType.swigValue());
    }

    public DARCNaviType getEntranceType() {
        return DARCNaviType.swigToEnum(AREngineJNIBridge.DARCAskResponse_entranceType_get(this.swigCPtr, this));
    }

    public void setScene(int i) {
        AREngineJNIBridge.DARCAskResponse_scene_set(this.swigCPtr, this, i);
    }

    public int getScene() {
        return AREngineJNIBridge.DARCAskResponse_scene_get(this.swigCPtr, this);
    }
}
