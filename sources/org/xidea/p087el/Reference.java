package org.xidea.p087el;

/* renamed from: org.xidea.el.Reference */
public interface Reference {
    Object getBase();

    Object getName();

    Class<? extends Object> getType();

    Object getValue();

    Reference next(Object obj);

    Object setValue(Object obj);
}
