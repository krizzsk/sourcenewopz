package com.didiglobal.pay.paysecure.prepaidcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.pay.paysecure.prepaidcard.CommonPwdDialog;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.CardPwdResetCreateUI;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.CardPwdResetReConfirmUI;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.CardPwdResetVerifyUI;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.ConfirmPasswordUI;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.CreatePasswordUI;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.DefaultCardPwdUI;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.ICardPwdUI;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\"\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 JM\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010'J<\u0010(\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J<\u0010)\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004JR\u0010*\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010+\u001a\u00020\u00122\b\b\u0002\u0010,\u001a\u00020-2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006/"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CardPwdManager;", "", "()V", "activeListener", "Lcom/didiglobal/pay/paysecure/prepaidcard/IActiveCardListener;", "getActiveListener", "()Lcom/didiglobal/pay/paysecure/prepaidcard/IActiveCardListener;", "setActiveListener", "(Lcom/didiglobal/pay/paysecure/prepaidcard/IActiveCardListener;)V", "password", "", "getPassword", "()Ljava/lang/String;", "setPassword", "(Ljava/lang/String;)V", "findCardPwdUI", "Landroidx/fragment/app/Fragment;", "step", "", "finishActivity", "", "fragment", "finishFragment", "manager", "Landroidx/fragment/app/FragmentManager;", "activity", "Landroidx/fragment/app/FragmentActivity;", "showCardPasswordDialog", "fragmentManager", "bundle", "Landroid/os/Bundle;", "listener", "Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$IDismissResult;", "showCreatePassword", "context", "Landroid/app/Activity;", "cardId", "sessionId", "scene", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/didiglobal/pay/paysecure/prepaidcard/IActiveCardListener;)V", "showForgetPassword", "showResetPassword", "startFragment", "index", "addStack", "", "pwd", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CardPwdManager.kt */
public final class CardPwdManager {
    public static final CardPwdManager INSTANCE = new CardPwdManager();

    /* renamed from: a */
    private static String f50332a = "";

    /* renamed from: b */
    private static IActiveCardListener f50333b;

    private CardPwdManager() {
    }

    public final String getPassword() {
        return f50332a;
    }

    public final void setPassword(String str) {
        f50332a = str;
    }

    public final IActiveCardListener getActiveListener() {
        return f50333b;
    }

    public final void setActiveListener(IActiveCardListener iActiveCardListener) {
        f50333b = iActiveCardListener;
    }

    /* renamed from: a */
    private final Fragment m36245a(int i) {
        ICardPwdUI iCardPwdUI;
        switch (i) {
            case 1:
                iCardPwdUI = new DefaultCardPwdUI();
                break;
            case 2:
                iCardPwdUI = new CreatePasswordUI();
                break;
            case 3:
                iCardPwdUI = new ConfirmPasswordUI();
                break;
            case 4:
                iCardPwdUI = new CardPwdResetVerifyUI();
                break;
            case 5:
                iCardPwdUI = new CardPwdResetCreateUI();
                break;
            case 6:
                iCardPwdUI = new CardPwdResetReConfirmUI();
                break;
            default:
                iCardPwdUI = new DefaultCardPwdUI();
                break;
        }
        return new CardPwdManagerFragment(iCardPwdUI);
    }

    public static /* synthetic */ void startFragment$default(CardPwdManager cardPwdManager, FragmentManager fragmentManager, int i, boolean z, String str, String str2, String str3, String str4, int i2, Object obj) {
        cardPwdManager.startFragment(fragmentManager, i, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? PrepaidConstant.SCENE_SET_PASSWORD : str3, (i2 & 64) != 0 ? "" : str4);
    }

