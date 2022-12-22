package com.didiglobal.pay.paysecure.prepaidcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001aB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/BottomDialog;", "Landroidx/fragment/app/DialogFragment;", "title", "", "listener", "Lcom/didiglobal/pay/paysecure/prepaidcard/BottomDialog$IClickListener;", "(Ljava/lang/String;Lcom/didiglobal/pay/paysecure/prepaidcard/BottomDialog$IClickListener;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "tvConfirm", "Landroid/widget/TextView;", "tvTitle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "IClickListener", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BottomDialog.kt */
public final class BottomDialog extends DialogFragment {

    /* renamed from: a */
    private TextView f50328a;

    /* renamed from: b */
    private TextView f50329b;

    /* renamed from: c */
    private String f50330c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IClickListener f50331d;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/BottomDialog$IClickListener;", "", "onClick", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BottomDialog.kt */
    public interface IClickListener {
        void onClick();
    }

    public BottomDialog(String str, IClickListener iClickListener) {
        this.f50330c = str;
        this.f50331d = iClickListener;
    }

    public final String getTitle() {
        return this.f50330c;
    }

    public final void setTitle(String str) {
        this.f50330c = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 2132017496);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dialog_bottom, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.tv_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.tv_title)");
        this.f50329b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_confirm);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.tv_confirm)");
        this.f50328a = (TextView) findViewById2;
        TextView textView = this.f50329b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        textView.setText(this.f50330c);
        TextView textView2 = this.f50328a;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
        }
        textView2.setOnClickListener(new BottomDialog$onViewCreated$1(this));
    }
}
