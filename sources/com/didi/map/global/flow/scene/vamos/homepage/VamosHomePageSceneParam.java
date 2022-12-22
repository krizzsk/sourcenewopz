package com.didi.map.global.flow.scene.vamos.homepage;

import android.content.Context;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.global.flow.scene.vamos.IActorGetter;

public class VamosHomePageSceneParam extends BaseVamosPageSceneParam {
    private VamosHomePageSceneParam(Builder builder) {
        super(builder);
    }

    public static class Builder extends BaseVamosPageSceneParam.Builder {
        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder actorGetter(IActorGetter iActorGetter) {
            return (Builder) super.actorGetter(iActorGetter);
        }

        public Builder travelId(String str) {
            return (Builder) super.travelId(str);
        }

        public VamosHomePageSceneParam build() {
            return new VamosHomePageSceneParam(this);
        }
    }
}
