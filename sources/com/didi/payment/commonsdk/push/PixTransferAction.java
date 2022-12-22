package com.didi.payment.commonsdk.push;

import com.didi.sdk.util.TextUtil;
import com.google.gson.Gson;

public class PixTransferAction {
    public Data innerData;
    public String payloadJson;

    public void parseInner() {
        if (TextUtil.isEmpty(this.payloadJson)) {
            this.innerData = new Data();
        } else {
            this.innerData = (Data) new Gson().fromJson(this.payloadJson, Data.class);
        }
    }

    public Data parseFromJson(String str) {
        return (Data) new Gson().fromJson(str, Data.class);
    }

    public static class Data {
        public String cpf;
        public String iconUrl;
        public String name;
        public String payerName;
        public String status;

        public boolean isValid() {
            return !TextUtil.isEmpty(this.cpf) && !TextUtil.isEmpty(this.name);
        }
    }
}
