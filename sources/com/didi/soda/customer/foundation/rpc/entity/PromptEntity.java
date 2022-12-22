package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class PromptEntity implements IEntity {
    private static final long serialVersionUID = 3654712160607397422L;
    public String activityId;
    public String activityType;
    public String backColor = null;
    public List<String> bgColor;
    public String content;
    public String fontColor = null;
    public int highLight;
    public String icon;
    public String iconText;
    public String iconUrl;
    public String imgUrl;
    public String maxline;
    public String style;
    public String tagImg;
    public String textColor;
    public int type;
}
