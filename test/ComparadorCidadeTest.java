import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorCidadeTest {

    public Cidade cidade1 = new Cidade("Cidade 01");
    public Cidade cidade2 = new Cidade("Cidade 02");
    public ComparadorCidade comparadorCidades = new ComparadorCidade();

    //Refactado o nome dos métodos para o padrão test<NomeDoMétodo>
    @Test
    void testCompareDistanciaPrimeiraCidadeMaisProxima() {
        cidade1.distancia=50;
        cidade2.distancia=100;
        assertEquals(-50,comparadorCidades.compare(cidade1,cidade2), "A primeira cidade não é a mais próxima a rede de trens");
    }
    @Test
    void testCompareDistanciaIgualDasCidadesParaRedeDeTrens() {
        cidade1.distancia=50;
        cidade2.distancia=50;
        assertEquals(0,comparadorCidades.compare(cidade1,cidade2), "As cidades não possuem distâncias iguais em relação a rede de trens");
    }
    @Test
    void testCompareDistanciaSegundaCidadeMaisProxima() {
        cidade1.distancia=100;
        cidade2.distancia=50;
        assertEquals(50,comparadorCidades.compare(cidade1,cidade2), "A segunda cidade não é a mais próxima a rede de trens");
    }
}