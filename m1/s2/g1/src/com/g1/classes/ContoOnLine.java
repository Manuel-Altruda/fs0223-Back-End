package com.g1.classes;

import com.g1.exceptions.BancaException;

public class ContoOnLine extends ContoCorrente {
	private double maxPrelievo;

	public ContoOnLine(String titolare, double saldo, double maxP) {
		super(titolare, saldo);
		this.maxPrelievo = maxP;
	}

	public void stampaSaldo() {
		System.out.println("Titolare: " + titolare + " - Saldo: " + restituisciSaldo() + " - Num movimenti: "
				+ nMovimenti + " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: "
				+ maxPrelievo);
	}

	public void preleva(double x) throws BancaException {
		if (x > maxPrelievo) {
			throw new BancaException("Il prelievo non è disponibile");
		}
		super.preleva(x);
	}
}

