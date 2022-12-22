package rui.base;

import android.view.View;

public class ButtonModel {
    public int customColor;
    public View.OnClickListener onClick;
    public String style = "";
    public CharSequence title = "";

    public ButtonModel(CharSequence charSequence, String str, int i, View.OnClickListener onClickListener) {
        this.title = charSequence;
        this.style = str;
        this.customColor = i;
        this.onClick = onClickListener;
    }
}
