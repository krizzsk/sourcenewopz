package com.didi.dimina.container.secondparty.trace.inner.net;

import android.util.Log;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.WebSocketCodes;
import com.didi.dimina.container.secondparty.trace.inner.LogManager;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.raven.config.RavenKey;
import didihttp.Response;
import didihttp.WebSocket;
import didihttp.WebSocketListener;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/net/LogWebSocketListener;", "Ldidihttp/WebSocketListener;", "()V", "onClosed", "", "webSocket", "Ldidihttp/WebSocket;", "code", "", "reason", "", "onClosing", "onFailure", "t", "", "response", "Ldidihttp/Response;", "onMessage", "text", "bytes", "Lokio/ByteString;", "onOpen", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogWebSocketListener.kt */
public final class LogWebSocketListener extends WebSocketListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "LogWebSocketListener";

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/net/LogWebSocketListener$Companion;", "", "()V", "TAG", "", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: LogWebSocketListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(str, "reason");
        LogUtil.iRelease(TAG, "onclosed: code:" + i + " reason:" + str);
        LogManager.INSTANCE.setWebSocketStatus(-1);
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(str, "reason");
        LogUtil.iRelease(TAG, "onclosed: code:" + i + " reason:" + str);
        LogManager.INSTANCE.setWebSocketStatus(-1);
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(th, RavenKey.TYPE);
        LogUtil.iRelease(TAG, "onFailure: " + Log.getStackTraceString(th));
        if (th instanceof EOFException) {
            onClosed(webSocket, WebSocketCodes.CLOSE_NORMAL.getCode(), "normal close");
            return;
        }
        LogManager.INSTANCE.setWebSocketStatus(1);
        LogNetManager.INSTANCE.reconnectWebSocket(webSocket, this);
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        LogUtil.iRelease(TAG, "onMessage: bytes:" + byteString);
    }

    public void onMessage(WebSocket webSocket, String str) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(str, "text");
        LogUtil.iRelease(TAG, "onMessage: text:" + str);
        JSONObject jSONObject = JSONUtil.toJSONObject(str);
        String optString = jSONObject.optString("type");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optString != null) {
            int hashCode = optString.hashCode();
            if (hashCode != 951351530) {
                if (hashCode == 1082290915 && optString.equals("receive")) {
                    LogManager.INSTANCE.onUploadSuccess(optJSONObject);
                }
            } else if (optString.equals("connect") && TextUtil.isEmpty(LogManager.INSTANCE.getUniqueId())) {
                String optString2 = optJSONObject != null ? optJSONObject.optString("u") : null;
                if (optString2 != null) {
                    LogManager.INSTANCE.saveUniqueId(optString2);
                }
            }
        }
    }

    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(response, "response");
        LogUtil.iRelease(TAG, "onOpen: response:" + response);
        LogManager.INSTANCE.setWebSocketStatus(2);
        LogNetManager.INSTANCE.setWebSocket(webSocket);
    }
}
