package br.com.curso.app;

import br.com.curso.dao.CursoDAO;
import br.com.curso.model.Curso;

public class Main {
    public static void main(String[] args) {


        /**Create registro no DB**/
        Curso curso = new Curso();

        curso.setNome("nomeCurso");
        curso.setDuracaoHoras("quantHoras");

        //cursoDAO.save(curso);


        /**Read registros do DB**/

        CursoDAO cursoDAO = new CursoDAO();

        for(Curso cursoSelect : cursoDAO.getCurso()){
            System.out.println("Curso: "+cursoSelect.getNome()+" - "+"Duração: "+cursoSelect.getDuracaoHoras());
        }


        /**Update registro no DB**/
        Curso cursoUpdate = new Curso();

        cursoUpdate.setId(13);
        cursoUpdate.setNome("Curso C++");
        cursoUpdate.setDuracaoHoras("6 Horas");

        //cursoDAO.update(cursoUpdate);

        /**Delete registro no DB**/

        //cursoDAO.deleteByID(5);

    }
}
