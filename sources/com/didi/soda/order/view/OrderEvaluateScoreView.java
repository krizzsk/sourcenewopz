package com.didi.soda.order.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationScoreInfoEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CustomerSeekBar;
import com.taxis99.R;
import java.util.List;

public class OrderEvaluateScoreView extends FrameLayout {
    public static final int MAX_STAR_COUNT = 3;

    /* renamed from: a */
    private TextView f43604a;

    /* renamed from: b */
    private CustomerSeekBar f43605b;

    /* renamed from: c */
    private int f43606c;

    /* renamed from: d */
    private List<OrderEvaluationScoreInfoEntity> f43607d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnStarClickListener f43608e;

    /* renamed from: f */
    private ScaleAnimation f43609f;

    /* renamed from: g */
    private int f43610g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnInterceptClickListener f43611h;

    public interface OnInterceptClickListener {
        boolean onInterceptTouch();
    }

    public interface OnStarClickListener {
        void onStarClick(int i);
    }

    public OrderEvaluateScoreView(Context context) {
        super(context);
        m30902a();
    }

    public OrderEvaluateScoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30902a();
    }

    public OrderEvaluateScoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30902a();
    }

    public void setScoreInfo(int i, List<OrderEvaluationScoreInfoEntity> list) {
        this.f43607d = list;
        if (i > 0 && i <= list.size()) {
            CustomerSeekBar customerSeekBar = this.f43605b;
            m30904a(customerSeekBar, i * customerSeekBar.getMinStep(), this.f43605b.getMaxProgress(), true);
        }
    }

    public int getScore() {
        return this.f43606c;
    }

    public void setOnStarClickListener(OnStarClickListener onStarClickListener) {
        this.f43608e = onStarClickListener;
    }

    public void setOnInterceptClickListener(OnInterceptClickListener onInterceptClickListener) {
        this.f43611h = onInterceptClickListener;
    }

    /* renamed from: a */
    private void m30902a() {
        this.f43605b = (CustomerSeekBar) LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_score, this, true).findViewById(R.id.customer_v_rate_seek_bar);
        this.f43604a = (TextView) findViewById(R.id.customer_star_choose_tip);
        this.f43605b.setOnTrackListener(new CustomerSeekBar.OnTrackListener() {
            public void onStartTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2) {
                OrderEvaluateScoreView.this.m30904a(customerSeekBar, i, i2, false);
            }

            public void onTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2) {
                OrderEvaluateScoreView.this.m30904a(customerSeekBar, i, i2, false);
            }

            public void onEndTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2, boolean z) {
                if (i == 0) {
                    i = (int) (((float) i2) * 0.2f);
                    customerSeekBar.setCurrentProgress(i);
                }
                if (z) {
                    OrderEvaluateScoreView.this.m30903a((i / customerSeekBar.getMinStep()) - 1);
                }
                if (OrderEvaluateScoreView.this.f43608e != null) {
                    OrderEvaluateScoreView.this.f43608e.onStarClick((i / customerSeekBar.getMinStep()) - 1);
                }
            }

            public boolean onInterceptTouch() {
                if (OrderEvaluateScoreView.this.f43611h != null) {
                    return OrderEvaluateScoreView.this.f43611h.onInterceptTouch();
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30904a(CustomerSeekBar customerSeekBar, int i, int i2, boolean z) {
        if (z) {
            customerSeekBar.setCurrentProgress(i);
        } else if (i == 0) {
            i = (int) (((float) i2) * 0.2f);
            customerSeekBar.setCurrentProgress(i);
        }
        m30903a((i / customerSeekBar.getMinStep()) - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30903a(int i) {
        OrderEvaluationScoreInfoEntity orderEvaluationScoreInfoEntity;
        if (i != this.f43610g) {
            this.f43610g = i;
            if (!CollectionsUtil.isEmpty(this.f43607d) && i < this.f43607d.size() && (orderEvaluationScoreInfoEntity = this.f43607d.get(i)) != null && !TextUtils.isEmpty(orderEvaluationScoreInfoEntity.desc) && this.f43606c != orderEvaluationScoreInfoEntity.score) {
                this.f43604a.setText(orderEvaluationScoreInfoEntity.desc);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43604a, IToolsService.FontType.MEDIUM);
                this.f43604a.setVisibility(0);
                this.f43606c = orderEvaluationScoreInfoEntity.score;
                if (i < 3) {
                    this.f43604a.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_2_40_666666));
                } else {
                    this.f43604a.setTextColor(SkinUtil.getBrandPrimaryColor());
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f43604a, View.ALPHA, new float[]{0.0f, 1.0f, 1.0f});
                ofFloat.setDuration(400);
                ofFloat.start();
            }
        }
    }
}
