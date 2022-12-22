package com.didi.sdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C10448R;
import com.taxis99.R;

public class DropDownListView extends ListView implements AbsListView.OnScrollListener {
    public static final int HEADER_STATUS_CLICK_TO_LOAD = 1;
    public static final int HEADER_STATUS_DROP_DOWN_TO_LOAD = 2;
    public static final int HEADER_STATUS_LOADING = 4;
    public static final int HEADER_STATUS_RELEASE_TO_LOAD = 3;

    /* renamed from: A */
    private boolean f37790A = false;

    /* renamed from: B */
    private int f37791B;

    /* renamed from: C */
    private int f37792C;

    /* renamed from: D */
    private boolean f37793D = false;

    /* renamed from: E */
    private RotateAnimation f37794E;

    /* renamed from: F */
    private RotateAnimation f37795F;

    /* renamed from: G */
    private int f37796G;

    /* renamed from: H */
    private int f37797H;

    /* renamed from: I */
    private float f37798I;

    /* renamed from: J */
    private boolean f37799J = false;

    /* renamed from: a */
    private boolean f37800a = true;

    /* renamed from: b */
    private boolean f37801b = true;

    /* renamed from: c */
    private boolean f37802c = false;

    /* renamed from: d */
    private String f37803d;

    /* renamed from: e */
    private String f37804e;

    /* renamed from: f */
    private String f37805f;

    /* renamed from: g */
    private String f37806g;

    /* renamed from: h */
    private String f37807h;

    /* renamed from: i */
    private String f37808i;

    /* renamed from: j */
    private String f37809j;

    /* renamed from: k */
    private Context f37810k;

    /* renamed from: l */
    private RelativeLayout f37811l;

    /* renamed from: m */
    private ImageView f37812m;

    /* renamed from: n */
    private ProgressBar f37813n;

    /* renamed from: o */
    private TextView f37814o;

    /* renamed from: p */
    private TextView f37815p;

    /* renamed from: q */
    private RelativeLayout f37816q;

    /* renamed from: r */
    private ProgressBar f37817r;

    /* renamed from: s */
    private Button f37818s;

    /* renamed from: t */
    private OnDropDownListener f37819t;

    /* renamed from: u */
    private AbsListView.OnScrollListener f37820u;

    /* renamed from: v */
    private float f37821v = 1.5f;

    /* renamed from: w */
    private int f37822w;

    /* renamed from: x */
    private boolean f37823x = true;

    /* renamed from: y */
    private boolean f37824y = true;

    /* renamed from: z */
    private boolean f37825z = true;

    public interface OnDropDownListener {
        void onDropDown();
    }

    public DropDownListView(Context context) {
        super(context);
        m26772a(context);
    }

