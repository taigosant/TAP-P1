package dados;
public class Compra {
    private double precoCompra;
    private String unidadeDeMedida;
    private double precoDeVenda;
    private int quantidade;
    private Produto produto;
    private String dataDaCompra;
    private int idCompra;

    public Compra(int idCompra){
        this("", 0.0, 0, null, "", idCompra);
    }

    public Compra(String unidade, double pVenda, int qtd, Produto prod, String data, int idCompra){
        this.dataDaCompra = data;
        this.idCompra = idCompra;
        this.precoCompra = prod.getPreco() * qtd;
        this.precoDeVenda = pVenda;
        this.produto = prod;
        this.unidadeDeMedida = unidade;
        this.quantidade = qtd;

    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getDataDaCompra() {
        return dataDaCompra;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setDataDaCompra(String dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void setPrecoDeVenda(double precoDeVenda) { this.precoDeVenda = precoDeVenda; }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public int getIdCompra() { return idCompra; }

    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }
}
