package com.didi.beatles.p099im.p100db.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.didi.beatles.im.db.entity.IMMessageDaoEntity */
public class IMMessageDaoEntity implements Parcelable {
    public static final Parcelable.Creator<IMMessageDaoEntity> CREATOR = new Parcelable.Creator<IMMessageDaoEntity>() {
        public IMMessageDaoEntity[] newArray(int i) {
            return new IMMessageDaoEntity[i];
        }

        public IMMessageDaoEntity createFromParcel(Parcel parcel) {
            return new IMMessageDaoEntity(parcel);
        }
    };

    /* renamed from: A */
    private String f9176A;

    /* renamed from: a */
    private Long f9177a;

    /* renamed from: b */
    private long f9178b;

    /* renamed from: c */
    private long f9179c;

    /* renamed from: d */
    private long f9180d;

    /* renamed from: e */
    private int f9181e;

    /* renamed from: f */
    private int f9182f;

    /* renamed from: g */
    private long f9183g;

    /* renamed from: h */
    private long f9184h;

    /* renamed from: i */
    private int f9185i;

    /* renamed from: j */
    private int f9186j;

    /* renamed from: k */
    private int f9187k;

    /* renamed from: l */
    private String f9188l;

    /* renamed from: m */
    private String f9189m;

    /* renamed from: n */
    private String f9190n;

    /* renamed from: o */
    private String f9191o;

    /* renamed from: p */
    private String f9192p;

    /* renamed from: q */
    private String f9193q;

    /* renamed from: r */
    private int f9194r;

    /* renamed from: s */
    private int f9195s;

    /* renamed from: t */
    private int f9196t;

    /* renamed from: u */
    private int f9197u;

    /* renamed from: v */
    private int f9198v;

    /* renamed from: w */
    private Boolean f9199w;

    /* renamed from: x */
    private int f9200x;

    /* renamed from: y */
    private int f9201y;

    /* renamed from: z */
    private String f9202z;

    public int describeContents() {
        return 0;
    }

    public IMMessageDaoEntity() {
    }

    public IMMessageDaoEntity(Long l) {
        this.f9177a = l;
    }

    public IMMessageDaoEntity(Long l, long j, long j2, long j3, int i, int i2, long j4, long j5, int i3, int i4, int i5, String str, String str2, String str3, String str4, String str5, String str6, int i6, int i7, int i8, int i9, int i10, Boolean bool, int i11, int i12, String str7, String str8) {
        this.f9177a = l;
        this.f9178b = j;
        this.f9179c = j2;
        this.f9180d = j3;
        this.f9181e = i;
        this.f9182f = i2;
        this.f9183g = j4;
        this.f9184h = j5;
        this.f9185i = i3;
        this.f9186j = i4;
        this.f9187k = i5;
        this.f9188l = str;
        this.f9189m = str2;
        this.f9190n = str3;
        this.f9191o = str4;
        this.f9192p = str5;
        this.f9193q = str6;
        this.f9194r = i6;
        this.f9195s = i7;
        this.f9196t = i8;
        this.f9197u = i9;
        this.f9198v = i10;
        this.f9199w = bool;
        this.f9200x = i11;
        this.f9201y = i12;
        this.f9202z = str7;
        this.f9176A = str8;
    }

    public Long getId() {
        return this.f9177a;
    }

    public void setId(Long l) {
        this.f9177a = l;
    }

    public long getMessage_id() {
        return this.f9178b;
    }

    public void setMessage_id(long j) {
        this.f9178b = j;
    }

    public long getUnique_id() {
        return this.f9179c;
    }

    public void setUnique_id(long j) {
        this.f9179c = j;
    }

    public String getUnique_cloud_msg_id() {
        return this.f9176A;
    }

    public void setUnique_cloud_msg_id(String str) {
        this.f9176A = str;
    }

    public long getSession_id() {
        return this.f9180d;
    }

    public void setSession_id(long j) {
        this.f9180d = j;
    }

    public int getType() {
        return this.f9181e;
    }

    public void setType(int i) {
        this.f9181e = i;
    }

    public int getCategory() {
        return this.f9182f;
    }

    public void setCategory(int i) {
        this.f9182f = i;
    }

    public long getSend_uid() {
        return this.f9183g;
    }

    public void setSend_uid(long j) {
        this.f9183g = j;
    }

    public long getCreate_time() {
        return this.f9184h;
    }

    public void setCreate_time(long j) {
        this.f9184h = j;
    }

    public int getBusiness_id() {
        return this.f9185i;
    }

    public void setBusiness_id(int i) {
        this.f9185i = i;
    }

    public int getPriority() {
        return this.f9186j;
    }

