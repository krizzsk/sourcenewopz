package com.didi.beatles.p099im.views.titlebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.resource.IMThemeConstant;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.titlebar.CommonTitleBar */
public class CommonTitleBar extends RelativeLayout {

    /* renamed from: a */
    private ImageView f10445a;

    /* renamed from: b */
    private TextView f10446b;

    /* renamed from: c */
    private TextView f10447c;

    /* renamed from: d */
    private TextView f10448d;

    /* renamed from: e */
    private ImageView f10449e;

    /* renamed from: f */
    private ImageView f10450f;

    /* renamed from: g */
    private LinearLayout f10451g;

    /* renamed from: h */
    private ImageView f10452h;

    /* renamed from: i */
    private ViewGroup f10453i;

    /* renamed from: b */
    private boolean m7107b(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public CommonTitleBar(Context context) {
        super(context);
        m7102a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7102a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7102a();
    }

    public CommonTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m7102a();
    }

    public void resetLayout(int i) {
        removeAllViews();
        m7103a(i);
    }

    /* renamed from: a */
    private void m7102a() {
        m7103a((int) R.layout.im_common_title_bar);
        initResource();
    }

    /* renamed from: a */
    private void m7103a(int i) {
        LayoutInflater.from(getContext()).inflate(i, this, true);
        this.f10453i = (ViewGroup) findViewById(R.id.title_bar_layout_above);
        this.f10445a = (ImageView) findViewById(R.id.common_title_bar_left_img);
        this.f10450f = (ImageView) findViewById(R.id.ub_title_bar_left_img);
        this.f10446b = (TextView) findViewById(R.id.common_title_bar_middle_tv);
        this.f10447c = (TextView) findViewById(R.id.common_title_bar_sub_tv);
        this.f10448d = (TextView) findViewById(R.id.common_title_bar_right_tv);
        this.f10452h = (ImageView) findViewById(R.id.common_title_bar_line);
        this.f10449e = (ImageView) findViewById(R.id.common_title_bar_right_iv);
        this.f10451g = (LinearLayout) findViewById(R.id.common_title_bar_right_layout);
    }

