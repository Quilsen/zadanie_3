package com.company;

import java.util.regex.Pattern;

public class UniquePicture extends Picture{

    public boolean add(Element e){
        if(!checkLabel(e)){
            super.add(e);
            return true;
        } else {
            return false;
        }
    }

    private boolean checkLabel(Element e){
        Pattern p = Pattern.compile(e.getLabel());
        boolean result = false;
        for(Element element:getElements()){
            result = p.matcher(element.getLabel()).matches();
        }
        return result;
    }
}
