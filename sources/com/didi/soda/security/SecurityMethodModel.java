package com.didi.soda.security;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class SecurityMethodModel implements IEntity {
    private static final long serialVersionUID = 3944854184355690445L;
    public String cid;
    public int code;
    public boolean isEnable;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.code == ((SecurityMethodModel) obj).code) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.code;
    }
}
