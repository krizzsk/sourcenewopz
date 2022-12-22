package com.didi.entrega.customer.foundation.push.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.io.Serializable;

public class AbsPushModel<T extends Serializable> implements IEntity {
    private static final long serialVersionUID = -4494833456187786193L;
    public T data;
    public long time;
    public int type;
}
