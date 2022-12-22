package com.didi.global.globalgenerickit.dialog;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayDeque;
import java.util.Iterator;

public class GGKDialogFragmentManager {

    /* renamed from: b */
    private static final GGKDialogFragmentManager f22065b = new GGKDialogFragmentManager();

    /* renamed from: a */
    private ArrayDeque<DialogFragment> f22066a;

    private GGKDialogFragmentManager() {
    }

    public static GGKDialogFragmentManager getInstance() {
        return f22065b;
    }

    public void addDialogFragment(GGKBaseAlertDialogFragment gGKBaseAlertDialogFragment) {
        DialogFragment peek;
        Dialog dialog;
        if (this.f22066a == null) {
            this.f22066a = new ArrayDeque<>();
        }
        if (!(this.f22066a.size() <= 0 || (peek = this.f22066a.peek()) == null || (dialog = peek.getDialog()) == null || dialog.getWindow() == null)) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.0f;
            window.setAttributes(attributes);
        }
        this.f22066a.push(gGKBaseAlertDialogFragment);
    }

    public void restoreDialogFragment() {
        DialogFragment peek;
        Dialog dialog;
        ArrayDeque<DialogFragment> arrayDeque = this.f22066a;
        if (arrayDeque != null && arrayDeque.size() != 0) {
            this.f22066a.pop();
            if (this.f22066a.size() > 0 && (peek = this.f22066a.peek()) != null && (dialog = peek.getDialog()) != null && dialog.getWindow() != null) {
                Window window = dialog.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = 1.0f;
                window.setAttributes(attributes);
            }
        }
    }

    public void dismissAllGGKDialog() {
        ArrayDeque<DialogFragment> arrayDeque = this.f22066a;
        if (arrayDeque != null && arrayDeque.size() > 0) {
            Iterator<DialogFragment> it = this.f22066a.iterator();
            while (it.hasNext()) {
                it.next().dismiss();
            }
        }
    }
}
