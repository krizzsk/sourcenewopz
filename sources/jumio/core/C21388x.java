package jumio.core;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.didi.sdk.util.GlobalCountryCode;
import com.jumio.commons.log.Log;
import com.jumio.sdk.JumioSDK;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: jumio.core.x */
/* compiled from: LocationUtil */
public class C21388x implements LocationListener {

    /* renamed from: f */
    public static final Object f59679f = new Object();

    /* renamed from: a */
    public Context f59680a;

    /* renamed from: b */
    public C21390b f59681b;

    /* renamed from: c */
    public LocationManager f59682c;

    /* renamed from: d */
    public Address f59683d = null;

    /* renamed from: e */
    public boolean f59684e = false;

    /* renamed from: jumio.core.x$a */
    /* compiled from: LocationUtil */
    public class C21389a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Location f59685a;

        /* renamed from: b */
        public final /* synthetic */ boolean f59686b;

        public C21389a(Location location, boolean z) {
            this.f59685a = location;
            this.f59686b = z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r0 = new android.location.Geocoder(jumio.core.C21388x.m42214a(r9.f59687c), java.util.Locale.US).getFromLocation(r9.f59685a.getLatitude(), r9.f59685a.getLongitude(), 1);
            r1 = jumio.core.C21388x.m42216a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
            if (jumio.core.C21388x.m42218b(r9.f59687c) == null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
            r3 = r9.f59687c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
            if (r0 == null) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
            if (r0.size() <= 0) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
            r2 = r0.get(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
            jumio.core.C21388x.m42215a(r3, r2);
            jumio.core.C21388x.m42218b(r9.f59687c).onAddressAvailable(jumio.core.C21388x.m42219c(r9.f59687c));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0071, code lost:
            com.jumio.commons.log.Log.m39463e("No geocoded information available ", (java.lang.Throwable) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                java.lang.Object r0 = jumio.core.C21388x.f59679f
                monitor-enter(r0)
                jumio.core.x r1 = jumio.core.C21388x.this     // Catch:{ all -> 0x0093 }
                android.content.Context r1 = r1.f59680a     // Catch:{ all -> 0x0093 }
                r2 = 0
                if (r1 == 0) goto L_0x0080
                android.location.Location r1 = r9.f59685a     // Catch:{ all -> 0x0093 }
                if (r1 == 0) goto L_0x0080
                jumio.core.x r1 = jumio.core.C21388x.this     // Catch:{ all -> 0x0093 }
                boolean r1 = r1.mo175890c()     // Catch:{ all -> 0x0093 }
                if (r1 != 0) goto L_0x001b
                goto L_0x0080
            L_0x001b:
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                android.location.Geocoder r3 = new android.location.Geocoder     // Catch:{ Exception -> 0x0070 }
                jumio.core.x r0 = jumio.core.C21388x.this     // Catch:{ Exception -> 0x0070 }
                android.content.Context r0 = r0.f59680a     // Catch:{ Exception -> 0x0070 }
                java.util.Locale r1 = java.util.Locale.US     // Catch:{ Exception -> 0x0070 }
                r3.<init>(r0, r1)     // Catch:{ Exception -> 0x0070 }
                android.location.Location r0 = r9.f59685a     // Catch:{ Exception -> 0x0070 }
                double r4 = r0.getLatitude()     // Catch:{ Exception -> 0x0070 }
                android.location.Location r0 = r9.f59685a     // Catch:{ Exception -> 0x0070 }
                double r6 = r0.getLongitude()     // Catch:{ Exception -> 0x0070 }
                r8 = 1
                java.util.List r0 = r3.getFromLocation(r4, r6, r8)     // Catch:{ Exception -> 0x0070 }
                java.lang.Object r1 = jumio.core.C21388x.f59679f     // Catch:{ Exception -> 0x0070 }
                monitor-enter(r1)     // Catch:{ Exception -> 0x0070 }
                jumio.core.x r3 = jumio.core.C21388x.this     // Catch:{ all -> 0x006d }
                jumio.core.x$b r3 = r3.f59681b     // Catch:{ all -> 0x006d }
                if (r3 == 0) goto L_0x006b
                jumio.core.x r3 = jumio.core.C21388x.this     // Catch:{ all -> 0x006d }
                if (r0 == 0) goto L_0x0059
                int r4 = r0.size()     // Catch:{ all -> 0x006d }
                if (r4 <= 0) goto L_0x0059
                r2 = 0
                java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x006d }
                r2 = r0
                android.location.Address r2 = (android.location.Address) r2     // Catch:{ all -> 0x006d }
            L_0x0059:
                android.location.Address unused = r3.f59683d = r2     // Catch:{ all -> 0x006d }
                jumio.core.x r0 = jumio.core.C21388x.this     // Catch:{ all -> 0x006d }
                jumio.core.x$b r0 = r0.f59681b     // Catch:{ all -> 0x006d }
                jumio.core.x r2 = jumio.core.C21388x.this     // Catch:{ all -> 0x006d }
                android.location.Address r2 = r2.f59683d     // Catch:{ all -> 0x006d }
                r0.onAddressAvailable(r2)     // Catch:{ all -> 0x006d }
            L_0x006b:
                monitor-exit(r1)     // Catch:{ all -> 0x006d }
                goto L_0x0076
            L_0x006d:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x006d }
                throw r0     // Catch:{ Exception -> 0x0070 }
            L_0x0070:
                r0 = move-exception
                java.lang.String r1 = "No geocoded information available "
                com.jumio.commons.log.Log.m39463e((java.lang.String) r1, (java.lang.Throwable) r0)
            L_0x0076:
                boolean r0 = r9.f59686b
                if (r0 == 0) goto L_0x007f
                jumio.core.x r0 = jumio.core.C21388x.this
                r0.mo175891d()
            L_0x007f:
                return
            L_0x0080:
                jumio.core.x r1 = jumio.core.C21388x.this     // Catch:{ all -> 0x0093 }
                jumio.core.x$b r1 = r1.f59681b     // Catch:{ all -> 0x0093 }
                if (r1 == 0) goto L_0x0091
                jumio.core.x r1 = jumio.core.C21388x.this     // Catch:{ all -> 0x0093 }
                jumio.core.x$b r1 = r1.f59681b     // Catch:{ all -> 0x0093 }
                r1.onAddressAvailable(r2)     // Catch:{ all -> 0x0093 }
            L_0x0091:
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                return
            L_0x0093:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21388x.C21389a.run():void");
        }
    }

