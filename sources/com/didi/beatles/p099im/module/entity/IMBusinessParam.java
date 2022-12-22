package com.didi.beatles.p099im.module.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.didi.beatles.im.module.entity.IMBusinessParam */
public class IMBusinessParam implements Parcelable {
    public static final Parcelable.Creator<IMBusinessParam> CREATOR = new Parcelable.Creator<IMBusinessParam>() {
        public IMBusinessParam createFromParcel(Parcel parcel) {
            return new IMBusinessParam(parcel);
        }

        public IMBusinessParam[] newArray(int i) {
            return new IMBusinessParam[i];
        }
    };

    /* renamed from: a */
    private static final String f9267a = IMBusinessParam.class.getSimpleName();

    /* renamed from: A */
    private String f9268A;

    /* renamed from: B */
    private String f9269B;

    /* renamed from: b */
    private long f9270b;

    /* renamed from: c */
    private int f9271c;

    /* renamed from: d */
    private long f9272d;

    /* renamed from: e */
    private long f9273e;

    /* renamed from: f */
    private String f9274f;

    /* renamed from: g */
    private String f9275g;

    /* renamed from: h */
    private String f9276h;

    /* renamed from: i */
    private String f9277i;

    /* renamed from: j */
    private String f9278j;

    /* renamed from: k */
    private long f9279k;

    /* renamed from: l */
    private long f9280l;

    /* renamed from: m */
    private int f9281m;

    /* renamed from: n */
    private String f9282n;

    /* renamed from: o */
    private String f9283o;

    /* renamed from: p */
    private String f9284p;

    /* renamed from: q */
    private int f9285q;

    /* renamed from: r */
    private String f9286r;

    /* renamed from: s */
    private int f9287s;

    /* renamed from: t */
    private String f9288t;

    /* renamed from: u */
    private String f9289u;

    /* renamed from: v */
    private int f9290v;

    /* renamed from: w */
    private String f9291w;

    /* renamed from: x */
    private Map<String, String> f9292x;
    @Deprecated

    /* renamed from: y */
    private String f9293y;

    /* renamed from: z */
    private Boolean f9294z;

    public int describeContents() {
        return 0;
    }

    public IMBusinessParam(long j, int i, long j2, long j3, String str, String str2, String str3, String str4, String str5) {
        this.f9274f = "";
        this.f9281m = -1;
        this.f9288t = "";
        this.f9289u = "";
        this.f9294z = false;
        this.f9270b = j;
        this.f9271c = i;
        this.f9272d = j2;
        this.f9273e = j3;
        this.f9274f = str;
        this.f9275g = str2;
        this.f9276h = str3;
        this.f9277i = str4;
        this.f9278j = str5;
    }

    public IMBusinessParam() {
        this.f9274f = "";
        this.f9281m = -1;
        this.f9288t = "";
        this.f9289u = "";
        this.f9294z = false;
    }

    public int getBottomInputConfig() {
        return this.f9287s;
    }

    public void setBottomInputConfig(int i) {
        this.f9287s = i;
    }

    public int getSessionType() {
        return this.f9290v;
    }

    public void setSessionType(int i) {
        this.f9290v = i;
    }

    public String getUserDraft() {
        return this.f9282n;
    }

    public void setUserDraft(String str) {
        this.f9282n = str;
    }

    public long getSessionId() {
        return this.f9270b;
    }

    public void setSessionId(long j) {
        this.f9270b = j;
    }

    public int getProductId() {
        return this.f9271c;
    }

    public int getBusinessId() {
        return this.f9271c;
    }

    public void setBusinessId(int i) {
        this.f9271c = i;
    }

    public long getSelfUid() {
        return this.f9272d;
    }

    public void setSelfUid(long j) {
        this.f9272d = j;
    }

    public long getPeerUid() {
        return this.f9273e;
    }

    public void setPeerUid(long j) {
        this.f9273e = j;
    }

    public String getSecret() {
        return this.f9274f;
    }

    public void setSecret(String str) {
        this.f9274f = str;
    }

    public void clearSecret() {
        this.f9274f = "";
    }

    public boolean isSecretValid() {
        return !TextUtils.isEmpty(this.f9274f);
    }

    public String getPeerUserName() {
        return this.f9277i;
    }

    public void setPeerUserName(String str) {
        this.f9277i = str;
    }

    public String getPeerUserAvatar() {
        return this.f9278j;
    }

    public void setPeerUserAvatar(String str) {
        this.f9278j = str;
    }

    public String getSelfUserName() {
        return this.f9275g;
    }

    public void setSelfUserName(String str) {
        this.f9275g = str;
    }

    public String getSelfUserAvatar() {
        return this.f9276h;
    }

    public void setSelfUserAvatar(String str) {
        this.f9276h = str;
    }

    public long getOrderId() {
        return this.f9279k;
    }

    public void setOrderId(long j) {
        this.f9279k = j;
    }

    public long getRouteId() {
        return this.f9280l;
    }

    public void setRouteId(long j) {
        this.f9280l = j;
    }

    public int getSourceId() {
        return this.f9281m;
    }

    public void setSourceId(int i) {
        this.f9281m = i;
    }

    public int getIsQuick() {
        return this.f9285q;
    }

    public void setIsQuick(int i) {
        this.f9285q = i;
    }

