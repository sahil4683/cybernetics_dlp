/*
 *  Cybernetics_DLP
 */
package com.stealthview.al;

import com.stealthview.model.BasicInfo_model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class BasicInfo_AL {

    private static final String CRLF = "\r\n";

    public BasicInfo_model processInfo() {
        BasicInfo_model info_model = new BasicInfo_model();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("systeminfo");

            BufferedReader processOutput = null;
            try {
                process.waitFor();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            try {
                //Error Output Handling
                if (process.exitValue() == 0) {
                    processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                } else {
                    processOutput = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                }
                //Fix for possible hanging. Flush output before start reading
                process.getOutputStream().flush();
                String line;
                while ((line = processOutput.readLine()) != null) {
                    if (!line.isEmpty()) {

                        if (line.contains("Host Name:")) {
                            info_model.setHostName(line.replace("Host Name:", "").trim());
                        }
                        if (line.contains("OS Name:")) {
                            info_model.setOS_Name(line.replace("OS Name:", "").trim());
                        }
                        if (line.startsWith("OS Version:")) {
                            info_model.setOS_Version(line.replace("OS Version:", "").trim());
                        }
                        if (line.contains("OS Manufacturer:")) {
                            info_model.setOS_Manufacturer(line.replace("OS Manufacturer:", "").trim());
                        }
                        if (line.contains("OS Configuration:")) {
                            info_model.setOS_Configuration(line.replace("OS Configuration:", "").trim());
                        }
                        if (line.contains("OS Build Type:")) {
                            info_model.setOS_BuildType(line.replace("OS Build Type:", "").trim());
                        }

                        if (line.contains("Product ID:")) {
                            info_model.setProductID(line.replace("Product ID:", "").trim());
                        }
                        if (line.contains("Original Install Date:")) {
                            info_model.setOriginalInstallDate(line.replace("Original Install Date:", "").trim());
                        }
                        if (line.contains("System Boot Time:")) {
                            info_model.setSystemBootTime(line.replace("System Boot Time:", "").trim());
                        }
                        if (line.contains("System Manufacturer:")) {
                            info_model.setSystemManufacturer(line.replace("System Manufacturer:", "").trim());
                        }
                        if (line.contains("System Model:")) {
                            info_model.setSystemModel(line.replace("System Model:", "").trim());
                        }
                        if (line.contains("System Type:")) {
                            info_model.setSystemType(line.replace("System Type:", "").trim());
                        }
                        /*
                            processor 
                         */
                        if (line.startsWith("BIOS Version:")) {
                            info_model.setBIOSVersion(line.replace("BIOS Version:", "").trim());
                        }

                        if (line.contains("Windows Directory:")) {
                            info_model.setWindowsDirectory(line.replace("Windows Directory:", "").trim());
                        }
                        if (line.contains("Boot Device:")) {
                            info_model.setBootDevice(line.replace("Boot Device:", "").trim());
                        }
                        if (line.contains("Time Zone:")) {
                            info_model.setTimeZone(line.replace("Time Zone:", "").trim());
                        }
                        if (line.contains("Domain:")) {
                            info_model.setDomain(line.replace("Domain:", "").trim());
                        }
                        /*
                            HotFix, NetworkCard, Hyper_V_Requirements
                         */
        

                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (processOutput != null) {
                        processOutput.close();
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info_model;
    }
    
}
