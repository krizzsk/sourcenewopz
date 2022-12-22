package com.didi.map.global.component.departure.bubble;

import android.view.ViewGroup;

public class DepartureBubbleFactory {
    public static <T extends DepartureBubble> T createDepartureBubble(Class<T> cls, ViewGroup viewGroup) {
        if (!(cls == null || viewGroup == null)) {
            try {
                return (DepartureBubble) cls.getConstructor(new Class[]{ViewGroup.class}).newInstance(new Object[]{viewGroup});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
