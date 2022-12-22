package com.didi.soda.search.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.base.rxdux.SkeletonStore;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.search.component.suggestion.SearchSuggestionActionCreator;
import com.didi.soda.search.component.suggestion.SearchSuggestionViewModel;
import com.didi.soda.search.helper.SearchLogHelper;
import com.didi.soda.search.repo.SearchHeaderRepo;
import com.didi.soda.search.repo.SearchWordModel;
import com.google.gson.JsonObject;
import com.taxis99.R;

public class SearchSuggestionBinder extends ItemBinder<SearchSuggestionViewModel, ViewHolder> {

    /* renamed from: a */
    private static final String f43678a = "AbSearchSuggestionBinder";

    /* renamed from: b */
    private ScopeContext f43679b;

    public SearchSuggestionBinder(ScopeContext scopeContext) {
        this.f43679b = scopeContext;
    }

    public SearchSuggestionBinder(ScopeContext scopeContext, ItemDecorator itemDecorator) {
        this(scopeContext);
        addDecorator(itemDecorator);
    }

    public void bind(final ViewHolder viewHolder, final SearchSuggestionViewModel searchSuggestionViewModel) {
        viewHolder.mTvSuggestion.setText(searchSuggestionViewModel.word);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchLogHelper.info(SearchSuggestionBinder.f43678a, "on search sug word clicked");
                SkeletonStore.getStore().dispatch(SearchSuggestionActionCreator.clearSuggestion());
                SearchWordModel searchWordModel = new SearchWordModel(searchSuggestionViewModel.word);
                searchWordModel.mSearchFrom = SearchWordModel.SearchFrom.SUGGESTION;
                searchWordModel.mIndex = viewHolder.getLayoutPosition();
                searchWordModel.mSugId = searchSuggestionViewModel.sugId;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(ParamConst.INPUT_WORD, searchSuggestionViewModel.input);
                jsonObject.addProperty(ParamConst.SUG_CK_WORD, searchSuggestionViewModel.word);
                jsonObject.addProperty(ParamConst.SUG_CK_INDEX, (Number) Integer.valueOf(searchWordModel.mIndex));
                jsonObject.addProperty(ParamConst.SUG_WORD_TYPE, (Number) 0);
                jsonObject.addProperty(ParamConst.SUG_ID_DATA, (Number) 0);
                searchWordModel.mSugCkJson = jsonObject.toString();
                SearchSuggestionBinder.this.m30998a(searchWordModel);
                OmegaTracker.Builder.create(EventConst.Search.SUGGESTION_CK).addEventParam(ParamConst.INPUT_WORD, searchSuggestionViewModel.input).addEventParam(ParamConst.SUG_CK_WORD, searchSuggestionViewModel.word).addEventParam(ParamConst.SUG_REG_ID, searchSuggestionViewModel.sugId).addEventParam("index", Integer.valueOf(searchSuggestionViewModel.sugIndex)).addEventParam(ParamConst.SUG_TRACE_ID, searchSuggestionViewModel.traceId).build().track();
                OmegaTracker.Builder.create(EventConst.Search.SUGGESTION_ASSOCIATIONAL_CK).addEventParam("name", searchSuggestionViewModel.word).build().track();
            }
        });
    }

    public Class<SearchSuggestionViewModel> bindDataType() {
        return SearchSuggestionViewModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_item_suggestion_ab, viewGroup, false));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30998a(SearchWordModel searchWordModel) {
        if (!StringUtils.isEmpty(searchWordModel.mSearchTag)) {
            SearchLogHelper.info("suggstion", "setSearchHeaderTag, " + searchWordModel.toString());
            ((SearchHeaderRepo) RepoFactory.getRepo(SearchHeaderRepo.class)).setValue(searchWordModel);
        }
    }

    class ViewHolder extends ItemViewHolder<SearchSuggestionViewModel> {
        IconTextView mImgLeft;
        TextView mTvSuggestion;

        ViewHolder(View view) {
            super(view);
            this.mImgLeft = (IconTextView) view.findViewById(R.id.customer_iv_search_suggestion_icon);
            this.mTvSuggestion = (TextView) view.findViewById(R.id.customer_tv_search_suggestion_text);
        }
    }
}
