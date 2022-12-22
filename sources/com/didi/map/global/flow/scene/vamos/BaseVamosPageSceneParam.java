package com.didi.map.global.flow.scene.vamos;

import android.content.Context;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;

public class BaseVamosPageSceneParam extends PageSceneParam {

    /* renamed from: a */
    private IActorGetter f17682a;

    /* renamed from: b */
    private String f17683b = "";

    public IActorGetter getActorGetter() {
        return this.f17682a;
    }

    public String getTravelId() {
        return this.f17683b;
    }

    public BaseVamosPageSceneParam(Builder builder) {
        super(builder);
        this.f17682a = builder.actor;
        this.f17683b = builder.travelId;
    }

    public static abstract class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public IActorGetter actor;
        /* access modifiers changed from: private */
        public String travelId = "";

        public /* bridge */ /* synthetic */ PageSceneParam.Builder context(Context context) {
            return super.context(context);
        }

        public /* bridge */ /* synthetic */ PageSceneParam.Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return super.mapChangeListener(iMapChangeListener);
        }

        public Builder actorGetter(IActorGetter iActorGetter) {
            this.actor = iActorGetter;
            return this;
        }

        public Builder travelId(String str) {
            this.travelId = str;
            return this;
        }
    }
}
