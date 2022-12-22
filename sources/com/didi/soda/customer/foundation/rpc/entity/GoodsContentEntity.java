package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class GoodsContentEntity implements IEntity {
    private static final long serialVersionUID = -5488192702136101897L;
    public int buyMode;
    public String contentId;
    public String contentName;
    public int isMust;
    public int maxItemNum;
    public int minItemNum;
    public List<GoodsSubItemEntity> subItemList;
}
