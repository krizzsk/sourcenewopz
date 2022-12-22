package com.didi.unifylogin.utils.customview;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;

public class CodeInputEditText extends EditText {

    /* renamed from: a */
    private ArrayList<TextWatcher> f44959a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnDelKeyEventListener f44960b;

    public interface OnDelKeyEventListener {
        void onDeleteClick(CodeInputEditText codeInputEditText);
    }

    public CodeInputEditText(Context context) {
        super(context);
    }

    public CodeInputEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CodeInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new ZanyInputConnection(super.onCreateInputConnection(editorInfo), true, this);
    }

    private class ZanyInputConnection extends InputConnectionWrapper {
        CodeInputEditText editText;

        public ZanyInputConnection(InputConnection inputConnection, boolean z, CodeInputEditText codeInputEditText) {
            super(inputConnection, z);
            this.editText = codeInputEditText;
        }

        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67 && CodeInputEditText.this.f44960b != null) {
                CodeInputEditText.this.f44960b.onDeleteClick(this.editText);
            }
            return super.sendKeyEvent(keyEvent);
        }

        public boolean deleteSurroundingText(int i, int i2) {
            sendKeyEvent(new KeyEvent(0, 67));
            return super.deleteSurroundingText(i, i2);
        }
    }

    public void setDelKeyEventListener(OnDelKeyEventListener onDelKeyEventListener) {
        this.f44960b = onDelKeyEventListener;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        super.addTextChangedListener(textWatcher);
        if (this.f44959a == null) {
            this.f44959a = new ArrayList<>();
        }
        this.f44959a.add(textWatcher);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        int indexOf;
        super.removeTextChangedListener(textWatcher);
        ArrayList<TextWatcher> arrayList = this.f44959a;
        if (arrayList != null && (indexOf = arrayList.indexOf(textWatcher)) >= 0) {
            this.f44959a.remove(indexOf);
        }
    }

    public void addTextChangedListeners(ArrayList<TextWatcher> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<TextWatcher> it = arrayList.iterator();
            while (it.hasNext()) {
                addTextChangedListener(it.next());
            }
        }
    }

    public void removeTextChangedListeners(ArrayList<TextWatcher> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<TextWatcher> it = arrayList.iterator();
            while (it.hasNext()) {
                removeTextChangedListener(it.next());
            }
        }
    }

    public ArrayList<TextWatcher> getTextWatcherListeners() {
        return new ArrayList<>(this.f44959a);
    }
}
