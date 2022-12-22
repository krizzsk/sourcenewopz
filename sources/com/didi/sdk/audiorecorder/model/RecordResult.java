package com.didi.sdk.audiorecorder.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.didi.sdk.audiorecorder.utils.MediaUtil;
import java.io.File;

public class RecordResult implements Parcelable {
    public static final Parcelable.Creator<RecordResult> CREATOR = new Parcelable.Creator<RecordResult>() {
        public RecordResult createFromParcel(Parcel parcel) {
            return new RecordResult(parcel);
        }

        public RecordResult[] newArray(int i) {
            return new RecordResult[i];
        }
    };
    public static final String TABLE_NAME = "record_result";

    /* renamed from: a */
    private static final String f35422a = "null";

    /* renamed from: b */
    private static final String f35423b = "";

    /* renamed from: c */
    private static final String f35424c = "{}";

    /* renamed from: d */
    private static final int f35425d = 1000;

    /* renamed from: e */
    private String f35426e;

    /* renamed from: f */
    private String f35427f;

    /* renamed from: g */
    private String f35428g;

    /* renamed from: h */
    private String f35429h;

    /* renamed from: i */
    private long f35430i;

    /* renamed from: j */
    private long f35431j;

    /* renamed from: k */
    private long f35432k;

    /* renamed from: l */
    private long f35433l;

    /* renamed from: m */
    private String f35434m;

    /* renamed from: n */
    private int f35435n;

    /* renamed from: o */
    private int f35436o;

    /* renamed from: p */
    private String f35437p;

    /* renamed from: q */
    private String f35438q;

    /* renamed from: r */
    private int f35439r;

    /* renamed from: s */
    private String f35440s;

    /* renamed from: t */
    private String f35441t;

    /* renamed from: u */
    private String f35442u;

    /* renamed from: v */
    private String f35443v;

    public int describeContents() {
        return 0;
    }

    public String getAudioFilePath() {
        return this.f35429h;
    }

    public void setAudioFilePath(String str) {
        this.f35429h = str;
    }

    public long getStartRecordTime() {
        return this.f35432k;
    }

    public void setStartRecordTime(long j) {
        this.f35432k = j;
    }

    public long getFinishRecordTime() {
        return this.f35433l;
    }

    public void setFinishRecordTime(long j) {
        this.f35433l = j;
    }

    public String getOrderIds() {
        return this.f35434m;
    }

    public void setOrderIds(String str) {
        this.f35434m = str;
    }

    public int getClientType() {
        return this.f35435n;
    }

    public void setClientType(int i) {
        this.f35435n = i;
    }

    public int getUtcOffsetInMinutes() {
        return this.f35436o;
    }

    public void setUtcOffsetInMinutes(int i) {
        this.f35436o = i;
    }

    public String getToken() {
        return this.f35437p;
    }

    public void setToken(String str) {
        this.f35437p = str;
    }

    public String getLanguage() {
        return this.f35438q;
    }

    public void setLanguage(String str) {
        this.f35438q = str;
    }

    public long getFileSizeInBytes() {
        return this.f35430i;
    }

    public void setFileSizeInBytes(long j) {
        this.f35430i = j;
    }

    public long getVoiceLenInSeconds() {
        return this.f35431j;
    }

    public void setVoiceLenInSeconds(long j) {
        this.f35431j = j;
    }

    public int getUploadRetryCount() {
        return this.f35439r;
    }

    public void setUploadRetryCount(int i) {
        this.f35439r = i;
    }

    public String getCaller() {
        return this.f35426e;
    }

    public void setCaller(String str) {
        this.f35426e = str;
    }

    public String getBusinessId() {
        return this.f35427f;
    }

    public void setBusinessId(String str) {
        this.f35427f = str;
    }

    public String getExtraJson() {
        return this.f35440s;
    }

    public void setExtraJson(String str) {
        this.f35440s = str;
    }

    public String getUploadUrl() {
        return this.f35441t;
    }

    public void setUploadUrl(String str) {
        this.f35441t = str;
    }

    public String getSignKey() {
        return this.f35442u;
    }

    public void setSignKey(String str) {
        this.f35442u = str;
    }

    public String getUserId() {
        return this.f35443v;
    }

    public void setUserId(String str) {
        this.f35443v = str;
    }

    public String getBusinessAlias() {
        return this.f35428g;
    }

