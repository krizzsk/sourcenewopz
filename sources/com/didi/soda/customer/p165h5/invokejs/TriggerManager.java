package com.didi.soda.customer.p165h5.invokejs;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.WebRegisterTriggerEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.p165h5.CustomerWebPage;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u001f\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r¢\u0006\u0002\u0010\u000eJ/\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/invokejs/TriggerManager;", "", "()V", "registerTriggers", "", "", "webPage", "Lcom/didi/soda/customer/h5/CustomerWebPage;", "attach", "", "get", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "invoke", "moduleName", "jsMethodName", "args", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "parseJsMethodInfo", "Lcom/didi/soda/customer/h5/invokejs/JSMethodInfo;", "method", "Ljava/lang/reflect/Method;", "registerTrigger", "Lorg/json/JSONObject;", "params", "unregisterTrigger", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.invokejs.TriggerManager */
/* compiled from: TriggerManager.kt */
public final class TriggerManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CustomerWebPage f41340a;

    /* renamed from: b */
    private List<String> f41341b = new ArrayList();

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/invokejs/TriggerManager$Companion;", "", "()V", "getAllTriggers", "", "", "clazz", "Ljava/lang/Class;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.soda.customer.h5.invokejs.TriggerManager$Companion */
    /* compiled from: TriggerManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getAllTriggers(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            List<String> arrayList = new ArrayList<>();
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "methods");
            for (Method method : declaredMethods) {
                Trigger trigger = (Trigger) method.getAnnotation(Trigger.class);
                String name = trigger == null ? null : trigger.name();
                CharSequence charSequence = name;
                if (charSequence == null || charSequence.length() == 0) {
                    name = method.getName();
                }
                Intrinsics.checkNotNull(name);
                arrayList.add(name);
            }
            return arrayList;
        }
    }

    public final void attach(CustomerWebPage customerWebPage) {
        Intrinsics.checkNotNullParameter(customerWebPage, "webPage");
        this.f41340a = customerWebPage;
    }

    public final void unregisterTrigger(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        try {
            List<String> list = ((WebRegisterTriggerEntity) GsonUtil.fromJson(jSONObject.toString(), WebRegisterTriggerEntity.class)).triggerList;
            Intrinsics.checkNotNullExpressionValue(list, "entity.triggerList");
            for (String str : list) {
                if (this.f41341b.contains(str)) {
                    this.f41341b.remove(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final JSONObject registerTrigger(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        JSONObject jSONObject2 = new JSONObject();
        try {
            List<String> allTriggers = Companion.getAllTriggers(CustomerWebTrigger.class);
            List<String> list = ((WebRegisterTriggerEntity) GsonUtil.fromJson(jSONObject.toString(), WebRegisterTriggerEntity.class)).triggerList;
            Intrinsics.checkNotNullExpressionValue(list, "entity.triggerList");
            for (String str : list) {
                if (allTriggers.contains(str)) {
                    List<String> list2 = this.f41341b;
                    Intrinsics.checkNotNullExpressionValue(str, "info");
                    list2.add(str);
                    jSONObject2.put(str, true);
                } else {
                    jSONObject2.put(str, false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject2;
    }

    public final <T> T get(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        if (this.f41340a == null) {
            LogUtil.m29102e("TriggerManager", "You need invoke TriggerManager.attach() method.");
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new TriggerManager$get$1(this, cls));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29292a(String str, String str2, Object[] objArr) {
        Object[] objArr2;
        if (this.f41341b.contains(str2)) {
            if (objArr != null) {
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread(objArr);
                spreadBuilder.add(new DefaultCallback(str, str2));
                objArr2 = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            } else {
                objArr2 = new Object[]{new DefaultCallback(str, str2)};
            }
            CustomerWebPage customerWebPage = this.f41340a;
            if (customerWebPage != null) {
                customerWebPage.invokeJSMethod(str, str2, Arrays.copyOf(objArr2, objArr2.length));
                return;
            }
            return;
        }
        LogUtil.m29104i("TriggerManager", str + ':' + str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final C13791a m29291a(Class<?> cls, Method method) {
        Module module = (Module) cls.getAnnotation(Module.class);
        String str = null;
        String name = module == null ? null : module.name();
        Trigger trigger = (Trigger) method.getAnnotation(Trigger.class);
        if (trigger != null) {
            str = trigger.name();
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            str = method.getName();
        }
        LogUtil.m29100d("TriggerManager", " invoke js method: module = " + name + " method = " + str);
        return new C13791a(name, str);
    }
}
