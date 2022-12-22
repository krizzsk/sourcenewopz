package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManagerFragment;
import com.didiglobal.pay.paysecure.prepaidcard.IPasswordCallback;
import com.didiglobal.pay.paysecure.prepaidcard.TrackerManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J$\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0016"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/ui/CreatePasswordUI;", "Lcom/didiglobal/pay/paysecure/prepaidcard/ui/ICardPwdUI;", "()V", "getID", "", "getStepText", "", "context", "Landroid/content/Context;", "getSubTitle", "getTitle", "initData", "", "isShowConfirmBtn", "", "isShowLaws", "onInputDone", "fragment", "Landroidx/fragment/app/Fragment;", "callback", "Lcom/didiglobal/pay/paysecure/prepaidcard/IPasswordCallback;", "text", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CreatePasswordUI */
/* compiled from: ICardPwdUI.kt */
public final class CreatePasswordUI implements ICardPwdUI {
    public int getID() {
        return 2;
    }

    public void initData() {
    }

    public boolean isShowConfirmBtn() {
        return false;
    }

    public boolean isShowLaws() {
        return false;
    }

    public CreatePasswordUI() {
        TrackerManager.Companion.trackSettingPwd();
    }

    public String getTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Fintech_Payment_management_Create_a_uJaI);
        }
        return null;
    }

    public String getSubTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.Fintech_Payment_management_Will_be_JXKH);
        }
        return null;
    }

    public String getStepText(Context context) {
        return Intrinsics.stringPlus(context != null ? context.getString(R.string.Fintech_Payment_management_Step_1_kMzI) : null, "2/2");
    }

    public void onInputDone(Fragment fragment, IPasswordCallback iPasswordCallback, String str) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        CardPwdManagerFragment cardPwdManagerFragment = (CardPwdManagerFragment) (!(fragment instanceof CardPwdManagerFragment) ? null : fragment);
        if (cardPwdManagerFragment != null) {
            if (CardPwdManagerFragment.checkPwdRule$default(cardPwdManagerFragment, str != null ? str : "", (String) null, 2, (Object) null)) {
                CardPwdManager.INSTANCE.setPassword(str);
                if (iPasswordCallback != null) {
                    iPasswordCallback.onSuccess(2, new CreatePasswordUI$onInputDone$1(fragment, cardPwdManagerFragment));
                    return;
                }
                return;
            }
        }
        if (iPasswordCallback != null) {
            String string = fragment.getString(R.string.Fintech_Payment_Password_The_new_HAoe);
            Intrinsics.checkExpressionValueIsNotNull(string, "fragment.getString(R.str…nt_Password_The_new_HAoe)");
            iPasswordCallback.onFail(2, string);
        }
    }
}
