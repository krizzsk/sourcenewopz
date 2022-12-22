package global.didi.pay.threeds.contract;

import global.didi.pay.threeds.method.cybs.ICybs3DSListener;
import global.didi.pay.threeds.model.Cybs3DSModel;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u001c\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH&¨\u0006\u000e"}, mo175978d2 = {"Lglobal/didi/pay/threeds/contract/ICybs3DS;", "", "handleModel", "", "model", "Lglobal/didi/pay/threeds/model/Cybs3DSModel;", "registerListener", "listener", "Lglobal/didi/pay/threeds/method/cybs/ICybs3DSListener;", "unregisterListener", "updateOmegaAttr", "map", "", "", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ICybs3DS.kt */
public interface ICybs3DS {
    void handleModel(Cybs3DSModel cybs3DSModel);

    void registerListener(ICybs3DSListener iCybs3DSListener);

    void unregisterListener();

    void updateOmegaAttr(Map<String, String> map);
}
