package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.search.repo.SearchHotWordsModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SearchRecommendTagEntity implements IEntity {
    private static final long serialVersionUID = -2279829379842298377L;
    @SerializedName("recId")
    public String mRecId;
    @SerializedName("recommendShop")
    public List<SearchShopsTagEntity> mRecommendShopList;
    @SerializedName("recommend")
    public List<SearchTag> mRecommendTagList;
    @SerializedName("hotWords")
    public List<SearchHotWordsEntity> mSearchHotWordsList;

    public List<SearchHotWordsModel> getTagStringList() {
        List<SearchHotWordsEntity> list = this.mSearchHotWordsList;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SearchHotWordsEntity convert2Model : this.mSearchHotWordsList) {
            SearchHotWordsModel convert2Model2 = SearchHotWordsModel.convert2Model(convert2Model);
            if (convert2Model2 != null) {
                arrayList.add(convert2Model2);
            }
        }
        return arrayList;
    }
}
