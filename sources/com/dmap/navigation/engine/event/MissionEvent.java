package com.dmap.navigation.engine.event;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.jni.swig.MissionButtonInfo;
import com.dmap.navigation.jni.swig.MissionButtonList;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.simple.SimpleLatlng;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissionEvent extends NaviEvent {
    public static final int MISSION_DISPLAY_HIDE_ICON_SHOW_BUBBLE = 3;
    public static final int MISSION_DISPLAY_NOT_SHOW = 1;
    public static final int MISSION_DISPLAY_NULL = 0;
    public static final int MISSION_DISPLAY_SHOW_ICON = 2;

    /* renamed from: a */
    private final long f51934a;

    /* renamed from: b */
    private final int f51935b;

    /* renamed from: c */
    private final String f51936c;

    /* renamed from: d */
    private final String f51937d;

    /* renamed from: e */
    private final LatLng f51938e;

    /* renamed from: f */
    private final byte[] f51939f;

    /* renamed from: g */
    private final BigInteger f51940g;

    /* renamed from: h */
    private final List<IMissionButtonInfo> f51941h;

    /* renamed from: i */
    private final int f51942i;

    /* renamed from: j */
    private final String f51943j;

    public interface IMissionButtonInfo {
        String getButtonPicUrl();

        String getButtonTitle();

        int getButtonType();

        int getButtonValue();
    }

    public MissionEvent(long j, int i, String str, String str2, NaviLatLng naviLatLng, byte[] bArr, BigInteger bigInteger, MissionButtonList missionButtonList, int i2, String str3) {
        this.f51934a = j;
        this.f51935b = i;
        this.f51936c = str;
        this.f51937d = str2;
        this.f51938e = new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng());
        this.f51939f = bArr;
        this.f51940g = bigInteger;
        this.f51942i = i2;
        this.f51943j = str3;
        int size = (int) missionButtonList.size();
        if (size > 0) {
            this.f51941h = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                this.f51941h.add(new SimpleMissionButtonInfo(missionButtonList.get(i3)));
            }
            return;
        }
        this.f51941h = null;
    }

    public String toString() {
        return "MissionEvent{missionId=" + this.f51934a + ", missionType=" + this.f51935b + ", missionTitle='" + this.f51936c + '\'' + ", missionTitlePicUrl='" + this.f51937d + '\'' + ", missionPos=" + this.f51938e + ", missionPbData=" + Arrays.toString(this.f51939f) + ", routeId=" + this.f51940g + ", buttonList=" + this.f51941h + ", missionDisplay=" + this.f51942i + ", missionDescription=" + this.f51943j + '}';
    }

    public long getMissionId() {
        return this.f51934a;
    }

    public int getMissionType() {
        return this.f51935b;
    }

    public String getMissionTitle() {
        return this.f51936c;
    }

    public String getMissionTitlePicUrl() {
        return this.f51937d;
    }

    public LatLng getMissionPos() {
        return this.f51938e;
    }

    public byte[] getMissionPbData() {
        return this.f51939f;
    }

    public BigInteger getRouteId() {
        return this.f51940g;
    }

    public int getMissionDisplay() {
        return this.f51942i;
    }

    public String getMissionDescription() {
        return this.f51943j;
    }

    public List<IMissionButtonInfo> getButtonList() {
        return this.f51941h;
    }

    public static class SimpleMissionButtonInfo implements IMissionButtonInfo {
        private final String buttonPicUrl;
        private final String buttonTitle;
        private final int buttonType;
        private final int buttonValue;

        SimpleMissionButtonInfo(MissionButtonInfo missionButtonInfo) {
            this.buttonTitle = missionButtonInfo.getButtonTitle();
            this.buttonPicUrl = missionButtonInfo.getButtonPicUrl();
            this.buttonType = missionButtonInfo.getButtonType();
            this.buttonValue = missionButtonInfo.getButtonValue();
        }

        public String toString() {
            return "SimpleMissionButtonInfo{buttonTitle='" + this.buttonTitle + '\'' + ", buttonPicUrl='" + this.buttonPicUrl + '\'' + ", buttonType=" + this.buttonType + ", buttonValue=" + this.buttonValue + '}';
        }

        public String getButtonTitle() {
            return this.buttonTitle;
        }

        public String getButtonPicUrl() {
            return this.buttonPicUrl;
        }

        public int getButtonType() {
            return this.buttonType;
        }

        public int getButtonValue() {
            return this.buttonValue;
        }
    }
}
