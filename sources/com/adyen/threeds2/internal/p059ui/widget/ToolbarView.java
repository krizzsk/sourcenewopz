package com.adyen.threeds2.internal.p059ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.adyen.threeds2.internal.ui.widget.ToolbarView */
public final class ToolbarView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private final TextView f1078a;

    /* renamed from: b */
    private final Button f1079b;

    /* renamed from: c */
    private C1427a f1080c;

    /* renamed from: com.adyen.threeds2.internal.ui.widget.ToolbarView$a */
    public interface C1427a {
        /* renamed from: a */
        void mo13873a();
    }

    public ToolbarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.f1080c != null && view.equals(this.f1079b)) {
            this.f1080c.mo13873a();
        }
    }

    public void setBackgroundColor(int i) {
        getChildAt(0).setBackgroundColor(i);
    }

    public void setCancelButtonBackgroundColor(int i) {
        this.f1079b.setBackgroundColor(i);
    }

    public void setCancelButtonText(String str) {
        this.f1079b.setText(str);
    }

    public void setCancelButtonTextColor(int i) {
        this.f1079b.setTextColor(i);
    }

    public void setCancelButtonTextTypeface(Typeface typeface) {
        this.f1079b.setTypeface(typeface);
    }

    public void setTitle(String str) {
        this.f1078a.setText(str);
    }

    public void setTitleFontSize(Integer num) {
        this.f1078a.setTextSize((float) num.intValue());
    }

    public void setTitleTextColor(int i) {
        this.f1078a.setTextColor(i);
    }

    public void setTitleTypeface(Typeface typeface) {
        this.f1078a.setTypeface(typeface);
    }

    public void setToolbarListener(C1427a aVar) {
        this.f1080c = aVar;
    }

    public ToolbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToolbarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LinearLayout.inflate(context, R.layout.a3ds2_widget_toolbar, this);
        CharSequence loadLabel = getContext().getApplicationInfo().loadLabel(getContext().getPackageManager());
        TextView textView = (TextView) findViewById(R.id.textView_title);
        this.f1078a = textView;
        textView.setText(loadLabel);
        Button button = (Button) findViewById(R.id.button_cancel);
        this.f1079b = button;
        button.setOnClickListener(this);
    }
}
