package com.didi.safetoolkit.business.share.model;

import com.didi.safetoolkit.model.ISfBaseObject;
import java.io.Serializable;

public class NewContactsModelForShare implements ISfBaseObject, Serializable {
    public String name;
    public boolean need_areacode;
    public String phone;
}
