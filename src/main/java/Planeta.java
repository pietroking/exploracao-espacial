import java.util.ArrayList;
import java.util.List;

public class Planeta {
    private Integer posicao;
    private List<Recursos> recursos;

    public Planeta(Integer posicao, List<Recursos> recursos) {
        this.posicao = posicao;
        this.recursos = recursos;
    }

    public double valorTotal(){
        return this.recursos.stream().mapToDouble(recurso -> recurso.getValor()).sum();
    }

    public Double valorPorPeso(){
        return this.recursos.stream().mapToDouble(recurso -> recurso.getValor() / recurso.getPeso()).sum();
    }

    public Integer getPosicao() {
        return posicao;
    }

    public List<Recursos> getRecursos(){
        return recursos;
    }
}
