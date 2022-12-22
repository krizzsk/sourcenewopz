package global.didi.pay.threeds.method.cybs;

import androidx.fragment.app.FragmentActivity;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalInitService;
import com.taxis99.R;
import global.didi.pay.threeds.network.model.ThreedsChannelInfo;
import global.didi.pay.threeds.network.model.ThreedsError;
import global.didi.pay.threeds.utils.ThreeDSUiThreadHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, mo175978d2 = {"global/didi/pay/threeds/method/cybs/Cybs3DS$onChannelInfo$1", "Lcom/cardinalcommerce/cardinalmobilesdk/services/CardinalInitService;", "onSetupCompleted", "", "consumerSessionId", "", "onValidated", "validateResponse", "Lcom/cardinalcommerce/cardinalmobilesdk/models/ValidateResponse;", "serverJwt", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Cybs3DS.kt */
public final class Cybs3DS$onChannelInfo$1 implements CardinalInitService {
    final /* synthetic */ ThreedsChannelInfo $channelInfo;
    final /* synthetic */ int $repeatTime;
    final /* synthetic */ Cybs3DS this$0;

    Cybs3DS$onChannelInfo$1(Cybs3DS cybs3DS, int i, ThreedsChannelInfo threedsChannelInfo) {
        this.this$0 = cybs3DS;
        this.$repeatTime = i;
        this.$channelInfo = threedsChannelInfo;
    }

    public void onSetupCompleted(String str) {
        this.this$0.channelAuth(str);
        this.this$0.omegaInit(1);
    }

    public void onValidated(ValidateResponse validateResponse, String str) {
        Intrinsics.checkNotNullParameter(validateResponse, "validateResponse");
        if (this.$repeatTime > 0) {
            Cybs3DS cybs3DS = this.this$0;
            cybs3DS.init(cybs3DS.getActivity());
            ThreeDSUiThreadHandler.INSTANCE.postDelayed(new Runnable(this.$channelInfo, this.$repeatTime) {
                public final /* synthetic */ ThreedsChannelInfo f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    Cybs3DS$onChannelInfo$1.m47664onValidated$lambda0(Cybs3DS.this, this.f$1, this.f$2);
                }
            }, 5000);
            return;
        }
        this.this$0.omegaInit(0);
        ThreeDSUiThreadHandler.INSTANCE.post(new Runnable() {
            public final void run() {
                Cybs3DS$onChannelInfo$1.m47665onValidated$lambda2(Cybs3DS.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onValidated$lambda-0  reason: not valid java name */
    public static final void m47664onValidated$lambda0(Cybs3DS cybs3DS, ThreedsChannelInfo threedsChannelInfo, int i) {
        Intrinsics.checkNotNullParameter(cybs3DS, "this$0");
        Intrinsics.checkNotNullParameter(threedsChannelInfo, "$channelInfo");
        cybs3DS.onChannelInfo(threedsChannelInfo, i - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: onValidated$lambda-2  reason: not valid java name */
    public static final void m47665onValidated$lambda2(Cybs3DS cybs3DS) {
        String string;
        Intrinsics.checkNotNullParameter(cybs3DS, "this$0");
        ICybs3DSListener access$getCybs3DSListener$p = cybs3DS.cybs3DSListener;
        if (access$getCybs3DSListener$p != null) {
            ThreedsError init_error = ThreedsError.Companion.getINIT_ERROR();
            FragmentActivity activity = cybs3DS.getActivity();
            String str = "";
            if (!(activity == null || (string = activity.getString(R.string.threeds_fail_message)) == null)) {
                str = string;
            }
            init_error.setMessage(str);
            Unit unit = Unit.INSTANCE;
            access$getCybs3DSListener$p.onFailure(init_error);
        }
    }
}
