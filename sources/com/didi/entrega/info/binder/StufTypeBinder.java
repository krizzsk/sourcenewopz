package com.didi.entrega.info.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.model.StuffTypeItemModel;
import com.didi.entrega.info.model.StuffTypeModel;
import com.didi.entrega.info.repo.InfoComponentRepo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\u001e\u0010\u001b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001e\u0010 \u001a\u00020\u00162\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00070\"j\b\u0012\u0004\u0012\u00020\u0007`#J\u0010\u0010$\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X.¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006&"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufTypeBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/info/model/StuffTypeModel;", "Lcom/didi/entrega/info/binder/StufTypeBinder$ViewHolder;", "()V", "dataListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/entrega/info/model/StuffTypeItemModel;", "oldItem", "getOldItem", "()Lcom/didi/entrega/info/model/StuffTypeItemModel;", "setOldItem", "(Lcom/didi/entrega/info/model/StuffTypeItemModel;)V", "recyclerAdapter", "Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "setScopeContext", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "setData", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setItemData", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StufTypeBinder.kt */
public final class StufTypeBinder extends ItemBinder<StuffTypeModel, ViewHolder> {

    /* renamed from: a */
    private final NovaRecyclerAdapter f20772a = new NovaRecyclerAdapter();

    /* renamed from: b */
    private ChildDataListManager<StuffTypeItemModel> f20773b;

    /* renamed from: c */
    private ScopeContext f20774c;

    /* renamed from: d */
    private StuffTypeItemModel f20775d;

    public Class<StuffTypeModel> bindDataType() {
        return StuffTypeModel.class;
    }

    public final ScopeContext getScopeContext() {
        return this.f20774c;
    }

    public final void setScopeContext(ScopeContext scopeContext) {
        this.f20774c = scopeContext;
    }

    public final StuffTypeItemModel getOldItem() {
        return this.f20775d;
    }

