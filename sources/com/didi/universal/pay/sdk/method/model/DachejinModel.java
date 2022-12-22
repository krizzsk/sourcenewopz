package com.didi.universal.pay.sdk.method.model;

import java.io.Serializable;
import java.util.Map;

public class DachejinModel implements Serializable {
    public boolean canceled;
    public String deduction_id;
    public Map other_info;
    public int type;
}
