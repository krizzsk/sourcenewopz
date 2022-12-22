package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.gridlayout.widget.GridLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.topgun.model.HomeFeedbackButtonModel;
import com.didi.soda.home.topgun.widget.HomeFeedbackGridLayout;
import com.taxis99.R;
import java.util.List;

public class HomeFeedbackGridLayout extends GridLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnClickItemListener f43119a;

    /* renamed from: b */
    private int f43120b;

    /* renamed from: c */
    private Context f43121c;

    public interface OnClickItemListener {
        void onItemClick(HomeFeedbackButtonModel homeFeedbackButtonModel);
    }

    public HomeFeedbackGridLayout(Context context) {
        super(context);
        m30512a(context);
    }

    public HomeFeedbackGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30512a(context);
    }

    public HomeFeedbackGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30512a(context);
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.f43119a = onClickItemListener;
    }

    public void setFeedbackItem(List<HomeFeedbackButtonModel> list) {
        GridLayout.LayoutParams layoutParams;
        removeAllViews();
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GridItem a = m30510a(list.get(i));
                int i2 = i / 2;
                int i3 = i % 2;
                if (size >= 2) {
                    layoutParams = new GridLayout.LayoutParams(GridLayout.spec(i2, 1.0f), GridLayout.spec(i3, 1.0f));
                    layoutParams.width = 0;
                } else {
                    layoutParams = new GridLayout.LayoutParams(GridLayout.spec(i2), GridLayout.spec(i3));
                    layoutParams.width = (this.f43120b - (DisplayUtils.dip2px(this.f43121c, 40.0f) + DisplayUtils.dip2px(this.f43121c, (float) 9))) / 2;
                }
                layoutParams.height = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_60);
                if (i2 > 0) {
                    layoutParams.topMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18);
                }
                if (i3 > 0) {
                    layoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20);
                }
                addView(a.itemView, layoutParams);
            }
        }
    }

    /* renamed from: a */
    private GridItem m30510a(HomeFeedbackButtonModel homeFeedbackButtonModel) {
        return new GridItem(this, homeFeedbackButtonModel);
    }

    /* renamed from: a */
    private void m30512a(Context context) {
        this.f43121c = context;
        this.f43120b = CustomerSystemUtil.getScreenWidth(context);
    }

    public class GridItem {
        View itemView;
        TextView textView;

        GridItem(ViewGroup viewGroup, HomeFeedbackButtonModel homeFeedbackButtonModel) {
            View inflate = LayoutInflater.from(HomeFeedbackGridLayout.this.getContext()).inflate(R.layout.customer_item_home_feedback_grid, viewGroup, false);
            this.itemView = inflate;
            TextView textView2 = (TextView) inflate.findViewById(R.id.customer_tv_home_feedback_grid_item);
            this.textView = textView2;
            textView2.setText(homeFeedbackButtonModel.getText());
            this.itemView.setOnClickListener(new View.OnClickListener(homeFeedbackButtonModel) {
                public final /* synthetic */ HomeFeedbackButtonModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    HomeFeedbackGridLayout.GridItem.this.lambda$new$0$HomeFeedbackGridLayout$GridItem(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$HomeFeedbackGridLayout$GridItem(HomeFeedbackButtonModel homeFeedbackButtonModel, View view) {
            if (HomeFeedbackGridLayout.this.f43119a != null) {
                HomeFeedbackGridLayout.this.f43119a.onItemClick(homeFeedbackButtonModel);
            }
        }
    }
}
