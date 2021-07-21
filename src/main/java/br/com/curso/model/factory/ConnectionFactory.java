/**
 * Classe de conexão
 */

package br.com.curso.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    /**Nome do usuario do DB**/
    private static final String USERNAME = "root";

    /**Senha do usuario do DB**/
    private static final String PASSWORD = "1234";

    /**Protocolo, SGBD, Caminho do DB, porta,nome DB **/
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/dio";

    /**Conexão com o DB**/
    public static Connection createConnectionToMySQL() throws Exception {

        /**Faz com que a classe seja carregada pela JVM**/
        //Class.forName("com.mysql.jdbc.Driver");

        /**Cria a conexão com o DB**/
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {

        /**Recuperar uma conexão com o DB**/

        Connection connection = createConnectionToMySQL();

        /**Testar se a conexão é nula**/
        if(connection!=null){
            System.out.println("CONEXÃO OBTIDA COM SUCESSO!");
            connection.close();
        }
    }

}
