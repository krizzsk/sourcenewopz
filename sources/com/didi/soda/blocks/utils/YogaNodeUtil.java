package com.didi.soda.blocks.utils;

import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.style.BaseBinder;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class YogaNodeUtil {
    public static YogaNode createYogaNode() {
        if ((YogaNode.class.getModifiers() & 1024) != 0) {
            return YogaNodeFactory.create();
        }
        try {
            return YogaNode.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String blockTree2String(BaseBinder baseBinder) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name", baseBinder.getVirtualNode().getName());
        linkedHashMap.put("id", baseBinder.getVirtualNode().getId());
        linkedHashMap.put("content", new JsonParser().parse(yogaNode2String(baseBinder.getYogaNode())));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry value : baseBinder.getDynamicChildren().entrySet()) {
            arrayList.add(new JsonParser().parse(blockTree2String((BaseBinder) value.getValue())));
        }
        if (arrayList.size() > 0) {
            linkedHashMap.put("children", arrayList);
        }
        return new GsonBuilder().setPrettyPrinting().create().toJson((Object) linkedHashMap);
    }

    public static String tree2String(WidgetNodeModel widgetNodeModel) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("id", widgetNodeModel.getId());
        linkedHashMap.put("widget_hexString", widgetNodeModel.getWidget().getView().toString());
        linkedHashMap.put("yoga_data_widget_hexString", widgetNodeModel.getYogaNode().getData().toString());
        if (widgetNodeModel.getWidget() instanceof BaseBinder) {
            linkedHashMap.put("widget_yoga_node_hexString", ((BaseBinder) widgetNodeModel.getWidget()).getYogaNode().toString());
            linkedHashMap.put("yoga_node_hexString", widgetNodeModel.getYogaNode().toString());
            linkedHashMap.put("widget_block_node_hexString", ((BaseBinder) widgetNodeModel.getWidget()).getVirtualNode().toString());
            linkedHashMap.put("block_node_hexString", widgetNodeModel.toString());
        }
        linkedHashMap.put("widget_height", "" + widgetNodeModel.getWidget().getView().getHeight());
        linkedHashMap.put("yoga_height", "" + widgetNodeModel.getYogaNode().getHeight());
        linkedHashMap.put("widget_width", "" + widgetNodeModel.getWidget().getView().getWidth());
        linkedHashMap.put("yoga_width", "" + widgetNodeModel.getYogaNode().getWidth());
        linkedHashMap.put("widget_x", "" + widgetNodeModel.getWidget().getView().getX());
        linkedHashMap.put("yoga_x", "" + widgetNodeModel.getYogaNode().getLayoutX());
        linkedHashMap.put("widget_y", "" + widgetNodeModel.getWidget().getView().getY());
        linkedHashMap.put("yoga_y", "" + widgetNodeModel.getYogaNode().getLayoutY());
        HashMap hashMap = new HashMap();
        hashMap.put("yoga_node_hexString", widgetNodeModel.getYogaNode().toString());
        hashMap.put("yoga_node", new JsonParser().parse(yogaNode2String(widgetNodeModel.getYogaNode())));
        hashMap.put("yoga_node_layout", new JsonParser().parse(yogaNodeLayoutInfo2String(widgetNodeModel.getYogaNode())));
        hashMap.put("yoga_node_children_count", Integer.valueOf(widgetNodeModel.getYogaNode().getChildCount()));
        linkedHashMap.put("yoga_node", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("block_node_hexString", widgetNodeModel.toString());
        hashMap2.put("props", widgetNodeModel.getProps());
        hashMap2.put("styles", widgetNodeModel.getStyles());
        hashMap2.put("name", widgetNodeModel.getName());
        if (widgetNodeModel.getChildren() != null) {
            hashMap2.put("childrenCount", Integer.valueOf(widgetNodeModel.getChildren().size()));
        } else {
            hashMap2.put("childrenCount", 0);
        }
        linkedHashMap.put("block_node", hashMap2);
        ArrayList arrayList = new ArrayList();
        if (widgetNodeModel.getChildren() != null && widgetNodeModel.getChildren().size() > 0) {
            for (int i = 0; i < widgetNodeModel.getChildren().size(); i++) {
                arrayList.add(new JsonParser().parse(tree2String(widgetNodeModel.getChildren().get(i))));
            }
            if (arrayList.size() > 0) {
                linkedHashMap.put("children", arrayList);
            }
        }
        return new GsonBuilder().setPrettyPrinting().create().toJson((Object) linkedHashMap);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0071, code lost:
        r20 = com.didi.soda.blocks.constant.Const.YogaConst.YOGA_FLEX_DIRECTION;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0075, code lost:
        r21 = com.didi.soda.blocks.constant.Const.YogaConst.YOGA_ALIGN_CONTENT;
        r12 = r25;
        r26 = r22;
        r22 = com.didi.soda.blocks.constant.Const.YogaConst.YOGA_ALIGN_ITEMS;
        r2 = r23;
        r23 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0241, code lost:
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x024e, code lost:
        r19 = com.didi.soda.blocks.constant.Const.YogaConst.YOGA_DIRECTION;
        r15 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0261, code lost:
        r20 = com.didi.soda.blocks.constant.Const.YogaConst.YOGA_FLEX_DIRECTION;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0278, code lost:
        r21 = com.didi.soda.blocks.constant.Const.YogaConst.YOGA_ALIGN_CONTENT;
        r12 = r25;
        r26 = r22;
        r22 = com.didi.soda.blocks.constant.Const.YogaConst.YOGA_ALIGN_ITEMS;
        r2 = r23;
        r23 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02c0, code lost:
        r23 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02c3, code lost:
        r23 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02e6, code lost:
        r12 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02eb, code lost:
        r12 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x032c, code lost:
        r4 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x032d, code lost:
        switch(r4) {
            case 0: goto L_0x0928;
            case 1: goto L_0x0909;
            case 2: goto L_0x08ea;
            case 3: goto L_0x08cb;
            case 4: goto L_0x08ab;
            case 5: goto L_0x088b;
            case 6: goto L_0x086b;
            case 7: goto L_0x084b;
            case 8: goto L_0x082a;
            case 9: goto L_0x080a;
            case 10: goto L_0x07e9;
            case 11: goto L_0x07c9;
            case 12: goto L_0x07a9;
            case 13: goto L_0x0789;
            case 14: goto L_0x0767;
            case 15: goto L_0x0744;
            case 16: goto L_0x0721;
            case 17: goto L_0x06ff;
            case 18: goto L_0x06dc;
            case 19: goto L_0x06bc;
            case 20: goto L_0x0699;
            case 21: goto L_0x067a;
            case 22: goto L_0x065b;
            case 23: goto L_0x063a;
            case 24: goto L_0x061a;
            case 25: goto L_0x05f8;
            case 26: goto L_0x05d8;
            case 27: goto L_0x05b6;
            case 28: goto L_0x0596;
            case 29: goto L_0x0576;
            case 30: goto L_0x0554;
            case 31: goto L_0x0534;
            case 32: goto L_0x0514;
            case 33: goto L_0x04f1;
            case 34: goto L_0x04ce;
            case 35: goto L_0x04ab;
            case 36: goto L_0x0488;
            case 37: goto L_0x0465;
            case 38: goto L_0x0445;
            case 39: goto L_0x0422;
            case 40: goto L_0x0402;
            case 41: goto L_0x03e1;
            case 42: goto L_0x03c6;
            case 43: goto L_0x03a9;
            case 44: goto L_0x038e;
            case 45: goto L_0x0372;
            case 46: goto L_0x0354;
            case 47: goto L_0x0338;
            default: goto L_0x0330;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0330, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0338, code lost:
        r0 = new java.lang.StringBuilder();
        r4 = r18;
        r0.append(r4);
        r0.append(r27.getMaxHeight());
        r7 = r17;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.MAX_HEIGHT, r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0354, code lost:
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.MAX_WIDTH, r4 + r27.getMaxWidth());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0372, code lost:
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.MIN_HEIGHT, r4 + r27.getMinHeight());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x038e, code lost:
        r7 = r17;
        r4 = r18;
        r7.put(r5, r4 + r27.getMinWidth());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03a9, code lost:
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.ASPECT_RATIO, r4 + r27.getAspectRatio());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03c6, code lost:
        r7 = r17;
        r4 = r18;
        r7.put(r15, r4 + r27.getHeight());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03e1, code lost:
        r7 = r17;
        r4 = r18;
        r7.put("width", r4 + r27.getWidth());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03fe, code lost:
        r5 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0402, code lost:
        r7 = r17;
        r4 = r18;
        r0 = new java.lang.StringBuilder();
        r0.append(r4);
        r5 = r27;
        r0.append(r5.getPadding(com.facebook.yoga.YogaEdge.ALL));
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.PADDING_PADDING, r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0422, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.PADDING_VERTICAL, r4 + r5.getPadding(com.facebook.yoga.YogaEdge.VERTICAL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0445, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put("paddingHorizontal", r4 + r5.getPadding(com.facebook.yoga.YogaEdge.HORIZONTAL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0465, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.PADDING_END, r4 + r5.getPadding(com.facebook.yoga.YogaEdge.END));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0488, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.PADDING_START, r4 + r5.getPadding(com.facebook.yoga.YogaEdge.START));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x04ab, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put("paddingBottom", r4 + r5.getPadding(com.facebook.yoga.YogaEdge.BOTTOM));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04ce, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put("paddingRight", r4 + r5.getPadding(com.facebook.yoga.YogaEdge.RIGHT));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x04f1, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put("paddingTop", r4 + r5.getPadding(com.facebook.yoga.YogaEdge.TOP));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0514, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(r2, r4 + r5.getPadding(com.facebook.yoga.YogaEdge.LEFT));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0534, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(r6, r4 + r5.getMargin(com.facebook.yoga.YogaEdge.ALL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0554, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.MARGIN_VERTICAL, r4 + r5.getMargin(com.facebook.yoga.YogaEdge.VERTICAL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0576, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(r12, r4 + r5.getMargin(com.facebook.yoga.YogaEdge.HORIZONTAL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0596, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.MARGIN_END, r4 + r5.getMargin(com.facebook.yoga.YogaEdge.END));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x05b6, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.MARGIN_START, r4 + r5.getMargin(com.facebook.yoga.YogaEdge.START));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x05d8, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.MARGIN_BOTTOM, r4 + r5.getMargin(com.facebook.yoga.YogaEdge.BOTTOM));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x05f8, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put("marginRight", r4 + r5.getMargin(com.facebook.yoga.YogaEdge.RIGHT));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x061a, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put("marginTop", r4 + r5.getMargin(com.facebook.yoga.YogaEdge.TOP));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x063a, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put("marginLeft", r4 + r5.getMargin(com.facebook.yoga.YogaEdge.LEFT));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x065b, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put("all", r4 + r5.getPosition(com.facebook.yoga.YogaEdge.ALL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x067a, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.EDGE_VERTICAL, r4 + r5.getPosition(com.facebook.yoga.YogaEdge.VERTICAL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0699, code lost:
        r5 = r27;
        r7 = r17;
        r4 = r18;
        r7.put(com.didi.soda.blocks.constant.Const.YogaConst.EDGE_HORIZONTAL, r4 + r5.getPosition(com.facebook.yoga.YogaEdge.HORIZONTAL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x06b9, code lost:
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x06bc, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put("end", r4 + r5.getPosition(com.facebook.yoga.YogaEdge.END));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x06dc, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put("start", r4 + r5.getPosition(com.facebook.yoga.YogaEdge.START));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x06ff, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(r23, r4 + r5.getPosition(com.facebook.yoga.YogaEdge.BOTTOM));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0721, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put("right", r4 + r5.getPosition(com.facebook.yoga.YogaEdge.RIGHT));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0744, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put("top", r4 + r5.getPosition(com.facebook.yoga.YogaEdge.TOP));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0767, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put("left", r4 + r5.getPosition(com.facebook.yoga.YogaEdge.LEFT));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0789, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(r24, r4 + r27.getFlexBasis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x07a9, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(com.didi.soda.blocks.constant.Const.YogaConst.YOGA_FLEX_SHRINK, r4 + r27.getFlexShrink());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x07c9, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(com.didi.soda.blocks.constant.Const.YogaConst.YOGA_FLEX_GROW, r4 + r27.getFlexGrow());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x07e9, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(com.didi.soda.blocks.constant.Const.YogaConst.YOGA_OVERFLOW, r4 + r27.getOverflow());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x080a, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(com.didi.soda.blocks.constant.Const.YogaConst.YOGA_FLEX_WRAP, r4 + r27.getWrap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x082a, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put("position", r4 + r27.getPositionType());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x084b, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(com.didi.soda.blocks.constant.Const.YogaConst.YOGA_ALIGN_SELF, r4 + r27.getAlignSelf());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x086b, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(r22, r4 + r27.getAlignItems());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x088b, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(r21, r4 + r27.getAlignContent());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x08ab, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(com.didi.soda.blocks.constant.Const.YogaConst.YOGA_JUSTIFY_CONTENT, r4 + r27.getJustifyContent());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x08cb, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(r20, r4 + r27.getFlexDirection());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x08ea, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(r19, r4 + r27.getStyleDirection());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0909, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put(com.didi.soda.blocks.constant.Const.YogaConst.YOGA_FLEX, r4 + r27.getFlex());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0928, code lost:
        r5 = r27;
        r0 = r17;
        r4 = r18;
        r0.put("display", r4 + r27.getDisplay());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0946, code lost:
        r2 = r0;
        r1 = r4;
        r0 = r5;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x006b, code lost:
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006d, code lost:
        r19 = com.didi.soda.blocks.constant.Const.YogaConst.YOGA_DIRECTION;
        r15 = r20;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String yogaNode2String(com.facebook.yoga.YogaNode r27) {
        /*
            r0 = r27
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            return r1
        L_0x0007:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            com.didi.soda.blocks.style.ValueManager$Companion r3 = com.didi.soda.blocks.style.ValueManager.Companion
            java.util.List r3 = r3.getYOGA_STYLES()
            java.util.Iterator r3 = r3.iterator()
        L_0x0016:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x094d
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r4.hashCode()
            java.lang.String r7 = "end"
            java.lang.String r8 = "all"
            java.lang.String r9 = "minHeight"
            java.lang.String r10 = "marginBottom"
            java.lang.String r11 = "paddingHorizontal"
            java.lang.String r12 = "alignContent"
            java.lang.String r13 = "padding"
            java.lang.String r14 = "maxHeight"
            java.lang.String r15 = "direction"
            java.lang.String r5 = "flexDirection"
            r16 = r3
            java.lang.String r3 = "marginTop"
            java.lang.String r0 = "marginEnd"
            r17 = r2
            java.lang.String r2 = "alignItems"
            r18 = r1
            java.lang.String r1 = "margin"
            r19 = r1
            java.lang.String r1 = "height"
            r20 = r1
            java.lang.String r1 = "minWidth"
            r21 = r1
            java.lang.String r1 = "bottom"
            r22 = r1
            java.lang.String r1 = "paddingLeft"
            r23 = r1
            java.lang.String r1 = "flexBasis"
            r24 = r1
            java.lang.String r1 = "marginHorizontal"
            r25 = r1
            java.lang.String r1 = "vertical"
            switch(r6) {
                case -1984141450: goto L_0x030d;
                case -1906103182: goto L_0x02ee;
                case -1783760955: goto L_0x02c6;
                case -1501175880: goto L_0x02a6;
                case -1383228885: goto L_0x0286;
                case -1375815020: goto L_0x0266;
                case -1221029593: goto L_0x0253;
                case -1081309778: goto L_0x0244;
                case -1063257157: goto L_0x023a;
                case -1044806579: goto L_0x0231;
                case -1044792121: goto L_0x0228;
                case -975171706: goto L_0x0220;
                case -962590849: goto L_0x0218;
                case -906066005: goto L_0x020f;
                case -806339567: goto L_0x0206;
                case -752601676: goto L_0x01fe;
                case -359890155: goto L_0x01f5;
                case -289173127: goto L_0x01ec;
                case -133587431: goto L_0x01e3;
                case 96673: goto L_0x01d9;
                case 100571: goto L_0x01cf;
                case 115029: goto L_0x01c2;
                case 3145721: goto L_0x01b7;
                case 3317767: goto L_0x01ab;
                case 90115850: goto L_0x019e;
                case 90130308: goto L_0x0191;
                case 108511772: goto L_0x0184;
                case 109757538: goto L_0x0177;
                case 113126854: goto L_0x016a;
                case 202355100: goto L_0x015d;
                case 400381634: goto L_0x0151;
                case 529642498: goto L_0x0144;
                case 713848971: goto L_0x0137;
                case 715094737: goto L_0x012a;
                case 747804969: goto L_0x011d;
                case 975087886: goto L_0x0111;
                case 976333652: goto L_0x0105;
                case 1031115618: goto L_0x00f9;
                case 1092174483: goto L_0x00ed;
                case 1343645351: goto L_0x00e0;
                case 1387629604: goto L_0x00d4;
                case 1431421764: goto L_0x00c8;
                case 1671764162: goto L_0x00bd;
                case 1743739820: goto L_0x00b1;
                case 1744216035: goto L_0x00a5;
                case 1767100401: goto L_0x009a;
                case 1860657097: goto L_0x008f;
                case 1970934485: goto L_0x0083;
                default: goto L_0x006b;
            }
        L_0x006b:
            r6 = r19
        L_0x006d:
            r19 = r15
            r15 = r20
        L_0x0071:
            r20 = r5
            r5 = r21
        L_0x0075:
            r21 = r12
            r12 = r25
            r26 = r22
            r22 = r2
            r2 = r23
            r23 = r26
            goto L_0x032c
        L_0x0083:
            java.lang.String r6 = "marginLeft"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 23
            goto L_0x0241
        L_0x008f:
            java.lang.String r6 = "justifyContent"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 4
            goto L_0x0241
        L_0x009a:
            java.lang.String r6 = "alignSelf"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 7
            goto L_0x0241
        L_0x00a5:
            java.lang.String r6 = "flexWrap"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 9
            goto L_0x0241
        L_0x00b1:
            java.lang.String r6 = "flexGrow"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 11
            goto L_0x0241
        L_0x00bd:
            java.lang.String r6 = "display"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 0
            goto L_0x0241
        L_0x00c8:
            java.lang.String r6 = "marginVertical"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 30
            goto L_0x0241
        L_0x00d4:
            java.lang.String r6 = "horizontal"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 20
            goto L_0x0241
        L_0x00e0:
            java.lang.String r6 = "paddingVertical"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 39
            goto L_0x0241
        L_0x00ed:
            java.lang.String r6 = "aspectRatio"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 43
            goto L_0x0241
        L_0x00f9:
            java.lang.String r6 = "flexShrink"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 12
            goto L_0x0241
        L_0x0105:
            java.lang.String r6 = "marginStart"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 27
            goto L_0x0241
        L_0x0111:
            java.lang.String r6 = "marginRight"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 25
            goto L_0x0241
        L_0x011d:
            java.lang.String r6 = "position"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 8
            goto L_0x0241
        L_0x012a:
            java.lang.String r6 = "paddingStart"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 36
            goto L_0x0241
        L_0x0137:
            java.lang.String r6 = "paddingRight"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 34
            goto L_0x0241
        L_0x0144:
            java.lang.String r6 = "overflow"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 10
            goto L_0x0241
        L_0x0151:
            java.lang.String r6 = "maxWidth"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 46
            goto L_0x0241
        L_0x015d:
            java.lang.String r6 = "paddingBottom"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 35
            goto L_0x0241
        L_0x016a:
            java.lang.String r6 = "width"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 41
            goto L_0x0241
        L_0x0177:
            java.lang.String r6 = "start"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 18
            goto L_0x0241
        L_0x0184:
            java.lang.String r6 = "right"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 16
            goto L_0x0241
        L_0x0191:
            java.lang.String r6 = "paddingTop"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 33
            goto L_0x0241
        L_0x019e:
            java.lang.String r6 = "paddingEnd"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 37
            goto L_0x0241
        L_0x01ab:
            java.lang.String r6 = "left"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 14
            goto L_0x0241
        L_0x01b7:
            java.lang.String r6 = "flex"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 1
            goto L_0x0241
        L_0x01c2:
            java.lang.String r6 = "top"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006b
            r4 = 15
            goto L_0x0241
        L_0x01cf:
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x006b
            r4 = 19
            goto L_0x0241
        L_0x01d9:
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x006b
            r4 = 22
            goto L_0x0241
        L_0x01e3:
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L_0x006b
            r4 = 45
            goto L_0x0241
        L_0x01ec:
            boolean r4 = r4.equals(r10)
            if (r4 == 0) goto L_0x006b
            r4 = 26
            goto L_0x0241
        L_0x01f5:
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x006b
            r4 = 38
            goto L_0x0241
        L_0x01fe:
            boolean r4 = r4.equals(r12)
            if (r4 == 0) goto L_0x006b
            r4 = 5
            goto L_0x0241
        L_0x0206:
            boolean r4 = r4.equals(r13)
            if (r4 == 0) goto L_0x006b
            r4 = 40
            goto L_0x0241
        L_0x020f:
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x006b
            r4 = 47
            goto L_0x0241
        L_0x0218:
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x006b
            r4 = 2
            goto L_0x0241
        L_0x0220:
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x006b
            r4 = 3
            goto L_0x0241
        L_0x0228:
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x006b
            r4 = 24
            goto L_0x0241
        L_0x0231:
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x006b
            r4 = 28
            goto L_0x0241
        L_0x023a:
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x006b
            r4 = 6
        L_0x0241:
            r6 = r19
            goto L_0x024e
        L_0x0244:
            r6 = r19
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006d
            r4 = 31
        L_0x024e:
            r19 = r15
            r15 = r20
            goto L_0x0261
        L_0x0253:
            r6 = r19
            r19 = r15
            r15 = r20
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x0071
            r4 = 42
        L_0x0261:
            r20 = r5
            r5 = r21
            goto L_0x0278
        L_0x0266:
            r6 = r19
            r19 = r15
            r15 = r20
            r20 = r5
            r5 = r21
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0075
            r4 = 44
        L_0x0278:
            r21 = r12
            r12 = r25
            r26 = r22
            r22 = r2
            r2 = r23
            r23 = r26
            goto L_0x032d
        L_0x0286:
            r6 = r19
            r19 = r15
            r15 = r20
            r20 = r5
            r5 = r21
            r21 = r12
            r12 = r22
            boolean r4 = r4.equals(r12)
            if (r4 == 0) goto L_0x02a1
            r4 = 17
            r22 = r2
            r2 = r23
            goto L_0x02c0
        L_0x02a1:
            r22 = r2
            r2 = r23
            goto L_0x02c3
        L_0x02a6:
            r6 = r19
            r19 = r15
            r15 = r20
            r20 = r5
            r5 = r21
            r21 = r12
            r12 = r22
            r22 = r2
            r2 = r23
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x02c3
            r4 = 32
        L_0x02c0:
            r23 = r12
            goto L_0x02e6
        L_0x02c3:
            r23 = r12
            goto L_0x02eb
        L_0x02c6:
            r6 = r19
            r19 = r15
            r15 = r20
            r20 = r5
            r5 = r21
            r21 = r12
            r12 = r24
            r26 = r22
            r22 = r2
            r2 = r23
            r23 = r26
            boolean r4 = r4.equals(r12)
            if (r4 == 0) goto L_0x02e9
            r4 = 13
            r24 = r12
        L_0x02e6:
            r12 = r25
            goto L_0x032d
        L_0x02e9:
            r24 = r12
        L_0x02eb:
            r12 = r25
            goto L_0x032c
        L_0x02ee:
            r6 = r19
            r19 = r15
            r15 = r20
            r20 = r5
            r5 = r21
            r21 = r12
            r12 = r25
            r26 = r22
            r22 = r2
            r2 = r23
            r23 = r26
            boolean r4 = r4.equals(r12)
            if (r4 == 0) goto L_0x032c
            r4 = 29
            goto L_0x032d
        L_0x030d:
            r6 = r19
            r19 = r15
            r15 = r20
            r20 = r5
            r5 = r21
            r21 = r12
            r12 = r25
            r26 = r22
            r22 = r2
            r2 = r23
            r23 = r26
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x032c
            r4 = 21
            goto L_0x032d
        L_0x032c:
            r4 = -1
        L_0x032d:
            switch(r4) {
                case 0: goto L_0x0928;
                case 1: goto L_0x0909;
                case 2: goto L_0x08ea;
                case 3: goto L_0x08cb;
                case 4: goto L_0x08ab;
                case 5: goto L_0x088b;
                case 6: goto L_0x086b;
                case 7: goto L_0x084b;
                case 8: goto L_0x082a;
                case 9: goto L_0x080a;
                case 10: goto L_0x07e9;
                case 11: goto L_0x07c9;
                case 12: goto L_0x07a9;
                case 13: goto L_0x0789;
                case 14: goto L_0x0767;
                case 15: goto L_0x0744;
                case 16: goto L_0x0721;
                case 17: goto L_0x06ff;
                case 18: goto L_0x06dc;
                case 19: goto L_0x06bc;
                case 20: goto L_0x0699;
                case 21: goto L_0x067a;
                case 22: goto L_0x065b;
                case 23: goto L_0x063a;
                case 24: goto L_0x061a;
                case 25: goto L_0x05f8;
                case 26: goto L_0x05d8;
                case 27: goto L_0x05b6;
                case 28: goto L_0x0596;
                case 29: goto L_0x0576;
                case 30: goto L_0x0554;
                case 31: goto L_0x0534;
                case 32: goto L_0x0514;
                case 33: goto L_0x04f1;
                case 34: goto L_0x04ce;
                case 35: goto L_0x04ab;
                case 36: goto L_0x0488;
                case 37: goto L_0x0465;
                case 38: goto L_0x0445;
                case 39: goto L_0x0422;
                case 40: goto L_0x0402;
                case 41: goto L_0x03e1;
                case 42: goto L_0x03c6;
                case 43: goto L_0x03a9;
                case 44: goto L_0x038e;
                case 45: goto L_0x0372;
                case 46: goto L_0x0354;
                case 47: goto L_0x0338;
                default: goto L_0x0330;
            }
        L_0x0330:
            r5 = r27
            r0 = r17
            r4 = r18
            goto L_0x0946
        L_0x0338:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r4 = r18
            r0.append(r4)
            com.facebook.yoga.YogaValue r1 = r27.getMaxHeight()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7 = r17
            r7.put(r14, r0)
            goto L_0x03fe
        L_0x0354:
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaValue r1 = r27.getMaxWidth()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "maxWidth"
            r7.put(r1, r0)
            goto L_0x03fe
        L_0x0372:
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaValue r1 = r27.getMinHeight()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r9, r0)
            goto L_0x03fe
        L_0x038e:
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaValue r1 = r27.getMinWidth()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r5, r0)
            goto L_0x03fe
        L_0x03a9:
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            float r1 = r27.getAspectRatio()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "aspectRatio"
            r7.put(r1, r0)
            goto L_0x03fe
        L_0x03c6:
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaValue r1 = r27.getHeight()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r15, r0)
            goto L_0x03fe
        L_0x03e1:
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaValue r1 = r27.getWidth()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "width"
            r7.put(r1, r0)
        L_0x03fe:
            r5 = r27
            goto L_0x06b9
        L_0x0402:
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.ALL
            r5 = r27
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r13, r0)
            goto L_0x06b9
        L_0x0422:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.VERTICAL
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "paddingVertical"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x0445:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.HORIZONTAL
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r11, r0)
            goto L_0x06b9
        L_0x0465:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.END
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "paddingEnd"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x0488:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.START
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "paddingStart"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x04ab:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.BOTTOM
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "paddingBottom"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x04ce:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.RIGHT
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "paddingRight"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x04f1:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.TOP
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "paddingTop"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x0514:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.LEFT
            com.facebook.yoga.YogaValue r1 = r5.getPadding(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r2, r0)
            goto L_0x06b9
        L_0x0534:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.ALL
            com.facebook.yoga.YogaValue r1 = r5.getMargin(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r6, r0)
            goto L_0x06b9
        L_0x0554:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.VERTICAL
            com.facebook.yoga.YogaValue r1 = r5.getMargin(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "marginVertical"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x0576:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.HORIZONTAL
            com.facebook.yoga.YogaValue r1 = r5.getMargin(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r12, r0)
            goto L_0x06b9
        L_0x0596:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.END
            com.facebook.yoga.YogaValue r2 = r5.getMargin(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r7.put(r0, r1)
            goto L_0x06b9
        L_0x05b6:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.START
            com.facebook.yoga.YogaValue r1 = r5.getMargin(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "marginStart"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x05d8:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.BOTTOM
            com.facebook.yoga.YogaValue r1 = r5.getMargin(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r10, r0)
            goto L_0x06b9
        L_0x05f8:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.RIGHT
            com.facebook.yoga.YogaValue r1 = r5.getMargin(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "marginRight"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x061a:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.TOP
            com.facebook.yoga.YogaValue r1 = r5.getMargin(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r3, r0)
            goto L_0x06b9
        L_0x063a:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.LEFT
            com.facebook.yoga.YogaValue r1 = r5.getMargin(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "marginLeft"
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x065b:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.ALL
            com.facebook.yoga.YogaValue r1 = r5.getPosition(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.put(r8, r0)
            goto L_0x06b9
        L_0x067a:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.VERTICAL
            com.facebook.yoga.YogaValue r2 = r5.getPosition(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r7.put(r1, r0)
            goto L_0x06b9
        L_0x0699:
            r5 = r27
            r7 = r17
            r4 = r18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.HORIZONTAL
            com.facebook.yoga.YogaValue r1 = r5.getPosition(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "horizontal"
            r7.put(r1, r0)
        L_0x06b9:
            r0 = r7
            goto L_0x0946
        L_0x06bc:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.END
            com.facebook.yoga.YogaValue r2 = r5.getPosition(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.put(r7, r1)
            goto L_0x0946
        L_0x06dc:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.START
            com.facebook.yoga.YogaValue r2 = r5.getPosition(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "start"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x06ff:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.BOTTOM
            com.facebook.yoga.YogaValue r2 = r5.getPosition(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = r23
            r0.put(r2, r1)
            goto L_0x0946
        L_0x0721:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.RIGHT
            com.facebook.yoga.YogaValue r2 = r5.getPosition(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "right"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x0744:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.TOP
            com.facebook.yoga.YogaValue r2 = r5.getPosition(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "top"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x0767:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.LEFT
            com.facebook.yoga.YogaValue r2 = r5.getPosition(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "left"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x0789:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaValue r2 = r27.getFlexBasis()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = r24
            r0.put(r2, r1)
            goto L_0x0946
        L_0x07a9:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            float r2 = r27.getFlexShrink()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "flexShrink"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x07c9:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            float r2 = r27.getFlexGrow()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "flexGrow"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x07e9:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaOverflow r2 = r27.getOverflow()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "overflow"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x080a:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaWrap r2 = r27.getWrap()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "flexWrap"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x082a:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaPositionType r2 = r27.getPositionType()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "position"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x084b:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaAlign r2 = r27.getAlignSelf()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "alignSelf"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x086b:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaAlign r2 = r27.getAlignItems()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = r22
            r0.put(r2, r1)
            goto L_0x0946
        L_0x088b:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaAlign r2 = r27.getAlignContent()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = r21
            r0.put(r2, r1)
            goto L_0x0946
        L_0x08ab:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaJustify r2 = r27.getJustifyContent()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "justifyContent"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x08cb:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaFlexDirection r2 = r27.getFlexDirection()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = r20
            r0.put(r2, r1)
            goto L_0x0946
        L_0x08ea:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaDirection r2 = r27.getStyleDirection()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = r19
            r0.put(r2, r1)
            goto L_0x0946
        L_0x0909:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            float r2 = r27.getFlex()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "flex"
            r0.put(r2, r1)
            goto L_0x0946
        L_0x0928:
            r5 = r27
            r0 = r17
            r4 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.facebook.yoga.YogaDisplay r2 = r27.getDisplay()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "display"
            r0.put(r2, r1)
        L_0x0946:
            r2 = r0
            r1 = r4
            r0 = r5
            r3 = r16
            goto L_0x0016
        L_0x094d:
            r0 = r2
            com.google.gson.GsonBuilder r1 = new com.google.gson.GsonBuilder
            r1.<init>()
            com.google.gson.GsonBuilder r1 = r1.setPrettyPrinting()
            com.google.gson.Gson r1 = r1.create()
            java.lang.String r0 = r1.toJson((java.lang.Object) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.utils.YogaNodeUtil.yogaNode2String(com.facebook.yoga.YogaNode):java.lang.String");
    }

    public static String yogaNodeLayoutInfo2String(YogaNode yogaNode) {
        if (yogaNode == null) {
            return "";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("layout_X", "" + yogaNode.getLayoutX());
        linkedHashMap.put("layout_Y", "" + yogaNode.getLayoutY());
        linkedHashMap.put("layout_Width", "" + yogaNode.getLayoutWidth());
        linkedHashMap.put("layout_Height", "" + yogaNode.getLayoutHeight());
        linkedHashMap.put("layout_Direction", "" + yogaNode.getLayoutDirection());
        linkedHashMap.put("layout_Margin_Left", "" + yogaNode.getLayoutMargin(YogaEdge.LEFT));
        linkedHashMap.put("layout_Margin_Right", "" + yogaNode.getLayoutMargin(YogaEdge.RIGHT));
        linkedHashMap.put("layout_Margin_Top", "" + yogaNode.getLayoutMargin(YogaEdge.TOP));
        linkedHashMap.put("layout_Margin_BOTTOM", "" + yogaNode.getLayoutMargin(YogaEdge.BOTTOM));
        linkedHashMap.put("layout_Padding_Left", "" + yogaNode.getLayoutPadding(YogaEdge.LEFT));
        linkedHashMap.put("layout_Padding_Right", "" + yogaNode.getLayoutPadding(YogaEdge.RIGHT));
        linkedHashMap.put("layout_Padding_Top", "" + yogaNode.getLayoutPadding(YogaEdge.TOP));
        linkedHashMap.put("layout_Padding_BOTTOM", "" + yogaNode.getLayoutPadding(YogaEdge.BOTTOM));
        return new GsonBuilder().setPrettyPrinting().create().toJson((Object) linkedHashMap);
    }
}
