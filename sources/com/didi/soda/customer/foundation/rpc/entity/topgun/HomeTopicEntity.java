package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HomeTopicEntity implements IEntity {
    private static final long serialVersionUID = 1603351199153623883L;
    public ActInfoEntity actInfo;
    public BgColorBean bgColor;
    public String bgImg;
    public String componentId;
    public CountDownEntity countDown;
    public String iconImg;
    @SerializedName("items")
    public List<GoodsItemEntity> mItems;
    @SerializedName("shops")
    public List<BusinessInfoEntity> mShopList;
    @SerializedName("topicTitle")
    public String mTopicTitle;
    @SerializedName("viewMoreCard")
    public ViewMoreEntity mViewMore;
    public String ruleDesc;
    @SerializedName("scene")
    public int scene;
    public String tabId;
    public TitleBean title;

    public static class BgColorBean implements IEntity {
        private static final long serialVersionUID = -4737083996148463491L;
        public int angle;
        public List<String> color;
    }

    public static class TitleBean implements IEntity {
        private static final long serialVersionUID = 8874351766377158244L;
        public String content;
        public String icon;
    }
}
