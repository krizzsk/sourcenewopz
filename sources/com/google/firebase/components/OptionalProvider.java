package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

class OptionalProvider<T> implements Deferred<T>, Provider<T> {
    private static final Provider<Object> EMPTY_PROVIDER = $$Lambda$OptionalProvider$V5P2P1pkwQDT7xyfdsKcTNI9lRw.INSTANCE;
    private static final Deferred.DeferredHandler<Object> NOOP_HANDLER = $$Lambda$OptionalProvider$p0l832a_x78_I5CnOiVPKec4M.INSTANCE;
    private volatile Provider<T> delegate;
    private Deferred.DeferredHandler<T> handler;

    static /* synthetic */ void lambda$static$0(Provider provider) {
    }

    static /* synthetic */ Object lambda$static$1() {
        return null;
    }

    private OptionalProvider(Deferred.DeferredHandler<T> deferredHandler, Provider<T> provider) {
        this.handler = deferredHandler;
        this.delegate = provider;
    }

    static <T> OptionalProvider<T> empty() {
        return new OptionalProvider<>(NOOP_HANDLER, EMPTY_PROVIDER);
    }

    /* renamed from: of */
    static <T> OptionalProvider<T> m38523of(Provider<T> provider) {
        return new OptionalProvider<>((Deferred.DeferredHandler) null, provider);
    }

    public T get() {
        return this.delegate.get();
    }

    /* access modifiers changed from: package-private */
    public void set(Provider<T> provider) {
        Deferred.DeferredHandler<T> deferredHandler;
        if (this.delegate == EMPTY_PROVIDER) {
            synchronized (this) {
                deferredHandler = this.handler;
                this.handler = null;
                this.delegate = provider;
            }
            deferredHandler.handle(provider);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    public void whenAvailable(Deferred.DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2 = this.delegate;
        if (provider2 != EMPTY_PROVIDER) {
            deferredHandler.handle(provider2);
            return;
        }
        Provider<T> provider3 = null;
        synchronized (this) {
            provider = this.delegate;
            if (provider != EMPTY_PROVIDER) {
                provider3 = provider;
            } else {
                this.handler = new Deferred.DeferredHandler(deferredHandler) {
                    public final /* synthetic */ Deferred.DeferredHandler f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void handle(Provider provider) {
                        OptionalProvider.lambda$whenAvailable$2(Deferred.DeferredHandler.this, this.f$1, provider);
                    }
                };
            }
        }
        if (provider3 != null) {
            deferredHandler.handle(provider);
        }
    }

    static /* synthetic */ void lambda$whenAvailable$2(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.handle(provider);
        deferredHandler2.handle(provider);
    }
}
