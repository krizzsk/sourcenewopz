package com.didichuxing.alpha.crash.dump;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import rui.config.RConfigConstants;

public final class ExcludedRefs implements Serializable {
    public final Map<String, Exclusion> classNames;
    public final Map<String, Map<String, Exclusion>> fieldNameByClassName;
    public final Map<String, Map<String, Exclusion>> staticFieldNameByClassName;
    public final Map<String, Exclusion> threadNames;

    public interface Builder {
        ExcludedRefs build();

        BuilderWithParams clazz(String str);

        BuilderWithParams instanceField(String str, String str2);

        BuilderWithParams staticField(String str, String str2);

        BuilderWithParams thread(String str);
    }

    public static Builder builder() {
        return new BuilderWithParams();
    }

    ExcludedRefs(BuilderWithParams builderWithParams) {
        this.fieldNameByClassName = unmodifiableRefStringMap(builderWithParams.fieldNameByClassName);
        this.staticFieldNameByClassName = unmodifiableRefStringMap(builderWithParams.staticFieldNameByClassName);
        this.threadNames = unmodifiableRefMap(builderWithParams.threadNames);
        this.classNames = unmodifiableRefMap(builderWithParams.classNames);
    }

    private Map<String, Map<String, Exclusion>> unmodifiableRefStringMap(Map<String, Map<String, ParamsBuilder>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(next.getKey(), unmodifiableRefMap((Map) next.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private Map<String, Exclusion> unmodifiableRefMap(Map<String, ParamsBuilder> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(next.getKey(), new Exclusion((ParamsBuilder) next.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = "";
        for (Map.Entry next : this.fieldNameByClassName.entrySet()) {
            String str2 = (String) next.getKey();
            for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                str = str + "| Field: " + str2 + "." + ((String) entry.getKey()) + (((Exclusion) entry.getValue()).alwaysExclude ? " (always)" : "") + "\n";
            }
        }
        for (Map.Entry next2 : this.staticFieldNameByClassName.entrySet()) {
            String str3 = (String) next2.getKey();
            for (Map.Entry entry2 : ((Map) next2.getValue()).entrySet()) {
                str = str + "| Static field: " + str3 + "." + ((String) entry2.getKey()) + (((Exclusion) entry2.getValue()).alwaysExclude ? " (always)" : "") + "\n";
            }
        }
        for (Map.Entry next3 : this.threadNames.entrySet()) {
            str = str + "| Thread:" + ((String) next3.getKey()) + (((Exclusion) next3.getValue()).alwaysExclude ? " (always)" : "") + "\n";
        }
        for (Map.Entry next4 : this.classNames.entrySet()) {
            str = str + "| Class:" + ((String) next4.getKey()) + (((Exclusion) next4.getValue()).alwaysExclude ? " (always)" : "") + "\n";
        }
        return str;
    }

    static final class ParamsBuilder {
        boolean alwaysExclude;
        final String matching;
        String name;
        String reason;

        ParamsBuilder(String str) {
            this.matching = str;
        }
    }

    public static final class BuilderWithParams implements Builder {
        /* access modifiers changed from: private */
        public final Map<String, ParamsBuilder> classNames = new LinkedHashMap();
        /* access modifiers changed from: private */
        public final Map<String, Map<String, ParamsBuilder>> fieldNameByClassName = new LinkedHashMap();
        private ParamsBuilder lastParams;
        /* access modifiers changed from: private */
        public final Map<String, Map<String, ParamsBuilder>> staticFieldNameByClassName = new LinkedHashMap();
        /* access modifiers changed from: private */
        public final Map<String, ParamsBuilder> threadNames = new LinkedHashMap();

        BuilderWithParams() {
        }

        public BuilderWithParams instanceField(String str, String str2) {
            Preconditions.checkNotNull(str, "className");
            Preconditions.checkNotNull(str2, "fieldName");
            Map map = this.fieldNameByClassName.get(str);
            if (map == null) {
                map = new LinkedHashMap();
                this.fieldNameByClassName.put(str, map);
            }
            ParamsBuilder paramsBuilder = new ParamsBuilder("field " + str + RConfigConstants.KEYWORD_COLOR_SIGN + str2);
            this.lastParams = paramsBuilder;
            map.put(str2, paramsBuilder);
            return this;
        }

        public BuilderWithParams staticField(String str, String str2) {
            Preconditions.checkNotNull(str, "className");
            Preconditions.checkNotNull(str2, "fieldName");
            Map map = this.staticFieldNameByClassName.get(str);
            if (map == null) {
                map = new LinkedHashMap();
                this.staticFieldNameByClassName.put(str, map);
            }
            ParamsBuilder paramsBuilder = new ParamsBuilder("static field " + str + RConfigConstants.KEYWORD_COLOR_SIGN + str2);
            this.lastParams = paramsBuilder;
            map.put(str2, paramsBuilder);
            return this;
        }

        public BuilderWithParams thread(String str) {
            Preconditions.checkNotNull(str, "threadName");
            ParamsBuilder paramsBuilder = new ParamsBuilder("any threads named " + str);
            this.lastParams = paramsBuilder;
            this.threadNames.put(str, paramsBuilder);
            return this;
        }

        public BuilderWithParams clazz(String str) {
            Preconditions.checkNotNull(str, "className");
            ParamsBuilder paramsBuilder = new ParamsBuilder("any subclass of " + str);
            this.lastParams = paramsBuilder;
            this.classNames.put(str, paramsBuilder);
            return this;
        }

        public BuilderWithParams named(String str) {
            this.lastParams.name = str;
            return this;
        }

        public BuilderWithParams reason(String str) {
            this.lastParams.reason = str;
            return this;
        }

        public BuilderWithParams alwaysExclude() {
            this.lastParams.alwaysExclude = true;
            return this;
        }

        public ExcludedRefs build() {
            return new ExcludedRefs(this);
        }
    }
}
