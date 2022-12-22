package com.didi.global.xbanner.view.base;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.basemodel.XBCardViewData;
import com.didi.global.xbanner.utils.DisplayUtils;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.global.xbanner.view.recycler.XBannerItemBean;
import com.didi.global.xbanner.view.recycler.XBannerOnScrollListener;
import com.didi.global.xbanner.view.recycler.XBannerPagerSnapHelper;
import com.didi.global.xbanner.view.recycler.XBannerRecyclerAdapter;
import com.didi.global.xbanner.view.recycler.XBannerScrollChangedListener;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;
import com.taxis99.R;
import java.util.List;

public class XBannerView extends RelativeLayout implements XbCardReloadListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RecyclerView f22945a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CardView f22946b;

    /* renamed from: c */
    private ImageView f22947c;

    /* renamed from: d */
    private XBannerRecyclerAdapter f22948d;

    /* renamed from: e */
    private Activity f22949e;

    /* renamed from: f */
    private XBannerInterceptFrame f22950f;

    /* renamed from: g */
    private XBannerOnScrollListener f22951g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f22952h = false;

    /* renamed from: i */
    private ExpandViewCallback f22953i;

    public XBannerView(Context context) {
        super(context);
        init(context);
    }

    public XBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public XBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.xbanner_view, this);
        this.f22945a = (RecyclerView) findViewById(R.id.xb_recycler_view);
        this.f22946b = (CardView) findViewById(R.id.xb_expand_view);
        this.f22945a.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f22945a.setOnFlingListener((RecyclerView.OnFlingListener) null);
        new XBannerPagerSnapHelper().attachToRecyclerView(this.f22945a);
        XBannerOnScrollListener xBannerOnScrollListener = new XBannerOnScrollListener();
        this.f22951g = xBannerOnScrollListener;
        this.f22945a.addOnScrollListener(xBannerOnScrollListener);
        this.f22947c = (ImageView) findViewById(R.id.shrink_icon);
    }

    public void setScrollChangedListener(XBannerScrollChangedListener xBannerScrollChangedListener) {
        this.f22951g.setScrollChangedListener(xBannerScrollChangedListener);
    }

    public void setXBannerExpandView(XBCardView xBCardView, XBCardViewData xBCardViewData, ExpandViewCallback expandViewCallback) {
        if (xBCardViewData != null) {
            View createView = xBCardView.createView(getContext(), xBCardViewData, XBannerUtil.getFullItemWidthWithoutMargin(getContext()));
            this.f22953i = expandViewCallback;
            if (createView != null) {
                m16519a(createView);
            } else {
                xBCardView.setReloadListener(this);
            }
        }
    }

    /* renamed from: a */
    private void m16519a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22946b.getLayoutParams();
        marginLayoutParams.width = XBannerUtil.getFullItemWidthWithoutMargin(view.getContext());
        marginLayoutParams.height = XBannerUtil.getUnfoldDefaultItemHeight(view.getContext());
        marginLayoutParams.leftMargin = (DisplayUtils.getScreenWidth(view.getContext()) - XBannerUtil.getFullItemWidthWithoutMargin(view.getContext())) / 2;
        marginLayoutParams.rightMargin = (DisplayUtils.getScreenWidth(view.getContext()) - XBannerUtil.getFullItemWidthWithoutMargin(view.getContext())) / 2;
        this.f22946b.setLayoutParams(marginLayoutParams);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setExpandVisibility(true);
        if (this.f22946b.getChildCount() > 1) {
            this.f22946b.removeViewAt(0);
        }
        this.f22946b.addView(view, 0);
        ExpandViewCallback expandViewCallback = this.f22953i;
        if (expandViewCallback != null) {
            expandViewCallback.onExpandViewShow();
        }
        this.f22947c.setVisibility(0);
        if (this.f22949e != null && m16522b() && this.f22950f == null) {
            XBannerInterceptFrame xBannerInterceptFrame = new XBannerInterceptFrame(getContext());
            this.f22950f = xBannerInterceptFrame;
            xBannerInterceptFrame.setNotInterceptArea(this.f22946b);
            this.f22950f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f22950f.setInterceptListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XBannerView.this.expandViewDismiss();
                }
            });
            ((ViewGroup) this.f22949e.getWindow().getDecorView()).addView(this.f22950f);
            this.f22950f.setVisibility(0);
            this.f22947c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XBannerView.this.expandViewDismiss();
                }
            });
        }
    }

    public void expandViewDismiss() {
        XBannerInterceptFrame xBannerInterceptFrame = this.f22950f;
        if (xBannerInterceptFrame != null && xBannerInterceptFrame.getVisibility() == 0) {
            this.f22950f.setVisibility(8);
            ((ViewGroup) this.f22949e.getWindow().getDecorView()).removeView(this.f22950f);
        }
        if (this.f22946b != null) {
            setExpandVisibility(false);
        }
        ExpandViewCallback expandViewCallback = this.f22953i;
        if (expandViewCallback != null) {
            expandViewCallback.onExpandViewDismiss();
        }
    }

    private void setExpandVisibility(boolean z) {
        if (z) {
            this.f22946b.setVisibility(0);
            this.f22945a.setVisibility(8);
            return;
        }
        m16518a();
    }

    public RecyclerView getRecyclerView() {
        return this.f22945a;
    }

    public void scrollToEnd() {
        RecyclerView recyclerView = this.f22945a;
        recyclerView.scrollToPosition(recyclerView.getChildCount() - 1);
    }

    public void scrollToStart() {
        this.f22945a.scrollToPosition(0);
    }

    /* renamed from: a */
    private void m16518a() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22946b, "ScaleY", new float[]{1.0f, 0.5f});
        this.f22946b.setPivotX(0.0f);
        this.f22946b.setPivotY((float) XBannerUtil.getUnfoldDefaultItemHeight(getContext()));
        this.f22945a.setVisibility(0);
        this.f22945a.setAlpha(0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22945a, "alpha", new float[]{0.0f, 1.0f});
        ofFloat2.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = XBannerView.this.f22952h = false;
            }

            public void onAnimationEnd(Animator animator) {
                XBannerView.this.f22945a.setAlpha(1.0f);
            }
        });
        if ((this.f22945a.getAdapter() == null ? 0 : this.f22945a.getAdapter().getItemCount()) > 1) {
            animatorSet.playTogether(new Animator[]{ofFloat, ObjectAnimator.ofFloat(this.f22946b, "ScaleX", new float[]{1.0f, ((float) XBannerUtil.getItemWidth(getContext())) / ((float) XBannerUtil.getFullItemWidthWithoutMargin(getContext()))}), ofFloat2});
        } else {
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f22946b, "alpha", new float[]{1.0f, 0.0f});
        ofFloat3.setDuration(100);
        ofFloat3.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                XBannerView.this.f22946b.setVisibility(8);
                boolean unused = XBannerView.this.f22952h = true;
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(new Animator[]{animatorSet, ofFloat3});
        animatorSet2.start();
    }

    public List<XBannerItemBean> getData() {
        return this.f22948d.getData();
    }

    public void setAttachedActivity(Activity activity) {
        this.f22949e = activity;
    }

    /* renamed from: b */
    private boolean m16522b() {
        CardView cardView = this.f22946b;
        if (cardView == null || cardView.getChildCount() == 0 || this.f22946b.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void setData(Context context, List<XBannerItemBean> list) {
        XBannerRecyclerAdapter xBannerRecyclerAdapter = this.f22948d;
        if (xBannerRecyclerAdapter == null) {
            XBannerRecyclerAdapter xBannerRecyclerAdapter2 = new XBannerRecyclerAdapter(list, context);
            this.f22948d = xBannerRecyclerAdapter2;
            this.f22945a.setAdapter(xBannerRecyclerAdapter2);
            return;
        }
        xBannerRecyclerAdapter.setData(list);
    }

    public void addData(Context context, List<XBannerItemBean> list) {
        XBannerRecyclerAdapter xBannerRecyclerAdapter = this.f22948d;
        if (xBannerRecyclerAdapter == null) {
            XBannerRecyclerAdapter xBannerRecyclerAdapter2 = new XBannerRecyclerAdapter(list, context);
            this.f22948d = xBannerRecyclerAdapter2;
            this.f22945a.setAdapter(xBannerRecyclerAdapter2);
            return;
        }
        xBannerRecyclerAdapter.addData(list);
    }

    public void removeItem(int i) {
        XBannerRecyclerAdapter xBannerRecyclerAdapter = this.f22948d;
        if (xBannerRecyclerAdapter != null) {
            xBannerRecyclerAdapter.removeItem(i);
        }
    }

    public void removeItemByCardId(String str) {
        XBannerRecyclerAdapter xBannerRecyclerAdapter = this.f22948d;
        if (xBannerRecyclerAdapter != null) {
            xBannerRecyclerAdapter.removeItemByCardId(str);
        }
    }

    public void onViewReload(View view) {
        if (this.f22953i != null) {
            m16519a(view);
        }
    }
}
