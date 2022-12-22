package global.didi.pay.threeds.method.cybs;

import androidx.fragment.app.FragmentActivity;
import com.taxis99.R;
import global.didi.pay.threeds.network.callback.ThreedsNetCallback;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsCybsInnerResponse;
import global.didi.pay.threeds.network.model.ThreedsCybsResultResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"global/didi/pay/threeds/method/cybs/Cybs3DS$callback$1", "Lglobal/didi/pay/threeds/network/callback/ThreedsNetCallback;", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;", "onFailure", "", "error", "Lglobal/didi/pay/threeds/network/model/ThreedsError;", "onSuccess", "response", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Cybs3DS.kt */
public final class Cybs3DS$callback$1 implements ThreedsNetCallback<ThreedsCybsResultResponse> {
    final /* synthetic */ Function1<ThreedsError, Unit> $failed;
    final /* synthetic */ Function1<ThreedsCybsDataResponse, Unit> $pending;
    final /* synthetic */ Function1<ThreedsCybsDataResponse, Unit> $success;
    final /* synthetic */ Cybs3DS this$0;

    Cybs3DS$callback$1(Function1<? super ThreedsError, Unit> function1, Function1<? super ThreedsCybsDataResponse, Unit> function12, Function1<? super ThreedsCybsDataResponse, Unit> function13, Cybs3DS cybs3DS) {
        this.$failed = function1;
        this.$success = function12;
        this.$pending = function13;
        this.this$0 = cybs3DS;
    }

    public void onSuccess(ThreedsCybsResultResponse threedsCybsResultResponse) {
        String string;
        FragmentActivity activity;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(threedsCybsResultResponse, "response");
        ThreedsCybsInnerResponse result3Ds = threedsCybsResultResponse.getResult3Ds();
        Unit unit = null;
        String str3 = "";
        if (result3Ds != null) {
            Function1<ThreedsError, Unit> function1 = this.$failed;
            Function1<ThreedsCybsDataResponse, Unit> function12 = this.$success;
            Function1<ThreedsCybsDataResponse, Unit> function13 = this.$pending;
            Cybs3DS cybs3DS = this.this$0;
            ThreedsCybsDataResponse data = result3Ds.getData();
            if (data != null) {
                String status = data.getStatus();
                if (status != null) {
                    int hashCode = status.hashCode();
                    if (hashCode != -1867169789) {
                        if (hashCode != -682587753) {
                            if (hashCode == 3135262 && status.equals("fail")) {
                                ThreedsError net_error = ThreedsError.Companion.getNET_ERROR();
                                FragmentActivity activity2 = cybs3DS.getActivity();
                                if (activity2 == null || (str2 = activity2.getString(R.string.threeds_fail_message)) == null) {
                                    str2 = str3;
                                }
                                net_error.setMessage(str2);
                                Unit unit2 = Unit.INSTANCE;
                                function1.invoke(net_error);
                                unit = Unit.INSTANCE;
                            }
                        } else if (status.equals("pending")) {
                            if (function13 != null) {
                                function13.invoke(data);
                                unit = Unit.INSTANCE;
                            }
                        }
                    } else if (status.equals("success")) {
                        function12.invoke(data);
                        unit = Unit.INSTANCE;
                    }
                }
                ThreedsError net_error2 = ThreedsError.Companion.getNET_ERROR();
                FragmentActivity activity3 = cybs3DS.getActivity();
                if (activity3 == null || (str = activity3.getString(R.string.threeds_fail_message)) == null) {
                    str = str3;
                }
                net_error2.setMessage(str);
                Unit unit3 = Unit.INSTANCE;
                function1.invoke(net_error2);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                ThreedsError net_error3 = ThreedsError.Companion.getNET_ERROR();
                String errMsg = result3Ds.getErrMsg();
                if (errMsg == null && ((activity = cybs3DS.getActivity()) == null || (errMsg = activity.getString(R.string.threeds_fail_message)) == null)) {
                    errMsg = str3;
                }
                net_error3.setMessage(errMsg);
                Integer errno = result3Ds.getErrno();
                net_error3.setCode(errno == null ? -1 : errno.intValue());
                Unit unit4 = Unit.INSTANCE;
                function1.invoke(net_error3);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Function1<ThreedsError, Unit> function14 = this.$failed;
            ThreedsError net_error4 = ThreedsError.Companion.getNET_ERROR();
            FragmentActivity activity4 = this.this$0.getActivity();
            if (!(activity4 == null || (string = activity4.getString(R.string.threeds_fail_message)) == null)) {
                str3 = string;
            }
            net_error4.setMessage(str3);
            Unit unit5 = Unit.INSTANCE;
            function14.invoke(net_error4);
        }
    }

    public void onFailure(ThreedsError threedsError) {
        Intrinsics.checkNotNullParameter(threedsError, "error");
        this.$failed.invoke(threedsError);
    }
}
