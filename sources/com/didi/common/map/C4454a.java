package com.didi.common.map;

import android.content.Context;
import com.didi.common.map.internal.IMapDelegate;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.MapApolloTools;
import com.didi.map.sdk.degrade.DegradeFactory;
import com.didi.map.sdk.degrade.DegradeMode;
import com.didi.map.sdk.degrade.IDegradeToggle;

/* renamed from: com.didi.common.map.a */
/* compiled from: MapDelegateFactory */
class C4454a {
    C4454a() {
    }

    /* renamed from: a */
    public static IMapDelegate m7312a(MapVendor mapVendor, Context context) {
        DLog.m7384d("MapDelegate", "IMapDelegate.create" + mapVendor, new Object[0]);
        IMapDelegate iMapDelegate = null;
        try {
            int i = MapDelegateFactory$1.$SwitchMap$com$didi$common$map$MapVendor[mapVendor.ordinal()];
            if (i == 1) {
                return m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.didiadapter.DDMap"), false);
            }
            if (i == 2) {
                return m7310a(context, Class.forName("com.didi.common.map.adapter.didiadapter.DDMap"), true, false);
            }
            if (i != 3) {
                if (i != 4) {
                    return m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.emptymapadapter.EmptyMap"), true);
                }
                return m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.hmsadapter.HMap"), false);
            } else if (MapApolloTools.isDiDiMapEnabled()) {
                DLog.m7384d("MapDelegate", "命中自建apollo", new Object[0]);
                return m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.didiadapter.DDMap"), false);
            } else {
                IDegradeToggle create = DegradeFactory.create();
                DegradeMode targetDegradeMode = create.getTargetDegradeMode(DegradeMode.GOOGLE, context);
                if (targetDegradeMode == DegradeMode.DIDI) {
                    iMapDelegate = m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.didiadapter.DDMap"), true);
                } else if (targetDegradeMode == DegradeMode.GOOGLE && MapAvailability.isAvailable(context, MapVendor.GOOGLE) == 0) {
                    iMapDelegate = m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.googlemapadapter.DDGoogleMap"), false);
                } else {
                    iMapDelegate = m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.emptymapadapter.EmptyMap"), true);
                }
                create.onAppLaunched(targetDegradeMode, context);
                return iMapDelegate;
            }
        } catch (Exception e) {
            DLog.m7384d("MapDelegate", "" + e.toString(), new Object[0]);
            try {
                return m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.emptymapadapter.EmptyMap"), true);
            } catch (ClassNotFoundException e2) {
                DLog.m7384d("MapDelegate", "zl map EmptyMap error" + e2.toString(), new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static IMapDelegate m7313a(MapVendor mapVendor, Context context, boolean z) {
        IMapDelegate a;
        DLog.m7384d("MapDelegate", "IMapDelegate.create" + mapVendor, new Object[0]);
        IMapDelegate iMapDelegate = null;
        try {
            int i = MapDelegateFactory$1.$SwitchMap$com$didi$common$map$MapVendor[mapVendor.ordinal()];
            if (i == 1) {
                return m7311a(context, Class.forName("com.didi.common.map.adapter.didiadapter.DDMap"), false, false, z);
            }
            if (i == 2) {
                return m7311a(context, Class.forName("com.didi.common.map.adapter.didiadapter.DDMap"), true, false, z);
            }
            if (i != 3) {
                if (i != 4) {
                    return m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.emptymapadapter.EmptyMap"), true);
                }
                return m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.hmsadapter.HMap"), false);
            } else if (MapApolloTools.isDiDiMapEnabled()) {
                DLog.m7384d("MapDelegate", "命中自建apollo", new Object[0]);
                return m7311a(context, Class.forName("com.didi.common.map.adapter.didiadapter.DDMap"), false, false, z);
            } else {
                IDegradeToggle create = DegradeFactory.create();
                DegradeMode targetDegradeMode = create.getTargetDegradeMode(DegradeMode.GOOGLE, context);
                if (targetDegradeMode == DegradeMode.DIDI) {
                    a = m7311a(context, Class.forName("com.didi.common.map.adapter.didiadapter.DDMap"), false, true, z);
                } else if (targetDegradeMode == DegradeMode.GOOGLE && MapAvailability.isAvailable(context, MapVendor.GOOGLE) == 0) {
                    a = m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.googlemapadapter.DDGoogleMap"), false);
                } else {
                    a = m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.emptymapadapter.EmptyMap"), true);
                }
                iMapDelegate = a;
                create.onAppLaunched(targetDegradeMode, context);
                return iMapDelegate;
            }
        } catch (Exception e) {
            DLog.m7384d("MapDelegate", "" + e.toString(), new Object[0]);
            try {
                return m7309a(context, (Class) Class.forName("com.didi.common.map.adapter.emptymapadapter.EmptyMap"), true);
            } catch (ClassNotFoundException e2) {
                DLog.m7384d("MapDelegate", "zl map EmptyMap error" + e2.toString(), new Object[0]);
            }
        }
    }

    /* renamed from: a */
    private static IMapDelegate m7309a(Context context, Class cls, boolean z) {
        try {
            Object newInstance = cls.getConstructor(new Class[]{Context.class, Boolean.TYPE}).newInstance(new Object[]{context, Boolean.valueOf(z)});
            if (newInstance instanceof IMapDelegate) {
                return (IMapDelegate) newInstance;
            }
            return null;
        } catch (Exception e) {
            DLog.m7384d("MapDelegate", "" + e.toString(), new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private static IMapDelegate m7310a(Context context, Class cls, boolean z, boolean z2) {
        try {
            Object newInstance = cls.getConstructor(new Class[]{Context.class, Boolean.TYPE, Boolean.TYPE}).newInstance(new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)});
            if (newInstance instanceof IMapDelegate) {
                return (IMapDelegate) newInstance;
            }
            return null;
        } catch (Exception e) {
            DLog.m7384d("MapDelegate", "" + e.toString(), new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private static IMapDelegate m7311a(Context context, Class cls, boolean z, boolean z2, boolean z3) {
        try {
            Object newInstance = cls.getConstructor(new Class[]{Context.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}).newInstance(new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
            if (newInstance instanceof IMapDelegate) {
                return (IMapDelegate) newInstance;
            }
            return null;
        } catch (Exception e) {
            DLog.m7384d("MapDelegate", "" + e.toString(), new Object[0]);
            return null;
        }
    }
}
