package com.didi.global.fintech.cashier.user.spi;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.model.FastPayCashierEnv;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ'\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u000fJ'\u0010\r\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0012J'\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\f¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/spi/IFastPayProcessor;", "", "cashierEnv", "Lcom/didi/global/fintech/cashier/user/model/FastPayCashierEnv;", "order", "", "activity", "Landroid/app/Activity;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "(Landroid/app/Activity;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/FastPayParam;)V", "pay", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "(Landroid/app/Activity;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "setting", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayProcessor.kt */
public interface IFastPayProcessor {
    FastPayCashierEnv cashierEnv();

    void order(Activity activity, Integer num, FastPayParam fastPayParam);

    void pay(Activity activity, Integer num, CashierParam cashierParam);

    void pay(Fragment fragment, Integer num, CashierParam cashierParam);

    void setting(Activity activity, Integer num, FastPayParam fastPayParam);
}
