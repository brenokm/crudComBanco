package main;

import Classes.Pessoas;
import Connection.DatabaseConnection;
import Telas.telaListagem;
import java.util.ArrayList;


public class CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DatabaseConnection dbc = new DatabaseConnection();
              //  Pessoas pessoinha = new Pessoas("Sugiroki Mimami",30,"88516269519");
               // dbc.create(pessoinha);
        telaListagem tl = new telaListagem();
        tl.setVisible(true);
       
       //ArrayList<Pessoas> pessoasCadastradas = new ArrayList();
       //pessoasCadastradas = dbc.readAll();
       // for (int i = 0; i < pessoasCadastradas.size(); i++) {
          // System.out.println(pessoasCadastradas.get(i).mostrarDados()+"\n");
       // }
       // Pessoas pessoinha = new Pessoas("Sugiroki Mimami Noku",27,"29516269519");
      //  dbc.update(pessoinha, 10);
       // dbc.delete(5);
    }
    
}
