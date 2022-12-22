package com.didiglobal.scan.view.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.scan.GlobalScan;
import com.didiglobal.scan.data.ManualInputInfo;
import com.didiglobal.scan.delegate.IViewStyleDelegate;
import com.didiglobal.scan.delegate.QRCodeProcessDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u0004\u0018\u00010\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H&J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0016J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020'2\b\u0010.\u001a\u0004\u0018\u00010\u0010J\u000e\u0010/\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u00100\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u00010\nJ\u000e\u00102\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00063"}, mo175978d2 = {"Lcom/didiglobal/scan/view/fragment/BaseQrScanFragment;", "Landroidx/fragment/app/Fragment;", "()V", "from", "Lcom/didiglobal/scan/GlobalScan$ScanFrom;", "getFrom", "()Lcom/didiglobal/scan/GlobalScan$ScanFrom;", "setFrom", "(Lcom/didiglobal/scan/GlobalScan$ScanFrom;)V", "inputInfo", "Lcom/didiglobal/scan/data/ManualInputInfo;", "getInputInfo", "()Lcom/didiglobal/scan/data/ManualInputInfo;", "setInputInfo", "(Lcom/didiglobal/scan/data/ManualInputInfo;)V", "parentFragment", "Lcom/didiglobal/scan/view/fragment/QrScanFragment;", "getParentFragment", "()Lcom/didiglobal/scan/view/fragment/QrScanFragment;", "setParentFragment", "(Lcom/didiglobal/scan/view/fragment/QrScanFragment;)V", "process", "Lcom/didiglobal/scan/delegate/QRCodeProcessDelegate;", "userType", "", "getUserType", "()I", "setUserType", "(I)V", "viewStyleDelegate", "Lcom/didiglobal/scan/delegate/IViewStyleDelegate;", "getViewStyleDelegate", "()Lcom/didiglobal/scan/delegate/IViewStyleDelegate;", "setViewStyleDelegate", "(Lcom/didiglobal/scan/delegate/IViewStyleDelegate;)V", "getQrCodeProcess", "getTitleBarView", "Landroid/view/View;", "initProcess", "", "initViewStyleDelegate", "onBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setParent", "parent", "updateFrom", "updateInfo", "info", "updateUserType", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseQrScanFragment.kt */
public abstract class BaseQrScanFragment extends Fragment {

    /* renamed from: a */
    private int f51371a = -1;

    /* renamed from: b */
    private GlobalScan.ScanFrom f51372b = GlobalScan.ScanFrom.INDEX;

    /* renamed from: c */
    private ManualInputInfo f51373c;

    /* renamed from: d */
    private IViewStyleDelegate f51374d;

    /* renamed from: e */
    private QrScanFragment f51375e;

    /* renamed from: f */
    private QRCodeProcessDelegate f51376f;

    public abstract View getTitleBarView();

    public void onBack() {
    }

    /* access modifiers changed from: protected */
    public final int getUserType() {
        return this.f51371a;
    }

    /* access modifiers changed from: protected */
    public final void setUserType(int i) {
        this.f51371a = i;
    }

    /* access modifiers changed from: protected */
    public final GlobalScan.ScanFrom getFrom() {
        return this.f51372b;
    }

    /* access modifiers changed from: protected */
    public final void setFrom(GlobalScan.ScanFrom scanFrom) {
        Intrinsics.checkParameterIsNotNull(scanFrom, "<set-?>");
        this.f51372b = scanFrom;
    }

    /* access modifiers changed from: protected */
    public final ManualInputInfo getInputInfo() {
        return this.f51373c;
    }

    /* access modifiers changed from: protected */
    public final void setInputInfo(ManualInputInfo manualInputInfo) {
        this.f51373c = manualInputInfo;
    }

    /* access modifiers changed from: protected */
    public final IViewStyleDelegate getViewStyleDelegate() {
        return this.f51374d;
    }

    /* access modifiers changed from: protected */
    public final void setViewStyleDelegate(IViewStyleDelegate iViewStyleDelegate) {
        this.f51374d = iViewStyleDelegate;
    }

    public final QrScanFragment getParentFragment() {
        return this.f51375e;
    }

    public final void setParentFragment(QrScanFragment qrScanFragment) {
        this.f51375e = qrScanFragment;
    }

    public final void setParent(QrScanFragment qrScanFragment) {
        this.f51375e = qrScanFragment;
    }

    public final void updateUserType(int i) {
        this.f51371a = i;
    }

    public final void updateFrom(GlobalScan.ScanFrom scanFrom) {
        Intrinsics.checkParameterIsNotNull(scanFrom, "from");
        this.f51372b = scanFrom;
    }

    public final void updateInfo(ManualInputInfo manualInputInfo) {
        this.f51373c = manualInputInfo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m36785b();
        m36784a();
    }

    /* renamed from: a */
    private final void m36784a() {
        this.f51374d = (IViewStyleDelegate) ServiceLoader.load(IViewStyleDelegate.class).get();
    }

    /* renamed from: b */
    private final void m36785b() {
        if (this.f51376f == null && getParentFragment() != null && (getParentFragment() instanceof QrScanFragment)) {
            QrScanFragment qrScanFragment = (QrScanFragment) getParentFragment();
            this.f51376f = qrScanFragment != null ? qrScanFragment.getQrCodeProcess() : null;
        }
    }

    public final QRCodeProcessDelegate getQrCodeProcess() {
        return this.f51376f;
    }
}
