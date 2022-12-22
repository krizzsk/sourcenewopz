package com.cardinalcommerce.p060a;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

/* renamed from: com.cardinalcommerce.a.McElieceCCA2KeyFactorySpi */
public final class McElieceCCA2KeyFactorySpi extends BasicPermission {
    private final int cca_continue;
    private final String init;

    public McElieceCCA2KeyFactorySpi(String str, String str2) {
        super(str, str2);
        this.init = str2;
        this.cca_continue = configure(str2);
    }

    private static int configure(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(setAnimation.getInstance(str), " ,");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("threadlocalecimplicitlyca")) {
                i |= 1;
            } else if (nextToken.equals("ecimplicitlyca")) {
                i |= 2;
            } else if (nextToken.equals("threadlocaldhdefaultparams")) {
                i |= 4;
            } else if (nextToken.equals("dhdefaultparams")) {
                i |= 8;
            } else if (nextToken.equals("acceptableeccurves")) {
                i |= 16;
            } else if (nextToken.equals("additionalecparameters")) {
                i |= 32;
            } else if (nextToken.equals("all")) {
                i |= 63;
            }
        }
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof McElieceCCA2KeyFactorySpi) {
            McElieceCCA2KeyFactorySpi mcElieceCCA2KeyFactorySpi = (McElieceCCA2KeyFactorySpi) obj;
            return this.cca_continue == mcElieceCCA2KeyFactorySpi.cca_continue && getName().equals(mcElieceCCA2KeyFactorySpi.getName());
        }
    }

    public final String getActions() {
        return this.init;
    }

    public final int hashCode() {
        return getName().hashCode() + this.cca_continue;
    }

    public final boolean implies(Permission permission) {
        if (!(permission instanceof McElieceCCA2KeyFactorySpi) || !getName().equals(permission.getName())) {
            return false;
        }
        int i = this.cca_continue;
        int i2 = ((McElieceCCA2KeyFactorySpi) permission).cca_continue;
        return (i & i2) == i2;
    }
}
