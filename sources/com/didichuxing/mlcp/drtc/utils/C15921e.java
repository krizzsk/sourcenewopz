package com.didichuxing.mlcp.drtc.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.enums.MessengerType;
import com.didichuxing.mlcp.drtc.interfaces.C15887a;
import com.didichuxing.mlcp.drtc.interfaces.C15888b;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import java.math.BigInteger;
import java.util.Date;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.utils.e */
/* compiled from: HttpRestMessenger */
class C15921e extends HttpUtils implements C15888b, Runnable {

    /* renamed from: a */
    private final MessengerType f48456a = MessengerType.restful;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C15887a f48457b;

    /* renamed from: c */
    private final String f48458c;

    /* renamed from: d */
    private volatile boolean f48459d = false;

    /* renamed from: e */
    private BigInteger f48460e;

    /* renamed from: f */
    private String f48461f;

    /* renamed from: g */
    private Thread f48462g;

    /* renamed from: com.didichuxing.mlcp.drtc.utils.e$a */
    /* compiled from: HttpRestMessenger */
    class C15922a extends AsyncHttpClient.JSONObjectCallback {
        C15922a() {
        }

        /* renamed from: a */
        public void onCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse, JSONObject jSONObject) {
            if (exc == null) {
                C15921e.this.mo119060b(jSONObject.toString());
            } else {
                C15921e.this.f48457b.mo118885b(new Exception("send message completed failed"));
            }
        }
    }

    /* renamed from: com.didichuxing.mlcp.drtc.utils.e$b */
    /* compiled from: HttpRestMessenger */
    class C15923b extends AsyncHttpClient.JSONObjectCallback {
        C15923b() {
        }

        /* renamed from: a */
        public void onCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse, JSONObject jSONObject) {
            if (exc == null) {
                C15921e.this.mo119060b(jSONObject.toString());
            } else {
                C15921e.this.f48457b.mo118885b(new Exception("loop exception"));
            }
            C15921e.this.m34734d();
        }
    }

    C15921e(String str, C15887a aVar) {
        this.f48457b = aVar;
        this.f48458c = str;
        this.f48461f = "";
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34734d() {
        if (this.f48459d) {
            HttpGet_Async(this.f48458c + "/" + this.f48460e.toString() + "?rid=" + new Date().getTime() + "&maxev=1", new C15923b());
        }
    }

    /* renamed from: c */
    public void mo118940c() {
        Connection_Async(this.f48458c, new HttpConnectCallback() {
            public final void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse) {
                C15921e.this.m34731a(exc, asyncHttpResponse);
            }
        });
        this.f48461f = "";
        Thread thread = this.f48462g;
        if (thread == null || !thread.isAlive()) {
            this.f48462g = new Thread(this, "rec");
        }
    }

    public void run() {
        if (Thread.currentThread() == this.f48462g) {
            if (this.f48461f.isEmpty()) {
                this.f48461f = this.f48458c;
            }
            m34734d();
        }
    }

    /* renamed from: a */
    public MessengerType mo118935a() {
        return this.f48456a;
    }

    /* renamed from: b */
    public void mo118939b() {
        try {
            this.f48459d = false;
            if (this.f48462g != null && this.f48462g.isAlive()) {
                this.f48462g.join();
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.f48462g = null;
            throw th;
        }
        this.f48462g = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34731a(Exception exc, AsyncHttpResponse asyncHttpResponse) {
        if (exc == null) {
            this.f48457b.mo118894e();
            this.f48459d = true;
            return;
        }
        this.f48457b.mo118885b(new Exception("Failed to connect"));
    }

    /* renamed from: a */
    public void mo118936a(String str) {
        SystemUtils.log(3, "message", "Sent ------>: \n\t" + str, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.e", 7);
        if (this.f48461f.isEmpty()) {
            this.f48461f = this.f48458c;
        }
        HttpPost_Async(this.f48461f, str, new C15922a());
    }

    /* renamed from: b */
    public void mo119060b(String str) {
        try {
            SystemUtils.log(3, "message", "Rec<<<<<<<<<<<<<<<<<<<<<<<<< : \n\t" + str, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.e", 11);
            this.f48457b.mo118895e(new JSONObject(str));
        } catch (Exception unused) {
            C15887a aVar = this.f48457b;
            aVar.mo118885b(new Exception("Rec Message failed ,rec message is not legal:" + str));
        }
    }

    /* renamed from: a */
    public void mo118937a(String str, BigInteger bigInteger) {
        m34732a(bigInteger);
        this.f48461f = "";
        this.f48461f = this.f48458c + "/" + bigInteger.toString();
        mo118936a(str);
    }

    /* renamed from: a */
    public void mo118938a(String str, BigInteger bigInteger, BigInteger bigInteger2) {
        m34732a(bigInteger);
        this.f48461f = "";
        this.f48461f = this.f48458c + "/" + bigInteger.toString() + "/" + bigInteger2.toString();
        mo118936a(str);
    }

    /* renamed from: a */
    private void m34732a(BigInteger bigInteger) {
        if (this.f48460e == null) {
            this.f48460e = bigInteger;
            Thread thread = this.f48462g;
            if (thread != null) {
                thread.start();
            }
        }
    }
}
