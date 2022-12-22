package com.didi.dimina.webview.dmwebview;

import android.content.Context;
import android.os.Build;
import com.didi.dimina.webview.BusinessAgent;
import java.util.List;

public class DMBusinessAgent extends BusinessAgent {

    /* renamed from: a */
    private static final String f18240a = "dimina";

    public String getBusinessUA() {
        return "dimina";
    }

    public String getUserPhone() {
        return "";
    }

    public boolean isWhiteUrl(Context context, String str) {
        return true;
    }

    public DMBusinessAgent(Context context) {
        super(context);
    }

    public boolean shouldIntercept(Context context, String str) {
        return Build.VERSION.SDK_INT >= 21;
    }

    public List<String> getPreloadUrlList() {
        return super.getPreloadUrlList();
    }
}
