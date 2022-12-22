package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C18619i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.as */
final class C18567as extends C18569au<List<SplitInstallSessionState>> {
    C18567as(C18570av avVar, C18619i<List<SplitInstallSessionState>> iVar) {
        super(avVar, iVar);
    }

    /* renamed from: a */
    public final void mo149124a(List<Bundle> list) throws RemoteException {
        super.mo149124a(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (Bundle a : list) {
            arrayList.add(SplitInstallSessionState.m38082a(a));
        }
        this.f53299a.mo149342b(arrayList);
    }
}
