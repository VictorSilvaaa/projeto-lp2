import java.util.ArrayList;
import java.lang.String;

public class Loja{
    private String nome;
    private ArrayList<Produto> produtos;
    private ArrayList<Vendedor> vendedores;

    public Loja(String nome){
        this.nome = nome;
        this.produtos = new ArrayList<Produto>();
        this.vendedores = new ArrayList<Vendedor>();
    }

    public void setVendedor(Vendedor vendedor){
        this.vendedores.add(vendedor);
    }

    public void setProdutos(Produto p){
        this.produtos.add(p);
    }

    public void registrarVenda(Vendedor v, Produto p, int quantidade){
        v.setVenda(p, quantidade);
        int pos = produtos.indexOf(p);
        produtos.get(pos).setEstoque(produtos.get(pos).getEstoque()-quantidade);
    }

    public void mostrarRelatorioCompleto(){
        float soma =0.0f;
        for(Vendedor v: this.vendedores){
            System.out.println(v.toString());
            System.out.println(String.format("----Relatório de venda %s----",v.getNome()));
            v.mostrarRelatorio();
            soma += v.getValorVendido();
        }
        System.out.println(String.format("\n-->valor total de vendas da loja: %.2f", soma));
    }

    public void mostrarEstoque(){
        for(Produto produto: produtos){
            System.out.println(String.format("Produto: %s \n Estoque: %d \n",produto.getNome(), produto.getEstoque()));
        }
    }
}