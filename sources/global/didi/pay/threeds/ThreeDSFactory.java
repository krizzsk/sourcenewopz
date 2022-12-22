package global.didi.pay.threeds;

import androidx.fragment.app.FragmentActivity;
import global.didi.pay.threeds.contract.IAdyen3DS;
import global.didi.pay.threeds.contract.ICybs3DS;
import global.didi.pay.threeds.method.adyen.Adyen3DS;
import global.didi.pay.threeds.method.cybs.Cybs3DS;

public class ThreeDSFactory {
    public static IAdyen3DS getAdyen3DS(FragmentActivity fragmentActivity) {
        return new Adyen3DS(fragmentActivity);
    }

    public static ICybs3DS getCybs3DS(FragmentActivity fragmentActivity) {
        return new Cybs3DS(fragmentActivity);
    }
}
