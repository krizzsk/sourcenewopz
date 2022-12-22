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

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/ui/ConfirmPasswordUI;", "Lcom/didiglobal/pay/paysecure/prepaidcard/ui/IConfirmCardUI;", "()V", "errorCount", "", "maxErrorCount", "request", "Lcom/didiglobal/pay/paysecure/prepaidcard/net/PrepaidCardRequest;", "getID", "getStepText", "", "context", "Landroid/content/Context;", "getSubTitle", "getTitle", "initData", "", "isShowConfirmBtn", "", "isShowLaws", "onConfirm", "fragment", "Landroidx/fragment/app/Fragment;", "onInputDone", "callback", "Lcom/didiglobal/pay/paysecure/prepaidcard/IPasswordCallback;", "text", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.ConfirmPasswordUI */
/* compiled from: ICardPwdUI.kt */
public final class ConfirmPasswordUI extends IConfirmCardUI {

    /* renamed from: a */
    private int f50411a;

    /* renamed from: b */
    private final int f50412b = 3;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final PrepaidCardRequest f50413c = new PrepaidCardRequest();

    public int getID() {
        return 3;
    }

    public void initData() {
    }

    public boolean isShowConfirmBtn() {
        return true;
    }

    public boolean isShowLaws() {
        return false;
    }

    public ConfirmPasswordUI() {
        TrackerManager.Companion.trackPrepaidLast4No("fin_prepaidcard_activate2_pinagain_sw", 2, 1, "", "");
    }

    public void onConfirm(Fragment fragment) {
        EncryptPassword encryptPassword;
        EncryptPassword encryptPassword2;
        EncryptPassword encryptPassword3;
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        String str = null;
        CardPwdManagerFragment cardPwdManagerFragment = (CardPwdManagerFragment) (!(fragment instanceof CardPwdManagerFragment) ? null : fragment);
        IConfirmLoading iConfirmLoading = (IConfirmLoading) (!(fragment instanceof IConfirmLoading) ? null : fragment);
        if (!(cardPwdManagerFragment == null || (encryptPassword3 = cardPwdManagerFragment.getEncryptPassword()) == null)) {
            String password = CardPwdManager.INSTANCE.getPassword();
            if (password == null) {
                password = "";
            }
            encryptPassword3.prepareEncrypt(password);
        }
        ConfirmPasswordUI$onConfirm$callback$1 confirmPasswordUI$onConfirm$callback$1 = new ConfirmPasswordUI$onConfirm$callback$1(this, cardPwdManagerFragment, iConfirmLoading, fragment);
        if (iConfirmLoading != null) {
            iConfirmLoading.startLoading();
        }
        PrepaidCardRequest prepaidCardRequest = this.f50413c;
        String cardId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getCardId() : null;
        String encryptedPwdString = (cardPwdManagerFragment == null || (encryptPassword2 = cardPwdManagerFragment.getEncryptPassword()) == null) ? null : encryptPassword2.getEncryptedPwdString();
        String encryptKey = (cardPwdManagerFragment == null || (encryptPassword = cardPwdManagerFragment.getEncryptPassword()) == null) ? null : encryptPassword.getEncryptKey();
        String sessionId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getSessionId() : null;
        if (cardPwdManagerFragment != null) {
            str = cardPwdManagerFragment.getScene();
        }
        prepaidCardRequest.setCardPassword(cardId, encryptedPwdString, encryptKey, sessionId, str, confirmPasswordUI$onConfirm$callback$1);
        TrackerManager.Companion.trackActiveCard();
    }

    public String getTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Fintech_Payment_management_Enter_the_LnvH);
        }
        return null;
    }

    public String getSubTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Fintech_Payment_Password_4_digits_urmh);
        }
        return null;
    }

    public String getStepText(Context context) {
        return Intrinsics.stringPlus(context != null ? context.getString(R.string.Fintech_Payment_management_Step_1_kMzI) : null, "2/2");
    }

    public void onInputDone(Fragment fragment, IPasswordCallback iPasswordCallback, String str) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        if (!TextUtils.equals(str, CardPwdManager.INSTANCE.getPassword())) {
            this.f50411a++;
            if (iPasswordCallback != null) {
                iPasswordCallback.onFail(3, "");
            }
            if (this.f50411a > this.f50412b) {
                String string = fragment.getString(R.string.Global_Driver_BR_DRV_bank_transfer_pin_code_process_Number_ceiling_oHyd);
                Intrinsics.checkExpressionValueIsNotNull(string, "fragment.getString(R.str…cess_Number_ceiling_oHyd)");
                BottomDialog bottomDialog = new BottomDialog(string, new ConfirmPasswordUI$onInputDone$dialog$1(fragment));
                FragmentManager fragmentManager = fragment.getFragmentManager();
                if (fragmentManager != null) {
                    bottomDialog.show(fragmentManager, "");
                    View view = fragment.getView();
                    if (view != null) {
                        view.postDelayed(new ConfirmPasswordUI$onInputDone$$inlined$let$lambda$1(bottomDialog, fragment), 300);
                    }
                }
            } else if (iPasswordCallback != null) {
                String string2 = fragment.getString(R.string.Fintech_Payment_Password_Please_check_VPtm);
                Intrinsics.checkExpressionValueIsNotNull(string2, "fragment.getString(R.str…ssword_Please_check_VPtm)");
                iPasswordCallback.onFail(3, string2);
            }
            TrackerManager.Companion.trackNewPwdError();
        } else if (iPasswordCallback != null) {
            IPasswordCallback.DefaultImpls.onSuccess$default(iPasswordCallback, 3, (Function0) null, 2, (Object) null);
        }
        TrackerManager.Companion.trackPrepaidLast4No("fin_prepaidcard_activate2_pinwro_sw", 2, 1, str, "");
    }
}
