package com.didi.soda.search.component.panel;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.animation.transitions.compat.SearchSharedElementCompat;
import com.didi.soda.customer.foundation.rpc.entity.SearchShopsTagEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.search.component.panel.Contract;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.didi.soda.search.repo.SearchHotWordsModel;
import com.didi.soda.search.repo.SearchTagRepo;
import com.didi.soda.search.storage.HistoryTag;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SearchEntrancePanelView extends Contract.AbsSearchEntrancePanelView {

    /* renamed from: a */
    private View f43713a;
    @BindView(18466)
    RFIconView mDeleteHistoryIv;
    @BindView(18197)
    View mSearchHistoryParentLayout;
    @BindView(17986)
    NovaFlowLayout mSearchHistoryTagFl;
    @BindView(18198)
    View mSearchRecommendParentLayout;
    @BindView(18028)
    NovaFlowLayout mSearchRecommendTagFl;
    @BindView(18075)
    NovaFlowLayout mSearchShopTagFl;
    @BindView(18201)
    View mSearchShopsParentLayout;

    interface Type {
        public static final int HISTORY = 1;
        public static final int RECOMMEND = 2;
        public static final int SHOPS = 3;
    }

    public void setRecommendTagsRow(int i) {
        this.mSearchRecommendTagFl.setMaxRows(i);
        this.mSearchHistoryTagFl.setMaxRows(i);
        this.mSearchShopTagFl.setMaxRows(i);
    }

    public void setPanelLayoutVisibility(int i) {
        this.f43713a.setVisibility(i);
        if (i == 0) {
            ((Contract.AbsSearchEntrancePanelPresenter) getPresenter()).updateSearchHistory((HistoryTag) null);
        }
    }

    public void setRecommendTags(List<SearchHotWordsModel> list) {
        m31035a(2, list, this.mSearchRecommendTagFl);
    }

    public void setHistoryTags(List<String> list) {
        m31041b(1, list, this.mSearchHistoryTagFl);
    }

    public void setShopTags(List<SearchShopsTagEntity> list) {
        m31041b(3, list, this.mSearchShopTagFl);
    }

    public void doFirstInAnimation() {
        ViewPropertyAnimator viewPropertyAnimator;
        ViewPropertyAnimator viewPropertyAnimator2;
        if (SearchSharedElementCompat.supportSharedElementTransition(getScopeContext())) {
            int dip2px = DisplayUtils.dip2px(getContext(), 50.0f);
            ViewPropertyAnimator viewPropertyAnimator3 = null;
            if (this.mSearchHistoryParentLayout.getVisibility() == 0) {
                this.mSearchHistoryParentLayout.setAlpha(0.0f);
                this.mSearchHistoryParentLayout.setTranslationY((float) dip2px);
                viewPropertyAnimator = this.mSearchHistoryParentLayout.animate().alpha(1.0f).translationY(0.0f).setInterpolator(CustomerInterpolator.newInstance()).setDuration(300);
            } else {
                viewPropertyAnimator = null;
            }
            if (this.mSearchRecommendParentLayout.getVisibility() == 0) {
                this.mSearchRecommendParentLayout.setAlpha(0.0f);
                this.mSearchRecommendParentLayout.setTranslationY((float) dip2px);
                viewPropertyAnimator2 = this.mSearchRecommendParentLayout.animate().alpha(1.0f).translationY(0.0f).setInterpolator(CustomerInterpolator.newInstance()).setDuration(300).setStartDelay(100);
            } else {
                viewPropertyAnimator2 = null;
            }
            if (this.mSearchShopsParentLayout.getVisibility() == 0) {
                this.mSearchShopsParentLayout.setAlpha(0.0f);
                this.mSearchShopsParentLayout.setTranslationY((float) dip2px);
                viewPropertyAnimator3 = this.mSearchShopsParentLayout.animate().alpha(1.0f).translationY(0.0f).setInterpolator(CustomerInterpolator.newInstance()).setDuration(300).setStartDelay(150);
            }
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.start();
            }
            if (viewPropertyAnimator2 != null) {
                viewPropertyAnimator2.start();
            }
            if (viewPropertyAnimator3 != null) {
                viewPropertyAnimator3.start();
            }
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_component_search_ab_panel, viewGroup, true);
        this.f43713a = inflate;
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mDeleteHistoryIv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsSearchEntrancePanelPresenter) SearchEntrancePanelView.this.getPresenter()).onDeleteHistoryClicked();
            }
        });
    }

    /* renamed from: a */
    private void m31035a(int i, List<SearchHotWordsModel> list, NovaFlowLayout novaFlowLayout) {
        m31038a((List) list, i);
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            m31036a(i, list, (List<View>) arrayList);
            novaFlowLayout.addView(arrayList);
            novaFlowLayout.post(new Runnable(novaFlowLayout, list) {
                public final /* synthetic */ NovaFlowLayout f$1;
                public final /* synthetic */ List f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SearchEntrancePanelView.this.m31037a(this.f$1, this.f$2);
                }
            });
            novaFlowLayout.setClickListener(new NovaFlowLayout.NovaFlowLayoutClickListener(list) {
                public final /* synthetic */ List f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(int i, Object obj, Object obj2) {
                    SearchEntrancePanelView.this.m31039a(this.f$1, i, (View) obj, (View) obj2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31037a(NovaFlowLayout novaFlowLayout, List list) {
        ((Contract.AbsSearchEntrancePanelPresenter) getPresenter()).onRecommendTagsShow(novaFlowLayout.getVisibleViewCount(), list);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31039a(List list, int i, View view, View view2) {
        TextView textView;
        SearchHotWordsModel searchHotWordsModel;
        if (view != null && (textView = (TextView) view.findViewById(R.id.tv_popular)) != null && !TextUtils.isEmpty(textView.getText()) && i <= list.size() && (searchHotWordsModel = (SearchHotWordsModel) list.get(i)) != null) {
            SearchTagRepo searchTagRepo = (SearchTagRepo) RepoFactory.getRepo(SearchTagRepo.class);
            SearchNewOmegaHelper.getInstance().trackRecommendWordClick(textView.getText().toString(), searchTagRepo.getRecId(), i);
            SearchNewOmegaHelper.getInstance().trackSearchHotWordCK(searchHotWordsModel, searchTagRepo.getRecId());
            if (Objects.equals(searchHotWordsModel.getType(), 2)) {
                ((Contract.AbsSearchEntrancePanelPresenter) getPresenter()).onSearchHotWordsClicked(searchHotWordsModel);
            } else {
                ((Contract.AbsSearchEntrancePanelPresenter) getPresenter()).onSearchRecommendTagClicked(textView.getText().toString(), i);
            }
        }
    }

    /* renamed from: b */
    private void m31041b(final int i, List list, final NovaFlowLayout novaFlowLayout) {
        m31038a(list, i);
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            final ArrayList<String> arrayList2 = new ArrayList<>();
            if (i == 3) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((SearchShopsTagEntity) it.next()).mShopName);
                }
            } else {
                arrayList2.addAll(list);
            }
            for (String a : arrayList2) {
                View a2 = m31033a(a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            novaFlowLayout.addView(arrayList);
            novaFlowLayout.post(new Runnable() {
                public void run() {
                    int visibleViewCount = novaFlowLayout.getVisibleViewCount();
                    if (i == 1) {
                        ((Contract.AbsSearchEntrancePanelPresenter) SearchEntrancePanelView.this.getPresenter()).onHistoryTagsShow(visibleViewCount, arrayList2);
                    }
                }
            });
            novaFlowLayout.setClickListener(new NovaFlowLayout.NovaFlowLayoutClickListener(i, list) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ List f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(int i, Object obj, Object obj2) {
                    SearchEntrancePanelView.this.m31034a(this.f$1, this.f$2, i, (View) obj, (View) obj2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31034a(int i, List list, int i2, View view, View view2) {
        TextView textView;
        if (view != null && (textView = (TextView) view.findViewById(R.id.tv_popular)) != null && !TextUtils.isEmpty(textView.getText())) {
            String trim = textView.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                if (i == 1) {
                    ((Contract.AbsSearchEntrancePanelPresenter) getPresenter()).onSearchHistoryTagClicked(trim, i2);
                }
                if (i == 3 && i2 < list.size()) {
                    ((Contract.AbsSearchEntrancePanelPresenter) getPresenter()).onSearchShopTagClicked(((SearchShopsTagEntity) list.get(i2)).mShopId, ((SearchShopsTagEntity) list.get(i2)).mShopName, i2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m31036a(int i, List<SearchHotWordsModel> list, List<View> list2) {
        for (SearchHotWordsModel a : list) {
            View a2 = m31032a(a);
            if (a2 != null) {
                list2.add(a2);
            }
        }
    }

    /* renamed from: a */
    private View m31032a(SearchHotWordsModel searchHotWordsModel) {
        View view = null;
        if (searchHotWordsModel != null && !TextUtils.isEmpty(searchHotWordsModel.getWord())) {
            view = View.inflate(getContext(), R.layout.customer_component_search_ab_panel_recommend_item, (ViewGroup) null);
            TextView textView = (TextView) view.findViewById(R.id.tv_popular);
            int b = m31040b(searchHotWordsModel);
            if (b > 0) {
                textView.setMaxWidth(b);
            }
            textView.setText(searchHotWordsModel.getWord());
            if (!TextUtils.isEmpty(searchHotWordsModel.getImg()) || Objects.equals(searchHotWordsModel.getType(), 2)) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_popular);
                imageView.setVisibility(0);
                FlyImageLoader.loadImage1x1(getContext(), searchHotWordsModel.getImg()).placeholder((int) R.drawable.customer_search_hot_sug).dontAnimate().centerCrop().error((int) R.drawable.customer_search_hot_sug).into(imageView);
            }
            View findViewById = view.findViewById(R.id.ll_container);
            if (searchHotWordsModel.getMBgColorIntArray().length > 0) {
                findViewById.setBackground(SkinUtil.getGradientBg(searchHotWordsModel.getMBgColorIntArray(), (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18), GradientDrawable.Orientation.LEFT_RIGHT));
            } else {
                findViewById.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.customer_skin_selector_search_tag_ab_bg));
            }
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_94)));
        }
        return view;
    }

    /* renamed from: b */
    private int m31040b(SearchHotWordsModel searchHotWordsModel) {
        if (Objects.equals(searchHotWordsModel.getType(), 2)) {
            return (int) Math.floor((((((double) ((DisplayUtils.getScreenWidth(getContext()) - ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_64)) - ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20))) / 2.0d) - ((double) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_48))) - ((double) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_36))) - ((double) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20)));
        }
        return -1;
    }

    /* renamed from: a */
    private View m31033a(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        View inflate = View.inflate(getContext(), R.layout.customer_component_search_ab_panel_recommend_item, (ViewGroup) null);
        ((CustomerAppCompatTextView) inflate.findViewById(R.id.tv_popular)).setText(str);
        inflate.findViewById(R.id.ll_container).setBackgroundDrawable(getDrawable(R.drawable.customer_skin_selector_search_tag_ab_bg));
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_94)));
        return inflate;
    }

    /* renamed from: a */
    private void m31038a(List list, int i) {
        RFIconView rFIconView;
        View view;
        boolean z = true;
        View view2 = null;
        if (i != 1) {
            if (i == 2) {
                view = this.mSearchRecommendParentLayout;
            } else if (i != 3) {
                rFIconView = null;
            } else {
                view = this.mSearchShopsParentLayout;
            }
            view2 = view;
            rFIconView = null;
        } else {
            view2 = this.mSearchHistoryParentLayout;
            rFIconView = this.mDeleteHistoryIv;
        }
        int i2 = 0;
        if (!(list == null || list.size() == 0)) {
            z = false;
        }
        if (view2 != null) {
            view2.setVisibility(z ? 8 : 0);
        }
        if (rFIconView != null) {
            if (z) {
                i2 = 8;
            }
            rFIconView.setVisibility(i2);
        }
    }
}
