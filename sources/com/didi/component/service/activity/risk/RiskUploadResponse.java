package com.didi.component.service.activity.risk;

import com.didi.travel.psnger.common.net.base.BaseObject;

public class RiskUploadResponse extends BaseObject {
    public Data data;

    public static final class Data {
        public String reason;
        public int risk;
        public int verify;
    }
}
