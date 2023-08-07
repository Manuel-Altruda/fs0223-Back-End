package com.Progetto_Settimanale.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Progetto_Settimanale.Spring.security.entity.Device;
import com.Progetto_Settimanale.Spring.security.entity.DeviceStatus;
import com.Progetto_Settimanale.Spring.security.entity.User;
import com.Progetto_Settimanale.Spring.security.service.DeviceService;
import com.Progetto_Settimanale.Spring.security.service.UserService;

//@RestController
//@RequestMapping("/api/dispositivi")
//public class DispositivoController {
//	
//	@Autowired
//    private DispositivoRepository dispositivoRepository;
//	
//	@GetMapping
//    public List<Dispositivo> getAllDispositivi() {
//        return dispositivoRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Dispositivo getDispositivoById(@PathVariable Long id) {
//        return dispositivoRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping
//    public Dispositivo createDispositivo(@RequestBody Dispositivo dispositivo) {
//        return dispositivoRepository.save(dispositivo);
//    }
//
//    @PutMapping("/{id}")
//    public Dispositivo updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivoDetails) {
//        Dispositivo dispositivo = dispositivoRepository.findById(id).orElse(null);
//        if (dispositivo != null) {
//            dispositivo.setTipo(dispositivoDetails.getTipo());
//            dispositivo.setStato(dispositivoDetails.getStato());
//            return dispositivoRepository.save(dispositivo);
//        }
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteDispositivo(@PathVariable Long id) {
//        dispositivoRepository.deleteById(id);
//    }
//	
//}


@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device createdDevice = deviceService.createDevice(device);
        return new ResponseEntity<>(createdDevice, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Device>> getDevicesByStatus(@PathVariable DeviceStatus status) {
        List<Device> devices = deviceService.getDevicesByStatus(status);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Device>> getDevicesByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        List<Device> devices = deviceService.getDevicesByUser(user);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device updatedDevice) {
        Device device = deviceService.updateDevice(id, updatedDevice);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

