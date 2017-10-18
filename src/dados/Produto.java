package dados;
public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private String codigoDeBarra;
    private int quantidade;

    public Produto(){
        this("", "", 0.0, "",0);
    }

    public Produto(String nome, String descricao, double preco, String codigo, int quantidade){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.codigoDeBarra = codigo;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
