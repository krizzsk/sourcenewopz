package atd.p033m;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p025i.C1053d;
import atd.p046s0.C1172a;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Tasks;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: atd.m.g */
public final class C1090g {

    /* renamed from: a */
    private Location f327a;

    /* renamed from: atd.m.g$b */
    private abstract class C1092b extends C1053d {
        private C1092b(C1090g gVar) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public List<String> mo13784b() {
            return Collections.singletonList(C1172a.m764a(-32685154454190L));
        }
    }

    /* renamed from: atd.m.g$c */
    static final class C1093c implements C1096f {
        C1093c() {
        }

        /* renamed from: a */
        public Location mo13828a(Context context) {
            try {
                return (Location) Tasks.await(LocationServices.getFusedLocationProviderClient(context).getLastLocation(), 500, TimeUnit.MILLISECONDS);
            } catch (NoClassDefFoundError unused) {
                return null;
            } catch (InterruptedException unused2) {
                C1172a.m764a(-32865543080622L);
                return null;
            } catch (ExecutionException unused3) {
                C1172a.m764a(-33058816608942L);
                return null;
            } catch (TimeoutException unused4) {
                C1172a.m764a(-33359464319662L);
                return null;
            }
        }
    }

    /* renamed from: atd.m.g$d */
    static final class C1094d implements C1096f {
        C1094d() {
        }

        /* renamed from: a */
        public Location mo13828a(Context context) {
            LocationManager locationManager = (LocationManager) context.getSystemService(C1172a.m764a(-33526968044206L));
            if (locationManager != null) {
                return locationManager.getLastKnownLocation(C1172a.m764a(-33565622749870L));
            }
            return null;
        }
    }

    /* renamed from: atd.m.g$e */
    private final class C1095e extends C1092b {
        C1095e() {
            super();
        }

        /* renamed from: a */
        public String mo13781a() {
            return C1172a.m764a(-33582802619054L);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Double mo13785c(Context context) throws C1051c {
            return Double.valueOf(C1090g.this.mo13826a(context).getLatitude());
        }
    }

    /* renamed from: atd.m.g$f */
    private interface C1096f {
        /* renamed from: a */
        Location mo13828a(Context context);
    }

    /* renamed from: atd.m.g$g */
    private final class C1097g extends C1092b {
        C1097g() {
            super();
        }

        /* renamed from: a */
        public String mo13781a() {
            return C1172a.m764a(-33604277455534L);
        }

        /* renamed from: d */
        public Double mo13785c(Context context) throws C1051c {
            return Double.valueOf(C1090g.this.mo13826a(context).getLongitude());
        }
    }

    /* renamed from: atd.m.g$h */
    static final class C1098h implements C1096f {
        C1098h() {
        }

        /* renamed from: a */
        public Location mo13828a(Context context) {
            LocationManager locationManager = (LocationManager) context.getSystemService(C1172a.m764a(-33625752292014L));
            if (locationManager != null) {
                return locationManager.getLastKnownLocation(C1172a.m764a(-33664406997678L));
            }
            return null;
        }
    }

    /* renamed from: atd.m.g$i */
    static final class C1099i implements C1096f {
        C1099i() {
        }

        /* renamed from: a */
        public Location mo13828a(Context context) {
            LocationManager locationManager = (LocationManager) context.getSystemService(C1172a.m764a(-33698766736046L));
            if (locationManager != null) {
                return locationManager.getLastKnownLocation(C1172a.m764a(-33737421441710L));
            }
            return null;
        }
    }

    /* renamed from: b */
    private List<C1096f> m549b() {
        return Arrays.asList(new C1096f[]{new C1093c(), new C1094d(), new C1098h(), new C1099i()});
    }

    /* renamed from: a */
    public Collection<? extends C1050b> mo13827a() {
        return Arrays.asList(new C1092b[]{new C1095e(), new C1097g()});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Location mo13826a(Context context) throws C1051c {
        Location location = this.f327a;
        if (location != null) {
            return location;
        }
        for (C1096f a : m549b()) {
            Location a2 = a.mo13828a(context);
            this.f327a = a2;
            if (a2 != null) {
                return a2;
            }
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
