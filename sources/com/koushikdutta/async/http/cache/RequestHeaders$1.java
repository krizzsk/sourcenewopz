package com.koushikdutta.async.http.cache;

import com.koushikdutta.async.http.cache.HeaderParser;

class RequestHeaders$1 implements HeaderParser.CacheControlHandler {
    final /* synthetic */ C20218c this$0;

    RequestHeaders$1(C20218c cVar) {
        this.this$0 = cVar;
    }

    public void handle(String str, String str2) {
        if (str.equalsIgnoreCase("no-cache")) {
            boolean unused = this.this$0.f55357c = true;
        } else if (str.equalsIgnoreCase("max-age")) {
            int unused2 = this.this$0.f55358d = HeaderParser.m39879a(str2);
        } else if (str.equalsIgnoreCase("max-stale")) {
            int unused3 = this.this$0.f55359e = HeaderParser.m39879a(str2);
        } else if (str.equalsIgnoreCase("min-fresh")) {
            int unused4 = this.this$0.f55360f = HeaderParser.m39879a(str2);
        } else if (str.equalsIgnoreCase("only-if-cached")) {
            boolean unused5 = this.this$0.f55361g = true;
        }
    }
}
