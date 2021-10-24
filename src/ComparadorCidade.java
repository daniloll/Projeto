import java.util.Comparator;

/**
 * Compare duas cidades para uso em classificação ou estruturas de dados
 */
public class ComparadorCidade implements Comparator<Cidade> {



  /**
   * Compara cidades pelo distancia  do ponto de início da rede ferroviaria
   * return: inteiro negativo se cidade1 estiver mais perto da origem 0,
   *         0 se distancias iguais,
   *         inteiro positivo se cidade2 estiver mais perto da origem 0
   */                                                      //Refatoração: Padronização do comentário
  public int compare(Cidade cidade1, Cidade cidade2) {     //Refatoração: O nome do parâmetro foram alterados para cidade1 e cidade2
    //return x.comparaDistancia(y,x);                      //BUG 03: Os parâmetros estão invertidos
    return cidade1.comparaDistancia(cidade2);                          //Refatoração: Correção do BUS 03, através do ajuste dos parâmetros
                                                           //Refatoração: ajustando a passagem de apenas um parâmetro
  }

}
