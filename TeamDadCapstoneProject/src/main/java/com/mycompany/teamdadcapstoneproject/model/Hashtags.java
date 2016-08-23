/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.teamdadcapstoneproject.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew Halbersma
 */
public class Hashtags {

    public String hashTagMaker(String content){
        List<String> results=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        String [] splitter=content.split("(?=[#]|\\s+|,|<|\")");
            for (String b: splitter){
                if (b.contains("#")&&b.length()>1){
                    sb.append("<a onclick=mySearch('");
                    sb.append(b);
                    sb.append("')>");
                    sb.append(b);
                    sb.append("</a>,");
                }
            }     return sb.toString();
}
    
}