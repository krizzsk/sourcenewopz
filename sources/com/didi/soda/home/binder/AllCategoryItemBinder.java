package com.didi.soda.home.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.home.binder.AllCategoryItemBinder;
import com.didi.soda.home.binder.model.AllCategoryItemModel;
import com.didi.soda.home.manager.AllCategoryLogicRepo;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001c\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004R\u00020\u00000\u0001:\u0003 !\"B\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0004R\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J\u001e\u0010\u0019\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\f\u0010\u001f\u001a\u00060\u0002R\u00020\u0000H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/home/binder/AllCategoryItemBinder;", "Lcom/didi/soda/customer/base/binder/logic/CustomerLogicItemBinder;", "Lcom/didi/soda/home/binder/AllCategoryItemBinder$AllCategoryItemBinderLogic;", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "Lcom/didi/soda/home/binder/AllCategoryItemBinder$ViewHolder;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "colCount", "", "componentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "(Lcom/didi/app/nova/skeleton/ScopeContext;ILcom/didi/soda/customer/base/binder/ComponentLogicUnit;)V", "fromPage", "", "getFromPage", "()Ljava/lang/String;", "setFromPage", "(Ljava/lang/String;)V", "mColCount", "bind", "", "viewHolder", "model", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getColumnCount", "onCreateBinderLogic", "AllCategoryItemBinderLogic", "AllCategoryItemBinderLogicImpl", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AllCategoryItemBinder.kt */
public final class AllCategoryItemBinder extends CustomerLogicItemBinder<AllCategoryItemBinderLogic, AllCategoryItemModel, ViewHolder> {

    /* renamed from: a */
    private int f42533a = 2;

    /* renamed from: b */
    private String f42534b;

    public Class<AllCategoryItemModel> bindDataType() {
        return AllCategoryItemModel.class;
    }

    public final String getFromPage() {
        return this.f42534b;
    }

