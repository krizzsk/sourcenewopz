package com.didi.soda.customer.blocks.binderpool;

import android.content.Context;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.widget.Buildable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B!\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\u0002\u0010\tJ%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00028\u0001H&¢\u0006\u0002\u0010#J\u001b\u0010$\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u001b\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u001bR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000@BX.¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/binderpool/BinderRoot;", "V", "Lcom/didi/soda/blocks/widget/Buildable;", "T", "", "type", "", "config", "Lcom/didi/soda/blocks/BinderRootConfig;", "(Ljava/lang/String;Lcom/didi/soda/blocks/BinderRootConfig;)V", "getConfig", "()Lcom/didi/soda/blocks/BinderRootConfig;", "setConfig", "(Lcom/didi/soda/blocks/BinderRootConfig;)V", "isAttached", "", "()Z", "setAttached", "(Z)V", "<set-?>", "getType", "()Ljava/lang/String;", "view", "getView", "()Lcom/didi/soda/blocks/widget/Buildable;", "Lcom/didi/soda/blocks/widget/Buildable;", "bind", "", "data", "position", "", "(Lcom/didi/soda/blocks/widget/Buildable;Ljava/lang/Object;I)V", "createView", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/Object;)Lcom/didi/soda/blocks/widget/Buildable;", "innerCreateView", "internalBindView", "item", "(Ljava/lang/Object;I)V", "internalRest", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BinderRoot.kt */
public abstract class BinderRoot<V extends Buildable, T> {

    /* renamed from: a */
    private BinderRootConfig<T> f40558a;

    /* renamed from: b */
    private String f40559b;

    /* renamed from: c */
    private V f40560c;

    /* renamed from: d */
    private boolean f40561d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BinderRoot(String str) {
        this(str, (BinderRootConfig) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void bind(V v, T t, int i) {
        Intrinsics.checkNotNullParameter(v, "view");
    }

    public abstract V createView(Context context, T t);

    public BinderRoot(String str, BinderRootConfig<T> binderRootConfig) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.f40558a = binderRootConfig;
        this.f40559b = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BinderRoot(String str, BinderRootConfig binderRootConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : binderRootConfig);
    }

    public final BinderRootConfig<T> getConfig() {
        return this.f40558a;
    }

    public final void setConfig(BinderRootConfig<T> binderRootConfig) {
        this.f40558a = binderRootConfig;
    }

    public final String getType() {
        return this.f40559b;
    }

    public final V getView() {
        V v = this.f40560c;
        if (v != null) {
            return v;
        }
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    public final boolean isAttached() {
        return this.f40561d;
    }

    public final void setAttached(boolean z) {
        this.f40561d = z;
    }

    public final V innerCreateView(Context context, T t) {
        Intrinsics.checkNotNullParameter(context, "context");
        V createView = createView(context, t);
        this.f40560c = createView;
        return createView;
    }

    public final void internalBindView(T t, int i) {
        bind(getView(), t, i);
    }

    public final void internalRest() {
        this.f40561d = false;
    }
}
