package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didiglobal.pay.paysecure.prepaidcard.BottomDialog;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManagerFragment;
import com.didiglobal.pay.paysecure.prepaidcard.EncryptPassword;
import com.didiglobal.pay.paysecure.prepaidcard.IConfirmLoading;
import com.didiglobal.pay.paysecure.prepaidcard.IPasswordCallback;
import com.didiglobal.pay.paysecure.prepaidcard.TrackerManager;
import com.didiglobal.pay.paysecure.prepaidcard.net.PrepaidCardRequest;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/ui/CardPwdResetReConfirmUI;", "Lcom/didiglobal/pay/paysecure/prepaidcard/ui/IConfirmCardUI;", "()V", "errorCount", "", "maxErrorCount", "request", "Lcom/didiglobal/pay/paysecure/prepaidcard/net/PrepaidCardRequest;", "getRequest", "()Lcom/didiglobal/pay/paysecure/prepaidcard/net/PrepaidCardRequest;", "getID", "getStepText", "", "context", "Landroid/content/Context;", "getSubTitle", "getTitle", "initData", "", "isShowConfirmBtn", "", "isShowLaws", "onConfirm", "fragment", "Landroidx/fragment/app/Fragment;", "onInputDone", "callback", "Lcom/didiglobal/pay/paysecure/prepaidcard/IPasswordCallback;", "text", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CardPwdResetReConfirmUI */
/* compiled from: CardPwdResetVerifyUI.kt */
public final class CardPwdResetReConfirmUI extends IConfirmCardUI {

    /* renamed from: a */
    private int f50408a;

    /* renamed from: b */
    private final int f50409b = 3;

    /* renamed from: c */
    private final PrepaidCardRequest f50410c = new PrepaidCardRequest();

    public int getID() {
        return 6;
    }

    public String getStepText(Context context) {
        return "";
    }

    public void initData() {
    }

    public boolean isShowConfirmBtn() {
        return true;
    }

    public boolean isShowLaws() {
        return false;
    }

    public CardPwdResetReConfirmUI() {
        TrackerManager.Companion.trackPrepaidLast4No("fin_prepaidcard_newpin_again_sw", (Integer) null, 2, (String) null, (String) null);
    }

    public final PrepaidCardRequest getRequest() {
        return this.f50410c;
    }

    public void onConfirm(Fragment fragment) {
        EncryptPassword encryptPassword;
        EncryptPassword encryptPassword2;
        EncryptPassword encryptPassword3;
        Fragment fragment2 = fragment;
        Intrinsics.checkParameterIsNotNull(fragment2, "fragment");
        String str = null;
        CardPwdManagerFragment cardPwdManagerFragment = (CardPwdManagerFragment) (!(fragment2 instanceof CardPwdManagerFragment) ? null : fragment2);
        IConfirmLoading iConfirmLoading = (IConfirmLoading) (!(fragment2 instanceof IConfirmLoading) ? null : fragment2);
        if (!(cardPwdManagerFragment == null || (encryptPassword3 = cardPwdManagerFragment.getEncryptPassword()) == null)) {
            String password = CardPwdManager.INSTANCE.getPassword();
            if (password == null) {
                password = "";
            }
            encryptPassword3.prepareEncrypt(password);
        }
        CardPwdResetReConfirmUI$onConfirm$callback$1 cardPwdResetReConfirmUI$onConfirm$callback$1 = new CardPwdResetReConfirmUI$onConfirm$callback$1(this, iConfirmLoading, fragment2, cardPwdManagerFragment);
        if (iConfirmLoading != null) {
            iConfirmLoading.startLoading();
        }
        PrepaidCardRequest prepaidCardRequest = this.f50410c;
        String cardId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getCardId() : null;
        String encryptedPwdString = (cardPwdManagerFragment == null || (encryptPassword2 = cardPwdManagerFragment.getEncryptPassword()) == null) ? null : encryptPassword2.getEncryptedPwdString();
        String encryptKey = (cardPwdManagerFragment == null || (encryptPassword = cardPwdManagerFragment.getEncryptPassword()) == null) ? null : encryptPassword.getEncryptKey();
        String sessionId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getSessionId() : null;
        if (cardPwdManagerFragment != null) {
            str = cardPwdManagerFragment.getScene();
        }
        prepaidCardRequest.setCardPassword(cardId, encryptedPwdString, encryptKey, sessionId, str, cardPwdResetReConfirmUI$onConfirm$callback$1);
        TrackerManager.Companion.trackPrepaidLast4No("fin_prepaidcard_newpin_again_ck", (Integer) null, 2, (String) null, (String) null);
    }

    public String getTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Fintech_Payment_Password_Enter_the_AkwR);
        }
        return null;
    }

    public String getSubTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Fintech_Payment_Password_4_digits_urmh);
        }
        return null;
    }

    public void onInputDone(Fragment fragment, IPasswordCallback iPasswordCallback, String str) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        if (!TextUtils.equals(str, CardPwdManager.INSTANCE.getPassword())) {
            this.f50408a++;
            if (iPasswordCallback != null) {
                iPasswordCallback.onFail(6, "");
            }
            if (this.f50408a > this.f50409b) {
                String string = fragment.getString(R.string.Global_Driver_BR_DRV_bank_transfer_pin_code_process_Number_ceiling_oHyd);
                Intrinsics.checkExpressionValueIsNotNull(string, "fragment.getString(R.str…cess_Number_ceiling_oHyd)");
                BottomDialog bottomDialog = new BottomDialog(string, new CardPwdResetReConfirmUI$onInputDone$dialog$1(fragment));
                FragmentManager fragmentManager = fragment.getFragmentManager();
                if (fragmentManager != null) {
                    bottomDialog.show(fragmentManager, "");
                    View view = fragment.getView();
                    if (view != null) {
                        view.postDelayed(new CardPwdResetReConfirmUI$onInputDone$$inlined$let$lambda$1(bottomDialog, fragment), 300);
                    }
                }
            } else if (iPasswordCallback != null) {
                String string2 = fragment.getString(R.string.Fintech_Payment_Password_Please_check_VPtm);
                Intrinsics.checkExpressionValueIsNotNull(string2, "fragment.getString(R.str…ssword_Please_check_VPtm)");
                iPasswordCallback.onFail(6, string2);
            }
        } else if (iPasswordCallback != null) {
            IPasswordCallback.DefaultImpls.onSuccess$default(iPasswordCallback, 6, (Function0) null, 2, (Object) null);
        }
        TrackerManager.Companion.trackPrepaidLast4No("fin_prepaidcard_newpin_again_ty", (Integer) null, 2, str, (String) null);
    }
}
