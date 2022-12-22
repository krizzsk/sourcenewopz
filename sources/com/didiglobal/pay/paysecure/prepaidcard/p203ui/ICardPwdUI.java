package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didiglobal.pay.paysecure.prepaidcard.IPasswordCallback;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J$\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0015"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/ui/ICardPwdUI;", "", "getID", "", "getStepText", "", "context", "Landroid/content/Context;", "getSubTitle", "getTitle", "initData", "", "isShowConfirmBtn", "", "isShowLaws", "onInputDone", "fragment", "Landroidx/fragment/app/Fragment;", "callback", "Lcom/didiglobal/pay/paysecure/prepaidcard/IPasswordCallback;", "text", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.ICardPwdUI */
/* compiled from: ICardPwdUI.kt */
public interface ICardPwdUI {
    int getID();

    String getStepText(Context context);

    String getSubTitle(Context context);

    String getTitle(Context context);

    void initData();

    boolean isShowConfirmBtn();

    boolean isShowLaws();

    void onInputDone(Fragment fragment, IPasswordCallback iPasswordCallback, String str);
}
