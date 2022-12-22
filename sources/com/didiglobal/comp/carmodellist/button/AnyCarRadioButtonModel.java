package com.didiglobal.comp.carmodellist.button;

import android.graphics.drawable.Drawable;
import java.util.List;

public class AnyCarRadioButtonModel {

    /* renamed from: a */
    List<ViewModel> f49784a;

    public static class TextModel {
        public String text;
        public String textColor;
    }

    public static class ViewModel {
        public Drawable bgChecked;
        public Drawable bgDisable;
        public Drawable bgUnChecked;
        public Drawable iconChecked;
        public Drawable iconDisable;
        public Drawable iconUnChecked;

        /* renamed from: id */
        public int f49785id = -1;
        public boolean isChecked;
        public TextModel titleChecked;
        public TextModel titleDisable;
        public TextModel titleUnChecked;
    }
}
