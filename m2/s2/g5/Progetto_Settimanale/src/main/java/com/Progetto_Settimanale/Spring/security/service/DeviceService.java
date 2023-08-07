package com.Progetto_Settimanale.Spring.security.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.Progetto_Settimanale.Spring.security.entity.DeviceStatus;

import com.Progetto_Settimanale.Spring.security.entity.Device;
import com.Progetto_Settimanale.Spring.security.entity.User;
import com.Progetto_Settimanale.Spring.security.repository.DispositivoRepository;

import jakarta.persistence.EntityNotFoundException;

//@Service
//public class DispositivoService {
//	private final DispositivoRepository dispositivoRepository;
//	private UserService userService;
//
//	 public DispositivoService(DispositivoRepository dispositivoRepository, UserService userService) {
//	        this.dispositivoRepository = dispositivoRepository;
//	        this.userService = userService;
//	    }
//
//
//    public List<Dispositivo> getAllDispositivi() {
//        return dispositivoRepository.findAll();
//    }
//
//    public Dispositivo getDispositivoById(Long id) {
//        return dispositivoRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Dispositivo non trovato con ID: " + id));
//    }
//
//    public Dispositivo createDispositivo(Dispositivo dispositivo) {
//        return dispositivoRepository.save(dispositivo);
//    }
//
//    public Dispositivo updateDispositivo(Long id, Dispositivo dispositivo) {
//        Dispositivo existingDispositivo = getDispositivoById(id);
//        existingDispositivo.setTipo(dispositivo.getTipo());
//        existingDispositivo.setStato(dispositivo.getStato());
//        existingDispositivo.setUtente(dispositivo.getUtente());
//        return dispositivoRepository.save(existingDispositivo);
//    }
//
//    public void deleteDispositivo(Long id) {
//        dispositivoRepository.deleteById(id);
//    }
//	
//    public void assegnaDispositivo(Long utenteId, Long dispositivoId) {
//        User utente = userService.getUtenteById(utenteId);
//        Dispositivo dispositivo = getDispositivoById(dispositivoId);
//
//        // Controlla se l'utente è un amministratore
//        if (utente.getRoles().equals("amministratore")) {
//            throw new IllegalArgumentException("Gli amministratori non possono avere dispositivi assegnati.");
//        }
//
//        // Controlla se il dispositivo è già assegnato
//        if (dispositivo.getUtente() != null) {
//            throw new IllegalArgumentException("Il dispositivo è già assegnato a un utente.");
//        }
//
//        dispositivo.setUtente(utente);
//        dispositivo.setStato(StatoDispositivo.ASSEGNATO);
//        dispositivoRepository.save(dispositivo);
//    }
//
//    public void rimuoviAssegnazioneDispositivo(Long utenteId, Long dispositivoId) {
//        User utente = userService.getUtenteById(utenteId);
//        Dispositivo dispositivo = getDispositivoById(dispositivoId);
//
//        // Controlla se l'utente è un amministratore
//        if (utente.getRoles().equals("amministratore")) {
//            throw new IllegalArgumentException("Gli amministratori non possono avere dispositivi assegnati.");
//        }
//
//        // Controlla se l'utente è effettivamente assegnato al dispositivo
//        if (!dispositivo.getUtente().equals(utente)) {
//            throw new IllegalArgumentException("L'utente non è assegnato a questo dispositivo.");
//        }
//
//        dispositivo.setUtente(null);
//        dispositivo.setStato(StatoDispositivo.DISPONIBILE);
//        dispositivoRepository.save(dispositivo);
//    }
//    
//}
@Service
public class DeviceService implements IdeviceService {
    @Autowired
    private DispositivoRepository deviceRepository;

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device not found with ID: " + id));
    }

    public List<Device> getDevicesByStatus(DeviceStatus status) {
        return deviceRepository.findByStatus(status);
    }

    public List<Device> getDevicesByUser(User user) {
        return deviceRepository.findByAssignedUser(user);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device updateDevice(Long id, Device updatedDevice) {
    	Device existingDevice = getDeviceById(id);
        existingDevice.setTipo(updatedDevice.getTipo());
        existingDevice.setStatus(updatedDevice.getStatus());
        existingDevice.setAssignedUser(updatedDevice.getAssignedUser());
        return deviceRepository.save(existingDevice);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
