package com.didi.component.payentrance.utils;

import android.content.Intent;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;

public class PERedirectUtil {
    public static void gotoWeb(WebViewModel webViewModel) {
        Intent intent = new Intent(DIDIApplication.getAppContext(), WebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        intent.addFlags(268435456);
        DIDIApplication.getAppContext().startActivity(intent);
    }
}
