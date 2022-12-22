package com.didi.component.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.addressnew.widget.EditTextErasable;
import com.didi.component.common.util.GLog;
import com.didi.component.common.widget.AutofitTextView;
import com.didi.raven.config.RavenKey;
import com.didi.unifylogin.utils.customview.LoginNextButton;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.GlobalPassangerTextView;
import com.didiglobal.font.GlobalTextSwicher;
import com.didiglobal.font.iface.DecoratorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider({DecoratorFactory.class})
@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J2\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/component/common/GlobalFontFactory;", "Lcom/didiglobal/font/iface/DecoratorFactory;", "()V", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onDecorateView", "", "view", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalFontFactory.kt */
public final class GlobalFontFactory implements DecoratorFactory {
    public void onDecorateView(View view, View view2, String str, Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        if (DIDIFontUtils.Companion.isSupportFont()) {
            if ((view2 instanceof TextView) || (view2 instanceof Button) || (view2 instanceof EditText)) {
                ((TextView) view2).setTypeface(DIDIFontUtils.Companion.getDidiTypeface(context, attributeSet));
            }
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        if (!DIDIFontUtils.Companion.isSupportFont()) {
            return null;
        }
        Typeface didiTypeface = DIDIFontUtils.Companion.getDidiTypeface(context, attributeSet);
        GLog.m7965d("fontfactory", "--------name ===== " + str + "  typeface=" + didiTypeface);
        switch (str.hashCode()) {
            case -938935918:
                if (!str.equals("TextView")) {
                    return null;
                }
                GlobalPassangerTextView globalPassangerTextView = new GlobalPassangerTextView(context, attributeSet);
                globalPassangerTextView.setTypeface(didiTypeface);
                return globalPassangerTextView;
            case -542304273:
                if (!str.equals("com.didi.addressnew.widget.EditTextErasable")) {
                    return null;
                }
                EditTextErasable editTextErasable = new EditTextErasable(context, attributeSet);
                editTextErasable.setTypeface(didiTypeface);
                editTextErasable.setFocusable(true);
                editTextErasable.setFocusableInTouchMode(true);
                return editTextErasable;
            case -189184178:
                if (!str.equals("TextSwitcher")) {
                    return null;
                }
                return new GlobalTextSwicher(context, attributeSet);
            case -136626917:
                if (!str.equals("androidx.appcompat.widget.AppCompatTextView")) {
                    return null;
                }
                AppCompatTextView appCompatTextView = new AppCompatTextView(context, attributeSet);
                appCompatTextView.setTypeface(didiTypeface);
                return appCompatTextView;
            case 997773093:
                if (!str.equals("com.didi.component.common.widget.AutofitTextView")) {
                    return null;
                }
                AutofitTextView autofitTextView = new AutofitTextView(context, attributeSet);
                autofitTextView.setTypeface(didiTypeface);
                return autofitTextView;
            case 1108548932:
                if (!str.equals("com.didi.unifylogin.utils.customview.LoginNextButton")) {
                    return null;
                }
                LoginNextButton loginNextButton = new LoginNextButton(context, attributeSet);
                loginNextButton.setTypeface(didiTypeface);
                loginNextButton.setGravity(17);
                return loginNextButton;
            case 1448720246:
                if (!str.equals("com.didi.addressold.widget.EditTextErasable")) {
                    return null;
                }
                com.didi.addressold.widget.EditTextErasable editTextErasable2 = new com.didi.addressold.widget.EditTextErasable(context, attributeSet);
                editTextErasable2.setTypeface(didiTypeface);
                editTextErasable2.setFocusable(true);
                editTextErasable2.setFocusableInTouchMode(true);
                return editTextErasable2;
            case 1666676343:
                if (!str.equals("EditText")) {
                    return null;
                }
                EditText editText = new EditText(context, attributeSet);
                editText.setTypeface(didiTypeface);
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                return editText;
            case 2001146706:
                if (!str.equals("Button")) {
                    return null;
                }
                Button button = new Button(context, attributeSet);
                button.setTypeface(didiTypeface);
                button.setGravity(17);
                return button;
            default:
                return null;
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        return onCreateView((View) null, str, context, attributeSet);
    }
}
