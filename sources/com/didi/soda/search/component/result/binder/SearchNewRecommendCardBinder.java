package com.didi.soda.search.component.result.binder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.StaggerItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.search.binder.model.SearchRecommendCardModel;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.didi.soda.search.repo.SearchHeaderRepo;
import com.didi.soda.search.repo.SearchWordModel;
import com.taxis99.R;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchNewRecommendCardBinder extends ItemBinder<SearchRecommendCardModel, ViewHolder> {
    public SearchNewRecommendCardBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public void bind(ViewHolder viewHolder, SearchRecommendCardModel searchRecommendCardModel) {
        viewHolder.mCardTitleTv.setText(searchRecommendCardModel.mCardTitle);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mCardTitleTv, IToolsService.FontType.MEDIUM);
        viewHolder.mCardContainerLayout.removeAllViews();
        if (!CollectionsUtil.isEmpty(searchRecommendCardModel.mCardWordList)) {
            for (int i = 0; i < searchRecommendCardModel.mCardWordList.size(); i++) {
                viewHolder.mCardContainerLayout.addView(m31075a(viewHolder.itemView.getContext(), searchRecommendCardModel, i));
            }
        }
        m31076a(searchRecommendCardModel);
    }

    public Class<SearchRecommendCardModel> bindDataType() {
        return SearchRecommendCardModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_search_new_recommend_card, viewGroup, false));
    }

    /* renamed from: a */
    private TextView m31075a(Context context, final SearchRecommendCardModel searchRecommendCardModel, final int i) {
        CheckedTextView checkedTextView = new CheckedTextView(context);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(checkedTextView, IToolsService.FontType.LIGHT);
        checkedTextView.setText(searchRecommendCardModel.mCardWordList.get(i).word);
        checkedTextView.setMaxLines(1);
        checkedTextView.setTextColor(context.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        checkedTextView.setGravity(17);
        checkedTextView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.customer_28px));
        checkedTextView.setSingleLine();
        checkedTextView.setEllipsize(TextUtils.TruncateAt.END);
        checkedTextView.setBackgroundDrawable(context.getDrawable(R.drawable.customer_skin_selector_search_tag_ab_bg));
        checkedTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, DisplayUtils.dip2px(context, 34.0f)));
        int dip2px = DisplayUtils.dip2px(context, 10.0f);
        checkedTextView.setPadding(dip2px, 0, dip2px, 0);
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchNewRecommendCardBinder.this.m31077a(searchRecommendCardModel, i);
            }
        });
        return checkedTextView;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31077a(SearchRecommendCardModel searchRecommendCardModel, int i) {
        SearchWordModel searchWordModel = new SearchWordModel(searchRecommendCardModel.mCardWordList.get(i).word);
        searchWordModel.mSessionID = searchRecommendCardModel.mSessionId;
        searchWordModel.mSessionIter = searchRecommendCardModel.mSessionIter;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ParamConst.WORD, searchRecommendCardModel.mCardWordList.get(i).word);
            jSONObject.put(ParamConst.SEARCH_CK_INDEX, i);
            searchWordModel.mQueryCkJson = jSONObject.toString();
        } catch (JSONException unused) {
        }
        ((SearchHeaderRepo) RepoFactory.getRepo(SearchHeaderRepo.class)).setValue(searchWordModel);
    }

    /* renamed from: a */
    private void m31076a(SearchRecommendCardModel searchRecommendCardModel) {
        SearchNewOmegaHelper.getInstance().itemExposureForRecommendCard(searchRecommendCardModel);
    }

    class ViewHolder extends StaggerItemViewHolder<SearchRecommendCardModel> {
        /* access modifiers changed from: private */
        public NovaFlowLayout mCardContainerLayout;
        /* access modifiers changed from: private */
        public TextView mCardTitleTv;

        public ViewHolder(View view) {
            super(view);
            this.mCardTitleTv = (TextView) view.findViewById(R.id.customer_tv_search_recommend_card_title);
            this.mCardContainerLayout = (NovaFlowLayout) view.findViewById(R.id.customer_tv_search_recommend_card_container);
        }
    }
}
