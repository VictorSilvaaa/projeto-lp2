import java.util.HashMap;
import java.util.Map;
import java.lang.String;



public class Vendedor{
    private int matricula;
    private String nome;
    private float valorVendido;
    private HashMap<Produto, Integer> vendas;

    public Vendedor(){

    }
    public Vendedor(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.vendas = new HashMap<Produto, Integer>();
    }

    public void setVenda(Produto produto, int quantidade){
        this.vendas.put(produto, quantidade);
    }
   

    public void mostrarRelatorio(){
        float soma = 0;
        String nomeVendedor;
        for(Map.Entry<Produto, Integer> venda: vendas.entrySet()){
            String x = String.format(
                "Produto: %s \ndescrição: %s \nquantidade: %d", 
                venda.getKey().getNome(), 

                venda.getKey().getDescricao(), 
                venda.getValue());
            System.out.println(x);
            System.out.println();
           

            soma = venda.getValue() * venda.getKey().getValor();
            this.valorVendido = soma;
        }
        System.out.println(String.format("Valor Total vendido por %s foi: %.2f\n",this.nome, soma));
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String toString(){
        String x = String.format(
                "Nome do vendedor: %s \nMatricula: %s", this.nome, this.matricula
        );
        return x;
    }

    public float getValorVendido() {
        return this.valorVendido;
    }
}