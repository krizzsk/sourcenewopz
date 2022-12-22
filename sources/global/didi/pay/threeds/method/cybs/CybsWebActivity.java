package global.didi.pay.threeds.method.cybs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import global.didi.pay.threeds.model.CybsNotifyEvent;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo175978d2 = {"Lglobal/didi/pay/threeds/method/cybs/CybsWebActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "initWebView", "", "loadUrl", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CybsWebActivity.kt */
public final class CybsWebActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String URL = "https://pay.didiglobal.com/risk-api/out/channelInfo3DS?caller=3ds&interfaceName=payrisk-api_3ds_oneDotOhRequest&demand=3ds";
    private WebView webView;

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lglobal/didi/pay/threeds/method/cybs/CybsWebActivity$Companion;", "", "()V", "URL", "", "startActivity", "", "activity", "Landroid/app/Activity;", "payLoad", "acsUrl", "sid", "authId", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CybsWebActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Activity activity, String str, String str2, String str3, String str4) {
            if (activity != null) {
                Intent intent = new Intent(activity, CybsWebActivity.class);
                intent.putExtra("pay_load", str);
                intent.putExtra("acs_url", str2);
                intent.putExtra("auth_id", str4);
                intent.putExtra("session_id", str3);
                Unit unit = Unit.INSTANCE;
                activity.startActivityForResult(intent, 100);
            }
        }
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public final void setWebView(WebView webView2) {
        this.webView = webView2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cybs_web);
        WebView.setWebContentsDebuggingEnabled(true);
        this.webView = (WebView) findViewById(R.id.wv_cybs);
        initWebView();
        loadUrl();
    }

    private final void loadUrl() {
        String stringExtra = getIntent().getStringExtra("pay_load");
        String str = "";
        if (stringExtra == null) {
            stringExtra = str;
        }
        String stringExtra2 = getIntent().getStringExtra("acs_url");
        if (stringExtra2 == null) {
            stringExtra2 = str;
        }
        String stringExtra3 = getIntent().getStringExtra("session_id");
        if (stringExtra3 != null) {
            str = stringExtra3;
        }
        String str2 = "PaReq=" + URLEncoder.encode(stringExtra, "UTF-8") + "&TermUrl=" + URLEncoder.encode(URL, "UTF-8") + "&MD=" + URLEncoder.encode(str, "UTF-8");
        WebView webView2 = this.webView;
        if (webView2 != null) {
            Charset charset = Charsets.UTF_8;
            if (str2 != null) {
                byte[] bytes = str2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                webView2.postUrl(stringExtra2, bytes);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void initWebView() {
        WebView webView2 = this.webView;
        Intrinsics.checkNotNull(webView2);
        webView2.setWebChromeClient(new WebChromeClient());
        WebView webView3 = this.webView;
        Intrinsics.checkNotNull(webView3);
        WebSettings settings = webView3.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView!!.settings");
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setDefaultTextEncodingName("utf-8");
        WebView webView4 = this.webView;
        Intrinsics.checkNotNull(webView4);
        webView4.setWebViewClient(new CybsWebActivity$initWebView$1(this));
    }

    public void onBackPressed() {
        EventBus.getDefault().post(new CybsNotifyEvent(CybsNotifyEvent.TYPE_3DS_CANCEL, (String) null));
        super.onBackPressed();
    }
}
