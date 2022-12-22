package global.didi.pay.select.model;

public class RequestPayEvent {
    public int channnel;
    public String sub_channel;
    public RequestType type;

    public enum RequestType {
        GetPayInfo,
        ChangePayInfo,
        PrePay
    }
}
