package com.p222hp.hpl.sparta;

import java.util.Hashtable;

/* renamed from: com.hp.hpl.sparta.Sparta */
public class Sparta {

    /* renamed from: a */
    private static Internment f53880a = new Internment() {
        private final Hashtable strings_ = new Hashtable();

        public String intern(String str) {
            String str2 = (String) this.strings_.get(str);
            if (str2 != null) {
                return str2;
            }
            this.strings_.put(str, str);
            return str;
        }
    };

    /* renamed from: b */
    private static CacheFactory f53881b = new CacheFactory() {
        public Cache create() {
            return new HashtableCache();
        }
    };

    /* renamed from: com.hp.hpl.sparta.Sparta$Cache */
    public interface Cache {
        Object get(Object obj);

        Object put(Object obj, Object obj2);

        int size();
    }

    /* renamed from: com.hp.hpl.sparta.Sparta$CacheFactory */
    public interface CacheFactory {
        Cache create();
    }

    /* renamed from: com.hp.hpl.sparta.Sparta$Internment */
    public interface Internment {
        String intern(String str);
    }

    public static String intern(String str) {
        return f53880a.intern(str);
    }

    public static void setInternment(Internment internment) {
        f53880a = internment;
    }

    /* renamed from: a */
    static Cache m38549a() {
        return f53881b.create();
    }

    public static void setCacheFactory(CacheFactory cacheFactory) {
        f53881b = cacheFactory;
    }

    /* renamed from: com.hp.hpl.sparta.Sparta$HashtableCache */
    private static class HashtableCache extends Hashtable implements Cache {
        private HashtableCache() {
        }
    }
}
