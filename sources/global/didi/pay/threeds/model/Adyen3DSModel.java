package global.didi.pay.threeds.model;

import java.io.Serializable;
import java.util.Map;

public class Adyen3DSModel implements Serializable {
    public Map action;
    public int channel;
    public String reference;
    public String shopper;
    public String vendor;
}
