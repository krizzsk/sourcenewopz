package com.didi.soda.compose;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.compose.adapter.ComposeAdapter;
import com.didi.soda.compose.adapter.ItemCard;
import com.didi.soda.compose.adapter.ItemCardHolder;
import com.didi.soda.compose.card.BaseCard;
import com.didi.soda.compose.entity.ComposeEntity;
import com.didi.soda.compose.event.ComposeBus;
import com.didi.soda.compose.parse.DataParser;
import com.didi.soda.compose.pool.CardsPool;
import com.didi.soda.compose.service.ComposeLoadMordScrollListener;
import com.didi.soda.compose.service.ServiceManager;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0010\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u001fJ\b\u0010\"\u001a\u0004\u0018\u00010\u0010J\u0016\u0010#\u001a\u0004\u0018\u00010\u00142\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016J\u0016\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u0016J\u001c\u0010*\u001a\u00020\u00162\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010+\u001a\u00020\u0014H\u0016J\u001e\u0010,\u001a\u00020\u00162\u0016\u0010-\u001a\u0012\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0/0.J\u000e\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0010J\u0016\u00102\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001fJ\u0014\u00103\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u000e\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u000206J\u000e\u00104\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020(J\u000e\u00109\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, mo175978d2 = {"Lcom/didi/soda/compose/ComposeEngine;", "Lcom/didi/soda/compose/service/ServiceManager;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "mCardsPool", "Lcom/didi/soda/compose/pool/CardsPool;", "mComposeAdapter", "Lcom/didi/soda/compose/adapter/ComposeAdapter;", "mComposeBus", "Lcom/didi/soda/compose/event/ComposeBus;", "mDataParser", "Lcom/didi/soda/compose/parse/DataParser;", "mPreLoadNumber", "", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mServices", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "", "addLoadMoreListener", "", "loadMoreListener", "Lcom/didi/soda/compose/service/ComposeLoadMordScrollListener$LoadMoreListener;", "appendData", "data", "Lorg/json/JSONObject;", "appendDataList", "list", "Ljava/util/LinkedList;", "Lcom/didi/soda/compose/card/BaseCard;", "findCardPosition", "card", "getContentView", "getService", "type", "insertCard", "position", "isAutoPreLoad", "", "onDestroy", "register", "service", "registerCard", "itemCard", "Lcom/didi/soda/compose/adapter/ItemCard;", "Lcom/didi/soda/compose/adapter/ItemCardHolder;", "registerView", "recyclerView", "replaceCard", "setCardList", "setData", "entity", "Lcom/didi/soda/compose/entity/ComposeEntity;", "setDebugLog", "debug", "setPreLoadNumber", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ComposeEngine.kt */
public final class ComposeEngine implements ServiceManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static boolean DEBUG;

    /* renamed from: a */
    private int f40099a = 5;

    /* renamed from: b */
    private RecyclerView f40100b;

    /* renamed from: c */
    private ComposeAdapter f40101c;

    /* renamed from: d */
    private CardsPool f40102d = new CardsPool();

    /* renamed from: e */
    private ComposeBus f40103e;

    /* renamed from: f */
    private ConcurrentHashMap<Class<?>, Object> f40104f;

    /* renamed from: g */
    private DataParser f40105g;

    public ComposeEngine(ScopeContext scopeContext) {
        this.f40103e = scopeContext != null ? new ComposeBus(scopeContext) : null;
        this.f40104f = new ConcurrentHashMap<>();
        this.f40105g = new DataParser();
        CardsPool cardsPool = this.f40102d;
        if (cardsPool != null) {
            register(CardsPool.class, cardsPool);
        }
        ComposeBus composeBus = this.f40103e;
        if (composeBus != null) {
            register(ComposeBus.class, composeBus);
        }
    }

    public final void registerCard(ItemCard<?, ? extends ItemCardHolder<BaseCard>> itemCard) {
        Intrinsics.checkParameterIsNotNull(itemCard, "itemCard");
        CardsPool cardsPool = this.f40102d;
        if (cardsPool != null) {
            cardsPool.register(itemCard);
        }
    }

    public final void registerView(RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        this.f40100b = recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        Object service = getService(CardsPool.class);
        if (service != null) {
            ComposeAdapter composeAdapter = new ComposeAdapter((CardsPool) service);
            this.f40101c = composeAdapter;
            recyclerView.setAdapter(composeAdapter);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.didi.soda.compose.pool.CardsPool");
    }

    public final void setData(ComposeEntity composeEntity) {
        ComposeAdapter composeAdapter;
        Intrinsics.checkParameterIsNotNull(composeEntity, "entity");
        DataParser dataParser = this.f40105g;
        LinkedList<BaseCard> parseCardData = dataParser != null ? dataParser.parseCardData(composeEntity, (ServiceManager) this) : null;
        if (parseCardData != null && (composeAdapter = this.f40101c) != null) {
            composeAdapter.setData(parseCardData);
        }
    }

    public final void setData(JSONObject jSONObject) {
        ComposeAdapter composeAdapter;
        Intrinsics.checkParameterIsNotNull(jSONObject, "data");
        DataParser dataParser = this.f40105g;
        LinkedList<BaseCard> parseCardData = dataParser != null ? dataParser.parseCardData(jSONObject, (ServiceManager) this) : null;
        if (parseCardData != null && (composeAdapter = this.f40101c) != null) {
            composeAdapter.setData(parseCardData);
        }
    }

    public final void setCardList(LinkedList<BaseCard> linkedList) {
        Intrinsics.checkParameterIsNotNull(linkedList, "list");
        ComposeAdapter composeAdapter = this.f40101c;
        if (composeAdapter != null) {
            composeAdapter.setData(linkedList);
        }
    }

    public final RecyclerView getContentView() {
        return this.f40100b;
    }

    public final void setDebugLog(boolean z) {
        DEBUG = z;
    }

    public final void addLoadMoreListener(ComposeLoadMordScrollListener.LoadMoreListener loadMoreListener) {
        Intrinsics.checkParameterIsNotNull(loadMoreListener, "loadMoreListener");
        RecyclerView recyclerView = this.f40100b;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new ComposeLoadMordScrollListener(loadMoreListener, this.f40099a));
        }
    }

    public final void appendData(JSONObject jSONObject) {
        ComposeAdapter composeAdapter;
        Intrinsics.checkParameterIsNotNull(jSONObject, "data");
        DataParser dataParser = this.f40105g;
        LinkedList<BaseCard> parseCardData = dataParser != null ? dataParser.parseCardData(jSONObject, (ServiceManager) this) : null;
        if (parseCardData != null && (composeAdapter = this.f40101c) != null) {
            composeAdapter.appendData(parseCardData);
        }
    }

    public final void appendDataList(LinkedList<BaseCard> linkedList) {
        Intrinsics.checkParameterIsNotNull(linkedList, "list");
        ComposeAdapter composeAdapter = this.f40101c;
        if (composeAdapter != null) {
            composeAdapter.appendData(linkedList);
        }
    }

    public final void insertCard(int i, BaseCard baseCard) {
        Intrinsics.checkParameterIsNotNull(baseCard, "data");
        ComposeAdapter composeAdapter = this.f40101c;
        LinkedList<BaseCard> data = composeAdapter != null ? composeAdapter.getData() : null;
        if (data != null) {
            data.add(i, baseCard);
            ComposeAdapter composeAdapter2 = this.f40101c;
            if (composeAdapter2 != null) {
                composeAdapter2.notifyItemRangeInserted(i, 1);
            }
        }
    }

    public final void replaceCard(int i, BaseCard baseCard) {
        Intrinsics.checkParameterIsNotNull(baseCard, "data");
        ComposeAdapter composeAdapter = this.f40101c;
        LinkedList<BaseCard> data = composeAdapter != null ? composeAdapter.getData() : null;
        if (data != null) {
            data.set(i, baseCard);
            ComposeAdapter composeAdapter2 = this.f40101c;
            if (composeAdapter2 != null) {
                composeAdapter2.notifyItemRangeChanged(i, 1, (Object) null);
            }
        }
    }

    public final void setPreLoadNumber(int i) {
        this.f40099a = i;
    }

    public final boolean isAutoPreLoad() {
        return this.f40099a > 1;
    }

    public final int findCardPosition(BaseCard baseCard) {
        ComposeAdapter composeAdapter = this.f40101c;
        if (composeAdapter != null) {
            return CollectionsKt.indexOf(composeAdapter.getData(), baseCard);
        }
        return -1;
    }

    public final void onDestroy() {
        this.f40105g = null;
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = this.f40104f;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        this.f40104f = null;
        this.f40102d = null;
        this.f40101c = null;
        ComposeBus composeBus = this.f40103e;
        if (composeBus != null) {
            composeBus.onDestroy();
        }
        this.f40103e = null;
    }

    public void register(Class<?> cls, Object obj) {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap;
        Intrinsics.checkParameterIsNotNull(cls, "type");
        Intrinsics.checkParameterIsNotNull(obj, "service");
        Object cast = cls.cast(obj);
        if (cast != null && (concurrentHashMap = this.f40104f) != null) {
            concurrentHashMap.put(cls, cast);
        }
    }

    public Object getService(Class<?> cls) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(cls, "type");
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = this.f40104f;
        if (concurrentHashMap == null || (obj = concurrentHashMap.get(cls)) == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(obj, "mServices?.get(type) ?: return null");
        return cls.cast(obj);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/compose/ComposeEngine$Companion;", "", "()V", "DEBUG", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ComposeEngine.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
