package com.example.demo;

import com.example.demo.bean.EquipmentData;
import com.example.demo.bean.ZhenDong;
import com.example.demo.service.EquipmentDataService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mantoo.mtic.netty.data.DataTransfer;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class dd extends DataTransfer {

    private static EquipmentDataService equipmentDataService;

    @Autowired
    public void setEquipmentDataService(EquipmentDataService equipmentDataService){
        dd.equipmentDataService = equipmentDataService;
    }


    @Override
    public void receiveData(String s) {
        try {
            List<EquipmentData> resultList = new ArrayList<>();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(s);

            long date = rootNode.get("date").asLong();
            String equipName = rootNode.get("equipName").asText();
            String equipType = rootNode.get("equipType").asText();
            String equipCode = rootNode.get("equipCode").asText();
if(equipName.equals("振动传感器")){

 //  System.out.println(s);
//            String value =rootNode.get("collectList").asText();
//
//    ZhenDong equipmentData = new ZhenDong();
//    equipmentData.setDate(date);
//    equipmentData.setEquipName(equipName);
//    equipmentData.setEquipType(equipType);
//    equipmentData.setEquipCode(equipCode);
//
}
            JsonNode collectList = rootNode.get("collectList");
            Iterator<JsonNode> elements = collectList.elements();
            while (elements.hasNext()) {
                JsonNode collectDataNode = elements.next();
                String code = collectDataNode.get("code").asText();
                String name = collectDataNode.get("name").asText();
                String value = collectDataNode.get("value").asText();
                if(code.equals("t")){
                    continue;
                }
                EquipmentData equipmentData = new EquipmentData();
                equipmentData.setDate(date);
                equipmentData.setEquipName(equipName);
                equipmentData.setEquipType(equipType);
                equipmentData.setEquipCode(equipCode);
                equipmentData.setCode(code);
                equipmentData.setName(name);
                equipmentData.setValue(Double.valueOf(value));


                resultList.add(equipmentData);
            }
            for(int i=0;i<resultList.size();i++){
                equipmentDataService.saveEquipmentData(resultList.get(i));
            }
            resultList = null;
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
