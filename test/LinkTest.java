import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    //Refactado o nome dos métodos para o padrão test<NomeDoMétodo>

    public Cidade cidade1 = new Cidade("Cidade 01");
    public Cidade cidade2 = new Cidade("Cidade 02");
    public Cidade cidade3 = new Cidade("Cidade 03");
    public Cidade cidade4 = new Cidade("Cidade 04");
    public Link linkCidades = new Link(cidade1, cidade2, 550);

    /* retorna o tamanho de um link entre duas cidades */
    @Test
    void testGetTamanho() {
        assertEquals(550,linkCidades.getTamanho(),"O valor do tamanho está inconsistente");
    }

    @Test
    void testIsUsado() {
        assertTrue(linkCidades.isUsado(),"O Link entre as cidades não está sendo usado");
    }

    @Test
    void testSetUsado() {
        linkCidades.setUsado(false);
        assertFalse(linkCidades.isUsado(), "Não foi possível atualizar o valor da variável usado");
    }

    @Test
    void testToString() {
        Link linkCidadeInvetido = new Link(cidade3, cidade4, 700);
        assertEquals("Cidade 03 "+linkCidadeInvetido.tamanho+"Km Cidade 04",linkCidadeInvetido.toString(), "As informações sobre o link entre as cidades está inconsistente");
    }

    @Test
    void testCompareToLinksComAsMesmasCidades() {
         assertEquals(0,linkCidades.compareTo(linkCidades), "Os links não possuem as cidades iguais");
    }
    @Test
    void testCompareToLinksComAsCidadesDiferentes() {
        Link linkCidadesDiferentes = new Link(cidade3, cidade4, 550);
        int valorComparacao = linkCidades.compareTo(linkCidadesDiferentes);
        assertTrue(valorComparacao < 0,"Os links não possuem todas as cidades diferentes");
    }
    @Test
    void testCompareToLinksComSomenteAsPrimeirasCidadesIguais() {
        Link linkCidadesDiferentes = new Link(cidade1, cidade4, 550);
        int valorComparacao = linkCidades.compareTo(linkCidadesDiferentes);
        assertTrue(valorComparacao < 0, "Os links não possuem as primeiras cidades iguais ");
    }
    @Test
    void testCompareToLinksCidade1MaiorComAsSegundasCidadesIguais() {
        Link linkCidadesDiferentes = new Link(cidade3, cidade2, 550);
        int valorComparacao = linkCidadesDiferentes.compareTo(linkCidades);
        assertTrue(valorComparacao > 0, "O link1 não possue a Cidade1 maior e/ou as segundas cidades iguais");
    }
    @Test
    void testCompareToLinksCidade1MenorComAsSegundasCidadesIguais() {
        Link linkCidadesDiferentes = new Link(cidade3, cidade2, 550);
        int valorComparacao = linkCidades.compareTo(linkCidadesDiferentes);
        assertTrue(valorComparacao < 0, "O link1 não possue a Cidade1 menor e/ou as segundas cidades iguais");
    }
}