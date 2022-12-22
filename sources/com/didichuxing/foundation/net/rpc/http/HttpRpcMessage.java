package com.didichuxing.foundation.net.rpc.http;

import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.http.HttpMessage;
import com.didichuxing.foundation.net.http.SimpleHttpHeader;
import com.didichuxing.foundation.rpc.RpcMessage;
import com.didichuxing.foundation.rpc.RpcProtocol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class HttpRpcMessage implements HttpMessage, RpcMessage {
    protected final HttpEntity mEntity;
    protected final List<HttpHeader> mHeaders;
    protected final RpcProtocol mProtocol;
    protected final String mUrl;

    public abstract HttpRpcClient getRpcClient();

    public abstract Builder<? extends HttpRpcMessage> newBuilder();

    protected HttpRpcMessage(Builder<? extends HttpRpcMessage> builder) {
        this.mUrl = builder.mUrl;
        this.mProtocol = builder.mProtocol;
        this.mHeaders = Collections.unmodifiableList(new ArrayList(builder.mHeaders));
        this.mEntity = builder.mEntity;
    }

    public final RpcProtocol getProtocol() {
        return this.mProtocol;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public List<HttpHeader> getHeaders() {
        return this.mHeaders;
    }

    public String getHeader(String str) {
        List<HttpHeader> list = this.mHeaders;
        ListIterator<HttpHeader> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            HttpHeader previous = listIterator.previous();
            if (previous.getName().equalsIgnoreCase(str)) {
                return previous.getValue();
            }
        }
        return null;
    }

    public List<String> getHeaders(String str) {
        ArrayList arrayList = new ArrayList();
        for (HttpHeader next : this.mHeaders) {
            if (next.getName().equalsIgnoreCase(str)) {
                arrayList.add(next.getValue());
            }
        }
        return arrayList;
    }

    public HttpEntity getEntity() {
        return this.mEntity;
    }

    public static abstract class Builder<T extends RpcMessage> {
        protected HttpEntity mEntity;
        protected final List<HttpHeader> mHeaders = new ArrayList();
        protected RpcProtocol mProtocol = HttpRpcProtocol.HTTP_1_1;
        protected String mUrl;

        public Builder<T> setProtocol(RpcProtocol rpcProtocol) {
            this.mProtocol = rpcProtocol;
            return this;
        }

        public Builder<T> addHeaders(Iterable<HttpHeader> iterable) {
            if (iterable != null) {
                for (HttpHeader next : iterable) {
                    if (next != null) {
                        checkNameAndValue(next.getName(), next.getValue());
                        this.mHeaders.add(next);
                    } else {
                        throw new NullPointerException("header == null");
                    }
                }
                return this;
            }
            throw new NullPointerException("headers == null");
        }

        public Builder<T> addHeaders(HttpHeader... httpHeaderArr) {
            if (httpHeaderArr != null) {
                int i = 0;
                int length = httpHeaderArr.length;
                while (i < length) {
                    if (httpHeaderArr[i] != null) {
                        checkNameAndValue(httpHeaderArr[i].getName(), httpHeaderArr[i].getValue());
                        this.mHeaders.add(httpHeaderArr[i]);
                        i++;
                    } else {
                        throw new NullPointerException("header == null");
                    }
                }
                return this;
            }
            throw new NullPointerException("headers == null");
        }

        public Builder<T> addHeader(String str, String str2) {
            checkNameAndValue(str, str2);
            this.mHeaders.add(new SimpleHttpHeader(str, str2));
            return this;
        }

        private void checkNameAndValue(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else if (str2 == null) {
                throw new NullPointerException("value == null, name = " + str);
            }
        }

        public Builder<T> removeHeaders(String str) {
            Iterator<HttpHeader> it = this.mHeaders.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equalsIgnoreCase(str)) {
                    it.remove();
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public Builder<T> setEntity(HttpEntity httpEntity) {
            this.mEntity = httpEntity;
            return this;
        }
    }
}
