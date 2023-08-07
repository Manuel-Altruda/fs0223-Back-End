package com.Progetto_Settimanale.Spring.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String tipo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private DeviceStatus status;
	
	
	@ManyToOne
    @JoinColumn(name = "utente_id")
    private User utente;
	
	@ManyToOne
    @JoinColumn(name = "user_id_assegnato")
    private User assignedUser;
	
	public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public User getAssignedUser() {
        return assignedUser;
    }
	
    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
    
}


