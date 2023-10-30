package Connection;


import Classes.Pessoas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DatabaseConnection {
    //Colocar o nome do banco de dados que você criou
    private static final String URL = "jdbc:mysql://192.168.10.131:3306/crud_estela";
    //Colocar o usuario que loga no MySQL Workbench
    private static final String USER = "estela";
    //Colocar a senha que loga no MySQL Workbench
    private static final String PASSWORD = "luiz";

    //Método que faz a conexão com o banco de dados
    public static Connection GetConnection() {
        try {
            //Classe importada para usar o banco, sempre será usado no JAVA
            System.out.println("Funcionou");        
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Deu merda");
            throw new RuntimeException(e);
        }
        finally {
            
        }
    }
 // Método para inserir uma nova Pessoa no banco.
    public void create(Pessoas pessoa) {
        // Query SQL para inserção.
        String query = "INSERT INTO pessoa (cpf, nome, idade) VALUES (?, ?, ?)";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            // Atribui os valores da pessoa para a query.
            stmt.setString(1, pessoa.getCPF());
            stmt.setString(2, pessoa.getNome());
            stmt.setInt(3, pessoa.getIdade());
            // Executa a query.
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
    }
    
    // Método para recuperar todas as pessoas do banco.
    public ArrayList<Pessoas> readAll() {
        // Lista para armazenar as pessoas recuperadas.
        ArrayList<Pessoas> pessoas = new ArrayList<>();
        // Query SQL para seleção.
        String query = "SELECT * FROM pessoa";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement stmt = conn.prepareStatement(query);
            // Executa a query e armazena o resultado.
            ResultSet rs = stmt.executeQuery()
        ) {
            // Itera sobre o resultado.
            while (rs.next()) {
                // Adiciona cada pessoa à lista.
                pessoas.add(new Pessoas(rs.getInt("id_pessoa"),rs.getString("nome"), rs.getInt("idade"),rs.getString("CPF")));
            }
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
        // Retorna a lista de pessoas.
        return pessoas;
    }
    
     // Método para atualizar uma pessoa existente no banco.
    public void update(Pessoas pessoa, int id) {
        // Query SQL para atualização.
        String query = "UPDATE pessoa SET nome = ?, idade = ?, cpf = ? WHERE id_pessoa = ?";
        try (
            // Estabelece uma conexão com o banco.
            Connection conn = GetConnection();
            // Cria um PreparedStatement para executar a query.
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            // Atribui os valores da pessoa para a query.
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getCPF());
            stmt.setInt(4,pessoa.getId());
            // Executa a query.
            stmt.execute();
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro.
            throw new RuntimeException(e);
        }
    }
    
    public void delete (int id){
        String query = "DELETE FROM pessoa WHERE id_pessoa = ?";
        try(
                Connection conn = GetConnection();
                PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);
            stmt.execute();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}