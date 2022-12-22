package com.didi.sdk.fastframe.view.systembar;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BuildProperties {

    /* renamed from: a */
    private final Properties f35933a;

    private BuildProperties() throws IOException {
        Properties properties = new Properties();
        this.f35933a = properties;
        properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
    }

    public boolean containsKey(Object obj) {
        return this.f35933a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f35933a.containsValue(obj);
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.f35933a.entrySet();
    }

    public String getProperty(String str) {
        return this.f35933a.getProperty(str);
    }

    public String getProperty(String str, String str2) {
        return this.f35933a.getProperty(str, str2);
    }

    public boolean isEmpty() {
        return this.f35933a.isEmpty();
    }

    public Enumeration<Object> keys() {
        return this.f35933a.keys();
    }

    public Set<Object> keySet() {
        return this.f35933a.keySet();
    }

    public int size() {
        return this.f35933a.size();
    }

    public Collection<Object> values() {
        return this.f35933a.values();
    }

    public static BuildProperties newInstance() throws IOException {
        return new BuildProperties();
    }
}