    public String getCityID() {
        return this.f9284p;
    }

    public void setCityID(String str) {
        this.f9284p = str;
    }

    public String getsOrderId() {
        return this.f9283o;
    }

    public void setsOrderId(String str) {
        this.f9283o = str;
    }

    public String getPeerEngNickName() {
        return this.f9289u;
    }

    public void setPeerEngNickName(String str) {
        this.f9289u = str;
    }

    public String getSelfEngNickName() {
        return this.f9288t;
    }

    public void setSelfEngNickName(String str) {
        this.f9288t = str;
    }

    public String getSceneKey() {
        return this.f9286r;
    }

    public void setSceneKey(String str) {
        this.f9286r = str;
    }

    public String getExtraInfo() {
        return this.f9291w;
    }

    public void setExtraInfo(String str) {
        this.f9291w = str;
    }

    public Map<String, String> getExtraTraceMap() {
        return this.f9292x;
    }

    public void setPhoneNum(String str) {
        this.f9293y = str;
    }

    public String getPhoneNum() {
        return this.f9293y;
    }

    public boolean getShowChatTitleRightIcon() {
        return this.f9294z.booleanValue();
    }

    public void setShowChatTitleRightIcon(boolean z) {
        this.f9294z = Boolean.valueOf(z);
    }

    public void setPhoneFuncGuide(String str) {
        this.f9268A = str;
    }

    public String getPhoneFuncGuide() {
        return this.f9268A;
    }

    public String getRobotGuideId() {
        return this.f9269B;
    }

    public void setRobotGuideId(String str) {
        this.f9269B = str;
    }

    public void setExtraTraceMap(Map<String, String> map) {
        this.f9292x = map;
    }

    public String toString() {
        return "IMBusinessParam{sessionId=" + this.f9270b + ", businessId=" + this.f9271c + ", selfUid=" + this.f9272d + ", peerUid=" + this.f9273e + ", secret='" + this.f9274f + '\'' + ", selfUserName='" + this.f9275g + '\'' + ", selfUserAvatar='" + this.f9276h + '\'' + ", peerUserName='" + this.f9277i + '\'' + ", peerUserAvatar='" + this.f9278j + '\'' + ", orderId=" + this.f9279k + ", routeId=" + this.f9280l + ", sourceId=" + this.f9281m + ", userDraft='" + this.f9282n + '\'' + ", sOrderId='" + this.f9283o + '\'' + ", cityID='" + this.f9284p + '\'' + ", isQuick=" + this.f9285q + '\'' + ", session_type=" + this.f9290v + '\'' + ", self_nick_eng_name =" + this.f9288t + '\'' + ", extraInfo =" + this.f9291w + '\'' + ", showChatTitleRightIcon" + this.f9294z + '\'' + ", peer_nick_eng_name =" + this.f9289u + ", robotGuideId =" + this.f9269B + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f9270b);
        parcel.writeInt(this.f9271c);
        parcel.writeLong(this.f9272d);
        parcel.writeLong(this.f9273e);
        parcel.writeString(this.f9274f);
        parcel.writeString(this.f9275g);
        parcel.writeString(this.f9276h);
        parcel.writeString(this.f9277i);
        parcel.writeString(this.f9278j);
        parcel.writeLong(this.f9279k);
        parcel.writeLong(this.f9280l);
        parcel.writeInt(this.f9281m);
        parcel.writeString(this.f9282n);
        parcel.writeString(this.f9283o);
        parcel.writeString(this.f9284p);
        parcel.writeInt(this.f9285q);
        parcel.writeInt(this.f9290v);
        parcel.writeInt(this.f9287s);
        parcel.writeString(this.f9288t);
        parcel.writeString(this.f9289u);
        parcel.writeString(this.f9286r);
        parcel.writeString(this.f9291w);
        parcel.writeString(this.f9293y);
        parcel.writeByte(this.f9294z.booleanValue() ? (byte) 1 : 0);
        parcel.writeString(this.f9268A);
    }

    protected IMBusinessParam(Parcel parcel) {
        this.f9274f = "";
        this.f9281m = -1;
        this.f9288t = "";
        this.f9289u = "";
        boolean z = false;
        this.f9294z = false;
        this.f9270b = parcel.readLong();
        this.f9271c = parcel.readInt();
        this.f9272d = parcel.readLong();
        this.f9273e = parcel.readLong();
        this.f9274f = parcel.readString();
        this.f9275g = parcel.readString();
        this.f9276h = parcel.readString();
        this.f9277i = parcel.readString();
        this.f9278j = parcel.readString();
        this.f9279k = parcel.readLong();
        this.f9280l = parcel.readLong();
        this.f9281m = parcel.readInt();
        this.f9282n = parcel.readString();
        this.f9283o = parcel.readString();
        this.f9284p = parcel.readString();
        this.f9285q = parcel.readInt();
        this.f9290v = parcel.readInt();
        this.f9287s = parcel.readInt();
        this.f9288t = parcel.readString();
        this.f9289u = parcel.readString();
        this.f9286r = parcel.readString();
        this.f9291w = parcel.readString();
        this.f9293y = parcel.readString();
        this.f9294z = Boolean.valueOf(parcel.readByte() != 0 ? true : z);
        this.f9268A = parcel.readString();
    }
}
