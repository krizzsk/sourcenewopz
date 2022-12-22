package com.didi.unifylogin.utils.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.taxis99.R;

public class LoginTitleBar extends AbsLoginTitleBar {

    /* renamed from: a */
    View f44996a;

    /* renamed from: b */
    TextView f44997b;

    /* renamed from: c */
    TextView f44998c;

    public LoginTitleBar(Context context) {
        super(context);
        m32251a(context);
    }

    public LoginTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32251a(context);
    }

    public LoginTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32251a(context);
    }

    /* renamed from: a */
    private void m32251a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.login_unify_layout_v_title_bar, this);
        this.f44996a = inflate.findViewById(R.id.ll_back);
        this.f44997b = (TextView) inflate.findViewById(R.id.tv_right);
        this.f44998c = (TextView) inflate.findViewById(R.id.tv_center);
    }

    public void setLeftClickListener(View.OnClickListener onClickListener) {
        View view = this.f44996a;
        if (view != null && onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setRightClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f44997b;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setLeftVisible(boolean z) {
        View view = this.f44996a;
        if (view != null) {
            view.setVisibility(z ? 0 : 4);
        }
    }

    public void setRightVisible(boolean z) {
        TextView textView = this.f44997b;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    public void setRightText(CharSequence charSequence) {
        TextView textView = this.f44997b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setCenterVisible(boolean z) {
        TextView textView = this.f44998c;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    public void setCenterMsg(String str) {
        TextView textView = this.f44998c;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
