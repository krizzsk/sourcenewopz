package atd.p042q0;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import atd.p015d.C0983f;
import atd.p040p0.C1128b;
import atd.p044r0.C1154a;
import atd.p046s0.C1172a;
import com.adyen.threeds2.internal.C1395b;
import com.taxis99.R;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/* renamed from: atd.q0.b */
public final class C1135b extends C1134a<C0983f, C1128b> {

    /* renamed from: c */
    static final Charset f341c = C1395b.f995a;

    /* renamed from: b */
    private final WebView f342b;

    static {
        C1172a.m764a(-727224315890350L);
        C1172a.m764a(-727245790726830L);
        C1172a.m764a(-727271560530606L);
        C1172a.m764a(-727301625301678L);
        C1172a.m764a(-727348869941934L);
    }

    public C1135b(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    public void mo13877a(C0983f fVar) {
        m670a(fVar.mo13645b());
    }

    /* renamed from: b */
    public void mo13878b(C0983f fVar) {
        m670a(fVar.mo13646c());
    }

    /* access modifiers changed from: protected */
    public int getChallengeContainerLayoutId() {
        return R.layout.a3ds2_view_challenge_html_container;
    }

    public C1135b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private void m670a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f342b.loadDataWithBaseURL(C1172a.m764a(-727112646740654L), C1154a.m709a().mo13923c(str), C1172a.m764a(-727116941707950L), f341c.toString(), (String) null);
        }
    }

    /* renamed from: atd.q0.b$a */
    private final class C1136a extends WebViewClient {
        C1136a() {
        }

        /* renamed from: a */
        private WebResourceResponse m673a(Uri uri) {
            if (C1172a.m764a(-726683150011054L).equals(uri.getScheme())) {
                return null;
            }
            if (!C1172a.m764a(-726704624847534L).equalsIgnoreCase(uri.getScheme()) || !C1172a.m764a(-726730394651310L).equalsIgnoreCase(uri.getHost()) || !C1172a.m764a(-726760459422382L).equalsIgnoreCase(uri.getPath())) {
                return m674a(C1172a.m764a(-726811999029934L) + uri.toString());
            }
            if (C1135b.this.getChallengeListener() != null) {
                ((C1128b) C1135b.this.getChallengeListener()).mo13862b(uri.getQuery());
            }
            return m674a(C1172a.m764a(-726807704062638L));
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                return m673a(Uri.parse(str));
            } catch (Exception unused) {
                return m674a(C1172a.m764a(-726588660730542L) + str);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return m673a(webResourceRequest.getUrl());
        }

        /* renamed from: a */
        private WebResourceResponse m674a(String str) {
            return new WebResourceResponse(C1172a.m764a(-727005272558254L), C1135b.f341c.toString(), new ByteArrayInputStream(str.getBytes(C1135b.f341c)));
        }
    }

    public C1135b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        WebView webView = (WebView) findViewById(R.id.webView_htmlChallengeContainer);
        this.f342b = webView;
        webView.getSettings().setJavaScriptEnabled(false);
        this.f342b.setWebViewClient(new C1136a());
    }
}
