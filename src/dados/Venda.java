package dados;
public class Venda {
    private int idVenda;
    private Produto produto;
    private int quantidade;
    private String tipoDePagamento;
    private double totalPagamento;
    private double troco;
    private String dataDaVenda;

    public Venda(int idVenda, int quantidade){
        this(idVenda, "", 0, 0, "",null, quantidade);
    }

    public Venda(int idVenda, String tipoDePagamento, double totalPagamento, double troco, String dataDaVenda, Produto produto, int quantidade){
        this.idVenda = idVenda;
        this.tipoDePagamento = tipoDePagamento;
        this.totalPagamento = totalPagamento;
        this.troco = troco;
        this.dataDaVenda = dataDaVenda;
        this.produto = produto;
        this.quantidade = quantidade;
    }



    public double getTotalPagamento() {
        return totalPagamento;
    }

    public double getTroco() {
        return troco;
    }

    public String getTipoDePagamento() {
        return tipoDePagamento;
    }

    public void setTipoDePagamento(String tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }

    public void setTotalPagamento(double totalPagamento) {
        this.totalPagamento = totalPagamento;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda){
        this.dataDaVenda = dataDaVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setProduto(Produto produto) { this.produto = produto; }

    public Produto getProduto() { return produto; }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public int getQuantidade() { return quantidade; }
}
