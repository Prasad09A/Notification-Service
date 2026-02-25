package com.loan.notification_service.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TemplateProcessor {

    public String processTemplate(String template, Map<String, String> placeholders){
        if(placeholders==null || placeholders.isEmpty()){
            return template;
        }

        for(Map.Entry<String, String > entry:placeholders.entrySet()){
            String key= "{{"+entry.getKey()+"}}";
            template=template.replace(key, entry.getValue());
        }
    return template;
    }
}
