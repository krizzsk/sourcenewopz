package com.didiglobal.font.decorator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo175978d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "name", "", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onCreateView"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DecoratorInjector.kt */
final class DecoratorInjector$inject$1 implements LayoutInflater.Factory {
    final /* synthetic */ AppCompatDelegate $delegate;

    DecoratorInjector$inject$1(AppCompatDelegate appCompatDelegate) {
        this.$delegate = appCompatDelegate;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.$delegate.createView((View) null, str, context, attributeSet);
    }
}
