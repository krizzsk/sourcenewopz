package com.koushikdutta.async.http.cache;

import android.text.TextUtils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: com.koushikdutta.async.http.cache.b */
/* compiled from: RawHeaders */
final class C20217b {

    /* renamed from: a */
    private static final Comparator<String> f55349a = new RawHeaders$1();

    /* renamed from: b */
    private final List<String> f55350b = new ArrayList(20);

    /* renamed from: c */
    private String f55351c;

    /* renamed from: d */
    private int f55352d = 1;

    /* renamed from: e */
    private int f55353e = -1;

    /* renamed from: f */
    private String f55354f;

    public C20217b() {
    }

    public C20217b(C20217b bVar) {
        mo164283a(bVar);
    }

    /* renamed from: a */
    public void mo164283a(C20217b bVar) {
        this.f55350b.addAll(bVar.f55350b);
        this.f55351c = bVar.f55351c;
        this.f55352d = bVar.f55352d;
        this.f55353e = bVar.f55353e;
        this.f55354f = bVar.f55354f;
    }

    /* renamed from: a */
    public void mo164284a(String str) {
        String trim = str.trim();
        this.f55351c = trim;
        if (trim != null && trim.startsWith("HTTP/")) {
            String trim2 = trim.trim();
            int indexOf = trim2.indexOf(" ") + 1;
            if (indexOf != 0) {
                if (trim2.charAt(indexOf - 2) != '1') {
                    this.f55352d = 0;
                }
                int i = indexOf + 3;
                if (i > trim2.length()) {
                    i = trim2.length();
                }
                this.f55353e = Integer.parseInt(trim2.substring(indexOf, i));
                int i2 = i + 1;
                if (i2 <= trim2.length()) {
                    this.f55354f = trim2.substring(i2);
                }
            }
        }
    }

    /* renamed from: a */
    public String mo164281a() {
        return this.f55351c;
    }

    /* renamed from: b */
    public int mo164287b() {
        int i = this.f55352d;
        if (i != -1) {
            return i;
        }
        return 1;
    }

    /* renamed from: c */
    public int mo164291c() {
        return this.f55353e;
    }

    /* renamed from: d */
    public String mo164293d() {
        return this.f55354f;
    }

    /* renamed from: b */
    public void mo164289b(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf == -1) {
            mo164285a("", str);
        } else {
            mo164285a(str.substring(0, indexOf), str.substring(indexOf + 1));
        }
    }

    /* renamed from: a */
    public void mo164285a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("fieldName == null");
        } else if (str2 == null) {
            PrintStream printStream = System.err;
            printStream.println("Ignoring HTTP header field '" + str + "' because its value is null");
        } else {
            this.f55350b.add(str);
            this.f55350b.add(str2.trim());
        }
    }

    /* renamed from: c */
    public void mo164292c(String str) {
        for (int i = 0; i < this.f55350b.size(); i += 2) {
            if (str.equalsIgnoreCase(this.f55350b.get(i))) {
                this.f55350b.remove(i);
                this.f55350b.remove(i);
            }
        }
    }

    /* renamed from: a */
    public void mo164286a(String str, List<String> list) {
        for (String a : list) {
            mo164285a(str, a);
        }
    }

    /* renamed from: b */
    public void mo164290b(String str, String str2) {
        mo164292c(str);
        mo164285a(str, str2);
    }

    /* renamed from: e */
    public int mo164295e() {
        return this.f55350b.size() / 2;
    }

    /* renamed from: a */
    public String mo164282a(int i) {
        int i2 = i * 2;
        if (i2 < 0 || i2 >= this.f55350b.size()) {
            return null;
        }
        return this.f55350b.get(i2);
    }

    /* renamed from: b */
    public String mo164288b(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0 || i2 >= this.f55350b.size()) {
            return null;
        }
        return this.f55350b.get(i2);
    }

    /* renamed from: d */
    public String mo164294d(String str) {
        for (int size = this.f55350b.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase(this.f55350b.get(size))) {
                return this.f55350b.get(size + 1);
            }
        }
        return null;
    }

    /* renamed from: a */
    public C20217b mo164280a(Set<String> set) {
        C20217b bVar = new C20217b();
        for (int i = 0; i < this.f55350b.size(); i += 2) {
            String str = this.f55350b.get(i);
            if (set.contains(str)) {
                bVar.mo164285a(str, this.f55350b.get(i + 1));
            }
        }
        return bVar;
    }

    /* renamed from: f */
    public String mo164296f() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(this.f55351c);
        sb.append("\r\n");
        for (int i = 0; i < this.f55350b.size(); i += 2) {
            sb.append(this.f55350b.get(i));
            sb.append(": ");
            sb.append(this.f55350b.get(i + 1));
            sb.append("\r\n");
        }
        sb.append("\r\n");
        return sb.toString();
    }

    /* renamed from: g */
    public Map<String, List<String>> mo164297g() {
        TreeMap treeMap = new TreeMap(f55349a);
        for (int i = 0; i < this.f55350b.size(); i += 2) {
            String str = this.f55350b.get(i);
            String str2 = this.f55350b.get(i + 1);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(str);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(str2);
            treeMap.put(str, Collections.unmodifiableList(arrayList));
        }
        String str3 = this.f55351c;
        if (str3 != null) {
            treeMap.put((Object) null, Collections.unmodifiableList(Collections.singletonList(str3)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    /* renamed from: a */
    public static C20217b m39889a(Map<String, List<String>> map) {
        C20217b bVar = new C20217b();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            if (str != null) {
                bVar.mo164286a(str, (List<String>) list);
            } else if (!list.isEmpty()) {
                bVar.mo164284a((String) list.get(list.size() - 1));
            }
        }
        return bVar;
    }

    /* renamed from: e */
    public static C20217b m39890e(String str) {
        String[] split = str.split("\n");
        C20217b bVar = new C20217b();
        for (String trim : split) {
            String trim2 = trim.trim();
            if (!TextUtils.isEmpty(trim2)) {
                if (bVar.mo164281a() == null) {
                    bVar.mo164284a(trim2);
                } else {
                    bVar.mo164289b(trim2);
                }
            }
        }
        return bVar;
    }
}
