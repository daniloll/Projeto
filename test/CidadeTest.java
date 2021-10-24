import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CidadeTest {

    public Cidade cidade1 = new Cidade("Cidade 01");
    public Cidade cidade2 = new Cidade("Cidade 02");
    public Link linkCidades = new Link(cidade1, cidade2, 100);

    //Refactado o nome dos métodos para o padrão test<NomeDoMétodo>

    @Test
    void testEncontrar() {
        assertEquals(cidade1, cidade1.encontrar("Cidade 01"), "A cidade informada não foi encontrada");
    }
    @Test
    void testEncontrarCidadeNaoExiste() {
        Cidade novaCidade = cidade1.encontrar("Cidade 03");
        assertEquals("Cidade 03", novaCidade.nome, "A cidade informada não foi encontrada");
    }

    @Test
    void testAddLink() {
        cidade1.addLink(linkCidades);
        assertTrue(linkCidades.isUsado(), "Não foi possível adicionar o link entre as cidades");
    }

    @Test
    void testComparaNomeAlfabeticamenteMenor() {
        assertEquals(-1,cidade1.comparaNome(cidade2),"Nome da cidade não é alfabeticamente Menor");
    }
    @Test
    void testComparaNomeIguais() {
        assertEquals(0,cidade1.comparaNome(cidade1),"Nome das cidades não são iguais");
    }
    @Test
    void testComparaNomeAlfabeticamenteMaior() {
        assertEquals(1,cidade2.comparaNome(cidade1),"Nome da cidade não é alfabeticamente Maior");
    }

    @Test
    void testToString() {
        assertEquals("Cidade 01", cidade1.toString(),"Não retornou o nome da cidade");
    }

    @Test
    void testComparaDistanciaPrimeiraCidadeMaisProxima() {
        cidade1.distancia=50;
        cidade2.distancia=100;
        assertEquals(-50,cidade1.comparaDistancia(cidade2));
    }
    @Test
    void testComparaDistanciaIgualDasCidadesParaRedeDeTrens() {
        cidade1.distancia=50;
        cidade2.distancia=50;
        assertEquals(0,cidade1.comparaDistancia(cidade2));
    }
    @Test
    void testComparaDistanciaSegundaCidadeMaisProxima() {
        cidade1.distancia=100;
        cidade2.distancia=50;
        assertEquals(50,cidade1.comparaDistancia(cidade2));
    }
}