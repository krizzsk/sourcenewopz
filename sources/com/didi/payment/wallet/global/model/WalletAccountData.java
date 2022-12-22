package com.didi.payment.wallet.global.model;

import com.didi.payment.base.service.IWalletService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\nHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006)"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/model/WalletAccountData;", "Ljava/io/Serializable;", "status", "", "fullKycStatus", "supportFullKyc", "", "accountStatus", "Lcom/didi/payment/base/service/IWalletService$AccountInfo;", "authenticationStatus", "", "(IIZLcom/didi/payment/base/service/IWalletService$AccountInfo;Ljava/lang/String;)V", "getAccountStatus", "()Lcom/didi/payment/base/service/IWalletService$AccountInfo;", "setAccountStatus", "(Lcom/didi/payment/base/service/IWalletService$AccountInfo;)V", "getAuthenticationStatus", "()Ljava/lang/String;", "setAuthenticationStatus", "(Ljava/lang/String;)V", "getFullKycStatus", "()I", "setFullKycStatus", "(I)V", "getStatus", "setStatus", "getSupportFullKyc", "()Z", "setSupportFullKyc", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletAccountData.kt */
public final class WalletAccountData implements Serializable {
    private IWalletService.AccountInfo accountStatus;
    private String authenticationStatus;
    private int fullKycStatus;
    private int status;
    private boolean supportFullKyc;

    public WalletAccountData() {
        this(0, 0, false, (IWalletService.AccountInfo) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WalletAccountData copy$default(WalletAccountData walletAccountData, int i, int i2, boolean z, IWalletService.AccountInfo accountInfo, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = walletAccountData.status;
        }
        if ((i3 & 2) != 0) {
            i2 = walletAccountData.fullKycStatus;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            z = walletAccountData.supportFullKyc;
        }
        boolean z2 = z;
        if ((i3 & 8) != 0) {
            accountInfo = walletAccountData.accountStatus;
        }
        IWalletService.AccountInfo accountInfo2 = accountInfo;
        if ((i3 & 16) != 0) {
            str = walletAccountData.authenticationStatus;
        }
        return walletAccountData.copy(i, i4, z2, accountInfo2, str);
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.fullKycStatus;
    }

    public final boolean component3() {
        return this.supportFullKyc;
    }

    public final IWalletService.AccountInfo component4() {
        return this.accountStatus;
    }

    public final String component5() {
        return this.authenticationStatus;
    }

    public final WalletAccountData copy(int i, int i2, boolean z, IWalletService.AccountInfo accountInfo, String str) {
        return new WalletAccountData(i, i2, z, accountInfo, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletAccountData)) {
            return false;
        }
        WalletAccountData walletAccountData = (WalletAccountData) obj;
        return this.status == walletAccountData.status && this.fullKycStatus == walletAccountData.fullKycStatus && this.supportFullKyc == walletAccountData.supportFullKyc && Intrinsics.areEqual((Object) this.accountStatus, (Object) walletAccountData.accountStatus) && Intrinsics.areEqual((Object) this.authenticationStatus, (Object) walletAccountData.authenticationStatus);
    }

    public int hashCode() {
        int i = ((this.status * 31) + this.fullKycStatus) * 31;
        boolean z = this.supportFullKyc;
        if (z) {
            z = true;
        }
        int i2 = (i + (z ? 1 : 0)) * 31;
        IWalletService.AccountInfo accountInfo = this.accountStatus;
        int i3 = 0;
        int hashCode = (i2 + (accountInfo == null ? 0 : accountInfo.hashCode())) * 31;
        String str = this.authenticationStatus;
        if (str != null) {
            i3 = str.hashCode();
        }
        return hashCode + i3;
    }

    public String toString() {
        return "WalletAccountData(status=" + this.status + ", fullKycStatus=" + this.fullKycStatus + ", supportFullKyc=" + this.supportFullKyc + ", accountStatus=" + this.accountStatus + ", authenticationStatus=" + this.authenticationStatus + VersionRange.RIGHT_OPEN;
    }

    public WalletAccountData(int i, int i2, boolean z, IWalletService.AccountInfo accountInfo, String str) {
        this.status = i;
        this.fullKycStatus = i2;
        this.supportFullKyc = z;
        this.accountStatus = accountInfo;
        this.authenticationStatus = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletAccountData(int r4, int r5, boolean r6, com.didi.payment.base.service.IWalletService.AccountInfo r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = 0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = 0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r6
        L_0x0015:
            r4 = r9 & 8
            r5 = 0
            if (r4 == 0) goto L_0x001c
            r2 = r5
            goto L_0x001d
        L_0x001c:
            r2 = r7
        L_0x001d:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0023
            r9 = r5
            goto L_0x0024
        L_0x0023:
            r9 = r8
        L_0x0024:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r0
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.model.WalletAccountData.<init>(int, int, boolean, com.didi.payment.base.service.IWalletService$AccountInfo, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getFullKycStatus() {
        return this.fullKycStatus;
    }

    public final void setFullKycStatus(int i) {
        this.fullKycStatus = i;
    }

    public final boolean getSupportFullKyc() {
        return this.supportFullKyc;
    }

    public final void setSupportFullKyc(boolean z) {
        this.supportFullKyc = z;
    }

    public final IWalletService.AccountInfo getAccountStatus() {
        return this.accountStatus;
    }

    public final void setAccountStatus(IWalletService.AccountInfo accountInfo) {
        this.accountStatus = accountInfo;
    }

    public final String getAuthenticationStatus() {
        return this.authenticationStatus;
    }

    public final void setAuthenticationStatus(String str) {
        this.authenticationStatus = str;
    }
}
