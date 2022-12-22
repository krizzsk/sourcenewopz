package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bw */
public abstract class C18475bw extends C18502k implements C18476bx {
    public C18475bw() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo149076a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo149128c(parcel.readInt(), (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo149121a(readInt);
                return true;
            case 4:
                mo149122a(parcel.readInt(), (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                mo149126b(parcel.readInt(), (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                mo149131e((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo149124a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                mo149130d((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                mo149123a((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle2 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo149125b();
                return true;
            case 11:
                Bundle bundle3 = (Bundle) C18503l.m37945a(parcel, Bundle.CREATOR);
                mo149120a();
                return true;
            case 12:
                mo149127b((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo149129c((Bundle) C18503l.m37945a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
