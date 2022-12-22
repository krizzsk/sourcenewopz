package com.jumio.defaultui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.google.android.material.button.MaterialButton;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioAnimationView;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00064"}, mo175978d2 = {"Lcom/jumio/defaultui/view/IproovScanFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "", "initObservers", "hideStartButtonLoading", "showStartButtonLoading", "startIproov", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onStart", "onDestroyView", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "Lcom/google/android/material/button/MaterialButton;", "startButton", "Lcom/google/android/material/button/MaterialButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "tvDescription", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroidx/core/widget/NestedScrollView;", "svDescription", "Landroidx/core/widget/NestedScrollView;", "tvTitle", "Landroidx/constraintlayout/widget/ConstraintLayout;", "baseLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/jumio/sdk/views/JumioAnimationView;", "iproovAnimationLayout", "Lcom/jumio/sdk/views/JumioAnimationView;", "Landroidx/lifecycle/Observer;", "Lcom/jumio/sdk/enums/JumioScanStep;", "scanStepObserver", "Landroidx/lifecycle/Observer;", "", "getIproovRetryHelpText", "()Ljava/lang/String;", "iproovRetryHelpText", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: IproovScanFragment.kt */
public final class IproovScanFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static String TAG = IproovScanFragment.class.getSimpleName();
    private ConstraintLayout baseLayout;
    private JumioAnimationView iproovAnimationLayout;
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new IproovScanFragment$special$$inlined$activityViewModels$default$1(this), new IproovScanFragment$special$$inlined$activityViewModels$default$2(this));
    private final Observer<JumioScanStep> scanStepObserver = new Observer() {
        public final void onChanged(Object obj) {
            IproovScanFragment.m47568scanStepObserver$lambda1(IproovScanFragment.this, (JumioScanStep) obj);
        }
    };
    private MaterialButton startButton;
    private NestedScrollView svDescription;
    private AppCompatTextView tvDescription;
    private AppCompatTextView tvTitle;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/IproovScanFragment$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: IproovScanFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {}, mo175978d2 = {}, mo175979k = 3, mo175980mv = {1, 5, 1})
    /* compiled from: IproovScanFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JumioScanStep.values().length];
            iArr[JumioScanStep.PREPARE.ordinal()] = 1;
            iArr[JumioScanStep.STARTED.ordinal()] = 2;
            iArr[JumioScanStep.IMAGE_TAKEN.ordinal()] = 3;
            iArr[JumioScanStep.PROCESSING.ordinal()] = 4;
            iArr[JumioScanStep.RETRY.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: com.jumio.defaultui.view.IproovScanFragment$a */
    /* compiled from: IproovScanFragment.kt */
    public static final class C20074a extends Lambda implements Function1<Integer, CharSequence> {

        /* renamed from: a */
        public final /* synthetic */ IproovScanFragment f55035a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C20074a(IproovScanFragment iproovScanFragment) {
            super(1);
            this.f55035a = iproovScanFragment;
        }

        /* renamed from: a */
        public final CharSequence mo163289a(int i) {
            String string = this.f55035a.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "getString(resource)");
            return string;
        }

        public /* synthetic */ Object invoke(Object obj) {
            return mo163289a(((Number) obj).intValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createLayout$lambda-2  reason: not valid java name */
    public static final void m47567createLayout$lambda2(IproovScanFragment iproovScanFragment, View view) {
        Intrinsics.checkNotNullParameter(iproovScanFragment, "this$0");
        iproovScanFragment.showStartButtonLoading();
        iproovScanFragment.startIproov();
    }

    private final String getIproovRetryHelpText() {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(Integer.valueOf(R.string.jumio_iproov_failure_generic_angle), Integer.valueOf(R.string.jumio_iproov_failure_generic_glare), Integer.valueOf(R.string.jumio_iproov_failure_generic_light)), "\n• ", "• ", (CharSequence) null, 0, (CharSequence) null, new C20074a(this), 28, (Object) null);
    }

    private final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    private final void hideStartButtonLoading() {
        MaterialButton materialButton = this.startButton;
        if (materialButton != null) {
            materialButton.setEnabled(true);
        }
        MaterialButton materialButton2 = this.startButton;
        if (materialButton2 != null) {
            setShowProgress(materialButton2, false);
        }
    }

    private final void initObservers() {
        getJumioViewModel().mo67x().observe(getViewLifecycleOwner(), this.scanStepObserver);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: scanStepObserver$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m47568scanStepObserver$lambda1(com.jumio.defaultui.view.IproovScanFragment r8, com.jumio.sdk.enums.JumioScanStep r9) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Event "
            r1.append(r2)
            java.lang.String r2 = r9.name()
            r1.append(r2)
            java.lang.String r2 = " received"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.jumio.commons.log.Log.m39466i((java.lang.String) r0, (java.lang.String) r1)
            int[] r0 = com.jumio.defaultui.view.IproovScanFragment.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r9 = r0[r9]
            r0 = 1
            if (r9 == r0) goto L_0x0136
            r1 = 2
            if (r9 == r1) goto L_0x0132
            r2 = 3
            if (r9 == r2) goto L_0x0116
            r2 = 5
            if (r9 == r2) goto L_0x003a
            goto L_0x0139
        L_0x003a:
            a.a r9 = r8.getJumioViewModel()
            com.jumio.sdk.retry.JumioRetryReason r9 = r9.mo47j()
            if (r9 != 0) goto L_0x0045
            return
        L_0x0045:
            com.jumio.defaultui.view.JumioFragmentCallback r9 = r8.getCallback()
            if (r9 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            r9.hideLoading()
        L_0x004f:
            a.a r9 = r8.getJumioViewModel()
            com.jumio.sdk.retry.JumioRetryReason r9 = r9.mo47j()
            androidx.appcompat.widget.AppCompatTextView r2 = r8.tvTitle
            r3 = 0
            if (r2 != 0) goto L_0x005d
            goto L_0x006f
        L_0x005d:
            android.content.Context r4 = r8.getContext()
            if (r4 != 0) goto L_0x0065
            r4 = r3
            goto L_0x006c
        L_0x0065:
            r5 = 2131955971(0x7f131103, float:1.9548485E38)
            java.lang.CharSequence r4 = r4.getText(r5)
        L_0x006c:
            r2.setText(r4)
        L_0x006f:
            r2 = 0
            if (r9 != 0) goto L_0x0073
            goto L_0x007d
        L_0x0073:
            int r4 = r9.getCode()
            r5 = 100
            if (r4 != r5) goto L_0x007d
            r4 = 1
            goto L_0x007e
        L_0x007d:
            r4 = 0
        L_0x007e:
            if (r4 != 0) goto L_0x00a8
            if (r9 != 0) goto L_0x0083
            goto L_0x008a
        L_0x0083:
            int r4 = r9.getCode()
            if (r4 != r1) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r0 = 0
        L_0x008b:
            if (r0 == 0) goto L_0x008e
            goto L_0x00a8
        L_0x008e:
            androidx.appcompat.widget.AppCompatTextView r0 = r8.tvDescription
            if (r0 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            if (r9 != 0) goto L_0x0096
            goto L_0x009a
        L_0x0096:
            java.lang.String r3 = r9.getMessage()
        L_0x009a:
            r0.setText(r3)
        L_0x009d:
            androidx.appcompat.widget.AppCompatTextView r9 = r8.tvDescription
            if (r9 != 0) goto L_0x00a2
            goto L_0x00bf
        L_0x00a2:
            r0 = 17
            r9.setGravity(r0)
            goto L_0x00bf
        L_0x00a8:
            androidx.appcompat.widget.AppCompatTextView r9 = r8.tvDescription
            if (r9 != 0) goto L_0x00ad
            goto L_0x00b3
        L_0x00ad:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r9.setGravity(r0)
        L_0x00b3:
            androidx.appcompat.widget.AppCompatTextView r9 = r8.tvDescription
            if (r9 != 0) goto L_0x00b8
            goto L_0x00bf
        L_0x00b8:
            java.lang.String r0 = r8.getIproovRetryHelpText()
            r9.setText(r0)
        L_0x00bf:
            r9 = 16
            android.content.Context r0 = r8.getContext()
            if (r0 != 0) goto L_0x00c8
            goto L_0x00d5
        L_0x00c8:
            android.content.res.Resources r0 = r0.getResources()
            if (r0 != 0) goto L_0x00cf
            goto L_0x00d5
        L_0x00cf:
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            if (r0 != 0) goto L_0x00d7
        L_0x00d5:
            r0 = 0
            goto L_0x00d9
        L_0x00d7:
            float r0 = r0.density
        L_0x00d9:
            float r9 = (float) r9
            float r9 = r9 * r0
            int r9 = (int) r9
            androidx.core.widget.NestedScrollView r0 = r8.svDescription
            if (r0 != 0) goto L_0x00e2
            goto L_0x00e5
        L_0x00e2:
            r0.setPadding(r9, r9, r9, r9)
        L_0x00e5:
            androidx.core.widget.NestedScrollView r9 = r8.svDescription
            if (r9 != 0) goto L_0x00ea
            goto L_0x00f0
        L_0x00ea:
            r0 = 2131234187(0x7f080d8b, float:1.8084533E38)
            r9.setBackgroundResource(r0)
        L_0x00f0:
            r8.hideStartButtonLoading()
            com.google.android.material.button.MaterialButton r9 = r8.startButton
            if (r9 != 0) goto L_0x00f8
            goto L_0x0102
        L_0x00f8:
            r0 = 2131955878(0x7f1310a6, float:1.9548296E38)
            java.lang.String r0 = r8.getString(r0)
            r9.setText(r0)
        L_0x0102:
            com.jumio.sdk.views.JumioAnimationView r9 = r8.iproovAnimationLayout
            if (r9 != 0) goto L_0x0107
            goto L_0x0139
        L_0x0107:
            a.a r8 = r8.getJumioViewModel()
            com.jumio.sdk.scanpart.JumioScanPart r8 = r8.mo48k()
            if (r8 != 0) goto L_0x0112
            goto L_0x0139
        L_0x0112:
            r8.getHelpAnimation(r9)
            goto L_0x0139
        L_0x0116:
            com.jumio.defaultui.view.JumioFragmentCallback r8 = r8.getCallback()
            if (r8 != 0) goto L_0x011d
            goto L_0x0139
        L_0x011d:
            com.jumio.defaultui.view.LoadingView$State r9 = new com.jumio.defaultui.view.LoadingView$State
            com.jumio.defaultui.view.LoadingView$ViewState r1 = com.jumio.defaultui.view.LoadingView.ViewState.PROGRESS
            r2 = 2131955864(0x7f131098, float:1.9548268E38)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 28
            r7 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateLoadingState(r9)
            goto L_0x0139
        L_0x0132:
            r8.hideStartButtonLoading()
            goto L_0x0139
        L_0x0136:
            r8.showStartButtonLoading()
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.IproovScanFragment.m47568scanStepObserver$lambda1(com.jumio.defaultui.view.IproovScanFragment, com.jumio.sdk.enums.JumioScanStep):void");
    }

    private final void showStartButtonLoading() {
        MaterialButton materialButton = this.startButton;
        if (materialButton != null && materialButton.isEnabled()) {
            MaterialButton materialButton2 = this.startButton;
            if (materialButton2 != null) {
                materialButton2.setText(getString(R.string.jumio_loading_title));
            }
            MaterialButton materialButton3 = this.startButton;
            if (materialButton3 != null) {
                materialButton3.setEnabled(false);
            }
            MaterialButton materialButton4 = this.startButton;
            if (materialButton4 != null) {
                setShowProgress(materialButton4, true);
            }
        }
    }

    private final void startIproov() {
        JumioScanPart k = getJumioViewModel().mo48k();
        if (k != null) {
            k.start();
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        JumioAnimationView jumioAnimationView;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_scan_iproov, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.baseLayout);
        this.baseLayout = constraintLayout;
        String str = null;
        if (constraintLayout == null) {
            jumioAnimationView = null;
        } else {
            jumioAnimationView = (JumioAnimationView) constraintLayout.findViewById(R.id.iproov_animation_view);
        }
        this.iproovAnimationLayout = jumioAnimationView;
        ConstraintLayout constraintLayout2 = this.baseLayout;
        MaterialButton materialButton = constraintLayout2 == null ? null : (MaterialButton) constraintLayout2.findViewById(R.id.btn_start);
        this.startButton = materialButton;
        if (materialButton != null) {
            Context context = getContext();
            materialButton.setText(context == null ? null : context.getString(R.string.jumio_start_button));
        }
        ConstraintLayout constraintLayout3 = this.baseLayout;
        this.tvTitle = constraintLayout3 == null ? null : (AppCompatTextView) constraintLayout3.findViewById(R.id.tv_title);
        ConstraintLayout constraintLayout4 = this.baseLayout;
        this.tvDescription = constraintLayout4 == null ? null : (AppCompatTextView) constraintLayout4.findViewById(R.id.tv_description);
        ConstraintLayout constraintLayout5 = this.baseLayout;
        this.svDescription = constraintLayout5 == null ? null : (NestedScrollView) constraintLayout5.findViewById(R.id.sv_description);
        AppCompatTextView appCompatTextView = this.tvTitle;
        if (appCompatTextView != null) {
            appCompatTextView.setGravity(17);
        }
        AppCompatTextView appCompatTextView2 = this.tvTitle;
        if (appCompatTextView2 != null) {
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getString(R.string.jumio_identity_title);
            }
            appCompatTextView2.setText(str);
        }
        MaterialButton materialButton2 = this.startButton;
        if (materialButton2 != null) {
            materialButton2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    IproovScanFragment.m47567createLayout$lambda2(IproovScanFragment.this, view);
                }
            });
        }
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.startButton = null;
        this.tvDescription = null;
        this.svDescription = null;
        this.tvTitle = null;
        this.baseLayout = null;
        this.iproovAnimationLayout = null;
    }

    public void onStart() {
        JumioScanPart k;
        super.onStart();
        JumioAnimationView jumioAnimationView = this.iproovAnimationLayout;
        if (jumioAnimationView != null && (k = getJumioViewModel().mo48k()) != null) {
            k.getHelpAnimation(jumioAnimationView);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initObservers();
    }
}
