package global.didi.pay.threeds.method.cybs;

import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "dataResponse", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsDataResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Cybs3DS.kt */
final class Cybs3DS$channelAuth$3 extends Lambda implements Function1<ThreedsCybsDataResponse, Unit> {
    final /* synthetic */ Cybs3DS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Cybs3DS$channelAuth$3(Cybs3DS cybs3DS) {
        super(1);
        this.this$0 = cybs3DS;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ThreedsCybsDataResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ThreedsCybsDataResponse threedsCybsDataResponse) {
        ICybs3DSListener access$getCybs3DSListener$p;
        Intrinsics.checkNotNullParameter(threedsCybsDataResponse, "dataResponse");
        Cybs3DS cybs3DS = this.this$0;
        if (!(!cybs3DS.onChannelAuth(threedsCybsDataResponse))) {
            cybs3DS = null;
        }
        if (cybs3DS != null && (access$getCybs3DSListener$p = this.this$0.cybs3DSListener) != null) {
            access$getCybs3DSListener$p.onFailure(ThreedsError.Companion.getINIT_ERROR());
        }
    }
}
