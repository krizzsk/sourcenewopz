package com.didiglobal.p205sa.biz.tab.manager;

import com.android.didi.bfflib.BffCallBack;
import com.android.didi.bfflib.BffExtra;
import com.didiglobal.p205sa.biz.tab.model.SaTabDataModel;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, mo175978d2 = {"com/didiglobal/sa/biz/tab/manager/SaTabDataManager$request$ability$1", "Lcom/android/didi/bfflib/BffCallBack;", "Lcom/google/gson/JsonObject;", "onFailure", "", "extra", "Lcom/android/didi/bfflib/BffExtra;", "onSuccess", "response", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabDataManager$request$ability$1 */
/* compiled from: SaTabDataManager.kt */
public final class SaTabDataManager$request$ability$1 implements BffCallBack<JsonObject> {
    final /* synthetic */ Function1<SaTabDataModel, Unit> $notification;

    public void onFailure(BffExtra bffExtra) {
    }

    SaTabDataManager$request$ability$1(Function1<? super SaTabDataModel, Unit> function1) {
        this.$notification = function1;
    }

    public void onSuccess(JsonObject jsonObject, BffExtra bffExtra) {
        SaTabDataManager.INSTANCE.m36695a(jsonObject, this.$notification);
    }
}
