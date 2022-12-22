package com.didi.sdk.fusionbridge;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didichuxing.apollo.sdk.Apollo;

public class FusionUtil {
    public static int topBarHeight;

    public static void openWebActivity(Context context, WebViewModel webViewModel) {
        Intent intent = new Intent(context, BaseWebActivity.class);
        if (webViewModel != null) {
            intent.putExtra("web_view_model", webViewModel);
        }
        context.startActivity(intent);
    }

    public static void openFusionWebActivity(Context context, WebViewModel webViewModel) {
        Intent intent = new Intent(context, FusionWebActivity.class);
        if (webViewModel != null) {
            intent.putExtra("web_view_model", webViewModel);
        }
        context.startActivity(intent);
    }

    public static void openWebActivityWithApollo(Context context, WebViewModel webViewModel, String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            if (Apollo.getToggle(str).allow()) {
                openFusionWebActivity(context, webViewModel);
            } else {
                openWebActivity(context, webViewModel);
            }
        }
    }

    public static int getTopBarHeight() {
        return topBarHeight;
    }

    public static void setTopBarHeight(int i) {
        topBarHeight = i;
    }
}
