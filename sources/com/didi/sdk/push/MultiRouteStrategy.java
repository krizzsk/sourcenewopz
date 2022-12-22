package com.didi.sdk.push;

import java.util.List;

class MultiRouteStrategy implements IRouteStrategy {
    private static final String CONNECTOR = "_";

    MultiRouteStrategy() {
    }

    public String select(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append(append);
            sb.append("_");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
