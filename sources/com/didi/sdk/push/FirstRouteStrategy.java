package com.didi.sdk.push;

import java.util.List;

class FirstRouteStrategy implements IRouteStrategy {
    FirstRouteStrategy() {
    }

    public String select(List<String> list) {
        return list.get(0);
    }
}
