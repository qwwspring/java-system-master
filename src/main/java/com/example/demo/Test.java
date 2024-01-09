package com.example.demo;

import com.example.demo.bean.EquipmentData;
import com.example.demo.service.EquipmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class Test {


    private static EquipmentDataService equipmentDataService;

    @Autowired
    public void setEquipmentDataService(EquipmentDataService equipmentDataService){
        this.equipmentDataService = equipmentDataService;
    }
    @RequestMapping("/hello")
    public String gg(){
        System.out.println("---1111");
        return "redirect:index.html";
    }
    @RequestMapping("/helloo")
    @ResponseBody
    public List<EquipmentData> ggg(){
      //  List<EquipmentData> s31162116 = equipmentDataService.getEquipmentDataByEquipCodeSortedByDate("S31162116");
        System.out.println("---");
        Pageable pageable = PageRequest.of(0, 10, Sort.by("date").descending());
        Page<EquipmentData> equipmentDataPage = equipmentDataService.getEquipmentDataByEquipCodeSortedByDateDesc("S91887128", pageable);

        // Do something with the paginated list of EquipmentData

        return equipmentDataPage.getContent();
    }

    @RequestMapping("/getzhendong1")
    @ResponseBody
    public List<EquipmentData> gggg(){
        //  List<EquipmentData> s31162116 = equipmentDataService.getEquipmentDataByEquipCodeSortedByDate("S31162116");
        Pageable pageable = PageRequest.of(0, 10, Sort.by("date").descending());
        Page<EquipmentData> equipmentDataPage = equipmentDataService.findByEquipCodeAndValueGreaterThanOrderByDateDesc("S31518229", 0.00, pageable);
        return equipmentDataPage.getContent();
    }
    @RequestMapping("/getzhendong2")
    @ResponseBody
    public List<EquipmentData> ggggg(){
        //  List<EquipmentData> s31162116 = equipmentDataService.getEquipmentDataByEquipCodeSortedByDate("S31162116");
        Pageable pageable = PageRequest.of(0, 10, Sort.by("date").descending());
        Page<EquipmentData> equipmentDataPage = equipmentDataService.findByEquipCodeAndValueGreaterThanOrderByDateDesc("S31162116", 0.00, pageable);
        return equipmentDataPage.getContent();
    }
    @RequestMapping("/getzhendong3")
    @ResponseBody
    public List<EquipmentData> gggggg(){
        //  List<EquipmentData> s31162116 = equipmentDataService.getEquipmentDataByEquipCodeSortedByDate("S31162116");
        Pageable pageable = PageRequest.of(0, 2000, Sort.by("date").descending());
        Page<EquipmentData> equipmentDataPage = equipmentDataService.findByEquipCodeAndValueGreaterThanOrderByDateDesc("S31378807", 0.00, pageable);
        return equipmentDataPage.getContent();
    }
    @RequestMapping("/getzhendong4")
    @ResponseBody
    public List<EquipmentData> ggggggg(){
        //  List<EquipmentData> s31162116 = equipmentDataService.getEquipmentDataByEquipCodeSortedByDate("S31162116");
        Pageable pageable = PageRequest.of(0, 1000, Sort.by("date").descending());
        Page<EquipmentData> equipmentDataPage = equipmentDataService.findByEquipCodeAndValueGreaterThanOrderByDateDesc("S12455592", 0.00, pageable);
        return equipmentDataPage.getContent();
    }
    @RequestMapping("/getzhendong5")
    @ResponseBody
    public List<EquipmentData> gggggggg(){
        //  List<EquipmentData> s31162116 = equipmentDataService.getEquipmentDataByEquipCodeSortedByDate("S31162116");
        Pageable pageable = PageRequest.of(0, 12000, Sort.by("date").descending());
        Page<EquipmentData> equipmentDataPage = equipmentDataService.findByEquipCodeAndValueGreaterThanOrderByDateDesc("S90075012", 0.00, pageable);
        return equipmentDataPage.getContent();
    }
    @RequestMapping("/getzhendong6")
    @ResponseBody
    public List<EquipmentData> ggggggggg(){
        //  List<EquipmentData> s31162116 = equipmentDataService.getEquipmentDataByEquipCodeSortedByDate("S31162116");
        Pageable pageable = PageRequest.of(0, 12000, Sort.by("date").descending());
        Page<EquipmentData> equipmentDataPage = equipmentDataService.findByEquipCodeAndValueGreaterThanOrderByDateDesc("S65324544", 0.00, pageable);
        return equipmentDataPage.getContent();
    }
    @RequestMapping("/getLeftBoxData")
    @ResponseBody
    public List<EquipmentData> getLeftBoxData(){
        //  List<EquipmentData> s31162116 = equipmentDataService.getEquipmentDataByEquipCodeSortedByDate("S31162116");

        List<EquipmentData> equipmentDataPage = equipmentDataService.findByCustomSql();
        return equipmentDataPage;
    }


}
