package com.didi.soda.customer.p165h5.invokejs;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, mo175978d2 = {"com/didi/soda/customer/h5/invokejs/TriggerManager$get$1", "Ljava/lang/reflect/InvocationHandler;", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.invokejs.TriggerManager$get$1 */
/* compiled from: TriggerManager.kt */
public final class TriggerManager$get$1 implements InvocationHandler {
    final /* synthetic */ Class<T> $clazz;
    final /* synthetic */ TriggerManager this$0;

    TriggerManager$get$1(TriggerManager triggerManager, Class<T> cls) {
        this.this$0 = triggerManager;
        this.$clazz = cls;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Intrinsics.checkNotNullParameter(obj, "proxy");
        Intrinsics.checkNotNullParameter(method, "method");
        C13791a access$parseJsMethodInfo = this.this$0.m29291a(this.$clazz, method);
        if (access$parseJsMethodInfo.mo105216c()) {
            TriggerManager triggerManager = this.this$0;
            String a = access$parseJsMethodInfo.mo105212a();
            Intrinsics.checkNotNull(a);
            String b = access$parseJsMethodInfo.mo105214b();
            Intrinsics.checkNotNull(b);
            triggerManager.m29292a(a, b, objArr);
        } else {
            LogUtil.m29102e("TriggerManager", Intrinsics.stringPlus("js调用信息不全: info: ", access$parseJsMethodInfo));
        }
        LogUtil.m29100d("TriggerManager", Intrinsics.stringPlus("method = ", method));
        return null;
    }
}
