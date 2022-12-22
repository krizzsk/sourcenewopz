package com.didi.dimina.starbox.websocket;

import android.text.TextUtils;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.debug.IDEMsgType;
import com.didi.dimina.container.debug.IWebSocketMsgSender;
import com.didi.dimina.container.debug.OnWebSocketStatus;
import com.didi.dimina.container.jsengine.web.WebJSArray;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.starbox.websocket.IDEWebSocket;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IDEWebSocket implements IWebSocketMsgSender {
    public static final String PHONE_DEBUGGER = "phoneDebugger";

    /* renamed from: a */
    private DiminaWebSocket f18179a;

    /* renamed from: b */
    private volatile boolean f18180b = false;

    /* renamed from: c */
    private final List<JSONObject> f18181c = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f18182d = 1;

    public boolean startConnect(final DMMina dMMina, final String str, final OnWebSocketStatus onWebSocketStatus) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        DiminaWebSocket diminaWebSocket = new DiminaWebSocket();
        this.f18179a = diminaWebSocket;
        diminaWebSocket.connect(str, new OnDiminaWebSocketEventListener() {
            public void onOpen() {
                LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "onConnectionOpen");
                UIHandlerUtil.post(new Runnable() {
                    public void run() {
                        SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), "client connected", 0));
                        IDEWebSocket.this.sendMsgToIDE(IDEMsgType.TYPE_CLIENT_READY, "");
                        onWebSocketStatus.onSuccess();
                    }
                });
            }

            public void onClose(int i, String str) {
                LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "onClose---> " + String.format("code: %d readson: %s", new Object[]{Integer.valueOf(i), str}));
                if (i == 4000) {
                    UIHandlerUtil.post(new Runnable(dMMina) {
                        public final /* synthetic */ DMMina f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            IDEWebSocket.C77721.this.lambda$onClose$0$IDEWebSocket$1(this.f$1);
                        }
                    });
                } else {
                    UIHandlerUtil.post(new Runnable(str) {
                        public final /* synthetic */ String f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), this.f$0, 0));
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onClose$0$IDEWebSocket$1(DMMina dMMina) {
                SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), "收到错误码 4000 ，远程控制台已关闭", 0));
                IDEWebSocket.this.m13563a(dMMina);
            }

            public void onClosing(int i, String str) {
                LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "onClosing---> " + String.format("code: %d readson: %s", new Object[]{Integer.valueOf(i), str}));
                if (i == 4000) {
                    UIHandlerUtil.post(new Runnable(dMMina) {
                        public final /* synthetic */ DMMina f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            IDEWebSocket.C77721.this.lambda$onClosing$2$IDEWebSocket$1(this.f$1);
                        }
                    });
                } else {
                    UIHandlerUtil.post(new Runnable(str) {
                        public final /* synthetic */ String f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), this.f$0, 0));
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onClosing$2$IDEWebSocket$1(DMMina dMMina) {
                SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), "收到错误码 4000 ，远程控制台已关闭", 0));
                IDEWebSocket.this.m13563a(dMMina);
            }

            public void onError(String str) {
                LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "onError：" + str);
                IDEWebSocket.this.m13564a(dMMina, str);
                onWebSocketStatus.onFailed();
            }

            public void onMessage(String str) {
                LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "onMessage：" + str);
                IDEWebSocket.this.handleMsg(dMMina, str);
            }
        });
        return true;
    }

    public void sendMsgToIDE(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.iRelease(PHONE_DEBUGGER, "发送消息方法名为空");
            return;
        }
        String b = m13567b(str);
        String a = m13561a(str, str2);
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", b);
                jSONObject.put("params", a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!b.contains("consoleAPICalled") || this.f18180b) {
                doSend(jSONObject.toString());
                return;
            }
            this.f18181c.add(jSONObject);
            LogUtil.iRelease(PHONE_DEBUGGER, "远程控制台尚未打开：已暂存消息" + jSONObject.toString());
        }
    }

    public void close(int i, String str) {
        this.f18179a.close(i, str);
    }

    public void destroy() {
        this.f18179a.destroy();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13564a(final DMMina dMMina, final String str) {
        if (!TextUtils.isEmpty(str) && dMMina != null && dMMina.getActivity() != null) {
            this.f18182d++;
            DiminaWebSocket diminaWebSocket = new DiminaWebSocket();
            this.f18179a = diminaWebSocket;
            diminaWebSocket.connect(str, new OnDiminaWebSocketEventListener() {
                public void onOpen() {
                    int unused = IDEWebSocket.this.f18182d = 0;
                    LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "reconnect Open");
                    UIHandlerUtil.post(new Runnable() {
                        public void run() {
                            SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), "client reConnected", 0));
                        }
                    });
                }

                public void onClose(int i, String str) {
                    LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "onClose reconnected---> code: " + i + " reason: " + str);
                    if (i == 4000) {
                        UIHandlerUtil.post(new Runnable(dMMina) {
                            public final /* synthetic */ DMMina f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                IDEWebSocket.C77742.this.lambda$onClose$0$IDEWebSocket$2(this.f$1);
                            }
                        });
                    } else {
                        UIHandlerUtil.post(new Runnable(str) {
                            public final /* synthetic */ String f$0;

                            {
                                this.f$0 = r1;
                            }

                            public final void run() {
                                SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), this.f$0, 0));
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onClose$0$IDEWebSocket$2(DMMina dMMina) {
                    SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), "收到错误码 4000 ，远程控制台已关闭", 0));
                    IDEWebSocket.this.m13563a(dMMina);
                }

                public void onClosing(int i, String str) {
                    LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "onClosing reconnected---> " + String.format("code: %d readson: %s", new Object[]{Integer.valueOf(i), str}));
                    if (i == 4000) {
                        UIHandlerUtil.post(new Runnable(dMMina) {
                            public final /* synthetic */ DMMina f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                IDEWebSocket.C77742.this.lambda$onClosing$2$IDEWebSocket$2(this.f$1);
                            }
                        });
                    } else {
                        UIHandlerUtil.post(new Runnable(str) {
                            public final /* synthetic */ String f$0;

                            {
                                this.f$0 = r1;
                            }

                            public final void run() {
                                SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), this.f$0, 0));
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onClosing$2$IDEWebSocket$2(DMMina dMMina) {
                    SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), "收到错误码 4000 ，远程控制台已关闭", 0));
                    IDEWebSocket.this.m13563a(dMMina);
                }

                public void onError(String str) {
                    LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "reconnect onError：" + str);
                    if (IDEWebSocket.this.f18182d <= 5) {
                        LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "reconnect current times：" + IDEWebSocket.this.f18182d);
                        UIHandlerUtil.postDelayed(new Runnable(dMMina, str) {
                            public final /* synthetic */ DMMina f$1;
                            public final /* synthetic */ String f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                IDEWebSocket.C77742.this.lambda$onError$4$IDEWebSocket$2(this.f$1, this.f$2);
                            }
                        }, Const.DELAY_TIME4LAST_GPS_TASK);
                        return;
                    }
                    LogUtil.iRelease(IDEWebSocket.PHONE_DEBUGGER, "reconnect failed ,try times arrived max ：" + IDEWebSocket.this.f18182d);
                    UIHandlerUtil.post(new Runnable() {
                        public void run() {
                            SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), "webSocket重连失败，已达到最大重连次数", 0));
                        }
                    });
                }

                public /* synthetic */ void lambda$onError$4$IDEWebSocket$2(DMMina dMMina, String str) {
                    IDEWebSocket.this.m13564a(dMMina, str);
                }

                public void onMessage(String str) {
                    IDEWebSocket.this.handleMsg(dMMina, str);
                }
            });
        }
    }

    /* renamed from: a */
    private JSONObject m13562a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", TypedValues.Custom.S_STRING);
            jSONObject2.put("value", str);
            jSONArray.put(jSONObject2);
            jSONObject.put("args", jSONArray);
            jSONObject.put("executionContextId", 1);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("type", "log");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: b */
    private String m13567b(String str) {
        if ("log".equals(str)) {
            return "Runtime.consoleAPICalled";
        }
        return IDEMsgType.TYPE_CLIENT_READY.equals(str) ? "scanCodeSuccess" : "";
    }

    /* renamed from: a */
    private String m13561a(String str, String str2) {
        if ("log".equals(str)) {
            return m13562a(str2).toString();
        }
        if (IDEMsgType.TYPE_CLIENT_READY.equals(str)) {
            return new JSONObject().toString();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13563a(DMMina dMMina) {
        if (dMMina != null) {
            DMMinaPool.remove(dMMina.getMinaIndex(), true);
            for (DMMinaNavigatorDelegate closeDimina : dMMina.getNavigatorList()) {
                closeDimina.closeDimina();
            }
        }
    }

    public void handleMsg(DMMina dMMina, String str) {
        JSONObject jSONObject;
        WebJSArray webJSArray;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("data");
        try {
            webJSArray = new WebJSArray(new JSONArray(optString2), optString2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            webJSArray = null;
        }
        if ("invoke".equals(optString)) {
            Object invokeNativeFromService = dMMina.getMessageTransfer().invokeNativeFromService(webJSArray);
            String optString3 = jSONObject.optString("syncId");
            if (!TextUtils.isEmpty(optString3)) {
                JSONObject jSONObject3 = new JSONObject();
                JSONUtil.put(jSONObject3, "data", invokeNativeFromService);
                JSONUtil.put(jSONObject3, "syncId", (Object) optString3);
                doSend(jSONObject3.toString());
            }
        } else if ("publish".equals(optString)) {
            try {
                jSONObject2 = new JSONObject(optString2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            dMMina.getMessageTransfer().sendMessageToWebView(jSONObject2.optInt(MessageWrapperBuilder.ARG_WEB_VIEW_ID), jSONObject2.optString("data"));
        }
    }

    public void doSend(String str) {
        LogUtil.iRelease(PHONE_DEBUGGER, "端上向IDE发送消息：" + str);
        this.f18179a.send(str);
    }
}
