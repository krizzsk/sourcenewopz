package global.didi.pay.threeds.method.cybs;

import androidx.fragment.app.FragmentActivity;
import com.taxis99.R;
import global.didi.pay.threeds.network.model.ThreedsChannelInfo;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "dataResponse", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsDataResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Cybs3DS.kt */
final class Cybs3DS$getChannelInfo$2 extends Lambda implements Function1<ThreedsCybsDataResponse, Unit> {
    final /* synthetic */ Cybs3DS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Cybs3DS$getChannelInfo$2(Cybs3DS cybs3DS) {
        super(1);
        this.this$0 = cybs3DS;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ThreedsCybsDataResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ThreedsCybsDataResponse threedsCybsDataResponse) {
        Unit unit;
        ICybs3DSListener access$getCybs3DSListener$p;
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(threedsCybsDataResponse, "dataResponse");
        ThreedsChannelInfo channelInfo = threedsCybsDataResponse.getChannelInfo();
        if (channelInfo == null) {
            unit = null;
        } else {
            this.this$0.onChannelInfo(channelInfo, 5);
            unit = Unit.INSTANCE;
        }
        if (unit == null && (access$getCybs3DSListener$p = this.this$0.cybs3DSListener) != null) {
            ThreedsError net_error = ThreedsError.Companion.getNET_ERROR();
            Cybs3DS cybs3DS = this.this$0;
            String status = threedsCybsDataResponse.getStatus();
            if (status == null && ((activity = cybs3DS.getActivity()) == null || (status = activity.getString(R.string.threeds_fail_message)) == null)) {
                status = "";
            }
            net_error.setMessage(status);
            Unit unit2 = Unit.INSTANCE;
            access$getCybs3DSListener$p.onFailure(net_error);
        }
    }
}
