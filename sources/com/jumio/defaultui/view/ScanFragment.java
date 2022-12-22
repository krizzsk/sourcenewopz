package com.jumio.defaultui.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.jumio.commons.log.Log;
import com.jumio.core.views.ScanView;
import com.jumio.defaultui.view.HelpViewBottomSheet;
import com.jumio.defaultui.view.JumioDialog;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioActivityAttacher;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0007¢\u0006\u0004\b\\\u0010]J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u0012\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010 H\u0016R\u001d\u00104\u001a\u00020/8B@\u0002X\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010:R\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020R0Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR*\u0010W\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020V\u0012\u0006\u0012\u0004\u0018\u00010\u00190U0Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010TR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00030Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010TR\u0016\u0010[\u001a\u00020\u00038B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006_"}, mo175978d2 = {"Lcom/jumio/defaultui/view/ScanFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "Landroid/view/View$OnClickListener;", "", "enable", "", "enableButtons", "playScanAnimations", "", "animStartDelay", "Landroid/animation/AnimatorSet;", "showIconAndScrim", "flipCardAndHide", "scaleBarcodeFocus", "initObservers", "setupTooltip", "cancelToolTip", "", "stringId", "setProgressText", "showAndEnableCameraSwitchIfAvailable", "startTip", "", "generateTipsText", "getScanModePromptStringResource", "Lcom/jumio/sdk/enums/JumioScanSide;", "scanSide", "shouldShowLegalDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "view", "savedInstanceState", "onViewCreated", "onStart", "onResume", "onPause", "onStop", "onDestroyView", "v", "onClick", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "Lcom/jumio/core/views/ScanView;", "scanView", "Lcom/jumio/core/views/ScanView;", "Landroid/widget/ImageButton;", "helpButton", "Landroid/widget/ImageButton;", "cameraSwitchButton", "Landroidx/appcompat/widget/AppCompatTextView;", "progressChip", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/jumio/defaultui/view/JumioBottomSheet;", "bottomSheet", "Lcom/jumio/defaultui/view/JumioBottomSheet;", "shutterButton", "Landroid/widget/ImageView;", "animationScrim", "Landroid/widget/ImageView;", "animationIcon", "scanAnimatorSet", "Landroid/animation/AnimatorSet;", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "processingIndicator", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "initializedScanSide", "Ljava/lang/String;", "Landroidx/appcompat/app/AlertDialog;", "legalDialog", "Landroidx/appcompat/app/AlertDialog;", "Landroidx/lifecycle/Observer;", "Lcom/jumio/sdk/enums/JumioScanStep;", "scanStepObserver", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "Lcom/jumio/sdk/enums/JumioScanUpdate;", "scanUpdateObserver", "helpViewObserver", "getHasFrontAndBackSide", "()Z", "hasFrontAndBackSide", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ScanFragment.kt */
public final class ScanFragment extends BaseFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static int LAYOUT = R.layout.fragment_scan;
    private static String TAG = ScanFragment.class.getSimpleName();
    /* access modifiers changed from: private */
    public ImageView animationIcon;
    /* access modifiers changed from: private */
    public ImageView animationScrim;
    private JumioBottomSheet bottomSheet;
    private ImageButton cameraSwitchButton;
    private ImageButton helpButton;
    private final Observer<Boolean> helpViewObserver = new Observer() {
        public final void onChanged(Object obj) {
            ScanFragment.m47576helpViewObserver$lambda20(ScanFragment.this, (Boolean) obj);
        }
    };
    private String initializedScanSide = "";
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new ScanFragment$special$$inlined$activityViewModels$default$1(this), new ScanFragment$special$$inlined$activityViewModels$default$2(this));
    private AlertDialog legalDialog;
    private CircularProgressIndicator processingIndicator;
    private AppCompatTextView progressChip;
    private AnimatorSet scanAnimatorSet = new AnimatorSet();
    private final Observer<JumioScanStep> scanStepObserver = new Observer() {
        public final void onChanged(Object obj) {
            ScanFragment.m47579scanStepObserver$lambda4(ScanFragment.this, (JumioScanStep) obj);
        }
    };
    private final Observer<Pair<JumioScanUpdate, JumioScanSide>> scanUpdateObserver = new Observer() {
        public final void onChanged(Object obj) {
            ScanFragment.m47580scanUpdateObserver$lambda19(ScanFragment.this, (Pair) obj);
        }
    };
    /* access modifiers changed from: private */
    public ScanView scanView;
    private ImageButton shutterButton;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/ScanFragment$Companion;", "", "", "LAYOUT", "I", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: ScanFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {}, mo175978d2 = {}, mo175979k = 3, mo175980mv = {1, 5, 1})
    /* compiled from: ScanFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[JumioScanStep.values().length];
            iArr[JumioScanStep.SCAN_VIEW.ordinal()] = 1;
            iArr[JumioScanStep.STARTED.ordinal()] = 2;
            iArr[JumioScanStep.IMAGE_TAKEN.ordinal()] = 3;
            iArr[JumioScanStep.CONFIRMATION_VIEW.ordinal()] = 4;
            iArr[JumioScanStep.REJECT_VIEW.ordinal()] = 5;
            iArr[JumioScanStep.ATTACH_ACTIVITY.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[JumioScanUpdate.values().length];
            iArr2[JumioScanUpdate.LEGAL_HINT.ordinal()] = 1;
            iArr2[JumioScanUpdate.FALLBACK.ordinal()] = 2;
            iArr2[JumioScanUpdate.CAMERA_AVAILABLE.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[JumioScanMode.values().length];
            iArr3[JumioScanMode.MRZ.ordinal()] = 1;
            iArr3[JumioScanMode.BARCODE.ordinal()] = 2;
            iArr3[JumioScanMode.FACE_MANUAL.ordinal()] = 3;
            iArr3[JumioScanMode.MANUAL.ordinal()] = 4;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private final void cancelToolTip() {
        ImageButton imageButton = this.helpButton;
        if (imageButton != null) {
            TooltipCompat.setTooltipText(imageButton, (CharSequence) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    private final void enableButtons(boolean z) {
        boolean z2;
        ImageButton imageButton = this.cameraSwitchButton;
        boolean z3 = false;
        if (imageButton != null) {
            if (z) {
                ScanView scanView2 = this.scanView;
                if (scanView2 != null && scanView2.getHasMultipleCameras()) {
                    z2 = true;
                    imageButton.setEnabled(z2);
                }
            }
            z2 = false;
            imageButton.setEnabled(z2);
        }
        ImageButton imageButton2 = this.shutterButton;
        if (imageButton2 != null) {
            if (z) {
                ScanView scanView3 = this.scanView;
                if (scanView3 != null && scanView3.isShutterEnabled()) {
                    z3 = true;
                }
            }
            imageButton2.setEnabled(z3);
        }
        ImageButton imageButton3 = this.helpButton;
        if (imageButton3 != null) {
            imageButton3.setEnabled(z);
        }
    }

    private final AnimatorSet flipCardAndHide() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.animationIcon, View.ROTATION_Y, new float[]{0.0f, 180.0f});
        ofFloat.setDuration(400);
        ofFloat.setStartDelay(200);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.animationIcon, View.ALPHA, new float[]{1.0f, 1.0f});
        ofFloat2.setDuration(200);
        ofFloat2.setStartDelay(200);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "");
        ofFloat2.addListener(new ScanFragment$flipCardAndHide$lambda13$$inlined$doOnEnd$1(this));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.animationIcon, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat3.setStartDelay(800);
        ofFloat3.setDuration(400);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.animationScrim, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat4.setStartDelay(800);
        ofFloat4.setDuration(400);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat).before(ofFloat3);
        animatorSet.play(ofFloat3).with(ofFloat4);
        return animatorSet;
    }

    private final boolean getHasFrontAndBackSide() {
        ArrayList<JumioScanSide> scanSides;
        JumioCredential g = getJumioViewModel().mo44g();
        if (g == null || (scanSides = g.getScanSides()) == null) {
            return false;
        }
        return scanSides.containsAll(CollectionsKt.listOf(JumioScanSide.FRONT, JumioScanSide.BACK));
    }

    /* access modifiers changed from: private */
    public final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    private final int getScanModePromptStringResource() {
        JumioScanPart k = getJumioViewModel().mo48k();
        JumioScanMode scanMode = k == null ? null : k.getScanMode();
        int i = scanMode == null ? -1 : WhenMappings.$EnumSwitchMapping$2[scanMode.ordinal()];
        if (i == 2) {
            return R.string.jumio_id_scan_prompt_barcode;
        }
        if (i != 3) {
            return i != 4 ? R.string.jumio_id_scan_prompt_initial_linefinder : R.string.jumio_id_scan_manual;
        }
        return R.string.jumio_identity_scan_prompt_initial;
    }

    /* access modifiers changed from: private */
    /* renamed from: helpViewObserver$lambda-20  reason: not valid java name */
    public static final void m47576helpViewObserver$lambda20(ScanFragment scanFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(scanFragment, "this$0");
        ScanView scanView2 = scanFragment.scanView;
        if (scanView2 != null) {
            scanView2.setExtraction(!bool.booleanValue());
        }
        scanFragment.enableButtons(!bool.booleanValue());
    }

    private final void initObservers() {
        getJumioViewModel().mo68y().observe(getViewLifecycleOwner(), this.scanUpdateObserver);
        getJumioViewModel().mo67x().observe(getViewLifecycleOwner(), this.scanStepObserver);
        getJumioViewModel().mo59p().observe(getViewLifecycleOwner(), this.helpViewObserver);
    }

    private final void playScanAnimations() {
        AnimatorSet animatorSet = new AnimatorSet();
        JumioScanMode jumioScanMode = null;
        if (getHasFrontAndBackSide()) {
            ImageView imageView = this.animationScrim;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.jumio_ic_scrim_rect_light);
            }
            BaseFragment.fadeAndScaleTo$default(this, this.animationIcon, 0, 0, 0, 6, (Object) null);
            BaseFragment.fadeAndScaleTo$default(this, this.animationScrim, 0, 0, 0, 6, (Object) null);
            AnimatorSet showIconAndScrim$default = showIconAndScrim$default(this, 0, 1, (Object) null);
            animatorSet.play(showIconAndScrim$default);
            if (getJumioViewModel().mo49l() == JumioScanSide.FRONT) {
                ImageView imageView2 = this.animationIcon;
                if (imageView2 != null) {
                    imageView2.setContentDescription(getString(R.string.jumio_accessibility_scan_id_front));
                }
                ImageView imageView3 = this.animationScrim;
                if (imageView3 != null) {
                    imageView3.setContentDescription(getString(R.string.jumio_accessibility_scan_id_front));
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.animationIcon, View.ALPHA, new float[]{1.0f, 0.0f});
                ofFloat.setDuration(400);
                ofFloat.setStartDelay(1700);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.animationScrim, View.ALPHA, new float[]{1.0f, 0.0f});
                ofFloat2.setDuration(400);
                ofFloat2.setStartDelay(1700);
                animatorSet.play(ofFloat).with(ofFloat2);
                animatorSet.play(ofFloat).after(showIconAndScrim$default);
            } else {
                ImageView imageView4 = this.animationIcon;
                if (imageView4 != null) {
                    imageView4.setContentDescription(getString(R.string.jumio_accessibility_scan_id_back));
                }
                ImageView imageView5 = this.animationScrim;
                if (imageView5 != null) {
                    imageView5.setContentDescription(getString(R.string.jumio_accessibility_scan_id_back));
                }
                animatorSet.play(flipCardAndHide()).after(showIconAndScrim$default);
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        JumioScanPart k = getJumioViewModel().mo48k();
        if (k != null) {
            jumioScanMode = k.getScanMode();
        }
        JumioScanMode jumioScanMode2 = JumioScanMode.BARCODE;
        if (jumioScanMode == jumioScanMode2) {
            ImageView imageView6 = this.animationIcon;
            if (imageView6 != null) {
                imageView6.setTag(jumioScanMode2);
            }
            AnimatorSet showIconAndScrim = showIconAndScrim(500);
            animatorSet2.play(showIconAndScrim);
            animatorSet2.addListener(new ScanFragment$playScanAnimations$$inlined$doOnStart$1(this));
            animatorSet2.play(scaleBarcodeFocus()).after(showIconAndScrim);
        }
        if (animatorSet.getChildAnimations().size() > 0) {
            this.scanAnimatorSet.play(animatorSet);
            if (animatorSet2.getChildAnimations().size() > 0) {
                this.scanAnimatorSet.play(animatorSet2).after(animatorSet);
            }
        }
        if (this.scanAnimatorSet.getChildAnimations().size() > 0) {
            this.scanAnimatorSet.start();
        }
    }

    private final AnimatorSet scaleBarcodeFocus() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.6f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.6f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.animationIcon, new PropertyValuesHolder[]{ofFloat, ofFloat2});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n…nIcon, scaleX, scaleY\n\t\t)");
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.animationScrim, new PropertyValuesHolder[]{ofFloat, ofFloat2});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder2, "ofPropertyValuesHolder(\n…Scrim, scaleX, scaleY\n\t\t)");
        ofPropertyValuesHolder.setDuration(300);
        ofPropertyValuesHolder.setStartDelay(Const.DELAY_TIME4LAST_GPS_TASK);
        ofPropertyValuesHolder.setRepeatCount(1);
        ofPropertyValuesHolder.setRepeatMode(2);
        ofPropertyValuesHolder2.setDuration(300);
        ofPropertyValuesHolder2.setStartDelay(Const.DELAY_TIME4LAST_GPS_TASK);
        ofPropertyValuesHolder2.setRepeatCount(1);
        ofPropertyValuesHolder2.setRepeatMode(2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofPropertyValuesHolder).with(ofPropertyValuesHolder2);
        return animatorSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: scanStepObserver$lambda-4  reason: not valid java name */
    public static final void m47579scanStepObserver$lambda4(ScanFragment scanFragment, JumioScanStep jumioScanStep) {
        JumioScanPart k;
        ScanView scanView2;
        JumioScanPart k2;
        ScanView scanView3;
        JumioScanPart k3;
        Intrinsics.checkNotNullParameter(scanFragment, "this$0");
        String str = TAG;
        Log.m39466i(str, "Event " + jumioScanStep.name() + " received on side " + scanFragment.initializedScanSide);
        boolean z = false;
        switch (WhenMappings.$EnumSwitchMapping$0[jumioScanStep.ordinal()]) {
            case 1:
                JumioFragmentCallback callback = scanFragment.getCallback();
                if (callback != null && callback.validatePermissions()) {
                    z = true;
                }
                if (z && (k = scanFragment.getJumioViewModel().mo48k()) != null && (scanView2 = scanFragment.scanView) != null) {
                    scanView2.attach(k);
                    return;
                }
                return;
            case 2:
                ScanView scanView4 = scanFragment.scanView;
                if (!(scanView4 != null && scanView4.isAttached())) {
                    JumioFragmentCallback callback2 = scanFragment.getCallback();
                    if (!(!(callback2 != null && callback2.validatePermissions()) || (k2 = scanFragment.getJumioViewModel().mo48k()) == null || (scanView3 = scanFragment.scanView) == null)) {
                        scanView3.attach(k2);
                    }
                }
                scanFragment.setProgressText(scanFragment.getScanModePromptStringResource());
                if (scanFragment.getJumioViewModel().mo48k() != null) {
                    CircularProgressIndicator circularProgressIndicator = scanFragment.processingIndicator;
                    if (circularProgressIndicator != null) {
                        circularProgressIndicator.hide();
                    }
                    scanFragment.playScanAnimations();
                    ImageButton imageButton = scanFragment.shutterButton;
                    if (imageButton != null) {
                        ScanView scanView5 = scanFragment.scanView;
                        imageButton.setVisibility(scanView5 != null && scanView5.isShutterEnabled() ? 0 : 8);
                    }
                    ImageButton imageButton2 = scanFragment.shutterButton;
                    if (imageButton2 != null) {
                        ScanView scanView6 = scanFragment.scanView;
                        if (scanView6 != null && scanView6.isShutterEnabled()) {
                            z = true;
                        }
                        imageButton2.setEnabled(z);
                    }
                    ImageButton imageButton3 = scanFragment.helpButton;
                    if (imageButton3 != null) {
                        imageButton3.setEnabled(true);
                    }
                    scanFragment.setupTooltip();
                    return;
                }
                return;
            case 3:
                scanFragment.scanAnimatorSet.cancel();
                scanFragment.scanAnimatorSet.removeAllListeners();
                ImageView imageView = scanFragment.animationIcon;
                if (imageView != null) {
                    BaseFragment.fadeAndScaleTo$default(scanFragment, imageView, 8, 0, 0, 6, (Object) null);
                }
                ImageView imageView2 = scanFragment.animationScrim;
                if (imageView2 != null) {
                    BaseFragment.fadeAndScaleTo$default(scanFragment, imageView2, 0, 0, 0, 6, (Object) null);
                }
                CircularProgressIndicator circularProgressIndicator2 = scanFragment.processingIndicator;
                if (circularProgressIndicator2 != null) {
                    circularProgressIndicator2.show();
                }
                ImageView imageView3 = scanFragment.animationScrim;
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.jumio_ic_scrim_circle);
                }
                scanFragment.enableButtons(false);
                scanFragment.cancelToolTip();
                scanFragment.setProgressText(R.string.jumio_id_scan_prompt_processing);
                return;
            case 4:
                CircularProgressIndicator circularProgressIndicator3 = scanFragment.processingIndicator;
                if (circularProgressIndicator3 != null) {
                    circularProgressIndicator3.hide();
                }
                ImageView imageView4 = scanFragment.animationIcon;
                if (imageView4 != null) {
                    imageView4.setRotationY(0.0f);
                }
                ImageView imageView5 = scanFragment.animationIcon;
                if (imageView5 != null) {
                    imageView5.setImageResource(R.drawable.jumio_ic_processing_success);
                }
                ImageView imageView6 = scanFragment.animationIcon;
                if (imageView6 != null) {
                    BaseFragment.fadeAndScaleTo$default(scanFragment, imageView6, 0, 0, 0, 6, (Object) null);
                }
                ImageView imageView7 = scanFragment.animationScrim;
                if (imageView7 != null) {
                    BaseFragment.fadeAndScaleTo$default(scanFragment, imageView7, 8, 0, 0, 6, (Object) null);
                    return;
                }
                return;
            case 5:
                CircularProgressIndicator circularProgressIndicator4 = scanFragment.processingIndicator;
                if (circularProgressIndicator4 != null) {
                    circularProgressIndicator4.hide();
                }
                ImageView imageView8 = scanFragment.animationIcon;
                if (imageView8 != null) {
                    imageView8.setImageResource(R.drawable.jumio_ic_processing_success);
                }
                ImageView imageView9 = scanFragment.animationIcon;
                if (imageView9 != null) {
                    BaseFragment.fadeAndScaleTo$default(scanFragment, imageView9, 0, 0, 0, 6, (Object) null);
                }
                ImageView imageView10 = scanFragment.animationScrim;
                if (imageView10 != null) {
                    BaseFragment.fadeAndScaleTo$default(scanFragment, imageView10, 8, 0, 0, 6, (Object) null);
                    return;
                }
                return;
            case 6:
                FragmentActivity activity = scanFragment.getActivity();
                if (activity != null && (k3 = scanFragment.getJumioViewModel().mo48k()) != null) {
                    new JumioActivityAttacher(activity).attach(k3);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: scanUpdateObserver$lambda-19  reason: not valid java name */
    public static final void m47580scanUpdateObserver$lambda19(ScanFragment scanFragment, Pair pair) {
        Context context;
        ScanFragment scanFragment2 = scanFragment;
        Intrinsics.checkNotNullParameter(scanFragment2, "this$0");
        JumioScanSide jumioScanSide = (JumioScanSide) pair.component2();
        int i = WhenMappings.$EnumSwitchMapping$1[((JumioScanUpdate) pair.component1()).ordinal()];
        if (i == 1) {
            ScanView scanView2 = scanFragment2.scanView;
            if (scanView2 != null) {
                scanView2.setExtraction(scanFragment.getJumioViewModel().mo62s());
            }
            if (scanFragment2.shouldShowLegalDialog(jumioScanSide) && (context = scanFragment.getContext()) != null) {
                scanFragment2.legalDialog = JumioDialog.create$default(JumioDialog.INSTANCE, context, 0, 0, (String) null, scanFragment.getJumioViewModel().mo63t(), new ScanFragment$scanUpdateObserver$1$1$1(scanFragment2), (JumioDialog.DialogAction) null, 78, (Object) null);
            }
        } else if (i == 2) {
            scanFragment2.setProgressText(scanFragment.getScanModePromptStringResource());
            ImageView imageView = scanFragment2.animationIcon;
            if ((imageView == null ? null : imageView.getTag()) == JumioScanMode.BARCODE) {
                ImageView imageView2 = scanFragment2.animationIcon;
                if (imageView2 != null) {
                    imageView2.setTag((Object) null);
                }
                ImageView imageView3 = scanFragment2.animationIcon;
                if (imageView3 != null) {
                    BaseFragment.fadeAndScaleTo$default(scanFragment, imageView3, 8, 0, 0, 6, (Object) null);
                }
                ImageView imageView4 = scanFragment2.animationScrim;
                if (imageView4 != null) {
                    BaseFragment.fadeAndScaleTo$default(scanFragment, imageView4, 8, 0, 0, 6, (Object) null);
                }
            }
            ScanView scanView3 = scanFragment2.scanView;
            int i2 = 8;
            if (scanView3 != null && scanView3.isShutterEnabled()) {
                ImageButton imageButton = scanFragment2.shutterButton;
                if (imageButton != null) {
                    imageButton.setVisibility(0);
                }
                ImageButton imageButton2 = scanFragment2.shutterButton;
                if (imageButton2 != null) {
                    imageButton2.setEnabled(true);
                }
            } else {
                ImageButton imageButton3 = scanFragment2.shutterButton;
                if (imageButton3 != null) {
                    imageButton3.setVisibility(8);
                }
            }
            C0010a jumioViewModel = scanFragment.getJumioViewModel();
            ImageButton imageButton4 = scanFragment2.shutterButton;
            if (imageButton4 != null) {
                i2 = imageButton4.getVisibility();
            }
            jumioViewModel.mo32b(i2);
        } else if (i == 3) {
            scanFragment.showAndEnableCameraSwitchIfAvailable();
        }
    }

    private final void setProgressText(int i) {
        AppCompatTextView appCompatTextView = this.progressChip;
        if (appCompatTextView != null) {
            appCompatTextView.setText(i);
            CharSequence text = appCompatTextView.getText();
            if (!(text == null || text.length() == 0)) {
                appCompatTextView.requestFocus();
                appCompatTextView.sendAccessibilityEvent(8);
                appCompatTextView.announceForAccessibility(appCompatTextView.getText());
            }
        }
    }

    private final void setupTooltip() {
        ImageButton imageButton = this.helpButton;
        if (imageButton != null) {
            TooltipCompat.setTooltipText(imageButton, getString(R.string.jumio_id_scan_tooltip));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    ScanFragment.m47581setupTooltip$lambda23(ScanFragment.this);
                }
            }, 10000);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: setupTooltip$lambda-23  reason: not valid java name */
    public static final void m47581setupTooltip$lambda23(ScanFragment scanFragment) {
        ImageButton imageButton;
        Intrinsics.checkNotNullParameter(scanFragment, "this$0");
        if (scanFragment.getJumioViewModel().mo67x().getValue() != JumioScanStep.SCAN_VIEW && scanFragment.bottomSheet == null && (imageButton = scanFragment.helpButton) != null) {
            imageButton.performLongClick();
        }
    }

    private final boolean shouldShowLegalDialog(JumioScanSide jumioScanSide) {
        if (jumioScanSide == null || getJumioViewModel().mo49l() != jumioScanSide || getJumioViewModel().mo62s()) {
            return false;
        }
        AlertDialog alertDialog = this.legalDialog;
        return !(alertDialog != null && alertDialog.isShowing());
    }

    private final void showAndEnableCameraSwitchIfAvailable() {
        ImageButton imageButton = this.cameraSwitchButton;
        boolean z = false;
        if (imageButton != null) {
            ScanView scanView2 = this.scanView;
            imageButton.setVisibility(scanView2 != null && scanView2.getHasMultipleCameras() ? 0 : 8);
        }
        ImageButton imageButton2 = this.cameraSwitchButton;
        if (imageButton2 != null) {
            ScanView scanView3 = this.scanView;
            if (scanView3 != null && scanView3.getHasMultipleCameras()) {
                z = true;
            }
            imageButton2.setEnabled(z);
        }
    }

    private final AnimatorSet showIconAndScrim(long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.animationIcon, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(50);
        ofFloat.setStartDelay(j);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.animationScrim, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(50);
        ofFloat2.setStartDelay(j);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public static /* synthetic */ AnimatorSet showIconAndScrim$default(ScanFragment scanFragment, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return scanFragment.showIconAndScrim(j);
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ScanView scanView2;
        ImageButton imageButton;
        ImageButton imageButton2;
        AppCompatTextView appCompatTextView;
        CircularProgressIndicator circularProgressIndicator;
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(LAYOUT, viewGroup, false);
        ImageButton imageButton3 = null;
        if (inflate == null) {
            scanView2 = null;
        } else {
            scanView2 = (ScanView) inflate.findViewById(R.id.scanView);
        }
        this.scanView = scanView2;
        if (scanView2 != null) {
            getViewLifecycleOwner().getLifecycle().addObserver(scanView2);
        }
        if (inflate == null) {
            imageButton = null;
        } else {
            imageButton = (ImageButton) inflate.findViewById(R.id.btn_help);
        }
        this.helpButton = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        if (inflate == null) {
            imageButton2 = null;
        } else {
            imageButton2 = (ImageButton) inflate.findViewById(R.id.btn_switchCamera);
        }
        this.cameraSwitchButton = imageButton2;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        if (inflate == null) {
            appCompatTextView = null;
        } else {
            appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.progressChip);
        }
        this.progressChip = appCompatTextView;
        if (inflate == null) {
            circularProgressIndicator = null;
        } else {
            circularProgressIndicator = (CircularProgressIndicator) inflate.findViewById(R.id.cpi_processing);
        }
        this.processingIndicator = circularProgressIndicator;
        if (inflate == null) {
            imageView = null;
        } else {
            imageView = (ImageView) inflate.findViewById(R.id.iv_animation_scrim);
        }
        this.animationScrim = imageView;
        if (inflate == null) {
            imageView2 = null;
        } else {
            imageView2 = (ImageView) inflate.findViewById(R.id.iv_animation_icon);
        }
        this.animationIcon = imageView2;
        if (inflate != null) {
            imageButton3 = (ImageButton) inflate.findViewById(R.id.btn_shutter);
        }
        this.shutterButton = imageButton3;
        if (imageButton3 != null) {
            imageButton3.setImageResource(R.drawable.jumio_shutter_button);
        }
        ImageButton imageButton4 = this.shutterButton;
        if (imageButton4 != null) {
            imageButton4.setContentDescription(getString(R.string.jumio_accessibility_scan_shutter_button));
        }
        ImageButton imageButton5 = this.shutterButton;
        if (imageButton5 != null) {
            imageButton5.setClickable(true);
        }
        ImageButton imageButton6 = this.shutterButton;
        if (imageButton6 != null) {
            imageButton6.setOnClickListener(this);
        }
        ImageButton imageButton7 = this.shutterButton;
        if (imageButton7 != null) {
            imageButton7.setVisibility(getJumioViewModel().mo4B());
        }
        this.initializedScanSide = String.valueOf(getJumioViewModel().mo49l());
        return inflate;
    }

    public void onClick(View view) {
        ScanView scanView2;
        FragmentManager supportFragmentManager;
        JumioBottomSheet jumioBottomSheet;
        AutoTrackHelper.trackViewOnClick(view);
        JumioScanMode jumioScanMode = null;
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.btn_help) {
            boolean z = true;
            getJumioViewModel().mo30a(true);
            JumioScanPart k = getJumioViewModel().mo48k();
            if (k != null) {
                jumioScanMode = k.getScanMode();
            }
            int i = jumioScanMode == null ? -1 : WhenMappings.$EnumSwitchMapping$2[jumioScanMode.ordinal()];
            int i2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? R.string.jumio_id_scan_tips_placing : R.string.jumio_id_scan_manual_tips : R.string.jumio_identity_scan_tips_placing : R.string.jumio_id_scan_tips_barcode : R.string.jumio_id_scan_tips_passport;
            JumioScanPart k2 = getJumioViewModel().mo48k();
            if (k2 == null || !k2.getHasFallback()) {
                z = false;
            }
            String string = z ? getString(R.string.jumio_id_scan_tips_button_fallback) : "";
            Intrinsics.checkNotNullExpressionValue(string, "if (jumioViewModel.curre…\t\t\t} else {\n\t\t\t\t\t\"\"\n\t\t\t\t}");
            HelpViewBottomSheet.Companion companion = HelpViewBottomSheet.Companion;
            String string2 = getString(R.string.jumio_id_scan_tips_title);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.jumio_id_scan_tips_title)");
            String generateTipsText = generateTipsText(i2);
            String string3 = getString(R.string.jumio_id_scan_tips_button_retry);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.jumio…d_scan_tips_button_retry)");
            this.bottomSheet = companion.newInstance(string2, generateTipsText, string3, string);
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (jumioBottomSheet = this.bottomSheet) != null) {
                jumioBottomSheet.show(supportFragmentManager, "dialog");
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_switchCamera) {
            ScanView scanView3 = this.scanView;
            if (scanView3 != null) {
                scanView3.switchCamera();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_shutter && (scanView2 = this.scanView) != null) {
            scanView2.takePicture();
        }
    }

    public void onDestroyView() {
        String str = TAG;
        Log.m39466i(str, "Scan fragment view " + hashCode() + ' ' + this.initializedScanSide + " destroyed");
        this.scanAnimatorSet.cancel();
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.setActionBarQuitIcon(R.drawable.jumio_ic_close);
        }
        new Handler(Looper.getMainLooper()).removeCallbacksAndMessages((Object) null);
        ScanView scanView2 = this.scanView;
        if (scanView2 != null) {
            getViewLifecycleOwner().getLifecycle().removeObserver(scanView2);
        }
        getJumioViewModel().mo68y().removeObserver(this.scanUpdateObserver);
        getJumioViewModel().mo67x().removeObserver(this.scanStepObserver);
        getJumioViewModel().mo59p().removeObserver(this.helpViewObserver);
        this.scanView = null;
        cancelToolTip();
        this.helpButton = null;
        this.cameraSwitchButton = null;
        this.progressChip = null;
        this.bottomSheet = null;
        this.shutterButton = null;
        this.animationScrim = null;
        this.animationIcon = null;
        this.processingIndicator = null;
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        String str = TAG;
        Log.m39466i(str, "Scan fragment " + hashCode() + ' ' + this.initializedScanSide + " paused");
    }

    public void onResume() {
        super.onResume();
        String str = TAG;
        Log.m39466i(str, "Scan fragment " + hashCode() + ' ' + this.initializedScanSide + " resumed");
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        C0010a jumioViewModel = getJumioViewModel();
        ImageButton imageButton = this.shutterButton;
        jumioViewModel.mo32b(imageButton == null ? 8 : imageButton.getVisibility());
    }

    public void onStart() {
        super.onStart();
        String str = TAG;
        Log.m39466i(str, "Scan fragment " + hashCode() + " side " + this.initializedScanSide + " onStart");
    }

    public void onStop() {
        super.onStop();
        String str = TAG;
        Log.m39466i(str, "Scan fragment " + hashCode() + ' ' + this.initializedScanSide + " stopped");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.setActionBarQuitIcon(R.drawable.jumio_ic_clear_white);
        }
        String str = TAG;
        Log.m39466i(str, "Scan fragment " + hashCode() + " side  " + this.initializedScanSide + " onViewCreated");
        initObservers();
    }

    private final String generateTipsText(int i) {
        return generateBulletPointList(i, R.string.jumio_id_scan_tips_focusing, R.string.jumio_id_scan_tips_lighting, R.string.jumio_id_scan_tips_glare);
    }
}
