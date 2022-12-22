package global.didi.pay.select.model;

import java.io.Serializable;
import java.util.List;

public class PayMethodGroupInfo implements Serializable {
    public List<Integer> channelIds;
    public String icon;
    public String name;
}
