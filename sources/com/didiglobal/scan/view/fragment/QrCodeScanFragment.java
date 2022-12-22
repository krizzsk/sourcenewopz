package com.didiglobal.scan.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didiglobal.scan.net.ScanNetRequest;
import com.didiglobal.scan.view.weight.ViewFinder;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001@B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\"\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010,\u001a\u0004\u0018\u00010\u00062\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u00020\u0018H\u0016J-\u00103\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u000106052\u0006\u00107\u001a\u000208H\u0016¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u0018H\u0016J\b\u0010\u0010\u001a\u00020\u0018H\u0002J\u0012\u0010;\u001a\u00020\u00182\b\b\u0001\u0010<\u001a\u00020*H\u0002J\u0010\u0010=\u001a\u00020\u00182\u0006\u0010>\u001a\u000206H\u0016J\b\u0010?\u001a\u00020\u0018H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, mo175978d2 = {"Lcom/didiglobal/scan/view/fragment/QrCodeScanFragment;", "Lcom/didiglobal/scan/view/fragment/BaseQrScanFragment;", "Lcom/didiglobal/scan/net/ScanNetRequest$LoadingDelegate;", "Lcom/didiglobal/scan/net/ScanNetRequest$ErrorActionDelegate;", "()V", "back", "Landroid/view/View;", "barCodeView", "Lcom/didi/zxing/barcodescanner/DecoratedBarcodeView;", "captureManager", "Lcom/didi/zxing/barcodescanner/CaptureManager;", "enterPin", "Landroid/widget/ImageView;", "handler", "Landroid/os/Handler;", "rootView", "selectPhoto", "stoped", "", "torch", "torchOn", "viewFinderView", "Lcom/didiglobal/scan/view/weight/ViewFinder;", "checkPermission", "", "successAction", "Lkotlin/Function0;", "errorAction", "getTitleBarView", "handleImage", "data", "Landroid/content/Intent;", "hideLoading", "initCapture", "initEnterPin", "initListener", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "setTorchIcon", "res", "showError", "error", "showLoading", "Companion", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: QrCodeScanFragment.kt */
public final class QrCodeScanFragment extends BaseQrScanFragment implements ScanNetRequest.ErrorActionDelegate, ScanNetRequest.LoadingDelegate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: l */
    private static final int f51377l = 100;

    /* renamed from: m */
    private static final int f51378m = 102;

    /* renamed from: a */
    private View f51379a;

    /* renamed from: b */
    private View f51380b;

    /* renamed from: c */
    private ImageView f51381c;

    /* renamed from: d */
    private ImageView f51382d;

    /* renamed from: e */
    private View f51383e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DecoratedBarcodeView f51384f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ViewFinder f51385g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CaptureManager f51386h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f51387i = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f51388j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f51389k;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/scan/view/fragment/QrCodeScanFragment$Companion;", "", "()V", "REQ_PERMISSION", "", "REQ_SELECT_PHOTO", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: QrCodeScanFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        this.f51379a = layoutInflater.inflate(R.layout.layout_fragment_gloabl_scan, viewGroup, false);
        m36791c();
        m36786a();
        m36793e();
        return this.f51379a;
    }

    /* renamed from: a */
    private final void m36786a() {
        View view = this.f51380b;
        if (view != null) {
            view.setOnClickListener(new QrCodeScanFragment$initListener$1(this));
        }
        ImageView imageView = this.f51381c;
        if (imageView != null) {
            imageView.setOnClickListener(new QrCodeScanFragment$initListener$2(this));
        }
        DecoratedBarcodeView decoratedBarcodeView = this.f51384f;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.setTorchListener(new QrCodeScanFragment$initListener$3(this));
        }
        View view2 = this.f51383e;
        if (view2 != null) {
            view2.setOnClickListener(new QrCodeScanFragment$initListener$4(this));
        }
        ImageView imageView2 = this.f51382d;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new QrCodeScanFragment$initListener$5(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36789a(Function0<Unit> function0, Function0<Unit> function02) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                Intrinsics.throwNpe();
            }
            boolean z = true;
            boolean z2 = ActivityCompat.checkSelfPermission(activity, Permission.WRITE_EXTERNAL_STORAGE) == 0;
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                Intrinsics.throwNpe();
            }
            if (ActivityCompat.checkSelfPermission(activity2, Permission.WRITE_EXTERNAL_STORAGE) != 0) {
                z = false;
            }
            if (!z2 || !z) {
                FragmentActivity activity3 = getActivity();
                if (activity3 == null) {
                    Intrinsics.throwNpe();
                }
                ActivityCompat.requestPermissions(activity3, new String[]{Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE}, 100);
                return;
            }
            function0.invoke();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 100) {
                m36790b();
            } else if (i == 102) {
                String dataString = intent != null ? intent.getDataString() : null;
                if (dataString != null) {
                    if (dataString.length() > 0) {
                        m36788a(intent);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final void m36788a(Intent intent) {
        QrScanFragment parentFragment;
        Uri data = intent.getData();
        if (getContext() != null && data != null && (parentFragment = getParentFragment()) != null) {
            parentFragment.showScanFromLocal(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m36790b() {
        try {
            Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
            startActivityForResult(intent, 102);
        } catch (Exception unused) {
            ToastHelper.showShortInfo(getContext(), "Open Pick App Error");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36787a(int i) {
        ImageView imageView = this.f51381c;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m36791c() {
        /*
            r3 = this;
            android.view.View r0 = r3.f51379a
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r2 = 2131431091(0x7f0b0eb3, float:1.8483901E38)
            android.view.View r0 = r0.findViewById(r2)
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            r3.f51380b = r0
            android.view.View r0 = r3.f51379a
            if (r0 == 0) goto L_0x001e
            r2 = 2131431095(0x7f0b0eb7, float:1.848391E38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            r3.f51381c = r0
            android.view.View r0 = r3.f51379a
            if (r0 == 0) goto L_0x002f
            r2 = 2131431092(0x7f0b0eb4, float:1.8483903E38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x0030
        L_0x002f:
            r0 = r1
        L_0x0030:
            r3.f51382d = r0
            android.view.View r0 = r3.f51379a
            if (r0 == 0) goto L_0x003e
            r2 = 2131431094(0x7f0b0eb6, float:1.8483907E38)
            android.view.View r0 = r0.findViewById(r2)
            goto L_0x003f
        L_0x003e:
            r0 = r1
        L_0x003f:
            r3.f51383e = r0
            android.view.View r0 = r3.f51379a
            if (r0 == 0) goto L_0x004f
            r2 = 2131428002(0x7f0b02a2, float:1.8477636E38)
            android.view.View r0 = r0.findViewById(r2)
            com.didi.zxing.barcodescanner.DecoratedBarcodeView r0 = (com.didi.zxing.barcodescanner.DecoratedBarcodeView) r0
            goto L_0x0050
        L_0x004f:
            r0 = r1
        L_0x0050:
            r3.f51384f = r0
            android.view.View r0 = r3.f51379a
            if (r0 == 0) goto L_0x0060
            r1 = 2131435910(0x7f0b2186, float:1.8493676E38)
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            com.didiglobal.scan.view.weight.ViewFinder r1 = (com.didiglobal.scan.view.weight.ViewFinder) r1
        L_0x0060:
            r3.f51385g = r1
            r3.m36792d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.scan.view.fragment.QrCodeScanFragment.m36791c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getInfoList();
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m36792d() {
        /*
            r4 = this;
            com.didiglobal.scan.data.ManualInputInfo r0 = r4.getInputInfo()
            if (r0 == 0) goto L_0x0011
            java.util.ArrayList r0 = r0.getInfoList()
            if (r0 == 0) goto L_0x0011
            boolean r0 = r0.isEmpty()
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            r1 = 8
            if (r0 == 0) goto L_0x001e
            android.widget.ImageView r0 = r4.f51382d
            if (r0 == 0) goto L_0x001d
            r0.setVisibility(r1)
        L_0x001d:
            return
        L_0x001e:
            com.didiglobal.scan.data.ManualInputInfo r0 = r4.getInputInfo()
            if (r0 == 0) goto L_0x0053
            java.util.ArrayList r0 = r0.getInfoList()
            if (r0 == 0) goto L_0x0053
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.didiglobal.scan.data.ManualInputInfoItem r0 = (com.didiglobal.scan.data.ManualInputInfoItem) r0
            if (r0 == 0) goto L_0x0053
            boolean r3 = r0.getEnableEntrance()
            if (r3 == 0) goto L_0x004c
            android.widget.ImageView r1 = r4.f51382d
            if (r1 == 0) goto L_0x0040
            r1.setVisibility(r2)
        L_0x0040:
            android.widget.ImageView r1 = r4.f51382d
            if (r1 == 0) goto L_0x0053
            int r0 = r0.getEntranceIcon()
            r1.setImageResource(r0)
            goto L_0x0053
        L_0x004c:
            android.widget.ImageView r0 = r4.f51382d
            if (r0 == 0) goto L_0x0053
            r0.setVisibility(r1)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.scan.view.fragment.QrCodeScanFragment.m36792d():void");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        CaptureManager captureManager = this.f51386h;
        if (captureManager != null) {
            captureManager.onResume();
        }
    }

    public void showError(String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        UiThreadHandler.getsUiHandler().post(new QrCodeScanFragment$showError$1(this, str));
    }

    /* renamed from: e */
    private final void m36793e() {
        CaptureManager captureManager = new CaptureManager(getActivity(), this.f51384f);
        this.f51386h = captureManager;
        if (captureManager != null) {
            captureManager.decodeContinuous(new QrCodeScanFragment$initCapture$1(this));
        }
        CaptureManager captureManager2 = this.f51386h;
        if (captureManager2 != null) {
            captureManager2.addStateListener(new QrCodeScanFragment$initCapture$2(this));
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f51389k) {
            CaptureManager captureManager = this.f51386h;
            if (captureManager != null) {
                captureManager.onResume();
            }
            this.f51389k = false;
        }
    }

    public void onPause() {
        super.onPause();
        if (!this.f51389k) {
            CaptureManager captureManager = this.f51386h;
            if (captureManager != null) {
                captureManager.onPauseWhioutWait();
            }
            this.f51389k = true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CaptureManager captureManager = this.f51386h;
        if (captureManager != null) {
            captureManager.onDestroy();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        CaptureManager captureManager = this.f51386h;
        if (captureManager != null) {
            captureManager.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public View getTitleBarView() {
        return this.f51380b;
    }

    public void showLoading() {
        QrScanFragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            parentFragment.showLoading();
        }
    }

    public void hideLoading() {
        QrScanFragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            parentFragment.hideLoading();
        }
    }
}
