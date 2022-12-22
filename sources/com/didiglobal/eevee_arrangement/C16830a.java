package com.didiglobal.eevee_arrangement;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.annotation.AnnotationUtil;
import com.didi.component.never.core.node.Node;
import com.didi.xengine.register.XERegister;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.common.event.BaseEventKeys;
import com.didiglobal.common.common.never.component.EeveeCompPresenterImpl;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/* renamed from: com.didiglobal.eevee_arrangement.a */
/* compiled from: EeveeArrangementPresenter */
class C16830a extends EeveeCompPresenterImpl<EeveeIView> {

    /* renamed from: a */
    private String f50100a;

    /* renamed from: b */
    private String f50101b;

    /* renamed from: c */
    private XEResponseCallback f50102c = new EeveeArrangementPresenter$1(this);

    public C16830a(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f50101b = "bus";
        XERegister.registerTemplate(new XERegisterModel(ComponentType.COMP_ARRANGEMENT, "eevee", this.f50102c));
    }

    public void onPageStart() {
        super.onPageStart();
        if ("eevee".equals(m36096a())) {
            m36097a(this.mContext);
        }
    }

    public void onPageResume() {
        super.onPageResume();
    }

    public void onNodeChanged(Node node) {
        XERegister.updateScene(ComponentType.COMP_ARRANGEMENT, getNodeEeveeID());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36099a(JsonObject jsonObject) {
        JsonObject asObject;
        if (jsonObject != null && (asObject = XEParserUtil.getAsObject("data", jsonObject)) != null) {
            m36100a(this.f50101b, asObject);
        }
    }

    /* renamed from: a */
    private void m36097a(Context context) {
        JsonObject asJsonObject;
        JsonObject asObject;
        try {
            String b = m36101b(context);
            if (b != null && (asJsonObject = new JsonParser().parse(b).getAsJsonObject()) != null && (asObject = XEParserUtil.getAsObject("data", asJsonObject)) != null) {
                m36100a(this.f50101b, asObject);
                doPublish(BaseEventKeys.Common.COMP_ARRANGEMENT_READY, m36096a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m36096a() {
        return getNodeEeveeID() == null ? AnnotationUtil.getNodeId(getNodeParent().getClass()) : getNodeEeveeID();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m36101b(android.content.Context r6) {
        /*
            r5 = this;
            r0 = 0
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ IOException -> 0x0033, all -> 0x002e }
            java.lang.String r1 = "pre_arrangement"
            java.io.InputStream r6 = r6.open(r1)     // Catch:{ IOException -> 0x0033, all -> 0x002e }
            int r1 = r6.available()     // Catch:{ IOException -> 0x002c }
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x002c }
            r6.read(r1)     // Catch:{ IOException -> 0x002c }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x002c }
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x002c }
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x002c }
            if (r6 == 0) goto L_0x002b
            com.didi.component.never.core.node.Node r0 = r5.getNodeParent()
            com.didi.component.never.core.node.NodeManager r0 = r0.getNodeManager()
            r0.getHostPage()
            r6.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            return r2
        L_0x002c:
            r1 = move-exception
            goto L_0x0035
        L_0x002e:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x004a
        L_0x0033:
            r1 = move-exception
            r6 = r0
        L_0x0035:
            r1.printStackTrace()     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x0048
            com.didi.component.never.core.node.Node r1 = r5.getNodeParent()
            com.didi.component.never.core.node.NodeManager r1 = r1.getNodeManager()
            r1.getHostPage()
            r6.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            return r0
        L_0x0049:
            r0 = move-exception
        L_0x004a:
            if (r6 == 0) goto L_0x005a
            com.didi.component.never.core.node.Node r1 = r5.getNodeParent()
            com.didi.component.never.core.node.NodeManager r1 = r1.getNodeManager()
            r1.getHostPage()
            r6.close()     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.eevee_arrangement.C16830a.m36101b(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m36100a(java.lang.String r3, com.google.gson.JsonObject r4) {
        /*
            r2 = this;
            com.didiglobal.common.business.arrangement.model.EeveeArrangementModel r4 = com.didiglobal.eevee_arrangement.EeveeArrangementParser.arrangementParse(r4)
            if (r4 == 0) goto L_0x0027
            java.util.List<com.didiglobal.common.business.arrangement.model.EeveeArrangementArrayItem> r0 = r4.eeveeData
            if (r0 == 0) goto L_0x0027
            java.util.List<com.didiglobal.common.business.arrangement.model.EeveeArrangementArrayItem> r4 = r4.eeveeData
            java.util.Iterator r4 = r4.iterator()
        L_0x0010:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r4.next()
            com.didiglobal.common.business.arrangement.model.EeveeArrangementArrayItem r0 = (com.didiglobal.common.business.arrangement.model.EeveeArrangementArrayItem) r0
            if (r0 == 0) goto L_0x0010
            java.lang.String r1 = r0.groupType
            boolean r1 = android.text.TextUtils.equals(r1, r3)
            if (r1 == 0) goto L_0x0010
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0036
            com.didiglobal.common.business.arrangement.model.EeveeArrangementBizConfig r3 = r0.bizConfig
            com.didiglobal.common.business.arrangement.ArrangementUtil.setConfig(r3)
            java.util.Map r3 = com.didiglobal.eevee_arrangement.EeveeArrangementParser.convertMap(r0)
            com.didiglobal.common.business.arrangement.ArrangementUtil.putArrangementMap(r3)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.eevee_arrangement.C16830a.m36100a(java.lang.String, com.google.gson.JsonObject):void");
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMP_ARRANGEMENT);
    }
}
