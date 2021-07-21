/**Faz com que o java se molde a estrura do DB**/
package br.com.curso.dao;

import br.com.curso.model.Curso;
import br.com.curso.model.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    /**
     * CRUD
     **/

    public void save(Curso curso) {
        String sql = "INSERT INTO curso(nome, duracaoHoras) VALUES ( ?, ?)";

        /**Aciona a conexão do DrriverManager**/
        Connection connection = null;

        /**Prepara uma esrutura para executar o java com SQL **/
        PreparedStatement preparedStatement = null;

        try {
            /**Criar a conexão com o DB**/
            connection = ConnectionFactory.createConnectionToMySQL();

            /**preparedStatement criada para executar uma query**/
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            /**Adicionar os valoes esperados pela query**/
            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setString(2, curso.getDuracaoHoras());

            /**Executar a Query**/
            preparedStatement.execute();
            System.out.println("DADOS INSERIDOS NA TABELA COM SUCESSO!");
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            /**Fechar as conexões**/
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    public List<Curso> getCurso(){

        String sql = "SELECT * FROM curso";

        List<Curso> cursos = new ArrayList<Curso>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        /**Classe que vai trazer os dados do banco**/
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQL();

            preparedStatement = connection.prepareStatement(sql);

            /**Tras as infomações semelhante a um Array**/
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Curso curso = new Curso();

                /**Recuperar o id**/
                curso.setId(resultSet.getInt("id"));
                /**Recuperar o nome**/
                curso.setNome(resultSet.getString("nome"));
                /**Recuperar o duracaoHoras**/
                curso.setDuracaoHoras(resultSet.getString("duracaoHoras"));

                cursos.add(curso);

            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (Exception exception){
                exception.printStackTrace();

            }
        }
        return cursos;
    }

    public void update(Curso curso){

        String sql = "UPDATE curso SET nome = ?, duracaoHoras = ? WHERE id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            //Criar conexão com o DB
            connection = ConnectionFactory.createConnectionToMySQL();

            //Criar a classe para executar a query

            preparedStatement = connection.prepareStatement(sql);

            //Adicionar os valores para atualizar
            preparedStatement.setString( 1, curso.getNome());
            preparedStatement.setString(2, curso.getDuracaoHoras());

            //Qual o ID do registro que deseja atualizar?
            preparedStatement.setInt(3, curso.getId());

            //Executar a query
            preparedStatement.execute();

        }catch (Exception exceptionn){
            exceptionn.printStackTrace();
        }finally {
            try{
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    public void deleteByID(int id){

        String sql = "DELETE FROM curso WHERE id = ? ";

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
                connection = ConnectionFactory.createConnectionToMySQL();

                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1, id);

                preparedStatement.execute();

            }catch (Exception exception){
                exception.printStackTrace();

        }finally {
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if(connection!=null){
                    connection.close();
                }

            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}


