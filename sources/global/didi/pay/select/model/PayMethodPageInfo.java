package global.didi.pay.select.model;

import java.io.Serializable;
import java.util.List;

public class PayMethodPageInfo implements Serializable {
    public String appId;
    public List<PayMethodGroupInfo> groupList;
    public PayMethodPageHeadInfo headInfo;
    public String orderId;
    public List<PayMethodItemInfo> payMethodList;
    public String productId;
    public String productLine;
}