    public void setBusinessAlias(String str) {
        this.f35428g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && hashCode() == obj.hashCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f35432k;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "RecordResult{, caller='" + this.f35426e + '\'' + ", audioFilePath='" + this.f35429h + '\'' + ", fileSizeInBytes=" + this.f35430i + ", voiceLenInSeconds=" + this.f35431j + ", startRecordTime=" + this.f35432k + ", finishRecordTime=" + this.f35433l + ", orderIds='" + this.f35434m + '\'' + ", clientType=" + this.f35435n + ", utcOffsetInMinutes=" + this.f35436o + ", token='" + this.f35437p + '\'' + ", language='" + this.f35438q + '\'' + ", uploadRetryCount=" + this.f35439r + ", businessId=" + this.f35427f + ", businessAlias=" + this.f35428g + ", extraJson=" + this.f35440s + ", uploadUrl=" + this.f35441t + ", signKey=" + this.f35442u + ", userId=" + this.f35443v + '}';
    }

    public void resolveIfNeed() {
        long mediaDuration = MediaUtil.getMediaDuration(this.f35429h);
        if (mediaDuration <= 0) {
            long j = this.f35433l;
            long j2 = this.f35432k;
            mediaDuration = j >= j2 ? j - j2 : 0;
        }
        long round = Math.round((((double) mediaDuration) * 1.0d) / 1000.0d);
        this.f35431j = round;
        if (this.f35433l <= 0 && round > 0) {
            this.f35433l = this.f35432k + (round * 1000);
        }
        if (this.f35430i == 0) {
            this.f35430i = new File(this.f35429h).length();
        }
        m25088a();
    }

    /* renamed from: a */
    private void m25088a() {
        if (TextUtils.isEmpty(this.f35426e) || "null".equals(this.f35426e)) {
            this.f35426e = "";
        }
        if (TextUtils.isEmpty(this.f35427f) || "null".equals(this.f35427f)) {
            this.f35427f = "";
        }
        if (TextUtils.isEmpty(this.f35440s) || "null".equals(this.f35440s)) {
            this.f35440s = f35424c;
        }
    }

    public boolean isTooShort() {
        return this.f35433l - this.f35432k <= 1000 || this.f35431j <= 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f35426e);
        parcel.writeString(this.f35427f);
        parcel.writeString(this.f35428g);
        parcel.writeString(this.f35429h);
        parcel.writeLong(this.f35430i);
        parcel.writeLong(this.f35431j);
        parcel.writeLong(this.f35432k);
        parcel.writeLong(this.f35433l);
        parcel.writeString(this.f35434m);
        parcel.writeInt(this.f35435n);
        parcel.writeInt(this.f35436o);
        parcel.writeString(this.f35437p);
        parcel.writeString(this.f35438q);
        parcel.writeInt(this.f35439r);
        parcel.writeString(this.f35440s);
        parcel.writeString(this.f35441t);
        parcel.writeString(this.f35442u);
        parcel.writeString(this.f35443v);
    }

    public void readFromParcel(Parcel parcel) {
        this.f35426e = parcel.readString();
        this.f35427f = parcel.readString();
        this.f35428g = parcel.readString();
        this.f35429h = parcel.readString();
        this.f35430i = parcel.readLong();
        this.f35431j = parcel.readLong();
        this.f35432k = parcel.readLong();
        this.f35433l = parcel.readLong();
        this.f35434m = parcel.readString();
        this.f35435n = parcel.readInt();
        this.f35436o = parcel.readInt();
        this.f35437p = parcel.readString();
        this.f35438q = parcel.readString();
        this.f35439r = parcel.readInt();
        this.f35440s = parcel.readString();
        this.f35441t = parcel.readString();
        this.f35442u = parcel.readString();
        this.f35443v = parcel.readString();
    }

    public RecordResult() {
    }

    protected RecordResult(Parcel parcel) {
        this.f35426e = parcel.readString();
        this.f35427f = parcel.readString();
        this.f35428g = parcel.readString();
        this.f35429h = parcel.readString();
        this.f35430i = parcel.readLong();
        this.f35431j = parcel.readLong();
        this.f35432k = parcel.readLong();
        this.f35433l = parcel.readLong();
        this.f35434m = parcel.readString();
        this.f35435n = parcel.readInt();
        this.f35436o = parcel.readInt();
        this.f35437p = parcel.readString();
        this.f35438q = parcel.readString();
        this.f35439r = parcel.readInt();
        this.f35440s = parcel.readString();
        this.f35441t = parcel.readString();
        this.f35442u = parcel.readString();
        this.f35443v = parcel.readString();
    }
}
