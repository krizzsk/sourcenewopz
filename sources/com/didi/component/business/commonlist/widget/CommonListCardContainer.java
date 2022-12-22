package com.didi.component.business.commonlist.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.didi.component.business.commonlist.ICommonListInterface;
import com.didi.component.business.commonlist.item.CommonListCardProperty;
import com.didi.component.common.util.UIUtils;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CommonListCardContainer extends NestedScrollView implements ICommonListInterface {

    /* renamed from: a */
    private NestedScrollView f11190a;

    /* renamed from: b */
    private List<CommonListCardProperty> f11191b = new LinkedList();
    protected LinearLayout mCellContainer;
    protected Context mCtx;

    public void addCard(CommonListCardProperty commonListCardProperty, int i) {
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_common_list_ll;
    }

    public void removeCard(int i) {
    }

    public void removeCard(CommonListCardProperty commonListCardProperty) {
    }

    public CommonListCardContainer(Context context) {
        super(context);
        init(context);
    }

    public CommonListCardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CommonListCardContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        this.mCtx = context;
        NestedScrollView nestedScrollView = (NestedScrollView) LayoutInflater.from(context).inflate(getLayout(), this);
        this.f11190a = nestedScrollView;
        this.mCellContainer = (LinearLayout) nestedScrollView.getChildAt(0);
    }

    public void setData(List<CommonListCardProperty> list) {
        if (list != null && !list.isEmpty()) {
            this.mCellContainer.setLayoutTransition((LayoutTransition) null);
            this.mCellContainer.removeAllViews();
            this.f11191b.clear();
            this.f11191b.addAll(list);
            List<View> cardsLayoutParams = setCardsLayoutParams(list);
            for (int i = 0; i < cardsLayoutParams.size(); i++) {
                this.mCellContainer.addView(cardsLayoutParams.get(i));
            }
            UIThreadHandler.post(new Runnable() {
                public void run() {
                    CommonListCardContainer.this.mCellContainer.setLayoutTransition(new LayoutTransition());
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public List<View> setCardsLayoutParams(List<CommonListCardProperty> list) {
        View view;
        ArrayList arrayList = new ArrayList();
        int dip2pxInt = UIUtils.dip2pxInt(this.mCtx, 10.0f);
        for (int i = 0; i < list.size(); i++) {
            CommonListCardProperty commonListCardProperty = list.get(i);
            if (!(commonListCardProperty == null || (view = commonListCardProperty.getView()) == null)) {
                if (view.getLayoutParams() == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.leftMargin = dip2pxInt;
                    layoutParams.rightMargin = dip2pxInt;
                    layoutParams.bottomMargin = dip2pxInt;
                    view.setLayoutParams(layoutParams);
                } else {
                    ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin = dip2pxInt;
                    ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin = dip2pxInt;
                    ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin = dip2pxInt;
                }
                arrayList.add(view);
            }
        }
        return arrayList;
    }

    public void removeCard(View view) {
        this.mCellContainer.removeView(view);
        Iterator<CommonListCardProperty> it = this.f11191b.iterator();
        while (it.hasNext()) {
            if (it.next().getView() == view) {
                it.remove();
                return;
            }
        }
    }

    public View getCardContainer() {
        return this.mCellContainer;
    }

    public List<CommonListCardProperty> getCardPropertyList() {
        return this.f11191b;
    }
}
