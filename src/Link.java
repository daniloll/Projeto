/* Classe que trata da construção de links entre as cidades
 */
public class Link implements Comparable<Link> {
  public Cidade cidade1;
  public Cidade cidade2;
  public int tamanho;
  public boolean usado = false;

  /**
   * Construct cria um Link entre a primeiracidade e a segunda cidade com um tamanho "tam
   * As cidades são comparadas alfabeticamente e criadas no link em ordem alfabética
   * o link é criado entre as cidades
   */
  public Link(Cidade c1, Cidade c2, int tam) {
    if (c1.comparaNome(c2) < 0) {
      cidade1 = c1;
      cidade2 = c2;
    } else {
      cidade1 = c2;
      cidade2 = c1;
    }
    tamanho = tam;
    c1.addLink(this);
    c2.addLink(this);
		usado = true;
  }

  /**
   * @description Retorna o tamanho de um link entre duas cidades
   * @return inteiro correspondente ao tamanaho do link
   */                                                                  //Refatoração: Padronização do comentário
  public int getTamanho() {
    return tamanho;
  }

  /**
   * @description Verificar a existencia de um link entre duas cidades
   * @return booleano true se o link entre duas cidades existir
   */                                                                  //Refatoração: Padronização do comentário
  public boolean isUsado() {
    return usado;
  }


  /**
   * @description Verificar se linké usado
   * @return booleano true se o link é usado
   */                                                                  //Refatoração: Padronização do comentário
  public void setUsado(boolean usado) {                                //Refatoração: O nome do parâmetro foi alterado para usado
    this.usado = usado;
  }

  /**
   * @description Descreve um link existente entre duas cidades
   * @return string com a descrição de um Link entre cidades
   *         O nome das cidades tem de vir em ordem alfabética, exemplo, Olinda vem antes de Recife
   *         Exemplo: "Cidade1 3 Cidade2"
   */                                                                  //Refatoração: Padronização do comentário
  public String toString() {
    //return cidade1.toString() + " " + cidade2.toString();            //BUG 04: Não retornava a distancia entre as cidades
    return cidade1.toString() + " "+tamanho+"Km "+ cidade2.toString(); //Refatoração: Correção do BUG 04; atraves da alteração da formatacao da string
  }

  /**
   * @description Compara dois links para saber se são o mesmo caminho
   *              até a rede de trens (ponto 0)
   * @param link link entre cidades
   * @return inteiro negativo se this.cidade1 < link.cidade1 ou
   *         inteiro negativo se cidade1 é igual nos dois links e this.cidade2 < link.cidade2;
   *         0 se os links tiverem as mesmas cidade1 e cidade2;
   *         positivo caso contrário;
   */                                                                  //Refatoração: Padronização do comentário
  public int compareTo(Link link) {                                    //Refatoração: O nome do parâmetro foi alterado para link
    int diferenca = cidade1.comparaNome(link.cidade1);
    if (diferenca == 0) {
      //diferenca = cidade1.comparaNome(link.cidade1);                 //BUG 05: Estava fazendo a comparação somente para uma das cidades, faltando comparar o valor da cidade2
      diferenca = cidade2.comparaNome(link.cidade2);                   //Refatoração: Correção do BUG 05
    }
    return diferenca;
  }
}
