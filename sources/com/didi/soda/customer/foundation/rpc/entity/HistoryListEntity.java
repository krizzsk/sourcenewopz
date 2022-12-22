package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class HistoryListEntity implements IEntity {
    private static final long serialVersionUID = -3404465099451470441L;
    public int haveNext;
    public int mhaveNext;
    public String nextText;
    public List<HistoryItemEntity> orderDone;
    public int orderNum;
    public List<HistoryItemEntity> orderWaiting;
    public String timeMode;
    public String toast;
}
