package com.didi.soda.address.edit.component;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, mo175978d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: Delegates.kt */
public final class EditAddressInfoPresent$special$$inlined$observable$1 extends ObservableProperty<Boolean> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ EditAddressInfoPresent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditAddressInfoPresent$special$$inlined$observable$1(Object obj, Object obj2, EditAddressInfoPresent editAddressInfoPresent) {
        super(obj2);
        this.$initialValue = obj;
        this.this$0 = editAddressInfoPresent;
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        boolean booleanValue = bool2.booleanValue();
        if (!bool.booleanValue() && booleanValue) {
            this.this$0.m27442b();
        }
    }
}
