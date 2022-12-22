package com.didi.soda.customer.foundation.rpc.entity.topgun;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.ActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.BannerEntity;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.HomeEfoInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.TabsEntity;
import com.didi.soda.customer.foundation.rpc.entity.TaskCenterEntity;
import com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.TofuEntity;
import com.didi.soda.datasource.parser.Parsable;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ComponentEntity implements IEntity, Parsable {
    private static final long serialVersionUID = -8354660173949041625L;
    @SerializedName("countDown")
    public ActivityInfoEntity.CountDownInfo countDown;
    @SerializedName("data")
    public JsonObject data;
    @SerializedName("header")
    public ActivityInfoEntity.HeaderInfo header;
    @SerializedName("bannerList")
    public List<BannerEntity> mBannerList;
    @SerializedName("bgImg")
    public String mBgImg;
    @SerializedName("btnText")
    public String mBtnText;
    @SerializedName("shop")
    public BusinessInfoEntity mBusinessInfo;
    @SerializedName("componentId")
    public String mComponentId;
    @SerializedName("componentV2")
    public TemplateTagEntity mComponentV2;
    @SerializedName("efo")
    public HomeEfoInfoEntity mEfoInfoEntity;
    @SerializedName("filterList")
    public List<FilterEntity> mFilterList;
    @SerializedName("itemList")
    public ItemListCompo mItemListCompo;
    @SerializedName("itemsLine")
    public ItemsLineCompo mItemsLineCompo;
    @SerializedName("unfinishedOrderList")
    public List<OrderInfoEntity> mOrderList;
    @SerializedName("position")
    public int mPosition;
    @SerializedName("shopList")
    public List<BusinessInfoEntity> mShopList;
    @SerializedName("subTitle")
    public String mSubTitle;
    @SerializedName("tabsInfo")
    public TabsEntity mTabsInfo;
    @SerializedName("title")
    public String mTitle;
    @SerializedName("tofuList")
    public List<TofuEntity> mTofuList;
    @SerializedName("topicComp")
    public HomeTopicEntity mTopicComp;
    @SerializedName("type")
    public String mType;
    @SerializedName("noResult")
    public JsonObject noResult;
    @SerializedName("taskCenter")
    public TaskCenterEntity taskCenter;

    public String getType() {
        if (!TextUtils.isEmpty(this.mType)) {
            return this.mType;
        }
        TemplateTagEntity templateTagEntity = this.mComponentV2;
        return (templateTagEntity == null || TextUtils.isEmpty(templateTagEntity.getTmplType())) ? "" : this.mComponentV2.getTmplType();
    }
}
