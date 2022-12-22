package com.didi.soda.order.component.tips;

import com.didi.soda.jadux.Action;

public final class TipActionCreator {
    private TipActionCreator() {
    }

    public static Action<Integer> selectTip(int i) {
        return new Action<>(TipActionType.SELECT_TIP, Integer.valueOf(i));
    }

    public static Action<String> inputTip(String str) {
        return new Action<>(TipActionType.INPUT_TIP, str);
    }
}
