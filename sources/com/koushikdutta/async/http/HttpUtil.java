package com.koushikdutta.async.http;

import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.body.JSONObjectBody;
import com.koushikdutta.async.http.body.MultipartFormDataBody;
import com.koushikdutta.async.http.body.StringBody;
import com.koushikdutta.async.http.body.UrlEncodedFormBody;

public class HttpUtil {
    public static AsyncHttpRequestBody getBody(DataEmitter dataEmitter, CompletedCallback completedCallback, Headers headers) {
        String str = headers.get("Content-Type");
        if (str == null) {
            return null;
        }
        String[] split = str.split(";");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        for (String str2 : split) {
            if ("application/x-www-form-urlencoded".equals(str2)) {
                return new UrlEncodedFormBody();
            }
            if ("application/json".equals(str2)) {
                return new JSONObjectBody();
            }
            if ("text/plain".equals(str2)) {
                return new StringBody();
            }
            if (str2 != null && str2.startsWith(MultipartFormDataBody.PRIMARY_TYPE)) {
                return new MultipartFormDataBody(str);
            }
        }
        return null;
    }

    static class EndEmitter extends FilteredDataEmitter {
        private EndEmitter() {
        }

        public static EndEmitter create(AsyncServer asyncServer, final Exception exc) {
            EndEmitter endEmitter = new EndEmitter();
            asyncServer.post(new Runnable(endEmitter) {
                final /* synthetic */ EndEmitter val$ret;

                {
                    this.val$ret = r1;
                }

                public void run() {
                    this.val$ret.report(exc);
                }
            });
            return endEmitter;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: com.koushikdutta.async.http.filter.ChunkedInputFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: com.koushikdutta.async.http.filter.GZIPInputFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: com.koushikdutta.async.http.filter.ChunkedInputFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: com.koushikdutta.async.http.filter.ChunkedInputFilter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.koushikdutta.async.DataEmitter getBodyDecoder(com.koushikdutta.async.DataEmitter r5, com.koushikdutta.async.http.Protocol r6, com.koushikdutta.async.http.Headers r7, boolean r8) {
        /*
            r0 = -1
            java.lang.String r6 = "Content-Length"
            java.lang.String r6 = r7.get(r6)     // Catch:{ NumberFormatException -> 0x000f }
            if (r6 == 0) goto L_0x000f
            long r2 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r2 = r0
        L_0x0010:
            r6 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0045
            r0 = 0
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x002e
            com.koushikdutta.async.AsyncServer r6 = r5.getServer()
            com.koushikdutta.async.http.BodyDecoderException r7 = new com.koushikdutta.async.http.BodyDecoderException
            java.lang.String r8 = "not using chunked encoding, and no content-length found."
            r7.<init>(r8)
            com.koushikdutta.async.http.HttpUtil$EndEmitter r6 = com.koushikdutta.async.http.HttpUtil.EndEmitter.create(r6, r7)
            r6.setDataEmitter(r5)
            return r6
        L_0x002e:
            if (r8 != 0) goto L_0x003c
            com.koushikdutta.async.AsyncServer r7 = r5.getServer()
            com.koushikdutta.async.http.HttpUtil$EndEmitter r6 = com.koushikdutta.async.http.HttpUtil.EndEmitter.create(r7, r6)
            r6.setDataEmitter(r5)
            return r6
        L_0x003c:
            com.koushikdutta.async.http.filter.ContentLengthFilter r6 = new com.koushikdutta.async.http.filter.ContentLengthFilter
            r6.<init>(r2)
            r6.setDataEmitter(r5)
            goto L_0x005b
        L_0x0045:
            java.lang.String r0 = "Transfer-Encoding"
            java.lang.String r0 = r7.get(r0)
            java.lang.String r1 = "chunked"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x005d
            com.koushikdutta.async.http.filter.ChunkedInputFilter r6 = new com.koushikdutta.async.http.filter.ChunkedInputFilter
            r6.<init>()
            r6.setDataEmitter(r5)
        L_0x005b:
            r5 = r6
            goto L_0x006b
        L_0x005d:
            if (r8 == 0) goto L_0x006b
            com.koushikdutta.async.AsyncServer r7 = r5.getServer()
            com.koushikdutta.async.http.HttpUtil$EndEmitter r6 = com.koushikdutta.async.http.HttpUtil.EndEmitter.create(r7, r6)
            r6.setDataEmitter(r5)
            return r6
        L_0x006b:
            java.lang.String r6 = "Content-Encoding"
            java.lang.String r8 = r7.get(r6)
            java.lang.String r0 = "gzip"
            boolean r8 = r0.equals(r8)
            if (r8 == 0) goto L_0x0083
            com.koushikdutta.async.http.filter.GZIPInputFilter r6 = new com.koushikdutta.async.http.filter.GZIPInputFilter
            r6.<init>()
            r6.setDataEmitter(r5)
        L_0x0081:
            r5 = r6
            goto L_0x0098
        L_0x0083:
            java.lang.String r6 = r7.get(r6)
            java.lang.String r7 = "deflate"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0098
            com.koushikdutta.async.http.filter.InflaterInputFilter r6 = new com.koushikdutta.async.http.filter.InflaterInputFilter
            r6.<init>()
            r6.setDataEmitter(r5)
            goto L_0x0081
        L_0x0098:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.HttpUtil.getBodyDecoder(com.koushikdutta.async.DataEmitter, com.koushikdutta.async.http.Protocol, com.koushikdutta.async.http.Headers, boolean):com.koushikdutta.async.DataEmitter");
    }

    public static boolean isKeepAlive(Protocol protocol, Headers headers) {
        String str = headers.get(HttpHeaders.CONNECTION);
        if (str == null) {
            return protocol == Protocol.HTTP_1_1;
        }
        return "keep-alive".equalsIgnoreCase(str);
    }

    public static boolean isKeepAlive(String str, Headers headers) {
        String str2 = headers.get(HttpHeaders.CONNECTION);
        if (str2 == null) {
            return Protocol.get(str) == Protocol.HTTP_1_1;
        }
        return "keep-alive".equalsIgnoreCase(str2);
    }

    public static long contentLength(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_LENGTH);
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
