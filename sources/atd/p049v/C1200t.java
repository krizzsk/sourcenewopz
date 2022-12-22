package atd.p049v;

import android.os.Build;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: atd.v.t */
abstract class C1200t extends C1179a0 {
    C1200t() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<String> mo13784b() {
        if (Build.VERSION.SDK_INT < 29) {
            return super.mo13784b();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Permission.READ_PHONE_STATE);
        arrayList.add("android.permission.READ_PRIVILEGED_PHONE_STATE");
        return Collections.unmodifiableList(arrayList);
    }
}
