import java.util.ArrayList;
import java.lang.String;

public class Loja{
    //definindo atributos
    private String nome;
    private ArrayList<Produto> produtos;
    private ArrayList<Vendedor> vendedores;

    //metodo construtor
    public Loja(String nome){
        this.nome = nome;
        //inicializando arraylists
        this.produtos = new ArrayList<Produto>();
        this.vendedores = new ArrayList<Vendedor>();
    }

    public void setVendedor(Vendedor vendedor){
        boolean flag = true;
       for(Vendedor v: this.vendedores){
        //verifica se vendedor ja esta cadastrado
            if(v.equals(vendedor)){
                System.out.println("Vendedor já está cadastrado");
                flag= false;
                break;
            }
       } 
       //se vendedor não tiver cadastrado
       if(flag){
            this.vendedores.add(vendedor);
       }
    }

    public void setProdutos(Produto p){
        this.produtos.add(p);
    }

    public void registrarVenda(Vendedor v, Produto p, int quantidade){
        int pos = produtos.indexOf(p); //posição do elemento no arraylist
        int novoEstoque = produtos.get(pos).getEstoque()-quantidade; 
        if(novoEstoque>=0 && quantidade>0){
            produtos.get(pos).setEstoque(novoEstoque); //atualiza estoque
            v.setVenda(p, quantidade); //registra venda para o vendedor
            System.out.println("Venda realizada com sucesso.");
        }else{
            //caso não tenha estoque suficiente
            System.out.println("Venda não realizada com sucesso.");
        }
    }

    public void mostrarRelatorioCompleto(){
        float soma =0.0f;
        System.out.println(String.format("---------------Relatório de %s------------------", this.nome));
        for(Vendedor v: this.vendedores){
            System.out.println(v.toString());
            System.out.println(String.format("----Relatório de venda %s----",v.getNome()));
            //chama função de relatório do vendedor
            v.mostrarRelatorio();
            //pega valor da venda de cada vendedor e vai somando pra um valor total da loja
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