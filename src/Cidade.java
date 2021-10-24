import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Cidade {

  public static HashMap<String, Cidade> cidades = new HashMap<String, Cidade>(); // Tabela com todas as cidades por nome
  public String nome;                                                            // Nome da cidade
  public final HashSet<Link> links = new HashSet<Link>();                        // Link da cidade adjacente
  public int distancia;                                                          // Menor distancia
  public Link linkPai;                                                           // Menor caminho percorrido


  /**
   *Contrutor para Cidade com um nome
   * adicionado a tabela (HashMap) de cidades
   */                                                                        //Refatoração: Padronização do comentário
  public Cidade(String nomeDaCidade) {                                       //Refatoração: Alteração no nome do parâmetro para nomeDaCidade
    this.nome = nomeDaCidade;
    cidades.put(nome, this);
  }

  /**
   * @description Método para encontrar uma cidade pelo nome
   * @param nomeDaCidade Cidade a ser encontrada
   * @return a cidade se ela existir na tabela;
   *         uma nova cidade com o nome informado, caso contrário;
   */                                                                       //Refatoração: Padronização do comentário
  public static Cidade encontrar(String nomeDaCidade) {                     //Refatoração: O nome do parâmetro foi alterado para nomeDaCidade
    Cidade p = cidades.get(nomeDaCidade);
    if (p == null) {
      p = new Cidade(nomeDaCidade);
      //return null;                                                        //BUG 01: Deveria retornar a nova cidade com o nome informado
    }                                                                        //Refatoração: Correção do BUG 01, atraves da exlusão do retorn null interno ao IF
    return p;
  }

  /**
   * @description Adiciona um link entre cidades na lista de links
   * @param link link entre cidades
   */                                                                      //Refatoração: Padronização do comentário
  public void addLink(Link link) {
    links.add(lnk);
  }

  /**
   * @description Compara cidades pelos seus nomes
   *              até a rede de trens (ponto 0)
   * @param cidadeAComparar Cidade a ser comparada
   * @return inteiro negativo se cidadeAComparar for alfabeticamente maior;
   *         0 se os nomes forem os menos;
   *         inteiro positivo se cidadeAComparar for alfabeticamente menor;
   */                                                                      //Refatoração: Padronização do comentário
  public int comparaNome(Cidade cidadeAComparar) {                         //Refatoração: Nome de parâmetro alterado para cidadeAComparar
    //return p.nome.compareTo(cidadeAComparar.nome);                       //BUG 02: Sempre iria comparar o nome do mesmo objeto e sempre retorna 0
    return this.nome.compareTo(cidadeAComparar.nome);                      //Refatoração: Código corrigido
  }

  /**
   * @description Retorna o nome da cidade
   * @return String nome da cidade
   */                                                                      //Refatoração: Padronização do comentário
  public String toString() {
    return nome;
  }

  /**
   * @description Compara cidades pela sua distancia
   *              até a rede de trens (ponto 0)
   * @param cidadeAComparar Cidade a ser comparada
   * @return inteiro negativo se cidadeAComparar for mais distante;
   *         0 se a distancia for a mesma;
   *         inteiro positivo se cidadeAComparar for mais próxima;
   */                                                                      //Refatoração: Padronização do comentário
  public int comparaDistancia(Cidade cidadeAComparar) {
    return (this.distancia - cidadeAComparar.distancia);                   //Refatoração: Foi utilizado o this para evitar a passagem de dois parâmetros
  }

}
