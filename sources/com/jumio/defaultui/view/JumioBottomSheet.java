package com.jumio.defaultui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.raven.config.RavenKey;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.jumio.core.util.DataDogHelper;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b0\u00101J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u000bH\u0014J\b\u0010\u0019\u001a\u00020\u000bH\u0014J&\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u0010/\u001a\u00020*8@@\u0000X\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u00063"}, mo175978d2 = {"Lcom/jumio/defaultui/view/JumioBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "Landroidx/core/widget/NestedScrollView;", "nestedScrollView", "", "updateScrollBarVisibility", "scrollView", "", "childHeight", "", "isScrollable", "Lcom/google/android/material/button/MaterialButton;", "button", "", "text", "initButton", "onPrimaryAction", "onSecondaryAction", "onDismiss", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "onStart", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onResume", "onPause", "v", "onClick", "Landroid/content/DialogInterface;", "dialog", "Landroid/widget/FrameLayout;", "rootView", "Landroid/widget/FrameLayout;", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel$jumio_defaultui_release", "()La/a;", "jumioViewModel", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioBottomSheet.kt */
public class JumioBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DESCRIPTION = "JUMIO_BUTTOM_SHEET_DESCRIPTION";
    public static final String PRIMARY_ACTION = "JUMIO_BUTTOM_SHEET_PRIMARY_ACTION";
    private static final float SCROLLVIEW_NO_SEC_BUTTON_HEIGHT_IN_PERCENT = 0.6f;
    public static final String SECONDARY_ACTION = "JUMIO_BUTTOM_SHEET_SECONDARY_ACTION";
    /* access modifiers changed from: private */
    public static final String TAG = JumioBottomSheet.class.getSimpleName();
    public static final String TITLE = "JUMIO_BUTTOM_SHEET_TITLE";
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new JumioBottomSheet$special$$inlined$activityViewModels$default$1(this), new JumioBottomSheet$special$$inlined$activityViewModels$default$2(this));
    private FrameLayout rootView;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0005¨\u0006\u0011"}, mo175978d2 = {"Lcom/jumio/defaultui/view/JumioBottomSheet$Companion;", "", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "DESCRIPTION", "PRIMARY_ACTION", "", "SCROLLVIEW_NO_SEC_BUTTON_HEIGHT_IN_PERCENT", "F", "SECONDARY_ACTION", "TITLE", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return JumioBottomSheet.TAG;
        }
    }

    private final View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        boolean z = false;
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_sheet_help, viewGroup, false);
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments == null ? null : arguments.getString(TITLE);
        String str2 = "";
        if (string == null) {
            string = str2;
        }
        Bundle arguments2 = getArguments();
        String string2 = arguments2 == null ? null : arguments2.getString(DESCRIPTION);
        if (string2 == null) {
            string2 = str2;
        }
        Bundle arguments3 = getArguments();
        String string3 = arguments3 == null ? null : arguments3.getString(PRIMARY_ACTION, str2);
        if (string3 == null) {
            string3 = str2;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            str = arguments4.getString(SECONDARY_ACTION, str2);
        }
        if (str != null) {
            str2 = str;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.tv_title);
        if (appCompatTextView != null) {
            if (string.length() == 0) {
                appCompatTextView.setVisibility(8);
            } else {
                appCompatTextView.setVisibility(0);
                appCompatTextView.setText(string);
            }
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) inflate.findViewById(R.id.tv_description);
        NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.tv_description_container);
        if (!(string2.length() == 0)) {
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(0);
            }
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(0);
            }
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(string2);
            }
        } else if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        updateScrollBarVisibility(nestedScrollView);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.btn_action_primary);
        if (materialButton != null) {
            initButton(materialButton, string3);
        }
        MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.btn_action_secondary);
        if (materialButton2 != null) {
            initButton(materialButton2, str2);
            if (str2.length() == 0) {
                z = true;
            }
            if (z) {
                materialButton2.setVisibility(8);
                if (nestedScrollView != null) {
                    ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
                    if (layoutParams != null) {
                        ((ConstraintLayout.LayoutParams) layoutParams).matchConstraintPercentHeight = SCROLLVIEW_NO_SEC_BUTTON_HEIGHT_IN_PERCENT;
                        nestedScrollView.requestLayout();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                }
            }
        }
        return inflate;
    }

    private final void initButton(MaterialButton materialButton, String str) {
        materialButton.setOnClickListener(this);
        materialButton.setSingleLine(false);
        materialButton.setMinLines(0);
        materialButton.setText(str);
    }

    private final boolean isScrollable(NestedScrollView nestedScrollView, int i) {
        return nestedScrollView.getHeight() < (i + nestedScrollView.getPaddingTop()) + nestedScrollView.getPaddingBottom();
    }

    private final void updateScrollBarVisibility(NestedScrollView nestedScrollView) {
        if (nestedScrollView != null) {
            nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
                public final /* synthetic */ JumioBottomSheet f$1;

                {
                    this.f$1 = r2;
                }

                public final void onGlobalLayout() {
                    JumioBottomSheet.m47569updateScrollBarVisibility$lambda8$lambda7(NestedScrollView.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateScrollBarVisibility$lambda-8$lambda-7  reason: not valid java name */
    public static final void m47569updateScrollBarVisibility$lambda8$lambda7(NestedScrollView nestedScrollView, JumioBottomSheet jumioBottomSheet) {
        Intrinsics.checkNotNullParameter(nestedScrollView, "$it");
        Intrinsics.checkNotNullParameter(jumioBottomSheet, "this$0");
        View childAt = nestedScrollView.getChildAt(0);
        if (childAt != null && jumioBottomSheet.isScrollable(nestedScrollView, childAt.getHeight())) {
            nestedScrollView.setScrollbarFadingEnabled(false);
            nestedScrollView.setScrollBarFadeDuration(0);
        }
    }

    public final C0010a getJumioViewModel$jumio_defaultui_release() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkNotNullParameter(view, RavenKey.VERSION);
        if (view.getId() == R.id.btn_action_primary) {
            onPrimaryAction();
            dismiss();
        } else if (view.getId() == R.id.btn_action_secondary) {
            onSecondaryAction();
            dismiss();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        FrameLayout frameLayout = this.rootView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.rootView;
        if (frameLayout2 != null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
            frameLayout2.addView(createLayout(layoutInflater, this.rootView));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = getContext();
        if (context == null) {
            frameLayout = null;
        } else {
            FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout2.addView(createLayout(layoutInflater, frameLayout2));
            frameLayout = frameLayout2;
        }
        this.rootView = frameLayout;
        return frameLayout;
    }

    public void onDismiss() {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        onDismiss();
    }

    public void onPause() {
        super.onPause();
        DataDogHelper.INSTANCE.reportViewStop(this);
    }

    public void onPrimaryAction() {
    }

    public void onResume() {
        super.onResume();
        DataDogHelper.INSTANCE.reportViewStart(this);
    }

    public void onSecondaryAction() {
    }

    public void onStart() {
        super.onStart();
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) getDialog();
        if (bottomSheetDialog != null) {
            bottomSheetDialog.getBehavior().setState(3);
            bottomSheetDialog.getBehavior().setFitToContents(true);
            bottomSheetDialog.setCancelable(true);
            bottomSheetDialog.setDismissWithAnimation(true);
            View view = getView();
            if (view != null) {
                view.requestLayout();
            }
        }
    }
}
