package com.Progetto_Settimanale.Spring.security.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Progetto_Settimanale.Spring.security.entity.Device;
import com.Progetto_Settimanale.Spring.security.entity.DeviceStatus;
import com.Progetto_Settimanale.Spring.security.entity.User;
import com.Progetto_Settimanale.Spring.security.repository.DispositivoRepository;
import com.Progetto_Settimanale.Spring.security.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService implements IuserService{
	
	@Autowired
    private UserRepository userRepository;
	private DeviceService dispositivoService;
	 
	 @Autowired
	   public UserService(UserRepository userRepository, DeviceService dispositivoService) {
	       this.userRepository = userRepository;
	       this.dispositivoService = dispositivoService;
	   }

	 @Autowired
	   public void setDispositivoService(DeviceService dispositivoService) {
	       this.dispositivoService = dispositivoService;
	  }
	
	public List<User> getAllUtenti() {
        return userRepository.findAll();
    }

    public User getUtenteById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utente non trovato con ID: " + id));
    }

    public User createUtente(User utente) {
        return userRepository.save(utente);
    }

    public User updateUtente(Long id, User utente) {
    	User existingUtente = getUtenteById(id);
        existingUtente.setUsername(utente.getUsername());
        existingUtente.setName(utente.getName());
        existingUtente.setSurname(utente.getSurname());
        existingUtente.setEmail(utente.getEmail());
        return userRepository.save(existingUtente);
    }

    public void deleteUtente(Long id) {
        userRepository.deleteById(id);
    }
    
    public User assegnaDispositivo(Long utenteId, Long dispositivoId) {
    	User utente = getUtenteById(utenteId);
        Device dispositivo = dispositivoService.getDeviceById(dispositivoId);

        // Controlla se l'utente è un amministratore
        if (utente.getRoles().equals("amministratore")) {
            throw new IllegalArgumentException("Gli amministratori non possono avere dispositivi assegnati.");
        }

        // Controlla se il dispositivo è già assegnato
        if (dispositivo.getUtente() != null) {
            throw new IllegalArgumentException("Il dispositivo è già assegnato a un utente.");
        }

        dispositivo.setUtente(utente);
        dispositivo.setStatus(DeviceStatus.ASSEGNATO);
        dispositivoService.updateDevice(dispositivoId, dispositivo);

        return utente;
    }

    public void rimuoviAssegnazioneDispositivo(Long utenteId, Long dispositivoId) {
    	User utente = getUtenteById(utenteId);
        Device dispositivo = dispositivoService.getDeviceById(dispositivoId);

        // Controlla se l'utente è un amministratore
        if (utente.getRoles().equals("amministratore")) {
            throw new IllegalArgumentException("Gli amministratori non possono avere dispositivi assegnati.");
        }

        // Controlla se l'utente è effettivamente assegnato al dispositivo
        if (!dispositivo.getUtente().equals(utente)) {
            throw new IllegalArgumentException("L'utente non è assegnato a questo dispositivo.");
        }

        dispositivo.setUtente(null);
        dispositivo.setStatus(DeviceStatus.DISPONIBILE);
        dispositivoService.updateDevice(dispositivoId, dispositivo);
    }
    
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
