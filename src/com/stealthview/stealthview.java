package com.stealthview;

import com.stealthview.al.BasicInfo_AL;
import com.stealthview.dto.BasicInfo_DTO;
import com.stealthview.mapper.ALMapper;
import com.stealthview.mapper.DTOMapper;
import com.stealthview.model.BasicInfo_model;
import java.util.HashMap;
import java.util.Map;

/*
 *  Cybernetics_DLP
 */
/**
 *
 * @author Administrator
 */
public class stealthview {

    public static void main(String[] args) {

        Map<Integer, String> inspector = new HashMap<>();
        inspector.put(100, "false");
        inspector.put(200, "false");
        inspector.put(300, "false");

        for (int i = 0; i < 5; i++) {

            for (Map.Entry mi : inspector.entrySet()) {
                if (mi.getKey().equals(100) && mi.getValue().equals("false")) {
                    mi.setValue(
                            new BasicInfo_DTO()
                                    .StoreInfo(
                                            new BasicInfo_AL()
                                                    .processInfo()
                                    ).getDTOResult()
                    );
                }
            }
        }
//        BasicInfo_AL aL = new BasicInfo_AL();
//        BasicInfo_DTO dTO = new BasicInfo_DTO();
//
//        BasicInfo_model bi = new BasicInfo_model();
//        BasicInfo_model biDTO = new BasicInfo_model();
//
//        bi = aL.processInfo();
//        System.out.println(bi);
//        biDTO = dTO.StoreInfo(bi);
//        System.out.println(biDTO);
//
//        for (int i = 0; i < 3; i++) {
//            if (bi.getHostName().equals(biDTO.getHostName())) {
//                System.out.println("Same");
//                bi = aL.processInfo();
//            } else {
//                System.out.println("not same");
//                bi = aL.processInfo();
//                biDTO = dTO.StoreInfo(bi);
//            }
//        }
    }
}
