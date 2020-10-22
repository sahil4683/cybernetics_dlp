/*
 *  Cybernetics_DLP
 */
package com.stealthview.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
@ToString
public class BasicInfo_model {

    private String HostName;
    private String OS_Name;
//    private String OS_Version;
    private String OS_Manufacturer;
    private String OS_Configuration;
    private String OS_BuildType;
    private String ProductID;
    private String OriginalInstallDate;
    private String SystemBootTime;
    private String SystemManufacturer;
    private String SystemModel;
    private String SystemType;
    private String Processor; //list
//    private String BIOSVersion;
    private String WindowsDirectory;
    private String BootDevice;
    private String TimeZone;
    private String Domain;
    private String Hotfix; //List
    private String NetworkCard; //List
    private String Hyper_V_Requirements;//list

    private String DTOResult;
}
