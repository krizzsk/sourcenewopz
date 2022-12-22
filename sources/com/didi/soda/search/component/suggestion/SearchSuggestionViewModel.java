package com.didi.soda.search.component.suggestion;

import android.text.TextUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.foundation.rpc.entity.SugCompEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

public final class SearchSuggestionViewModel implements RecyclerModel {
    public String input;
    public int size;
    public SugCompEntity sugCompEntity;
    public String sugId;
    public int sugIndex;
    public String traceId;
    public String word;

    private SearchSuggestionViewModel(String str, String str2, String str3) {
        this.sugId = str;
        this.word = str2;
        this.input = str3;
    }

    public static List<RecyclerModel> convertToViewModel(SearchSuggestionState searchSuggestionState) {
        ArrayList arrayList = new ArrayList();
        if (searchSuggestionState.sugList != null && searchSuggestionState.sugList.size() > 0) {
            for (int i = 0; i < searchSuggestionState.sugList.size(); i++) {
                SugCompEntity sugCompEntity2 = searchSuggestionState.sugList.get(i);
                if (sugCompEntity2 != null) {
                    Object obj = null;
                    if (sugCompEntity2.getComponentV2() != null && !TextUtils.isEmpty(sugCompEntity2.getComponentV2().getTmplId()) && sugCompEntity2.getShop() != null && !TextUtils.isEmpty(sugCompEntity2.getShop().getShopName())) {
                        sugCompEntity2.setRecId(searchSuggestionState.sugId);
                        sugCompEntity2.setPosition(i);
                        sugCompEntity2.setTraceId(searchSuggestionState.traceId);
                        obj = m31086a(sugCompEntity2);
                    } else if (!TextUtils.isEmpty(sugCompEntity2.getWord())) {
                        obj = m31087a(searchSuggestionState, sugCompEntity2.getWord(), true);
                    }
                    arrayList.add(obj);
                }
            }
        } else if (searchSuggestionState.suggestions != null && searchSuggestionState.suggestions.size() > 0) {
            for (String next : searchSuggestionState.suggestions) {
                if (!TextUtils.isEmpty(next)) {
                    arrayList.add(m31087a(searchSuggestionState, next, false));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static SearchSuggestionViewModel m31087a(SearchSuggestionState searchSuggestionState, String str, Boolean bool) {
        SearchSuggestionViewModel searchSuggestionViewModel = new SearchSuggestionViewModel(searchSuggestionState.sugId, str, searchSuggestionState.searchKey);
        searchSuggestionViewModel.traceId = searchSuggestionState.traceId;
        if (!bool.booleanValue()) {
            searchSuggestionViewModel.size = searchSuggestionState.suggestions.size();
        } else {
            searchSuggestionViewModel.size = searchSuggestionState.sugList.size();
        }
        searchSuggestionViewModel.sugIndex = searchSuggestionState.sugIndex;
        return searchSuggestionViewModel;
    }

    /* renamed from: a */
    private static ComponentModel m31086a(SugCompEntity sugCompEntity2) {
        ComponentModel componentModel = new ComponentModel();
        JsonParser jsonParser = new JsonParser();
        componentModel.setTemplateId(sugCompEntity2.getComponentV2().getTmplId());
        if (sugCompEntity2.getComponentV2().getTmplId() != null) {
            componentModel.setWidgetNodeModel(BlocksEngine.Companion.getInstance().buildWidgetNode(sugCompEntity2.getComponentV2().getTmplId(), (JsonObject) jsonParser.parse(GsonUtil.toJson(sugCompEntity2)), componentModel));
        }
        return componentModel;
    }
}