    public final void startFragment(FragmentManager fragmentManager, int i, boolean z, String str, String str2, String str3, String str4) {
        Fragment a = m36245a(i);
        Bundle bundle = new Bundle();
        bundle.putString(BaseCard.KEY_CARD_ID, str);
        bundle.putString("session_id", str2);
        bundle.putString("scene", str3);
        bundle.putString("pwd", str4);
        a.setArguments(bundle);
        FragmentTransaction beginTransaction = fragmentManager != null ? fragmentManager.beginTransaction() : null;
        if (beginTransaction != null) {
            beginTransaction.replace(R.id.fl_root, a, a.getClass().getSimpleName());
            if (z) {
                beginTransaction.addToBackStack((String) null);
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public final void finishFragment(FragmentManager fragmentManager, FragmentActivity fragmentActivity) {
        if ((fragmentManager != null ? fragmentManager.getBackStackEntryCount() : 1) > 1) {
            if (fragmentManager != null) {
                fragmentManager.popBackStack();
            }
        } else if (fragmentActivity != null) {
            fragmentActivity.finish();
        }
    }

    public final void finishActivity(Fragment fragment) {
        FragmentActivity activity;
        if (fragment != null && (activity = fragment.getActivity()) != null) {
            activity.finish();
        }
    }

    public final void showCardPasswordDialog(FragmentManager fragmentManager, Bundle bundle, CommonPwdDialog.IDismissResult iDismissResult) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "fragmentManager");
        CommonPwdDialog commonPwdDialog = new CommonPwdDialog();
        commonPwdDialog.setArguments(bundle);
        commonPwdDialog.show(fragmentManager, "prepaid");
        commonPwdDialog.setDismissListener(iDismissResult);
    }

    public static /* synthetic */ void showCreatePassword$default(CardPwdManager cardPwdManager, Activity activity, String str, String str2, String str3, Integer num, IActiveCardListener iActiveCardListener, int i, Object obj) {
        cardPwdManager.showCreatePassword(activity, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? 1 : num, iActiveCardListener);
    }

    public final void showCreatePassword(Activity activity, String str, String str2, String str3, Integer num, IActiveCardListener iActiveCardListener) {
        Intrinsics.checkParameterIsNotNull(activity, "context");
        f50333b = iActiveCardListener;
        Intent intent = new Intent(activity, CardPwdManagerActivity.class);
        intent.putExtra(CardPwdManagerActivity.CARD_MODE_KEY, num);
        intent.putExtra(BaseCard.KEY_CARD_ID, str);
        intent.putExtra("session_id", str2);
        intent.putExtra("scene", str3);
        activity.startActivity(intent);
    }

    public static /* synthetic */ void showResetPassword$default(CardPwdManager cardPwdManager, Activity activity, String str, String str2, String str3, IActiveCardListener iActiveCardListener, int i, Object obj) {
        String str4 = (i & 2) != 0 ? "" : str;
        String str5 = (i & 4) != 0 ? "" : str2;
        if ((i & 8) != 0) {
            str3 = "change_password";
        }
        cardPwdManager.showResetPassword(activity, str4, str5, str3, iActiveCardListener);
    }

    public final void showResetPassword(Activity activity, String str, String str2, String str3, IActiveCardListener iActiveCardListener) {
        Intrinsics.checkParameterIsNotNull(activity, "context");
        f50333b = iActiveCardListener;
        Intent intent = new Intent(activity, CardPwdManagerActivity.class);
        intent.putExtra(BaseCard.KEY_CARD_ID, str);
        intent.putExtra("session_id", str2);
        intent.putExtra("scene", str3);
        intent.putExtra(CardPwdManagerActivity.CARD_MODE_KEY, 2);
        activity.startActivity(intent);
    }

    public static /* synthetic */ void showForgetPassword$default(CardPwdManager cardPwdManager, Activity activity, String str, String str2, String str3, IActiveCardListener iActiveCardListener, int i, Object obj) {
        String str4 = (i & 2) != 0 ? "" : str;
        String str5 = (i & 4) != 0 ? "" : str2;
        if ((i & 8) != 0) {
            str3 = PrepaidConstant.SCENE_FORGET_PASSWORD;
        }
        cardPwdManager.showForgetPassword(activity, str4, str5, str3, iActiveCardListener);
    }

    public final void showForgetPassword(Activity activity, String str, String str2, String str3, IActiveCardListener iActiveCardListener) {
        Intrinsics.checkParameterIsNotNull(activity, "context");
        f50333b = iActiveCardListener;
        Intent intent = new Intent(activity, CardPwdManagerActivity.class);
        intent.putExtra(CardPwdManagerActivity.CARD_MODE_KEY, 4);
        intent.putExtra(BaseCard.KEY_CARD_ID, str);
        intent.putExtra("session_id", str2);
        intent.putExtra("scene", str3);
        activity.startActivity(intent);
    }
}
