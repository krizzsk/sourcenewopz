package com.dmap.apollo;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloDelegateImpl implements IApolloDelegate {
    public IToggle getToggle(String str) {
        return Apollo.getToggle(str);
    }

    public IToggle getToggle(String str, boolean z) {
        return Apollo.getToggle(str, z);
    }
}
