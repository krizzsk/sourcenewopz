package global.didi.pay.threeds.method.cybs;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import global.didi.pay.threeds.model.CybsNotifyEvent;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"global/didi/pay/threeds/method/cybs/CybsWebActivity$initWebView$1", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CybsWebActivity.kt */
public final class CybsWebActivity$initWebView$1 extends WebViewClient {
    final /* synthetic */ CybsWebActivity this$0;

    CybsWebActivity$initWebView$1(CybsWebActivity cybsWebActivity) {
        this.this$0 = cybsWebActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        String uri;
        boolean z = true;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (uri = url.toString()) == null || !StringsKt.contains$default((CharSequence) uri, (CharSequence) "cybsredirect://3ds/callback", false, 2, (Object) null)) {
            z = false;
        }
        if (z) {
            EventBus.getDefault().post(new CybsNotifyEvent("1.0", this.this$0.getIntent().getStringExtra("auth_id")));
            this.this$0.finish();
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
