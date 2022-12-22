package com.didichuxing.mlcp.drtc.utils;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.MessengerType;
import com.didichuxing.mlcp.drtc.interfaces.C15887a;
import com.didichuxing.mlcp.drtc.interfaces.C15888b;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.utils.h */
/* compiled from: WebsocketMessenger */
class C15926h implements C15888b {

    /* renamed from: a */
    private static final String f48466a = "com.didichuxing.mlcp.drtc.utils.h";

    /* renamed from: b */
    private final String f48467b;

    /* renamed from: c */
    private final C15887a f48468c;

    /* renamed from: d */
    private final MessengerType f48469d = MessengerType.websocket;

    /* renamed from: e */
    private WebSocket f48470e = null;

    /* renamed from: f */
    private boolean f48471f;

    /* renamed from: g */
    private int f48472g = 3;

    /* renamed from: h */
    private final ConcurrentLinkedDeque<String> f48473h = new ConcurrentLinkedDeque<>();

    public C15926h(String str, C15887a aVar) {
        this.f48467b = str;
        this.f48468c = aVar;
    }

    /* renamed from: a */
    public MessengerType mo118935a() {
        return this.f48469d;
    }

    /* renamed from: b */
    public void mo118939b() {
        if (this.f48470e.isOpen()) {
            this.f48470e.close();
        }
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = this.f48473h;
        if (concurrentLinkedDeque != null && concurrentLinkedDeque.size() > 0) {
            this.f48473h.clear();
        }
    }

    /* renamed from: c */
    public void mo118940c() {
        AsyncHttpClient.getDefaultInstance().websocket(this.f48467b, SDKConsts.getSysConfig().f48337d, (AsyncHttpClient.WebSocketConnectCallback) new AsyncHttpClient.WebSocketConnectCallback(new WeakReference(this)) {
            public final /* synthetic */ WeakReference f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc, WebSocket webSocket) {
                C15926h.this.m34750a(this.f$1, exc, webSocket);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34750a(WeakReference weakReference, Exception exc, WebSocket webSocket) {
        C15926h hVar = (C15926h) weakReference.get();
        if (exc != null) {
            hVar.f48468c.mo118881a(exc);
            return;
        }
        this.f48470e = webSocket;
        webSocket.setWriteableCallback($$Lambda$h$wZkYw3YonWm5_rKBMZvtklOWKMc.INSTANCE);
        this.f48470e.setPongCallback($$Lambda$h$zPRH6DimiAN8M2eOm7gC61BCU7o.INSTANCE);
        this.f48470e.setDataCallback($$Lambda$h$JPmhxHPsn8_1kJdD4BZYmZEIQy8.INSTANCE);
        this.f48470e.setEndCallback($$Lambda$h$5BtXBilVvSTOFQyzSXmQevtCExo.INSTANCE);
        WebSocket webSocket2 = this.f48470e;
        hVar.getClass();
        webSocket2.setStringCallback(new WebSocket.StringCallback() {
            public final void onStringAvailable(String str) {
                C15926h.this.mo119066b(str);
            }
        });
        this.f48470e.setClosedCallback(new CompletedCallback() {
            public final void onCompleted(Exception exc) {
                C15926h.m34747a(C15926h.this, exc);
            }
        });
        hVar.f48471f = true;
        if (hVar.f48472g == 3) {
            hVar.f48468c.mo118894e();
        }
    }

    /* renamed from: b */
    public void mo119066b(String str) {
        String str2 = f48466a;
        SystemUtils.log(3, str2, "Rec: \n\t" + str, (Throwable) null, f48466a, 5);
        try {
            this.f48468c.mo118895e(new JSONObject(str));
        } catch (Exception e) {
            this.f48468c.mo118885b(e);
        }
    }

    /* renamed from: a */
    private void m34749a(Exception exc) {
        this.f48468c.mo118885b(exc);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m34747a(C15926h hVar, Exception exc) {
        SystemUtils.log(3, f48466a, "Socket closed for some reason", (Throwable) null, f48466a, 46);
        hVar.f48471f = false;
        if (exc != null) {
            String str = f48466a;
            SystemUtils.log(3, str, "SOCKET EX " + exc.getMessage(), (Throwable) null, f48466a, 50);
            hVar.m34749a(exc);
            return;
        }
        hVar.f48468c.mo118896f();
    }

    /* renamed from: a */
    public void mo118936a(String str) {
        String str2 = f48466a;
        SystemUtils.log(3, str2, "Sent: \n\t" + str, (Throwable) null, f48466a, 54);
        WebSocket webSocket = this.f48470e;
        if (webSocket != null) {
            webSocket.send(str);
        } else {
            this.f48473h.addLast(str);
        }
    }

    /* renamed from: a */
    public void mo118937a(String str, BigInteger bigInteger) {
        mo118936a(str);
    }

    /* renamed from: a */
    public void mo118938a(String str, BigInteger bigInteger, BigInteger bigInteger2) {
        mo118936a(str);
    }
}
