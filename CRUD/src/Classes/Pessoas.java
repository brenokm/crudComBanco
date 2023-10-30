package Classes;


public class Pessoas {
    
    private String nome;
    private int idade;
    private String CPF;
    private int id;

    public Pessoas() {
    }
    
    

    public Pessoas(int id,String nome, int idade, String CPF) {
        this.id=id;
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String mostrarDados(){
        return"ID:"+getId()+" | "+"Nome: "+getNome()+" | Idade: "+getIdade()+" | CPF: "+getCPF()+" |\n";
    }
           
    
}
