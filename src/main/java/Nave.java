import java.util.ArrayList;
import java.util.List;

public class Nave {

    private Integer posicao;
    private Integer combustivel;

    public Nave(Integer combustivel) {
        this.combustivel = combustivel;
        this.posicao = 0;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public Integer getQuantidadeDeCombustivel() {
        return combustivel;
    }

    public void setQuantidadeDeCombustivel(Integer combustivel) {
        this.combustivel = combustivel;
    }

    public List<Recursos> explorar(List<Planeta> planetas){
        List<Recursos> recursosExplorados = new ArrayList<>();
        Integer posicaoAtual = 0;
        for (Planeta planeta : planetas){
            while (planeta.getPosicao() > posicaoAtual){
                if (this.getQuantidadeDeCombustivel() < 3){
                    this.setPosicao(posicaoAtual);
                    break;
                }
                posicaoAtual = posicaoAtual + 1;
                this.setQuantidadeDeCombustivel(this.getQuantidadeDeCombustivel()-3);
                if (planeta.getPosicao().equals(posicaoAtual)){
                    recursosExplorados.addAll(planeta.getRecursos());
                    this.setPosicao(posicaoAtual);
                    break;
                }
                this.setPosicao(posicaoAtual);
            }
            while(planeta.getPosicao() < posicaoAtual){
                if (this.getQuantidadeDeCombustivel() < 3){
                    this.setPosicao(posicaoAtual);
                    break;
                }
                posicaoAtual = posicaoAtual - 1;
                this.setQuantidadeDeCombustivel(this.getQuantidadeDeCombustivel()-3);
                if (planeta.getPosicao().equals(posicaoAtual)){
                    recursosExplorados.addAll(planeta.getRecursos());
                    this.setPosicao(posicaoAtual);
                    break;
                }
                this.setPosicao(posicaoAtual);
            }
        }
        while(getQuantidadeDeCombustivel() > 2 && !this.getPosicao().equals(0)){
            this.setPosicao(this.getPosicao() - 1);
            this.setQuantidadeDeCombustivel(this.getQuantidadeDeCombustivel()-3);
        }
        return recursosExplorados;
    }
}
