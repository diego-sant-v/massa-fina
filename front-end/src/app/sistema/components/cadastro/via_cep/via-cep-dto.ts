export class ViaCepDTO {
    public cep: string;
    public logradouro: string;
    public complemento: string;
    public bairro: string;
    public localidade: string;
    public uf: string;
    public ibge: string;
    public gia: string;
    public ddd: string;
    public siafi: string;
  
    constructor(
      cep: string,
      logradouro: string,
      complemento: string,
      bairro: string,
      localidade: string,
      uf: string,
      ibge: string,
      gia: string,
      ddd: string,
      siafi: string
    ) {
      this.cep = cep;
      this.logradouro = logradouro;
      this.complemento = complemento;
      this.bairro = bairro;
      this.localidade = localidade;
      this.uf = uf;
      this.ibge = ibge;
      this.gia = gia;
      this.ddd = ddd;
      this.siafi = siafi;
    }
  }
  