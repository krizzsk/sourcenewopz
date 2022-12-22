package com.android.didi.bfflib.net;

import com.didi.dimina.container.util.TraceUtil;
import com.google.gson.JsonObject;

class BffResponsePojo {
    private BffData data;
    private String errmsg = "";
    private int errno = TraceUtil.MINA_INDEX_UN_KNOW;

    BffResponsePojo() {
    }

    public static class BffData {
        private JsonObject abilities;
        private JsonObject service;

        public JsonObject getService() {
            return this.service;
        }

        public JsonObject getAbilities() {
            return this.abilities;
        }
    }

    public int getErrno() {
        return this.errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public BffData getData() {
        return this.data;
    }
}
