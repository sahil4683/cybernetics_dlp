/*
 *  Cybernetics_DLP
 */
package com.stealthview.dto;

import com.stealthview.model.BasicInfo_model;

/**
 *
 * @author Administrator
 */
public class BasicInfo_DTO {
    
    public BasicInfo_model StoreInfo(BasicInfo_model info_model) {
        
        info_model.setDTOResult("true");
        info_model.setOS_Name("sdfsd");
//        System.out.println(info_model);
        
        return info_model;
    }
}
