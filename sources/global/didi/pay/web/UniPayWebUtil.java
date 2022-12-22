package global.didi.pay.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.activity.CouponsListWebActivityIntent;
import com.didi.unifiedPay.component.activity.WebActivityIntent;
import com.didi.unifiedPay.util.UniPayParamUtil;
import java.util.Map;

public class UniPayWebUtil {
    private static final String GLOBAL_DRIVER = "global_driver";
    private static final int SODA_USER_BRAZIL = 300106;
    private static final int SODA_USER_GLOBAL = 300103;
    private static final int WM_D_BRAZIL = 300104;
    private static final int WM_D_GLOBAL = 300107;

    public static void startWebPage(UniPayWebModel uniPayWebModel, IViewCallback iViewCallback) {
        if (uniPayWebModel != null && iViewCallback != null) {
            if (proxyWebview(uniPayWebModel.context)) {
                WebBrowserUtil.startInternalWebActivity(uniPayWebModel.context, uniPayWebModel.url, "");
            } else if (isInternalContainerSelected(uniPayWebModel.context, uniPayWebModel.sid)) {
                startInternalWebPage(uniPayWebModel);
            } else if (uniPayWebModel.contentType == 1) {
                startExternalCouponWebPage(uniPayWebModel, iViewCallback);
            } else {
                startExternalWebPage(uniPayWebModel, iViewCallback);
            }
        }
    }

    private static boolean isInternalContainerSelected(Context context, String str) {
        int terminalId;
        if (!TextUtils.isEmpty(str) && GLOBAL_DRIVER.equals(str)) {
            return true;
        }
        if ((context == null || ((terminalId = UniPayParamUtil.getTerminalId(context)) != 300106 && terminalId != SODA_USER_GLOBAL)) && !UniPayParamUtil.needPayWebContainer(context)) {
            return false;
        }
        return true;
    }

    private static boolean proxyWebview(Context context) {
        if (context == null) {
            return false;
        }
        int terminalId = UniPayParamUtil.getTerminalId(context);
        return terminalId == WM_D_BRAZIL || terminalId == WM_D_GLOBAL;
    }

    private static void startInternalWebPage(UniPayWebModel uniPayWebModel) {
        uniPayWebModel.url = appendUrlQueryParams(uniPayWebModel.url, UniPayParamUtil.getWebParam(uniPayWebModel.context));
        Intent intent = new Intent();
        intent.putExtra(PayBaseWebActivity.EXTRA_URL, uniPayWebModel.url);
        intent.addFlags(uniPayWebModel.intentFlag);
        if (uniPayWebModel.context instanceof Activity) {
            Activity activity = (Activity) uniPayWebModel.context;
            intent.setClass(activity, UniPayWebActivity.class);
            activity.startActivityForResult(intent, uniPayWebModel.requestCode);
        }
    }

    private static void startExternalWebPage(UniPayWebModel uniPayWebModel, IViewCallback iViewCallback) {
        WebActivityIntent webActivityIntent = new WebActivityIntent();
        webActivityIntent.setWebUrl(uniPayWebModel.url);
        webActivityIntent.addFlags(uniPayWebModel.intentFlag);
        iViewCallback.callStartActivityForResult(webActivityIntent, uniPayWebModel.requestCode);
    }

    private static void startExternalCouponWebPage(UniPayWebModel uniPayWebModel, IViewCallback iViewCallback) {
        CouponsListWebActivityIntent couponsListWebActivityIntent = new CouponsListWebActivityIntent();
        couponsListWebActivityIntent.setWebUrl(uniPayWebModel.url);
        couponsListWebActivityIntent.addFlags(View.NAVIGATION_BAR_UNHIDE);
        iViewCallback.callStartActivityForResult(couponsListWebActivityIntent, uniPayWebModel.requestCode);
    }

    private static String appendUrlQueryParams(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return executeAppend(Uri.parse(str), map).toString();
    }

    private static Uri.Builder executeAppend(Uri uri, Map<String, Object> map) {
        Uri.Builder buildUpon = uri.buildUpon();
        if (map == null || map.size() <= 0 || uri.isOpaque()) {
            return buildUpon;
        }
        for (Map.Entry next : map.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) next.getKey()) && uri.getQueryParameter((String) next.getKey()) == null) {
                buildUpon.appendQueryParameter((String) next.getKey(), String.valueOf(next.getValue()));
            }
        }
        return buildUpon;
    }
}
