package com.didi.soda.bill.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.bill.widgets.CustomerCartTipsPercentItem;
import com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.jadux.Store;
import com.didi.soda.order.component.tips.TipActionCreator;
import com.didi.soda.order.component.tips.TipState;
import com.taxis99.R;
import java.util.Map;
import p242io.reactivex.functions.Consumer;

public class CustomerCartTipsGroupView extends ViewGroup {

    /* renamed from: d */
    private static final int f39277d = ResourceHelper.getDimensionPixelSize(R.dimen.customer_16px);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Store<TipState> f39278a;

    /* renamed from: b */
    private Context f39279b;

    /* renamed from: c */
    private int f39280c = 3;

    public interface OnselectTipListener {
        void onSelectTip(int i);
    }

    public CustomerCartTipsGroupView(Context context) {
        super(context);
        m27822a(context);
    }

    public CustomerCartTipsGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27822a(context);
    }

    public CustomerCartTipsGroupView setStore(Store<TipState> store) {
        this.f39278a = store;
        store.subscribe(new Consumer<TipState>() {
            public void accept(TipState tipState) throws Exception {
                CustomerCartTipsGroupView.this.m27824a(tipState);
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th) throws Exception {
                th.printStackTrace();
            }
        });
        return this;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount;
        if (z && (childCount = getChildCount()) != 0) {
            int dip2px = DisplayUtils.dip2px(this.f39279b, 24.0f);
            int measuredWidth = getChildAt(0).getMeasuredWidth();
            int measuredHeight = getChildAt(0).getMeasuredHeight();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                int i6 = this.f39280c;
                int i7 = f39277d;
                childAt.layout((i5 % i6) * (measuredWidth + i7), (i5 / i6) * (measuredHeight + dip2px), (((i5 % i6) + 1) * measuredWidth) + ((i5 % i6) * i7), (((i5 / i6) + 1) * measuredHeight) + ((i5 / i6) * dip2px));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        measureChildren(m27826c(i), i2);
        setMeasuredDimension(m27820a(i), m27825b(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27824a(TipState tipState) {
        if (tipState != null && tipState.mConfig != null && tipState.mConfig.tipFeeConfig != null) {
            C134123 r0 = new OnselectTipListener() {
                public void onSelectTip(int i) {
                    CustomerCartTipsGroupView.this.f39278a.dispatch(TipActionCreator.selectTip(i));
                }
            };
            TipsConfigEntity tipsConfigEntity = tipState.mConfig;
            for (int i = 0; i < tipsConfigEntity.tipFeeConfig.size(); i++) {
                if (getChildAt(i) == null) {
                    CustomerCartTipsPercentItem customerCartTipsPercentItem = new CustomerCartTipsPercentItem(this.f39279b, i);
                    customerCartTipsPercentItem.setTips(new CustomerCartTipsPercentItem.TipFeeViewModel(tipsConfigEntity.tipFeeConfig.get(i).longValue(), tipsConfigEntity.tipFeeType, tipState.mCurrency, tipState.mOrderPrice));
                    customerCartTipsPercentItem.setOnSelectTipListener(r0);
                    customerCartTipsPercentItem.setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtils.dip2px(this.f39279b, 30.0f)));
                    addView(customerCartTipsPercentItem);
                }
            }
            for (Map.Entry next : tipState.mSelectStatus.entrySet()) {
                getChildAt(((Integer) next.getKey()).intValue()).setSelected(((Boolean) next.getValue()).booleanValue());
            }
        }
    }

    /* renamed from: a */
    private int m27820a(int i) {
        return View.MeasureSpec.getSize(i);
    }

    /* renamed from: b */
    private int m27825b(int i) {
        int childCount = getChildCount();
        int i2 = 0;
        if (childCount == 0) {
            return 0;
        }
        int dip2px = DisplayUtils.dip2px(this.f39279b, 24.0f);
        int measuredHeight = childCount > 0 ? getChildAt(0).getMeasuredHeight() : 0;
        int i3 = this.f39280c;
        int i4 = childCount / i3;
        if (childCount % i3 > 0) {
            i2 = 1;
        }
        int i5 = i4 + i2;
        return (measuredHeight * i5) + (dip2px * (i5 - 1));
    }

    /* renamed from: c */
    private int m27826c(int i) {
        int size = View.MeasureSpec.getSize(i);
        int i2 = this.f39280c;
        return View.MeasureSpec.makeMeasureSpec((size - ((i2 - 1) * f39277d)) / i2, 1073741824);
    }

    /* renamed from: a */
    private void m27822a(Context context) {
        this.f39279b = context;
    }
}
