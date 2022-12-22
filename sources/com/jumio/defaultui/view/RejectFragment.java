package com.jumio.defaultui.view;

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
import com.jumio.sdk.views.JumioRejectView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000bH\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006-"}, mo175978d2 = {"Lcom/jumio/defaultui/view/RejectFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "Landroid/view/View$OnClickListener;", "", "retakeImage", "", "reason", "updateUiWithReason", "", "titleResId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tipIds", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onStart", "onDestroyView", "v", "onClick", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "Lcom/jumio/sdk/views/JumioRejectView;", "rejectView", "Lcom/jumio/sdk/views/JumioRejectView;", "Lcom/google/android/material/button/MaterialButton;", "rejectButton", "Lcom/google/android/material/button/MaterialButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "descriptionTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "tipsTextView", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: RejectFragment.kt */
public final class RejectFragment extends BaseFragment implements View.OnClickListener {
    private AppCompatTextView descriptionTextView;
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new RejectFragment$special$$inlined$activityViewModels$default$1(this), new RejectFragment$special$$inlined$activityViewModels$default$2(this));
    private MaterialButton rejectButton;
    private JumioRejectView rejectView;
    private AppCompatTextView tipsTextView;

    /* access modifiers changed from: private */
    public final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void retakeImage() {
        JumioRejectView jumioRejectView = this.rejectView;
        if (jumioRejectView != null) {
            jumioRejectView.retake();
        }
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.retakeImage();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        if (r6.equals("2004") == false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005f, code lost:
        if (r6.equals("2003") == false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        r6 = com.taxis99.R.string.jumio_error_instant_feedback_missing_part_doc_title;
        r0.add(java.lang.Integer.valueOf(com.taxis99.R.string.jumio_error_instant_feedback_no_doc_tip_whole_document));
        r0.add(java.lang.Integer.valueOf(com.taxis99.R.string.jumio_error_instant_feedback_no_doc_tip_hand));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateUiWithReason(java.lang.String r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r6 == 0) goto L_0x0155
            int r1 = r6.hashCode()
            r2 = 2131955905(0x7f1310c1, float:1.954835E38)
            r3 = 2131955906(0x7f1310c2, float:1.9548353E38)
            r4 = 2131955901(0x7f1310bd, float:1.9548343E38)
            switch(r1) {
                case 48627: goto L_0x0137;
                case 48628: goto L_0x0123;
                case 48629: goto L_0x010f;
                case 49586: goto L_0x00ea;
                case 49587: goto L_0x00d1;
                case 49592: goto L_0x00b8;
                case 49621: goto L_0x009f;
                case 1537215: goto L_0x007c;
                case 1537217: goto L_0x0059;
                case 1537218: goto L_0x004f;
                case 1537219: goto L_0x0036;
                case 1537220: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0155
        L_0x0019:
            java.lang.String r1 = "2006"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0023
            goto L_0x0155
        L_0x0023:
            r6 = 2131955907(0x7f1310c3, float:1.9548355E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.add(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.add(r1)
            goto L_0x0162
        L_0x0036:
            java.lang.String r1 = "2005"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0040
            goto L_0x0155
        L_0x0040:
            r6 = 2131955900(0x7f1310bc, float:1.954834E38)
            r1 = 2131955899(0x7f1310bb, float:1.9548338E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x004f:
            java.lang.String r1 = "2004"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0063
            goto L_0x0155
        L_0x0059:
            java.lang.String r1 = "2003"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0063
            goto L_0x0155
        L_0x0063:
            r6 = 2131955912(0x7f1310c8, float:1.9548365E38)
            r1 = 2131955915(0x7f1310cb, float:1.954837E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            r1 = 2131955914(0x7f1310ca, float:1.9548369E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x007c:
            java.lang.String r1 = "2001"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0086
            goto L_0x0155
        L_0x0086:
            r6 = 2131955895(0x7f1310b7, float:1.954833E38)
            r1 = 2131955893(0x7f1310b5, float:1.9548326E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            r1 = 2131955894(0x7f1310b6, float:1.9548328E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x009f:
            java.lang.String r1 = "214"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00a9
            goto L_0x0155
        L_0x00a9:
            r6 = 2131955911(0x7f1310c7, float:1.9548363E38)
            r1 = 2131955910(0x7f1310c6, float:1.954836E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x00b8:
            java.lang.String r1 = "206"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00c2
            goto L_0x0155
        L_0x00c2:
            r6 = 2131955909(0x7f1310c5, float:1.9548359E38)
            r1 = 2131955908(0x7f1310c4, float:1.9548357E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x00d1:
            java.lang.String r1 = "201"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00db
            goto L_0x0155
        L_0x00db:
            r6 = 2131955916(0x7f1310cc, float:1.9548373E38)
            r1 = 2131955913(0x7f1310c9, float:1.9548367E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x00ea:
            java.lang.String r1 = "200"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x00f3
            goto L_0x0155
        L_0x00f3:
            r6 = 2131955917(0x7f1310cd, float:1.9548375E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.add(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.add(r1)
            r1 = 2131955892(0x7f1310b4, float:1.9548324E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x010f:
            java.lang.String r1 = "104"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0118
            goto L_0x0155
        L_0x0118:
            r6 = 2131955902(0x7f1310be, float:1.9548345E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r0.add(r1)
            goto L_0x0162
        L_0x0123:
            java.lang.String r1 = "103"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x012c
            goto L_0x0155
        L_0x012c:
            r6 = 2131955898(0x7f1310ba, float:1.9548336E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r0.add(r1)
            goto L_0x0162
        L_0x0137:
            java.lang.String r1 = "102"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0140
            goto L_0x0155
        L_0x0140:
            r6 = 2131955897(0x7f1310b9, float:1.9548334E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r0.add(r1)
            r1 = 2131955896(0x7f1310b8, float:1.9548332E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L_0x0162
        L_0x0155:
            r6 = 2131955904(0x7f1310c0, float:1.9548349E38)
            r1 = 2131955903(0x7f1310bf, float:1.9548347E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
        L_0x0162:
            r5.updateUiWithReason(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.RejectFragment.updateUiWithReason(java.lang.String):void");
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_reject, viewGroup, false);
        this.rejectView = (JumioRejectView) inflate.findViewById(R.id.reject_fragment_reject_view);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.reject_fragment_retry_button);
        this.rejectButton = materialButton;
        if (materialButton != null) {
            materialButton.setOnClickListener(this);
        }
        this.descriptionTextView = (AppCompatTextView) inflate.findViewById(R.id.reject_fragment_details_description);
        this.tipsTextView = (AppCompatTextView) inflate.findViewById(R.id.reject_fragment_details_tips);
        MaterialButton materialButton2 = this.rejectButton;
        if (materialButton2 != null) {
            materialButton2.setVisibility(0);
        }
        JumioRejectView jumioRejectView = this.rejectView;
        if (jumioRejectView != null) {
            AppCompatTextView appCompatTextView = this.descriptionTextView;
            jumioRejectView.setContentDescription(appCompatTextView == null ? null : appCompatTextView.getText());
        }
        String i = getJumioViewModel().mo46i();
        if (i != null) {
            updateUiWithReason(i);
        }
        return inflate;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == R.id.reject_fragment_retry_button) {
            retakeImage();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.rejectView = null;
        this.rejectButton = null;
        this.descriptionTextView = null;
        this.tipsTextView = null;
    }

    public void onStart() {
        JumioRejectView jumioRejectView;
        super.onStart();
        JumioScanPart k = getJumioViewModel().mo48k();
        if (k != null && (jumioRejectView = this.rejectView) != null) {
            jumioRejectView.attach(k);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback(getViewLifecycleOwner(), new RejectFragment$onViewCreated$1(this));
        }
    }

    private final void updateUiWithReason(int i, ArrayList<Integer> arrayList) {
        AppCompatTextView appCompatTextView = this.descriptionTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setText(getString(i));
        }
        AppCompatTextView appCompatTextView2 = this.tipsTextView;
        if (appCompatTextView2 != null) {
            int[] intArray = CollectionsKt.toIntArray(arrayList);
            appCompatTextView2.setText(generateBulletPointList(Arrays.copyOf(intArray, intArray.length)));
        }
    }
}
