package com.dmap.navigation.api.core;

import com.dmap.navigation.base.route.IRoute;
import java.util.List;

public interface INaviPlanner {

    public interface Callback {
        void onBegin(int i);

        void onFinish(List<IRoute> list, int i, int i2);

        void onRetry(int i);
    }

    public enum Type {
        YAW,
        PARALLEL,
        ELEVATED,
        MULTI
    }

    void cancel();

    void enqueue(Callback callback);
}
