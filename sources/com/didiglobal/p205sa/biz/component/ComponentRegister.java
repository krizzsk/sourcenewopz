package com.didiglobal.p205sa.biz.component;

import com.didi.component_processor.annonation.ModuleMap;
import com.didiglobal.p205sa.biz.component.activity.ActivityPanelComponent;
import com.didiglobal.p205sa.biz.component.bizcard.BizCardComponent;
import com.didiglobal.p205sa.biz.component.businesscard.BusinessCardComponent;
import com.didiglobal.p205sa.biz.component.container.SuperAppContainerComponent;
import com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideComponent;
import com.didiglobal.p205sa.biz.component.guide.GuideComponent;
import com.didiglobal.p205sa.biz.component.homemsg.HomeMsgComponent;
import com.didiglobal.p205sa.biz.component.interactivedialog.InteractiveDialogComponent;
import com.didiglobal.p205sa.biz.component.mapflow.MapFlowComponent;
import com.didiglobal.p205sa.biz.component.recommend.RecommendComponent;
import com.didiglobal.p205sa.biz.component.ridecard.RideCardComponent;
import com.didiglobal.p205sa.biz.component.safeToolKit.SAJarvisComponent;
import com.didiglobal.p205sa.biz.component.sapanel.SAPanelComponent;
import com.didiglobal.p205sa.biz.component.topbar.TopBarComponent;
import com.didiglobal.p205sa.biz.component.welcome.WelcomeComponent;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineComponent;
import com.didiglobal.p205sa.biz.node.NodeIds;
import com.didiglobal.p205sa.biz.node.SuperActivityNode;
import com.didiglobal.p205sa.biz.node.SuperAppNode;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/ComponentRegister;", "", "()V", "register", "", "registerComponent", "registerContainer", "registerNode", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.ComponentRegister */
/* compiled from: ComponentRegister.kt */
public final class ComponentRegister {
    public static final ComponentRegister INSTANCE = new ComponentRegister();

    private ComponentRegister() {
    }

    public final void register() {
        m36428a();
        m36429b();
        m36430c();
    }

    /* renamed from: a */
    private final void m36428a() {
        ModuleMap.addNode(NodeIds.NODE_SUPPER_APP, SuperAppNode.class);
        ModuleMap.addNode(NodeIds.NODE_SUPPER_ACTIVITY, SuperActivityNode.class);
    }

    /* renamed from: b */
    private final void m36429b() {
        ModuleMap.addStandard(ComponentType.COMPONENT_SAXEngine, SAXEngineComponent.class);
        ModuleMap.addStandard(ComponentType.COMPONENT_INTERACTIVIE_DIALOG, InteractiveDialogComponent.class);
        ModuleMap.addStandard("map_flow", MapFlowComponent.class);
        ModuleMap.addStandard(ComponentType.COMPONENT_TOP_BAR, TopBarComponent.class);
        ModuleMap.addStandard(ComponentType.COMPONENT_WELCOME, WelcomeComponent.class);
        ModuleMap.addStandard(ComponentType.COMPONENT_SA_XPANEL, SAPanelComponent.class);
        ModuleMap.addStandard(ComponentType.COMPONENT_SA_ACTIVITY_PANEL, ActivityPanelComponent.class);
        ModuleMap.addChild(ComponentType.COMPONENT_BUSINESS_CARD, BusinessCardComponent.class);
        ModuleMap.addChild(ComponentType.COMPONENT_SA_GUIDE, GuideComponent.class);
        ModuleMap.addChild(ComponentType.COMPONENT_DRAINAGE_GUIDE, SADrainageGuideComponent.class);
        ModuleMap.addChild(ComponentType.COMPONENT_RIDE_CARD, RideCardComponent.class);
        ModuleMap.addChild(ComponentType.COMPONENT_HOME_MSG, HomeMsgComponent.class);
        ModuleMap.addChild(ComponentType.COMPONENT_RECOMMEND, RecommendComponent.class);
        ModuleMap.addChild(ComponentType.COMPONENT_SA_SAFE_JARVIS, SAJarvisComponent.class);
        ModuleMap.addChild(ComponentType.COMPONENT_BIZ_CARD, BizCardComponent.class);
    }

    /* renamed from: c */
    private final void m36430c() {
        ModuleMap.addContainer(ComponentType.COMPONENT_CONTAINER, SuperAppContainerComponent.class);
    }
}
