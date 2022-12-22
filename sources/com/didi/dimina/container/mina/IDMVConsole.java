package com.didi.dimina.container.mina;

import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public interface IDMVConsole {

    public static class NOVConsole implements IDMVConsole {
        public void inspectVConsole(WebViewEngine webViewEngine) {
        }

        public void notifyVConsole() {
        }

        public void recordVConsole(int i, String str) {
        }
    }

    void inspectVConsole(WebViewEngine webViewEngine);

    void notifyVConsole();

    void recordVConsole(int i, String str);

    public static class RealVConsole implements IDMVConsole {
        private static final int MAX_LOG_SIZE = 10000;
        private final JSONObject currentVConsole = new JSONObject();
        private final List<WebViewEngine> dmWebViewList = new ArrayList();
        private final JSONArray preVConsoleList = new JSONArray();
        private final JSONObject res = new JSONObject();

        public void recordVConsole(int i, String str) {
            if (this.dmWebViewList.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                if (i == 0) {
                    JSONUtil.put(jSONObject, "type", 0);
                    JSONUtil.put(jSONObject, "content", (Object) str);
                    JSONUtil.put(this.currentVConsole, "type", 0);
                    JSONUtil.put(this.currentVConsole, "content", (Object) str);
                } else if (i == 1) {
                    JSONUtil.put(jSONObject, "type", 1);
                    JSONUtil.put(jSONObject, "content", (Object) str);
                    JSONUtil.put(this.currentVConsole, "type", 1);
                    JSONUtil.put(this.currentVConsole, "content", (Object) str);
                } else if (i == 2) {
                    JSONUtil.put(jSONObject, "type", 2);
                    JSONUtil.put(jSONObject, "content", (Object) str);
                    JSONUtil.put(this.currentVConsole, "type", 2);
                    JSONUtil.put(this.currentVConsole, "content", (Object) str);
                } else if (i == 3) {
                    JSONUtil.put(jSONObject, "type", 3);
                    JSONUtil.put(jSONObject, "content", (Object) str);
                    JSONUtil.put(this.currentVConsole, "type", 3);
                    JSONUtil.put(this.currentVConsole, "content", (Object) str);
                }
                if (this.preVConsoleList.length() > 10000) {
                    this.preVConsoleList.remove(0);
                }
                this.preVConsoleList.put(jSONObject);
            }
        }

        public void notifyVConsole() {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.currentVConsole);
            try {
                this.res.put("consoleList", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject build = new MessageWrapperBuilder().data(this.res).build();
            for (WebViewEngine next : this.dmWebViewList) {
                if (next.getDmMina() != null) {
                    next.getDmMina().getMessageTransfer().sendMessageToWebView(next, "serviceConsole", build);
                }
            }
        }

        public void inspectVConsole(WebViewEngine webViewEngine) {
            if (webViewEngine.getDmMina() != null) {
                try {
                    this.res.put("consoleList", this.preVConsoleList);
                    webViewEngine.getDmMina().getMessageTransfer().sendMessageToWebView(webViewEngine, "serviceConsole", new MessageWrapperBuilder().data(this.res).build());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.dmWebViewList.add(webViewEngine);
        }
    }
}