    public DropDownListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26773a(context, attributeSet);
        m26772a(context);
    }

    public DropDownListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26773a(context, attributeSet);
        m26772a(context);
    }

    /* renamed from: a */
    private void m26772a(Context context) {
        this.f37810k = context;
        m26771a();
        m26776b();
        super.setOnScrollListener(this);
    }

    /* renamed from: a */
    private void m26771a() {
        RelativeLayout relativeLayout = this.f37811l;
        if (relativeLayout != null) {
            if (this.f37800a) {
                addHeaderView(relativeLayout);
            } else {
                removeHeaderView(relativeLayout);
            }
        } else if (this.f37800a) {
            this.f37822w = this.f37810k.getResources().getDimensionPixelSize(R.dimen.drop_down_list_header_release_min_distance);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.f37794E = rotateAnimation;
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.f37794E.setDuration(250);
            this.f37794E.setFillAfter(true);
            RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.f37795F = rotateAnimation2;
            rotateAnimation2.setInterpolator(new LinearInterpolator());
            this.f37795F.setDuration(250);
            this.f37795F.setFillAfter(true);
            this.f37803d = this.f37810k.getString(R.string.drop_down_list_header_default_text);
            this.f37804e = this.f37810k.getString(R.string.drop_down_list_header_pull_text);
            this.f37805f = this.f37810k.getString(R.string.drop_down_list_header_release_text);
            this.f37806g = this.f37810k.getString(R.string.drop_down_list_header_loading_text);
            RelativeLayout relativeLayout2 = (RelativeLayout) ((LayoutInflater) this.f37810k.getSystemService("layout_inflater")).inflate(R.layout.v_drop_down_list_header, this, false);
            this.f37811l = relativeLayout2;
            this.f37814o = (TextView) relativeLayout2.findViewById(R.id.drop_down_list_header_default_text);
            this.f37812m = (ImageView) this.f37811l.findViewById(R.id.drop_down_list_header_image);
            this.f37813n = (ProgressBar) this.f37811l.findViewById(R.id.drop_down_list_header_progress_bar);
            this.f37815p = (TextView) this.f37811l.findViewById(R.id.drop_down_list_header_second_text);
            this.f37811l.setClickable(true);
            this.f37811l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DropDownListView.this.onDropDown();
                }
            });
            this.f37814o.setText(this.f37803d);
            addHeaderView(this.f37811l);
            m26775a((View) this.f37811l);
            this.f37796G = this.f37811l.getMeasuredHeight();
            this.f37797H = this.f37811l.getPaddingTop();
            this.f37792C = 1;
        }
    }

    /* renamed from: b */
    private void m26776b() {
        RelativeLayout relativeLayout = this.f37816q;
        if (relativeLayout != null) {
            if (this.f37801b) {
                addFooterView(relativeLayout);
            } else {
                removeFooterView(relativeLayout);
            }
        } else if (this.f37801b) {
            this.f37807h = this.f37810k.getString(R.string.drop_down_list_footer_default_text);
            this.f37808i = this.f37810k.getString(R.string.drop_down_list_footer_loading_text);
            this.f37809j = this.f37810k.getString(R.string.drop_down_list_footer_no_more_text);
            RelativeLayout relativeLayout2 = (RelativeLayout) ((LayoutInflater) this.f37810k.getSystemService("layout_inflater")).inflate(R.layout.v_drop_down_list_footer, this, false);
            this.f37816q = relativeLayout2;
            Button button = (Button) relativeLayout2.findViewById(R.id.drop_down_list_footer_button);
            this.f37818s = button;
            button.setDrawingCacheBackgroundColor(0);
            this.f37818s.setEnabled(true);
            this.f37817r = (ProgressBar) this.f37816q.findViewById(R.id.drop_down_list_footer_progress_bar);
            addFooterView(this.f37816q);
        }
    }

    public boolean isDropDownStyle() {
        return this.f37800a;
    }

    public void setDropDownStyle(boolean z) {
        if (this.f37800a != z) {
            this.f37800a = z;
            m26771a();
        }
    }

    public boolean isOnBottomStyle() {
        return this.f37801b;
    }

    public void setOnBottomStyle(boolean z) {
        if (this.f37801b != z) {
            this.f37801b = z;
            m26776b();
        }
    }

    public boolean isAutoLoadOnBottom() {
        return this.f37802c;
    }

    public void setAutoLoadOnBottom(boolean z) {
        this.f37802c = z;
    }

    public boolean isShowFooterProgressBar() {
        return this.f37824y;
    }

    public void setShowFooterProgressBar(boolean z) {
        this.f37824y = z;
    }

    public boolean isShowFooterButton() {
        return this.f37825z;
    }

    public void setIsShowFooterButton(boolean z) {
        this.f37825z = z;
    }

    public boolean isShowFooterWhenNoMore() {
        return this.f37790A;
    }

    public void setShowFooterWhenNoMore(boolean z) {
        this.f37790A = z;
    }

    public Button getFooterButton() {
        return this.f37818s;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (this.f37800a) {
            setSecondPositionVisible();
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f37820u = onScrollListener;
    }

    public void setOnDropDownListener(OnDropDownListener onDropDownListener) {
        this.f37819t = onDropDownListener;
    }

    public void setOnBottomListener(View.OnClickListener onClickListener) {
        if (this.f37801b) {
            this.f37818s.setOnClickListener(onClickListener);
            return;
        }
        throw new RuntimeException("isOnBottomStyle is false, cannot call setOnBottomListener, you can call setOnBottomStyle(true) at first.");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (!this.f37800a) {
            return super.onTouchEvent(motionEvent);
        }
        this.f37793D = false;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f37798I = motionEvent.getY();
        } else if (action == 1) {
            if (!isVerticalScrollBarEnabled()) {
                setVerticalScrollBarEnabled(true);
            }
            if (getFirstVisiblePosition() == 0 && (i = this.f37792C) != 4) {
                if (i == 2) {
                    m26779e();
                    setSecondPositionVisible();
                } else if (i == 3) {
                    onDropDown();
                }
            }
        } else if (action == 2) {
            m26774a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f37800a) {
            if (this.f37791B != 1 || this.f37792C == 4) {
                if (this.f37791B == 2 && i == 0 && this.f37792C != 4) {
                    setSecondPositionVisible();
                    this.f37793D = true;
                } else if (this.f37791B == 2 && this.f37793D) {
                    setSecondPositionVisible();
                }
            } else if (i == 0) {
                this.f37812m.setVisibility(0);
                int i4 = this.f37796G + this.f37822w;
                if (this.f37811l.getBottom() >= i4) {
                    m26781g();
                } else if (this.f37811l.getBottom() < i4) {
                    m26780f();
                }
            } else {
                m26779e();
            }
        }
        if (this.f37801b && this.f37802c && this.f37823x && i > 0 && i3 > 0 && i + i2 == i3) {
            onBottom();
        }
        AbsListView.OnScrollListener onScrollListener = this.f37820u;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f37800a) {
            this.f37791B = i;
            if (i == 0) {
                this.f37793D = false;
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.f37820u;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    /* renamed from: c */
    private void m26777c() {
        if (this.f37800a) {
            m26782h();
        }
    }

    public void onDropDown() {
        if (this.f37792C != 4 && this.f37800a && this.f37819t != null) {
            m26777c();
            this.f37819t.onDropDown();
        }
    }

    public void onDropDownComplete(CharSequence charSequence) {
        if (this.f37800a) {
            setHeaderSecondText(charSequence);
            onDropDownComplete();
        }
    }

    public void setHeaderSecondText(CharSequence charSequence) {
        if (!this.f37800a) {
            return;
        }
        if (charSequence == null) {
            this.f37815p.setVisibility(8);
            return;
        }
        this.f37815p.setVisibility(0);
        this.f37815p.setText(charSequence);
    }

    public void onDropDownComplete() {
        if (this.f37800a) {
            m26779e();
            if (this.f37811l.getBottom() > 0) {
                invalidateViews();
                setSecondPositionVisible();
            }
        }
    }

    /* renamed from: d */
    private void m26778d() {
        if (this.f37801b) {
            if (this.f37824y) {
                this.f37817r.setVisibility(0);
            }
            this.f37818s.setText(this.f37808i);
            this.f37818s.setEnabled(false);
        }
    }

    public void onBottom() {
        if (this.f37801b && !this.f37799J) {
            this.f37799J = true;
            m26778d();
            this.f37818s.performClick();
        }
    }

    public void onBottomComplete() {
        if (this.f37801b) {
            if (this.f37824y) {
                this.f37817r.setVisibility(8);
            }
            if (!this.f37823x) {
                this.f37818s.setText(this.f37809j);
                this.f37818s.setEnabled(false);
                if (!this.f37790A) {
                    removeFooterView(this.f37816q);
                }
            } else {
                this.f37818s.setText(this.f37807h);
                this.f37818s.setEnabled(true);
            }
            this.f37799J = false;
        }
    }

    public void setSecondPositionVisible() {
        if (getAdapter() != null && getAdapter().getCount() > 0 && getFirstVisiblePosition() == 0) {
            setSelection(1);
        }
    }

    public boolean isHasMore() {
        return this.f37823x;
    }

    public void setHasMore(boolean z) {
        this.f37823x = z;
    }

    public RelativeLayout getHeaderLayout() {
        return this.f37811l;
    }

    public RelativeLayout getFooterLayout() {
        return this.f37816q;
    }

    public float getHeaderPaddingTopRate() {
        return this.f37821v;
    }

    public void setHeaderPaddingTopRate(float f) {
        this.f37821v = f;
    }

    public int getHeaderReleaseMinDistance() {
        return this.f37822w;
    }

    public void setHeaderReleaseMinDistance(int i) {
        this.f37822w = i;
    }

    public String getHeaderDefaultText() {
        return this.f37803d;
    }

    public void setHeaderDefaultText(String str) {
        this.f37803d = str;
        TextView textView = this.f37814o;
        if (textView != null && this.f37792C == 1) {
            textView.setText(str);
        }
    }

    public String getHeaderPullText() {
        return this.f37804e;
    }

    public void setHeaderPullText(String str) {
        this.f37804e = str;
    }

    public String getHeaderReleaseText() {
        return this.f37805f;
    }

    public void setHeaderReleaseText(String str) {
        this.f37805f = str;
    }

    public String getHeaderLoadingText() {
        return this.f37806g;
    }

    public void setHeaderLoadingText(String str) {
        this.f37806g = str;
    }

    public String getFooterDefaultText() {
        return this.f37807h;
    }

    public void setFooterDefaultText(String str) {
        this.f37807h = str;
        Button button = this.f37818s;
        if (button != null && button.isEnabled()) {
            this.f37818s.setText(str);
        }
    }

    public String getFooterLoadingText() {
        return this.f37808i;
    }

    public void setFooterLoadingText(String str) {
        this.f37808i = str;
    }

    public String getFooterNoMoreText() {
        return this.f37809j;
    }

    public void setFooterNoMoreText(String str) {
        this.f37809j = str;
    }

    /* renamed from: e */
    private void m26779e() {
        if (this.f37792C != 1) {
            m26783i();
            this.f37812m.clearAnimation();
            this.f37812m.setVisibility(8);
            this.f37813n.setVisibility(8);
            this.f37814o.setText(this.f37803d);
            this.f37792C = 1;
        }
    }

    /* renamed from: f */
    private void m26780f() {
        if (this.f37792C != 2) {
            this.f37812m.setVisibility(0);
            if (this.f37792C != 1) {
                this.f37812m.clearAnimation();
                this.f37812m.startAnimation(this.f37795F);
            }
            this.f37813n.setVisibility(8);
            this.f37814o.setText(this.f37804e);
            if (isVerticalFadingEdgeEnabled()) {
                setVerticalScrollBarEnabled(false);
            }
            this.f37792C = 2;
        }
    }

    /* renamed from: g */
    private void m26781g() {
        if (this.f37792C != 3) {
            this.f37812m.setVisibility(0);
            this.f37812m.clearAnimation();
            this.f37812m.startAnimation(this.f37794E);
            this.f37813n.setVisibility(8);
            this.f37814o.setText(this.f37805f);
            this.f37792C = 3;
        }
    }

    /* renamed from: h */
    private void m26782h() {
        if (this.f37792C != 4) {
            m26783i();
            this.f37812m.setVisibility(8);
            this.f37812m.clearAnimation();
            this.f37813n.setVisibility(0);
            this.f37814o.setText(this.f37806g);
            this.f37792C = 4;
            setSelection(0);
        }
    }

    /* renamed from: a */
    private void m26774a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        if (isVerticalFadingEdgeEnabled()) {
            setVerticalScrollBarEnabled(false);
        }
        for (int i = 0; i < historySize; i++) {
            int i2 = this.f37792C;
            if (i2 == 2 || i2 == 3) {
                RelativeLayout relativeLayout = this.f37811l;
                relativeLayout.setPaddingRelative(relativeLayout.getPaddingLeft(), (int) (((motionEvent.getHistoricalY(i) - this.f37798I) - ((float) this.f37796G)) / this.f37821v), this.f37811l.getPaddingRight(), this.f37811l.getPaddingBottom());
            }
        }
    }

    /* renamed from: i */
    private void m26783i() {
        RelativeLayout relativeLayout = this.f37811l;
        relativeLayout.setPaddingRelative(relativeLayout.getPaddingLeft(), this.f37797H, this.f37811l.getPaddingRight(), this.f37811l.getPaddingBottom());
    }

    /* renamed from: a */
    private void m26775a(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
    }

    /* renamed from: a */
    private void m26773a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.drop_down_list_attr);
        this.f37800a = obtainStyledAttributes.getBoolean(1, false);
        this.f37801b = obtainStyledAttributes.getBoolean(2, false);
        this.f37802c = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }
}
