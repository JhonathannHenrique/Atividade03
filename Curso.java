import java.util.ArrayList;

public class Curso {

    int idProfessor;

    int idCurso, cargaHrsCurso;
    String nomeCurso;
    Professor professor;

        static ArrayList<Curso> cursos = new ArrayList<>();


    public Curso(int idCurso, String nomeCurso, int cargaHrsCurso, int idProfessor){

        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.cargaHrsCurso = cargaHrsCurso;
        this.idProfessor = idProfessor;
        this.professor = Professor.buscaProf(idProfessor);
    }

    static Curso buscaCurso(int id) {
        for(Curso curso : cursos) {
            if (id == curso.idCurso) {
                return curso;
            }
        }

        return null;
    }

    static ArrayList<Curso> buscaCursoPorProfessor(int idProfessor) {
        ArrayList<Curso> cursoPorProfessor = new ArrayList<Curso>();

        for (Curso curso : cursos) {
            if (idProfessor == curso.idProfessor) {
                cursoPorProfessor.add(curso);
            }
        }

        return cursoPorProfessor;
    }
}
