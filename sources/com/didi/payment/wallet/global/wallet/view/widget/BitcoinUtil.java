package com.didi.payment.wallet.global.wallet.view.widget;

import android.content.Context;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;

public class BitcoinUtil {
    public static Boolean checkBitcoinWelPage(Context context) {
        if (DCryptoUtils.hasUserBeenEducated(context)) {
            return false;
        }
        DRouter.build("pay99://one/btc/welcome_page").start(context);
        return true;
    }

    public static Boolean isBitcoin(int i) {
        if (i == 656) {
            return true;
        }
        return false;
    }

    public static void putBitcoinExtra(Request request) {
        request.putExtra("terminal_id", "5");
        request.putExtra("env", "sim113");
    }
}
