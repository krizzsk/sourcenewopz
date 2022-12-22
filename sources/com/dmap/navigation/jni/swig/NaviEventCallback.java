package com.dmap.navigation.jni.swig;

import java.math.BigInteger;

public class NaviEventCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected NaviEventCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(NaviEventCallback naviEventCallback) {
        if (naviEventCallback == null) {
            return 0;
        }
        return naviEventCallback.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NaviBusinessJNI.delete_NaviEventCallback(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        NaviBusinessJNI.NaviEventCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        NaviBusinessJNI.NaviEventCallback_change_ownership(this, this.swigCPtr, true);
    }

    public NaviEventCallback() {
        this(NaviBusinessJNI.new_NaviEventCallback(), true);
        NaviBusinessJNI.NaviEventCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onVoiceEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onVoiceEvent(this.swigCPtr, this, str, str2, i, i2, i3, i4, i5, i6, i7);
        } else {
            NaviBusinessJNI.NaviEventCallback_onVoiceEventSwigExplicitNaviEventCallback(this.swigCPtr, this, str, str2, i, i2, i3, i4, i5, i6, i7);
        }
    }

    public void onArrivedEvent(boolean z, NaviLatLng naviLatLng, NaviLatLng naviLatLng2, NaviLatLng naviLatLng3, int i, int i2) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onArrivedEvent(this.swigCPtr, this, z, NaviLatLng.getCPtr(naviLatLng), naviLatLng, NaviLatLng.getCPtr(naviLatLng2), naviLatLng2, NaviLatLng.getCPtr(naviLatLng3), naviLatLng3, i, i2);
            return;
        }
        NaviBusinessJNI.NaviEventCallback_onArrivedEventSwigExplicitNaviEventCallback(this.swigCPtr, this, z, NaviLatLng.getCPtr(naviLatLng), naviLatLng, NaviLatLng.getCPtr(naviLatLng2), naviLatLng2, NaviLatLng.getCPtr(naviLatLng3), naviLatLng3, i, i2);
    }

    public void onCameraEvent(int i, NaviCameraList naviCameraList, int i2) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onCameraEvent(this.swigCPtr, this, i, NaviCameraList.getCPtr(naviCameraList), naviCameraList, i2);
            return;
        }
        NaviBusinessJNI.NaviEventCallback_onCameraEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i, NaviCameraList.getCPtr(naviCameraList), naviCameraList, i2);
    }

    public void onCongestionEvent(int i, int i2, int i3, int i4, int i5, int i6) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onCongestionEvent(this.swigCPtr, this, i, i2, i3, i4, i5, i6);
        } else {
            NaviBusinessJNI.NaviEventCallback_onCongestionEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i, i2, i3, i4, i5, i6);
        }
    }

    public void onDestinationEvent(int i, int i2, int i3, int i4, int i5) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onDestinationEvent(this.swigCPtr, this, i, i2, i3, i4, i5);
        } else {
            NaviBusinessJNI.m37054x47b71df2(this.swigCPtr, this, i, i2, i3, i4, i5);
        }
    }

    public void onDownloadEvent(StringList stringList) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onDownloadEvent(this.swigCPtr, this, StringList.getCPtr(stringList), stringList);
            return;
        }
        NaviBusinessJNI.NaviEventCallback_onDownloadEventSwigExplicitNaviEventCallback(this.swigCPtr, this, StringList.getCPtr(stringList), stringList);
    }

    public void onDownloadVecEvent(String str, String str2, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onDownloadVecEvent(this.swigCPtr, this, str, str2, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char), i);
            return;
        }
        NaviBusinessJNI.m37056xca313c50(this.swigCPtr, this, str, str2, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char), i);
    }

    public void onEnlargeMapEvent(int i, String str, String str2) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onEnlargeMapEvent(this.swigCPtr, this, i, str, str2);
        } else {
            NaviBusinessJNI.NaviEventCallback_onEnlargeMapEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i, str, str2);
        }
    }

    public void onIllegalParkEvent(int i, int i2, int i3, String str, String str2, NaviLatLng naviLatLng, NaviLatLng naviLatLng2) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onIllegalParkEvent(this.swigCPtr, this, i, i2, i3, str, str2, NaviLatLng.getCPtr(naviLatLng), naviLatLng, NaviLatLng.getCPtr(naviLatLng2), naviLatLng2);
            return;
        }
        NaviBusinessJNI.m37057xe6357de4(this.swigCPtr, this, i, i2, i3, str, str2, NaviLatLng.getCPtr(naviLatLng), naviLatLng, NaviLatLng.getCPtr(naviLatLng2), naviLatLng2);
    }

    public void onIntersectionEvent(int i, String str, String str2, int i2, int i3, int i4, NaviLatLng naviLatLng, int i5, int i6, String str3, boolean z, int i7) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onIntersectionEvent(this.swigCPtr, this, i, str, str2, i2, i3, i4, NaviLatLng.getCPtr(naviLatLng), naviLatLng, i5, i6, str3, z, i7);
            return;
        }
        NaviBusinessJNI.m37058x68f0ef17(this.swigCPtr, this, i, str, str2, i2, i3, i4, NaviLatLng.getCPtr(naviLatLng), naviLatLng, i5, i6, str3, z, i7);
    }

    public void onLaneEvent(int i, String str, String str2, String str3, int i2, int i3, BigInteger bigInteger, NaviLatLng naviLatLng, int i4) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onLaneEvent(this.swigCPtr, this, i, str, str2, str3, i2, i3, bigInteger, NaviLatLng.getCPtr(naviLatLng), naviLatLng, i4);
            return;
        }
        NaviBusinessJNI.NaviEventCallback_onLaneEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i, str, str2, str3, i2, i3, bigInteger, NaviLatLng.getCPtr(naviLatLng), naviLatLng, i4);
    }

    public void onLimitSpeedCameraEvent(int i, int i2, int i3, NaviLatLng naviLatLng, String str) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onLimitSpeedCameraEvent(this.swigCPtr, this, i, i2, i3, NaviLatLng.getCPtr(naviLatLng), naviLatLng, str);
            return;
        }
        NaviBusinessJNI.m37059xcd6e2f9f(this.swigCPtr, this, i, i2, i3, NaviLatLng.getCPtr(naviLatLng), naviLatLng, str);
    }

    public void onMatchLocationEvent(BigInteger bigInteger, NaviLocation naviLocation, int i, int i2, double d, int i3) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onMatchLocationEvent(this.swigCPtr, this, bigInteger, NaviLocation.getCPtr(naviLocation), naviLocation, i, i2, d, i3);
            return;
        }
        NaviBusinessJNI.m37060x69fa2cbe(this.swigCPtr, this, bigInteger, NaviLocation.getCPtr(naviLocation), naviLocation, i, i2, d, i3);
    }

    public void onMissionEvent(long j, int i, String str, String str2, NaviLatLng naviLatLng, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i2, BigInteger bigInteger, MissionButtonList missionButtonList, int i3, String str3) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onMissionEvent(this.swigCPtr, this, j, i, str, str2, NaviLatLng.getCPtr(naviLatLng), naviLatLng, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char), i2, bigInteger, MissionButtonList.getCPtr(missionButtonList), missionButtonList, i3, str3);
            return;
        }
        NaviBusinessJNI.NaviEventCallback_onMissionEventSwigExplicitNaviEventCallback(this.swigCPtr, this, j, i, str, str2, NaviLatLng.getCPtr(naviLatLng), naviLatLng, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char), i2, bigInteger, MissionButtonList.getCPtr(missionButtonList), missionButtonList, i3, str3);
    }

    public void onDownloadMJOEvent(long j, String str, String str2, String str3) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onDownloadMJOEvent(this.swigCPtr, this, j, str, str2, str3);
        } else {
            NaviBusinessJNI.m37055xcdb0dfae(this.swigCPtr, this, j, str, str2, str3);
        }
    }

    public void onMJOEvent(int i, long j, String str, BigInteger bigInteger) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onMJOEvent(this.swigCPtr, this, i, j, str, bigInteger);
        } else {
            NaviBusinessJNI.NaviEventCallback_onMJOEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i, j, str, bigInteger);
        }
    }

    public void onYawEvent(BindNaviLocation bindNaviLocation, int i, int i2) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onYawEvent(this.swigCPtr, this, BindNaviLocation.getCPtr(bindNaviLocation), bindNaviLocation, i, i2);
            return;
        }
        NaviBusinessJNI.NaviEventCallback_onYawEventSwigExplicitNaviEventCallback(this.swigCPtr, this, BindNaviLocation.getCPtr(bindNaviLocation), bindNaviLocation, i, i2);
    }

    public void onParallelRoadEvent(int i, int i2) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onParallelRoadEvent(this.swigCPtr, this, i, i2);
        } else {
            NaviBusinessJNI.m37061xbb7f3ad5(this.swigCPtr, this, i, i2);
        }
    }

    public void onPassPointVerifyEvent(int i) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onPassPointVerifyEvent(this.swigCPtr, this, i);
        } else {
            NaviBusinessJNI.m37062x46ca2f3c(this.swigCPtr, this, i);
        }
    }

    public void onQRPayEvent(int i, BigInteger bigInteger) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onQRPayEvent(this.swigCPtr, this, i, bigInteger);
        } else {
            NaviBusinessJNI.NaviEventCallback_onQRPayEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i, bigInteger);
        }
    }

    public void onSlopeInfoEvent(int i) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onSlopeInfoEvent(this.swigCPtr, this, i);
        } else {
            NaviBusinessJNI.NaviEventCallback_onSlopeInfoEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i);
        }
    }

    public void onSpeedIconEvent(int i, int i2, int i3, int i4, int i5, float f, int i6) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onSpeedIconEvent(this.swigCPtr, this, i, i2, i3, i4, i5, f, i6);
        } else {
            NaviBusinessJNI.NaviEventCallback_onSpeedIconEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i, i2, i3, i4, i5, f, i6);
        }
    }

    public void onVDRInfoEvent(BigInteger bigInteger, double d, double d2, float f, int i, int i2) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onVDRInfoEvent(this.swigCPtr, this, bigInteger, d, d2, f, i, i2);
        } else {
            NaviBusinessJNI.NaviEventCallback_onVDRInfoEventSwigExplicitNaviEventCallback(this.swigCPtr, this, bigInteger, d, d2, f, i, i2);
        }
    }

    public void onVecEnlargeMapEvent(int i, String str, String str2) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onVecEnlargeMapEvent(this.swigCPtr, this, i, str, str2);
        } else {
            NaviBusinessJNI.m37063x59005da2(this.swigCPtr, this, i, str, str2);
        }
    }

    public void onRoutesEvent(LongList longList, int i) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onRoutesEvent(this.swigCPtr, this, LongList.getCPtr(longList), longList, i);
            return;
        }
        NaviBusinessJNI.NaviEventCallback_onRoutesEventSwigExplicitNaviEventCallback(this.swigCPtr, this, LongList.getCPtr(longList), longList, i);
    }

    public void onMoreRouteEvent(int i, String str) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onMoreRouteEvent(this.swigCPtr, this, i, str);
        } else {
            NaviBusinessJNI.NaviEventCallback_onMoreRouteEventSwigExplicitNaviEventCallback(this.swigCPtr, this, i, str);
        }
    }

    public void onAnalysisEvent(String str, AnalysisLogList analysisLogList) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onAnalysisEvent(this.swigCPtr, this, str, AnalysisLogList.getCPtr(analysisLogList), analysisLogList);
            return;
        }
        NaviBusinessJNI.NaviEventCallback_onAnalysisEventSwigExplicitNaviEventCallback(this.swigCPtr, this, str, AnalysisLogList.getCPtr(analysisLogList), analysisLogList);
    }

    public void onToastText(int i, String str) {
        if (getClass() == NaviEventCallback.class) {
            NaviBusinessJNI.NaviEventCallback_onToastText(this.swigCPtr, this, i, str);
        } else {
            NaviBusinessJNI.NaviEventCallback_onToastTextSwigExplicitNaviEventCallback(this.swigCPtr, this, i, str);
        }
    }
}
