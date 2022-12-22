package com.didi.component.ridestatus.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.ridestatus.AbsRideStatusPresenter;
import com.didi.component.ridestatus.IRideStatusView;
import com.taxis99.R;

public class OptimizeRideStatusView implements IRideStatusView {

    /* renamed from: a */
    private Context f15342a;

    /* renamed from: b */
    private View f15343b;

    /* renamed from: c */
    private RelativeLayout f15344c;

    /* renamed from: d */
    private TextView f15345d;

    /* renamed from: e */
    private TextView f15346e;

    /* renamed from: f */
    private ImageView f15347f;

    /* renamed from: g */
    private ImageView f15348g;

    /* renamed from: h */
    private String f15349h;

    /* renamed from: i */
    private boolean f15350i;

    /* renamed from: j */
    private boolean f15351j;
    protected AbsRideStatusPresenter mAbsRideStatusPresenter;

    public void setActivityIcon(String str) {
    }

    public void setContextTextMinLines(int i) {
    }

    public void setIcon(Drawable drawable) {
    }

    public void setPlaceHolderTitle(String str) {
    }

    public void setPlaceHolderTitleVisible(boolean z) {
    }

    public void setTimeTextVisible(boolean z) {
    }

    public void setTipText(String str) {
    }

    public void showWhyWaitIcon(boolean z) {
    }

    public void startLottieAnimation(String str, String str2, long j) {
    }

    public void startSubTitleFadeInAnimation(long j) {
    }

    public void startTitleFadeInAnimation(long j) {
    }

    public OptimizeRideStatusView(Context context) {
        this.f15342a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_op_ride_status_important_layout, (ViewGroup) null);
        this.f15343b = inflate;
        this.f15346e = (TextView) inflate.findViewById(R.id.op_ride_status_content_text);
        if (this.f15343b.getLayoutParams() == null) {
            this.f15343b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        }
        this.f15344c = (RelativeLayout) this.f15343b.findViewById(R.id.op_ride_status_layout);
        this.f15345d = (TextView) this.f15343b.findViewById(R.id.op_ride_status_title_text);
    }

    public void setPresenter(AbsRideStatusPresenter absRideStatusPresenter) {
        this.mAbsRideStatusPresenter = absRideStatusPresenter;
    }

    public void setTitleText(String str) {
        TextView textView = this.f15345d;
        if (textView != null) {
            textView.setText(HighlightUtil.highlight(textView.getContext(), str));
        }
    }

    public void setContentText(String str) {
        TextView textView = this.f15346e;
        if (textView != null) {
            textView.setText(HighlightUtil.highlight(this.f15343b.getContext(), str));
            this.f15346e.setVisibility(0);
            this.f15349h = str;
        }
    }

    public void setBackgroudColor(String str) {
        RelativeLayout relativeLayout = this.f15344c;
        if (relativeLayout != null) {
            ((GradientDrawable) relativeLayout.getBackground()).setColor(Color.parseColor(str));
        }
    }

    public void setEnhanceIconViewUrl(String str) {
        if (this.f15347f != null && !TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT >= 17) {
                Context context = this.f15342a;
                if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                    return;
                }
            }
            Context context2 = this.f15342a;
            if (!(context2 instanceof Activity) || !((Activity) context2).isFinishing()) {
                ((RequestBuilder) Glide.with(this.f15342a).asBitmap().load(str).placeholder((Drawable) null)).into(this.f15347f);
            }
        }
    }

    public void setCloseViewVisibility(int i) {
        ImageView imageView = this.f15348g;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f15348g;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setTitleVisible(boolean z) {
        this.f15345d.setVisibility(z ? 0 : 8);
    }

    public void setContentVisible(boolean z) {
        this.f15346e.setVisibility(z ? 0 : 8);
        this.f15350i = z;
    }

    public void setTitleWarning(boolean z) {
        if (z) {
            this.f15345d.setTextColor(Color.rgb(255, 0, 0));
        } else {
            this.f15345d.setTextColor(Color.rgb(0, 0, 0));
        }
    }

    public void setContentWarning(boolean z) {
        if (z) {
            TextView textView = this.f15346e;
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.theme_high_color));
        } else {
            this.f15346e.setTextColor(Color.rgb(102, 102, 102));
        }
        this.f15351j = z;
    }

    public String getContentText() {
        return this.f15349h;
    }

    public boolean isContentVisible() {
        return this.f15350i;
    }

    public boolean isContentWarning() {
        return this.f15351j;
    }

    public View getView() {
        return this.f15343b;
    }
}
