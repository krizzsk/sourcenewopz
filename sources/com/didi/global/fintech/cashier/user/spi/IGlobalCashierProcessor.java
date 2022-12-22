package com.didi.global.fintech.cashier.user.spi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.global.fintech.cashier.user.facade.CashierResultListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\b\u0010\u0002\u001a\u00020\u0003H&J1\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJ1\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor;", "", "dismissLoading", "", "launch", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "launchForResult", "listener", "Lcom/didi/global/fintech/cashier/user/facade/CashierResultListener;", "newVersionCheck", "callback", "Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor$Callback;", "showLoading", "context", "Landroid/content/Context;", "Callback", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierProcessor.kt */
public interface IGlobalCashierProcessor {

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor$Callback;", "", "onResult", "", "result", "", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IGlobalCashierProcessor.kt */
    public interface Callback {
        void onResult(boolean z);
    }

    void dismissLoading();

    void launch(Activity activity, Intent intent, Integer num, CashierParam cashierParam);

    void launch(Fragment fragment, Intent intent, Integer num, CashierParam cashierParam);

    void launchForResult(Activity activity, CashierParam cashierParam, CashierResultListener cashierResultListener);

    void launchForResult(Fragment fragment, CashierParam cashierParam, CashierResultListener cashierResultListener);

    void newVersionCheck(CashierParam cashierParam, Callback callback);

    void showLoading(Context context);
}
