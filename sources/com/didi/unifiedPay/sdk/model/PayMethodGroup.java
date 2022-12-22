package com.didi.unifiedPay.sdk.model;

import java.io.Serializable;
import java.util.List;

public class PayMethodGroup implements Serializable {
    public String icon;
    public String name;
    public List<Integer> payment_methods;
}
