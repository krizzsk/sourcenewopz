package com.koushikdutta.async.http.server;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpHead;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.filter.ChunkedOutputFilter;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.util.StreamUtility;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class AsyncHttpServerResponseImpl implements AsyncHttpServerResponse {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    CompletedCallback closedCallback;
    int code = 200;
    boolean ended;
    boolean headWritten = false;
    String httpVersion = "HTTP/1.1";
    private long mContentLength = -1;
    boolean mEnded;
    private Headers mRawHeaders = new Headers();
    AsyncHttpServerRequestImpl mRequest;
    DataSink mSink;
    AsyncSocket mSocket;
    WritableCallback writable;

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
    }

    public Headers getHeaders() {
        return this.mRawHeaders;
    }

    public AsyncSocket getSocket() {
        return this.mSocket;
    }

    public void setSocket(AsyncSocket asyncSocket) {
        this.mSocket = asyncSocket;
    }

    AsyncHttpServerResponseImpl(AsyncSocket asyncSocket, AsyncHttpServerRequestImpl asyncHttpServerRequestImpl) {
        this.mSocket = asyncSocket;
        this.mRequest = asyncHttpServerRequestImpl;
        if (HttpUtil.isKeepAlive(Protocol.HTTP_1_1, asyncHttpServerRequestImpl.getHeaders())) {
            this.mRawHeaders.set(HttpHeaders.CONNECTION, "Keep-Alive");
        }
    }

    public AsyncHttpServerRequest getRequest() {
        return this.mRequest;
    }

    public void write(ByteBufferList byteBufferList) {
        DataSink dataSink;
        if (!this.headWritten) {
            initFirstWrite();
        }
        if (byteBufferList.remaining() != 0 && (dataSink = this.mSink) != null) {
            dataSink.write(byteBufferList);
        }
    }

    /* access modifiers changed from: package-private */
    public void initFirstWrite() {
        boolean z;
        if (!this.headWritten) {
            this.headWritten = true;
            String str = this.mRawHeaders.get(HttpHeaders.TRANSFER_ENCODING);
            if ("".equals(str)) {
                this.mRawHeaders.removeAll(HttpHeaders.TRANSFER_ENCODING);
            }
            boolean z2 = ("Chunked".equalsIgnoreCase(str) || str == null) && !"close".equalsIgnoreCase(this.mRawHeaders.get(HttpHeaders.CONNECTION));
            if (this.mContentLength < 0) {
                String str2 = this.mRawHeaders.get(HttpHeaders.CONTENT_LENGTH);
                if (!TextUtils.isEmpty(str2)) {
                    this.mContentLength = Long.valueOf(str2).longValue();
                }
            }
            if (this.mContentLength >= 0 || !z2) {
                z = false;
            } else {
                this.mRawHeaders.set(HttpHeaders.TRANSFER_ENCODING, "Chunked");
                z = true;
            }
            C20137Util.writeAll((DataSink) this.mSocket, this.mRawHeaders.toPrefixString(String.format(Locale.ENGLISH, "%s %s %s", new Object[]{this.httpVersion, Integer.valueOf(this.code), AsyncHttpServer.getResponseCodeDescription(this.code)})).getBytes(), (CompletedCallback) new CompletedCallback(z) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCompleted(Exception exc) {
                    AsyncHttpServerResponseImpl.this.lambda$initFirstWrite$1$AsyncHttpServerResponseImpl(this.f$1, exc);
                }
            });
        }
    }

    public /* synthetic */ void lambda$initFirstWrite$1$AsyncHttpServerResponseImpl(boolean z, Exception exc) {
        if (exc != null) {
            report(exc);
            return;
        }
        if (z) {
            ChunkedOutputFilter chunkedOutputFilter = new ChunkedOutputFilter(this.mSocket);
            chunkedOutputFilter.setMaxBuffer(0);
            this.mSink = chunkedOutputFilter;
        } else {
            this.mSink = this.mSocket;
        }
        this.mSink.setClosedCallback(this.closedCallback);
        this.closedCallback = null;
        this.mSink.setWriteableCallback(this.writable);
        this.writable = null;
        if (this.ended) {
            end();
        } else {
            getServer().post(new Runnable() {
                public final void run() {
                    AsyncHttpServerResponseImpl.this.lambda$null$0$AsyncHttpServerResponseImpl();
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$0$AsyncHttpServerResponseImpl() {
        WritableCallback writeableCallback = getWriteableCallback();
        if (writeableCallback != null) {
            writeableCallback.onWriteable();
        }
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        DataSink dataSink = this.mSink;
        if (dataSink != null) {
            dataSink.setWriteableCallback(writableCallback);
        } else {
            this.writable = writableCallback;
        }
    }

    public WritableCallback getWriteableCallback() {
        DataSink dataSink = this.mSink;
        if (dataSink != null) {
            return dataSink.getWriteableCallback();
        }
        return this.writable;
    }

    public void end() {
        if (!this.ended) {
            this.ended = true;
            if (!this.headWritten || this.mSink != null) {
                if (!this.headWritten) {
                    this.mRawHeaders.remove(HttpHeaders.TRANSFER_ENCODING);
                }
                DataSink dataSink = this.mSink;
                if (dataSink instanceof ChunkedOutputFilter) {
                    dataSink.end();
                } else if (this.headWritten) {
                    onEnd();
                } else if (!this.mRequest.getMethod().equalsIgnoreCase(AsyncHttpHead.METHOD)) {
                    send("text/html", "");
                } else {
                    writeHead();
                    onEnd();
                }
            }
        }
    }

    public void writeHead() {
        initFirstWrite();
    }

    public void setContentType(String str) {
        this.mRawHeaders.set("Content-Type", str);
    }

    public void send(String str, byte[] bArr) {
        send(str, new ByteBufferList(bArr));
    }

    public <T> void sendBody(AsyncParser<T> asyncParser, T t) {
        this.mRawHeaders.set("Content-Type", asyncParser.getMime());
        asyncParser.write(this, t, new CompletedCallback() {
            public final void onCompleted(Exception exc) {
                AsyncHttpServerResponseImpl.this.lambda$sendBody$2$AsyncHttpServerResponseImpl(exc);
            }
        });
    }

    public /* synthetic */ void lambda$sendBody$2$AsyncHttpServerResponseImpl(Exception exc) {
        end();
    }

    public void send(String str, ByteBuffer byteBuffer) {
        send(str, new ByteBufferList(byteBuffer));
    }

    public void send(String str, ByteBufferList byteBufferList) {
        getServer().post(new Runnable(byteBufferList, str) {
            public final /* synthetic */ ByteBufferList f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                AsyncHttpServerResponseImpl.this.lambda$send$4$AsyncHttpServerResponseImpl(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$send$4$AsyncHttpServerResponseImpl(ByteBufferList byteBufferList, String str) {
        long remaining = (long) byteBufferList.remaining();
        this.mContentLength = remaining;
        this.mRawHeaders.set(HttpHeaders.CONTENT_LENGTH, Long.toString(remaining));
        if (str != null) {
            this.mRawHeaders.set("Content-Type", str);
        }
        C20137Util.writeAll((DataSink) this, byteBufferList, (CompletedCallback) new CompletedCallback() {
            public final void onCompleted(Exception exc) {
                AsyncHttpServerResponseImpl.this.lambda$null$3$AsyncHttpServerResponseImpl(exc);
            }
        });
    }

    public /* synthetic */ void lambda$null$3$AsyncHttpServerResponseImpl(Exception exc) {
        onEnd();
    }

    public void send(String str, String str2) {
        try {
            send(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: protected */
    public void onEnd() {
        this.mEnded = true;
    }

    public void send(String str) {
        String str2 = this.mRawHeaders.get("Content-Type");
        if (str2 == null) {
            str2 = "text/html; charset=utf-8";
        }
        send(str2, str);
    }

    public void send(JSONObject jSONObject) {
        send("application/json; charset=utf-8", jSONObject.toString());
    }

    public void send(JSONArray jSONArray) {
        send("application/json; charset=utf-8", jSONArray.toString());
    }

    public void sendStream(InputStream inputStream, long j) {
        long j2;
        InputStream inputStream2 = inputStream;
        long j3 = j - 1;
        String str = this.mRequest.getHeaders().get(HttpHeaders.RANGE);
        if (str != null) {
            String[] split = str.split("=");
            if (split.length != 2 || !"bytes".equals(split[0])) {
                code(416);
                end();
                return;
            }
            String[] split2 = split[1].split("-");
            try {
                if (split2.length <= 2) {
                    long parseLong = !TextUtils.isEmpty(split2[0]) ? Long.parseLong(split2[0]) : 0;
                    if (split2.length == 2 && !TextUtils.isEmpty(split2[1])) {
                        j3 = Long.parseLong(split2[1]);
                    }
                    code(206);
                    getHeaders().set(HttpHeaders.CONTENT_RANGE, String.format(Locale.ENGLISH, "bytes %d-%d/%d", new Object[]{Long.valueOf(parseLong), Long.valueOf(j3), Long.valueOf(j)}));
                    j2 = parseLong;
                } else {
                    throw new MalformedRangeException();
                }
            } catch (Exception unused) {
                code(416);
                end();
                return;
            }
        } else {
            j2 = 0;
        }
        try {
            if (j2 == inputStream2.skip(j2)) {
                long j4 = (j3 - j2) + 1;
                this.mContentLength = j4;
                this.mRawHeaders.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(j4));
                this.mRawHeaders.set(HttpHeaders.ACCEPT_RANGES, "bytes");
                if (this.mRequest.getMethod().equals(AsyncHttpHead.METHOD)) {
                    writeHead();
                    onEnd();
                } else if (this.mContentLength == 0) {
                    writeHead();
                    StreamUtility.closeQuietly(inputStream2);
                    onEnd();
                } else {
                    getServer().post(new Runnable(inputStream2) {
                        public final /* synthetic */ InputStream f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            AsyncHttpServerResponseImpl.this.lambda$sendStream$6$AsyncHttpServerResponseImpl(this.f$1);
                        }
                    });
                }
            } else {
                throw new StreamSkipException("skip failed to skip requested amount");
            }
        } catch (Exception unused2) {
            code(500);
            end();
        }
    }

    public /* synthetic */ void lambda$sendStream$6$AsyncHttpServerResponseImpl(InputStream inputStream) {
        C20137Util.pump(inputStream, this.mContentLength, this, new CompletedCallback(inputStream) {
            public final /* synthetic */ InputStream f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc) {
                AsyncHttpServerResponseImpl.this.lambda$null$5$AsyncHttpServerResponseImpl(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$null$5$AsyncHttpServerResponseImpl(InputStream inputStream, Exception exc) {
        StreamUtility.closeQuietly(inputStream);
        onEnd();
    }

    public void sendFile(File file) {
        try {
            if (this.mRawHeaders.get("Content-Type") == null) {
                this.mRawHeaders.set("Content-Type", AsyncHttpServer.getContentType(file.getAbsolutePath()));
            }
            sendStream(new BufferedInputStream(new FileInputStream(file), 64000), file.length());
        } catch (FileNotFoundException unused) {
            code(404);
            end();
        }
    }

    public void proxy(AsyncHttpResponse asyncHttpResponse) {
        code(asyncHttpResponse.code());
        asyncHttpResponse.headers().removeAll(HttpHeaders.TRANSFER_ENCODING);
        asyncHttpResponse.headers().removeAll(HttpHeaders.CONTENT_ENCODING);
        asyncHttpResponse.headers().removeAll(HttpHeaders.CONNECTION);
        getHeaders().addAll(asyncHttpResponse.headers());
        asyncHttpResponse.headers().set(HttpHeaders.CONNECTION, "close");
        C20137Util.pump((DataEmitter) asyncHttpResponse, (DataSink) this, (CompletedCallback) new CompletedCallback(asyncHttpResponse) {
            public final /* synthetic */ AsyncHttpResponse f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc) {
                AsyncHttpServerResponseImpl.this.lambda$proxy$7$AsyncHttpServerResponseImpl(this.f$1, exc);
            }
        });
    }

    public /* synthetic */ void lambda$proxy$7$AsyncHttpServerResponseImpl(AsyncHttpResponse asyncHttpResponse, Exception exc) {
        asyncHttpResponse.setEndCallback(new CompletedCallback.NullCompletedCallback());
        asyncHttpResponse.setDataCallback(new DataCallback.NullDataCallback());
        end();
    }

    public AsyncHttpServerResponse code(int i) {
        this.code = i;
        return this;
    }

    public int code() {
        return this.code;
    }

    public void redirect(String str) {
        code(302);
        this.mRawHeaders.set("Location", str);
        end();
    }

    public String getHttpVersion() {
        return this.httpVersion;
    }

    public void setHttpVersion(String str) {
        this.httpVersion = str;
    }

    public void onCompleted(Exception exc) {
        end();
    }

    public boolean isOpen() {
        DataSink dataSink = this.mSink;
        if (dataSink != null) {
            return dataSink.isOpen();
        }
        return this.mSocket.isOpen();
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        DataSink dataSink = this.mSink;
        if (dataSink != null) {
            dataSink.setClosedCallback(completedCallback);
        } else {
            this.closedCallback = completedCallback;
        }
    }

    public CompletedCallback getClosedCallback() {
        DataSink dataSink = this.mSink;
        if (dataSink != null) {
            return dataSink.getClosedCallback();
        }
        return this.closedCallback;
    }

    public AsyncServer getServer() {
        return this.mSocket.getServer();
    }

    public String toString() {
        if (this.mRawHeaders == null) {
            return super.toString();
        }
        return this.mRawHeaders.toPrefixString(String.format(Locale.ENGLISH, "%s %s %s", new Object[]{this.httpVersion, Integer.valueOf(this.code), AsyncHttpServer.getResponseCodeDescription(this.code)}));
    }
}
