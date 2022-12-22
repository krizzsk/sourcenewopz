package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

/* renamed from: com.google.android.play.core.internal.bq */
public final class C18469bq<T> {

    /* renamed from: a */
    private final Object f53163a;

    /* renamed from: b */
    private final Field f53164b;

    /* renamed from: c */
    private final Class<T> f53165c;

    C18469bq(Object obj, Field field, Class<T> cls) {
        this.f53163a = obj;
        this.f53164b = field;
        this.f53165c = cls;
    }

    C18469bq(Object obj, Field field, Class cls, byte[] bArr) {
        this(obj, field, Array.newInstance(cls, 0).getClass());
    }

    /* renamed from: c */
    private Class m37838c() {
        return mo149110b().getType().getComponentType();
    }

    /* renamed from: a */
    public final T mo149107a() {
        try {
            return this.f53165c.cast(this.f53164b.get(this.f53163a));
        } catch (Exception e) {
            throw new C18471bs(String.format("Failed to get value of field %s of type %s on object of type %s", new Object[]{this.f53164b.getName(), this.f53163a.getClass().getName(), this.f53165c.getName()}), e);
        }
    }

    /* renamed from: a */
    public final void mo149108a(T t) {
        try {
            this.f53164b.set(this.f53163a, t);
        } catch (Exception e) {
            throw new C18471bs(String.format("Failed to set value of field %s of type %s on object of type %s", new Object[]{this.f53164b.getName(), this.f53163a.getClass().getName(), this.f53165c.getName()}), e);
        }
    }

    /* renamed from: a */
    public void mo149109a(Collection collection) {
        Object[] objArr = (Object[]) mo149107a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance(m37838c(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (Object obj : collection) {
            objArr2[length] = obj;
            length++;
        }
        mo149108a(objArr2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final Field mo149110b() {
        return this.f53164b;
    }

    /* renamed from: b */
    public void mo149111b(Collection collection) {
        Object[] objArr = (Object[]) mo149107a();
        int i = 0;
        Object[] objArr2 = (Object[]) Array.newInstance(m37838c(), (objArr == null ? 0 : objArr.length) + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (Object obj : collection) {
            objArr2[i] = obj;
            i++;
        }
        mo149108a(objArr2);
    }
}
