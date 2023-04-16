import java.util.HashMap;
import java.util.Map;
import java.lang.String;



public class Vendedor{
    private int matricula;
    private String nome;
    private float valorVendido;
    private HashMap<Produto, Integer> vendas;

    public Vendedor(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.vendas = new HashMap<Produto, Integer>();
    }

    public void setVenda(Produto produto, int quantidade){
        if(this.vendas.get(produto)==null){
            this.vendas.put(produto, quantidade);
        }else{
            int novaQuantidade = this.vendas.get(produto) + quantidade;
            this.vendas.put(produto, novaQuantidade);
        }    
    }
   
    public void mostrarRelatorio(){
        float soma = 0.0f;
        for(Map.Entry<Produto, Integer> venda: vendas.entrySet()){
            String txt = String.format(
                "Produto: %s \ndescrição: %s \nquantidade: %d", 
                venda.getKey().getNome(), 
                venda.getKey().getDescricao(), 
                venda.getValue());
            System.out.println(txt);
            System.out.println();
           
            soma += venda.getValue() * venda.getKey().getValor();
            this.valorVendido = soma;
        }
        System.out.println(String.format("Valor Total vendido por %s foi: %.2f\n",this.nome, this.valorVendido));
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

    public float getValorVendido() {
        return this.valorVendido;
    }

    public String toString(){
        String x = String.format(
                "Nome do vendedor: %s \nMatricula: %s", this.nome, this.matricula
        );
        return x;
    }
}