package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.datasource.parser.Parsable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ComponentEntity implements IEntity, Parsable {
    private static final long serialVersionUID = 4459105733544870850L;
    @SerializedName("banner")
    public List<BannerEntity> mBannerEntityList;
    @SerializedName("shop")
    public BusinessInfoEntity mBusinessInfoEntity;
    @SerializedName("componentV2")
    public TemplateTagEntity mComponentV2;
    @SerializedName("searchWords")
    public SearchWordsEntity mSearchWordsEntity;
    @SerializedName("shopSlide")
    public List<BusinessInfoEntity> mSlideBusinessInfoEntity;
    public String type = "";

    public String getType() {
        return this.type;
    }
}
