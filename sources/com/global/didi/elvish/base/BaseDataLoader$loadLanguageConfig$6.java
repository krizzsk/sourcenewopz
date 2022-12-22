package com.global.didi.elvish.base;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0015\u0010\u0004\u001a\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, mo175978d2 = {"<anonymous>", "", "", "", "p1", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: BaseDataLoader.kt */
final /* synthetic */ class BaseDataLoader$loadLanguageConfig$6 extends FunctionReference implements Function1<Context, Map<String, Object>> {
    BaseDataLoader$loadLanguageConfig$6(BaseDataLoader baseDataLoader) {
        super(1, baseDataLoader);
    }

    public final String getName() {
        return "loadRemoteLanguageConfData";
    }

    public final KDeclarationContainer getOwner() {
        return C21490Reflection.getOrCreateKotlinClass(BaseDataLoader.class);
    }

    public final String getSignature() {
        return "loadRemoteLanguageConfData(Landroid/content/Context;)Ljava/util/Map;";
    }

    public final Map<String, Object> invoke(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "p1");
        return ((BaseDataLoader) this.receiver).m37296c(context);
    }
}
