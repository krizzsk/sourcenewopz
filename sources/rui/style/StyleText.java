package rui.style;

import android.graphics.Typeface;
import android.widget.TextView;
import com.taxis99.R;

public class StyleText {
    public static void titleLarge(TextView textView) {
        titleStyle(textView, R.dimen.rui_text_title_large, true);
    }

    public static void titleNormal(TextView textView) {
        titleStyle(textView, R.dimen.rui_text_normal, false);
    }

    public static void titleStyle(TextView textView, int i, boolean z) {
        textView.setTextSize(0, textView.getContext().getResources().getDimension(i));
        if (z) {
            textView.setTypeface((Typeface) null, 1);
        }
    }
}
