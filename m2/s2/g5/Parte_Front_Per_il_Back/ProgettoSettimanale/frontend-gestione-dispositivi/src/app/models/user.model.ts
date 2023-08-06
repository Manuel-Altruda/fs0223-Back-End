export class User {
  id: number;
  name: string;
  lastname: string;
  username: string;
  email: string;
  password: string;
  ruolo: string;
  token!: string | null;


  constructor(id: number, username: string, nome: string, cognome: string, email: string, password: any, ruolo: string) {
    this.id = id;
    this.username = username;
    this.name = nome;
    this.lastname = cognome;
    this.email = email;
    this.password = password;
    this.ruolo = ruolo;
  }
}
