package com.didi.entrega.info.helper;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.TextView;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/info/helper/HideKeyBoardListener;", "Landroid/widget/TextView$OnEditorActionListener;", "()V", "onEditorAction", "", "v", "Landroid/widget/TextView;", "actionId", "", "event", "Landroid/view/KeyEvent;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HideKeyBoardListener.kt */
public final class HideKeyBoardListener implements TextView.OnEditorActionListener {
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Context context;
        if (i != 4 && i != 6 && (keyEvent == null || 66 != keyEvent.getKeyCode() || keyEvent.getAction() != 0)) {
            return true;
        }
        if (textView == null) {
            context = null;
        } else {
            context = textView.getContext();
        }
        KeyboardUtils.hideSoftInput(context, textView);
        return true;
    }
}
