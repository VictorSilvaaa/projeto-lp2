
public class prog{
    public static void main(String args[]){
        Loja lojaGomes = new Loja("Papelaria Gomes");

        //instanciando produtos
        Produto produtoCaneta = new Produto("Caneta", "Azul", 3.00f, 25); 
        Produto produtoCaderno = new Produto("Caderno", "96 folhas", 25.00f, 20); 
        Produto produtoLapis = new Produto("Lápis", "HB", 1.0f, 5); 

        //adicionando produtos na loja
        lojaGomes.setProdutos(produtoCaneta);
        lojaGomes.setProdutos(produtoCaderno);
        lojaGomes.setProdutos(produtoLapis);

        //instanciando vendedores
        Vendedor vendedorManoelG = new Vendedor("Manoel Gomes", 1);
        Vendedor vendedorJoaoG = new Vendedor("João Gomes", 2);
        Vendedor vendedorCiroG = new Vendedor("Ciro Gomes", 3);

        //adicionando vendedores na loja
        lojaGomes.setVendedor(vendedorManoelG);
        lojaGomes.setVendedor(vendedorJoaoG);
        lojaGomes.setVendedor(vendedorCiroG);
        
        //realizando vendas na loja
        lojaGomes.registrarVenda(vendedorManoelG, produtoCaneta, 5);
        lojaGomes.registrarVenda(vendedorManoelG, produtoCaderno, 2);

        lojaGomes.registrarVenda(vendedorJoaoG, produtoLapis, 3);
        lojaGomes.registrarVenda(vendedorCiroG, produtoLapis, 2);

        lojaGomes.registrarVenda(vendedorManoelG, produtoCaneta, 10);
        lojaGomes.registrarVenda(vendedorJoaoG, produtoCaderno, 9);

        lojaGomes.registrarVenda(vendedorManoelG, produtoLapis, 1);
        lojaGomes.registrarVenda(vendedorCiroG, produtoCaderno, 2);
        lojaGomes.registrarVenda(vendedorCiroG, produtoCaneta, 2);
        System.out.println();

        //mostrar estoque
        lojaGomes.mostrarEstoque();
        //relatorio completo
        lojaGomes.mostrarRelatorioCompleto();
    }
}