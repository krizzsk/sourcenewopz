package com.didi.dynamic.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.dynamic.manager.utils.Log;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ModulesTable {

    /* renamed from: a */
    protected static final String f19337a = "DM.ModulesTable";

    /* renamed from: b */
    protected static final String f19338b = ":";

    /* renamed from: c */
    protected static final String f19339c = "dynamic_modules";

    /* renamed from: d */
    protected static final String f19340d = "modules";

    /* renamed from: e */
    protected static final String f19341e = "url";

    /* renamed from: f */
    protected static final String f19342f = "launchType";

    /* renamed from: g */
    protected static final String f19343g = "downloaded";

    /* renamed from: h */
    protected static final String f19344h = "modulePath";

    /* renamed from: i */
    protected static final String f19345i = "moduleTempPath";

    /* renamed from: j */
    protected static final String f19346j = "appVersion";

    /* renamed from: k */
    protected static final String f19347k = "moduleType";

    /* renamed from: l */
    protected static final String f19348l = "moduleIsUseful";

    /* renamed from: m */
    protected static final String f19349m = "moduleExt";

    /* renamed from: n */
    protected Context f19350n;

    /* renamed from: o */
    protected final SharedPreferencesWrapper f19351o;

    interface Filter {
        boolean match(SharedPreferences sharedPreferences, String str, String str2);
    }

    /* renamed from: a */
    public static ModulesTable m14452a(Context context) {
        return new ModulesTable(context);
    }

    protected ModulesTable(Context context) {
        this.f19350n = context.getApplicationContext();
        this.f19351o = SharedPreferencesWrapper.m14516of(context, f19339c, 0);
    }

    /* renamed from: a */
    protected static String m14453a(Object... objArr) {
        return TextUtils.join(":", objArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59079a(SharedPreferencesWrapper.Editor editor) {
        editor.commitNow();
    }

    /* renamed from: a */
    public boolean mo59084a(Module module) {
        boolean z;
        if (module == null) {
            return false;
        }
        HashSet<String> hashSet = new HashSet<>();
        synchronized (this.f19351o) {
            SharedPreferencesWrapper sharedPreferencesWrapper = this.f19351o;
            Set<String> stringSet = sharedPreferencesWrapper.getStringSet(module.moduleCode, (Set<String>) null);
            if (stringSet == null) {
                z = true;
            } else {
                z = true;
                for (String next : stringSet) {
                    boolean z2 = sharedPreferencesWrapper.getBoolean(m14453a(module.moduleCode, next, f19343g), false);
                    if (module.versionLong - Long.parseLong(next) == 0) {
                        module.f19336a = z2;
                        z = false;
                    } else {
                        hashSet.add(next);
                    }
                }
            }
            SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
            Set<String> stringSet2 = sharedPreferencesWrapper.getStringSet(f19340d, Collections.emptySet());
            Set<String> stringSet3 = sharedPreferencesWrapper.getStringSet(module.moduleCode, Collections.emptySet());
            HashSet hashSet2 = new HashSet(stringSet2);
            HashSet hashSet3 = new HashSet(stringSet3);
            if (z) {
                Log.m14484d(f19337a, "add module:" + module.moduleCode + " v:" + module.version);
                mo59080a(edit, module, (Set<String>) hashSet2, (Set<String>) hashSet3);
            } else {
                Log.m14484d(f19337a, "update module:" + module.moduleCode + " v:" + module.version);
                mo59080a(edit, module, (Set<String>) hashSet2, (Set<String>) hashSet3);
            }
            for (String str : hashSet) {
                mo59081a(edit, module.moduleCode, str, false);
                Log.m14484d(f19337a, "delete reverted module:" + module.moduleCode + " v:" + str);
            }
            mo59079a(edit);
        }
        return true;
    }

    /* renamed from: b */
    public void mo59090b(Module module) {
        synchronized (this.f19351o) {
            SharedPreferencesWrapper sharedPreferencesWrapper = this.f19351o;
            SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
            mo59080a(edit, module, (Set<String>) new HashSet(sharedPreferencesWrapper.getStringSet(f19340d, Collections.emptySet())), (Set<String>) new HashSet(sharedPreferencesWrapper.getStringSet(module.moduleCode, Collections.emptySet())));
            mo59079a(edit);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59080a(SharedPreferencesWrapper.Editor editor, Module module, Set<String> set, Set<String> set2) {
        if (module != null) {
            String str = module.moduleCode;
            String str2 = module.version;
            set.add(str);
            set2.add(str2);
            editor.putStringSet(f19340d, (Set) set).putStringSet(str, (Set) set2).putString(m14453a(str, str2, "url"), module.url).putInt(m14453a(str, str2, f19342f), module.launchType).putBoolean(m14453a(str, str2, f19343g), module.f19336a).putString(m14453a(str, str2, f19344h), module.modulePath.getAbsolutePath()).putString(m14453a(str, str2, f19345i), module.moduleTempPath.getAbsolutePath()).putString(m14453a(str, str2, "appVersion"), module.appVersion).putString(m14453a(str, str2, f19349m), module.ext).putInt(m14453a(str, str2, f19347k), module.moduleType).putBoolean(m14453a(str, str2, f19348l), module.moduleIsUseful);
        }
    }

    /* renamed from: c */
    public void mo59091c(Module module) {
        if (module != null) {
            synchronized (this.f19351o) {
                if (this.f19351o.getStringSet(module.moduleCode, Collections.emptySet()).contains(module.version)) {
                    mo59090b(module);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59081a(SharedPreferencesWrapper.Editor editor, String str, String str2, boolean z) {
        if (this.f19351o.getStringSet(str, Collections.emptySet()).contains(str2)) {
            editor.putBoolean(m14453a(str, str2, f19348l), z);
        }
    }

    /* renamed from: d */
    public boolean mo59093d(Module module) {
        boolean a;
        if (module == null) {
            return false;
        }
        synchronized (this.f19351o) {
            mo59094e(module);
            a = mo59086a(module.moduleCode, module.version);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo59086a(String str, String str2) {
        SharedPreferencesWrapper sharedPreferencesWrapper = this.f19351o;
        SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
        SharedPreferencesWrapper.Editor editor = edit;
        String str3 = str;
        String str4 = str2;
        boolean a = mo59085a(editor, str3, str4, new HashSet(sharedPreferencesWrapper.getStringSet(f19340d, Collections.emptySet())), new HashSet(sharedPreferencesWrapper.getStringSet(str, Collections.emptySet())));
        mo59079a(edit);
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo59085a(SharedPreferencesWrapper.Editor editor, String str, String str2, Set<String> set, Set<String> set2) {
        if (!set2.remove(str2)) {
            return false;
        }
        if (set2.isEmpty()) {
            editor.remove(str);
            set.remove(str);
            editor.putStringSet(f19340d, (Set) set);
        } else {
            editor.putStringSet(str, (Set) set2);
        }
        editor.remove(m14453a(str, str2, "url")).remove(m14453a(str, str2, f19342f)).remove(m14453a(str, str2, f19349m)).remove(m14453a(str, str2, f19343g)).remove(m14453a(str, str2, f19344h)).remove(m14453a(str, str2, f19345i)).remove(m14453a(str, str2, "appVersion")).remove(m14453a(str, str2, f19347k)).remove(m14453a(str, str2, f19348l));
        return true;
    }

    /* renamed from: a */
    public void mo59083a(String str) {
        synchronized (this.f19351o) {
            mo59092c(str);
            mo59076a();
        }
    }

    /* renamed from: a */
    public void mo59077a(final int i) {
        synchronized (this.f19351o) {
            mo59078a((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    return i == sharedPreferences.getInt(ModulesTable.m14453a(str, str2, ModulesTable.f19347k), -1);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59082a(Iterable<Module> iterable) {
        HashSet hashSet;
        SharedPreferencesWrapper sharedPreferencesWrapper = this.f19351o;
        SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
        HashSet hashSet2 = new HashSet(sharedPreferencesWrapper.getStringSet(f19340d, Collections.emptySet()));
        HashMap hashMap = new HashMap();
        for (Module next : iterable) {
            String str = next.moduleCode;
            String str2 = next.version;
            Set set = (Set) hashMap.get(str);
            if (set == null) {
                HashSet hashSet3 = new HashSet(sharedPreferencesWrapper.getStringSet(str, Collections.emptySet()));
                hashMap.put(str, hashSet3);
                hashSet = hashSet3;
            } else {
                hashSet = set;
            }
            mo59085a(edit, str, str2, hashSet2, hashSet);
        }
        mo59079a(edit);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59078a(Filter filter) {
        SharedPreferencesWrapper sharedPreferencesWrapper = this.f19351o;
        Set<String> stringSet = sharedPreferencesWrapper.getStringSet(f19340d, Collections.emptySet());
        HashSet hashSet = new HashSet(stringSet);
        SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
        for (String next : stringSet) {
            Set<String> stringSet2 = sharedPreferencesWrapper.getStringSet(next, Collections.emptySet());
            HashSet hashSet2 = new HashSet(stringSet2);
            for (String next2 : stringSet2) {
                if (filter == null || filter.match(sharedPreferencesWrapper, next, next2)) {
                    mo59085a(edit, next, next2, hashSet, hashSet2);
                }
            }
        }
        mo59079a(edit);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<Module> mo59088b(Filter filter) {
        ArrayList arrayList = new ArrayList();
        SharedPreferencesWrapper sharedPreferencesWrapper = this.f19351o;
        for (String next : sharedPreferencesWrapper.getStringSet(f19340d, Collections.emptySet())) {
            for (String next2 : sharedPreferencesWrapper.getStringSet(next, Collections.emptySet())) {
                if (filter == null || filter.match(sharedPreferencesWrapper, next, next2)) {
                    arrayList.add(mo59075a(sharedPreferencesWrapper, next, next2));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public Module mo59087b(final String str, final String str2) {
        synchronized (this.f19351o) {
            List<Module> b = mo59088b((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    return str.equals(str) && str2.equals(str2);
                }
            });
            if (b.size() != 1) {
                return null;
            }
            Module module = b.get(0);
            return module;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Module mo59075a(SharedPreferencesWrapper sharedPreferencesWrapper, String str, String str2) {
        Module module = new Module();
        module.moduleCode = str;
        module.version = str2;
        module.url = sharedPreferencesWrapper.getString(m14453a(str, str2, "url"), "");
        module.launchType = sharedPreferencesWrapper.getInt(m14453a(str, str2, f19342f), 0);
        module.ext = sharedPreferencesWrapper.getString(m14453a(str, str2, f19349m), "");
        module.f19336a = sharedPreferencesWrapper.getBoolean(m14453a(str, str2, f19343g), false);
        module.modulePath = new File(sharedPreferencesWrapper.getString(m14453a(str, str2, f19344h), ""));
        module.moduleTempPath = new File(sharedPreferencesWrapper.getString(m14453a(str, str2, f19345i), ""));
        module.appVersion = sharedPreferencesWrapper.getString(m14453a(str, str2, "appVersion"), "");
        module.moduleType = sharedPreferencesWrapper.getInt(m14453a(str, str2, f19347k), -1);
        module.versionLong = Long.parseLong(module.version);
        module.moduleIsUseful = sharedPreferencesWrapper.getBoolean(m14453a(str, str2, f19348l), false);
        return module;
    }

    /* renamed from: b */
    public Map<String, List<Module>> mo59089b(final String str) {
        HashMap hashMap = new HashMap();
        synchronized (this.f19351o) {
            for (Module next : mo59088b((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    if (!sharedPreferences.getBoolean(ModulesTable.m14453a(str, str2, ModulesTable.f19348l), false)) {
                        return false;
                    }
                    if (sharedPreferences.getString(ModulesTable.m14453a(str, str2, "appVersion"), "").equals(str)) {
                        return true;
                    }
                    return false;
                }
            })) {
                String str2 = next.moduleCode;
                List list = (List) hashMap.get(str2);
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(str2, list);
                }
                list.add(next);
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    public void mo59092c(final String str) {
        synchronized (this.f19351o) {
            List<Module> b = mo59088b((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    return !sharedPreferences.getString(ModulesTable.m14453a(str, str2, "appVersion"), "").equals(str);
                }
            });
            for (Module e : b) {
                mo59094e(e);
            }
            mo59082a((Iterable<Module>) b);
        }
    }

    /* renamed from: a */
    public void mo59076a() {
        synchronized (this.f19351o) {
            List<Module> b = mo59088b((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    return !sharedPreferences.getBoolean(ModulesTable.m14453a(str, str2, ModulesTable.f19348l), false);
                }
            });
            for (Module e : b) {
                mo59094e(e);
            }
            mo59082a((Iterable<Module>) b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo59094e(Module module) {
        if (module.modulePath != null && module.modulePath.exists()) {
            module.modulePath.delete();
        }
        if (module.moduleTempPath != null && module.moduleTempPath.exists()) {
            module.moduleTempPath.delete();
        }
    }
}
