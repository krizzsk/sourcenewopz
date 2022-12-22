package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzht implements Parcelable {
    public static final Parcelable.Creator<zzht> CREATOR = new zzhs();
    public final int height;

    /* renamed from: id */
    private final String f52601id;
    public final int width;
    public final int zzahk;
    public final String zzahl;
    private final zzmh zzahm;
    public final String zzahn;
    public final String zzaho;
    public final int zzahp;
    public final List<byte[]> zzahq;
    public final zzjo zzahr;
    public final float zzahs;
    public final int zzaht;
    public final float zzahu;
    private final int zzahv;
    private final byte[] zzahw;
    private final zzpy zzahx;
    public final int zzahy;
    public final int zzahz;
    public final int zzaia;
    private final int zzaib;
    private final int zzaic;
    public final long zzaid;
    public final int zzaie;
    public final String zzaif;
    private final int zzaig;
    private int zzaih;

    public static zzht zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zzpy zzpy, zzjo zzjo) {
        return new zzht(str, (String) null, str2, (String) null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zzpy, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, list, zzjo, (zzmh) null);
    }

    public final int describeContents() {
        return 0;
    }

    public static zzht zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzjo zzjo, int i5, String str4) {
        return zza(str, str2, (String) null, -1, -1, i3, i4, -1, (List<byte[]>) null, zzjo, 0, str4);
    }

    public static zzht zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzjo zzjo, int i6, String str4) {
        return new zzht(str, (String) null, str2, (String) null, -1, i2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpy) null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzjo, (zzmh) null);
    }

    public static zzht zza(String str, String str2, String str3, int i, int i2, String str4, zzjo zzjo) {
        return zza(str, str2, (String) null, -1, i2, str4, -1, zzjo, Long.MAX_VALUE, Collections.emptyList());
    }

    public static zzht zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzjo zzjo, long j, List<byte[]> list) {
        return new zzht(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpy) null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzjo, (zzmh) null);
    }

    public static zzht zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzjo zzjo) {
        return new zzht(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpy) null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzjo, (zzmh) null);
    }

    public static zzht zza(String str, String str2, long j) {
        return new zzht((String) null, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpy) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, (zzjo) null, (zzmh) null);
    }

    public static zzht zza(String str, String str2, String str3, int i, zzjo zzjo) {
        return new zzht(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpy) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, zzjo, (zzmh) null);
    }

    private zzht(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zzpy zzpy, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzjo zzjo, zzmh zzmh) {
        this.f52601id = str;
        this.zzahn = str2;
        this.zzaho = str3;
        this.zzahl = str4;
        this.zzahk = i;
        this.zzahp = i2;
        this.width = i3;
        this.height = i4;
        this.zzahs = f;
        this.zzaht = i5;
        this.zzahu = f2;
        this.zzahw = bArr;
        this.zzahv = i6;
        this.zzahx = zzpy;
        this.zzahy = i7;
        this.zzahz = i8;
        this.zzaia = i9;
        this.zzaib = i10;
        this.zzaic = i11;
        this.zzaie = i12;
        this.zzaif = str5;
        this.zzaig = i13;
        this.zzaid = j;
        this.zzahq = list == null ? Collections.emptyList() : list;
        this.zzahr = zzjo;
        this.zzahm = zzmh;
    }

    zzht(Parcel parcel) {
        this.f52601id = parcel.readString();
        this.zzahn = parcel.readString();
        this.zzaho = parcel.readString();
        this.zzahl = parcel.readString();
        this.zzahk = parcel.readInt();
        this.zzahp = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzahs = parcel.readFloat();
        this.zzaht = parcel.readInt();
        this.zzahu = parcel.readFloat();
        this.zzahw = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzahv = parcel.readInt();
        this.zzahx = (zzpy) parcel.readParcelable(zzpy.class.getClassLoader());
        this.zzahy = parcel.readInt();
        this.zzahz = parcel.readInt();
        this.zzaia = parcel.readInt();
        this.zzaib = parcel.readInt();
        this.zzaic = parcel.readInt();
        this.zzaie = parcel.readInt();
        this.zzaif = parcel.readString();
        this.zzaig = parcel.readInt();
        this.zzaid = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzahq = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzahq.add(parcel.createByteArray());
        }
        this.zzahr = (zzjo) parcel.readParcelable(zzjo.class.getClassLoader());
        this.zzahm = (zzmh) parcel.readParcelable(zzmh.class.getClassLoader());
    }

    public final zzht zzy(int i) {
        String str = this.f52601id;
        return new zzht(str, this.zzahn, this.zzaho, this.zzahl, this.zzahk, i, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic, this.zzaie, this.zzaif, this.zzaig, this.zzaid, this.zzahq, this.zzahr, this.zzahm);
    }

    public final zzht zzds(long j) {
        return new zzht(this.f52601id, this.zzahn, this.zzaho, this.zzahl, this.zzahk, this.zzahp, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic, this.zzaie, this.zzaif, this.zzaig, j, this.zzahq, this.zzahr, this.zzahm);
    }

    public final zzht zzd(int i, int i2) {
        String str = this.f52601id;
        return new zzht(str, this.zzahn, this.zzaho, this.zzahl, this.zzahk, this.zzahp, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, i, i2, this.zzaie, this.zzaif, this.zzaig, this.zzaid, this.zzahq, this.zzahr, this.zzahm);
    }

    public final zzht zza(zzjo zzjo) {
        String str = this.f52601id;
        return new zzht(str, this.zzahn, this.zzaho, this.zzahl, this.zzahk, this.zzahp, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic, this.zzaie, this.zzaif, this.zzaig, this.zzaid, this.zzahq, zzjo, this.zzahm);
    }

    public final zzht zza(zzmh zzmh) {
        String str = this.f52601id;
        return new zzht(str, this.zzahn, this.zzaho, this.zzahl, this.zzahk, this.zzahp, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic, this.zzaie, this.zzaif, this.zzaig, this.zzaid, this.zzahq, this.zzahr, zzmh);
    }

    public final int zzfd() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final MediaFormat zzfe() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzaho);
        String str = this.zzaif;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        zza(mediaFormat, "max-input-size", this.zzahp);
        zza(mediaFormat, "width", this.width);
        zza(mediaFormat, "height", this.height);
        float f = this.zzahs;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        zza(mediaFormat, "rotation-degrees", this.zzaht);
        zza(mediaFormat, "channel-count", this.zzahy);
        zza(mediaFormat, "sample-rate", this.zzahz);
        zza(mediaFormat, "encoder-delay", this.zzaib);
        zza(mediaFormat, "encoder-padding", this.zzaic);
        for (int i = 0; i < this.zzahq.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzahq.get(i)));
        }
        zzpy zzpy = this.zzahx;
        if (zzpy != null) {
            zza(mediaFormat, "color-transfer", zzpy.zzasg);
            zza(mediaFormat, "color-standard", zzpy.zzasf);
            zza(mediaFormat, "color-range", zzpy.zzash);
            byte[] bArr = zzpy.zzbld;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        String str = this.f52601id;
        String str2 = this.zzahn;
        String str3 = this.zzaho;
        int i = this.zzahk;
        String str4 = this.zzaif;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzahs;
        int i4 = this.zzahy;
        int i5 = this.zzahz;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.zzaih == 0) {
            String str = this.f52601id;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.zzahn;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzaho;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzahl;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzahk) * 31) + this.width) * 31) + this.height) * 31) + this.zzahy) * 31) + this.zzahz) * 31;
            String str5 = this.zzaif;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.zzaig) * 31;
            zzjo zzjo = this.zzahr;
            int hashCode6 = (hashCode5 + (zzjo == null ? 0 : zzjo.hashCode())) * 31;
            zzmh zzmh = this.zzahm;
            if (zzmh != null) {
                i = zzmh.hashCode();
            }
            this.zzaih = hashCode6 + i;
        }
        return this.zzaih;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzht zzht = (zzht) obj;
            if (this.zzahk == zzht.zzahk && this.zzahp == zzht.zzahp && this.width == zzht.width && this.height == zzht.height && this.zzahs == zzht.zzahs && this.zzaht == zzht.zzaht && this.zzahu == zzht.zzahu && this.zzahv == zzht.zzahv && this.zzahy == zzht.zzahy && this.zzahz == zzht.zzahz && this.zzaia == zzht.zzaia && this.zzaib == zzht.zzaib && this.zzaic == zzht.zzaic && this.zzaid == zzht.zzaid && this.zzaie == zzht.zzaie && zzpt.zza(this.f52601id, zzht.f52601id) && zzpt.zza(this.zzaif, zzht.zzaif) && this.zzaig == zzht.zzaig && zzpt.zza(this.zzahn, zzht.zzahn) && zzpt.zza(this.zzaho, zzht.zzaho) && zzpt.zza(this.zzahl, zzht.zzahl) && zzpt.zza(this.zzahr, zzht.zzahr) && zzpt.zza(this.zzahm, zzht.zzahm) && zzpt.zza(this.zzahx, zzht.zzahx) && Arrays.equals(this.zzahw, zzht.zzahw) && this.zzahq.size() == zzht.zzahq.size()) {
                for (int i = 0; i < this.zzahq.size(); i++) {
                    if (!Arrays.equals(this.zzahq.get(i), zzht.zzahq.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f52601id);
        parcel.writeString(this.zzahn);
        parcel.writeString(this.zzaho);
        parcel.writeString(this.zzahl);
        parcel.writeInt(this.zzahk);
        parcel.writeInt(this.zzahp);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzahs);
        parcel.writeInt(this.zzaht);
        parcel.writeFloat(this.zzahu);
        parcel.writeInt(this.zzahw != null ? 1 : 0);
        byte[] bArr = this.zzahw;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzahv);
        parcel.writeParcelable(this.zzahx, i);
        parcel.writeInt(this.zzahy);
        parcel.writeInt(this.zzahz);
        parcel.writeInt(this.zzaia);
        parcel.writeInt(this.zzaib);
        parcel.writeInt(this.zzaic);
        parcel.writeInt(this.zzaie);
        parcel.writeString(this.zzaif);
        parcel.writeInt(this.zzaig);
        parcel.writeLong(this.zzaid);
        int size = this.zzahq.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzahq.get(i2));
        }
        parcel.writeParcelable(this.zzahr, 0);
        parcel.writeParcelable(this.zzahm, 0);
    }
}
