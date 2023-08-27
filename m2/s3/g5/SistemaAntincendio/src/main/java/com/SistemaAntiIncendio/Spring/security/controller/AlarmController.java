package com.SistemaAntiIncendio.Spring.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaAntiIncendio.Spring.data.AlarmData;
import com.SistemaAntiIncendio.Spring.model.UserAction;
import com.SistemaAntiIncendio.Spring.services.UserActionService;

@RestController
public class AlarmController {
	private final UserAction userAction;
	private final UserActionService userActionService;
	private List<AlarmData> alarmDataList = new ArrayList<>(); // Simulated data for demonstration
	
	@Autowired
    public AlarmController(UserAction userAction, UserActionService userActionService) {
        this.userAction = userAction;
        this.userActionService = userActionService;
    }
	
    @GetMapping("/alarms")
    public String getAlarmList(Model model) {
        model.addAttribute("alarmData", alarmDataList);
        return "alarm-list";
    }

    @GetMapping("/add-alarm")
    public String showAddAlarmForm(Model model) {
        model.addAttribute("newAlarm", new AlarmData("", 0.0, 0.0, 0.0));
        return "add-alarm-form";
    }

    @PostMapping("/add-alarm")
    public String addAlarm(@ModelAttribute AlarmData newAlarm) {
        alarmDataList.add(newAlarm);
        return "redirect:/alarms";
    }
	
    @GetMapping("/edit-alarm/{id}")
    public String showEditAlarmForm(@PathVariable String id, Model model) {
        AlarmData alarmToUpdate = findAlarmById(id);
        if (alarmToUpdate != null) {
            model.addAttribute("alarmToUpdate", alarmToUpdate);
            return "edit-alarm-form";
        }
        return "redirect:/alarms";
    }

    @PostMapping("/edit-alarm")
    public String editAlarm(@ModelAttribute AlarmData updatedAlarm) {
        AlarmData existingAlarm = findAlarmById(updatedAlarm.getIdSonda());
        if (existingAlarm != null) {
            // Update the existing alarm
            existingAlarm.setLatitude(updatedAlarm.getLatitude());
            existingAlarm.setLongitude(updatedAlarm.getLongitude());
            existingAlarm.setSmokeLevel(updatedAlarm.getSmokeLevel());
        }
        return "redirect:/alarms";
    }

    @GetMapping("/delete-alarm/{id}")
    public String deleteAlarm(@PathVariable String id) {
        AlarmData alarmToDelete = findAlarmById(id);
        if (alarmToDelete != null) {
            alarmDataList.remove(alarmToDelete);
        }
        return "redirect:/alarms";
    }

    
    private AlarmData findAlarmById(String id) {
        return alarmDataList.stream()
            .filter(alarm -> alarm.getIdSonda().equals(id))
            .findFirst()
            .orElse(null);
    }

	public UserAction getUserAction() {
		return userAction;
	}

	public UserActionService getUserActionService() {
		return userActionService;
	}
}
