package com.didi.beatles.p099im.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.passenger.C10448R;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMFolderTextView */
public class IMFolderTextView extends TextView {

    /* renamed from: a */
    private static final String f9872a = "...";

    /* renamed from: b */
    private String f9873b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f9874c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f9875d;

    /* renamed from: e */
    private boolean f9876e;

    /* renamed from: f */
    private int f9877f;

    /* renamed from: g */
    private String f9878g;

    /* renamed from: h */
    private float f9879h;

    /* renamed from: i */
    private float f9880i;

    public IMFolderTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMFolderTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMFolderTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9874c = false;
        this.f9875d = false;
        this.f9876e = false;
        this.f9877f = 2;
        this.f9879h = 1.0f;
        this.f9880i = 0.0f;
        this.f9873b = IMResource.getString(R.string.im_arrow_details);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C10448R.styleable.IMFolderTextView);
        this.f9877f = obtainStyledAttributes.getInt(0, 2);
        obtainStyledAttributes.recycle();
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMFolderTextView iMFolderTextView = IMFolderTextView.this;
                boolean unused = iMFolderTextView.f9874c = !iMFolderTextView.f9874c;
                boolean unused2 = IMFolderTextView.this.f9875d = false;
                IMFolderTextView.this.invalidate();
            }
        });
    }

    private void setUpdateText(CharSequence charSequence) {
        this.f9876e = true;
        setText(charSequence);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (TextUtils.isEmpty(this.f9878g) || !this.f9876e) {
            this.f9875d = false;
            this.f9878g = String.valueOf(charSequence);
        }
        super.setText(charSequence, bufferType);
    }

    public void setLineSpacing(float f, float f2) {
        this.f9880i = f;
        this.f9879h = f2;
        super.setLineSpacing(f, f2);
    }

    public int getFoldLine() {
        return this.f9877f;
    }

    public void setFoldLine(int i) {
        this.f9877f = i;
    }

    /* renamed from: a */
    private Layout m6675a(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.f9879h, this.f9880i, false);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.f9875d) {
            m6676a();
        }
        super.onDraw(canvas);
        this.f9875d = true;
        this.f9876e = false;
    }

    /* renamed from: a */
    private void m6676a() {
        String str = this.f9878g;
        if (this.f9874c) {
            setUpdateText(str);
        } else if (!m6683e(str)) {
            setUpdateText(str);
        } else {
            setUpdateText(m6681c(m6684f(str)));
        }
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: b */
    private SpannableString m6679b(String str) {
        String str2 = str + this.f9873b;
        int length = str2.length() - this.f9873b.length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan((Object) null, length, length2, 33);
        return spannableString;
    }

    /* renamed from: c */
    private SpannableString m6681c(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        int length = str.length() - this.f9873b.length();
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange)), length, length2, 33);
        return spannableString;
    }

    /* renamed from: d */
    private String m6682d(String str) {
        if (m6675a(str).getLineCount() <= getFoldLine()) {
            return str;
        }
        return m6684f(str);
    }

    /* renamed from: e */
    private boolean m6683e(String str) {
        return m6675a(str).getLineCount() > getFoldLine();
    }

    /* renamed from: f */
    private String m6684f(String str) {
        String str2 = str + f9872a + this.f9873b;
        Layout a = m6675a(str2);
        if (a.getLineCount() <= getFoldLine()) {
            return str2;
        }
        int lineEnd = a.getLineEnd(getFoldLine());
        if (str.length() < lineEnd) {
            lineEnd = str.length();
        }
        return m6684f(str.substring(0, lineEnd - 1));
    }
}
