package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class BusinessBuyMoreEntity implements IEntity {
    private static final long serialVersionUID = 5260926912026436604L;
    public String buyTimeDesc;
    public String cateId;
    public String cateName;
    public String currency;
    public List<GoodsItemEntity> items;
    public int price;
    public String title;
}
