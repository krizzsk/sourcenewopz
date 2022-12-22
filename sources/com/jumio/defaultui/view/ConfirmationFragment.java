package com.jumio.defaultui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.material.button.MaterialButton;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioConfirmationView;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006&"}, mo175978d2 = {"Lcom/jumio/defaultui/view/ConfirmationFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "Landroid/view/View$OnClickListener;", "", "retakeImage", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onStart", "onDestroyView", "v", "onClick", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "Lcom/jumio/sdk/views/JumioConfirmationView;", "confirmationView", "Lcom/jumio/sdk/views/JumioConfirmationView;", "Lcom/google/android/material/button/MaterialButton;", "confirmButton", "Lcom/google/android/material/button/MaterialButton;", "retakeButton", "Landroidx/appcompat/widget/AppCompatTextView;", "title", "Landroidx/appcompat/widget/AppCompatTextView;", "description", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ConfirmationFragment.kt */
public final class ConfirmationFragment extends BaseFragment implements View.OnClickListener {
    private MaterialButton confirmButton;
    private JumioConfirmationView confirmationView;
    private AppCompatTextView description;
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new C20065x200e0e3b(this), new C20066x200e0e3c(this));
    private MaterialButton retakeButton;
    private AppCompatTextView title;

    /* access modifiers changed from: private */
    public final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void retakeImage() {
        JumioConfirmationView jumioConfirmationView = this.confirmationView;
        if (jumioConfirmationView != null) {
            jumioConfirmationView.retake();
        }
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.retakeImage();
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_confirmation, viewGroup, false);
        this.confirmationView = (JumioConfirmationView) inflate.findViewById(R.id.confirmationView);
        this.confirmButton = (MaterialButton) inflate.findViewById(R.id.confirmationPositiveButton);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.confirmationNegativeButton);
        this.retakeButton = materialButton;
        for (MaterialButton materialButton2 : CollectionsKt.listOf(this.confirmButton, materialButton)) {
            if (materialButton2 != null) {
                materialButton2.setOnClickListener(this);
            }
        }
        this.title = (AppCompatTextView) inflate.findViewById(R.id.confirmationTitle);
        this.description = (AppCompatTextView) inflate.findViewById(R.id.confirmationDescription);
        MaterialButton materialButton3 = this.confirmButton;
        if (materialButton3 != null) {
            materialButton3.setVisibility(0);
        }
        MaterialButton materialButton4 = this.retakeButton;
        if (materialButton4 != null) {
            materialButton4.setVisibility(0);
        }
        AppCompatTextView appCompatTextView = this.title;
        CharSequence charSequence = null;
        if (appCompatTextView != null) {
            Context context = getContext();
            appCompatTextView.setText(context == null ? null : context.getString(R.string.jumio_id_confirm_title));
        }
        JumioConfirmationView jumioConfirmationView = this.confirmationView;
        if (jumioConfirmationView != null) {
            AppCompatTextView appCompatTextView2 = this.description;
            if (appCompatTextView2 != null) {
                charSequence = appCompatTextView2.getText();
            }
            jumioConfirmationView.setContentDescription(charSequence);
        }
        return inflate;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.confirmationPositiveButton) {
            JumioConfirmationView jumioConfirmationView = this.confirmationView;
            if (jumioConfirmationView != null) {
                jumioConfirmationView.confirm();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.confirmationNegativeButton) {
            retakeImage();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.confirmationView = null;
        this.confirmButton = null;
        this.retakeButton = null;
        this.title = null;
        this.description = null;
    }

    public void onStart() {
        JumioConfirmationView jumioConfirmationView;
        super.onStart();
        JumioScanPart k = getJumioViewModel().mo48k();
        if (k != null && (jumioConfirmationView = this.confirmationView) != null) {
            jumioConfirmationView.attach(k);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback(getViewLifecycleOwner(), new ConfirmationFragment$onViewCreated$1(this));
        }
    }
}
