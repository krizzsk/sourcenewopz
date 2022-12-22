package com.didi.soda.search.component.suggestion;

import android.os.Bundle;
import com.didi.soda.customer.foundation.rpc.entity.SearchSuggestionEntity;
import com.didi.soda.jadux.Action;
import com.didichuxing.omega.sdk.feedback.FeedbackConfig;

public final class SearchSuggestionActionCreator {
    public static final String CLEAR_SUGGESTION = "com.didi.soda.search.component.suggestion.clear";
    public static final String UPDATE_SEARCH_SUGGESTION = "com.didi.soda.search.component.suggestion.update_suggstion";

    private SearchSuggestionActionCreator() {
    }

    public static Action<Bundle> updateSuggestion(String str, SearchSuggestionEntity searchSuggestionEntity) {
        Bundle bundle = new Bundle();
        bundle.putString("key", str);
        bundle.putSerializable(FeedbackConfig.FT_SUG, searchSuggestionEntity);
        return new Action<>(UPDATE_SEARCH_SUGGESTION, bundle);
    }

    public static Action<Integer> clearSuggestion() {
        return new Action<>(CLEAR_SUGGESTION, 1);
    }
}
