package com.didi.global.fintech.cashier.fastpay.spi;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleType;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.global.fintech.cashier.fastpay.FastPayOrderActivity;
import com.didi.global.fintech.cashier.fastpay.FastPaySettingActivity;
import com.didi.global.fintech.cashier.fastpay.FastPaySyncActivity;
import com.didi.global.fintech.cashier.threeds.GlobalCashierThreeDSModule;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.ICashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.model.FastPayCashierEnv;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import com.didi.global.fintech.cashier.user.model.ThirdParty;
import com.didi.global.fintech.cashier.user.model.ThirdPartyAbility;
import com.didi.global.fintech.cashier.user.spi.IFastPayProcessor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier", value = {IFastPayProcessor.class})
@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0013J'\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/spi/FastPayProcessorImpl;", "Lcom/didi/global/fintech/cashier/user/spi/IFastPayProcessor;", "()V", "cashierEnv", "Lcom/didi/global/fintech/cashier/user/model/FastPayCashierEnv;", "order", "", "activity", "Landroid/app/Activity;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "(Landroid/app/Activity;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/FastPayParam;)V", "pay", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "(Landroid/app/Activity;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "setting", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayProcessorImpl.kt */
public final class FastPayProcessorImpl implements IFastPayProcessor {
    public FastPayCashierEnv cashierEnv() {
        FastPayCashierEnv fastPayCashierEnv = new FastPayCashierEnv();
        ThirdParty.ThreeDS threeDS = new ThirdParty.ThreeDS();
        threeDS.setCallback_schema(ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.ThreeDS, GlobalCashierThreeDSModule.CALLBACK_SCHEME, (String) null, 4, (Object) null));
        threeDS.setSupport_vendor(ICashierFacade.DefaultImpls.getParamListByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.ThreeDS, GlobalCashierThreeDSModule.SUPPORT_VENDOR, (String) null, 4, (Object) null));
        Unit unit = Unit.INSTANCE;
        fastPayCashierEnv.setThird_party(new ThirdParty(threeDS));
        ThirdPartyAbility thirdPartyAbility = new ThirdPartyAbility((String) null, 1, (DefaultConstructorMarker) null);
        thirdPartyAbility.setVirtual_3ds_sdk_version(CashierFacade.Companion.getInstance().getParamByModuleSync(GlobalCashierModuleType.Core, GlobalCashierCoreModule.META_DATA, ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.ThreeDS, GlobalCashierThreeDSModule.THREEDS_SDK_VERSION_NAME, (String) null, 4, (Object) null)));
        Unit unit2 = Unit.INSTANCE;
        fastPayCashierEnv.setThird_party_ability(thirdPartyAbility);
        return fastPayCashierEnv;
    }

    public void pay(Activity activity, Integer num, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        Intent intent = new Intent(activity, FastPaySyncActivity.class);
        intent.putExtra("args_param", cashierParam);
        if (num != null) {
            activity.startActivityForResult(intent, num.intValue());
        } else {
            activity.startActivity(intent);
        }
    }

    public void pay(Fragment fragment, Integer num, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        Intent intent = new Intent(fragment.getContext(), FastPaySyncActivity.class);
        intent.putExtra("args_param", cashierParam);
        if (num != null) {
            fragment.startActivityForResult(intent, num.intValue());
        } else {
            fragment.startActivity(intent);
        }
    }

    public void setting(Activity activity, Integer num, FastPayParam fastPayParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fastPayParam, "param");
        if (num != null) {
            Intent intent = new Intent(activity, FastPaySettingActivity.class);
            intent.putExtra("args_param", fastPayParam);
            Unit unit = Unit.INSTANCE;
            activity.startActivityForResult(intent, num.intValue());
            return;
        }
        Intent intent2 = new Intent(activity, FastPaySettingActivity.class);
        intent2.putExtra("args_param", fastPayParam);
        Unit unit2 = Unit.INSTANCE;
        activity.startActivity(intent2);
    }

    public void order(Activity activity, Integer num, FastPayParam fastPayParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fastPayParam, "param");
        if (num != null) {
            Intent intent = new Intent(activity, FastPayOrderActivity.class);
            intent.putExtra("args_param", fastPayParam);
            Unit unit = Unit.INSTANCE;
            activity.startActivityForResult(intent, num.intValue());
            return;
        }
        Intent intent2 = new Intent(activity, FastPayOrderActivity.class);
        intent2.putExtra("args_param", fastPayParam);
        Unit unit2 = Unit.INSTANCE;
        activity.startActivity(intent2);
    }
}
