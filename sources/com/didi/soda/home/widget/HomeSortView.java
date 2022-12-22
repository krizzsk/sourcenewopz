package com.didi.soda.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.home.component.feed.listener.HomeSortClickListener;
import com.taxis99.R;

public class HomeSortView extends LinearLayout {

    /* renamed from: a */
    HomeSortClickListener f43297a;
    @BindView(24518)
    View mPriceLine;
    @BindView(24021)
    TextView mPriceTv;
    @BindView(22700)
    View mPriceView;
    @BindView(24519)
    View mRecommendLine;
    @BindView(24022)
    TextView mRecommendTv;
    @BindView(22701)
    View mRecommendView;
    @BindView(24520)
    View mTimeLine;
    @BindView(24023)
    TextView mTimeTv;
    @BindView(22702)
    View mTimeView;

    public HomeSortView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HomeSortView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomeSortView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30623a(context);
    }

    public void setOnSortListener(HomeSortClickListener homeSortClickListener) {
        this.f43297a = homeSortClickListener;
    }

    public void show() {
        HomeSortClickListener homeSortClickListener = this.f43297a;
        HomeSortClickListener.Type currentSortType = homeSortClickListener != null ? homeSortClickListener.getCurrentSortType() : HomeSortClickListener.Type.RECOMMEND;
        m30622a();
        if (currentSortType == HomeSortClickListener.Type.RECOMMEND) {
            this.mRecommendLine.setVisibility(0);
            this.mRecommendView.setSelected(true);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mRecommendTv, IToolsService.FontType.MEDIUM);
        } else if (currentSortType == HomeSortClickListener.Type.PRICE) {
            this.mPriceLine.setVisibility(0);
            this.mPriceView.setSelected(true);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPriceTv, IToolsService.FontType.MEDIUM);
        } else if (currentSortType == HomeSortClickListener.Type.TIME) {
            this.mTimeLine.setVisibility(0);
            this.mTimeView.setSelected(true);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mTimeTv, IToolsService.FontType.MEDIUM);
        }
    }

    /* renamed from: a */
    private void m30623a(Context context) {
        ButterKnife.bind(LayoutInflater.from(context).inflate(R.layout.customer_widget_home_sort, this, true));
        this.mRecommendView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HomeSortView.this.f43297a != null) {
                    HomeSortView.this.f43297a.onSortClick(HomeSortClickListener.Type.RECOMMEND);
                    HomeSortView.this.show();
                }
            }
        });
        this.mPriceView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HomeSortView.this.f43297a != null) {
                    HomeSortView.this.f43297a.onSortClick(HomeSortClickListener.Type.PRICE);
                    HomeSortView.this.show();
                }
            }
        });
        this.mTimeView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HomeSortView.this.f43297a != null) {
                    HomeSortView.this.f43297a.onSortClick(HomeSortClickListener.Type.TIME);
                    HomeSortView.this.show();
                }
            }
        });
        m30622a();
    }

    /* renamed from: a */
    private void m30622a() {
        this.mRecommendLine.setVisibility(8);
        this.mPriceLine.setVisibility(8);
        this.mTimeLine.setVisibility(8);
        this.mRecommendView.setSelected(false);
        this.mPriceView.setSelected(false);
        this.mTimeView.setSelected(false);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mRecommendTv, IToolsService.FontType.NORMAL);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPriceTv, IToolsService.FontType.NORMAL);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mTimeTv, IToolsService.FontType.NORMAL);
    }
}
