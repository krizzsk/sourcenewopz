package com.didi.soda.customer.p165h5.invokejs;

import com.didi.onehybrid.jsbridge.CallbackFunction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J%\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/invokejs/DefaultCallback;", "Lcom/didi/onehybrid/jsbridge/CallbackFunction;", "moduleName", "", "jsMethodName", "(Ljava/lang/String;Ljava/lang/String;)V", "callbacks", "", "Lcom/didi/soda/customer/h5/invokejs/TriggerCallback;", "getJsMethodName", "()Ljava/lang/String;", "getModuleName", "onCallBack", "", "arguments", "", "", "([Ljava/lang/Object;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.invokejs.DefaultCallback */
/* compiled from: TriggerCallback.kt */
public final class DefaultCallback implements CallbackFunction {

    /* renamed from: a */
    private final String f41333a;

    /* renamed from: b */
    private final String f41334b;

    /* renamed from: c */
    private final List<TriggerCallback> f41335c;

    public DefaultCallback(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "moduleName");
        Intrinsics.checkNotNullParameter(str2, "jsMethodName");
        this.f41333a = str;
        this.f41334b = str2;
        List<TriggerCallback> arrayList = new ArrayList<>();
        this.f41335c = arrayList;
        arrayList.add(new TrackTriggerCallback());
    }

    public final String getModuleName() {
        return this.f41333a;
    }

    public final String getJsMethodName() {
        return this.f41334b;
    }

    public void onCallBack(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "arguments");
        try {
            JSONObject jSONObject = null;
            if (!(objArr.length == 0)) {
                Object first = ArraysKt.first((T[]) objArr);
                if (first instanceof JSONObject) {
                    jSONObject = (JSONObject) first;
                }
            }
            for (TriggerCallback onCallback : this.f41335c) {
                onCallback.onCallback(getModuleName(), getJsMethodName(), jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
