package com.didi.jacoco.store.expand;

import com.didi.jacoco.p120ec.EcInfo;
import java.util.ArrayList;
import java.util.List;

public class EcInfoDataStore implements IEcInfoVisitor {
    private final List<EcInfo> infos = new ArrayList();

    public boolean isEmpty() {
        return this.infos.isEmpty();
    }

    public List<EcInfo> getInfos() {
        return new ArrayList(this.infos);
    }

    public void accept(IEcInfoVisitor iEcInfoVisitor) {
        for (EcInfo visitEcInfo : getInfos()) {
            iEcInfoVisitor.visitEcInfo(visitEcInfo);
        }
    }

    public void visitEcInfo(EcInfo ecInfo) {
        this.infos.add(ecInfo);
    }
}
