package com.didi.component.comp_homecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.didi.component.business.commonlist.item.CommonListCardProperty;
import com.didi.component.business.commonlist.widget.CommonListCardContainer;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomePanelCardContainer extends CommonListCardContainer {

    /* renamed from: a */
    private Logger f12224a = LoggerFactory.getLogger(getClass());

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.home_panel_list_ll;
    }

    public HomePanelCardContainer(Context context) {
        super(context);
    }

    public HomePanelCardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HomePanelCardContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        super.init(context);
    }

    public void setData(List<CommonListCardProperty> list) {
        super.setData(list);
    }

    /* access modifiers changed from: protected */
    public List<View> setCardsLayoutParams(List<CommonListCardProperty> list) {
        View view;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            CommonListCardProperty commonListCardProperty = list.get(i);
            if (!(commonListCardProperty == null || (view = commonListCardProperty.getView()) == null)) {
                if (view.getParent() != null && (view.getParent() instanceof CardView)) {
                    ((CardView) view.getParent()).removeAllViews();
                }
                CardView cardView = (CardView) LayoutInflater.from(this.mCtx).inflate(R.layout.home_panel_card_container, this.mCellContainer, false);
                cardView.addView(view, new ViewGroup.LayoutParams(-1, -2));
                arrayList.add(cardView);
            }
        }
        return arrayList;
    }
}
