package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzyc extends zzgy implements zzxz {
    public zzyc() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzxq zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvt) zzgx.zza(parcel, zzvt.CREATOR), parcel.readString(), zzanm.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zza);
                return true;
            case 2:
                zzxq zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvt) zzgx.zza(parcel, zzvt.CREATOR), parcel.readString(), zzanm.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zzb);
                return true;
            case 3:
                zzxj zza2 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzanm.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zza2);
                return true;
            case 4:
                zzyh zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zzc);
                return true;
            case 5:
                zzaew zza3 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zza3);
                return true;
            case 6:
                zzavg zza4 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanm.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zza4);
                return true;
            case 7:
                zzass zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zzd);
                return true;
            case 8:
                zzash zzb2 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zzb2);
                return true;
            case 9:
                zzyh zza5 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zza5);
                return true;
            case 10:
                zzxq zza6 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvt) zzgx.zza(parcel, zzvt.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zza6);
                return true;
            case 11:
                zzafd zza7 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zza7);
                return true;
            case 12:
                zzawf zzb3 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzanm.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zzb3);
                return true;
            case 13:
                zzxq zzc2 = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvt) zzgx.zza(parcel, zzvt.CREATOR), parcel.readString(), zzanm.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zzc2);
                return true;
            case 14:
                zzazc zzb4 = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanm.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zzb4);
                return true;
            case 15:
                zzaru zzc3 = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanm.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, (IInterface) zzc3);
                return true;
            default:
                return false;
        }
    }
}
