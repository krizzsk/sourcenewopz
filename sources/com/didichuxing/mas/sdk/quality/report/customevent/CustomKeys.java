package com.didichuxing.mas.sdk.quality.report.customevent;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CustomKeys {
    @SerializedName("keys")
    private List<CustomKey> keys;

    public void setKeys(List<CustomKey> list) {
        this.keys = list;
    }

    public List<CustomKey> getKeys() {
        return this.keys;
    }

    public static class CustomKey {
        @SerializedName("key")
        private String key;
        @SerializedName("num")
        private int num;

        public void setKey(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        public void setNum(int i) {
            this.num = i;
        }

        public int getNum() {
            return this.num;
        }

        public String toString() {
            return "CustomKey{key='" + this.key + '\'' + ", num=" + this.num + '}';
        }
    }

    public String toString() {
        return "CustomKeys{keys=" + this.keys + '}';
    }
}
