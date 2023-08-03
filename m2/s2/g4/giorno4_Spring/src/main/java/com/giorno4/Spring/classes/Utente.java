package com.giorno4.Spring.classes;

import jakarta.persistence.*;

@Entity
public class Utente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cognome;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String ruolo;
    
    public Utente() {
    }

	public Utente(Long id, String username, String nome, String cognome, String email, String password, String ruolo) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.ruolo = ruolo;
	}



	public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
		this.id = id;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
    
    
}
