package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C18619i;

/* renamed from: com.google.android.play.core.assetpacks.al */
final class C18302al extends C18301ak<ParcelFileDescriptor> {
    C18302al(C18308ar arVar, C18619i<ParcelFileDescriptor> iVar) {
        super(arVar, iVar);
    }

    /* renamed from: b */
    public final void mo148884b(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.mo148884b(bundle, bundle2);
        this.f52743a.mo149342b((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
