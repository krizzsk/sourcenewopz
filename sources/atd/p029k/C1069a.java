package atd.p029k;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p025i.C1053d;
import atd.p046s0.C1172a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: atd.k.a */
public class C1069a extends C1053d {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-31284995115694L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<String> mo13784b() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 29) {
            arrayList.add(C1172a.m764a(-31306469952174L));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(C1172a.m764a(-31508333415086L));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo13785c(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 26) {
            return Build.getSerial();
        }
        return Build.SERIAL;
    }
}
