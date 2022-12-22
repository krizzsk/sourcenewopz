package com.didi.address.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtil {
    public static boolean useRecCache() {
        IToggle toggle = Apollo.getToggle("global_passage_sug_recCache");
        return toggle != null && toggle.allow();
    }
}
