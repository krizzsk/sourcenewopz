package com.global.didi.elvish.base;

import android.content.Context;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo175978d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "it", "Landroid/content/Context;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: BaseDataLoader.kt */
final class BaseDataLoader$loadLanguageConfig$5 extends Lambda implements Function1<Context, HashMap<String, Object>> {
    public static final BaseDataLoader$loadLanguageConfig$5 INSTANCE = new BaseDataLoader$loadLanguageConfig$5();

    BaseDataLoader$loadLanguageConfig$5() {
        super(1);
    }

    public final HashMap<String, Object> invoke(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "it");
        return new HashMap<>();
    }
}
