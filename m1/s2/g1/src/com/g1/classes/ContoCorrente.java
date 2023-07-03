package com.g1.classes;

import com.g1.exceptions.BancaException;

public class ContoCorrente {
	
	protected String titolare;
	protected int nMovimenti;
	protected final int maxMovimenti = 50;
	private double saldo;

	public ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	public void preleva(double x) throws BancaException {
		if (nMovimenti < maxMovimenti) {
			saldo = saldo - x;
		} else {
			saldo = saldo - x - 0.50;
		}
		nMovimenti++;

		if (saldo < 0) {
			throw new BancaException("Il conto è in rosso");
		}
	}

	public double restituisciSaldo() {
		return saldo;
	}

}
