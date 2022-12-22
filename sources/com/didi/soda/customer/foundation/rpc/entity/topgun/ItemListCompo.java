package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

class ItemListCompo implements IEntity {
    private static final long serialVersionUID = 2468490688926237149L;
    public String bizTimeDesc;
    @SerializedName("items")
    public List<GoodsItemEntity> mItems;
    public String shopId;
    public String shopImg;
    public String shopName;
    public String statusDesc;
    public List<PromptEntity> tags;
    public TitleInfo title;
    public ViewMoreEntity viewMoreCard;

    ItemListCompo() {
    }

    class TitleInfo implements IEntity {
        private static final long serialVersionUID = 2468490688926237159L;
        public String content;
        public String icon;

        TitleInfo() {
        }
    }
}
