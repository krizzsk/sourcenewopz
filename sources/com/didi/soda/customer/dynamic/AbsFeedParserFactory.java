package com.didi.soda.customer.dynamic;

import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.dynamic.AbsFeedParser;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.datasource.parser.Parsable;
import com.didi.soda.datasource.parser.ParserMeta;
import java.util.HashMap;

public abstract class AbsFeedParserFactory<T extends AbsFeedParser> {

    /* renamed from: a */
    private final HashMap<String, Class<? extends T>> f40885a = new HashMap<>();

    public abstract void initParser();

    public T getParser(Parsable parsable) {
        if (parsable == null) {
            return null;
        }
        Class cls = this.f40885a.get(parsable.getType());
        if (cls == null) {
            initParser();
            cls = this.f40885a.get(parsable.getType());
            if (cls == null) {
                return null;
            }
        }
        return (AbsFeedParser) SingletonFactory.get(cls);
    }

    public T getParser(String str) {
        if (TextUtil.isEmpty(str)) {
            return null;
        }
        Class cls = this.f40885a.get(str);
        if (cls == null) {
            initParser();
            cls = this.f40885a.get(str);
            if (cls == null) {
                return null;
            }
        }
        return (AbsFeedParser) SingletonFactory.get(cls);
    }

    public void registerParser(Class<? extends T> cls) {
        if (cls.isAnnotationPresent(ParserMeta.class)) {
            ParserMeta parserMeta = (ParserMeta) cls.getAnnotation(ParserMeta.class);
            synchronized (this.f40885a) {
                for (String put : parserMeta.type()) {
                    this.f40885a.put(put, cls);
                }
            }
        } else if (CustomerToolBoxUtil.DEBUG) {
            throw new IllegalStateException("You should impl ParserMeta annotation before registerParser.");
        }
    }
}
