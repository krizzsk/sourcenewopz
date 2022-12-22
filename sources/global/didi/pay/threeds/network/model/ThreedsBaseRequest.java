package global.didi.pay.threeds.network.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0014"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsBaseRequest;", "Ljava/io/Serializable;", "()V", "channelNameOf3ds", "", "getChannelNameOf3ds", "()Ljava/lang/String;", "setChannelNameOf3ds", "(Ljava/lang/String;)V", "model", "getModel", "nonce", "getNonce", "setNonce", "passportToken", "getPassportToken", "setPassportToken", "timestamp", "getTimestamp", "setTimestamp", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsBaseRequest.kt */
public class ThreedsBaseRequest implements Serializable {
    private String channelNameOf3ds;
    private final String model = "android";
    private String nonce;
    private String passportToken;
    private String timestamp;

    public final String getPassportToken() {
        return this.passportToken;
    }

    public final void setPassportToken(String str) {
        this.passportToken = str;
    }

    public final String getChannelNameOf3ds() {
        return this.channelNameOf3ds;
    }

    public final void setChannelNameOf3ds(String str) {
        this.channelNameOf3ds = str;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final void setNonce(String str) {
        this.nonce = str;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(String str) {
        this.timestamp = str;
    }

    public final String getModel() {
        return this.model;
    }
}
