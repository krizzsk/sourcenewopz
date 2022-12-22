package com.didi.map.sdk.maprouter.global;

import com.didi.map.sdk.maprouter.MapType;
import com.didi.map.sdk.maprouter.OnNavTtsListener;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.Locale;

public class PlatInfo {

    /* renamed from: a */
    private static final String f28307a = "GlobalInfo";

    /* renamed from: b */
    private static PlatInfo f28308b;

    /* renamed from: c */
    private String f28309c = "";

    /* renamed from: d */
    private String f28310d = "";

    /* renamed from: e */
    private String f28311e = "";

    /* renamed from: f */
    private String f28312f = "";

    /* renamed from: g */
    private long f28313g;

    /* renamed from: h */
    private String f28314h = "";

    /* renamed from: i */
    private int f28315i = 0;

    /* renamed from: j */
    private String f28316j = "";

    /* renamed from: k */
    private String f28317k = "";

    /* renamed from: l */
    private OnNavTtsListener f28318l = null;

    /* renamed from: m */
    private int f28319m = -1;

    /* renamed from: n */
    private String f28320n = "";

    /* renamed from: o */
    private int f28321o = 0;

    /* renamed from: p */
    private String f28322p = "";

    /* renamed from: q */
    private String f28323q = "";

    /* renamed from: r */
    private int f28324r = -1;

    /* renamed from: s */
    private MapType f28325s = MapType.google;

    /* renamed from: t */
    private boolean f28326t = true;

    public String getCountryLanguage() {
        return this.f28309c;
    }

    public void setCountryLanguage(String str) {
        this.f28309c = str;
    }

    public static PlatInfo getInstance() {
        synchronized (PlatInfo.class) {
            if (f28308b == null) {
                f28308b = new PlatInfo();
            }
        }
        return f28308b;
    }

    public String getClientVersion() {
        return this.f28310d;
    }

    public void setClientVersion(String str) {
        this.f28310d = str;
    }

    public int getBizType() {
        return this.f28315i;
    }

    public void setBizType(int i) {
        this.f28315i = i;
    }

    @Deprecated
    public String getCountryID() {
        return this.f28316j;
    }

    @Deprecated
    public void setCountryID(String str) {
        this.f28316j = str;
    }

    public String getCountryCode() {
        return this.f28317k;
    }

    public void setCountryCode(String str) {
        this.f28317k = str;
    }

    public String getDriverPhoneNumber() {
        return this.f28311e;
    }

    public void setDriverPhoneNumber(String str) {
        this.f28311e = str;
    }

    public String getDriverTicket() {
        return this.f28312f;
    }

    public void setDriverTicket(String str) {
        this.f28312f = str;
    }

    public long getDriverId() {
        return this.f28313g;
    }

    public void setDriverId(long j) {
        this.f28313g = j;
    }

    public String getTraverId() {
        return this.f28314h;
    }

    public void setTraverId(String str) {
        this.f28314h = str;
    }

    public MapType getMapType() {
        return this.f28325s;
    }

    public void setMapType(MapType mapType) {
        this.f28325s = mapType;
    }

    public void setOnNavTtsListener(OnNavTtsListener onNavTtsListener) {
        this.f28318l = onNavTtsListener;
    }

    public OnNavTtsListener getOnNavTtsListener() {
        return this.f28318l;
    }

    public String toString() {
        return String.format(Locale.CHINA, "PlatInfo:(clientVersion=%s,driverPhoneNumber =%s,driverTicket =%s,driverId =%d, traverId= %s,bizType = %d,countryID= %s,countryCode= %s)", new Object[]{this.f28310d, this.f28311e, this.f28312f, Long.valueOf(this.f28313g), this.f28314h, Integer.valueOf(this.f28315i), this.f28316j, this.f28317k});
    }

    public int getOrderStage() {
        return this.f28319m;
    }

    public void setOrderStage(int i) {
        this.f28319m = i;
    }

    public boolean isPushConnect() {
        return this.f28326t;
    }

    public void setPushConnect(boolean z) {
        this.f28326t = z;
    }

    public String getDomainFlavor() {
        return this.f28320n;
    }

    public void setDomainFlavor(String str) {
        this.f28320n = str;
    }

    public String getPoiMapDomain() {
        String str = this.f28323q;
        if (str != null && str.length() > 0) {
            return this.f28323q;
        }
        return "https://poimap" + this.f28320n + ".didiglobal.com";
    }

    public String getApiMapDomain() {
        String str = this.f28322p;
        if (str != null && str.length() > 0) {
            return this.f28322p;
        }
        return "https://apimap" + this.f28320n + ".didiglobal.com";
    }

    public int getTerminalId() {
        return this.f28324r;
    }

    public void setTerminalId(int i) {
        this.f28324r = i;
    }

    public TravelMode getTravelMode() {
        int i = this.f28321o;
        if (i == 0) {
            return TravelMode.DRIVING;
        }
        if (i == 1) {
            return TravelMode.WALKING;
        }
        if (i == 2) {
            return TravelMode.BYCYCLING;
        }
        if (i != 3) {
            return TravelMode.DRIVING;
        }
        return TravelMode.TWOWHEELER;
    }

    public int getTravelModeNum() {
        return this.f28321o;
    }

    public void setTravelModeNum(int i) {
        this.f28321o = i;
    }

    public boolean isCanoe() {
        int i = this.f28324r;
        return i == 300302 || i == 300301;
    }

    public String getFullDomainApiMap() {
        return this.f28322p;
    }

    public void setFullDomainApiMap(String str) {
        this.f28322p = str;
    }

    public String getFullDomainPoiMap() {
        return this.f28323q;
    }

    public void setFullDomainPoiMap(String str) {
        this.f28323q = str;
    }
}
