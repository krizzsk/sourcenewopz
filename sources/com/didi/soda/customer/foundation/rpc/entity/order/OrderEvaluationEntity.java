package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;

public class OrderEvaluationEntity implements IEntity {
    private static final long serialVersionUID = -1454713626467127296L;
    public int evaluationEntry;
    public List<OrderEvaluationItemsListEntity> items;
    public RiderEvaluationEntity rider;
    public ShopEvaluationEntity shop;
}
