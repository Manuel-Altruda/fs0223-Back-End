package com.Week_Project.classes;

import javax.persistence.*;



/*Questa classe è un'aggiunta extra dell'esercizio*/

@Entity
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private Prestito prestito;
    
    private double importo;

    public Multa() {}

    public Multa(Prestito prestito, double importo) {
        this.prestito = prestito;
        this.importo = importo;
    }

   public Long getId() {
        return id;
   }

   public void setId(Long id) {
        this.id = id;
   }

   public Prestito getPrestito() {
        return prestito;
   }

   public void setPrestito(Prestito prestito) {
        this.prestito = prestito;
   }

   public double getImporto() {
        return importo;
   }

   public void setImporto(double importo) {
        this.importo = importo;
   }
}