    /* renamed from: jumio.core.x$b */
    /* compiled from: LocationUtil */
    public interface C21390b {
        void onAddressAvailable(Address address);
    }

    public C21388x(Context context, C21390b bVar) {
        this.f59680a = context;
        this.f59681b = bVar;
    }

    /* renamed from: d */
    public void mo175891d() {
        synchronized (f59679f) {
            try {
                LocationManager locationManager = this.f59682c;
                if (locationManager != null) {
                    locationManager.removeUpdates(this);
                    this.f59682c = null;
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
            this.f59680a = null;
            this.f59681b = null;
        }
    }

    public void onLocationChanged(Location location) {
        new Thread(new C21389a(location, this.f59684e)).start();
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* renamed from: b */
    public boolean mo175889b() {
        return JumioSDK.Companion.hasPermissionsFor(this.f59680a, new String[]{Permission.ACCESS_COARSE_LOCATION});
    }

    /* renamed from: c */
    public boolean mo175890c() {
        return Geocoder.isPresent();
    }

    /* renamed from: a */
    public static String m42217a(C21340b bVar) {
        if (bVar == null) {
            return null;
        }
        String c = bVar.mo175783c();
        if (!GlobalCountryCode.AMERICA.equals(c)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = bVar.mo175780a().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                sb.append(next);
                sb.append(" ");
            }
        }
        String b = bVar.mo175782b();
        Matcher matcher = Pattern.compile(" [A-Z]{2} ").matcher(sb);
        while (matcher.find()) {
            b = matcher.group().trim();
        }
        if (b == null || b.length() != 2) {
            return null;
        }
        return String.format("%s-%s", new Object[]{c, b});
    }

    /* renamed from: a */
    public void mo175888a(boolean z, boolean z2) {
        if (mo175889b()) {
            try {
                synchronized (f59679f) {
                    LocationManager locationManager = (LocationManager) this.f59680a.getSystemService("location");
                    this.f59682c = locationManager;
                    if (locationManager.getAllProviders().contains("network")) {
                        if (z) {
                            this.f59684e = false;
                            onLocationChanged(this.f59682c.getLastKnownLocation("network"));
                        }
                        this.f59684e = z2;
                        this.f59682c.requestSingleUpdate("network", this, Looper.getMainLooper());
                    }
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
        }
    }
}
