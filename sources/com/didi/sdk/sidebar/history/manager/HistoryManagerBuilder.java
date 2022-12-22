package com.didi.sdk.sidebar.history.manager;

import com.didi.sdk.app.tap.BusinessConstants;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.sidebar.history.manager.impl.RideHistoryManagerImpl;
import com.didi.sdk.sidebar.history.manager.soda.FoodHistoryManagerImpl;

public class HistoryManagerBuilder {

    /* renamed from: d */
    private static HistoryManagerBuilder f37361d;

    /* renamed from: a */
    private IRideHistoryManager f37362a;

    /* renamed from: b */
    private IFoodHistoryManager f37363b;

    /* renamed from: c */
    private IBikeHistoryManager f37364c;

    private HistoryManagerBuilder() {
    }

    public static HistoryManagerBuilder getInstance() {
        if (f37361d == null) {
            synchronized (HistoryManagerBuilder.class) {
                if (f37361d == null) {
                    f37361d = new HistoryManagerBuilder();
                }
            }
        }
        return f37361d;
    }

    public IHistoryManager createHistoryManager(String str) {
        if ("ride".equals(str)) {
            if (this.f37362a == null) {
                this.f37362a = RideHistoryManagerImpl.getRideHistoryManager();
            }
            return this.f37362a;
        } else if ("soda".equals(str)) {
            if (this.f37363b == null) {
                this.f37363b = FoodHistoryManagerImpl.getFoodHistoryManager();
            }
            return this.f37363b;
        } else if (!BusinessConstants.TYPE_BIKE.equals(str)) {
            return null;
        } else {
            if (this.f37364c == null) {
                this.f37364c = (IBikeHistoryManager) ComponentLoadUtil.getComponent(IBikeHistoryManager.class);
            }
            return this.f37364c;
        }
    }
}
