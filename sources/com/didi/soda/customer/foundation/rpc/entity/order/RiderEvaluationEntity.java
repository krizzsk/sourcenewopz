package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;

public class RiderEvaluationEntity implements IEntity {
    private static final long serialVersionUID = -8831304870940426872L;
    public List<OrderEvaluationTagEntity> badTag;
    public String content;
    public String defaultBadTagContent;
    public String defaultContent;
    public String defaultGoodTagContent;
    public List<OrderEvaluationTagEntity> goodTag;
    public boolean hasEval;
    public int hasEvalScore;
    public List<Integer> hasEvalTags;
    public String orderFinishTime;
    public String popUpTitle;
    public String riderArrivalTime;
    public String riderId;
    public String riderImg;
    public String riderName;
    public int score;
    public String scoreDesc;
    public List<OrderEvaluationScoreInfoEntity> scoreInfo;
    public List<Integer> tagIds;
    public List<String> tags;
}
