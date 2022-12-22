package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzahn;
import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzcmb;
import com.google.android.gms.internal.ads.zzcsh;
import com.google.android.gms.internal.ads.zzdtw;
import com.google.android.gms.internal.ads.zzve;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    public final int orientation;
    public final String url;
    public final zzbar zzbpx;
    public final String zzbvf;
    public final String zzbwe;
    public final zzve zzchr;
    public final zzahn zzdic;
    public final zzahp zzdie;
    public final zzcmb zzdje;
    public final zzdtw zzdjf;
    public final zzbfi zzdkm;
    public final zzb zzdue;
    public final zzp zzduf;
    public final String zzdug;
    public final boolean zzduh;
    public final String zzdui;
    public final zzx zzduj;
    public final int zzduk;
    public final String zzdul;
    public final zzk zzdum;
    public final zzcsh zzdun;
    public final zzbg zzduo;
    public final String zzdup;

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzd(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public AdOverlayInfoParcel(zzbfi zzbfi, zzbar zzbar, zzbg zzbg, zzcsh zzcsh, zzcmb zzcmb, zzdtw zzdtw, String str, String str2, int i) {
        this.zzdue = null;
        this.zzchr = null;
        this.zzduf = null;
        this.zzdkm = zzbfi;
        this.zzdic = null;
        this.zzdie = null;
        this.zzdug = null;
        this.zzduh = false;
        this.zzdui = null;
        this.zzduj = null;
        this.orientation = i;
        this.zzduk = 5;
        this.url = null;
        this.zzbpx = zzbar;
        this.zzdul = null;
        this.zzdum = null;
        this.zzbwe = str;
        this.zzdup = str2;
        this.zzdun = zzcsh;
        this.zzdje = zzcmb;
        this.zzdjf = zzdtw;
        this.zzduo = zzbg;
        this.zzbvf = null;
    }

    public AdOverlayInfoParcel(zzve zzve, zzp zzp, zzx zzx, zzbfi zzbfi, int i, zzbar zzbar, String str, zzk zzk, String str2, String str3, String str4) {
        this.zzdue = null;
        this.zzchr = null;
        this.zzduf = zzp;
        this.zzdkm = zzbfi;
        this.zzdic = null;
        this.zzdie = null;
        this.zzdug = str2;
        this.zzduh = false;
        this.zzdui = str3;
        this.zzduj = null;
        this.orientation = i;
        this.zzduk = 1;
        this.url = null;
        this.zzbpx = zzbar;
        this.zzdul = str;
        this.zzdum = zzk;
        this.zzbwe = null;
        this.zzdup = null;
        this.zzdun = null;
        this.zzdje = null;
        this.zzdjf = null;
        this.zzduo = null;
        this.zzbvf = str4;
    }

    public AdOverlayInfoParcel(zzve zzve, zzp zzp, zzx zzx, zzbfi zzbfi, boolean z, int i, zzbar zzbar) {
        this.zzdue = null;
        this.zzchr = zzve;
        this.zzduf = zzp;
        this.zzdkm = zzbfi;
        this.zzdic = null;
        this.zzdie = null;
        this.zzdug = null;
        this.zzduh = z;
        this.zzdui = null;
        this.zzduj = zzx;
        this.orientation = i;
        this.zzduk = 2;
        this.url = null;
        this.zzbpx = zzbar;
        this.zzdul = null;
        this.zzdum = null;
        this.zzbwe = null;
        this.zzdup = null;
        this.zzdun = null;
        this.zzdje = null;
        this.zzdjf = null;
        this.zzduo = null;
        this.zzbvf = null;
    }

    public AdOverlayInfoParcel(zzve zzve, zzp zzp, zzahn zzahn, zzahp zzahp, zzx zzx, zzbfi zzbfi, boolean z, int i, String str, zzbar zzbar) {
        this.zzdue = null;
        this.zzchr = zzve;
        this.zzduf = zzp;
        this.zzdkm = zzbfi;
        this.zzdic = zzahn;
        this.zzdie = zzahp;
        this.zzdug = null;
        this.zzduh = z;
        this.zzdui = null;
        this.zzduj = zzx;
        this.orientation = i;
        this.zzduk = 3;
        this.url = str;
        this.zzbpx = zzbar;
        this.zzdul = null;
        this.zzdum = null;
        this.zzbwe = null;
        this.zzdup = null;
        this.zzdun = null;
        this.zzdje = null;
        this.zzdjf = null;
        this.zzduo = null;
        this.zzbvf = null;
    }

    public AdOverlayInfoParcel(zzve zzve, zzp zzp, zzahn zzahn, zzahp zzahp, zzx zzx, zzbfi zzbfi, boolean z, int i, String str, String str2, zzbar zzbar) {
        this.zzdue = null;
        this.zzchr = zzve;
        this.zzduf = zzp;
        this.zzdkm = zzbfi;
        this.zzdic = zzahn;
        this.zzdie = zzahp;
        this.zzdug = str2;
        this.zzduh = z;
        this.zzdui = str;
        this.zzduj = zzx;
        this.orientation = i;
        this.zzduk = 3;
        this.url = null;
        this.zzbpx = zzbar;
        this.zzdul = null;
        this.zzdum = null;
        this.zzbwe = null;
        this.zzdup = null;
        this.zzdun = null;
        this.zzdje = null;
        this.zzdjf = null;
        this.zzduo = null;
        this.zzbvf = null;
    }

    public AdOverlayInfoParcel(zzb zzb, zzve zzve, zzp zzp, zzx zzx, zzbar zzbar, zzbfi zzbfi) {
        this.zzdue = zzb;
        this.zzchr = zzve;
        this.zzduf = zzp;
        this.zzdkm = zzbfi;
        this.zzdic = null;
        this.zzdie = null;
        this.zzdug = null;
        this.zzduh = false;
        this.zzdui = null;
        this.zzduj = zzx;
        this.orientation = -1;
        this.zzduk = 4;
        this.url = null;
        this.zzbpx = zzbar;
        this.zzdul = null;
        this.zzdum = null;
        this.zzbwe = null;
        this.zzdup = null;
        this.zzdun = null;
        this.zzdje = null;
        this.zzdjf = null;
        this.zzduo = null;
        this.zzbvf = null;
    }

    AdOverlayInfoParcel(zzb zzb, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzbar zzbar, String str4, zzk zzk, IBinder iBinder6, String str5, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, IBinder iBinder10, String str6, String str7) {
        this.zzdue = zzb;
        this.zzchr = (zzve) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzduf = (zzp) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzdkm = (zzbfi) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzdic = (zzahn) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zzdie = (zzahp) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzdug = str;
        this.zzduh = z;
        this.zzdui = str2;
        this.zzduj = (zzx) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzduk = i2;
        this.url = str3;
        this.zzbpx = zzbar;
        this.zzdul = str4;
        this.zzdum = zzk;
        this.zzbwe = str5;
        this.zzdup = str6;
        this.zzdun = (zzcsh) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzdje = (zzcmb) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzdjf = (zzdtw) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
        this.zzduo = (zzbg) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder10));
        this.zzbvf = str7;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdue, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzchr).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzduf).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzdkm).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzdie).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdug, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzduh);
        SafeParcelWriter.writeString(parcel, 9, this.zzdui, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzduj).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzduk);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzbpx, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzdul, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzdum, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzdic).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzbwe, false);
        SafeParcelWriter.writeIBinder(parcel, 20, ObjectWrapper.wrap(this.zzdun).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 21, ObjectWrapper.wrap(this.zzdje).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 22, ObjectWrapper.wrap(this.zzdjf).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 23, ObjectWrapper.wrap(this.zzduo).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 24, this.zzdup, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzbvf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
