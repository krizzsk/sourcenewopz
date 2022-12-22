package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationItemsListEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "itemId", "", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "itemImg", "getItemImg", "setItemImg", "itemName", "getItemName", "setItemName", "score", "", "getScore", "()I", "setScore", "(I)V", "scoreInfo", "", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationScoreInfoEntity;", "getScoreInfo", "()Ljava/util/List;", "setScoreInfo", "(Ljava/util/List;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderEvaluationItemsListEntity.kt */
public final class OrderEvaluationItemsListEntity implements IEntity {
    private String itemId;
    private String itemImg;
    private String itemName;
    private int score;
    private List<? extends OrderEvaluationScoreInfoEntity> scoreInfo;

    public final String getItemId() {
        return this.itemId;
    }

    public final void setItemId(String str) {
        this.itemId = str;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public final void setItemName(String str) {
        this.itemName = str;
    }

    public final String getItemImg() {
        return this.itemImg;
    }

    public final void setItemImg(String str) {
        this.itemImg = str;
    }

    public final int getScore() {
        return this.score;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    public final List<OrderEvaluationScoreInfoEntity> getScoreInfo() {
        return this.scoreInfo;
    }

    public final void setScoreInfo(List<? extends OrderEvaluationScoreInfoEntity> list) {
        this.scoreInfo = list;
    }
}
