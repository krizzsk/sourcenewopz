package com.appsflyer;

import android.content.Context;
import com.appsflyer.oaid.OaidClient;

@Deprecated
class OaidClient {
    OaidClient() {
    }

    @Deprecated
    public static Info fetch(Context context) {
        OaidClient.Info fetch = new com.appsflyer.oaid.OaidClient(context).fetch();
        if (fetch != null) {
            return new Info(fetch.getId(), fetch.getLat());
        }
        return null;
    }

    @Deprecated
    static class Info {

        /* renamed from: id */
        private final String f1871id;
        private final Boolean lat;

        @Deprecated
        public Info(String str, Boolean bool) {
            this.f1871id = str;
            this.lat = bool;
        }

        @Deprecated
        public String getId() {
            return this.f1871id;
        }

        @Deprecated
        public Boolean isLat() {
            return this.lat;
        }
    }
}
