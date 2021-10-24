import java.util.Comparator;

/* Compare two cidades for use in sorting or data structures
 */ 
public class ComparadorCidade implements Comparator<Cidade> {
  /* compare cidades by their distancia from the start of the rail network
   * return: negative if c1 is closer to 0, 0 if equal distancia, positive if c2 is closer to 0
   */
  public int compare(Cidade x, Cidade y) {
    //return x.comparaDistancia(y,x);  //BUG03 Os parâmetros estão invertidos
    return x.comparaDistancia(y);  //Correção do código e a refatoração para passar somente um parâmetro
  }
}
