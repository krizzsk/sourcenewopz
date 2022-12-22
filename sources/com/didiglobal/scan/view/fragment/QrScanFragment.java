package com.didiglobal.scan.view.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.scan.GlobalScan;
import com.didiglobal.scan.data.ManualInputInfo;
import com.didiglobal.scan.delegate.QRCodeProcessDelegate;
import com.didiglobal.scan.delegate.QRScanDelegate;
import com.didiglobal.scan.view.activity.GlobalScanActivity;
import com.facebook.share.internal.ShareConstants;
import com.taxis99.R;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0006\u0010#\u001a\u00020$J\u0012\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010,\u001a\u00020\u001eH\u0016J\u001a\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010/\u001a\u00020\u001eJ\u0006\u00100\u001a\u00020\u001eJ\u000e\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\tH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo175978d2 = {"Lcom/didiglobal/scan/view/fragment/QrScanFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didiglobal/scan/delegate/QRScanDelegate;", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "currentFragment", "Lcom/didiglobal/scan/view/fragment/BaseQrScanFragment;", "fragment", "getFragment", "()Landroidx/fragment/app/Fragment;", "from", "Lcom/didiglobal/scan/GlobalScan$ScanFrom;", "inputInfo", "Lcom/didiglobal/scan/data/ManualInputInfo;", "loadingLayout", "Landroid/view/ViewGroup;", "qrCodeProcess", "Lcom/didiglobal/scan/delegate/QRCodeProcessDelegate;", "rootView", "Landroid/view/View;", "titleBar", "getTitleBar", "()Landroid/view/View;", "userType", "", "getQrCodeProcess", "hideLoading", "", "initArgument", "initListener", "initQrCodeProcess", "initView", "onBackPress", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroy", "onViewCreated", "view", "showLoading", "showScan", "showScanFromLocal", "uri", "Landroid/net/Uri;", "updateFragment", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: QrScanFragment.kt */
public final class QrScanFragment extends Fragment implements QRScanDelegate {

    /* renamed from: a */
    private BaseQrScanFragment f51395a;

    /* renamed from: b */
    private ViewGroup f51396b;

    /* renamed from: c */
    private View f51397c;

    /* renamed from: d */
    private QRCodeProcessDelegate f51398d;

    /* renamed from: e */
    private GlobalScan.ScanFrom f51399e = GlobalScan.ScanFrom.INDEX;

    /* renamed from: f */
    private int f51400f = -1;

    /* renamed from: g */
    private ManualInputInfo f51401g;

    /* renamed from: a */
    private final void m36798a() {
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                Intrinsics.throwNpe();
            }
            this.f51400f = arguments.getInt(GlobalScanActivity.KEY_USERTYPE, -1);
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                Intrinsics.throwNpe();
            }
            String string = arguments2.getString("key_from");
            if (string == null) {
                string = GlobalScan.ScanFrom.INDEX.getFrom();
            }
            Intrinsics.checkExpressionValueIsNotNull(string, "arguments!!.getString(Gl…lScan.ScanFrom.INDEX.from");
            this.f51399e = GlobalScan.INSTANCE.transStrToForm(string);
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                Intrinsics.throwNpe();
            }
            Serializable serializable = arguments3.getSerializable(GlobalScanActivity.KEY_INPUT_INFO);
            if (serializable != null && (serializable instanceof ManualInputInfo)) {
                this.f51401g = (ManualInputInfo) serializable;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        this.f51397c = layoutInflater.inflate(R.layout.layout_fragment_scan, viewGroup, false);
        showScan();
        return this.f51397c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m36800b();
        m36798a();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        m36802d();
        m36801c();
    }

    /* renamed from: b */
    private final void m36800b() {
        if (getActivity() instanceof GlobalScanActivity) {
            ServiceLoader<S> load = ServiceLoader.load(QRCodeProcessDelegate.class);
            this.f51398d = load != null ? (QRCodeProcessDelegate) load.get() : null;
        }
        QRCodeProcessDelegate qRCodeProcessDelegate = this.f51398d;
        if (qRCodeProcessDelegate != null) {
            if (qRCodeProcessDelegate == null) {
                Intrinsics.throwNpe();
            }
            qRCodeProcessDelegate.onEnter(this);
        }
    }

    /* renamed from: c */
    private final void m36801c() {
        ViewGroup viewGroup = this.f51396b;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(QrScanFragment$initListener$1.INSTANCE);
        }
    }

    /* renamed from: d */
    private final void m36802d() {
        View view = this.f51397c;
        this.f51396b = view != null ? (ViewGroup) view.findViewById(R.id.loadingLayout) : null;
    }

    public final void showScan() {
        m36799a(new QrCodeScanFragment());
    }

    public final void showScanFromLocal(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, ShareConstants.MEDIA_URI);
        QrCodeScanFromLocalFragment qrCodeScanFromLocalFragment = new QrCodeScanFromLocalFragment();
        Bundle bundle = new Bundle();
        bundle.putString(QrCodeScanFromLocalFragment.KEY_URI, uri.toString());
        qrCodeScanFromLocalFragment.setArguments(bundle);
        m36799a(qrCodeScanFromLocalFragment);
    }

    public final void showLoading() {
        ViewGroup viewGroup = this.f51396b;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void hideLoading() {
        ViewGroup viewGroup = this.f51396b;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final QRCodeProcessDelegate getQrCodeProcess() {
        return this.f51398d;
    }

    /* renamed from: a */
    private final void m36799a(BaseQrScanFragment baseQrScanFragment) {
        StatusBarLightingCompat.setStatusBarBgLightning(getActivity(), true, 0);
        this.f51395a = baseQrScanFragment;
        if (baseQrScanFragment != null) {
            baseQrScanFragment.setParent(this);
        }
        BaseQrScanFragment baseQrScanFragment2 = this.f51395a;
        if (baseQrScanFragment2 != null) {
            baseQrScanFragment2.updateFrom(this.f51399e);
        }
        BaseQrScanFragment baseQrScanFragment3 = this.f51395a;
        if (baseQrScanFragment3 != null) {
            baseQrScanFragment3.updateUserType(this.f51400f);
        }
        BaseQrScanFragment baseQrScanFragment4 = this.f51395a;
        if (baseQrScanFragment4 != null) {
            baseQrScanFragment4.updateInfo(this.f51401g);
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        BaseQrScanFragment baseQrScanFragment5 = this.f51395a;
        if (baseQrScanFragment5 == null) {
            Intrinsics.throwNpe();
        }
        beginTransaction.replace(R.id.container, baseQrScanFragment5).commitAllowingStateLoss();
    }

    public Activity getActivity() {
        return getActivity();
    }

    public Fragment getFragment() {
        return this;
    }

    public View getTitleBar() {
        BaseQrScanFragment baseQrScanFragment = this.f51395a;
        if (baseQrScanFragment != null) {
            return baseQrScanFragment.getTitleBarView();
        }
        return null;
    }

    public final boolean onBackPress() {
        BaseQrScanFragment baseQrScanFragment = this.f51395a;
        if (baseQrScanFragment == null || (baseQrScanFragment instanceof QrCodeScanFragment) || !(baseQrScanFragment instanceof BaseQrScanFragment)) {
            return false;
        }
        if (baseQrScanFragment == null) {
            return true;
        }
        baseQrScanFragment.onBack();
        return true;
    }

    public void onDestroy() {
        QRCodeProcessDelegate qRCodeProcessDelegate = this.f51398d;
        if (qRCodeProcessDelegate != null) {
            qRCodeProcessDelegate.onLeave();
        }
        super.onDestroy();
    }
}
