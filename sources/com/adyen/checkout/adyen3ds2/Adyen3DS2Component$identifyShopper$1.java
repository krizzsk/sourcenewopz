package com.adyen.checkout.adyen3ds2;

import android.app.Activity;
import com.adyen.checkout.adyen3ds2.model.FingerprintToken;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.Logger;
import com.adyen.threeds2.AuthenticationRequestParameters;
import com.adyen.threeds2.ThreeDS2Service;
import com.adyen.threeds2.Transaction;
import com.adyen.threeds2.exception.SDKAlreadyInitializedException;
import com.adyen.threeds2.exception.SDKNotInitializedException;
import com.adyen.threeds2.exception.SDKRuntimeException;
import com.adyen.threeds2.parameters.ConfigParameters;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.adyen.checkout.adyen3ds2.Adyen3DS2Component$identifyShopper$1", mo176687f = "Adyen3DS2Component.kt", mo176688i = {}, mo176689l = {256}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: Adyen3DS2Component.kt */
final class Adyen3DS2Component$identifyShopper$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ ConfigParameters $configParameters;
    final /* synthetic */ FingerprintToken $fingerprintToken;
    final /* synthetic */ boolean $submitFingerprintAutomatically;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Adyen3DS2Component this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Adyen3DS2Component$identifyShopper$1(Activity activity, ConfigParameters configParameters, Adyen3DS2Component adyen3DS2Component, FingerprintToken fingerprintToken, boolean z, Continuation<? super Adyen3DS2Component$identifyShopper$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$configParameters = configParameters;
        this.this$0 = adyen3DS2Component;
        this.$fingerprintToken = fingerprintToken;
        this.$submitFingerprintAutomatically = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Adyen3DS2Component$identifyShopper$1 adyen3DS2Component$identifyShopper$1 = new Adyen3DS2Component$identifyShopper$1(this.$activity, this.$configParameters, this.this$0, this.$fingerprintToken, this.$submitFingerprintAutomatically, continuation);
        adyen3DS2Component$identifyShopper$1.L$0 = obj;
        return adyen3DS2Component$identifyShopper$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Adyen3DS2Component$identifyShopper$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                Logger.m1076d(Adyen3DS2Component.f528g, "initialize 3DS2 SDK");
                ThreeDS2Service.INSTANCE.initialize(this.$activity, this.$configParameters, (String) null, this.this$0.f537e);
            } catch (SDKRuntimeException e) {
                this.this$0.notifyException(new ComponentException("Failed to initialize 3DS2 SDK", e));
                return Unit.INSTANCE;
            } catch (SDKAlreadyInitializedException unused) {
                Logger.m1084w(Adyen3DS2Component.f528g, "3DS2 Service already initialized.");
            }
            Adyen3DS2Component adyen3DS2Component = this.this$0;
            try {
                Logger.m1076d(Adyen3DS2Component.f528g, "create transaction");
                if (this.$fingerprintToken.getThreeDSMessageVersion() != null) {
                    adyen3DS2Component.f536d = ThreeDS2Service.INSTANCE.createTransaction((String) null, this.$fingerprintToken.getThreeDSMessageVersion());
                    Transaction access$getMTransaction$p = this.this$0.f536d;
                    AuthenticationRequestParameters authenticationRequestParameters = access$getMTransaction$p == null ? null : access$getMTransaction$p.getAuthenticationRequestParameters();
                    if (authenticationRequestParameters == null) {
                        this.this$0.notifyException(new ComponentException("Failed to retrieve 3DS2 authentication parameters"));
                        return Unit.INSTANCE;
                    }
                    final String createEncodedFingerprint = this.this$0.createEncodedFingerprint(authenticationRequestParameters);
                    if (this.$submitFingerprintAutomatically) {
                        this.label = 1;
                        if (this.this$0.m1026a(this.$activity, createEncodedFingerprint, (Continuation<? super Unit>) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        final Adyen3DS2Component adyen3DS2Component2 = this.this$0;
                        Job unused2 = C21836d.m45637a(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new C12961((Continuation<? super C12961>) null), 2, (Object) null);
                    }
                } else {
                    this.this$0.notifyException(new ComponentException("Failed to create 3DS2 Transaction. Missing threeDSMessageVersion inside fingerprintToken."));
                    return Unit.INSTANCE;
                }
            } catch (SDKNotInitializedException e2) {
                this.this$0.notifyException(new ComponentException("Failed to create 3DS2 Transaction", e2));
                return Unit.INSTANCE;
            } catch (SDKRuntimeException e3) {
                this.this$0.notifyException(new ComponentException("Failed to create 3DS2 Transaction", e3));
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @DebugMetadata(mo176686c = "com.adyen.checkout.adyen3ds2.Adyen3DS2Component$identifyShopper$1$1", mo176687f = "Adyen3DS2Component.kt", mo176688i = {}, mo176689l = {}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
    /* renamed from: com.adyen.checkout.adyen3ds2.Adyen3DS2Component$identifyShopper$1$1 */
    /* compiled from: Adyen3DS2Component.kt */
    static final class C12961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C12961(adyen3DS2Component2, createEncodedFingerprint, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Adyen3DS2Component adyen3DS2Component = adyen3DS2Component2;
                adyen3DS2Component.notifyDetails(adyen3DS2Component.f534b.createFingerprintDetails(createEncodedFingerprint));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
