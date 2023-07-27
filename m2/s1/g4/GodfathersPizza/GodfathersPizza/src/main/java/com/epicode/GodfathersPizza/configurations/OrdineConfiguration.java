package com.epicode.GodfathersPizza.configurations;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.epicode.GodfathersPizza.classes.Ordine;
import com.epicode.GodfathersPizza.classes.StatoOrdine;
import com.epicode.GodfathersPizza.classes.Tavolo;

@Configuration
@PropertySource("classpath:application.properties")
public class OrdineConfiguration {
	
	@Value("${pizzeria.costocoperto}") private Double costoCoperto;
	
	@Bean("generaOrdine")
	@Scope("prototype")
	public Ordine generaOrdine() {
		Ordine o = new Ordine();
		o.setStatoOrdine(StatoOrdine.IN_CORSO);
		o.setOraAcquisizioneOrdine(LocalTime.now());
		o.setCostoCoperto(costoCoperto); // devo leggere da application.properties
		return o;
	}
	
	@Bean("generaTavolo")
	@Scope("prototype")
	public Tavolo generaTavolo() {
		return new Tavolo();
	}

}
