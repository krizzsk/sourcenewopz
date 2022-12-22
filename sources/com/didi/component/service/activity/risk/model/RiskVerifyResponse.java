package com.didi.component.service.activity.risk.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import java.io.Serializable;
import java.util.ArrayList;

public class RiskVerifyResponse extends BaseObject {
    public RiskVerifyData data;

    public static class RiskVerifyData implements Serializable {
        public ArrayList<RiskVerifyListItem> verify_list;
    }
}
