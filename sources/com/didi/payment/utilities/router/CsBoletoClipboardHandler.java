package com.didi.payment.utilities.router;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.utilities.CsBoletoClipboardChecker;

public class CsBoletoClipboardHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        if (request.getContext() != null) {
            Context context = request.getContext();
            FragmentActivity fragmentActivity = null;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            }
            if (fragmentActivity != null) {
                int i = request.getInt("key_from");
                boolean z = request.getBoolean(WalletExtraConstant.Key.REMOVE);
                if (i == 3) {
                    if (z) {
                        CsBoletoClipboardChecker.removeClipboardCheckerRunnable("wallet_home");
                    } else {
                        CsBoletoClipboardChecker.postClipboardCheckerRunnable(fragmentActivity, "wallet_home");
                    }
                } else if (i != 5) {
                } else {
                    if (z) {
                        CsBoletoClipboardChecker.removeClipboardCheckerRunnable("wallet_sidebar");
                    } else {
                        CsBoletoClipboardChecker.postClipboardCheckerRunnable(fragmentActivity, "wallet_sidebar");
                    }
                }
            }
        }
    }
}
