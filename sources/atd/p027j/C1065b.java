package atd.p027j;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p025i.C1053d;
import atd.p046s0.C1172a;
import java.util.Collections;
import java.util.List;

/* renamed from: atd.j.b */
abstract class C1065b extends C1053d {
    C1065b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<String> mo13784b() {
        return Collections.singletonList(C1172a.m764a(-30894153091758L));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public BluetoothAdapter mo13794d(Context context) throws C1051c {
        return mo13795e(context).getAdapter();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public BluetoothManager mo13795e(Context context) throws C1051c {
        BluetoothManager bluetoothManager;
        if (Build.VERSION.SDK_INT >= 18 && (bluetoothManager = (BluetoothManager) context.getSystemService(C1172a.m764a(-31018707143342L))) != null) {
            return bluetoothManager;
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
