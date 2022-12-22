package com.didiglobal.pay.paysecure.prepaidcard;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.pay.paysecure.prepaidcard.KeyboardUtil;
import com.didiglobal.pay.paysecure.prepaidcard.loading.LineLoading;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010%\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "cardId", "", "cardLoading", "Lcom/didiglobal/pay/paysecure/prepaidcard/loading/LineLoading;", "getCardLoading", "()Lcom/didiglobal/pay/paysecure/prepaidcard/loading/LineLoading;", "dismissListener", "Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$IDismissResult;", "encryptPassword", "Lcom/didiglobal/pay/paysecure/prepaidcard/EncryptPassword;", "getEncryptPassword", "()Lcom/didiglobal/pay/paysecure/prepaidcard/EncryptPassword;", "encryptPassword$delegate", "Lkotlin/Lazy;", "result", "", "scene", "sessionId", "source", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "setDismissListener", "Companion", "IDismissResult", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CommonPwdDialog.kt */
public final class CommonPwdDialog extends DialogFragment {
    public static final int CLOSE_DIALOG = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int VERIFY_FAILED = 0;
    public static final int VERIFY_SUCCESS = 1;

    /* renamed from: a */
    private IDismissResult f50354a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f50355b;

    /* renamed from: c */
    private final Lazy f50356c = LazyKt.lazy(CommonPwdDialog$encryptPassword$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f50357d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f50358e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f50359f = "";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f50360g = "";

    /* renamed from: h */
    private final LineLoading f50361h = new LineLoading();

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$IDismissResult;", "", "onDismissResult", "", "result", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: CommonPwdDialog.kt */
    public interface IDismissResult {
        void onDismissResult(int i);
    }

    public final EncryptPassword getEncryptPassword() {
        return (EncryptPassword) this.f50356c.getValue();
    }

    public final LineLoading getCardLoading() {
        return this.f50361h;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$Companion;", "", "()V", "CLOSE_DIALOG", "", "VERIFY_FAILED", "VERIFY_SUCCESS", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: CommonPwdDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dialog_common_pwd, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        Window window;
        Window window2;
        Window window3;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window3 = dialog.getWindow()) == null)) {
            window3.requestFeature(1);
        }
        super.onActivityCreated(bundle);
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window2 = dialog2.getWindow()) == null)) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null && (window = dialog3.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f50357d = arguments.getString(BaseCard.KEY_CARD_ID);
            this.f50358e = arguments.getString("source");
            this.f50359f = arguments.getString("scene");
            this.f50360g = arguments.getString("session_id");
        }
        CommonPwdEditView commonPwdEditView = (CommonPwdEditView) view.findViewById(R.id.pwd_view);
        View findViewById = view.findViewById(R.id.loading);
        ((ImageView) view.findViewById(R.id.iv_close)).setOnClickListener(new CommonPwdDialog$onViewCreated$2(this));
        ((TextView) view.findViewById(R.id.tv_tips)).setOnClickListener(new CommonPwdDialog$onViewCreated$3(this, findViewById));
        commonPwdEditView.setInputListener(new CommonPwdDialog$onViewCreated$4(this, findViewById, commonPwdEditView, (TextView) view.findViewById(R.id.tv_desc)));
        KeyboardUtil.Companion companion = KeyboardUtil.Companion;
        Intrinsics.checkExpressionValueIsNotNull(commonPwdEditView, "editView");
        KeyboardUtil.Companion.showKeyboard$default(companion, commonPwdEditView, 0, 2, (Object) null);
        TrackerManager.Companion.trackInputCardPwd();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkParameterIsNotNull(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        IDismissResult iDismissResult = this.f50354a;
        if (iDismissResult != null) {
            iDismissResult.onDismissResult(this.f50355b);
        }
    }

    public final void setDismissListener(IDismissResult iDismissResult) {
        this.f50354a = iDismissResult;
    }
}
