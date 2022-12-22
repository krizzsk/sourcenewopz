package com.didi.component.operationpanel.model;

import com.didi.component.business.sharetrip.CommonTripShareManager;
import com.didi.component.business.xengine.XELogicCallbackSupplier;
import com.didi.component.common.socialshare.SharePlatforms;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.travel.infra.serialization.GsonKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didi/component/business/xengine/XELogicCallbackSupplier;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OperationPanelModel.kt */
final class OperationPanelModel$attach$1 extends Lambda implements Function1<XELogicCallbackSupplier, Unit> {
    final /* synthetic */ OperationPanelModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OperationPanelModel$attach$1(OperationPanelModel operationPanelModel) {
        super(1);
        this.this$0 = operationPanelModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((XELogicCallbackSupplier) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(XELogicCallbackSupplier xELogicCallbackSupplier) {
        Intrinsics.checkNotNullParameter(xELogicCallbackSupplier, "$this$registerXEngineLogic");
        final OperationPanelModel operationPanelModel = this.this$0;
        xELogicCallbackSupplier.onSuccess(new Function1<XEngineData, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((XEngineData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(XEngineData xEngineData) {
                List list;
                Intrinsics.checkNotNullParameter(xEngineData, "raw");
                JsonObject jsonObject = xEngineData.jsonObject;
                Intrinsics.checkNotNullExpressionValue(jsonObject, "raw.jsonObject");
                JsonObject objectOf = GsonKt.objectOf(jsonObject, "data:data");
                if (objectOf != null) {
                    OperationPanelModel operationPanelModel = operationPanelModel;
                    String stringOf$default = GsonKt.stringOf$default(objectOf, "url", false, 2, (Object) null);
                    if (stringOf$default == null) {
                        stringOf$default = "";
                    }
                    operationPanelModel.f14837c = stringOf$default;
                    JsonArray<JsonElement> arrayOf = GsonKt.arrayOf(objectOf, "share_channels");
                    if (arrayOf != null) {
                        Collection arrayList = new ArrayList();
                        for (JsonElement stringOrNull : arrayOf) {
                            String stringOrNull2 = GsonKt.stringOrNull(stringOrNull);
                            if (stringOrNull2 != null) {
                                arrayList.add(stringOrNull2);
                            }
                        }
                        list = (List) arrayList;
                    } else {
                        list = CollectionsKt.emptyList();
                    }
                    SharePlatforms.Companion companion = SharePlatforms.Companion;
                    Object[] array = list.toArray(new String[0]);
                    if (array != null) {
                        String[] strArr = (String[]) array;
                        operationPanelModel.f14838d = companion.fromPlatforms((String[]) Arrays.copyOf(strArr, strArr.length));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                }
                CommonTripShareManager unused = operationPanelModel.m10619a();
            }
        });
        final OperationPanelModel operationPanelModel2 = this.this$0;
        xELogicCallbackSupplier.onFail(new Function1<Exception, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Exception) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "it");
                operationPanelModel2.f14835a.error("Fail to parse share_trip_platform data", (Throwable) exc);
            }
        });
    }
}
