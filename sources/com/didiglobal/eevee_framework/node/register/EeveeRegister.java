package com.didiglobal.eevee_framework.node.register;

import com.didi.component_processor.annonation.ModuleMap;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.business.constant.NodeId;
import com.didiglobal.e_container.home.HomeContainerComponent;
import com.didiglobal.e_where2go.EWhere2goComponent;
import com.didiglobal.eevee.comp.config.EConfigComponent;
import com.didiglobal.eevee.comp.sug.ESugComponent;
import com.didiglobal.eevee.mew.EMewComponent;
import com.didiglobal.eevee.mew.widget.titlebar.EeveeTopBarComponent;
import com.didiglobal.eevee.xengine.GlobalXEngineComponent;
import com.didiglobal.eevee_arrangement.EeveeArrangementComponent;
import com.didiglobal.eevee_framework.node.biz_entrance.BizEntranceNode;
import com.didiglobal.eevee_framework.node.eevee.impl.EeveePushNode;
import com.didiglobal.eevee_framework.node.eevee.impl.EeveeSwitchNode;
import com.didiglobal.eevee_framework.node.eevee_launch.EeveeLaunchNode;

public class EeveeRegister {

    public enum RegisterType {
        NODE,
        CONTAINER,
        COMPONENT
    }

    public static void register() {
        m36104a();
        m36105b();
        m36106c();
    }

    /* renamed from: a */
    private static void m36104a() {
        ModuleMap.addNode(NodeId.NODE_EEVEE_LAUNCH, BizEntranceNode.class);
        ModuleMap.addNode("eevee", EeveeLaunchNode.class);
        ModuleMap.addNode(NodeId.NODE_EEVEE_SWITCH, EeveeSwitchNode.class);
        ModuleMap.addNode(NodeId.NODE_EEVEE_PUSH, EeveePushNode.class);
    }

    /* renamed from: b */
    private static void m36105b() {
        ModuleMap.addStandard(ComponentType.XENGINE, GlobalXEngineComponent.class);
        ModuleMap.addStandard(ComponentType.COMP_TOP_BAR, EeveeTopBarComponent.class);
        ModuleMap.addStandard(ComponentType.COMP_ARRANGEMENT, EeveeArrangementComponent.class);
        ModuleMap.addStandard(ComponentType.COMP_MEW, EMewComponent.class);
        ModuleMap.addStandard(ComponentType.COMP_WHERE2GO, EWhere2goComponent.class);
        ModuleMap.addStandard(ComponentType.COMP_SUG, ESugComponent.class);
        ModuleMap.addStandard(ComponentType.COMP_CONFIG, EConfigComponent.class);
    }

    /* renamed from: c */
    private static void m36106c() {
        ModuleMap.addContainer(ComponentType.CONTAINER_HOME, HomeContainerComponent.class);
    }

    /* renamed from: com.didiglobal.eevee_framework.node.register.EeveeRegister$1 */
    static /* synthetic */ class C168541 {

        /* renamed from: $SwitchMap$com$didiglobal$eevee_framework$node$register$EeveeRegister$RegisterType */
        static final /* synthetic */ int[] f50105xc21b38ea;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didiglobal.eevee_framework.node.register.EeveeRegister$RegisterType[] r0 = com.didiglobal.eevee_framework.node.register.EeveeRegister.RegisterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50105xc21b38ea = r0
                com.didiglobal.eevee_framework.node.register.EeveeRegister$RegisterType r1 = com.didiglobal.eevee_framework.node.register.EeveeRegister.RegisterType.NODE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50105xc21b38ea     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didiglobal.eevee_framework.node.register.EeveeRegister$RegisterType r1 = com.didiglobal.eevee_framework.node.register.EeveeRegister.RegisterType.COMPONENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50105xc21b38ea     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didiglobal.eevee_framework.node.register.EeveeRegister$RegisterType r1 = com.didiglobal.eevee_framework.node.register.EeveeRegister.RegisterType.CONTAINER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.eevee_framework.node.register.EeveeRegister.C168541.<clinit>():void");
        }
    }

    public static void register(RegisterType registerType, String str, Class<?> cls) {
        int i = C168541.f50105xc21b38ea[registerType.ordinal()];
        if (i == 1) {
            ModuleMap.addNode(str, cls);
        } else if (i == 2) {
            ModuleMap.addStandard(str, cls);
        } else if (i == 3) {
            ModuleMap.addContainer(str, cls);
        }
    }
}
