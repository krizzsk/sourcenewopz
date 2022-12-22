package com.didi.map.global.flow.scene;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;

public class PageSceneParam {

    /* renamed from: a */
    private IMapChangeListener f26308a;

    /* renamed from: b */
    private Context f26309b;

    public IMapChangeListener getMapChangeListener() {
        return this.f26308a;
    }

    public Context getContext() {
        return this.f26309b;
    }

    public PageSceneParam(Builder builder) {
        m18603a(builder);
    }

    public void reset(Builder builder) {
        m18603a(builder);
    }

    /* renamed from: a */
    private void m18603a(Builder builder) {
        this.f26308a = builder.mapChangeListener;
        this.f26309b = builder.context;
    }

    protected static abstract class Builder {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public IMapChangeListener mapChangeListener;

        protected Builder() {
        }

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            this.mapChangeListener = iMapChangeListener;
            return this;
        }

        public Builder context(Context context2) {
            this.context = context2;
            return this;
        }
    }
}
