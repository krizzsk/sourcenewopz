package com.didi.entrega.security.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;

public class RiskControlModel implements IEntity {
    public static final int CODE_CPF = 41059;
    public static final int CODE_CREDITCARD = 41056;
    public static final int CODE_CURP = 41058;
    public static final int CODE_EFO = 41067;
    public static final int CODE_FACEBOOK = 41057;
    public static final int CODE_REGULAR = 41069;
    private static final long serialVersionUID = 8439762769243404607L;
    public String frontMsg;
    public int riskCode;
    public List<Integer> subCodeList;
}
