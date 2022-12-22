package com.didi.soda.business.component.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.business.component.category.CategoryPanelBinder;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0002H&J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0002H&¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/CategoryPanelBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/business/model/BusinessCategoryRvModel;", "Lcom/didi/soda/business/component/category/CategoryPanelBinder$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onCategoryItemClick", "index", "", "onCategoryItemExposure", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CategoryPanelBinder.kt */
public abstract class CategoryPanelBinder extends ItemBinder<BusinessCategoryRvModel, ViewHolder> {
    public Class<BusinessCategoryRvModel> bindDataType() {
        return BusinessCategoryRvModel.class;
    }

    public abstract void onCategoryItemClick(int i, BusinessCategoryRvModel businessCategoryRvModel);

    public abstract void onCategoryItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel);

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_item_business_category, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_category, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, BusinessCategoryRvModel businessCategoryRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(businessCategoryRvModel, "item");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(this, businessCategoryRvModel) {
            public final /* synthetic */ CategoryPanelBinder f$1;
            public final /* synthetic */ BusinessCategoryRvModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                CategoryPanelBinder.m46807bind$lambda1(CategoryPanelBinder.ViewHolder.this, this.f$1, this.f$2, view);
            }
        });
        onCategoryItemExposure(viewHolder.getAdapterPosition(), businessCategoryRvModel);
        TextView numView = viewHolder.getNumView();
        StringBuilder sb = new StringBuilder();
        sb.append(VersionRange.LEFT_OPEN);
        sb.append(businessCategoryRvModel.mItemCount);
        sb.append(VersionRange.RIGHT_OPEN);
        numView.setText(sb.toString());
        viewHolder.getClassifyName().setText(businessCategoryRvModel.mCategoryName);
        viewHolder.getDivider().setVisibility(viewHolder.getAdapterPosition() == 0 ? 8 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1  reason: not valid java name */
    public static final void m46807bind$lambda1(ViewHolder viewHolder, CategoryPanelBinder categoryPanelBinder, BusinessCategoryRvModel businessCategoryRvModel, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(categoryPanelBinder, "this$0");
        Intrinsics.checkNotNullParameter(businessCategoryRvModel, "$item");
        viewHolder.itemView.post(new Runnable(viewHolder, businessCategoryRvModel) {
            public final /* synthetic */ CategoryPanelBinder.ViewHolder f$1;
            public final /* synthetic */ BusinessCategoryRvModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CategoryPanelBinder.m46808bind$lambda1$lambda0(CategoryPanelBinder.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m46808bind$lambda1$lambda0(CategoryPanelBinder categoryPanelBinder, ViewHolder viewHolder, BusinessCategoryRvModel businessCategoryRvModel) {
        Intrinsics.checkNotNullParameter(categoryPanelBinder, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(businessCategoryRvModel, "$item");
        categoryPanelBinder.onCategoryItemClick(viewHolder.getAdapterPosition(), businessCategoryRvModel);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/business/component/category/CategoryPanelBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/business/model/BusinessCategoryRvModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "classifyName", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getClassifyName", "()Landroid/widget/TextView;", "divider", "getDivider", "()Landroid/view/View;", "numView", "getNumView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CategoryPanelBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<BusinessCategoryRvModel> {
        private final TextView classifyName;
        private final View divider;
        private final TextView numView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.classifyName = (TextView) view.findViewById(R.id.customer_tv_business_classify_name);
            this.numView = (TextView) view.findViewById(R.id.customer_tv_business_classify_num);
            this.divider = view.findViewById(R.id.customer_v_business_category_divider);
        }

        public final TextView getClassifyName() {
            return this.classifyName;
        }

        public final TextView getNumView() {
            return this.numView;
        }

        public final View getDivider() {
            return this.divider;
        }
    }
}
