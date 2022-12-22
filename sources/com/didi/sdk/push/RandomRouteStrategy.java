package com.didi.sdk.push;

import java.util.List;
import java.util.Random;

class RandomRouteStrategy implements IRouteStrategy {
    private Random random = new Random();

    RandomRouteStrategy() {
    }

    public String select(List<String> list) {
        return list.get(this.random.nextInt(list.size()));
    }
}
