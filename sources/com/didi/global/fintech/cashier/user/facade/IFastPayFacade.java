package com.didi.global.fintech.cashier.user.facade;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.model.FastPayCashierEnv;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J \u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H&J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H&J \u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/facade/IFastPayFacade;", "", "cashierEnv", "Lcom/didi/global/fintech/cashier/user/model/FastPayCashierEnv;", "exist", "", "context", "Landroid/content/Context;", "init", "", "application", "Landroid/app/Application;", "order", "activity", "Landroid/app/Activity;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "pay", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "fragment", "Landroidx/fragment/app/Fragment;", "setting", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayFacade.kt */
public interface IFastPayFacade {
    FastPayCashierEnv cashierEnv();

    boolean exist(Context context);

    void init(Application application);

    void order(Activity activity, int i, FastPayParam fastPayParam);

    void pay(Activity activity, int i, CashierParam cashierParam);

    void pay(Fragment fragment, int i, CashierParam cashierParam);

    void setting(Activity activity, int i, FastPayParam fastPayParam);
}
