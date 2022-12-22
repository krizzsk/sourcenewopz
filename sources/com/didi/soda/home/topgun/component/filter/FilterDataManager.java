package com.didi.soda.home.topgun.component.filter;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.model.FilterComponentState;
import com.didi.soda.home.topgun.model.FilterItemParam;
import com.didi.soda.home.topgun.model.FilterItemState;
import com.didi.soda.home.topgun.model.FilterModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 72\u00020\u0001:\u000278B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bJ\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\u0003J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"2\b\b\u0002\u0010#\u001a\u00020$J\b\u0010%\u001a\u0004\u0018\u00010\u0015J\u001a\u0010&\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0002J\u0006\u0010+\u001a\u00020\u0011J\u0016\u0010,\u001a\u00020\u00112\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\"J\u0006\u0010/\u001a\u00020\u0011J\u0010\u00100\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015J\u0016\u00101\u001a\u00020\u00112\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0002J\u001c\u00103\u001a\u00020\u00112\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\u0004\u0018\u0001`\u0012J\u0016\u00105\u001a\u00020\u00112\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\u0004\u0018\u0001`\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00069"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "", "scene", "", "(I)V", "mCateId", "", "getMCateId", "()Ljava/lang/String;", "setMCateId", "(Ljava/lang/String;)V", "mCurrentStatu", "Ljava/util/HashMap;", "Lcom/didi/soda/home/topgun/model/FilterComponentState;", "Lkotlin/collections/HashMap;", "mFilterDataChangedListener", "Lkotlin/Function0;", "", "Lcom/didi/soda/home/topgun/component/filter/OnFilterDataChangedListener;", "mModelList", "", "Lcom/didi/soda/home/topgun/model/FilterModel;", "getScene", "()I", "generateGroupOutParams", "Ljava/util/ArrayList;", "Lcom/didi/soda/home/topgun/model/FilterItemParam;", "Lkotlin/collections/ArrayList;", "filterModel", "generateOutParams", "generateStatu", "getFilterGroupDataById", "id", "getFilterModelListWithoutMain", "", "withAnim", "", "getMainFilterModel", "handleFilterHeaderLine", "isOriginalFilterData", "mergeComponentState", "componentModel", "Lcom/didi/soda/home/topgun/model/FilterModel$FilterComponentModel;", "notifyFilterDataChanged", "parseFilterEntity", "filterList", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/FilterEntity;", "resetAllFilter", "saveFilterGroupChange", "saveOriginalData", "apiModelList", "setFilterDataChangedListener", "listener", "syncFilterModelListWithStatu", "modelList", "Companion", "FilterDataManagerPool", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterDataManager.kt */
public final class FilterDataManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final int f42838a;

    /* renamed from: b */
    private final List<FilterModel> f42839b;

    /* renamed from: c */
    private final HashMap<Integer, FilterComponentState> f42840c;

    /* renamed from: d */
    private Function0<Unit> f42841d;

    /* renamed from: e */
    private String f42842e;

    public /* synthetic */ FilterDataManager(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private FilterDataManager(@FilterDataManagerScene int i) {
        this.f42838a = i;
        this.f42839b = new ArrayList();
        this.f42840c = new HashMap<>();
    }

    public final int getScene() {
        return this.f42838a;
    }

    public final String getMCateId() {
        return this.f42842e;
    }

    public final void setMCateId(String str) {
        this.f42842e = str;
    }

    public final void parseFilterEntity(List<? extends FilterEntity> list) {
        if (list != null) {
            List<FilterModel> convert = FilterEntity.convert(list, this.f42838a);
            Intrinsics.checkNotNullExpressionValue(convert, "apiModelList");
            m30313a((List<? extends FilterModel>) convert);
            m30309a();
            notifyFilterDataChanged();
            int i = this.f42838a;
            if (i == 1) {
                HomeOmegaHelper.getInstance().filterResultSw(convert, 1);
            } else if (i == 3) {
                HomeOmegaHelper.getInstance().filterResultSw(convert, 3);
            } else {
                HomeOmegaHelper.getInstance().filterResultSw(convert, 2);
            }
        }
    }

    /* renamed from: a */
    private final void m30313a(List<? extends FilterModel> list) {
        this.f42839b.clear();
        this.f42839b.addAll(list);
    }

    /* renamed from: a */
    private final void m30309a() {
        this.f42840c.clear();
        for (FilterModel filterModel : this.f42839b) {
            for (FilterModel.FilterComponentModel next : filterModel.mFilterComponent) {
                if (!this.f42840c.containsKey(Integer.valueOf(next.mType))) {
                    Integer valueOf = Integer.valueOf(next.mType);
                    FilterComponentState.Companion companion = FilterComponentState.Companion;
                    Intrinsics.checkNotNullExpressionValue(next, "componentModel");
                    this.f42840c.put(valueOf, companion.convert(next));
                }
            }
        }
    }

    public final FilterModel getFilterGroupDataById(int i) {
        if (i < this.f42839b.size()) {
            return this.f42839b.get(i);
        }
        return null;
    }

    public final ArrayList<FilterItemParam> generateOutParams() {
        ArrayList<FilterItemParam> arrayList = new ArrayList<>();
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : this.f42840c.entrySet()) {
            if (!((FilterComponentState) entry.getValue()).getFilterItemStates().isEmpty()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            int intValue = ((Number) entry2.getKey()).intValue();
            Map filterItemStates = ((FilterComponentState) entry2.getValue()).getFilterItemStates();
            Collection arrayList2 = new ArrayList(filterItemStates.size());
            for (Map.Entry value : filterItemStates.entrySet()) {
                arrayList2.add((FilterItemState) value.getValue());
            }
            for (FilterItemState filterItemState : (List) arrayList2) {
                String itemId = filterItemState.getItemId();
                if (itemId == null) {
                    itemId = "";
                }
                arrayList.add(new FilterItemParam(intValue, itemId, filterItemState.getSourceType(), filterItemState.getActivityId()));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.didi.soda.home.topgun.model.FilterItemParam> generateGroupOutParams(com.didi.soda.home.topgun.model.FilterModel r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r8 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.util.List<com.didi.soda.home.topgun.model.FilterModel$FilterComponentModel> r8 = r8.mFilterComponent
            if (r8 != 0) goto L_0x000e
            r8 = 0
            goto L_0x003a
        L_0x000e:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r8 = r8.iterator()
        L_0x0021:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r8.next()
            com.didi.soda.home.topgun.model.FilterModel$FilterComponentModel r2 = (com.didi.soda.home.topgun.model.FilterModel.FilterComponentModel) r2
            int r2 = r2.mType
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.add(r2)
            goto L_0x0021
        L_0x0037:
            r8 = r1
            java.util.List r8 = (java.util.List) r8
        L_0x003a:
            if (r8 != 0) goto L_0x0040
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0040:
            java.util.HashMap<java.lang.Integer, com.didi.soda.home.topgun.model.FilterComponentState> r1 = r7.f42840c
            java.util.Map r1 = (java.util.Map) r1
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0053:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x007b
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getValue()
            com.didi.soda.home.topgun.model.FilterComponentState r4 = (com.didi.soda.home.topgun.model.FilterComponentState) r4
            java.util.HashMap r4 = r4.getFilterItemStates()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0053
            java.lang.Object r4 = r3.getKey()
            java.lang.Object r3 = r3.getValue()
            r2.put(r4, r3)
            goto L_0x0053
        L_0x007b:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0088:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00b4
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r8.contains(r4)
            if (r4 == 0) goto L_0x0088
            java.lang.Object r4 = r3.getKey()
            java.lang.Object r3 = r3.getValue()
            r1.put(r4, r3)
            goto L_0x0088
        L_0x00b4:
            java.util.Map r1 = (java.util.Map) r1
            java.util.Set r8 = r1.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x00be:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0137
            java.lang.Object r1 = r8.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.getValue()
            com.didi.soda.home.topgun.model.FilterComponentState r1 = (com.didi.soda.home.topgun.model.FilterComponentState) r1
            java.util.HashMap r1 = r1.getFilterItemStates()
            java.util.Map r1 = (java.util.Map) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r1.size()
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00f3:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0109
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            com.didi.soda.home.topgun.model.FilterItemState r4 = (com.didi.soda.home.topgun.model.FilterItemState) r4
            r3.add(r4)
            goto L_0x00f3
        L_0x0109:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r1 = r3.iterator()
        L_0x0111:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00be
            java.lang.Object r3 = r1.next()
            com.didi.soda.home.topgun.model.FilterItemState r3 = (com.didi.soda.home.topgun.model.FilterItemState) r3
            com.didi.soda.home.topgun.model.FilterItemParam r4 = new com.didi.soda.home.topgun.model.FilterItemParam
            java.lang.String r5 = r3.getItemId()
            if (r5 == 0) goto L_0x0126
            goto L_0x0128
        L_0x0126:
            java.lang.String r5 = ""
        L_0x0128:
            java.lang.String r6 = r3.getSourceType()
            java.lang.String r3 = r3.getActivityId()
            r4.<init>(r2, r5, r6, r3)
            r0.add(r4)
            goto L_0x0111
        L_0x0137:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.filter.FilterDataManager.generateGroupOutParams(com.didi.soda.home.topgun.model.FilterModel):java.util.ArrayList");
    }

    /* renamed from: a */
    private final void m30311a(FilterModel.FilterComponentModel filterComponentModel) {
        FilterComponentState filterComponentState = this.f42840c.get(Integer.valueOf(filterComponentModel.mType));
        if (filterComponentState != null) {
            Map linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : filterComponentState.getFilterItemStates().entrySet()) {
                if (Intrinsics.areEqual((Object) ((FilterItemState) entry.getValue()).isMultipleChoice(), (Object) false)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            boolean z = !linkedHashMap.isEmpty();
            for (FilterModel.FilterItemRvModel next : filterComponentModel.mItems) {
                if (next.mIsSelected) {
                    if (!next.mIsMultipleChoice) {
                        filterComponentState.getFilterItemStates().clear();
                        HashMap<String, FilterItemState> filterItemStates = filterComponentState.getFilterItemStates();
                        String str = next.mId;
                        FilterItemState.Companion companion = FilterItemState.Companion;
                        Intrinsics.checkNotNullExpressionValue(next, "item");
                        filterItemStates.put(str, companion.convert(next));
                        z = true;
                    } else if (z) {
                        filterComponentState.getFilterItemStates().clear();
                        HashMap<String, FilterItemState> filterItemStates2 = filterComponentState.getFilterItemStates();
                        String str2 = next.mId;
                        FilterItemState.Companion companion2 = FilterItemState.Companion;
                        Intrinsics.checkNotNullExpressionValue(next, "item");
                        filterItemStates2.put(str2, companion2.convert(next));
                        z = false;
                    } else {
                        HashMap<String, FilterItemState> filterItemStates3 = filterComponentState.getFilterItemStates();
                        String str3 = next.mId;
                        FilterItemState.Companion companion3 = FilterItemState.Companion;
                        Intrinsics.checkNotNullExpressionValue(next, "item");
                        filterItemStates3.put(str3, companion3.convert(next));
                    }
                } else if (filterComponentState.getFilterItemStates().containsKey(next.mId)) {
                    filterComponentState.getFilterItemStates().remove(next.mId);
                }
            }
        }
    }

    /* renamed from: b */
    private final void m30314b(List<? extends FilterModel> list) {
        HashMap<String, FilterItemState> filterItemStates;
        for (FilterModel filterModel : list) {
            List<FilterModel.FilterComponentModel> list2 = filterModel.mFilterComponent;
            Intrinsics.checkNotNullExpressionValue(list2, "filterModel.mFilterComponent");
            for (FilterModel.FilterComponentModel filterComponentModel : list2) {
                for (FilterModel.FilterItemRvModel next : filterComponentModel.mItems) {
                    FilterComponentState filterComponentState = this.f42840c.get(Integer.valueOf(filterComponentModel.mType));
                    boolean z = true;
                    if (filterComponentState == null || (filterItemStates = filterComponentState.getFilterItemStates()) == null || !filterItemStates.containsKey(next.mId)) {
                        z = false;
                    }
                    next.mIsSelected = z;
                }
            }
        }
    }

    public final void saveFilterGroupChange(FilterModel filterModel) {
        if (filterModel != null) {
            List<FilterModel.FilterComponentModel> list = filterModel.mFilterComponent;
            Intrinsics.checkNotNullExpressionValue(list, "filterModel.mFilterComponent");
            for (FilterModel.FilterComponentModel filterComponentModel : list) {
                Intrinsics.checkNotNullExpressionValue(filterComponentModel, "it");
                m30311a(filterComponentModel);
            }
            m30314b(this.f42839b);
        }
    }

    public final void resetAllFilter() {
        for (FilterModel reset : this.f42839b) {
            reset.reset();
        }
        m30309a();
    }

    public static /* synthetic */ List getFilterModelListWithoutMain$default(FilterDataManager filterDataManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return filterDataManager.getFilterModelListWithoutMain(z);
    }

    public final List<FilterModel> getFilterModelListWithoutMain(boolean z) {
        Collection arrayList = new ArrayList();
        for (Object next : this.f42839b) {
            if (!(((FilterModel) next).mShowType == 4)) {
                arrayList.add(next);
            }
        }
        List<FilterModel> list = (List) arrayList;
        for (FilterModel a : list) {
            m30312a(a, z);
        }
        return list;
    }

    public final FilterModel getMainFilterModel() {
        Collection arrayList = new ArrayList();
        Iterator it = this.f42839b.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((FilterModel) next).mShowType == 4) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List<FilterModel> list = (List) arrayList;
        for (FilterModel a : list) {
            m30310a(this, a, false, 2, (Object) null);
        }
        return (FilterModel) CollectionsKt.firstOrNull(list);
    }

    /* renamed from: a */
    static /* synthetic */ void m30310a(FilterDataManager filterDataManager, FilterModel filterModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        filterDataManager.m30312a(filterModel, z);
    }

    /* renamed from: a */
    private final void m30312a(FilterModel filterModel, boolean z) {
        boolean z2;
        List<FilterModel.FilterItemRvModel> list;
        FilterModel.FilterItemRvModel filterItemRvModel;
        boolean z3 = true;
        if (filterModel.mShowType == 4) {
            filterModel.mHeadLineLight = !filterModel.isOriginal();
        } else if (filterModel.mShowType == 5) {
            if (filterModel.checkFilterComponentSize()) {
                FilterModel.FilterComponentModel filterComponentModel = filterModel.mFilterComponent.get(0);
                Collection collection = filterComponentModel.mItems;
                if (collection != null && !collection.isEmpty()) {
                    z3 = false;
                }
                if (z3) {
                    filterComponentModel = null;
                }
                FilterModel.FilterComponentModel filterComponentModel2 = filterComponentModel;
                if (filterComponentModel2 != null && (list = filterComponentModel2.mItems) != null && (filterItemRvModel = list.get(0)) != null) {
                    filterModel.setHeaderLine(TextUtils.isEmpty(filterItemRvModel.mShortName) ? filterItemRvModel.mName : filterItemRvModel.mShortName, z);
                    filterModel.mHeadLineLight = filterItemRvModel.mIsSelected;
                }
            }
        } else if (filterModel.checkFilterComponentSize()) {
            FilterModel.FilterComponentModel filterComponentModel3 = filterModel.mFilterComponent.get(0);
            List<FilterModel.FilterItemRvModel> list2 = filterComponentModel3.mItems;
            if (list2 == null) {
                z2 = true;
            } else {
                z2 = true;
                for (FilterModel.FilterItemRvModel filterItemRvModel2 : list2) {
                    if (filterItemRvModel2.mIsMultipleChoice) {
                        z2 = false;
                    }
                }
            }
            if (z2) {
                FilterModel.FilterItemRvModel selectedItem = filterComponentModel3.getSelectedItem();
                if (selectedItem != null) {
                    if (TextUtils.isEmpty(selectedItem.mShortName)) {
                        filterModel.setHeaderLine(selectedItem.mName, z);
                    } else {
                        filterModel.setHeaderLine(selectedItem.mShortName, z);
                    }
                    filterModel.mHeadLineLight = !selectedItem.mIsDefault;
                    return;
                }
                return;
            }
            String mergeMultiHeadLine = filterComponentModel3.mergeMultiHeadLine();
            CharSequence charSequence = mergeMultiHeadLine;
            if (!(charSequence == null || charSequence.length() == 0)) {
                filterModel.setHeaderLine(mergeMultiHeadLine, z);
                filterModel.mHeadLineLight = true;
                return;
            }
            filterModel.setHeaderLine(filterModel.mDefaultHeadLine, z);
            filterModel.mHeadLineLight = false;
        }
    }

    public final void setFilterDataChangedListener(Function0<Unit> function0) {
        this.f42841d = function0;
    }

    public final void notifyFilterDataChanged() {
        Function0<Unit> function0 = this.f42841d;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean isOriginalFilterData() {
        for (FilterModel isOriginal : this.f42839b) {
            if (!isOriginal.isOriginal()) {
                return false;
            }
        }
        return true;
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\t\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/filter/FilterDataManager$FilterDataManagerPool;", "", "()V", "mPool", "Ljava/util/HashMap;", "", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "Lkotlin/collections/HashMap;", "getFilterManager", "scene", "removeFilterManager", "", "saveFilterDataManger", "dataManager", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilterDataManager.kt */
    private static final class FilterDataManagerPool {
        public static final FilterDataManagerPool INSTANCE = new FilterDataManagerPool();
        private static final HashMap<Integer, FilterDataManager> mPool = new HashMap<>();

        private FilterDataManagerPool() {
        }

        public final FilterDataManager getFilterManager(@FilterDataManagerScene int i) {
            return mPool.get(Integer.valueOf(i));
        }

        public final void saveFilterDataManger(@FilterDataManagerScene int i, FilterDataManager filterDataManager) {
            Intrinsics.checkNotNullParameter(filterDataManager, "dataManager");
            mPool.put(Integer.valueOf(i), filterDataManager);
        }

        public final void removeFilterManager(@FilterDataManagerScene int i) {
            mPool.remove(Integer.valueOf(i));
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/filter/FilterDataManager$Companion;", "", "()V", "getInstanceByScene", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "scene", "", "isHasDataManager", "", "removeHadaManager", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilterDataManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FilterDataManager getInstanceByScene(@FilterDataManagerScene int i) {
            FilterDataManager filterManager = FilterDataManagerPool.INSTANCE.getFilterManager(i);
            if (filterManager != null) {
                return filterManager;
            }
            FilterDataManager filterDataManager = new FilterDataManager(i, (DefaultConstructorMarker) null);
            FilterDataManagerPool.INSTANCE.saveFilterDataManger(i, filterDataManager);
            return filterDataManager;
        }

        public final boolean isHasDataManager(@FilterDataManagerScene int i) {
            return FilterDataManagerPool.INSTANCE.getFilterManager(i) != null;
        }

        public final void removeHadaManager(@FilterDataManagerScene int i) {
            FilterDataManagerPool.INSTANCE.removeFilterManager(i);
        }
    }
}