    public void initResource() {
        ViewGroup viewGroup = this.f10453i;
        if (viewGroup != null && this.f10446b != null) {
            viewGroup.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_nomix_titlebar_bg));
            this.f10446b.setTextSize(0, IMResource.getDimension(R.dimen.im_nomix_titlebar_textsize, 18));
            this.f10446b.setTextColor(IMResource.getColor(R.color.im_nomix_color_titlebar_text));
        }
    }

    public ImageView getLeftImgView() {
        return this.f10445a;
    }

    public TextView getRightTextView() {
        return this.f10448d;
    }

    public void setTitle(int i) {
        TextView textView = this.f10446b;
        if (textView != null) {
            m7105a(textView, i);
            m7104a((View) this.f10446b);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f10446b;
        if (textView != null) {
            m7106a(textView, str);
            m7104a((View) this.f10446b);
        }
    }

    public void setRightText(int i) {
        TextView textView = this.f10448d;
        if (textView != null) {
            m7105a(textView, i);
            m7104a((View) this.f10448d);
        }
    }

    public void setRightText(String str) {
        TextView textView = this.f10448d;
        if (textView != null) {
            m7106a(textView, str);
            m7104a((View) this.f10448d);
        }
    }

    public void setRightExtendIv(int i, View.OnClickListener onClickListener) {
        ImageView imageView = this.f10449e;
        if (imageView != null) {
            imageView.setImageResource(i);
            if (onClickListener != null) {
                this.f10449e.setOnClickListener(onClickListener);
            }
        }
    }

    public void setRightExtendIvVisible(int i) {
        ImageView imageView = this.f10449e;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public boolean isRightExtendViewIsShowing() {
        ImageView imageView = this.f10449e;
        if (imageView == null) {
            return false;
        }
        return imageView.isShown();
    }

    public ImageView getRightExtendView() {
        return this.f10449e;
    }

    public void setRightImg(int i) {
        TextView textView = this.f10448d;
        if (textView != null) {
            m7106a(textView, "");
            m7104a((View) this.f10448d);
            this.f10448d.setBackgroundResource(IMResource.getDrawableID(i));
        }
    }

    public View getRightImg() {
        if (this.f10448d == null) {
            return null;
        }
        return this.f10449e;
    }

    public void hideRightImg() {
        TextView textView = this.f10448d;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public LinearLayout getRightLayout() {
        return this.f10451g;
    }

    public void setRightText(int i, View.OnClickListener onClickListener) {
        TextView textView = this.f10448d;
        if (textView != null) {
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            m7105a(this.f10448d, i);
            m7104a((View) this.f10448d);
        }
    }

    public void setRightText(String str, View.OnClickListener onClickListener) {
        TextView textView = this.f10448d;
        if (textView != null) {
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            m7106a(this.f10448d, str);
            m7104a((View) this.f10448d);
        }
    }

    public void setLeftBackListener(View.OnClickListener onClickListener) {
        setLeftImage(IMResource.getDrawableID(R.drawable.im_common_title_bar_btn_back_selector), onClickListener);
        ImageView imageView = this.f10450f;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setLeftImage(int i, View.OnClickListener onClickListener) {
        ImageView imageView = this.f10445a;
        if (imageView != null) {
            if (onClickListener != null) {
                imageView.setOnClickListener(onClickListener);
            }
            this.f10445a.setImageResource(i);
            m7104a((View) this.f10445a);
        }
    }

    public void setLeftImage(Drawable drawable, View.OnClickListener onClickListener) {
        ImageView imageView = this.f10445a;
        if (imageView != null) {
            if (onClickListener != null) {
                imageView.setOnClickListener(onClickListener);
            }
            if (drawable != null) {
                this.f10445a.setImageDrawable(drawable);
            }
            m7104a((View) this.f10445a);
        }
    }

    public void setLeftVisible(int i) {
        if (this.f10445a != null && m7107b(i)) {
            this.f10445a.setVisibility(i);
        }
    }

    public void setTitleLineVisible(int i) {
        if (this.f10446b != null && m7107b(i)) {
            this.f10446b.setVisibility(i);
        }
    }

    public void setRightVisible(int i) {
        if (this.f10448d != null && m7107b(i)) {
            this.f10448d.setVisibility(i);
        }
    }

    public void setTitleBarLineVisible(int i) {
        if (this.f10452h != null && m7107b(i)) {
            this.f10452h.setVisibility(i);
        }
    }

    public void setTitleBackground(int i) {
        ViewGroup viewGroup = this.f10453i;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(i);
        }
    }

    public void setTitleConfig(IMBusinessConfig iMBusinessConfig) {
        if (this.f10445a != null && this.f10450f != null && this.f10446b != null && this.f10452h != null && this.f10453i != null && iMBusinessConfig != null) {
            if (iMBusinessConfig.isUber()) {
                this.f10445a.setVisibility(8);
                this.f10450f.setVisibility(0);
                this.f10446b.getPaint().setFakeBoldText(true);
                this.f10446b.setTextColor(getContext().getResources().getColor(R.color.black));
                this.f10452h.setImageResource(R.color.ub_title_bar_line_bg);
                this.f10453i.setBackgroundResource(R.color.ub_title_bar_bg);
                return;
            }
            if (iMBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_TITLE_ICON) != -1) {
                this.f10445a.setImageResource(iMBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_TITLE_ICON));
            }
            if (iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_BG) != -1) {
                this.f10453i.setBackgroundResource(iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_BG));
            }
            if (iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_FONT_COLOR) != -1) {
                this.f10446b.setTextColor(getContext().getResources().getColor(iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_FONT_COLOR)));
            }
            if (iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_DIVIDE_COLOR) != -1) {
                this.f10452h.setImageResource(iMBusinessConfig.getExtendColorResource(IMThemeConstant.IM_TITLE_DIVIDE_COLOR));
            }
        }
    }

    public void setRightTextColor(int i) {
        TextView textView = this.f10448d;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setRightClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f10448d;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: a */
    private void m7105a(TextView textView, int i) {
        textView.setText(i);
    }

    /* renamed from: a */
    private void m7106a(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: a */
    private void m7104a(View view) {
        view.setVisibility(0);
    }

    public void setSubTitle(String str) {
        TextView textView = this.f10447c;
        if (textView != null) {
            textView.setText(str);
            this.f10447c.setVisibility(0);
        }
    }
}
