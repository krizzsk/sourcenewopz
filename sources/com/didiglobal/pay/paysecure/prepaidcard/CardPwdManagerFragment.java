package com.didiglobal.pay.paysecure.prepaidcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.pay.paysecure.prepaidcard.KeyboardUtil;
import com.didiglobal.pay.paysecure.prepaidcard.loading.LineLoading;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.DefaultCardPwdUI;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.ICardPwdUI;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bJ&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\bH\u0016J\u001e\u0010D\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020@0FH\u0016J\u001a\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u0002082\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010I\u001a\u00020@H\u0016J\b\u0010J\u001a\u00020@H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\fR\u001c\u0010$\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\fR\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000200X.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000200X.¢\u0006\u0002\n\u0000¨\u0006K"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CardPwdManagerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/didiglobal/pay/paysecure/prepaidcard/IPasswordCallback;", "Lcom/didiglobal/pay/paysecure/prepaidcard/IConfirmLoading;", "pwdUI", "Lcom/didiglobal/pay/paysecure/prepaidcard/ui/ICardPwdUI;", "(Lcom/didiglobal/pay/paysecure/prepaidcard/ui/ICardPwdUI;)V", "cardId", "", "getCardId", "()Ljava/lang/String;", "setCardId", "(Ljava/lang/String;)V", "cardLoading", "Lcom/didiglobal/pay/paysecure/prepaidcard/loading/LineLoading;", "getCardLoading", "()Lcom/didiglobal/pay/paysecure/prepaidcard/loading/LineLoading;", "editView", "Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdEditView;", "encryptPassword", "Lcom/didiglobal/pay/paysecure/prepaidcard/EncryptPassword;", "getEncryptPassword", "()Lcom/didiglobal/pay/paysecure/prepaidcard/EncryptPassword;", "encryptPassword$delegate", "Lkotlin/Lazy;", "oldPwd", "getOldPwd", "setOldPwd", "pwdMatch", "", "getPwdUI", "()Lcom/didiglobal/pay/paysecure/prepaidcard/ui/ICardPwdUI;", "setPwdUI", "scene", "getScene", "setScene", "sessionId", "getSessionId", "setSessionId", "titleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "getTitleBar", "()Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "setTitleBar", "(Lcom/didi/sdk/view/titlebar/CommonTitleBar;)V", "tvConfirm", "Lcom/didiglobal/pay/paysecure/prepaidcard/CommonLoadingTVButton;", "tvDesc", "Landroid/widget/TextView;", "tvStep", "tvTips", "tvTitle", "checkPwdRule", "", "pwd", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFail", "", "index", "", "msg", "onSuccess", "callback", "Lkotlin/Function0;", "onViewCreated", "view", "startLoading", "stopLoading", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CardPwdManagerFragment.kt */
public final class CardPwdManagerFragment extends Fragment implements IConfirmLoading, IPasswordCallback {

    /* renamed from: a */
    private TextView f50335a;

    /* renamed from: b */
    private TextView f50336b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f50337c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CommonLoadingTVButton f50338d;

    /* renamed from: e */
    private TextView f50339e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CommonPwdEditView f50340f;

    /* renamed from: g */
    private String f50341g;

    /* renamed from: h */
    private String f50342h;

    /* renamed from: i */
    private String f50343i;

    /* renamed from: j */
    private String f50344j;

    /* renamed from: k */
    private final Lazy f50345k;

    /* renamed from: l */
    private List<String> f50346l;

    /* renamed from: m */
    private final LineLoading f50347m;

    /* renamed from: n */
    private ICardPwdUI f50348n;
    public CommonTitleBar titleBar;

    public CardPwdManagerFragment() {
        this((ICardPwdUI) null, 1, (DefaultConstructorMarker) null);
    }

    public final EncryptPassword getEncryptPassword() {
        return (EncryptPassword) this.f50345k.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardPwdManagerFragment(ICardPwdUI iCardPwdUI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultCardPwdUI() : iCardPwdUI);
    }

    public static final /* synthetic */ CommonPwdEditView access$getEditView$p(CardPwdManagerFragment cardPwdManagerFragment) {
        CommonPwdEditView commonPwdEditView = cardPwdManagerFragment.f50340f;
        if (commonPwdEditView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editView");
        }
        return commonPwdEditView;
    }

