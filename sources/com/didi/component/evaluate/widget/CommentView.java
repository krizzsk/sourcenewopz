package com.didi.component.evaluate.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;

public class CommentView extends FrameLayout implements TextWatcher, View.OnFocusChangeListener {

    /* renamed from: b */
    private static final int f13433b = 140;

    /* renamed from: c */
    private static final int f13434c = 4;

    /* renamed from: d */
    private static final int f13435d = 3;

    /* renamed from: e */
    private static final int f13436e = 6;

    /* renamed from: f */
    private static final String f13437f = "comment";

    /* renamed from: a */
    boolean f13438a = false;

    /* renamed from: g */
    private EditText f13439g;

    /* renamed from: h */
    private TextView f13440h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f13441i = 1;

    /* renamed from: j */
    private EditTextHeightAnimator f13442j;

    /* renamed from: k */
    private RelativeLayout f13443k;

    /* renamed from: l */
    private TextView f13444l;

    /* renamed from: m */
    private OnContentChangeListener f13445m;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());

    public interface OnContentChangeListener {
        void onContentChange(CharSequence charSequence);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public boolean checkInputConnectionProxy(View view) {
        return true;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CommentView(Context context) {
        super(context);
        m9204a();
    }

    public CommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9204a();
    }

    public CommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9204a();
    }

    public CommentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m9204a();
    }

    /* renamed from: a */
    private void m9204a() {
        LayoutInflater.from(getContext()).inflate(R.layout.global_evaluate_comment_input_view, this);
        EditText editText = (EditText) findViewById(R.id.oc_evaluate_comment_view);
        this.f13439g = editText;
        editText.setOnFocusChangeListener(this);
        this.f13439g.addTextChangedListener(this);
        TextView textView = (TextView) findViewById(R.id.oc_evaluate_comment_text_limit_view);
        this.f13440h = textView;
        textView.setText(String.valueOf(140));
        this.f13443k = (RelativeLayout) findViewById(R.id.rly_content_container);
        this.f13444l = (TextView) findViewById(R.id.oc_evaluate_comment_content_view);
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f13438a = true;
            this.f13440h.setVisibility(0);
            return;
        }
        this.f13438a = false;
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f13439g.getWindowToken(), 0);
        m9208d();
        this.f13440h.setVisibility(8);
    }

    public String getText() {
        return this.f13439g.getText().toString().trim();
    }

    public void afterTextChanged(Editable editable) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < editable.length(); i3++) {
            if (editable.charAt(i3) == 10) {
                i2++;
            }
        }
        if (i2 > 3) {
            editable.delete(editable.length() - 1, editable.length());
        }
        if (editable.length() <= 140) {
            m9206b();
        }
        int length = 140 - editable.length();
        TextView textView = this.f13440h;
        StringBuilder sb = new StringBuilder();
        if (length >= 0) {
            i = length;
        }
        sb.append(i);
        sb.append("");
        textView.setText(sb.toString());
        OnContentChangeListener onContentChangeListener = this.f13445m;
        if (onContentChangeListener != null) {
            onContentChangeListener.onContentChange(editable.toString());
        }
    }

    /* renamed from: b */
    private void m9206b() {
        this.mLogger.info("update height on focus", new Object[0]);
        EditTextHeightAnimator editTextHeightAnimator = this.f13442j;
        if (editTextHeightAnimator != null && editTextHeightAnimator.isStarted() && this.f13442j.isRunning()) {
            this.f13442j.end();
        }
        int max = Math.max(m9207c(), 4);
        if (max != this.f13441i) {
            m9205a(max);
        }
    }

    /* renamed from: c */
    private int m9207c() {
        int lineCount = this.f13439g.getLineCount();
        if (lineCount >= 4) {
            return 4;
        }
        return lineCount;
    }

    /* renamed from: d */
    private void m9208d() {
        EditTextHeightAnimator editTextHeightAnimator = this.f13442j;
        if (editTextHeightAnimator != null && editTextHeightAnimator.isStarted() && this.f13442j.isRunning()) {
            this.f13442j.end();
        }
        int i = 4;
        if (this.f13439g.getLineCount() <= 4) {
            i = this.f13439g.getLineCount();
        }
        m9205a(i);
    }

    /* renamed from: a */
    private void m9205a(final int i) {
        EditTextHeightAnimator editTextHeightAnimator = new EditTextHeightAnimator(this.f13439g, this.f13441i, i);
        this.f13442j = editTextHeightAnimator;
        editTextHeightAnimator.setOnFinishListener(new EditTextHeightAnimator.OnFinishListener() {
            public void onFinish() {
                int unused = CommentView.this.f13441i = i;
            }
        });
        this.f13442j.start();
    }

    public void clearFocus() {
        super.clearFocus();
        this.f13439g.clearFocus();
    }

    public boolean isFocused() {
        return this.f13439g.isFocused();
    }

    public void setContent(String str) {
        this.f13439g.setVisibility(8);
        this.f13440h.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.f13443k.setVisibility(0);
            this.f13444l.setText(str);
        }
    }

    public int onKeyboardHeightChange(int i) {
        EditTextHeightAnimator editTextHeightAnimator;
        if (i > 0 && this.f13438a) {
            m9206b();
        }
        if (Math.max(m9207c(), 4) == this.f13441i || (editTextHeightAnimator = this.f13442j) == null) {
            return 0;
        }
        return editTextHeightAnimator.mDeltaHeight;
    }

    public int getFullHeight() {
        EditTextHeightAnimator editTextHeightAnimator = this.f13442j;
        if (editTextHeightAnimator != null) {
            return editTextHeightAnimator.getTargetHeight();
        }
        return this.f13444l.getLineHeight() * 2;
    }

    public void setOnContentChangeListener(OnContentChangeListener onContentChangeListener) {
        this.f13445m = onContentChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    static class EditTextHeightAnimator extends ValueAnimator implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        /* access modifiers changed from: private */
        public int mDeltaHeight;
        private OnFinishListener mEndListener;
        private int mOriginalHeight;
        private EditText mView;

        public interface OnFinishListener {
            void onFinish();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public EditTextHeightAnimator(EditText editText, int i, int i2) {
            this.mView = editText;
            int lineHeight = editText.getLineHeight() + (Build.VERSION.SDK_INT >= 16 ? (int) editText.getLineSpacingExtra() : 0);
            this.mDeltaHeight = (i2 - i) * lineHeight;
            this.mOriginalHeight = (i * lineHeight) + this.mView.getPaddingBottom() + this.mView.getPaddingTop();
        }

        public void start() {
            setIntValues(new int[]{0, this.mDeltaHeight});
            setDuration((long) (Math.abs(this.mDeltaHeight) * 2));
            setInterpolator(new LinearInterpolator());
            addUpdateListener(this);
            addListener(this);
            super.start();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.mView.setHeight(this.mOriginalHeight + ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        public void setOnFinishListener(OnFinishListener onFinishListener) {
            this.mEndListener = onFinishListener;
        }

        public void onAnimationEnd(Animator animator) {
            OnFinishListener onFinishListener = this.mEndListener;
            if (onFinishListener != null) {
                onFinishListener.onFinish();
                if (this.mView.getLineCount() < 4) {
                    this.mView.setMaxLines(4);
                } else {
                    this.mView.setMaxLines(6);
                }
                this.mView.requestLayout();
            }
        }

        public void end() {
            super.end();
        }

        public int getTargetHeight() {
            return this.mDeltaHeight;
        }
    }
}