    public void setPriority(int i) {
        this.f9186j = i;
    }

    public int getStatus() {
        return this.f9187k;
    }

    public void setStatus(int i) {
        this.f9187k = i;
    }

    public String getText_content() {
        return this.f9188l;
    }

    public void setText_content(String str) {
        this.f9188l = str;
    }

    public String getFile_uri() {
        return this.f9189m;
    }

    public void setFile_uri(String str) {
        this.f9189m = str;
    }

    public String getGift_ns() {
        return this.f9190n;
    }

    public void setGift_ns(String str) {
        this.f9190n = str;
    }

    public String getGift_ftoken() {
        return this.f9191o;
    }

    public void setGift_ftoken(String str) {
        this.f9191o = str;
    }

    public String getGift_fid() {
        return this.f9192p;
    }

    public void setGift_fid(String str) {
        this.f9192p = str;
    }

    public String getFile_name() {
        return this.f9193q;
    }

    public void setFile_name(String str) {
        this.f9193q = str;
    }

    public int getHeight() {
        return this.f9194r;
    }

    public void setHeight(int i) {
        this.f9194r = i;
    }

    public int getWidth() {
        return this.f9195s;
    }

    public void setWidth(int i) {
        this.f9195s = i;
    }

    public int getSec() {
        return this.f9196t;
    }

    public void setSec(int i) {
        this.f9196t = i;
    }

    public int getSize() {
        return this.f9197u;
    }

    public void setSize(int i) {
        this.f9197u = i;
    }

    public int getSys_type() {
        return this.f9198v;
    }

    public void setSys_type(int i) {
        this.f9198v = i;
    }

    public Boolean getIsRead() {
        return this.f9199w;
    }

    public void setIsRead(Boolean bool) {
        this.f9199w = bool;
    }

    public int getReserveInt1() {
        return this.f9200x;
    }

    public void setReserveInt1(int i) {
        this.f9200x = i;
    }

    public int getReserveInt2() {
        return this.f9201y;
    }

    public void setReserveInt2(int i) {
        this.f9201y = i;
    }

    public String getReserveStr3() {
        return this.f9202z;
    }

    public void setReserveStr3(String str) {
        this.f9202z = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f9177a.longValue());
        parcel.writeLong(this.f9178b);
        parcel.writeLong(this.f9179c);
        parcel.writeLong(this.f9180d);
        parcel.writeInt(this.f9181e);
        parcel.writeInt(this.f9182f);
        parcel.writeLong(this.f9183g);
        parcel.writeLong(this.f9184h);
        parcel.writeInt(this.f9185i);
        parcel.writeInt(this.f9186j);
        parcel.writeInt(this.f9187k);
        parcel.writeString(this.f9188l);
        parcel.writeString(this.f9189m);
        parcel.writeString(getGift_ns());
        parcel.writeString(this.f9191o);
        parcel.writeString(this.f9192p);
        parcel.writeString(this.f9193q);
        parcel.writeInt(this.f9194r);
        parcel.writeInt(this.f9195s);
        parcel.writeInt(this.f9196t);
        parcel.writeInt(this.f9197u);
        parcel.writeInt(this.f9198v);
        parcel.writeByte(this.f9199w.booleanValue() ? (byte) 1 : 0);
        parcel.writeInt(this.f9200x);
        parcel.writeInt(this.f9201y);
        parcel.writeString(this.f9202z);
        parcel.writeString(this.f9176A);
    }

    public IMMessageDaoEntity(Parcel parcel) {
        this.f9177a = Long.valueOf(parcel.readLong());
        this.f9178b = parcel.readLong();
        this.f9179c = parcel.readLong();
        this.f9180d = parcel.readLong();
        this.f9181e = parcel.readInt();
        this.f9182f = parcel.readInt();
        this.f9183g = parcel.readLong();
        this.f9184h = parcel.readLong();
        this.f9185i = parcel.readInt();
        this.f9186j = parcel.readInt();
        this.f9187k = parcel.readInt();
        this.f9188l = parcel.readString();
        this.f9189m = parcel.readString();
        this.f9190n = parcel.readString();
        this.f9191o = parcel.readString();
        this.f9192p = parcel.readString();
        this.f9193q = parcel.readString();
        this.f9194r = parcel.readInt();
        this.f9195s = parcel.readInt();
        this.f9196t = parcel.readInt();
        this.f9197u = parcel.readInt();
        this.f9198v = parcel.readInt();
        this.f9199w = Boolean.valueOf(parcel.readByte() != 0);
        this.f9200x = parcel.readInt();
        this.f9201y = parcel.readInt();
        this.f9202z = parcel.readString();
        this.f9176A = parcel.readString();
    }
}
