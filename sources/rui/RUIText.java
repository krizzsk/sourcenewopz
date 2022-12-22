package rui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.passenger.C10448R;
import java.util.Arrays;
import rui.support.TextLengthFilter;
import rui.util.FontUtil;

@Deprecated
public class RUIText extends TextView {
    protected static final int RUI_VIEW_HIERARCHY = 1;

    /* renamed from: a */
    private int f6740a = -1;

    /* renamed from: b */
    private int f6741b = 0;

    /* renamed from: c */
    private TextLengthFilter f6742c;

    /* renamed from: d */
    private InputFilter[] f6743d;

    public interface TypefaceType {
        public static final int ICON = 2;
        public static final int NONE = 0;
        public static final int PROTRUDE_NUMBER = 1;
    }

    public RUIText(Context context) {
        super(context);
        m3839a(context, (AttributeSet) null);
    }

    public RUIText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3839a(context, attributeSet);
    }

    public RUIText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3839a(context, attributeSet);
    }

    /* renamed from: a */
    private void m3839a(Context context, AttributeSet attributeSet) {
        this.f6743d = getFilters();
        setAllCaps(false);
        m3840b(context, attributeSet);
    }

    /* renamed from: b */
    private void m3840b(Context context, AttributeSet attributeSet) {
        int i = this.f6740a;
        int i2 = this.f6741b;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RUIText);
            i = obtainStyledAttributes.getColor(0, i);
            i2 = obtainStyledAttributes.getInt(1, i2);
            obtainStyledAttributes.recycle();
        }
        setTypefaceType(i2);
        setMaxTextLength(i);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f6743d = inputFilterArr;
        if (this.f6742c != null) {
            InputFilter[] inputFilterArr2 = (InputFilter[]) Arrays.copyOf(inputFilterArr, inputFilterArr.length + 1);
            inputFilterArr2[inputFilterArr.length] = this.f6742c;
            super.setFilters(inputFilterArr2);
            return;
        }
        super.setFilters(inputFilterArr);
    }

    public void setMaxTextLength(int i) {
        if (this.f6740a != i) {
            this.f6740a = i;
            if (i == -1) {
                this.f6742c = null;
            } else {
                this.f6742c = new TextLengthFilter(i);
            }
            setFilters(this.f6743d);
            setText(getText());
        }
    }

    public void setTypefaceType(int i) {
        if (this.f6741b != i) {
            this.f6741b = i;
            if (i == 0) {
                setTypeface((Typeface) null);
            } else if (i == 2) {
                setTypeface(FontUtil.getIconTypeface(getContext()));
            }
        }
    }
}
