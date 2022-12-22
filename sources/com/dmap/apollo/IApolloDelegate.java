package com.dmap.apollo;

import com.didichuxing.apollo.sdk.IToggle;

public interface IApolloDelegate {
    IToggle getToggle(String str);

    IToggle getToggle(String str, boolean z);
}
