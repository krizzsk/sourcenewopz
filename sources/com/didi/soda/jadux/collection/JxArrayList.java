package com.didi.soda.jadux.collection;

import com.didi.soda.jadux.function.JxFunction0;
import java.util.ArrayList;
import java.util.Iterator;
import p242io.reactivex.functions.BiFunction;

public class JxArrayList<E> extends ArrayList<E> implements JxList<E> {
    public <R> JxList<R> map(JxFunction0<E, R> jxFunction0) {
        JxArrayList jxArrayList = new JxArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            jxArrayList.add(jxFunction0.invoke(it.next()));
        }
        return jxArrayList;
    }

    public JxList<E> filter(JxFunction0<E, Boolean> jxFunction0) {
        JxList<E> copy = copy();
        Iterator it = copy.iterator();
        while (it.hasNext()) {
            if (!jxFunction0.invoke(it.next()).booleanValue()) {
                it.remove();
            }
        }
        return copy;
    }

    public JxList<E> copy() {
        JxArrayList jxArrayList = new JxArrayList();
        jxArrayList.addAll(this);
        return jxArrayList;
    }

    public JxList<E> forEach(JxFunction0<E, E> jxFunction0) {
        Iterator it = iterator();
        while (it.hasNext()) {
            jxFunction0.invoke(it.next());
        }
        return this;
    }

    public E reduce(BiFunction<E, E, E> biFunction) throws Exception {
        int size = size();
        if (size != 0) {
            E e = get(0);
            for (int i = 1; i < size - 1; i++) {
                e = biFunction.apply(e, get(i));
            }
            return e;
        }
        throw new IllegalArgumentException("List can't not be null or empty!");
    }
}
