package com.didi.soda.blocks.track;

import com.didi.soda.blocks.constant.TrackConst;
import com.didi.soda.blocks.entity.Template;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/blocks/track/BlocksTrackHelper;", "", "()V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BlocksTrackHelper.kt */
public final class BlocksTrackHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J \u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J$\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/blocks/track/BlocksTrackHelper$Companion;", "", "()V", "trackAcionNotFound", "", "templateId", "", "componentName", "eventName", "actionName", "trackComponetFormatError", "trackCosumedTimeForNodeBuilding", "duration", "", "exprDuration", "trackCosumedTimeForPainting", "trackCosumedTimeForTreeRendering", "trackCosumedTimeForYogaLayout", "trackCriticalInfoError", "type", "", "expression", "result", "trackExpressionExecuteError", "originExpression", "reason", "trackTemplateFormatError", "template", "Lcom/didi/soda/blocks/entity/Template;", "trackWidgetDisallowStyle", "trackWidgetNotFound", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: BlocksTrackHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void trackTemplateFormatError(Template template) {
            if (template != null) {
                Map linkedHashMap = new LinkedHashMap();
                if (Intrinsics.areEqual((Object) template.getVersion(), (Object) "1")) {
                    if (template.getTmplId() == null) {
                        linkedHashMap.put(TrackConst.Params.NIL_KEYS, "tmplId");
                    } else {
                        String tmplId = template.getTmplId();
                        if (tmplId == null) {
                            Intrinsics.throwNpe();
                        }
                        linkedHashMap.put("template_id", tmplId);
                    }
                    if (template.getContent() == null) {
                        linkedHashMap.put(TrackConst.Params.NIL_KEYS, "content");
                    }
                    if (template.getPeer() != null) {
                        linkedHashMap.put(TrackConst.Params.WRONG_KEYS, "peer");
                    }
                } else {
                    if (template.getTemplateId() == null) {
                        linkedHashMap.put(TrackConst.Params.NIL_KEYS, "templateId");
                    } else {
                        String templateId = template.getTemplateId();
                        if (templateId == null) {
                            Intrinsics.throwNpe();
                        }
                        linkedHashMap.put("template_id", templateId);
                    }
                    if (template.getComponentsTree() == null) {
                        linkedHashMap.put(TrackConst.Params.NIL_KEYS, "componentsTree");
                    }
                }
                linkedHashMap.put("version", template.getVersion());
                IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
                if (tracker != null) {
                    tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_TEMPLATE_FORMAT_ERROR, linkedHashMap);
                }
            }
        }

        public final void trackWidgetNotFound(String str, String str2) {
            Pair[] pairArr = new Pair[2];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to(TrackConst.Params.COMPONENT_NAME, str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[1] = TuplesKt.m42317to("template_id", str2);
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_WIDGET_NOT_FOUND, mutableMapOf);
            }
        }

        public final void trackComponetFormatError(String str) {
            Pair[] pairArr = new Pair[1];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("template_id", str);
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_COMPONENT_FORMAT_ERROR, mutableMapOf);
            }
        }

        public final void trackWidgetDisallowStyle(String str, String str2) {
            Pair[] pairArr = new Pair[2];
            if (str2 == null) {
                str2 = "";
            }
            pairArr[0] = TuplesKt.m42317to(TrackConst.Params.COMPONENT_NAME, str2);
            if (str == null) {
                str = "";
            }
            pairArr[1] = TuplesKt.m42317to("template_id", str);
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_WIDGET_DISALLOW_STYLE, mutableMapOf);
            }
        }

        public final void trackAcionNotFound(String str, String str2, String str3, String str4) {
            Pair[] pairArr = new Pair[4];
            if (str2 == null) {
                str2 = "";
            }
            pairArr[0] = TuplesKt.m42317to(TrackConst.Params.COMPONENT_NAME, str2);
            if (str == null) {
                str = "";
            }
            pairArr[1] = TuplesKt.m42317to("template_id", str);
            if (str3 == null) {
                str3 = "";
            }
            pairArr[2] = TuplesKt.m42317to(TrackConst.Params.EVENT_NAME, str3);
            if (str4 == null) {
                str4 = "";
            }
            pairArr[3] = TuplesKt.m42317to(TrackConst.Params.ACTION_NAME, str4);
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_ACTION_NOT_FOUND, mutableMapOf);
            }
        }

        public final void trackCosumedTimeForNodeBuilding(String str, long j, long j2) {
            Pair[] pairArr = new Pair[3];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("template_id", str);
            pairArr[1] = TuplesKt.m42317to("duration", Long.valueOf(j));
            pairArr[2] = TuplesKt.m42317to(TrackConst.Params.EXPR_DURATION, Long.valueOf(j2));
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_NODE_TREE_CREATION, mutableMapOf);
            }
        }

        public final void trackCosumedTimeForTreeRendering(String str, long j) {
            Pair[] pairArr = new Pair[2];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("template_id", str);
            pairArr[1] = TuplesKt.m42317to("duration", Long.valueOf(j));
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_WIDGET_TREE_RENDER, mutableMapOf);
            }
        }

        public final void trackCosumedTimeForYogaLayout(String str, long j) {
            Pair[] pairArr = new Pair[2];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("template_id", str);
            pairArr[1] = TuplesKt.m42317to("duration", Long.valueOf(j));
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_WIDGET_TREE_LAYOUT, mutableMapOf);
            }
        }

        public final void trackCosumedTimeForPainting(String str, long j) {
            Pair[] pairArr = new Pair[2];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to("template_id", str);
            pairArr[1] = TuplesKt.m42317to("duration", Long.valueOf(j));
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_WIDGET_TREE_PAINTER, mutableMapOf);
            }
        }

        public final void trackExpressionExecuteError(String str, String str2, String str3) {
            Pair[] pairArr = new Pair[3];
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.m42317to(TrackConst.Params.ORIGINAL_EXPRESSION, str);
            if (str2 == null) {
                str2 = "";
            }
            pairArr[1] = TuplesKt.m42317to(TrackConst.Params.EXECUTABLE_EXPRESSION, str2);
            if (str3 == null) {
                str3 = "";
            }
            pairArr[2] = TuplesKt.m42317to("reason", str3);
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_EXPRESSION_EXECUTE_ERROR, mutableMapOf);
            }
        }

        public final void trackCriticalInfoError(int i, String str, Object obj) {
            Pair[] pairArr = new Pair[3];
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            sb.append(str2);
            sb.append(i);
            pairArr[0] = TuplesKt.m42317to("type", sb.toString());
            if (str == null) {
                str = str2;
            }
            pairArr[1] = TuplesKt.m42317to(TrackConst.Params.EXPRESSION, str);
            String obj2 = obj != null ? obj.toString() : null;
            if (obj2 != null) {
                str2 = obj2;
            }
            pairArr[2] = TuplesKt.m42317to("result", str2);
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
            if (tracker != null) {
                tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_EXPRESSION_COMPONENT_CRITICAL_INFO_ERROR, mutableMapOf);
            }
        }
    }
}
