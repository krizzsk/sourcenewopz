package com.didi.component.homedestination.model;

import com.didi.component.business.model.HomeCardModel;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HomeCardListResponse extends BaseObject {
    @SerializedName("rec_destination_new")
    public List<HomeCardModel> newDataList;
    public OrderBanCardInfo orderBanCardInfo;
    @SerializedName("search_id")
    public String searchId;
}
