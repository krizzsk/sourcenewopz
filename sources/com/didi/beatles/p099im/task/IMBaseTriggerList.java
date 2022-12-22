package com.didi.beatles.p099im.task;

import com.didi.beatles.p099im.task.IMTriggerList;
import java.util.List;

/* renamed from: com.didi.beatles.im.task.IMBaseTriggerList */
public interface IMBaseTriggerList<T> {
    boolean ExecuteAll(boolean z);

    boolean add(T t);

    void addAll(List<T> list);

    void addTriggerListener(IMTriggerList.IMTriggerListener<T> iMTriggerListener);

    void clear();

    boolean isAllExecuted();

    boolean remove(T t);

    void removeAll(List<T> list);

    void removeHasExecuted();
}