    public final void setOldItem(StuffTypeItemModel stuffTypeItemModel) {
        this.f20775d = stuffTypeItemModel;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ChildDataListManager<StuffTypeItemModel> childDataListManager = new ChildDataListManager<>(this.f20772a);
        this.f20773b = childDataListManager;
        NovaRecyclerAdapter novaRecyclerAdapter = this.f20772a;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
            childDataListManager = null;
        }
        novaRecyclerAdapter.addDataManager(childDataListManager);
        NovaRecyclerAdapter novaRecyclerAdapter2 = this.f20772a;
        StufTypeItemBinder stufTypeItemBinder = new StufTypeItemBinder();
        stufTypeItemBinder.setScopeContext(getScopeContext());
        stufTypeItemBinder.setListener(new StufTypeBinder$create$1$1(this));
        Unit unit = Unit.INSTANCE;
        novaRecyclerAdapter2.registerBinder(stufTypeItemBinder);
        View inflate = layoutInflater.inflate(R.layout.entrega_info_stuff_type_binder, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…pe_binder, parent, false)");
        return new ViewHolder(this, inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0047, code lost:
        r5 = r5.getTitle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.didi.entrega.info.binder.StufTypeBinder.ViewHolder r4, com.didi.entrega.info.model.StuffTypeModel r5) {
        /*
            r3 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.didi.entrega.info.helper.InfoDataHelper r0 = com.didi.entrega.info.helper.InfoDataHelper.INSTANCE
            java.util.ArrayList r0 = r0.getStuffTypeItemDataList(r5)
            r3.setData(r0)
            android.view.View r4 = r4.itemView
            r0 = 2131432795(0x7f0b155b, float:1.8487358E38)
            android.view.View r0 = r4.findViewById(r0)
            com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView r0 = (com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView) r0
            com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaGridLayoutManager r1 = new com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaGridLayoutManager
            android.content.Context r2 = r0.getContext()
            r1.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r0.setLayoutManager(r1)
            com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter r1 = r3.f20772a
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = (androidx.recyclerview.widget.RecyclerView.Adapter) r1
            r0.setAdapter(r1)
            r0 = 2131435390(0x7f0b1f7e, float:1.849262E38)
            android.view.View r4 = r4.findViewById(r0)
            com.didi.entrega.customer.widget.text.RichTextView r4 = (com.didi.entrega.customer.widget.text.RichTextView) r4
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfoTag r5 = r5.getStuffEntityData()
            java.lang.String r0 = ""
            if (r5 != 0) goto L_0x0047
        L_0x0044:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x0051
        L_0x0047:
            java.lang.String r5 = r5.getTitle()
            if (r5 != 0) goto L_0x004e
            goto L_0x0044
        L_0x004e:
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x0051:
            r4.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.binder.StufTypeBinder.bind(com.didi.entrega.info.binder.StufTypeBinder$ViewHolder, com.didi.entrega.info.model.StuffTypeModel):void");
    }

    public final void setItemData(StuffTypeItemModel stuffTypeItemModel) {
        CommonInfoEntity.CateInfosItem stuffEntityData;
        CommonInfoEntity.CateInfosItem stuffEntityData2;
        CommonInfoEntity.CateInfosItem stuffEntityData3;
        ChildDataListManager<StuffTypeItemModel> childDataListManager = this.f20773b;
        ChildDataListManager<StuffTypeItemModel> childDataListManager2 = null;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
            childDataListManager = null;
        }
        int indexOf = childDataListManager.indexOf(stuffTypeItemModel);
        InfoComponentRepo infoComponentRepo = (InfoComponentRepo) RepoFactory.getRepo(InfoComponentRepo.class);
        if (!(stuffTypeItemModel == null || (stuffEntityData2 = stuffTypeItemModel.getStuffEntityData()) == null)) {
            CommonInfoEntity.CateInfosItem selectedItem = infoComponentRepo.getSelectedItem();
            if (Intrinsics.areEqual((Object) selectedItem == null ? null : selectedItem.getCateID(), (Object) (stuffTypeItemModel == null || (stuffEntityData3 = stuffTypeItemModel.getStuffEntityData()) == null) ? null : stuffEntityData3.getCateID())) {
                infoComponentRepo.setStuffTypeItemValue((CommonInfoEntity.CateInfosItem) null);
            } else {
                infoComponentRepo.setStuffTypeItemValue(stuffEntityData2);
            }
        }
        if (indexOf >= 0) {
            ChildDataListManager<StuffTypeItemModel> childDataListManager3 = this.f20773b;
            if (childDataListManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
                childDataListManager3 = null;
            }
            childDataListManager3.set(indexOf, stuffTypeItemModel);
        }
        StuffTypeItemModel stuffTypeItemModel2 = this.f20775d;
        if (stuffTypeItemModel2 != null) {
            CommonInfoEntity.CateInfosItem stuffEntityData4 = stuffTypeItemModel2.getStuffEntityData();
            if (!Intrinsics.areEqual((Object) stuffEntityData4 == null ? null : stuffEntityData4.getCateID(), (Object) (stuffTypeItemModel == null || (stuffEntityData = stuffTypeItemModel.getStuffEntityData()) == null) ? null : stuffEntityData.getCateID())) {
                ChildDataListManager<StuffTypeItemModel> childDataListManager4 = this.f20773b;
                if (childDataListManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
                    childDataListManager4 = null;
                }
                int indexOf2 = childDataListManager4.indexOf(getOldItem());
                if (indexOf2 >= 0) {
                    CommonInfoEntity.CateInfosItem stuffEntityData5 = stuffTypeItemModel2.getStuffEntityData();
                    if (stuffEntityData5 != null) {
                        stuffEntityData5.setSelected(false);
                    }
                    ChildDataListManager<StuffTypeItemModel> childDataListManager5 = this.f20773b;
                    if (childDataListManager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
                    } else {
                        childDataListManager2 = childDataListManager5;
                    }
                    childDataListManager2.set(indexOf2, stuffTypeItemModel2);
                }
            }
        }
        this.f20775d = stuffTypeItemModel;
    }

    public final void setData(ArrayList<StuffTypeItemModel> arrayList) {
        CommonInfoEntity.CateInfosItem stuffEntityData;
        Intrinsics.checkNotNullParameter(arrayList, "list");
        Iterator<StuffTypeItemModel> it = arrayList.iterator();
        while (it.hasNext()) {
            StuffTypeItemModel next = it.next();
            boolean z = false;
            if (!(next == null || (stuffEntityData = next.getStuffEntityData()) == null)) {
                z = Intrinsics.areEqual((Object) stuffEntityData.getSelected(), (Object) true);
            }
            if (z) {
                this.f20775d = next;
            }
        }
        ChildDataListManager<StuffTypeItemModel> childDataListManager = this.f20773b;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListManager");
            childDataListManager = null;
        }
        childDataListManager.set(arrayList);
    }

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/binder/StufTypeBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/info/model/StuffTypeModel;", "rootView", "Landroid/view/View;", "(Lcom/didi/entrega/info/binder/StufTypeBinder;Landroid/view/View;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StufTypeBinder.kt */
    public final class ViewHolder extends ItemViewHolder<StuffTypeModel> {
        final /* synthetic */ StufTypeBinder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(StufTypeBinder stufTypeBinder, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(stufTypeBinder, "this$0");
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.this$0 = stufTypeBinder;
        }
    }
}
