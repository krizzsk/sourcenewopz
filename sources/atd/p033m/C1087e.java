package atd.p033m;

import android.content.Context;
import atd.p025i.C1051c;
import atd.p025i.C1053d;
import atd.p046s0.C1172a;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: atd.m.e */
public final class C1087e extends C1053d {

    /* renamed from: atd.m.e$a */
    class C1088a implements Comparator<NetworkInterface> {
        C1088a(C1087e eVar) {
        }

        /* renamed from: a */
        public int compare(NetworkInterface networkInterface, NetworkInterface networkInterface2) {
            return !networkInterface2.getName().contains(C1172a.m764a(-32272837593774L)) ? 0 : -1;
        }
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-32298607397550L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<String> mo13784b() {
        return Arrays.asList(new String[]{C1172a.m764a(-32320082234030L), C1172a.m764a(-32440341318318L)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo13785c(Context context) throws C1051c {
        try {
            ArrayList<T> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            Collections.sort(list, new C1088a(this));
            for (T inetAddresses : list) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                return hostAddress;
                            }
                            int indexOf = hostAddress.indexOf(37);
                            if (indexOf >= 0) {
                                hostAddress = hostAddress.substring(0, indexOf);
                            }
                            return hostAddress.toUpperCase(Locale.US);
                        }
                    }
                }
            }
            throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        } catch (SocketException e) {
            throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, e);
        }
    }
}
