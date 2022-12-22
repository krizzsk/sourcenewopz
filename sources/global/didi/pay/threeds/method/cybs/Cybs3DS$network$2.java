package global.didi.pay.threeds.method.cybs;

import androidx.fragment.app.FragmentActivity;
import global.didi.pay.threeds.network.ThreedsNetwork;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lglobal/didi/pay/threeds/network/ThreedsNetwork;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Cybs3DS.kt */
final class Cybs3DS$network$2 extends Lambda implements Function0<ThreedsNetwork> {
    final /* synthetic */ Cybs3DS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Cybs3DS$network$2(Cybs3DS cybs3DS) {
        super(0);
        this.this$0 = cybs3DS;
    }

    public final ThreedsNetwork invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity == null) {
            return null;
        }
        return new ThreedsNetwork(activity);
    }
}
