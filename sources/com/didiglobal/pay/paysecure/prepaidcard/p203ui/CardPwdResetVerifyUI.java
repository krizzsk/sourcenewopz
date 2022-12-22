package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManagerFragment;
import com.didiglobal.pay.paysecure.prepaidcard.EncryptPassword;
import com.didiglobal.pay.paysecure.prepaidcard.IPasswordCallback;
import com.didiglobal.pay.paysecure.prepaidcard.TrackerManager;
import com.didiglobal.pay.paysecure.prepaidcard.loading.ILoading;
import com.didiglobal.pay.paysecure.prepaidcard.loading.LineLoading;
import com.didiglobal.pay.paysecure.prepaidcard.net.PrepaidCardRequest;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J$\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0016"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/ui/CardPwdResetVerifyUI;", "Lcom/didiglobal/pay/paysecure/prepaidcard/ui/ICardPwdUI;", "()V", "getID", "", "getStepText", "", "context", "Landroid/content/Context;", "getSubTitle", "getTitle", "initData", "", "isShowConfirmBtn", "", "isShowLaws", "onInputDone", "fragment", "Landroidx/fragment/app/Fragment;", "callback", "Lcom/didiglobal/pay/paysecure/prepaidcard/IPasswordCallback;", "text", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CardPwdResetVerifyUI */
/* compiled from: CardPwdResetVerifyUI.kt */
public final class CardPwdResetVerifyUI implements ICardPwdUI {
    public int getID() {
        return 4;
    }

    public String getStepText(Context context) {
        return "";
    }

    public void initData() {
    }

    public boolean isShowConfirmBtn() {
        return false;
    }

    public boolean isShowLaws() {
        return false;
    }

    public CardPwdResetVerifyUI() {
        TrackerManager.Companion.trackPrepaidLast4No("fin_prepaidcard_change_pin_sw", (Integer) null, 2, "", "");
    }

    public String getTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Fintech_Payment_Password_Enter_the_VPkL);
        }
        return null;
    }

    public String getSubTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Fintech_Payment_Password_4_digit_FByu);
        }
        return null;
    }

    public void onInputDone(Fragment fragment, IPasswordCallback iPasswordCallback, String str) {
        EncryptPassword encryptPassword;
        EncryptPassword encryptPassword2;
        LineLoading cardLoading;
        EncryptPassword encryptPassword3;
        Fragment fragment2 = fragment;
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(fragment2, "fragment");
        String str3 = null;
        CardPwdManagerFragment cardPwdManagerFragment = (CardPwdManagerFragment) (!(fragment2 instanceof CardPwdManagerFragment) ? null : fragment2);
        if (!(cardPwdManagerFragment == null || (encryptPassword3 = cardPwdManagerFragment.getEncryptPassword()) == null)) {
            encryptPassword3.prepareEncrypt(str2 != null ? str2 : "");
        }
        FragmentActivity activity = fragment.getActivity();
        if (!(activity == null || cardPwdManagerFragment == null || (cardLoading = cardPwdManagerFragment.getCardLoading()) == null)) {
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            ILoading.DefaultImpls.showLoading$default(cardLoading, activity, cardPwdManagerFragment.getTitleBar(), (String) null, 4, (Object) null);
        }
        PrepaidCardRequest prepaidCardRequest = new PrepaidCardRequest();
        String cardId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getCardId() : null;
        String encryptedPwdString = (cardPwdManagerFragment == null || (encryptPassword2 = cardPwdManagerFragment.getEncryptPassword()) == null) ? null : encryptPassword2.getEncryptedPwdString();
        String scene = cardPwdManagerFragment != null ? cardPwdManagerFragment.getScene() : null;
        String sessionId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getSessionId() : null;
        if (!(cardPwdManagerFragment == null || (encryptPassword = cardPwdManagerFragment.getEncryptPassword()) == null)) {
            str3 = encryptPassword.getEncryptKey();
        }
        prepaidCardRequest.verifyPassword(cardId, encryptedPwdString, "1", scene, sessionId, str3, "2", "", new CardPwdResetVerifyUI$onInputDone$2(cardPwdManagerFragment, iPasswordCallback, fragment2, str2));
        TrackerManager.Companion.trackPrepaidLast4No("fin_prepaidcard_change_pin_ty", (Integer) null, 2, str, "");
    }
}