    public final void setFromPage(String str) {
        this.f42534b = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllCategoryItemBinder(ScopeContext scopeContext, int i, ComponentLogicUnit componentLogicUnit) {
        super(componentLogicUnit);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(componentLogicUnit, "componentLogicUnit");
        this.f42533a = i;
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/home/binder/AllCategoryItemBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "itemView", "Landroid/view/View;", "(Lcom/didi/soda/home/binder/AllCategoryItemBinder;Landroid/view/View;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "mCategoryImageView", "Landroid/widget/ImageView;", "getMCategoryImageView", "()Landroid/widget/ImageView;", "mCategoryNameView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getMCategoryNameView", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "mRooView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMRooView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AllCategoryItemBinder.kt */
    public final class ViewHolder extends ItemViewHolder<AllCategoryItemModel> {
        private final Context context;
        private final ImageView mCategoryImageView;
        private final CustomerAppCompatTextView mCategoryNameView;
        private final ConstraintLayout mRooView;
        final /* synthetic */ AllCategoryItemBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(AllCategoryItemBinder allCategoryItemBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(allCategoryItemBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = allCategoryItemBinder;
            View findViewById = view.findViewById(R.id.customer_tv_home_filter_category_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<Cu…ome_filter_category_name)");
            this.mCategoryNameView = (CustomerAppCompatTextView) findViewById;
            View findViewById2 = view.findViewById(R.id.customer_tv_home_filter_category_img);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById<Im…home_filter_category_img)");
            this.mCategoryImageView = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.root_view);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById<Co…ntLayout>(R.id.root_view)");
            this.mRooView = (ConstraintLayout) findViewById3;
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            this.context = context2;
        }

        public final CustomerAppCompatTextView getMCategoryNameView() {
            return this.mCategoryNameView;
        }

        public final ImageView getMCategoryImageView() {
            return this.mCategoryImageView;
        }

        public final ConstraintLayout getMRooView() {
            return this.mRooView;
        }

        public final Context getContext() {
            return this.context;
        }
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_item_all_category_view, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater?.inflate(R.layo…y_view, container, false)");
        return new ViewHolder(this, inflate);
    }

    public void bind(ViewHolder viewHolder, AllCategoryItemModel allCategoryItemModel) {
        CategoryEntity category;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (allCategoryItemModel != null && (category = allCategoryItemModel.getCategory()) != null) {
            viewHolder.getMCategoryNameView().setText(category.getTitle());
            FlyImageLoader.loadImageUnspecified(viewHolder.getContext(), category.getImg()).placeholder((int) R.drawable.customer_icon_category_round_logo).error((int) R.drawable.customer_icon_category_round_logo).fitCenter().transform(new RoundedCornersTransformation(viewHolder.getContext(), DisplayUtils.dip2px(viewHolder.getContext(), 14.0f), 0, RoundedCornersTransformation.CornerType.BOTTOM_RIGHT, true)).into(viewHolder.getMCategoryImageView());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(allCategoryItemModel, viewHolder) {
                public final /* synthetic */ AllCategoryItemModel f$1;
                public final /* synthetic */ AllCategoryItemBinder.ViewHolder f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    AllCategoryItemBinder.m29985a(AllCategoryItemBinder.this, this.f$1, this.f$2, view);
                }
            });
            HomeOmegaHelper.getInstance().trackFilterCategoryRealSw(category, viewHolder.getAdapterPosition(), allCategoryItemModel.getRecId(), getFromPage());
            Integer selected = category.getSelected();
            if (selected != null && selected.intValue() == 1) {
                viewHolder.getMRooView().setBackground(viewHolder.getContext().getDrawable(R.drawable.customer_shape_bg_all_item_selected_card));
                viewHolder.getMCategoryNameView().setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
                viewHolder.getMCategoryNameView().setFontType(IToolsService.FontType.BOLD);
                return;
            }
            viewHolder.getMRooView().setBackground(viewHolder.getContext().getDrawable(R.drawable.customer_selector_home_filter_bg));
            viewHolder.getMCategoryNameView().setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
            viewHolder.getMCategoryNameView().setFontType(IToolsService.FontType.MEDIUM);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29985a(AllCategoryItemBinder allCategoryItemBinder, AllCategoryItemModel allCategoryItemModel, ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(allCategoryItemBinder, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        ((AllCategoryItemBinderLogic) allCategoryItemBinder.getBinderLogic()).onCategoryItemClick(allCategoryItemModel, viewHolder.getAdapterPosition());
    }

    public int getColumnCount() {
        return this.f42533a;
    }

    public AllCategoryItemBinderLogic onCreateBinderLogic() {
        return new AllCategoryItemBinderLogicImpl(this);
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b¦\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/home/binder/AllCategoryItemBinder$AllCategoryItemBinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/BinderLogic;", "Lcom/didi/soda/home/manager/AllCategoryLogicRepo;", "(Lcom/didi/soda/home/binder/AllCategoryItemBinder;)V", "onCategoryItemClick", "", "rvItemModel", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "position", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AllCategoryItemBinder.kt */
    public abstract class AllCategoryItemBinderLogic extends BinderLogic<AllCategoryLogicRepo> {
        final /* synthetic */ AllCategoryItemBinder this$0;

        public abstract void onCategoryItemClick(AllCategoryItemModel allCategoryItemModel, int i);

        public AllCategoryItemBinderLogic(AllCategoryItemBinder allCategoryItemBinder) {
            Intrinsics.checkNotNullParameter(allCategoryItemBinder, "this$0");
            this.this$0 = allCategoryItemBinder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/home/binder/AllCategoryItemBinder$AllCategoryItemBinderLogicImpl;", "Lcom/didi/soda/home/binder/AllCategoryItemBinder$AllCategoryItemBinderLogic;", "Lcom/didi/soda/home/binder/AllCategoryItemBinder;", "(Lcom/didi/soda/home/binder/AllCategoryItemBinder;)V", "bindLogicRepoType", "Ljava/lang/Class;", "Lcom/didi/soda/home/manager/AllCategoryLogicRepo;", "onCategoryItemClick", "", "rvModel", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "position", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AllCategoryItemBinder.kt */
    public final class AllCategoryItemBinderLogicImpl extends AllCategoryItemBinderLogic {
        final /* synthetic */ AllCategoryItemBinder this$0;

        public Class<AllCategoryLogicRepo> bindLogicRepoType() {
            return AllCategoryLogicRepo.class;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AllCategoryItemBinderLogicImpl(AllCategoryItemBinder allCategoryItemBinder) {
            super(allCategoryItemBinder);
            Intrinsics.checkNotNullParameter(allCategoryItemBinder, "this$0");
            this.this$0 = allCategoryItemBinder;
        }

        public void onCategoryItemClick(AllCategoryItemModel allCategoryItemModel, int i) {
            Intrinsics.checkNotNullParameter(allCategoryItemModel, "rvModel");
            ((AllCategoryLogicRepo) getLogicRepo()).setValue(AllCategoryLogicRepo.Companion.buildCategoryClickedModel(allCategoryItemModel, i));
        }
    }
}
