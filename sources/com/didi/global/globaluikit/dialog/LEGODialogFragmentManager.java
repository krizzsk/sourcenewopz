package com.didi.global.globaluikit.dialog;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayDeque;
import java.util.Iterator;

public class LEGODialogFragmentManager {

    /* renamed from: b */
    private static final LEGODialogFragmentManager f22485b = new LEGODialogFragmentManager();

    /* renamed from: a */
    private ArrayDeque<DialogFragment> f22486a;

    private LEGODialogFragmentManager() {
    }

    public static LEGODialogFragmentManager getInstance() {
        return f22485b;
    }

    public void addDialogFragment(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment) {
        DialogFragment peek;
        Dialog dialog;
        if (this.f22486a == null) {
            this.f22486a = new ArrayDeque<>();
        }
        if (!(this.f22486a.size() <= 0 || (peek = this.f22486a.peek()) == null || (dialog = peek.getDialog()) == null || dialog.getWindow() == null)) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.0f;
            window.setAttributes(attributes);
        }
        this.f22486a.push(lEGOBaseAlertDialogFragment);
    }

    public void restoreDialogFragment() {
        DialogFragment peek;
        Dialog dialog;
        ArrayDeque<DialogFragment> arrayDeque = this.f22486a;
        if (arrayDeque != null && arrayDeque.size() != 0) {
            this.f22486a.pop();
            if (this.f22486a.size() > 0 && (peek = this.f22486a.peek()) != null && (dialog = peek.getDialog()) != null && dialog.getWindow() != null) {
                Window window = dialog.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = 1.0f;
                window.setAttributes(attributes);
            }
        }
    }

    public void dismissAllGGKDialog() {
        ArrayDeque<DialogFragment> arrayDeque = this.f22486a;
        if (arrayDeque != null && arrayDeque.size() > 0) {
            Iterator<DialogFragment> it = this.f22486a.iterator();
            while (it.hasNext()) {
                it.next().dismiss();
            }
        }
    }
}
