public enum RecursosEnum {

    Água(180.0, 10.0), Oxigênio(300.0, 2.0), Silício(60.0, 16.0), Ouro(120.0, 25.0), Ferro(30.0,32.0);
    private double valor;
    private double peso;

    private RecursosEnum(double valor, double peso) {
        this.valor = valor;
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }
}