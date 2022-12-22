package com.didi.global.qrscan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.global.qrscan.inter.QRCodeProcess;
import com.didi.global.qrscan.inter.QRScanDelegate;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;

public class QRScanFragment extends Fragment implements QRScanDelegate {

    /* renamed from: a */
    QRCodeProcess f22927a;

    /* renamed from: b */
    private String f22928b;

    /* renamed from: c */
    private C8796a f22929c;

    public void finish() {
        try {
            m16496d();
        } catch (IllegalStateException e) {
            Log.d("QRScanFragment", XPanelScene.SCENE_FINISH, e);
        }
    }

    public Fragment getFragment() {
        return this;
    }

    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    public void setProductId(String str) {
        this.f22928b = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.f22928b) && (getContext() instanceof BaseGlobalScanActivity)) {
            this.f22928b = ((BaseGlobalScanActivity) getContext()).getProductId();
        }
        ServiceLoader<S> load = ServiceLoader.load(QRCodeProcess.class, this.f22928b);
        if (load != null) {
            this.f22927a = (QRCodeProcess) load.get();
        }
        QRCodeProcess qRCodeProcess = this.f22927a;
        if (qRCodeProcess != null) {
            qRCodeProcess.onEnter(this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_qr_fragment_new, viewGroup, false);
        mo67450b();
        return inflate;
    }

    /* renamed from: d */
    private void m16496d() {
        getFragmentManager().popBackStack();
        QRCodeProcess qRCodeProcess = this.f22927a;
        if (qRCodeProcess != null) {
            qRCodeProcess.onLeave();
        }
    }

    public void onRestart() {
        C8796a aVar = this.f22929c;
        if (aVar != null) {
            aVar.mo67434a();
        }
    }

    public void stopScan() {
        C8796a aVar = this.f22929c;
        if (aVar != null && (aVar instanceof QRCodeScannerFragment)) {
            aVar.mo67447b();
        }
    }

    public View getTitleBar() {
        C8796a aVar = this.f22929c;
        if (aVar != null) {
            return aVar.getTitleBar();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67449a() {
        getActivity().onBackPressed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67450b() {
        if (!(this.f22929c instanceof QRCodeScannerFragment)) {
            QRCodeProcess qRCodeProcess = this.f22927a;
            if (qRCodeProcess != null) {
                qRCodeProcess.onScanStart();
            }
            QRCodeScannerFragment qRCodeScannerFragment = new QRCodeScannerFragment();
            this.f22929c = qRCodeScannerFragment;
            qRCodeScannerFragment.setProcess(this.f22927a);
            this.f22929c.setParent(this);
            getChildFragmentManager().beginTransaction().replace(R.id.global_scan_container, this.f22929c).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo67451c() {
        if (!(this.f22929c instanceof QRCodeInputFragment)) {
            StatusBarLightingCompat.setStatusBarBgLightning(getActivity(), true, 0);
            QRCodeInputFragment qRCodeInputFragment = new QRCodeInputFragment();
            this.f22929c = qRCodeInputFragment;
            qRCodeInputFragment.setProcess(this.f22927a);
            this.f22929c.setParent(this);
            getChildFragmentManager().beginTransaction().replace(R.id.global_scan_container, this.f22929c).commitAllowingStateLoss();
        }
    }

    public boolean onBackPressed() {
        C8796a aVar = this.f22929c;
        if (aVar == null || !(aVar instanceof QRCodeInputFragment)) {
            return false;
        }
        mo67450b();
        QRCodeProcess qRCodeProcess = this.f22927a;
        if (qRCodeProcess == null) {
            return true;
        }
        qRCodeProcess.onLeaveInputCode();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        QRCodeProcess qRCodeProcess = this.f22927a;
        if (qRCodeProcess != null) {
            qRCodeProcess.onActivityResult(i, i2, intent);
        }
    }

    public void goInputCode() {
        mo67451c();
    }
}
