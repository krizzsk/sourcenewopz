package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.u */
public abstract class C18512u extends C18502k implements C18513v {
    public C18512u() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo149076a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo148877a(parcel.readInt(), (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo148876a(readInt);
                return true;
            case 4:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo148882b(readInt2);
                return true;
            case 5:
                mo148880a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                Bundle bundle3 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo148883b((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo148878a((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                Bundle bundle4 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo148885c((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle5 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo148887d((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 11:
                mo148879a((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR), (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 12:
                mo148884b((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR), (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo148886c((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR), (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 14:
                Bundle bundle6 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                Bundle bundle7 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo148881b();
                return true;
            case 15:
                Bundle bundle8 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo148875a();
                return true;
            default:
                return false;
        }
    }
}
