package com.koushikdutta.async.http.cache;

import com.koushikdutta.async.http.cache.HeaderParser;

class ResponseHeaders$1 implements HeaderParser.CacheControlHandler {
    final /* synthetic */ C20219d this$0;

    ResponseHeaders$1(C20219d dVar) {
        this.this$0 = dVar;
    }

    public void handle(String str, String str2) {
        if (str.equalsIgnoreCase("no-cache")) {
            boolean unused = this.this$0.f55382j = true;
        } else if (str.equalsIgnoreCase("no-store")) {
            boolean unused2 = this.this$0.f55383k = true;
        } else if (str.equalsIgnoreCase("max-age")) {
            int unused3 = this.this$0.f55384l = HeaderParser.m39879a(str2);
        } else if (str.equalsIgnoreCase("s-maxage")) {
            int unused4 = this.this$0.f55385m = HeaderParser.m39879a(str2);
        } else if (str.equalsIgnoreCase("public")) {
            boolean unused5 = this.this$0.f55386n = true;
        } else if (str.equalsIgnoreCase("must-revalidate")) {
            boolean unused6 = this.this$0.f55387o = true;
        }
    }
}
