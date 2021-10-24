/* Classe que trata da construção de links entre as cidades
 */
public class Link implements Comparable<Link> {
  public Cidade cidade1;
  public Cidade cidade2;
  public int tamanho;
  public boolean usado = false;

  /* Construct cria um Link entre a primeiracidade e a segunda cidade com um tamanho "tam
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

  /* retorna o tamanho de um link entre duas cidades */
  public int getTamanho() {
    return tamanho;
  }

  /* returna true se o link entre duas cidades existir */
  public boolean isUsado() {
    return usado;
  }

  /* set usado como u */
  public void setUsado(boolean u) {
    usado = u;
  }

  /* returna uma string com a descrição de um Link entre cidades
   * exemplo "Cidade1 3 Cidade2"
   * O nome das cidades tem de vir em ordem alfabética, exemplo, Olinda vem antes de Recife
   */
  public String toString() {
//    return cidade1.toString() + " " + cidade2.toString(); //BUG04: Não estava retornando a distancia entre as cidades
    return cidade1.toString() + " "+tamanho+"Km "+ cidade2.toString();

  }

  /* Compara dois links para saber se são o mesmo caminho
   * returna 0 se os links tiverem as mesmas cidade1 e cidade2
   * return negativo se this.cidade1 < l.cidade1 ou se cidade1 é igual nos dois links e this.cidade2 < l.cidade2
   * retorna positivo caso contrário
   */
  public int compareTo(Link l) {
    int diferenca = cidade1.comparaNome(l.cidade1);
    if (diferenca == 0) {     //BUG05: Estava fazendo a comparação somente para uma das cidades, faltando comparar o valor da cidade2
//      diferenca = cidade1.comparaNome(l.cidade1);
      diferenca = cidade2.comparaNome(l.cidade2);
    }
    return diferenca;
  }
}
