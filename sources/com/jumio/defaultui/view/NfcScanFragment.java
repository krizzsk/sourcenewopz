package com.jumio.defaultui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.jumio.commons.log.Log;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioActivityAttacher;
import com.jumio.sdk.views.JumioAnimationView;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u0007¢\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010/R\u0018\u00101\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R*\u0010<\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020:\u0012\u0006\u0012\u0004\u0018\u00010;09088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020>088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010=¨\u0006C"}, mo175978d2 = {"Lcom/jumio/defaultui/view/NfcScanFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "Landroid/view/View$OnClickListener;", "", "initObservers", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onStart", "v", "onClick", "onDestroyView", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "Lcom/google/android/material/button/MaterialButton;", "btnHelpSkip", "Lcom/google/android/material/button/MaterialButton;", "btnRetrySkip", "btnRetry", "Landroid/widget/ImageView;", "ivStatus", "Landroid/widget/ImageView;", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "cpiExtraction", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "Landroidx/appcompat/widget/AppCompatTextView;", "tvTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "tvDescription", "tvRetryDescription", "tvProgress", "Landroidx/constraintlayout/widget/ConstraintLayout;", "baseLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/Group;", "groupRetry", "Landroidx/constraintlayout/widget/Group;", "groupProgress", "groupHelp", "Lcom/jumio/sdk/views/JumioAnimationView;", "nfcAnimationView", "Lcom/jumio/sdk/views/JumioAnimationView;", "Lcom/jumio/sdk/retry/JumioRetryReason;", "retryReason", "Lcom/jumio/sdk/retry/JumioRetryReason;", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "Lcom/jumio/sdk/enums/JumioScanUpdate;", "Lcom/jumio/sdk/enums/JumioScanSide;", "scanUpdateObserver", "Landroidx/lifecycle/Observer;", "Lcom/jumio/sdk/enums/JumioScanStep;", "scanStepObserver", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: NfcScanFragment.kt */
public final class NfcScanFragment extends BaseFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static String TAG = NfcScanFragment.class.getSimpleName();
    private ConstraintLayout baseLayout;
    private MaterialButton btnHelpSkip;
    private MaterialButton btnRetry;
    private MaterialButton btnRetrySkip;
    private CircularProgressIndicator cpiExtraction;
    private Group groupHelp;
    private Group groupProgress;
    private Group groupRetry;
    private ImageView ivStatus;
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new NfcScanFragment$special$$inlined$activityViewModels$default$1(this), new NfcScanFragment$special$$inlined$activityViewModels$default$2(this));
    private JumioAnimationView nfcAnimationView;
    private JumioRetryReason retryReason;
    private final Observer<JumioScanStep> scanStepObserver = new Observer() {
        public final void onChanged(Object obj) {
            NfcScanFragment.m47574scanStepObserver$lambda3(NfcScanFragment.this, (JumioScanStep) obj);
        }
    };
    private final Observer<Pair<JumioScanUpdate, JumioScanSide>> scanUpdateObserver = new Observer() {
        public final void onChanged(Object obj) {
            NfcScanFragment.m47575scanUpdateObserver$lambda0(NfcScanFragment.this, (Pair) obj);
        }
    };
    private AppCompatTextView tvDescription;
    private AppCompatTextView tvProgress;
    private AppCompatTextView tvRetryDescription;
    private AppCompatTextView tvTitle;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/NfcScanFragment$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: NfcScanFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {}, mo175978d2 = {}, mo175979k = 3, mo175980mv = {1, 5, 1})
    /* compiled from: NfcScanFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[JumioScanUpdate.values().length];
            iArr[JumioScanUpdate.NFC_EXTRACTION_STARTED.ordinal()] = 1;
            iArr[JumioScanUpdate.NFC_EXTRACTION_PROGRESS.ordinal()] = 2;
            iArr[JumioScanUpdate.NFC_EXTRACTION_FINISHED.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[JumioScanStep.values().length];
            iArr2[JumioScanStep.ATTACH_ACTIVITY.ordinal()] = 1;
            iArr2[JumioScanStep.RETRY.ordinal()] = 2;
            iArr2[JumioScanStep.CAN_FINISH.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    private final void initObservers() {
        getJumioViewModel().mo68y().observe(getViewLifecycleOwner(), this.scanUpdateObserver);
        getJumioViewModel().mo67x().observe(getViewLifecycleOwner(), this.scanStepObserver);
    }

    /* access modifiers changed from: private */
    /* renamed from: scanStepObserver$lambda-3  reason: not valid java name */
    public static final void m47574scanStepObserver$lambda3(NfcScanFragment nfcScanFragment, JumioScanStep jumioScanStep) {
        JumioScanPart k;
        JumioAnimationView jumioAnimationView;
        Intrinsics.checkNotNullParameter(nfcScanFragment, "this$0");
        String str = TAG;
        Log.m39466i(str, "Event " + jumioScanStep.name() + " received");
        int i = WhenMappings.$EnumSwitchMapping$1[jumioScanStep.ordinal()];
        if (i == 1) {
            FragmentActivity activity = nfcScanFragment.getActivity();
            if (activity != null && (k = nfcScanFragment.getJumioViewModel().mo48k()) != null) {
                new JumioActivityAttacher(activity).attach(k);
            }
        } else if (i != 2) {
            if (i == 3 && (jumioAnimationView = nfcScanFragment.nfcAnimationView) != null) {
                jumioAnimationView.destroy();
            }
        } else if (nfcScanFragment.getJumioViewModel().mo47j() != null) {
            JumioRetryReason j = nfcScanFragment.getJumioViewModel().mo47j();
            nfcScanFragment.retryReason = j;
            AppCompatTextView appCompatTextView = nfcScanFragment.tvRetryDescription;
            if (appCompatTextView != null) {
                appCompatTextView.setText(j == null ? null : j.getMessage());
            }
            Group group = nfcScanFragment.groupHelp;
            if (group != null) {
                group.setVisibility(8);
            }
            Group group2 = nfcScanFragment.groupProgress;
            if (group2 != null) {
                group2.setVisibility(8);
            }
            Group group3 = nfcScanFragment.groupRetry;
            if (group3 != null) {
                group3.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: scanUpdateObserver$lambda-0  reason: not valid java name */
    public static final void m47575scanUpdateObserver$lambda0(NfcScanFragment nfcScanFragment, Pair pair) {
        Intrinsics.checkNotNullParameter(nfcScanFragment, "this$0");
        JumioScanUpdate jumioScanUpdate = (JumioScanUpdate) pair.component1();
        String str = TAG;
        Log.m39466i(str, "Update " + jumioScanUpdate.name() + " received");
        int i = WhenMappings.$EnumSwitchMapping$0[jumioScanUpdate.ordinal()];
        if (i == 1) {
            Log.m39466i(TAG, "NFC Extraction started");
            Group group = nfcScanFragment.groupHelp;
            if (group != null) {
                group.setVisibility(8);
            }
            Group group2 = nfcScanFragment.groupProgress;
            if (group2 != null) {
                group2.setVisibility(0);
            }
            Group group3 = nfcScanFragment.groupRetry;
            if (group3 != null) {
                group3.setVisibility(8);
            }
        } else if (i == 2) {
            Log.m39466i(TAG, "NFC Extraction progress");
            AppCompatTextView appCompatTextView = nfcScanFragment.tvProgress;
            if (appCompatTextView != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(nfcScanFragment.getJumioViewModel().mo65v());
                sb.append('%');
                appCompatTextView.setText(sb.toString());
            }
        } else if (i == 3) {
            Log.m39466i(TAG, "NFC Extraction finished");
            CircularProgressIndicator circularProgressIndicator = nfcScanFragment.cpiExtraction;
            if (circularProgressIndicator != null) {
                circularProgressIndicator.hide();
            }
            AppCompatTextView appCompatTextView2 = nfcScanFragment.tvProgress;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(4);
            }
            ImageView imageView = nfcScanFragment.ivStatus;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.jumio_ic_nfc_success);
            }
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        JumioAnimationView jumioAnimationView;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_scan_nfc, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.baseLayout);
        this.baseLayout = constraintLayout;
        String str = null;
        if (constraintLayout == null) {
            jumioAnimationView = null;
        } else {
            jumioAnimationView = (JumioAnimationView) constraintLayout.findViewById(R.id.nfc_animation_view);
        }
        this.nfcAnimationView = jumioAnimationView;
        ConstraintLayout constraintLayout2 = this.baseLayout;
        MaterialButton materialButton = constraintLayout2 == null ? null : (MaterialButton) constraintLayout2.findViewById(R.id.btn_help_skip);
        this.btnHelpSkip = materialButton;
        if (materialButton != null) {
            materialButton.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout3 = this.baseLayout;
        MaterialButton materialButton2 = constraintLayout3 == null ? null : (MaterialButton) constraintLayout3.findViewById(R.id.btn_retry_skip);
        this.btnRetrySkip = materialButton2;
        if (materialButton2 != null) {
            materialButton2.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout4 = this.baseLayout;
        MaterialButton materialButton3 = constraintLayout4 == null ? null : (MaterialButton) constraintLayout4.findViewById(R.id.btn_retry);
        this.btnRetry = materialButton3;
        if (materialButton3 != null) {
            materialButton3.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout5 = this.baseLayout;
        this.groupRetry = constraintLayout5 == null ? null : (Group) constraintLayout5.findViewById(R.id.group_retry);
        ConstraintLayout constraintLayout6 = this.baseLayout;
        this.groupProgress = constraintLayout6 == null ? null : (Group) constraintLayout6.findViewById(R.id.group_progress);
        ConstraintLayout constraintLayout7 = this.baseLayout;
        this.groupHelp = constraintLayout7 == null ? null : (Group) constraintLayout7.findViewById(R.id.group_help);
        ConstraintLayout constraintLayout8 = this.baseLayout;
        this.tvProgress = constraintLayout8 == null ? null : (AppCompatTextView) constraintLayout8.findViewById(R.id.tv_progress_percentage);
        ConstraintLayout constraintLayout9 = this.baseLayout;
        this.ivStatus = constraintLayout9 == null ? null : (ImageView) constraintLayout9.findViewById(R.id.iv_progress);
        ConstraintLayout constraintLayout10 = this.baseLayout;
        this.cpiExtraction = constraintLayout10 == null ? null : (CircularProgressIndicator) constraintLayout10.findViewById(R.id.cpi_extraction);
        ConstraintLayout constraintLayout11 = this.baseLayout;
        this.tvTitle = constraintLayout11 == null ? null : (AppCompatTextView) constraintLayout11.findViewById(R.id.tv_title);
        ConstraintLayout constraintLayout12 = this.baseLayout;
        this.tvDescription = constraintLayout12 == null ? null : (AppCompatTextView) constraintLayout12.findViewById(R.id.tv_description);
        ConstraintLayout constraintLayout13 = this.baseLayout;
        this.tvRetryDescription = constraintLayout13 == null ? null : (AppCompatTextView) constraintLayout13.findViewById(R.id.tv_retry_description);
        AppCompatTextView appCompatTextView = this.tvTitle;
        if (appCompatTextView != null) {
            Context context = getContext();
            appCompatTextView.setText(context == null ? null : context.getString(R.string.jumio_nfc_header_start));
        }
        AppCompatTextView appCompatTextView2 = this.tvDescription;
        if (appCompatTextView2 != null) {
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getString(R.string.jumio_nfc_description_start_other);
            }
            appCompatTextView2.setText(str);
        }
        return inflate;
    }

    public void onClick(View view) {
        JumioScanPart k;
        AutoTrackHelper.trackViewOnClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf == null || valueOf.intValue() != R.id.btn_retry) {
            if ((valueOf != null && valueOf.intValue() == R.id.btn_retry_skip) || (valueOf != null && valueOf.intValue() == R.id.btn_help_skip)) {
                MaterialButton materialButton = this.btnRetrySkip;
                if (materialButton != null) {
                    materialButton.setEnabled(false);
                }
                MaterialButton materialButton2 = this.btnHelpSkip;
                if (materialButton2 != null) {
                    materialButton2.setEnabled(false);
                }
                JumioFragmentCallback callback = getCallback();
                if (callback != null) {
                    callback.skipAddonPart();
                }
            }
        } else if (this.retryReason != null) {
            Group group = this.groupHelp;
            if (group != null) {
                group.setVisibility(0);
            }
            Group group2 = this.groupProgress;
            if (group2 != null) {
                group2.setVisibility(8);
            }
            Group group3 = this.groupRetry;
            if (group3 != null) {
                group3.setVisibility(8);
            }
            JumioRetryReason jumioRetryReason = this.retryReason;
            if (!(jumioRetryReason == null || (k = getJumioViewModel().mo48k()) == null)) {
                k.retry(jumioRetryReason);
            }
            this.retryReason = null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        JumioAnimationView jumioAnimationView = this.nfcAnimationView;
        if (jumioAnimationView != null) {
            jumioAnimationView.destroy();
        }
        this.btnHelpSkip = null;
        this.btnRetrySkip = null;
        this.btnRetry = null;
        this.ivStatus = null;
        this.cpiExtraction = null;
        this.tvTitle = null;
        this.tvDescription = null;
        this.tvRetryDescription = null;
        this.tvProgress = null;
        this.baseLayout = null;
        this.groupRetry = null;
        this.groupProgress = null;
        this.groupHelp = null;
        this.nfcAnimationView = null;
    }

    public void onStart() {
        JumioScanPart k;
        super.onStart();
        JumioAnimationView jumioAnimationView = this.nfcAnimationView;
        if (!(jumioAnimationView == null || (k = getJumioViewModel().mo48k()) == null)) {
            k.getHelpAnimation(jumioAnimationView);
        }
        JumioScanPart k2 = getJumioViewModel().mo48k();
        if (k2 != null) {
            k2.start();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initObservers();
    }
}
