package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C18512u;
import com.google.android.play.core.tasks.C18619i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ak */
class C18301ak<T> extends C18512u {

    /* renamed from: a */
    final C18619i<T> f52743a;

    /* renamed from: b */
    final /* synthetic */ C18308ar f52744b;

    C18301ak(C18308ar arVar, C18619i<T> iVar) {
        this.f52744b = arVar;
        this.f52743a = iVar;
    }

    C18301ak(C18308ar arVar, C18619i iVar, byte[] bArr) {
        this(arVar, iVar);
    }

    C18301ak(C18308ar arVar, C18619i iVar, char[] cArr) {
        this(arVar, iVar);
    }

    C18301ak(C18308ar arVar, C18619i iVar, int[] iArr) {
        this(arVar, iVar);
    }

    C18301ak(C18308ar arVar, C18619i iVar, short[] sArr) {
        this(arVar, iVar);
    }

    /* renamed from: a */
    public void mo148875a() {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onCancelDownloads()", new Object[0]);
    }

    /* renamed from: a */
    public final void mo148876a(int i) {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onCancelDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo148877a(int i, Bundle bundle) {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onStartDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo148878a(Bundle bundle) {
        this.f52744b.f52759e.mo149092a();
        int i = bundle.getInt("error_code");
        C18308ar.f52755a.mo149083b("onError(%d)", Integer.valueOf(i));
        this.f52743a.mo149341b((Exception) new AssetPackException(i));
    }

    /* renamed from: a */
    public void mo148879a(Bundle bundle, Bundle bundle2) {
        this.f52744b.f52760f.mo149092a();
        C18308ar.f52755a.mo149084c("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    /* renamed from: a */
    public void mo148880a(List<Bundle> list) {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onGetSessionStates", new Object[0]);
    }

    /* renamed from: b */
    public void mo148881b() {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onRemoveModule()", new Object[0]);
    }

    /* renamed from: b */
    public final void mo148882b(int i) {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: b */
    public void mo148883b(Bundle bundle) {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: b */
    public void mo148884b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onGetChunkFileDescriptor", new Object[0]);
    }

    /* renamed from: c */
    public void mo148885c(Bundle bundle) {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: c */
    public void mo148886c(Bundle bundle, Bundle bundle2) {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onRequestDownloadInfo()", new Object[0]);
    }

    /* renamed from: d */
    public void mo148887d(Bundle bundle) {
        this.f52744b.f52759e.mo149092a();
        C18308ar.f52755a.mo149084c("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }
}
