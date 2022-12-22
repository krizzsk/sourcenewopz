package com.didi.soda.home.topgun.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.topgun.model.HomeSearchHotWordsModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u001a2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/adapter/HomeSearchViewFlpperAdapter;", "Landroid/widget/BaseAdapter;", "()V", "data", "Ljava/util/ArrayList;", "Lcom/didi/soda/home/topgun/model/HomeSearchHotWordsModel;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lcom/didi/soda/home/topgun/adapter/HomeSearchViewFlpperAdapter$OnItemClickListener;", "getOnItemClickListener", "()Lcom/didi/soda/home/topgun/adapter/HomeSearchViewFlpperAdapter$OnItemClickListener;", "setOnItemClickListener", "(Lcom/didi/soda/home/topgun/adapter/HomeSearchViewFlpperAdapter$OnItemClickListener;)V", "getCount", "", "getData", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setData", "", "list", "OnItemClickListener", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeSearchViewFlpperAdapter.kt */
public final class HomeSearchViewFlpperAdapter extends BaseAdapter {

    /* renamed from: a */
    private final ArrayList<HomeSearchHotWordsModel> f42747a = new ArrayList<>();

    /* renamed from: b */
    private OnItemClickListener f42748b;

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/adapter/HomeSearchViewFlpperAdapter$OnItemClickListener;", "", "onItemClickListener", "", "model", "Lcom/didi/soda/home/topgun/model/HomeSearchHotWordsModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeSearchViewFlpperAdapter.kt */
    public interface OnItemClickListener {
        void onItemClickListener(HomeSearchHotWordsModel homeSearchHotWordsModel);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.f42748b;
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f42748b = onItemClickListener;
    }

    public final void setData(ArrayList<HomeSearchHotWordsModel> arrayList) {
        Collection collection = arrayList;
        if (collection == null || collection.isEmpty()) {
            this.f42747a.clear();
            ArrayList<HomeSearchHotWordsModel> arrayList2 = this.f42747a;
            HomeSearchHotWordsModel homeSearchHotWordsModel = new HomeSearchHotWordsModel();
            homeSearchHotWordsModel.setWord(ResourceHelper.getString(R.string.customer_global_home_search_hit));
            homeSearchHotWordsModel.setType(1);
            Unit unit = Unit.INSTANCE;
            arrayList2.add(homeSearchHotWordsModel);
        } else {
            this.f42747a.clear();
            notifyDataSetChanged();
            this.f42747a.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public final ArrayList<HomeSearchHotWordsModel> getData() {
        return this.f42747a;
    }

    public int getCount() {
        ArrayList<HomeSearchHotWordsModel> arrayList = this.f42747a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public HomeSearchHotWordsModel getItem(int i) {
        ArrayList<HomeSearchHotWordsModel> arrayList = this.f42747a;
        HomeSearchHotWordsModel homeSearchHotWordsModel = arrayList == null ? null : arrayList.get(i);
        return homeSearchHotWordsModel == null ? new HomeSearchHotWordsModel() : homeSearchHotWordsModel;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        CharSequence charSequence;
        int i2 = 0;
        HomeSearchHotWordsModel homeSearchHotWordsModel = null;
        if (view == null) {
            Context context = viewGroup == null ? null : viewGroup.getContext();
            if (context == null) {
                context = GlobalContext.getContext();
            }
            view = LayoutInflater.from(context).inflate(R.layout.customer_item_home_header_search_hint, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view, "from(parent?.context\n   …arch_hint, parent, false)");
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            Object tag = view.getTag();
            if (tag != null) {
                viewHolder = (ViewHolder) tag;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.home.topgun.adapter.HomeSearchViewFlpperAdapter.ViewHolder");
            }
        }
        ArrayList<HomeSearchHotWordsModel> arrayList = this.f42747a;
        if (arrayList != null) {
            i2 = arrayList.size();
        }
        if (i >= i2) {
            view.setVisibility(8);
            return view;
        }
        ArrayList<HomeSearchHotWordsModel> arrayList2 = this.f42747a;
        if (arrayList2 != null) {
            homeSearchHotWordsModel = arrayList2.get(i);
        }
        if (homeSearchHotWordsModel == null) {
            HomeSearchViewFlpperAdapter homeSearchViewFlpperAdapter = this;
            view.setVisibility(8);
            return view;
        }
        view.setOnClickListener(new View.OnClickListener(homeSearchHotWordsModel) {
            public final /* synthetic */ HomeSearchHotWordsModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeSearchViewFlpperAdapter.m30181a(HomeSearchViewFlpperAdapter.this, this.f$1, view);
            }
        });
        TextView tv_item = viewHolder.getTv_item();
        String word = homeSearchHotWordsModel.getWord();
        if (word == null) {
            charSequence = ResourceHelper.getString(R.string.customer_global_home_search_hit);
        } else {
            charSequence = word;
        }
        tv_item.setText(charSequence);
        return view;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30181a(HomeSearchViewFlpperAdapter homeSearchViewFlpperAdapter, HomeSearchHotWordsModel homeSearchHotWordsModel, View view) {
        Intrinsics.checkNotNullParameter(homeSearchViewFlpperAdapter, "this$0");
        Intrinsics.checkNotNullParameter(homeSearchHotWordsModel, "$model");
        OnItemClickListener onItemClickListener = homeSearchViewFlpperAdapter.getOnItemClickListener();
        if (onItemClickListener != null) {
            onItemClickListener.onItemClickListener(homeSearchHotWordsModel);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/adapter/HomeSearchViewFlpperAdapter$ViewHolder;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "tv_item", "Landroid/widget/TextView;", "getTv_item", "()Landroid/widget/TextView;", "setTv_item", "(Landroid/widget/TextView;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeSearchViewFlpperAdapter.kt */
    public static final class ViewHolder {
        private TextView tv_item;

        public ViewHolder(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.customer_tv_home_search_hint);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.c…omer_tv_home_search_hint)");
            this.tv_item = (TextView) findViewById;
        }

        public final TextView getTv_item() {
            return this.tv_item;
        }

        public final void setTv_item(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tv_item = textView;
        }
    }
}
