package com.jumio.sdk.controller;

import android.content.Context;
import android.os.Bundle;
import com.jumio.core.Controller;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B+\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B-\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\"\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004R\u001c\u0010\u0016\u001a\u00020\u00118\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0018\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, mo175978d2 = {"Lcom/jumio/sdk/controller/JumioController;", "", "Landroid/os/Bundle;", "data", "", "persist", "stop", "Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "credentialInfo", "Lcom/jumio/sdk/credentials/JumioCredential;", "start", "Lcom/jumio/sdk/error/JumioError;", "error", "retry", "cancel", "finish", "userConsented", "Lcom/jumio/core/Controller;", "a", "Lcom/jumio/core/Controller;", "getController$jumio_core_release", "()Lcom/jumio/core/Controller;", "controller", "", "isComplete", "()Z", "Landroid/content/Context;", "context", "Lcom/jumio/core/models/AuthorizationModel;", "authorizationModel", "Lcom/jumio/sdk/interfaces/JumioControllerInterface;", "controllerInterface", "", "customThemeId", "<init>", "(Landroid/content/Context;Lcom/jumio/core/models/AuthorizationModel;Lcom/jumio/sdk/interfaces/JumioControllerInterface;I)V", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/jumio/sdk/interfaces/JumioControllerInterface;Lcom/jumio/sdk/interfaces/JumioScanPartInterface;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioController.kt */
public final class JumioController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public final Controller f55072a;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo175978d2 = {"Lcom/jumio/sdk/controller/JumioController$Companion;", "", "", "CONTROLLER_EXPIRATION_MESSAGE", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioController.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioController(Context context, AuthorizationModel authorizationModel, JumioControllerInterface jumioControllerInterface, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, authorizationModel, jumioControllerInterface, (i2 & 8) != 0 ? 0 : i);
    }

    public final synchronized void cancel() throws IllegalArgumentException, SDKNotConfiguredException {
        if (this.f55072a.isActive$jumio_core_release()) {
            this.f55072a.cancel();
        } else {
            throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
        }
    }

    public final synchronized void finish() throws IllegalArgumentException, SDKNotConfiguredException {
        if (this.f55072a.isActive$jumio_core_release()) {
            try {
                this.f55072a.finish();
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
        }
    }

    public final Controller getController$jumio_core_release() {
        return this.f55072a;
    }

    public final boolean isComplete() {
        return this.f55072a.isComplete();
    }

    public final void persist(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "data");
        if (this.f55072a.isActive$jumio_core_release()) {
            this.f55072a.saveState(bundle);
        }
    }

    public final void retry(JumioError jumioError) throws SDKNotConfiguredException {
        Intrinsics.checkNotNullParameter(jumioError, "error");
        if (this.f55072a.isActive$jumio_core_release()) {
            this.f55072a.retry(jumioError);
            return;
        }
        throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
    }

    public final JumioCredential start(JumioCredentialInfo jumioCredentialInfo) throws IllegalArgumentException, SDKNotConfiguredException {
        Intrinsics.checkNotNullParameter(jumioCredentialInfo, "credentialInfo");
        if (this.f55072a.isActive$jumio_core_release()) {
            return this.f55072a.startCredential(jumioCredentialInfo);
        }
        throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
    }

    public final void stop() {
        if (this.f55072a.isActive$jumio_core_release()) {
            this.f55072a.persistAllData(true);
        }
    }

    public final void userConsented() throws SDKNotConfiguredException {
        if (this.f55072a.isActive$jumio_core_release()) {
            this.f55072a.userConsented();
            return;
        }
        throw new SDKNotConfiguredException("This controller can not be used anymore".toString());
    }

    public JumioController(Context context, AuthorizationModel authorizationModel, JumioControllerInterface jumioControllerInterface, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authorizationModel, "authorizationModel");
        Intrinsics.checkNotNullParameter(jumioControllerInterface, "controllerInterface");
        this.f55072a = new Controller(context, authorizationModel, jumioControllerInterface, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioController(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bundle, jumioControllerInterface, (i & 8) != 0 ? null : jumioScanPartInterface);
    }

    public JumioController(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "data");
        Intrinsics.checkNotNullParameter(jumioControllerInterface, "controllerInterface");
        this.f55072a = new Controller(context, bundle, jumioControllerInterface, jumioScanPartInterface);
    }
}
