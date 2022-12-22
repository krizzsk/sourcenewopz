package com.didi.sdk.debug.language;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LanguageSelectFragment.kt */
final class LanguageSelectFragment$getData$1$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: $i */
    final /* synthetic */ int f35809$i;
    final /* synthetic */ JSONArray $language;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LanguageSelectFragment$getData$1$1(JSONArray jSONArray, int i) {
        super(1);
        this.$language = jSONArray;
        this.f35809$i = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        EventBus eventBus = EventBus.getDefault();
        LanguageSelectEvent languageSelectEvent = new LanguageSelectEvent();
        String string = this.$language.getString(this.f35809$i);
        Intrinsics.checkNotNullExpressionValue(string, "language.getString(i)");
        languageSelectEvent.setSelect(string);
        Unit unit = Unit.INSTANCE;
        eventBus.post(languageSelectEvent);
    }
}
