package com.didi.map.global.flow.model;

public final class EtaEda {
    public int eda;
    public int eta;

    public EtaEda(int i, int i2) {
        this.eta = i;
        this.eda = i2;
    }

    public EtaEda(EtaEda etaEda) {
        this.eta = etaEda.eta;
        this.eda = etaEda.eda;
    }

    public boolean checkVaild() {
        return this.eta >= 0 && this.eda >= 0;
    }

    public String toString() {
        return "eta=" + this.eta + " eda=" + this.eda;
    }
}
