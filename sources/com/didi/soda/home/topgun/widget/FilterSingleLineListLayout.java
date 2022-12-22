package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.model.FilterUIModel;
import com.didi.soda.home.topgun.widget.FilterSingleLineListLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0011J\u001c\u0010\u0018\u001a\u00060\u000bR\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u0014\u0010\u001b\u001a\u00020\u00112\n\u0010\u001c\u001a\u00060\u000bR\u00020\u0000H\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u001c\u0010\u001e\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010 \u001a\u00020\rJ$\u0010!\u001a\u00020\u00112\u001c\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u0012R\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\u000bR\u00020\u00000\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0004\u0018\u0001`\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u000bR\u00020\u00000\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/FilterSingleLineListLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mItemList", "", "Lcom/didi/soda/home/topgun/widget/FilterSingleLineListLayout$ListItem;", "mNotAllowEmpty", "", "mOnClickFilterItemListener", "Lkotlin/Function2;", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "", "Lcom/didi/soda/home/topgun/component/filter/module/OnFilterItemClickListener;", "uIItemList", "", "getUIItemList", "()Ljava/util/List;", "confirm", "getFilterItemView", "index", "itemRvModel", "itemSelectChanged", "listItem", "reset", "setFilterItem", "filterItemRvModelList", "notAllowEmpty", "setOnClickFilterItemListener", "listener", "ListItem", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterSingleLineListLayout.kt */
public final class FilterSingleLineListLayout extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> f43062a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final List<ListItem> f43063b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f43064c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilterSingleLineListLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilterSingleLineListLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterSingleLineListLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterSingleLineListLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43063b = new ArrayList();
        setOrientation(1);
    }

    public final void setOnClickFilterItemListener(Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "listener");
        this.f43062a = function2;
    }

    public final void setFilterItem(List<? extends FilterModel.FilterItemRvModel> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "filterItemRvModelList");
        this.f43064c = z;
        this.f43063b.clear();
        removeAllViews();
        int i = 0;
        for (FilterModel.FilterItemRvModel a : list) {
            int i2 = i + 1;
            ListItem a2 = m30465a(i, a);
            this.f43063b.add(a2);
            View itemView = a2.getItemView();
            itemView.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(itemView.getContext(), 68.0f)));
            addView(itemView);
            i = i2;
        }
    }

    public final List<ListItem> getUIItemList() {
        return this.f43063b;
    }

    public final void confirm() {
        for (ListItem next : this.f43063b) {
            FilterModel.FilterItemRvModel itemRvModel = next.getItemRvModel();
            if (itemRvModel != null) {
                itemRvModel.mIsSelected = next.isSelected();
            }
        }
    }

    public final void reset() {
        for (ListItem next : this.f43063b) {
            FilterModel.FilterItemRvModel itemRvModel = next.getItemRvModel();
            next.setViewSelected(itemRvModel == null ? false : itemRvModel.mIsDefault);
        }
    }

    /* renamed from: a */
    private final ListItem m30465a(int i, FilterModel.FilterItemRvModel filterItemRvModel) {
        return new ListItem(this, this, i, filterItemRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30466a(ListItem listItem) {
        Function2<? super FilterModel.FilterItemRvModel, ? super Boolean, Unit> function2;
        for (ListItem next : this.f43063b) {
            if (next != listItem) {
                if (!next.isMultipleChoice()) {
                    next.setViewSelected(false);
                } else if (!next.isMultipleChoice()) {
                    next.setViewSelected(false);
                }
            }
        }
        FilterModel.FilterItemRvModel itemRvModel = listItem.getItemRvModel();
        if (itemRvModel != null && (function2 = this.f43062a) != null) {
            function2.invoke(itemRvModel, Boolean.valueOf(listItem.isSelected()));
        }
    }

    @Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0016R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/FilterSingleLineListLayout$ListItem;", "Lcom/didi/soda/home/topgun/model/FilterUIModel;", "parent", "Landroid/view/ViewGroup;", "index", "", "itemRvModel", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;", "(Lcom/didi/soda/home/topgun/widget/FilterSingleLineListLayout;Landroid/view/ViewGroup;ILcom/didi/soda/home/topgun/model/FilterModel$FilterItemRvModel;)V", "divider", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "setDivider", "(Landroid/view/View;)V", "iconView", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "getIconView", "()Lcom/didi/soda/customer/widget/text/IconRichTextView;", "setIconView", "(Lcom/didi/soda/customer/widget/text/IconRichTextView;)V", "isFirst", "", "()Z", "setFirst", "(Z)V", "itemView", "getItemView", "setItemView", "selectedIcon", "getSelectedIcon", "setSelectedIcon", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "setViewSelected", "", "isSelected", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilterSingleLineListLayout.kt */
    public final class ListItem extends FilterUIModel {
        private View divider;
        private IconRichTextView iconView;
        private boolean isFirst;
        private View itemView;
        private View selectedIcon;
        private TextView textView;
        final /* synthetic */ FilterSingleLineListLayout this$0;

        public ListItem(FilterSingleLineListLayout filterSingleLineListLayout, ViewGroup viewGroup, int i, FilterModel.FilterItemRvModel filterItemRvModel) {
            Intrinsics.checkNotNullParameter(filterSingleLineListLayout, "this$0");
            Intrinsics.checkNotNullParameter(filterItemRvModel, "itemRvModel");
            this.this$0 = filterSingleLineListLayout;
            setItemRvModel(filterItemRvModel);
            int i2 = 0;
            this.isFirst = i == 0;
            View inflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.customer_item_home_filter_recommend, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          …recommend, parent, false)");
            this.itemView = inflate;
            View findViewById = inflate.findViewById(R.id.customer_home_filter_divider);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…omer_home_filter_divider)");
            this.divider = findViewById;
            findViewById.setVisibility(this.isFirst ? 8 : i2);
            View findViewById2 = this.itemView.findViewById(R.id.customer_home_filter_recommend_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…me_filter_recommend_icon)");
            IconRichTextView iconRichTextView = (IconRichTextView) findViewById2;
            this.iconView = iconRichTextView;
            String str = filterItemRvModel.mIcon;
            iconRichTextView.setText(str == null ? "" : str);
            View findViewById3 = this.itemView.findViewById(R.id.customer_home_filter_recommend_text);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.…me_filter_recommend_text)");
            TextView textView2 = (TextView) findViewById3;
            this.textView = textView2;
            textView2.setText(filterItemRvModel.mName);
            View findViewById4 = this.itemView.findViewById(R.id.customer_home_filter_recommend_selected);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.…ilter_recommend_selected)");
            this.selectedIcon = findViewById4;
            setMultipleChoice(filterItemRvModel.mIsMultipleChoice);
            setViewSelected(filterItemRvModel.mIsSelected);
            this.itemView.setOnClickListener(new View.OnClickListener(this.this$0) {
                public final /* synthetic */ FilterSingleLineListLayout f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    FilterSingleLineListLayout.ListItem.m46989_init_$lambda2(FilterSingleLineListLayout.ListItem.this, this.f$1, view);
                }
            });
        }

        public final View getItemView() {
            return this.itemView;
        }

        public final void setItemView(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.itemView = view;
        }

        public final TextView getTextView() {
            return this.textView;
        }

        public final void setTextView(TextView textView2) {
            Intrinsics.checkNotNullParameter(textView2, "<set-?>");
            this.textView = textView2;
        }

        public final IconRichTextView getIconView() {
            return this.iconView;
        }

        public final void setIconView(IconRichTextView iconRichTextView) {
            Intrinsics.checkNotNullParameter(iconRichTextView, "<set-?>");
            this.iconView = iconRichTextView;
        }

        public final View getSelectedIcon() {
            return this.selectedIcon;
        }

        public final void setSelectedIcon(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.selectedIcon = view;
        }

        public final View getDivider() {
            return this.divider;
        }

        public final void setDivider(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.divider = view;
        }

        public final boolean isFirst() {
            return this.isFirst;
        }

        public final void setFirst(boolean z) {
            this.isFirst = z;
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-2  reason: not valid java name */
        public static final void m46989_init_$lambda2(ListItem listItem, FilterSingleLineListLayout filterSingleLineListLayout, View view) {
            Function2 access$getMOnClickFilterItemListener$p;
            Intrinsics.checkNotNullParameter(listItem, "this$0");
            Intrinsics.checkNotNullParameter(filterSingleLineListLayout, "this$1");
            if (listItem.isSelected() && filterSingleLineListLayout.f43064c) {
                Collection arrayList = new ArrayList();
                for (Object next : filterSingleLineListLayout.f43063b) {
                    if (((ListItem) next).isSelected()) {
                        arrayList.add(next);
                    }
                }
                if (((List) arrayList).size() == 1) {
                    FilterModel.FilterItemRvModel itemRvModel = listItem.getItemRvModel();
                    if (itemRvModel != null && (access$getMOnClickFilterItemListener$p = filterSingleLineListLayout.f43062a) != null) {
                        access$getMOnClickFilterItemListener$p.invoke(itemRvModel, Boolean.valueOf(listItem.isSelected()));
                        return;
                    }
                    return;
                }
            }
            listItem.setViewSelected(!listItem.isSelected());
            filterSingleLineListLayout.m30466a(listItem);
        }

        public final void setViewSelected(boolean z) {
            setSelected(z);
            this.itemView.setSelected(z);
            if (z) {
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.textView, IToolsService.FontType.BOLD);
                this.selectedIcon.setVisibility(0);
                return;
            }
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.textView, IToolsService.FontType.MEDIUM);
            this.selectedIcon.setVisibility(4);
        }
    }
}
