package com.didichuxing.diface.biz.guide.p183M;

import com.didichuxing.diface.core.BaseParam;
import java.io.Serializable;

/* renamed from: com.didichuxing.diface.biz.guide.M.GuideParam */
public class GuideParam extends BaseParam implements Serializable {
    public int bizCode;
    public String data;
    public String modelVersion;
    public String sdkVersion;
    public String sessionId;

    public int getBizCode() {
        return this.bizCode;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getData() {
        return this.data;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getModelVersion() {
        return this.modelVersion;
    }
}
