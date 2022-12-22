package p242io.socket.engineio.client.transports;

import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p242io.socket.emitter.Emitter;
import p242io.socket.engineio.client.Transport;
import p242io.socket.thread.EventThread;

/* renamed from: io.socket.engineio.client.transports.PollingXHR */
public class PollingXHR extends Polling {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f59540a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f59541b;

    static {
        Logger logger = Logger.getLogger(PollingXHR.class.getName());
        f59540a = logger;
        f59541b = logger.isLoggable(Level.FINE);
    }

    public PollingXHR(Transport.Options options) {
        super(options);
    }

    /* access modifiers changed from: protected */
    public Request request() {
        return request((Request.Options) null);
    }

    /* access modifiers changed from: protected */
    public Request request(Request.Options options) {
        if (options == null) {
            options = new Request.Options();
        }
        options.uri = uri();
        options.callFactory = this.callFactory;
        Request request = new Request(options);
        request.mo175675on("requestHeaders", new Emitter.Listener() {
            public void call(Object... objArr) {
                this.emit("requestHeaders", objArr[0]);
            }
        }).mo175675on("responseHeaders", new Emitter.Listener() {
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() {
                    public void run() {
                        this.emit("responseHeaders", objArr[0]);
                    }
                });
            }
        });
        return request;
    }

    /* access modifiers changed from: protected */
    public void doWrite(byte[] bArr, Runnable runnable) {
        m42042a(bArr, runnable);
    }

    /* access modifiers changed from: protected */
    public void doWrite(String str, Runnable runnable) {
        m42042a(str, runnable);
    }

    /* renamed from: a */
    private void m42042a(Object obj, final Runnable runnable) {
        Request.Options options = new Request.Options();
        options.method = "POST";
        options.data = obj;
        Request request = request(options);
        request.mo175675on("success", new Emitter.Listener() {
            public void call(Object... objArr) {
                EventThread.exec(new Runnable() {
                    public void run() {
                        runnable.run();
                    }
                });
            }
        });
        request.mo175675on("error", new Emitter.Listener() {
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() {
                    public void run() {
                        Object[] objArr = objArr;
                        Transport unused = this.onError("xhr post error", (objArr.length <= 0 || !(objArr[0] instanceof Exception)) ? null : (Exception) objArr[0]);
                    }
                });
            }
        });
        request.create();
    }

    /* access modifiers changed from: protected */
    public void doPoll() {
        f59540a.fine("xhr poll");
        Request request = request();
        request.mo175675on("data", new Emitter.Listener() {
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() {
                    public void run() {
                        Object[] objArr = objArr;
                        String str = objArr.length > 0 ? objArr[0] : null;
                        if (str instanceof String) {
                            this.onData(str);
                        } else if (str instanceof byte[]) {
                            this.onData((byte[]) str);
                        }
                    }
                });
            }
        });
        request.mo175675on("error", new Emitter.Listener() {
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() {
                    public void run() {
                        Object[] objArr = objArr;
                        Transport unused = this.onError("xhr poll error", (objArr.length <= 0 || !(objArr[0] instanceof Exception)) ? null : (Exception) objArr[0]);
                    }
                });
            }
        });
        request.create();
    }

    /* renamed from: io.socket.engineio.client.transports.PollingXHR$Request */
    public static class Request extends Emitter {
        private static final String BINARY_CONTENT_TYPE = "application/octet-stream";
        private static final MediaType BINARY_MEDIA_TYPE = MediaType.parse(BINARY_CONTENT_TYPE);
        public static final String EVENT_DATA = "data";
        public static final String EVENT_ERROR = "error";
        public static final String EVENT_REQUEST_HEADERS = "requestHeaders";
        public static final String EVENT_RESPONSE_HEADERS = "responseHeaders";
        public static final String EVENT_SUCCESS = "success";
        private static final String TEXT_CONTENT_TYPE = "text/plain;charset=UTF-8";
        private static final MediaType TEXT_MEDIA_TYPE = MediaType.parse("text/plain;charset=UTF-8");
        private Call.Factory callFactory;
        private Object data;
        private String method;
        private Call requestCall;
        /* access modifiers changed from: private */
        public Response response;
        private String uri;

        /* renamed from: io.socket.engineio.client.transports.PollingXHR$Request$Options */
        public static class Options {
            public Call.Factory callFactory;
            public Object data;
            public String method;
            public String uri;
        }

        public Request(Options options) {
            this.method = options.method != null ? options.method : "GET";
            this.uri = options.uri;
            this.data = options.data;
            this.callFactory = options.callFactory != null ? options.callFactory : new OkHttpClient();
        }

        public void create() {
            if (PollingXHR.f59541b) {
                PollingXHR.f59540a.fine(String.format("xhr open %s: %s", new Object[]{this.method, this.uri}));
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            if ("POST".equals(this.method)) {
                if (this.data instanceof byte[]) {
                    treeMap.put("Content-type", new LinkedList(Collections.singletonList(BINARY_CONTENT_TYPE)));
                } else {
                    treeMap.put("Content-type", new LinkedList(Collections.singletonList("text/plain;charset=UTF-8")));
                }
            }
            treeMap.put(HttpHeaders.ACCEPT, new LinkedList(Collections.singletonList(AsyncHttpRequest.HEADER_ACCEPT_ALL)));
            onRequestHeaders(treeMap);
            if (PollingXHR.f59541b) {
                Logger c = PollingXHR.f59540a;
                Object[] objArr = new Object[2];
                objArr[0] = this.uri;
                Object obj = this.data;
                if (obj instanceof byte[]) {
                    obj = Arrays.toString((byte[]) obj);
                }
                objArr[1] = obj;
                c.fine(String.format("sending xhr with url %s | data %s", objArr));
            }
            Request.Builder builder = new Request.Builder();
            for (Map.Entry entry : treeMap.entrySet()) {
                for (String addHeader : (List) entry.getValue()) {
                    builder.addHeader((String) entry.getKey(), addHeader);
                }
            }
            RequestBody requestBody = null;
            Object obj2 = this.data;
            if (obj2 instanceof byte[]) {
                requestBody = RequestBody.create(BINARY_MEDIA_TYPE, (byte[]) obj2);
            } else if (obj2 instanceof String) {
                requestBody = RequestBody.create(TEXT_MEDIA_TYPE, (String) obj2);
            }
            Call newCall = this.callFactory.newCall(builder.url(HttpUrl.parse(this.uri)).method(this.method, requestBody).build());
            this.requestCall = newCall;
            newCall.enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    this.onError(iOException);
                }

                public void onResponse(Call call, Response response) throws IOException {
                    Response unused = this.response = response;
                    this.onResponseHeaders(response.headers().toMultimap());
                    try {
                        if (response.isSuccessful()) {
                            this.onLoad();
                        } else {
                            this.onError(new IOException(Integer.toString(response.code())));
                        }
                    } finally {
                        response.close();
                    }
                }
            });
        }

        private void onSuccess() {
            emit("success", new Object[0]);
        }

        private void onData(String str) {
            emit("data", str);
            onSuccess();
        }

        private void onData(byte[] bArr) {
            emit("data", bArr);
            onSuccess();
        }

        /* access modifiers changed from: private */
        public void onError(Exception exc) {
            emit("error", exc);
        }

        private void onRequestHeaders(Map<String, List<String>> map) {
            emit("requestHeaders", map);
        }

        /* access modifiers changed from: private */
        public void onResponseHeaders(Map<String, List<String>> map) {
            emit("responseHeaders", map);
        }

        /* access modifiers changed from: private */
        public void onLoad() {
            ResponseBody body = this.response.body();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                try {
                    if (BINARY_CONTENT_TYPE.equalsIgnoreCase(contentType.toString())) {
                        onData(body.bytes());
                        return;
                    }
                } catch (IOException e) {
                    onError(e);
                    return;
                }
            }
            onData(body.string());
        }
    }
}
