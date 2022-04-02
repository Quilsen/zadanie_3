package com.company;

import java.util.regex.Pattern;

public class StandarizedPicture extends Picture{

    public boolean add(Element e){
       if (checkLabel(e)){
           super.add(e);
           return true;
       } else {
           return false;
       }
    }

    private boolean checkLabel(Element e){
        Pattern p = Pattern.compile("[A-Z]{1}[A-Z0-9]+");
        return p.matcher(e.getLabel()).matches();
    }
}
