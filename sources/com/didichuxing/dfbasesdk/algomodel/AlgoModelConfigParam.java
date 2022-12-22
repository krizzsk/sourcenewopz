package com.didichuxing.dfbasesdk.algomodel;

import java.io.Serializable;
import java.util.List;

public class AlgoModelConfigParam implements Serializable {
    public String appPac;
    public String appVer;
    public String baseSdkVer;
    public List<ParamModel> models;

    /* renamed from: os */
    public int f46487os;

    public String getAppVer() {
        return this.appVer;
    }

    public void setAppVer(String str) {
        this.appVer = str;
    }

    public String getAppPac() {
        return this.appPac;
    }

    public void setAppPac(String str) {
        this.appPac = str;
    }

    public int getOs() {
        return this.f46487os;
    }

    public void setOs(int i) {
        this.f46487os = i;
    }

    public List<ParamModel> getModels() {
        return this.models;
    }

    public void setModels(List<ParamModel> list) {
        this.models = list;
    }

    public static class ParamModel implements Serializable {
        public int background;
        public String md5;
        public String sdkVer;
        public int type;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public String getMd5() {
            return this.md5;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public String getSdkVer() {
            return this.sdkVer;
        }

        public void setSdkVer(String str) {
            this.sdkVer = str;
        }

        public int getBackground() {
            return this.background;
        }

        public void setBackground(int i) {
            this.background = i;
        }
    }
}
