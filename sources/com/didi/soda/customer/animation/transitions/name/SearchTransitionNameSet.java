package com.didi.soda.customer.animation.transitions.name;

import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public final class SearchTransitionNameSet {

    /* renamed from: a */
    private static String f40304a;

    private SearchTransitionNameSet() {
    }

    public static String getNormalTransitionName() {
        if (f40304a == null) {
            f40304a = ResourceHelper.getString(R.string.customer_transition_tag_search_home_search_box);
        }
        return f40304a;
    }
}
