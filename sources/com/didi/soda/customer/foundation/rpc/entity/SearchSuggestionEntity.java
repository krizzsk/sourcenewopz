package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.blocks.entity.Template;
import java.util.ArrayList;

public class SearchSuggestionEntity implements IEntity {
    private static final long serialVersionUID = -2395055722548044783L;
    public int sugIndex;
    public ArrayList<SugCompEntity> sugList;
    public String suggestionId;
    public ArrayList<Template> templates;
    public String traceId;
    public ArrayList<String> words;
}
