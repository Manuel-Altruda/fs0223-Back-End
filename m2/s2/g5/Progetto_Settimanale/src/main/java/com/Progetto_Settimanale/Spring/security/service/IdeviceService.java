package com.Progetto_Settimanale.Spring.security.service;

import java.util.List;

import com.Progetto_Settimanale.Spring.security.entity.Device;
import com.Progetto_Settimanale.Spring.security.entity.DeviceStatus;
import com.Progetto_Settimanale.Spring.security.entity.User;

public interface IdeviceService {
	Device createDevice(Device device);
	Device getDeviceById(Long id);
    List<Device> getDevicesByStatus(DeviceStatus status);
    List<Device> getDevicesByUser(User user);
    List<Device> getAllDevices();
    Device updateDevice(Long id, Device updatedDevice);
    void deleteDevice(Long id);
}
