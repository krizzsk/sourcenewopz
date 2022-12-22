package com.didi.soda.blocks.parse;

import com.didi.soda.blocks.entity.ActionEntity;
import com.didi.soda.blocks.entity.CallBackEntity;
import com.didi.soda.blocks.entity.WidgetNodeEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/PeerDiffMapper;", "", "()V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PeerDiffMapper.kt */
public final class PeerDiffMapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ(\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/blocks/parse/PeerDiffMapper$Companion;", "", "()V", "map", "", "nodeEntity", "Lcom/didi/soda/blocks/entity/WidgetNodeEntity;", "peer", "Lcom/didi/soda/blocks/parse/Peer;", "mapLogic", "logicList", "", "Lcom/didi/soda/blocks/entity/ActionEntity;", "logicMap", "", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: PeerDiffMapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void map(WidgetNodeEntity widgetNodeEntity, Peer peer) {
            List<ActionEntity> logics;
            Intrinsics.checkParameterIsNotNull(widgetNodeEntity, "nodeEntity");
            Intrinsics.checkParameterIsNotNull(peer, "peer");
            Map<String, String> widget = peer.getWidget();
            if (!(widget == null || widget.isEmpty())) {
                Map<String, String> widget2 = peer.getWidget();
                if (widget2 == null) {
                    Intrinsics.throwNpe();
                }
                String str = widget2.get(widgetNodeEntity.getComponentName());
                if (str != null) {
                    widgetNodeEntity.setComponentName(str);
                }
            }
            List<WidgetNodeEntity> children = widgetNodeEntity.getChildren();
            if (children != null) {
                for (WidgetNodeEntity map : children) {
                    PeerDiffMapper.Companion.map(map, peer);
                }
            }
            Map<String, String> event = peer.getEvent();
            if (event == null || event.isEmpty()) {
                Map<String, String> logic = peer.getLogic();
                if (logic == null || logic.isEmpty()) {
                    return;
                }
            }
            List<CallBackEntity> actions = widgetNodeEntity.getActions();
            if (actions != null) {
                for (CallBackEntity callBackEntity : actions) {
                    Map<String, String> event2 = peer.getEvent();
                    if (!(event2 == null || event2.isEmpty())) {
                        Map<String, String> event3 = peer.getEvent();
                        if (event3 == null) {
                            Intrinsics.throwNpe();
                        }
                        String str2 = event3.get(callBackEntity.getEvent());
                        if (str2 != null) {
                            callBackEntity.setEvent(str2);
                        }
                    }
                    Map<String, String> logic2 = peer.getLogic();
                    if (!(logic2 == null || logic2.isEmpty()) && (logics = callBackEntity.getLogics()) != null) {
                        Companion companion = PeerDiffMapper.Companion;
                        Map<String, String> logic3 = peer.getLogic();
                        if (logic3 == null) {
                            Intrinsics.throwNpe();
                        }
                        companion.mapLogic(logics, logic3);
                    }
                }
            }
        }

        public final void mapLogic(List<ActionEntity> list, Map<String, String> map) {
            Intrinsics.checkParameterIsNotNull(list, "logicList");
            Intrinsics.checkParameterIsNotNull(map, "logicMap");
            for (ActionEntity actionEntity : list) {
                String str = map.get(actionEntity.getMethod());
                if (str != null) {
                    actionEntity.setMethod(str);
                }
                List<ActionEntity> onResolve = actionEntity.getOnResolve();
                if (onResolve != null) {
                    PeerDiffMapper.Companion.mapLogic(onResolve, map);
                }
                List<ActionEntity> onReject = actionEntity.getOnReject();
                if (onReject != null) {
                    PeerDiffMapper.Companion.mapLogic(onReject, map);
                }
            }
        }
    }
}
