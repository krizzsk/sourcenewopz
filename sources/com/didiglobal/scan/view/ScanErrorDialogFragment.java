package com.didiglobal.scan.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/scan/view/ScanErrorDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "clickCallBack", "Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ClickCallBack;", "errorText", "Landroid/widget/TextView;", "retry", "initData", "", "initListener", "initView", "view", "Landroid/view/View;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "setCallBack", "callback", "ClickCallBack", "Companion", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ScanErrorDialogFragment.kt */
public final class ScanErrorDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_MSG = "key_msg";

    /* renamed from: a */
    private TextView f51366a;

    /* renamed from: b */
    private TextView f51367b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ClickCallBack f51368c;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ClickCallBack;", "", "onClick", "", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ScanErrorDialogFragment.kt */
    public interface ClickCallBack {
        void onClick();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/scan/view/ScanErrorDialogFragment$Companion;", "", "()V", "KEY_MSG", "", "show", "", "errorMsg", "manager", "Landroidx/fragment/app/FragmentManager;", "callback", "Lcom/didiglobal/scan/view/ScanErrorDialogFragment$ClickCallBack;", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ScanErrorDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void show$default(Companion companion, String str, FragmentManager fragmentManager, ClickCallBack clickCallBack, int i, Object obj) {
            if ((i & 4) != 0) {
                clickCallBack = null;
            }
            companion.show(str, fragmentManager, clickCallBack);
        }

        public final void show(String str, FragmentManager fragmentManager, ClickCallBack clickCallBack) {
            Intrinsics.checkParameterIsNotNull(str, "errorMsg");
            Intrinsics.checkParameterIsNotNull(fragmentManager, "manager");
            try {
                ScanErrorDialogFragment scanErrorDialogFragment = new ScanErrorDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key_msg", str);
                scanErrorDialogFragment.setArguments(bundle);
                scanErrorDialogFragment.setCallBack(clickCallBack);
                scanErrorDialogFragment.show(fragmentManager, "ScanErrorDialogFragment");
            } catch (Exception unused) {
            }
        }
    }

    public final void setCallBack(ClickCallBack clickCallBack) {
        this.f51368c = clickCallBack;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r2 = r2.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.os.Bundle r2) {
        /*
            r1 = this;
            super.onActivityCreated(r2)
            android.app.Dialog r2 = r1.getDialog()
            if (r2 == 0) goto L_0x0014
            android.view.Window r2 = r2.getWindow()
            if (r2 == 0) goto L_0x0014
            android.view.WindowManager$LayoutParams r2 = r2.getAttributes()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            r0 = -1
            if (r2 == 0) goto L_0x001a
            r2.width = r0
        L_0x001a:
            if (r2 == 0) goto L_0x001e
            r2.height = r0
        L_0x001e:
            android.app.Dialog r0 = r1.getDialog()
            if (r0 == 0) goto L_0x002d
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x002d
            r0.setAttributes(r2)
        L_0x002d:
            android.app.Dialog r2 = r1.getDialog()
            if (r2 == 0) goto L_0x003f
            android.view.Window r2 = r2.getWindow()
            if (r2 == 0) goto L_0x003f
            r0 = 2131233491(0x7f080ad3, float:1.808312E38)
            r2.setBackgroundDrawableResource(r0)
        L_0x003f:
            android.app.Dialog r2 = r1.getDialog()
            if (r2 == 0) goto L_0x0049
            r0 = 0
            r2.setCanceledOnTouchOutside(r0)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.scan.view.ScanErrorDialogFragment.onActivityCreated(android.os.Bundle):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_dialog_scan_error, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        m36779a(view);
        m36778a();
        m36780b();
    }

    /* renamed from: a */
    private final void m36779a(View view) {
        this.f51366a = (TextView) view.findViewById(R.id.errorMsg);
        this.f51367b = (TextView) view.findViewById(R.id.retry);
    }

    /* renamed from: a */
    private final void m36778a() {
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("key_msg")) == null) {
            str = ResourcesHelper.getString(getContext(), R.string.Finance_LightSpeedPC_Identification_failed_wKuB);
        }
        TextView textView = this.f51366a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: b */
    private final void m36780b() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new ScanErrorDialogFragment$initListener$1());
        }
        TextView textView = this.f51367b;
        if (textView != null) {
            textView.setOnClickListener(new ScanErrorDialogFragment$initListener$2(this));
        }
    }
}
