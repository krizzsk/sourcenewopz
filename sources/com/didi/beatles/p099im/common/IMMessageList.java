package com.didi.beatles.p099im.common;

import com.didi.beatles.p099im.module.entity.IMMessage;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.didi.beatles.im.common.IMMessageList */
public class IMMessageList<E extends IMMessage> extends ArrayList<IMMessage> {
    public boolean add(IMMessage iMMessage) {
        if (iMMessage != null && !contains(iMMessage)) {
            return super.add(iMMessage);
        }
        return false;
    }

    public boolean addAll(Collection<? extends IMMessage> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        return super.addAll(getNewList(collection));
    }

    public boolean addAll(int i, Collection<? extends IMMessage> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        return super.addAll(i, getNewList(collection));
    }

    private IMMessageList<IMMessage> getNewList(Collection<? extends IMMessage> collection) {
        IMMessageList<IMMessage> iMMessageList = new IMMessageList<>();
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            IMMessage iMMessage = (IMMessage) ((ArrayList) collection).get(i);
            if (!contains(iMMessage) && !iMMessageList.contains(iMMessage)) {
                iMMessageList.add(iMMessage);
            }
        }
        return iMMessageList;
    }

    public IMMessage remove(int i) {
        return (IMMessage) super.remove(i);
    }

    public int getLocation(Object obj) {
        if (obj != null && (obj instanceof IMMessage)) {
            IMMessage iMMessage = (IMMessage) obj;
            if (iMMessage.getType() == 107) {
                return -1;
            }
            Object[] array = toArray();
            int size = size();
            for (int i = 0; i < size; i++) {
                if (iMMessage.getUniqueId() == ((IMMessage) array[i]).getUniqueId()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        if (obj != null && (obj instanceof IMMessage)) {
            Object[] array = toArray();
            int size = size();
            IMMessage iMMessage = (IMMessage) obj;
            if (iMMessage.getType() == 107) {
                for (int i = 0; i < size; i++) {
                    if (((IMMessage) array[i]).getType() == 107 && iMMessage.getCreateTime() == ((IMMessage) array[i]).getCreateTime()) {
                        return true;
                    }
                }
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (iMMessage.getUniqueId() == ((IMMessage) array[i2]).getUniqueId()) {
                    return true;
                }
            }
        }
        return false;
    }
}
