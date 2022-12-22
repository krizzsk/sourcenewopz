package com.didi.jacoco.runtime.activity;

import com.didi.jacoco.runtime.module.role.Data;
import kotlin.Metadata;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ChooseRoleActivity.kt */
final /* synthetic */ class ChooseRoleActivity$initView$1 extends MutablePropertyReference0 {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-668800676085206289L, "com/didi/jacoco/runtime/activity/ChooseRoleActivity$initView$1", 8);
        $jacocoData = probes;
        return probes;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseRoleActivity$initView$1(ChooseRoleActivity chooseRoleActivity) {
        super(chooseRoleActivity);
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public String getName() {
        $jacocoInit()[1] = true;
        return "roleData";
    }

    public KDeclarationContainer getOwner() {
        boolean[] $jacocoInit = $jacocoInit();
        KClass orCreateKotlinClass = C21490Reflection.getOrCreateKotlinClass(ChooseRoleActivity.class);
        $jacocoInit[3] = true;
        return orCreateKotlinClass;
    }

    public String getSignature() {
        $jacocoInit()[2] = true;
        return "getRoleData()Lcom/didi/jacoco/runtime/module/role/Data;";
    }

    public Object get() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[4] = true;
        Data access$getRoleData$p = ChooseRoleActivity.access$getRoleData$p((ChooseRoleActivity) this.receiver);
        $jacocoInit[5] = true;
        return access$getRoleData$p;
    }

    public void set(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[6] = true;
        ChooseRoleActivity.access$setRoleData$p((ChooseRoleActivity) this.receiver, (Data) obj);
        $jacocoInit[7] = true;
    }
}
