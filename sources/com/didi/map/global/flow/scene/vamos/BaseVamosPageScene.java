package com.didi.map.global.flow.scene.vamos;

import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageSceneParam;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.RoleType;

public abstract class BaseVamosPageScene<P extends BaseVamosPageSceneParam> extends PageScene<P> {

    /* renamed from: a */
    private IActorGetter f17681a;

    public BaseVamosPageScene(P p, MapViewHolder mapViewHolder) {
        super(p, mapViewHolder);
        if (p != null) {
            IActorGetter actorGetter = p.getActorGetter();
            this.f17681a = actorGetter;
            if (actorGetter == null || actorGetter.getActor() != 1) {
                IActorGetter iActorGetter = this.f17681a;
                if (iActorGetter != null && iActorGetter.getActor() == 0) {
                    PaxEnvironment.getInstance().setRoleTypeInternal(RoleType.PASSENGER);
                    return;
                }
                return;
            }
            PaxEnvironment.getInstance().setRoleTypeInternal(RoleType.DRIVER);
        }
    }

    public int getActor() {
        IActorGetter iActorGetter = this.f17681a;
        if (iActorGetter != null) {
            return iActorGetter.getActor();
        }
        return -1;
    }

    public final boolean isDriver() {
        return getActor() == 1;
    }

    public final boolean isPassenger() {
        return getActor() == 0;
    }
}