    public static final /* synthetic */ CommonLoadingTVButton access$getTvConfirm$p(CardPwdManagerFragment cardPwdManagerFragment) {
        CommonLoadingTVButton commonLoadingTVButton = cardPwdManagerFragment.f50338d;
        if (commonLoadingTVButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
        }
        return commonLoadingTVButton;
    }

    public static final /* synthetic */ TextView access$getTvDesc$p(CardPwdManagerFragment cardPwdManagerFragment) {
        TextView textView = cardPwdManagerFragment.f50337c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
        }
        return textView;
    }

    public final ICardPwdUI getPwdUI() {
        return this.f50348n;
    }

    public final void setPwdUI(ICardPwdUI iCardPwdUI) {
        Intrinsics.checkParameterIsNotNull(iCardPwdUI, "<set-?>");
        this.f50348n = iCardPwdUI;
    }

    public CardPwdManagerFragment(ICardPwdUI iCardPwdUI) {
        Intrinsics.checkParameterIsNotNull(iCardPwdUI, "pwdUI");
        this.f50348n = iCardPwdUI;
        this.f50341g = "";
        this.f50342h = "";
        this.f50343i = PrepaidConstant.SCENE_SET_PASSWORD;
        this.f50344j = "";
        this.f50345k = LazyKt.lazy(CardPwdManagerFragment$encryptPassword$2.INSTANCE);
        List<String> arrayList = new ArrayList<>();
        arrayList.add("([0-9])\\1{3}");
        arrayList.add("(0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){3}\\d");
        this.f50346l = arrayList;
        this.f50347m = new LineLoading();
    }

    public final CommonTitleBar getTitleBar() {
        CommonTitleBar commonTitleBar = this.titleBar;
        if (commonTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        }
        return commonTitleBar;
    }

    public final void setTitleBar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkParameterIsNotNull(commonTitleBar, "<set-?>");
        this.titleBar = commonTitleBar;
    }

    public final String getCardId() {
        return this.f50341g;
    }

    public final void setCardId(String str) {
        this.f50341g = str;
    }

    public final String getSessionId() {
        return this.f50342h;
    }

    public final void setSessionId(String str) {
        this.f50342h = str;
    }

    public final String getScene() {
        return this.f50343i;
    }

    public final void setScene(String str) {
        this.f50343i = str;
    }

    public final String getOldPwd() {
        return this.f50344j;
    }

    public final void setOldPwd(String str) {
        this.f50344j = str;
    }

    public final LineLoading getCardLoading() {
        return this.f50347m;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_card_pwd_manager, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.tv_step);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.tv_step)");
        this.f50335a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.tv_title)");
        this.f50336b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_desc);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.tv_desc)");
        this.f50337c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_confirm);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById(R.id.tv_confirm)");
        this.f50338d = (CommonLoadingTVButton) findViewById4;
        View findViewById5 = view.findViewById(R.id.edit_pwd);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "view.findViewById(R.id.edit_pwd)");
        this.f50340f = (CommonPwdEditView) findViewById5;
        View findViewById6 = view.findViewById(R.id.title_bar);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "view.findViewById(R.id.title_bar)");
        this.titleBar = (CommonTitleBar) findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_tips);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "view.findViewById(R.id.tv_tips)");
        this.f50339e = (TextView) findViewById7;
        CommonTitleBar commonTitleBar = this.titleBar;
        if (commonTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        }
        commonTitleBar.setLeftImage((int) R.drawable.ic_pay_secure_back, (View.OnClickListener) new CardPwdManagerFragment$onViewCreated$1(this));
        this.f50348n.initData();
        TextView textView = this.f50335a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvStep");
        }
        textView.setText(this.f50348n.getStepText(getContext()));
        CommonLoadingTVButton commonLoadingTVButton = this.f50338d;
        if (commonLoadingTVButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
        }
        boolean isShowConfirmBtn = this.f50348n.isShowConfirmBtn();
        int i2 = 8;
        if (!isShowConfirmBtn) {
            i = 8;
        } else if (isShowConfirmBtn) {
            CommonLoadingTVButton commonLoadingTVButton2 = this.f50338d;
            if (commonLoadingTVButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
            }
            commonLoadingTVButton2.setEnabled(false);
            CommonLoadingTVButton commonLoadingTVButton3 = this.f50338d;
            if (commonLoadingTVButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
            }
            commonLoadingTVButton3.setOnClickListener(new CardPwdManagerFragment$onViewCreated$2(this));
            i = 0;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        commonLoadingTVButton.setVisibility(i);
        TextView textView2 = this.f50339e;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTips");
        }
        if (this.f50348n.getID() == 4) {
            TextView textView3 = this.f50339e;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTips");
            }
            textView3.setOnClickListener(new CardPwdManagerFragment$onViewCreated$3(this));
            i2 = 0;
        }
        textView2.setVisibility(i2);
        CommonPwdEditView commonPwdEditView = this.f50340f;
        if (commonPwdEditView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editView");
        }
        commonPwdEditView.setInputMode(this.f50348n.isShowLaws() ? 1 : 0);
        CommonPwdEditView commonPwdEditView2 = this.f50340f;
        if (commonPwdEditView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editView");
        }
        commonPwdEditView2.setInputListener(new CardPwdManagerFragment$onViewCreated$4(this));
        TextView textView4 = this.f50336b;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        textView4.setText(this.f50348n.getTitle(getContext()));
        TextView textView5 = this.f50337c;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
        }
        textView5.setText(this.f50348n.getSubTitle(getContext()));
        Bundle arguments = getArguments();
        String str = null;
        this.f50341g = arguments != null ? arguments.getString(BaseCard.KEY_CARD_ID) : null;
        Bundle arguments2 = getArguments();
        this.f50342h = arguments2 != null ? arguments2.getString("session_id") : null;
        Bundle arguments3 = getArguments();
        this.f50343i = arguments3 != null ? arguments3.getString("scene") : null;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            str = arguments4.getString("pwd");
        }
        this.f50344j = str;
        KeyboardUtil.Companion companion = KeyboardUtil.Companion;
        CommonPwdEditView commonPwdEditView3 = this.f50340f;
        if (commonPwdEditView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editView");
        }
        KeyboardUtil.Companion.showKeyboard$default(companion, commonPwdEditView3, 0, 2, (Object) null);
    }

    public void onSuccess(int i, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        if (i == 3 || i == 6) {
            CommonLoadingTVButton commonLoadingTVButton = this.f50338d;
            if (commonLoadingTVButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
            }
            commonLoadingTVButton.setEnabled(true);
        } else {
            CommonPwdEditView commonPwdEditView = this.f50340f;
            if (commonPwdEditView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editView");
            }
            commonPwdEditView.reset(function0);
        }
        TextView textView = this.f50337c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDesc");
        }
        CommonPwdEditView commonPwdEditView2 = this.f50340f;
        if (commonPwdEditView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editView");
        }
        textView.setTextColor(ContextCompat.getColor(commonPwdEditView2.getContext(), R.color.color_000000));
    }

    public void onFail(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        CommonPwdEditView commonPwdEditView = this.f50340f;
        if (commonPwdEditView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editView");
        }
        commonPwdEditView.showError(new CardPwdManagerFragment$onFail$1(this, str));
        KeyboardUtil.Companion companion = KeyboardUtil.Companion;
        CommonPwdEditView commonPwdEditView2 = this.f50340f;
        if (commonPwdEditView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editView");
        }
        companion.showKeyboard(commonPwdEditView2, 500);
    }

    public static /* synthetic */ boolean checkPwdRule$default(CardPwdManagerFragment cardPwdManagerFragment, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return cardPwdManagerFragment.checkPwdRule(str, str2);
    }

    public final boolean checkPwdRule(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "pwd");
        CharSequence charSequence = str;
        if (!Pattern.compile("^\\d{4}$").matcher(charSequence).find()) {
            return false;
        }
        if (str2 != null && Intrinsics.areEqual((Object) str, (Object) str2)) {
            return false;
        }
        for (String compile : this.f50346l) {
            if (Pattern.compile(compile).matcher(charSequence).find()) {
                return false;
            }
        }
        return true;
    }

    public void startLoading() {
        CommonLoadingTVButton commonLoadingTVButton = this.f50338d;
        if (commonLoadingTVButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
        }
        commonLoadingTVButton.startLoading();
    }

    public void stopLoading() {
        CommonLoadingTVButton commonLoadingTVButton = this.f50338d;
        if (commonLoadingTVButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
        }
        commonLoadingTVButton.stopLoading();
    }
}
