package rui.widget.popup.type.input;

import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.widget.EditText;
import rui.base.ButtonModel;
import rui.widget.popup.base.BasePopupModel;

public class PopupInput extends BasePopupModel<FactoryPopupInput> {
    public ButtonModel button;
    public boolean defaultEnable = true;
    public CharSequence defaultText;
    public InputFilter[] filters;
    public KeyListener keyListener;
    public CharSequence subtitle;
    public CharSequence title;
    public TextWatcher watcher;

    public PopupInput() {
        this.factory = new FactoryPopupInput();
    }

    public EditText getEditText() {
        return ((FactoryPopupInput) this.factory).getEditText();
    }

    public void enableButton(boolean z) {
        ((FactoryPopupInput) this.factory).enableButton(z);
    }
}
