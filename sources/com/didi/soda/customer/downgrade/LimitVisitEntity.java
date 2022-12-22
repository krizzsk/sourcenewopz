package com.didi.soda.customer.downgrade;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.ArrayList;

public class LimitVisitEntity implements IEntity {
    private static final long serialVersionUID = 5812360082315854887L;
    public ArrayList<String> blackList;
    public boolean isOpen;
    public int limitRandomTime;
    public int limitTime;
}
