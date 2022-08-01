import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Teste {
    @Test
    public void deveFicarADerivaQuandoFaltarCombustivelParaIrAteUmPlaneta() {
        int posicaoEsperada = 3;
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, new ArrayList<>());
        Planeta terra = new Planeta(2, Arrays.asList(new Recursos(RecursosEnum.Ouro.getValor(),RecursosEnum.Ouro.getPeso())));
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);
        planetas.add(terra);
        Collections.sort(planetas, Comparator.comparingInt(Planeta::getPosicao));
        milleniumFalcon.explorar(planetas);

        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void deveTerValorTotalZeradoQuandoNaoExistirNenhumRecurso() {
        double quantidadeDeRecursosEsperados = 0.0;
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, new ArrayList<>());
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);

        milleniumFalcon.explorar(planetas);
        double quantidadeDeRecursos = tatooine.valorTotal();

        Assert.assertEquals(quantidadeDeRecursosEsperados, quantidadeDeRecursos, 0.01);
    }

    @Test
    public void deveTerValorPorPesoZeradoQuandoNaoExistirNenhumRecurso() {
        double quantidadeDeRecursosEsperados = 0.0;
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, new ArrayList<>());
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);

        milleniumFalcon.explorar(planetas);
        double quantidadeDeRecursos = tatooine.valorPorPeso();

        Assert.assertEquals(quantidadeDeRecursosEsperados, quantidadeDeRecursos, 0.01);
    }

    @Test
    public void deveTerValorTotalQuandoExistirRecursosNoPlaneta() {
        double quantidadeDeRecursosEsperados = 300.0;
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, Arrays.asList(new Recursos(RecursosEnum.Ouro.getValor(),RecursosEnum.Ouro.getPeso()), new Recursos(RecursosEnum.Água.getValor(),RecursosEnum.Água.getPeso())));
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);

        milleniumFalcon.explorar(planetas);
        double quantidadeDeRecursos = tatooine.valorTotal();

        Assert.assertEquals(quantidadeDeRecursosEsperados, quantidadeDeRecursos, 0.01);
    }

    @Test
    public void deveTerValorPorPesoQuandoExistirRecursosNoPlaneta() {
        double quantidadeDeRecursosPorPesoEsperados = 4.8;
        Nave milleniumFalcon = new Nave(9);
        Planeta tatooine = new Planeta(4, Arrays.asList(new Recursos(RecursosEnum.Ouro.getValor(),RecursosEnum.Ouro.getPeso())));
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(tatooine);

        milleniumFalcon.explorar(planetas);
        double quantidadeDeRecursosPorPeso = tatooine.valorPorPeso();

        Assert.assertEquals(quantidadeDeRecursosPorPesoEsperados, quantidadeDeRecursosPorPeso, 0.01);
    }

    @Test
    public void testeExploracaoDePlanetas(){
        Nave milleniumFalcon = new Nave(19);
        List<Recursos> y = Arrays.asList(new Recursos(RecursosEnum.Oxigênio.getValor(),RecursosEnum.Oxigênio.getPeso()), new Recursos(RecursosEnum.Ouro.getValor(),RecursosEnum.Ouro.getPeso()), new Recursos(RecursosEnum.Água.getValor(),RecursosEnum.Água.getPeso()));
        double valorEsperado = 600.0;
        Planeta tatooine = new Planeta(3, Arrays.asList(new Recursos(RecursosEnum.Ouro.getValor(),RecursosEnum.Ouro.getPeso()), new Recursos(RecursosEnum.Água.getValor(),RecursosEnum.Água.getPeso())));
        Planeta terra = new Planeta(1, Arrays.asList(new Recursos(RecursosEnum.Oxigênio.getValor(),RecursosEnum.Oxigênio.getPeso())));
        List<Planeta> planetas = new ArrayList<>();

        planetas.add(tatooine);
        planetas.add(terra);
        //Collections.sort(planetas, Comparator.comparingDouble(Planeta::valorTotal));

        List<Recursos> x = milleniumFalcon.explorar(planetas);
        double valorExplorado = terra.valorTotal()+ tatooine.valorTotal();
        System.out.println(x);
        Assert.assertEquals(valorEsperado, valorExplorado, 0.01);
    }

    @Test
    public void collectionsGetPosicao() {
        int posicaoEsperada = 1;
        Nave milleniumFalcon = new Nave(17);
        Planeta tatooine = new Planeta(3, Arrays.asList(new Recursos(RecursosEnum.Silício.getValor(),RecursosEnum.Silício.getPeso()), new Recursos(RecursosEnum.Água.getValor(),RecursosEnum.Água.getPeso())));
        Planeta terra = new Planeta(1, Arrays.asList(new Recursos(RecursosEnum.Oxigênio.getValor(),RecursosEnum.Oxigênio.getPeso())));
        Planeta zord = new Planeta(2, Arrays.asList(new Recursos(RecursosEnum.Ferro.getValor(),RecursosEnum.Ferro.getPeso())));
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(terra);
        planetas.add(zord);
        planetas.add(tatooine);

        Collections.sort(planetas, Comparator.comparingInt(Planeta::getPosicao));
        milleniumFalcon.explorar(planetas);

        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void collectionsValorTotal() {
        int posicaoEsperada = 1;
        Nave milleniumFalcon = new Nave(17);
        Planeta tatooine = new Planeta(3, Arrays.asList(new Recursos(RecursosEnum.Silício.getValor(),RecursosEnum.Silício.getPeso()), new Recursos(RecursosEnum.Água.getValor(),RecursosEnum.Água.getPeso())));
        Planeta terra = new Planeta(1, Arrays.asList(new Recursos(RecursosEnum.Oxigênio.getValor(),RecursosEnum.Oxigênio.getPeso())));
        Planeta zord = new Planeta(2, Arrays.asList(new Recursos(RecursosEnum.Ferro.getValor(),RecursosEnum.Ferro.getPeso())));
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(terra);
        planetas.add(zord);
        planetas.add(tatooine);

        Collections.sort(planetas, Comparator.comparingDouble(Planeta::valorTotal));
        milleniumFalcon.explorar(planetas);

        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }

    @Test
    public void collectionsValorPorPeso() {
        int posicaoEsperada = 1;
        Nave milleniumFalcon = new Nave(17);
        Planeta tatooine = new Planeta(3, Arrays.asList(new Recursos(RecursosEnum.Silício.getValor(),RecursosEnum.Silício.getPeso()), new Recursos(RecursosEnum.Água.getValor(),RecursosEnum.Água.getPeso())));
        Planeta terra = new Planeta(1, Arrays.asList(new Recursos(RecursosEnum.Oxigênio.getValor(),RecursosEnum.Oxigênio.getPeso())));
        Planeta zord = new Planeta(2, Arrays.asList(new Recursos(RecursosEnum.Ferro.getValor(),RecursosEnum.Ferro.getPeso())));
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(terra);
        planetas.add(zord);
        planetas.add(tatooine);

        Collections.sort(planetas, Comparator.comparingDouble(Planeta::valorPorPeso));
        milleniumFalcon.explorar(planetas);

        int posicaoResultante = milleniumFalcon.getPosicao();

        Assert.assertEquals(posicaoEsperada, posicaoResultante);
    }
}
