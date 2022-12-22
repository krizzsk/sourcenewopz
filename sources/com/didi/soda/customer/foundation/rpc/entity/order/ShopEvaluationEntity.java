package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;

public class ShopEvaluationEntity implements IEntity {
    private static final long serialVersionUID = 1148417653751247082L;
    public List<OrderEvaluationTagEntity> badTag;
    public String content;
    public String defaultBadTagContent;
    public String defaultContent;
    public String defaultGoodTagContent;
    public List<OrderEvaluationTagEntity> goodTag;
    public boolean hasEval;
    public int hasEvalScore;
    public List<Integer> hasEvalTags;
    public List<String> imgs;
    public String popUpTitle;
    public int score;
    public String scoreDesc;
    public List<OrderEvaluationScoreInfoEntity> scoreInfo;
    public String shopId;
    public String shopImg;
    public String shopName;
    public List<Integer> tagIds;
    public List<String> tags;
}
