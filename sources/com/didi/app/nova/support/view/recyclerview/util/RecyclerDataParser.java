package com.didi.app.nova.support.view.recyclerview.util;

import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.data.BaseDataManager;
import java.util.Iterator;
import java.util.List;

public class RecyclerDataParser {
    public static <T extends BaseDataManager> T getDataManagerForPosition(List<BaseDataManager> list, int i) {
        Iterator<BaseDataManager> it = list.iterator();
        while (it.hasNext()) {
            T t = (BaseDataManager) it.next();
            int count = t.getCount();
            if (i < count) {
                return t;
            }
            i -= count;
        }
        throw new IllegalStateException("Invalid position for DataManager!");
    }

    public static <T> T getItemForPosition(List<BaseDataManager> list, int i) {
        int i2 = i;
        for (BaseDataManager next : list) {
            int count = next.getCount();
            if (i2 < count) {
                return next.get(i2);
            }
            i2 -= count;
        }
        throw new IllegalStateException("Item not found for position. position = " + i);
    }

    public static int getPositionInDataManager(List<BaseDataManager> list, int i) {
        int count;
        Iterator<BaseDataManager> it = list.iterator();
        while (it.hasNext() && i >= (count = it.next().getCount())) {
            i -= count;
        }
        return i;
    }

    public static int getItemPositionInRV(List<BaseDataManager> list, BaseDataManager baseDataManager, int i) {
        int indexOf = list.indexOf(baseDataManager);
        if (indexOf >= 0) {
            for (int i2 = 0; i2 < indexOf; i2++) {
                i += list.get(i2).getCount();
            }
            return i;
        }
        throw new IllegalStateException("BaseDataManager does not exist in adapter");
    }

    public static ItemBinder getBinderForPosition(List<BaseDataManager> list, List<ItemBinder> list2, int i) {
        Object itemForPosition = getItemForPosition(list, i);
        for (ItemBinder next : list2) {
            if (next.canBindData(itemForPosition)) {
                return next;
            }
        }
        throw new IllegalStateException("Binder not found for position. object = " + itemForPosition);
    }

    public static int getPositionForItem(List<BaseDataManager> list, Object obj) {
        int i = 0;
        for (BaseDataManager next : list) {
            int count = next.getCount();
            int i2 = 0;
            while (true) {
                if (i2 < count) {
                    if (next.get(i2).equals(obj)) {
                        return i;
                    }
                    i++;
                    i2++;
                }
            }
        }
        return -1;
    }
}
