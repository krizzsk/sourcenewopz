package com.didichuxing.foundation.net.rpc.http;

import android.text.TextUtils;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcMessage;
import com.didichuxing.foundation.p188io.Deserializer;
import com.didichuxing.foundation.p188io.Serializer;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcProtocol;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import com.didichuxing.foundation.util.Introspector;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class HttpRpcRequest extends HttpRpcMessage implements RpcRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final RpcClient<?, ?> f47595a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final HttpMethod f47596b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f47597c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Serializer<?> f47598d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Class<? extends Deserializer> f47599e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Type f47600f;

    private HttpRpcRequest(Builder builder) {
        super(builder);
        this.f47598d = builder.mSerializer;
        this.f47599e = builder.mClassOfDeserializer;
        this.f47600f = builder.mType;
        this.f47596b = builder.mMethod;
        this.f47595a = builder.mClient;
        this.f47597c = builder.mTag != null ? builder.mTag : this;
    }

    public HttpMethod getMethod() {
        return this.f47596b;
    }

    public Object getTag() {
        return this.f47597c;
    }

    public HttpRpcClient getRpcClient() {
        return (HttpRpcClient) this.f47595a;
    }

    public boolean isSecure() {
        int indexOf = this.mUrl.indexOf(58);
        if (indexOf >= 0) {
            return "https".equalsIgnoreCase(this.mUrl.substring(0, indexOf));
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Serializer<?> mo117243a() {
        return this.f47598d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Class<? extends Deserializer> mo117244b() {
        return this.f47599e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Type mo117245c() {
        return this.f47600f;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder extends HttpRpcMessage.Builder<HttpRpcRequest> implements RpcRequest.Builder {
        /* access modifiers changed from: private */
        public Class<? extends Deserializer> mClassOfDeserializer;
        /* access modifiers changed from: private */
        public RpcClient<?, ?> mClient;
        /* access modifiers changed from: private */
        public HttpMethod mMethod;
        /* access modifiers changed from: private */
        public Serializer mSerializer;
        /* access modifiers changed from: private */
        public Object mTag;
        /* access modifiers changed from: private */
        public Type mType;

        public Builder() {
            this.mMethod = HttpMethod.GET;
        }

        private Builder(HttpRpcRequest httpRpcRequest) {
            this.mMethod = HttpMethod.GET;
            this.mUrl = httpRpcRequest.mUrl;
            this.mMethod = httpRpcRequest.f47596b;
            this.mHeaders.addAll(httpRpcRequest.mHeaders);
            this.mEntity = httpRpcRequest.mEntity;
            this.mSerializer = httpRpcRequest.f47598d;
            this.mClassOfDeserializer = httpRpcRequest.f47599e;
            this.mType = httpRpcRequest.f47600f;
            this.mTag = httpRpcRequest.f47597c;
            this.mClient = httpRpcRequest.f47595a;
        }

        public Builder setProtocol(RpcProtocol rpcProtocol) {
            super.setProtocol(rpcProtocol);
            return this;
        }

        public Builder setUrl(String str) {
            this.mUrl = str;
            return this;
        }

        public Builder addHeaders(Iterable<HttpHeader> iterable) {
            super.addHeaders(iterable);
            return this;
        }

        public Builder addHeaders(HttpHeader... httpHeaderArr) {
            super.addHeaders(httpHeaderArr);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            super.addHeader(str, str2);
            return this;
        }

        public Builder setMethod(HttpMethod httpMethod, HttpEntity httpEntity) {
            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            this.mMethod = httpMethod;
            return setEntity(httpEntity);
        }

        /* access modifiers changed from: protected */
        public Builder setEntity(HttpEntity httpEntity) {
            super.setEntity(httpEntity);
            return this;
        }

        public Builder setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public Builder setRpcClient(RpcClient<? extends RpcRequest, ? extends RpcResponse> rpcClient) {
            this.mClient = rpcClient;
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d5, code lost:
            if ((r11 instanceof com.didichuxing.foundation.rpc.RpcService.CallbackV2) == false) goto L_0x00d8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0218  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x022b  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x02bd A[LOOP:7: B:127:0x02bb->B:128:0x02bd, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x02e1  */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x02e6  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x02ec  */
        /* JADX WARNING: Removed duplicated region for block: B:135:0x02f1  */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x0306  */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x030b  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x030f  */
        /* JADX WARNING: Removed duplicated region for block: B:179:0x03e3  */
        /* JADX WARNING: Removed duplicated region for block: B:181:0x03e8  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0160  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x018a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.didichuxing.foundation.net.rpc.http.HttpRpcRequest.Builder setRpcService(java.lang.Class<? extends com.didichuxing.foundation.rpc.RpcService> r19, java.lang.reflect.Method r20, java.lang.Object... r21) {
            /*
                r18 = this;
                r1 = r18
                r0 = r19
                r2 = r20
                r3 = r21
                java.lang.String r4 = r1.mUrl
                android.net.Uri r4 = android.net.Uri.parse(r4)
                android.net.Uri$Builder r5 = new android.net.Uri$Builder
                r5.<init>()
                java.lang.String r6 = r4.getScheme()
                r5.scheme(r6)
                java.lang.String r6 = r4.getEncodedAuthority()
                r5.encodedAuthority(r6)
                java.lang.String r6 = r4.getEncodedPath()
                r5.encodedPath(r6)
                java.lang.String r6 = r4.getEncodedQuery()
                r5.encodedQuery(r6)
                java.lang.String r4 = r4.getEncodedFragment()
                r5.encodedFragment(r4)
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.Path> r4 = com.didichuxing.foundation.rpc.annotation.Path.class
                boolean r4 = r0.isAnnotationPresent(r4)
                java.lang.String r6 = ""
                java.lang.String r7 = "/"
                if (r4 == 0) goto L_0x0078
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.Path> r4 = com.didichuxing.foundation.rpc.annotation.Path.class
                java.lang.annotation.Annotation r0 = r0.getAnnotation(r4)
                com.didichuxing.foundation.rpc.annotation.Path r0 = (com.didichuxing.foundation.rpc.annotation.Path) r0
                java.lang.String r0 = r0.value()
                boolean r4 = android.text.TextUtils.isEmpty(r0)
                if (r4 != 0) goto L_0x0078
                java.lang.String[] r4 = r0.split(r7)
                if (r4 == 0) goto L_0x0078
                int r9 = r4.length
                if (r9 <= 0) goto L_0x0078
                int r9 = r4.length
                r10 = 0
            L_0x005f:
                if (r10 >= r9) goto L_0x006f
                r11 = r4[r10]
                boolean r12 = android.text.TextUtils.isEmpty(r11)
                if (r12 != 0) goto L_0x006c
                r5.appendPath(r11)
            L_0x006c:
                int r10 = r10 + 1
                goto L_0x005f
            L_0x006f:
                boolean r0 = r0.endsWith(r7)
                if (r0 == 0) goto L_0x0078
                r5.appendPath(r6)
            L_0x0078:
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.Path> r0 = com.didichuxing.foundation.rpc.annotation.Path.class
                boolean r0 = r2.isAnnotationPresent(r0)
                if (r0 == 0) goto L_0x00b6
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.Path> r0 = com.didichuxing.foundation.rpc.annotation.Path.class
                java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
                com.didichuxing.foundation.rpc.annotation.Path r0 = (com.didichuxing.foundation.rpc.annotation.Path) r0
                java.lang.String r0 = r0.value()
                boolean r4 = android.text.TextUtils.isEmpty(r0)
                if (r4 != 0) goto L_0x00b6
                java.lang.String[] r4 = r0.split(r7)
                if (r4 == 0) goto L_0x00b6
                int r9 = r4.length
                if (r9 <= 0) goto L_0x00b6
                int r9 = r4.length
                r10 = 0
            L_0x009d:
                if (r10 >= r9) goto L_0x00ad
                r11 = r4[r10]
                boolean r12 = android.text.TextUtils.isEmpty(r11)
                if (r12 != 0) goto L_0x00aa
                r5.appendPath(r11)
            L_0x00aa:
                int r10 = r10 + 1
                goto L_0x009d
            L_0x00ad:
                boolean r0 = r0.endsWith(r7)
                if (r0 == 0) goto L_0x00b6
                r5.appendPath(r6)
            L_0x00b6:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                r10 = 1
                if (r3 == 0) goto L_0x00d8
                int r11 = r3.length
                if (r11 <= 0) goto L_0x00d8
                int r11 = r3.length
                int r11 = r11 - r10
                r11 = r3[r11]
                boolean r12 = r11 instanceof com.didichuxing.foundation.rpc.RpcService.Callback
                if (r12 != 0) goto L_0x00d9
                boolean r12 = r11 instanceof com.didichuxing.foundation.rpc.RpcService.CallbackV2
                if (r12 == 0) goto L_0x00d8
                goto L_0x00d9
            L_0x00d8:
                r11 = 0
            L_0x00d9:
                java.lang.annotation.Annotation[][] r12 = r20.getParameterAnnotations()
                if (r12 == 0) goto L_0x015a
                int r13 = r12.length
                if (r13 <= 0) goto L_0x015a
                int r13 = r12.length
                if (r11 != 0) goto L_0x00e7
                r14 = 0
                goto L_0x00e8
            L_0x00e7:
                r14 = 1
            L_0x00e8:
                int r13 = r13 - r14
                r14 = 0
            L_0x00ea:
                if (r14 >= r13) goto L_0x015a
                r15 = r3[r14]
                if (r15 == 0) goto L_0x0154
                java.lang.Object r9 = org.json.JSONObject.NULL
                if (r9 != r15) goto L_0x00f5
                goto L_0x0154
            L_0x00f5:
                r9 = r12[r14]
                if (r9 == 0) goto L_0x0154
                int r10 = r9.length
                if (r10 > 0) goto L_0x00fd
                goto L_0x0154
            L_0x00fd:
                int r10 = r9.length
                r8 = 0
            L_0x00ff:
                if (r8 >= r10) goto L_0x0154
                r16 = r9[r8]
                java.lang.Class r3 = r16.annotationType()
                r17 = r9
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.QueryParameter> r9 = com.didichuxing.foundation.rpc.annotation.QueryParameter.class
                boolean r9 = r9.equals(r3)
                if (r9 == 0) goto L_0x0120
                com.didichuxing.foundation.rpc.annotation.QueryParameter r16 = (com.didichuxing.foundation.rpc.annotation.QueryParameter) r16
                java.lang.String r3 = r16.value()
                com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$SimpleParameter r9 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$SimpleParameter
                r9.<init>(r3, r15)
                r0.add(r9)
                goto L_0x014d
            L_0x0120:
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.BodyParameter> r9 = com.didichuxing.foundation.rpc.annotation.BodyParameter.class
                boolean r9 = r9.equals(r3)
                if (r9 == 0) goto L_0x0137
                com.didichuxing.foundation.rpc.annotation.BodyParameter r16 = (com.didichuxing.foundation.rpc.annotation.BodyParameter) r16
                java.lang.String r3 = r16.value()
                com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$SimpleParameter r9 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$SimpleParameter
                r9.<init>(r3, r15)
                r7.add(r9)
                goto L_0x014d
            L_0x0137:
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.PathParameter> r9 = com.didichuxing.foundation.rpc.annotation.PathParameter.class
                boolean r3 = r9.equals(r3)
                if (r3 == 0) goto L_0x014d
                com.didichuxing.foundation.rpc.annotation.PathParameter r16 = (com.didichuxing.foundation.rpc.annotation.PathParameter) r16
                java.lang.String r3 = r16.value()
                com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$SimpleParameter r9 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$SimpleParameter
                r9.<init>(r3, r15)
                r4.add(r9)
            L_0x014d:
                int r8 = r8 + 1
                r3 = r21
                r9 = r17
                goto L_0x00ff
            L_0x0154:
                int r14 = r14 + 1
                r3 = r21
                r10 = 1
                goto L_0x00ea
            L_0x015a:
                int r3 = r0.size()
                if (r3 <= 0) goto L_0x0184
                java.util.List r0 = inflate(r0)
                java.util.Iterator r0 = r0.iterator()
            L_0x0168:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x0184
                java.lang.Object r3 = r0.next()
                com.didichuxing.foundation.rpc.RpcRequest$Parameter r3 = (com.didichuxing.foundation.rpc.RpcRequest.Parameter) r3
                java.lang.String r8 = r3.getName()
                java.lang.Object r3 = r3.getValue()
                java.lang.String r3 = java.lang.String.valueOf(r3)
                r5.appendQueryParameter(r8, r3)
                goto L_0x0168
            L_0x0184:
                int r0 = r4.size()
                if (r0 <= 0) goto L_0x0210
                java.util.List r0 = inflate(r4)
                java.util.Iterator r0 = r0.iterator()
            L_0x0192:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x0210
                java.lang.Object r3 = r0.next()
                com.didichuxing.foundation.rpc.RpcRequest$Parameter r3 = (com.didichuxing.foundation.rpc.RpcRequest.Parameter) r3
                java.lang.String r4 = r3.getName()
                java.lang.Object r3 = r3.getValue()
                android.net.Uri r8 = r5.build()
                java.util.List r8 = r8.getPathSegments()
                r5.encodedPath(r6)
                java.util.Iterator r8 = r8.iterator()
            L_0x01b5:
                boolean r9 = r8.hasNext()
                if (r9 == 0) goto L_0x0192
                java.lang.Object r9 = r8.next()
                java.lang.String r9 = (java.lang.String) r9
                r10 = 123(0x7b, float:1.72E-43)
                int r10 = r9.indexOf(r10)
                r12 = 125(0x7d, float:1.75E-43)
                int r12 = r9.indexOf(r12)
                if (r10 < 0) goto L_0x0206
                if (r12 < 0) goto L_0x0206
                if (r12 <= r10) goto L_0x0206
                int r13 = r10 + 1
                java.lang.String r13 = r9.substring(r13, r12)
                boolean r13 = r13.equals(r4)
                if (r13 == 0) goto L_0x0206
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                if (r10 <= 0) goto L_0x01ee
                r14 = 0
                java.lang.String r10 = r9.substring(r14, r10)
                r13.append(r10)
            L_0x01ee:
                r13.append(r3)
                int r10 = r9.length()
                r14 = 1
                int r10 = r10 - r14
                if (r12 >= r10) goto L_0x0202
                int r12 = r12 + 1
                java.lang.String r9 = r9.substring(r12)
                r13.append(r9)
            L_0x0202:
                java.lang.String r9 = r13.toString()
            L_0x0206:
                boolean r10 = android.text.TextUtils.isEmpty(r9)
                if (r10 != 0) goto L_0x01b5
                r5.appendEncodedPath(r9)
                goto L_0x01b5
            L_0x0210:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Get> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Get.class
                boolean r0 = r2.isAnnotationPresent(r0)
                if (r0 == 0) goto L_0x022b
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Get> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Get.class
                java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
                com.didichuxing.foundation.net.rpc.http.annotation.Get r0 = (com.didichuxing.foundation.net.rpc.http.annotation.Get) r0
                com.didichuxing.foundation.net.http.HttpMethod r3 = com.didichuxing.foundation.net.http.HttpMethod.GET
                java.lang.String[] r0 = r0.headers()
            L_0x0226:
                r4 = r0
                r0 = 0
            L_0x0228:
                r6 = 0
                goto L_0x02b9
            L_0x022b:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Post> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Post.class
                boolean r0 = r2.isAnnotationPresent(r0)
                if (r0 == 0) goto L_0x0249
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Post> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Post.class
                java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
                com.didichuxing.foundation.net.rpc.http.annotation.Post r0 = (com.didichuxing.foundation.net.rpc.http.annotation.Post) r0
                com.didichuxing.foundation.net.http.HttpMethod r3 = com.didichuxing.foundation.net.http.HttpMethod.POST
                java.lang.String r4 = r0.contentType()
                java.lang.String[] r0 = r0.headers()
            L_0x0245:
                r6 = r4
                r4 = r0
                r0 = 0
                goto L_0x02b9
            L_0x0249:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Put> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Put.class
                boolean r0 = r2.isAnnotationPresent(r0)
                if (r0 == 0) goto L_0x0264
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Put> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Put.class
                java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
                com.didichuxing.foundation.net.rpc.http.annotation.Put r0 = (com.didichuxing.foundation.net.rpc.http.annotation.Put) r0
                com.didichuxing.foundation.net.http.HttpMethod r3 = com.didichuxing.foundation.net.http.HttpMethod.PUT
                java.lang.String r4 = r0.contentType()
                java.lang.String[] r0 = r0.headers()
                goto L_0x0245
            L_0x0264:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Patch> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Patch.class
                boolean r0 = r2.isAnnotationPresent(r0)
                if (r0 == 0) goto L_0x027f
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Patch> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Patch.class
                java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
                com.didichuxing.foundation.net.rpc.http.annotation.Patch r0 = (com.didichuxing.foundation.net.rpc.http.annotation.Patch) r0
                com.didichuxing.foundation.net.http.HttpMethod r3 = com.didichuxing.foundation.net.http.HttpMethod.PATCH
                java.lang.String r4 = r0.contentType()
                java.lang.String[] r0 = r0.headers()
                goto L_0x0245
            L_0x027f:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Delete> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Delete.class
                boolean r0 = r2.isAnnotationPresent(r0)
                if (r0 == 0) goto L_0x029a
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Delete> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Delete.class
                java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
                com.didichuxing.foundation.net.rpc.http.annotation.Delete r0 = (com.didichuxing.foundation.net.rpc.http.annotation.Delete) r0
                com.didichuxing.foundation.net.http.HttpMethod r3 = com.didichuxing.foundation.net.http.HttpMethod.DELETE
                java.lang.String r4 = r0.contentType()
                java.lang.String[] r0 = r0.headers()
                goto L_0x0245
            L_0x029a:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Head> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Head.class
                boolean r0 = r2.isAnnotationPresent(r0)
                if (r0 == 0) goto L_0x02b2
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.annotation.Head> r0 = com.didichuxing.foundation.net.rpc.http.annotation.Head.class
                java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
                com.didichuxing.foundation.net.rpc.http.annotation.Head r0 = (com.didichuxing.foundation.net.rpc.http.annotation.Head) r0
                com.didichuxing.foundation.net.http.HttpMethod r3 = com.didichuxing.foundation.net.http.HttpMethod.HEAD
                java.lang.String[] r0 = r0.headers()
                goto L_0x0226
            L_0x02b2:
                com.didichuxing.foundation.net.http.HttpMethod r3 = com.didichuxing.foundation.net.http.HttpMethod.GET
                r0 = 0
                java.lang.String[] r4 = new java.lang.String[r0]
                goto L_0x0228
            L_0x02b9:
                int r8 = r4.length
                r9 = 0
            L_0x02bb:
                if (r9 >= r8) goto L_0x02cf
                r10 = r4[r9]
                r12 = 1
                com.didichuxing.foundation.net.http.HttpHeader[] r13 = new com.didichuxing.foundation.net.http.HttpHeader[r12]
                com.didichuxing.foundation.net.http.HttpHeader r10 = com.didichuxing.foundation.net.http.HttpHeaders.parse(r10)
                r13[r0] = r10
                r1.addHeaders((com.didichuxing.foundation.net.http.HttpHeader[]) r13)
                int r9 = r9 + 1
                r0 = 0
                goto L_0x02bb
            L_0x02cf:
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.Serialization> r0 = com.didichuxing.foundation.rpc.annotation.Serialization.class
                java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
                com.didichuxing.foundation.rpc.annotation.Serialization r0 = (com.didichuxing.foundation.rpc.annotation.Serialization) r0
                java.lang.Class<com.didichuxing.foundation.rpc.annotation.Deserialization> r4 = com.didichuxing.foundation.rpc.annotation.Deserialization.class
                java.lang.annotation.Annotation r4 = r2.getAnnotation(r4)
                com.didichuxing.foundation.rpc.annotation.Deserialization r4 = (com.didichuxing.foundation.rpc.annotation.Deserialization) r4
                if (r11 == 0) goto L_0x02e6
                java.lang.reflect.Type r2 = com.didichuxing.foundation.util.TypeResolver.getGenericTypeParameter((java.lang.Object) r11)
                goto L_0x02ea
            L_0x02e6:
                java.lang.reflect.Type r2 = r20.getGenericReturnType()
            L_0x02ea:
                if (r0 == 0) goto L_0x02f1
                java.lang.Class r0 = r0.value()
                goto L_0x0304
            L_0x02f1:
                boolean r0 = android.text.TextUtils.isEmpty(r6)
                if (r0 != 0) goto L_0x0302
                java.lang.String r0 = "multipart/"
                boolean r0 = r6.startsWith(r0)
                if (r0 == 0) goto L_0x0302
                java.lang.Class<com.didichuxing.foundation.net.http.MultipartSerializer> r0 = com.didichuxing.foundation.net.http.MultipartSerializer.class
                goto L_0x0304
            L_0x0302:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.FormSerializer> r0 = com.didichuxing.foundation.net.rpc.http.FormSerializer.class
            L_0x0304:
                if (r4 == 0) goto L_0x030b
                java.lang.Class r4 = r4.value()
                goto L_0x030d
            L_0x030b:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.b> r4 = com.didichuxing.foundation.net.rpc.http.C15578b.class
            L_0x030d:
                if (r0 == 0) goto L_0x03d0
                r8 = 1
                java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x0335 }
                java.lang.Class<java.lang.reflect.Type> r10 = java.lang.reflect.Type.class
                r11 = 0
                r9[r11] = r10     // Catch:{ Exception -> 0x0335 }
                java.lang.reflect.Constructor r9 = r0.getConstructor(r9)     // Catch:{ Exception -> 0x0335 }
                r9.setAccessible(r8)     // Catch:{ Exception -> 0x0335 }
                java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0335 }
                com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder$1 r8 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder$1     // Catch:{ Exception -> 0x0335 }
                r8.<init>()     // Catch:{ Exception -> 0x0335 }
                java.lang.reflect.Type r8 = r8.getType()     // Catch:{ Exception -> 0x0335 }
                r11 = 0
                r10[r11] = r8     // Catch:{ Exception -> 0x0335 }
                java.lang.Object r8 = r9.newInstance(r10)     // Catch:{ Exception -> 0x0335 }
                com.didichuxing.foundation.io.Serializer r8 = (com.didichuxing.foundation.p188io.Serializer) r8     // Catch:{ Exception -> 0x0335 }
                r1.mSerializer = r8     // Catch:{ Exception -> 0x0335 }
                goto L_0x034a
            L_0x0335:
                r8 = 0
                java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x03c9 }
                java.lang.reflect.Constructor r0 = r0.getConstructor(r9)     // Catch:{ Exception -> 0x03c9 }
                r9 = 1
                r0.setAccessible(r9)     // Catch:{ Exception -> 0x03c9 }
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x03c9 }
                java.lang.Object r0 = r0.newInstance(r9)     // Catch:{ Exception -> 0x03c9 }
                com.didichuxing.foundation.io.Serializer r0 = (com.didichuxing.foundation.p188io.Serializer) r0     // Catch:{ Exception -> 0x03c9 }
                r1.mSerializer = r0     // Catch:{ Exception -> 0x03c9 }
            L_0x034a:
                java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
                r0.<init>()
                boolean r8 = r7.isEmpty()
                if (r8 != 0) goto L_0x03b1
                java.util.List r7 = inflate(r7)
                java.util.Iterator r7 = r7.iterator()
            L_0x035d:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x03b1
                java.lang.Object r8 = r7.next()
                com.didichuxing.foundation.rpc.RpcRequest$Parameter r8 = (com.didichuxing.foundation.rpc.RpcRequest.Parameter) r8
                java.lang.String r9 = r8.getName()
                boolean r9 = r0.containsKey(r9)
                if (r9 == 0) goto L_0x03a3
                java.lang.String r9 = r8.getName()
                java.lang.Object r9 = r0.get(r9)
                boolean r10 = r9 instanceof java.util.List
                if (r10 == 0) goto L_0x0384
                java.util.List r9 = (java.util.List) r9
                r11 = 1
                r13 = 0
                goto L_0x0394
            L_0x0384:
                java.util.ArrayList r10 = new java.util.ArrayList
                r11 = 1
                java.lang.Object[] r12 = new java.lang.Object[r11]
                r13 = 0
                r12[r13] = r9
                java.util.List r9 = java.util.Arrays.asList(r12)
                r10.<init>(r9)
                r9 = r10
            L_0x0394:
                java.lang.Object r10 = r8.getValue()
                r9.add(r10)
                java.lang.String r8 = r8.getName()
                r0.put(r8, r9)
                goto L_0x035d
            L_0x03a3:
                r11 = 1
                r13 = 0
                java.lang.String r9 = r8.getName()
                java.lang.Object r8 = r8.getValue()
                r0.put(r9, r8)
                goto L_0x035d
            L_0x03b1:
                boolean r7 = r3.permitsRequestBody()
                if (r7 == 0) goto L_0x03c4
                com.didichuxing.foundation.io.Serializer r7 = r1.mSerializer
                if (r7 == 0) goto L_0x03c4
                com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder$2 r7 = new com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder$2
                r7.<init>(r6, r0)
                r1.setMethod(r3, r7)
                goto L_0x03d0
            L_0x03c4:
                r0 = 0
                r1.setMethod(r3, r0)
                goto L_0x03d0
            L_0x03c9:
                r0 = move-exception
                java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
                r2.<init>(r0)
                throw r2
            L_0x03d0:
                if (r2 == 0) goto L_0x03e8
                java.lang.Class r0 = java.lang.Void.TYPE
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x03e8
                java.lang.Class<java.lang.Void> r0 = java.lang.Void.class
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x03e3
                goto L_0x03e8
            L_0x03e3:
                if (r4 == 0) goto L_0x03ec
                r1.mClassOfDeserializer = r4
                goto L_0x03ec
            L_0x03e8:
                java.lang.Class<com.didichuxing.foundation.net.rpc.http.b> r0 = com.didichuxing.foundation.net.rpc.http.C15578b.class
                r1.mClassOfDeserializer = r0
            L_0x03ec:
                r1.mType = r2
                android.net.Uri r0 = r5.build()
                java.lang.String r0 = r0.toString()
                r1.mUrl = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.foundation.net.rpc.http.HttpRpcRequest.Builder.setRpcService(java.lang.Class, java.lang.reflect.Method, java.lang.Object[]):com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder");
        }

        public Builder get() {
            return setMethod(HttpMethod.GET, (HttpEntity) null);
        }

        public Builder get(String str) {
            return setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        }

        public Builder head() {
            return setMethod(HttpMethod.HEAD, (HttpEntity) null);
        }

        public Builder head(String str) {
            return setUrl(str).setMethod(HttpMethod.HEAD, (HttpEntity) null);
        }

        public Builder post(HttpEntity httpEntity) {
            return setMethod(HttpMethod.POST, httpEntity);
        }

        public Builder post(String str, HttpEntity httpEntity) {
            return setUrl(str).setMethod(HttpMethod.POST, httpEntity);
        }

        public Builder put(HttpEntity httpEntity) {
            return setMethod(HttpMethod.PUT, httpEntity);
        }

        public Builder put(String str, HttpEntity httpEntity) {
            return setUrl(str).setMethod(HttpMethod.PUT, httpEntity);
        }

        public Builder delete() {
            return setMethod(HttpMethod.DELETE, (HttpEntity) null);
        }

        public Builder delete(String str) {
            return setUrl(str).setMethod(HttpMethod.DELETE, (HttpEntity) null);
        }

        public Builder delete(HttpEntity httpEntity) {
            return setMethod(HttpMethod.DELETE, httpEntity);
        }

        public Builder delete(String str, HttpEntity httpEntity) {
            return setUrl(str).setMethod(HttpMethod.DELETE, httpEntity);
        }

        public Builder patch(HttpEntity httpEntity) {
            return setMethod(HttpMethod.PATCH, httpEntity);
        }

        public Builder patch(String str, HttpEntity httpEntity) {
            return setUrl(str).setMethod(HttpMethod.PATCH, httpEntity);
        }

        public HttpRpcRequest build() {
            return new HttpRpcRequest(this);
        }

        static final List<RpcRequest.Parameter> inflate(List<RpcRequest.Parameter> list) {
            RpcRequest.Parameter next = list.isEmpty() ? null : list.iterator().next();
            if (next == null || list.size() > 1 || !TextUtils.isEmpty(next.getName())) {
                return list;
            }
            Object value = next.getValue();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next2 : (value instanceof Map ? (Map) value : Introspector.properties(value, true)).entrySet()) {
                arrayList.add(new SimpleParameter(String.valueOf(next2.getKey()), next2.getValue()));
            }
            return arrayList;
        }
    }

    static final class SimpleParameter implements RpcRequest.Parameter {
        final String mName;
        final Object mValue;

        public SimpleParameter(String str, Object obj) {
            this.mName = str;
            this.mValue = obj;
        }

        public String getName() {
            return this.mName;
        }

        public Object getValue() {
            return this.mValue;
        }
    }
}
