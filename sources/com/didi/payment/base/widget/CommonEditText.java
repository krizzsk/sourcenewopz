package com.didi.payment.base.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.GravityCompat;
import java.util.StringTokenizer;

public class CommonEditText extends AppCompatEditText {
    public static final int STATE_EDITING = 1;
    public static final int STATE_INVALID = 2;
    public static final int STATE_VALID = 3;

    /* renamed from: a */
    KeyboardListener f30118a;

    /* renamed from: b */
    OnTextChangeListener f30119b;

    /* renamed from: c */
    private int f30120c = 2;

    /* renamed from: d */
    private TextWatcher f30121d = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (CommonEditText.this.f30119b != null) {
                CommonEditText.this.f30119b.onTextChanged(editable != null ? editable.toString() : "");
            }
        }
    };

    public interface KeyboardListener {
        void onStateChanged(CommonEditText commonEditText, boolean z);
    }

    public interface OnTextChangeListener {
        void onTextChanged(String str);
    }

    public enum TYPE {
        CARD_NUMBER,
        DATE,
        CVV,
        TEXT,
        NUMBER_DECIMAL
    }

    public CommonEditText(Context context) {
        super(context);
        m21099a();
    }

    public CommonEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21099a();
    }

    public CommonEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21099a();
    }

    /* renamed from: a */
    private void m21099a() {
        if (Build.VERSION.SDK_INT >= 17) {
            setTextAlignment(5);
            setGravity(GravityCompat.START);
            setTextDirection(5);
        }
        addTextChangedListener(this.f30121d);
        setMaxLines(1);
    }

    public void setStyleAdapter(EditStyleAdapter editStyleAdapter) {
        if (editStyleAdapter != null) {
            editStyleAdapter.init();
            editStyleAdapter.bindEditText(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        KeyboardListener keyboardListener;
        super.onFocusChanged(z, i, rect);
        if (z && (keyboardListener = this.f30118a) != null) {
            keyboardListener.onStateChanged(this, true);
        }
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        KeyboardListener keyboardListener;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && (keyboardListener = this.f30118a) != null) {
            keyboardListener.onStateChanged(this, false);
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public String getTextWithoutSpace() {
        String obj = getText() != null ? getText().toString() : "";
        return !TextUtils.isEmpty(obj) ? obj.trim().replaceAll(" ", "") : obj;
    }

    public String getTextString() {
        return getText() == null ? "" : String.valueOf(getText());
    }

    public void setMaxLength(int i) {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    public void setState(int i) {
        this.f30120c = i;
    }

    public int getState() {
        return this.f30120c;
    }

    /* renamed from: com.didi.payment.base.widget.CommonEditText$2 */
    static /* synthetic */ class C105422 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$payment$base$widget$CommonEditText$TYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.payment.base.widget.CommonEditText$TYPE[] r0 = com.didi.payment.base.widget.CommonEditText.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$payment$base$widget$CommonEditText$TYPE = r0
                com.didi.payment.base.widget.CommonEditText$TYPE r1 = com.didi.payment.base.widget.CommonEditText.TYPE.CARD_NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$payment$base$widget$CommonEditText$TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.base.widget.CommonEditText$TYPE r1 = com.didi.payment.base.widget.CommonEditText.TYPE.DATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$payment$base$widget$CommonEditText$TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.payment.base.widget.CommonEditText$TYPE r1 = com.didi.payment.base.widget.CommonEditText.TYPE.CVV     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$payment$base$widget$CommonEditText$TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.payment.base.widget.CommonEditText$TYPE r1 = com.didi.payment.base.widget.CommonEditText.TYPE.TEXT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$payment$base$widget$CommonEditText$TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.payment.base.widget.CommonEditText$TYPE r1 = com.didi.payment.base.widget.CommonEditText.TYPE.NUMBER_DECIMAL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.widget.CommonEditText.C105422.<clinit>():void");
        }
    }

    public void setType(TYPE type) {
        int i = C105422.$SwitchMap$com$didi$payment$base$widget$CommonEditText$TYPE[type.ordinal()];
        if (i == 1) {
            setInputType(2);
        } else if (i == 2) {
            setInputType(2);
        } else if (i == 3) {
            setInputType(2);
        } else if (i == 4) {
            setInputType(1);
        } else if (i == 5) {
            setInputType(8192);
        }
    }

    public static class NumberTextWatcherForThousand implements TextWatcher {
        String decimalSeperator;
        EditText innerEdittext;
        String mGroupSeparator;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public NumberTextWatcherForThousand(EditText editText, String str, String str2) {
            this.innerEdittext = editText;
            this.decimalSeperator = str;
            this.mGroupSeparator = str2;
        }

        public void afterTextChanged(Editable editable) {
            try {
                this.innerEdittext.removeTextChangedListener(this);
                String obj = this.innerEdittext.getText().toString();
                if (obj != null && !obj.equals("")) {
                    if (obj.startsWith(this.decimalSeperator)) {
                        EditText editText = this.innerEdittext;
                        editText.setText("0" + this.decimalSeperator);
                    }
                    if (obj.startsWith("0")) {
                        if (!obj.startsWith("0" + this.decimalSeperator)) {
                            this.innerEdittext.setText("");
                        }
                    }
                    this.innerEdittext.setText(getDecimalFormat(this.innerEdittext.getText().toString().replaceAll("\\" + this.mGroupSeparator, "")));
                    this.innerEdittext.setSelection(this.innerEdittext.getText().toString().length());
                }
                this.innerEdittext.addTextChangedListener(this);
            } catch (Exception e) {
                e.printStackTrace();
                this.innerEdittext.addTextChangedListener(this);
            }
            if (editable.toString().contains(this.decimalSeperator)) {
                this.innerEdittext.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                return;
            }
            EditText editText2 = this.innerEdittext;
            editText2.setKeyListener(DigitsKeyListener.getInstance("0123456789" + this.decimalSeperator));
        }

        public String getDecimalFormat(String str) {
            String str2;
            StringTokenizer stringTokenizer = new StringTokenizer(str, this.decimalSeperator);
            if (stringTokenizer.countTokens() > 1) {
                str = stringTokenizer.nextToken();
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            if (str.charAt(str.length() - 1) == this.decimalSeperator.charAt(0)) {
                length--;
                sb = new StringBuilder(this.decimalSeperator);
            }
            int i = 0;
            while (length >= 0) {
                if (i == 3) {
                    sb.insert(0, this.mGroupSeparator);
                    i = 0;
                }
                sb.insert(0, str.charAt(length));
                i++;
                length--;
            }
            if (str2.length() > 0) {
                sb.append(this.decimalSeperator);
                sb.append(str2);
            }
            return sb.toString();
        }
    }

    public void registeTextChangeListener(OnTextChangeListener onTextChangeListener) {
        this.f30119b = onTextChangeListener;
    }

    public static abstract class EditStyleAdapter {
        public EditText mEdittext;

        public abstract TextWatcher getWatcher();

        public void init() {
        }

        /* access modifiers changed from: protected */
        public void bindEditText(EditText editText) {
            this.mEdittext = editText;
            editText.addTextChangedListener(getWatcher());
        }
    }

    public void setOnKeyboardListener(KeyboardListener keyboardListener) {
        this.f30118a = keyboardListener;
    }

    public void setTExtChangeListener(OnTextChangeListener onTextChangeListener) {
        this.f30119b = onTextChangeListener;
    }
}
