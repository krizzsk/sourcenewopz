package rui.widget.dialog;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import rui.base.ButtonModel;
import rui.base.ImageLoader;
import rui.widget.button.ButtonStyles;

public class DialogModel {
    public static int CONTENT_ALIGN_CENTER = 1;
    public static int CONTENT_ALIGN_LEFT = 8388611;
    public static int CONTENT_ALIGN_RIGHT = 8388613;
    public static int NO_VALUE = -1;
    public int backgroundRes = NO_VALUE;
    private List<ButtonModel> buttons = new ArrayList();
    public CharSequence content;
    public int contentAlign = CONTENT_ALIGN_LEFT;
    private C3024a factory = new C3024a();
    public boolean hasClose = false;
    public ImageLoader headerImage;
    public ImageLoader iconImage;
    public View.OnClickListener onCloseListener;
    public View.OnClickListener onContentClickListener;
    public CharSequence title;

    public void addButton(CharSequence charSequence, String str, View.OnClickListener onClickListener) {
        this.buttons.add(new ButtonModel(charSequence, str, Integer.MIN_VALUE, onClickListener));
    }

    public void addButton(CharSequence charSequence, int i, View.OnClickListener onClickListener) {
        this.buttons.add(new ButtonModel(charSequence, ButtonStyles.BUTTON_INTERNAL_DIALOG_BASE, i, onClickListener));
    }

    public List<ButtonModel> getButtons() {
        return this.buttons;
    }

    public C3024a getFactory() {
        return this.factory;
    }
}
