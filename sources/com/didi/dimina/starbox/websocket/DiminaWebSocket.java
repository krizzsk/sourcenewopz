package com.didi.dimina.starbox.websocket;

import com.didi.dimina.container.util.LogUtil;
import java.io.EOFException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class DiminaWebSocket implements IDiminaWebSocket {

    /* renamed from: d */
    private static final String f18173d = "DiminaWebSocket";

    /* renamed from: a */
    private String f18174a;

    /* renamed from: b */
    private final OkHttpClient f18175b = new OkHttpClient().newBuilder().build();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WebSocket f18176c;

    public void connect(String str, final OnDiminaWebSocketEventListener onDiminaWebSocketEventListener) {
        if (this.f18176c != null) {
            if (str != null && !str.equals(this.f18174a)) {
                close(CloseCodes.CLOSE_NORMAL.getCode(), CloseCodes.CLOSE_NORMAL.name());
            } else {
                return;
            }
        }
        this.f18174a = str;
        this.f18175b.newWebSocket(new Request.Builder().url(str).build(), new WebSocketListener() {
            public void onOpen(WebSocket webSocket, Response response) {
                LogUtil.iRelease(DiminaWebSocket.f18173d, "onOpen");
                WebSocket unused = DiminaWebSocket.this.f18176c = webSocket;
                OnDiminaWebSocketEventListener onDiminaWebSocketEventListener = onDiminaWebSocketEventListener;
                if (onDiminaWebSocketEventListener != null) {
                    onDiminaWebSocketEventListener.onOpen();
                }
            }

            public void onClosed(WebSocket webSocket, int i, String str) {
                LogUtil.iRelease(DiminaWebSocket.f18173d, "onClose---> code: " + i + " reason: " + str);
                DiminaWebSocket.this.m13557a();
                OnDiminaWebSocketEventListener onDiminaWebSocketEventListener = onDiminaWebSocketEventListener;
                if (onDiminaWebSocketEventListener != null) {
                    onDiminaWebSocketEventListener.onClose(i, str);
                }
            }

            public void onClosing(WebSocket webSocket, int i, String str) {
                LogUtil.iRelease(DiminaWebSocket.f18173d, "onClosing---> code: " + i + " reason: " + str);
                DiminaWebSocket.this.m13557a();
                OnDiminaWebSocketEventListener onDiminaWebSocketEventListener = onDiminaWebSocketEventListener;
                if (onDiminaWebSocketEventListener != null) {
                    onDiminaWebSocketEventListener.onClosing(i, str);
                }
            }

            public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                LogUtil.iRelease(DiminaWebSocket.f18173d, "onFailure---> ");
                th.printStackTrace();
                DiminaWebSocket.this.m13557a();
                OnDiminaWebSocketEventListener onDiminaWebSocketEventListener = onDiminaWebSocketEventListener;
                if (onDiminaWebSocketEventListener == null) {
                    return;
                }
                if (th instanceof EOFException) {
                    onDiminaWebSocketEventListener.onClose(CloseCodes.CLOSE_NORMAL.getCode(), CloseCodes.CLOSE_NORMAL.name());
                } else {
                    onDiminaWebSocketEventListener.onError(th.getMessage());
                }
            }

            public void onMessage(WebSocket webSocket, String str) {
                OnDiminaWebSocketEventListener onDiminaWebSocketEventListener = onDiminaWebSocketEventListener;
                if (onDiminaWebSocketEventListener != null) {
                    onDiminaWebSocketEventListener.onMessage(str);
                }
            }
        });
    }

    public void close(int i, String str) {
        WebSocket webSocket = this.f18176c;
        if (webSocket != null) {
            webSocket.close(i, str);
        }
        m13557a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13557a() {
        this.f18174a = null;
        this.f18176c = null;
    }

    public void destroy() {
        close(CloseCodes.CLOSE_GOING_AWAY.getCode(), CloseCodes.CLOSE_GOING_AWAY.name());
    }

    public void send(String str) {
        WebSocket webSocket = this.f18176c;
        if (webSocket != null) {
            webSocket.send(str);
        }
    }

    public enum CloseCodes {
        CLOSE_NORMAL(1000),
        CLOSE_GOING_AWAY(1001),
        CLOSE_PROTOCOL_ERROR(1002),
        CLOSE_UNSUPPORTED(1003),
        CLOSE_NO_STATUS(1005),
        CLOSE_ABNORMAL(1006),
        UNSUPPORTED_DATA(1007),
        POLICY_VIOLATION(1008),
        CLOSE_TOO_LARGE(1009),
        MISSING_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        SERVICE_RESTART(1012),
        TRY_AGAIN_LATER(1013),
        TLS_HANDSHAKE(1015);
        
        private final int code;

        private CloseCodes(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }
}
