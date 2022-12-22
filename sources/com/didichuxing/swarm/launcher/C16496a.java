package com.didichuxing.swarm.launcher;

import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/* renamed from: com.didichuxing.swarm.launcher.a */
/* compiled from: BundleDependency */
class C16496a {

    /* renamed from: a */
    private static final String f49189a = "BundleDependency";

    /* renamed from: b */
    private static final JsonParser f49190b = new JsonParser();

    /* renamed from: c */
    private final Bundle f49191c;

    /* renamed from: d */
    private final Map<String, C16497b> f49192d;

    /* renamed from: e */
    private final Map<String, String> f49193e = new HashMap();

    public C16496a(Map<String, C16497b> map, Bundle bundle) {
        this.f49191c = bundle;
        this.f49192d = map;
        String str = bundle.getHeaders().get("Bundle-Dependency");
        if (!TextUtils.isEmpty(str)) {
            for (Map.Entry next : f49190b.parse(str).getAsJsonObject().entrySet()) {
                this.f49193e.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
            }
        }
    }

    /* renamed from: a */
    public List<C16496a> mo121203a() throws BundleException {
        if (this.f49193e.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String next : this.f49193e.keySet()) {
            if (this.f49192d.containsKey(next)) {
                Map<String, C16497b> map = this.f49192d;
                arrayList.add(new C16496a(map, map.get(next).mo121207b()));
            } else {
                throw new BundleException("Bundle " + next + " not found", 4);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo121204b() throws BundleException {
        C16497b bVar = this.f49192d.get(this.f49191c.getSymbolicName());
        if (bVar == null) {
            return;
        }
        if (bVar == null || !bVar.mo121206a()) {
            if (!this.f49193e.isEmpty()) {
                for (C16496a b : mo121203a()) {
                    b.mo121204b();
                }
            }
            this.f49191c.start();
            bVar.mo121205a(true);
        }
    }
}
