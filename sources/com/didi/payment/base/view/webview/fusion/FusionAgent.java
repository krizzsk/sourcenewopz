package com.didi.payment.base.view.webview.fusion;

import android.content.Context;
import com.didi.onehybrid.BusinessAgent;

public class FusionAgent extends BusinessAgent {
    public String getUserPhone() {
        return null;
    }

    public boolean isWhiteUrl(Context context, String str) {
        return true;
    }

    public FusionAgent(Context context) {
        super(context);
    }
}
