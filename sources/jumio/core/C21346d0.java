package jumio.core;

import com.jumio.core.plugins.C20007a;
import com.jumio.core.plugins.ScanPartPlugin;
import java.util.EnumMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.d0 */
/* compiled from: PluginManager.kt */
public final class C21346d0 {

    /* renamed from: a */
    public final Object f59602a = new Object();

    /* renamed from: b */
    public final EnumMap<C20007a.C20010c, C21343c0> f59603b = new EnumMap<>(C20007a.C20010c.class);

    /* renamed from: a */
    public final <T extends C21343c0> T mo175786a(C20007a.C20010c cVar) {
        T t;
        Intrinsics.checkNotNullParameter(cVar, "pluginMode");
        synchronized (this.f59602a) {
            t = this.f59603b.get(cVar);
            if (t == null) {
                t = C20007a.m39594b(cVar);
                if (t != null) {
                    this.f59603b.put(cVar, t);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return (C21343c0) t;
    }

    /* renamed from: a */
    public final void mo175787a() {
        synchronized (this.f59602a) {
            for (Map.Entry next : this.f59603b.entrySet()) {
                C20007a.C20010c cVar = (C20007a.C20010c) next.getKey();
                C21343c0 c0Var = (C21343c0) next.getValue();
                if (c0Var instanceof ScanPartPlugin) {
                    ((ScanPartPlugin) c0Var).unload();
                }
            }
            this.f59603b.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
