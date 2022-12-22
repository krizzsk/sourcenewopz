package com.didi.map.sdk.maprouter.china;

public class CommonData {

    /* renamed from: u */
    private static CommonData f28286u;

    /* renamed from: a */
    private String f28287a;

    /* renamed from: b */
    private int f28288b;

    /* renamed from: c */
    private double f28289c;

    /* renamed from: d */
    private double f28290d;

    /* renamed from: e */
    private double f28291e;

    /* renamed from: f */
    private double f28292f;

    /* renamed from: g */
    private double f28293g;

    /* renamed from: h */
    private double f28294h;

    /* renamed from: i */
    private int f28295i;

    /* renamed from: j */
    private String f28296j;

    /* renamed from: k */
    private String f28297k;

    /* renamed from: l */
    private String f28298l;

    /* renamed from: m */
    private String f28299m;

    /* renamed from: n */
    private String f28300n;

    /* renamed from: o */
    private String f28301o;

    /* renamed from: p */
    private String f28302p;

    /* renamed from: q */
    private String f28303q;

    /* renamed from: r */
    private int f28304r;

    /* renamed from: s */
    private int f28305s;

    /* renamed from: t */
    private int f28306t;

    public static CommonData getInstance() {
        synchronized (CommonData.class) {
            if (f28286u == null) {
                f28286u = new CommonData();
            }
        }
        return f28286u;
    }

    public String getOrderId() {
        return this.f28287a;
    }

    public void setOrderId(String str) {
        this.f28287a = str;
    }

    public int getOrderStage() {
        return this.f28288b;
    }

    public void setOrderStage(int i) {
        this.f28288b = i;
    }

    public double getStartLat() {
        return this.f28289c;
    }

    public void setStartLat(double d) {
        this.f28289c = d;
    }

    public double getStartLon() {
        return this.f28290d;
    }

    public void setStartLon(double d) {
        this.f28290d = d;
    }

    public double getDestLat() {
        return this.f28291e;
    }

    public void setDestLat(double d) {
        this.f28291e = d;
    }

    public double getDestLon() {
        return this.f28292f;
    }

    public void setDestLon(double d) {
        this.f28292f = d;
    }

    public double getGetOnLat() {
        return this.f28293g;
    }

    public void setGetOnLat(double d) {
        this.f28293g = d;
    }

    public double getGetOnLon() {
        return this.f28294h;
    }

    public void setGetOnLon(double d) {
        this.f28294h = d;
    }

    public int getBizType() {
        return this.f28295i;
    }

    public void setBizType(int i) {
        this.f28295i = i;
    }

    public String getTicket() {
        return this.f28296j;
    }

    public void setTicket(String str) {
        this.f28296j = str;
    }

    public String getDriverId() {
        return this.f28297k;
    }

    public void setDriverId(String str) {
        this.f28297k = str;
    }

    public String getTravelId() {
        return this.f28298l;
    }

    public void setTravelId(String str) {
        this.f28298l = str;
    }

    public String getLastOrderId() {
        return this.f28299m;
    }

    public void setLastOrderId(String str) {
        this.f28299m = str;
    }

    public String getCountryId() {
        return this.f28300n;
    }

    public void setCountryId(String str) {
        this.f28300n = str;
    }

    public String getClientVersion() {
        return this.f28301o;
    }

    public void setClientVersion(String str) {
        this.f28301o = str;
    }

    public String getPhoneNumber() {
        return this.f28302p;
    }

    public void setPhoneNumber(String str) {
        this.f28302p = str;
    }

    public String getRouteId() {
        return this.f28303q;
    }

    public void setRouteId(String str) {
        this.f28303q = str;
    }

    public int getTripStep() {
        return this.f28304r;
    }

    public void setTripStep(int i) {
        this.f28304r = i;
    }

    public int getMapType() {
        return this.f28305s;
    }

    public void setMapType(int i) {
        this.f28305s = i;
    }

    public int getTerminal() {
        return this.f28306t;
    }

    public void setTerminal(int i) {
        this.f28306t = i;
    }
}
