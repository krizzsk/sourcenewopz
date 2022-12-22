package com.didiglobal.pay.paysecure.base;

import androidx.fragment.app.Fragment;
import com.didiglobal.pay.paysecure.p204ui.fragment.CreatePayPwdFragment;
import com.didiglobal.pay.paysecure.p204ui.fragment.GateKeeperFragment;
import com.didiglobal.pay.paysecure.p204ui.fragment.VerifyPayPwdFragment;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/base/PaySecureFragmentManager;", "", "()V", "TAG", "", "getFragment", "Landroidx/fragment/app/Fragment;", "state", "Lcom/didiglobal/pay/paysecure/base/PaySecureState;", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PaySecureFragmentManager.kt */
public final class PaySecureFragmentManager {
    public static final PaySecureFragmentManager INSTANCE = new PaySecureFragmentManager();

    /* renamed from: a */
    private static final String f50320a = "PaySecureFragmentManager";

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaySecureState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PaySecureState.STATE_GATEKEEPER.ordinal()] = 1;
            $EnumSwitchMapping$0[PaySecureState.STATE_FORGOT_PWD.ordinal()] = 2;
            $EnumSwitchMapping$0[PaySecureState.STATE_SET_PWD.ordinal()] = 3;
            $EnumSwitchMapping$0[PaySecureState.STATE_VERIFY_OLD_PWD.ordinal()] = 4;
            $EnumSwitchMapping$0[PaySecureState.STATE_SET_NEW_PWD.ordinal()] = 5;
            $EnumSwitchMapping$0[PaySecureState.STATE_VERIFY_PWD.ordinal()] = 6;
        }
    }

    private PaySecureFragmentManager() {
    }

    public final Fragment getFragment(PaySecureState paySecureState) {
        if (paySecureState == null) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[paySecureState.ordinal()]) {
            case 1:
            case 2:
                return new GateKeeperFragment();
            case 3:
            case 4:
            case 5:
                return new CreatePayPwdFragment();
            case 6:
                return new VerifyPayPwdFragment();
            default:
                return null;
        }
    }
}
