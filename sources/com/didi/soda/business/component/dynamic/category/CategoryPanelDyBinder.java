package com.didi.soda.business.component.dynamic.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.business.component.dynamic.category.CategoryPanelDyBinder;
import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0002H&J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0002H&¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/CategoryPanelDyBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/business/model/BusinessCategoryMenuRvModel;", "Lcom/didi/soda/business/component/dynamic/category/CategoryPanelDyBinder$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createCategoryMenuSpanString", "Landroid/text/SpannableStringBuilder;", "ctx", "Landroid/content/Context;", "onCategoryItemClick", "index", "", "onCategoryItemExposure", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CategoryPanelDyBinder.kt */
public abstract class CategoryPanelDyBinder extends ItemBinder<BusinessCategoryMenuRvModel, ViewHolder> {
    public Class<BusinessCategoryMenuRvModel> bindDataType() {
        return BusinessCategoryMenuRvModel.class;
    }

    public abstract void onCategoryItemClick(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel);

    public abstract void onCategoryItemExposure(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel);

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_item_business_dy_category, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_category, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, BusinessCategoryMenuRvModel businessCategoryMenuRvModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(businessCategoryMenuRvModel, "item");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(this, businessCategoryMenuRvModel) {
            public final /* synthetic */ CategoryPanelDyBinder f$1;
            public final /* synthetic */ BusinessCategoryMenuRvModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                CategoryPanelDyBinder.m46816bind$lambda1(CategoryPanelDyBinder.ViewHolder.this, this.f$1, this.f$2, view);
            }
        });
        onCategoryItemExposure(viewHolder.getAdapterPosition(), businessCategoryMenuRvModel);
        CustomerAppCompatTextView classifyName = viewHolder.getClassifyName();
        Context context = viewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
        classifyName.setText(createCategoryMenuSpanString(businessCategoryMenuRvModel, context));
        int i = 0;
        viewHolder.getDivider().setVisibility(viewHolder.getAdapterPosition() == 0 ? 8 : 0);
        View ivCategorySelect = viewHolder.getIvCategorySelect();
        if (!businessCategoryMenuRvModel.isSelected) {
            i = 4;
        }
        ivCategorySelect.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1  reason: not valid java name */
    public static final void m46816bind$lambda1(ViewHolder viewHolder, CategoryPanelDyBinder categoryPanelDyBinder, BusinessCategoryMenuRvModel businessCategoryMenuRvModel, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(categoryPanelDyBinder, "this$0");
        Intrinsics.checkNotNullParameter(businessCategoryMenuRvModel, "$item");
        viewHolder.itemView.post(new Runnable(viewHolder, businessCategoryMenuRvModel) {
            public final /* synthetic */ CategoryPanelDyBinder.ViewHolder f$1;
            public final /* synthetic */ BusinessCategoryMenuRvModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CategoryPanelDyBinder.m46817bind$lambda1$lambda0(CategoryPanelDyBinder.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m46817bind$lambda1$lambda0(CategoryPanelDyBinder categoryPanelDyBinder, ViewHolder viewHolder, BusinessCategoryMenuRvModel businessCategoryMenuRvModel) {
        Intrinsics.checkNotNullParameter(categoryPanelDyBinder, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(businessCategoryMenuRvModel, "$item");
        categoryPanelDyBinder.onCategoryItemClick(viewHolder.getAdapterPosition(), businessCategoryMenuRvModel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if ((r1.length() == 0) == true) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.text.SpannableStringBuilder createCategoryMenuSpanString(com.didi.soda.business.model.BusinessCategoryMenuRvModel r8, android.content.Context r9) {
        /*
            r7 = this;
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>()
            java.lang.String r1 = r8.mCategoryName
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x000d
        L_0x000b:
            r2 = 0
            goto L_0x001a
        L_0x000d:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0017
            r1 = 1
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            if (r1 != r2) goto L_0x000b
        L_0x001a:
            if (r2 == 0) goto L_0x001d
            return r0
        L_0x001d:
            r1 = 1098907648(0x41800000, float:16.0)
            float r9 = com.didi.app.nova.support.util.DisplayUtils.sp2px(r9, r1)
            int r9 = (int) r9
            android.text.SpannableString r1 = new android.text.SpannableString
            java.lang.String r2 = r8.mCategoryName
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.<init>(r2)
            android.text.style.AbsoluteSizeSpan r2 = new android.text.style.AbsoluteSizeSpan
            r2.<init>(r9)
            int r4 = r1.length()
            r5 = 33
            r1.setSpan(r2, r3, r4, r5)
            android.text.style.ForegroundColorSpan r2 = new android.text.style.ForegroundColorSpan
            boolean r4 = r8.isSelected
            r6 = 2131101459(0x7f060713, float:1.7815328E38)
            if (r4 == 0) goto L_0x0048
            r4 = 2131101459(0x7f060713, float:1.7815328E38)
            goto L_0x004b
        L_0x0048:
            r4 = 2131101488(0x7f060730, float:1.7815387E38)
        L_0x004b:
            int r4 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r4)
            r2.<init>(r4)
            int r4 = r1.length()
            r1.setSpan(r2, r3, r4, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.append(r1)
            java.lang.String r1 = " "
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.append(r1)
            android.text.SpannableString r1 = new android.text.SpannableString
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r4 = 40
            r2.append(r4)
            int r4 = r8.mItemCount
            r2.append(r4)
            r4 = 41
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.<init>(r2)
            android.text.style.AbsoluteSizeSpan r2 = new android.text.style.AbsoluteSizeSpan
            r2.<init>(r9)
            int r9 = r1.length()
            r1.setSpan(r2, r3, r9, r5)
            android.text.style.ForegroundColorSpan r9 = new android.text.style.ForegroundColorSpan
            boolean r8 = r8.isSelected
            if (r8 == 0) goto L_0x0097
            goto L_0x009a
        L_0x0097:
            r6 = 2131101582(0x7f06078e, float:1.7815578E38)
        L_0x009a:
            int r8 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r6)
            r9.<init>(r8)
            int r8 = r1.length()
            r1.setSpan(r9, r3, r8, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.append(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.component.dynamic.category.CategoryPanelDyBinder.createCategoryMenuSpanString(com.didi.soda.business.model.BusinessCategoryMenuRvModel, android.content.Context):android.text.SpannableStringBuilder");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \b*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/category/CategoryPanelDyBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/business/model/BusinessCategoryMenuRvModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "classifyName", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "kotlin.jvm.PlatformType", "getClassifyName", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "divider", "getDivider", "()Landroid/view/View;", "ivCategorySelect", "getIvCategorySelect", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CategoryPanelDyBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<BusinessCategoryMenuRvModel> {
        private final CustomerAppCompatTextView classifyName;
        private final View divider;
        private final View ivCategorySelect;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.classifyName = (CustomerAppCompatTextView) view.findViewById(R.id.customer_tv_business_classify_name);
            this.divider = view.findViewById(R.id.customer_v_business_category_divider);
            this.ivCategorySelect = view.findViewById(R.id.customer_iv_category_item_select);
        }

        public final CustomerAppCompatTextView getClassifyName() {
            return this.classifyName;
        }

        public final View getDivider() {
            return this.divider;
        }

        public final View getIvCategorySelect() {
            return this.ivCategorySelect;
        }
    }
}
