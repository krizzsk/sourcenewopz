package com.didi.global.qrscan;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.didi.global.qrscan.inter.QRCodeProcess;

/* renamed from: com.didi.global.qrscan.a */
/* compiled from: BaseQrScanFragment */
abstract class C8796a extends Fragment {

    /* renamed from: a */
    QRCodeProcess f22930a;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo67434a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo67435a(boolean z);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67447b() {
    }

    /* access modifiers changed from: package-private */
    public abstract View getTitleBar();

    /* access modifiers changed from: package-private */
    public abstract void setParent(QRScanFragment qRScanFragment);

    C8796a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f22930a == null && getParentFragment() != null && (getParentFragment() instanceof QRScanFragment)) {
            this.f22930a = ((QRScanFragment) getParentFragment()).f22927a;
        }
    }

    public void setProcess(QRCodeProcess qRCodeProcess) {
        this.f22930a = qRCodeProcess;
    }
}
