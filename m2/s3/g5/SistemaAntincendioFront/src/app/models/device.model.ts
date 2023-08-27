export class Device {
  id: number;
  nome: string;
  tipo: string;
  stato: string;
  assegnatoA: number | null;

  constructor(id: number, nome: string, tipo: string, stato: string, assegnatoA: number | null) {
    this.id = id;
    this.nome = nome;
    this.tipo = tipo;
    this.stato = stato;
    this.assegnatoA = assegnatoA;
  }
}
