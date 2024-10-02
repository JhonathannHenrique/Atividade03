import java.util.ArrayList;


public class Professor {

    int idProfessor;
    String nomeProf, departamento;

    static ArrayList<Professor> professores = new ArrayList<>();


    public Professor(int idProfessor, String nomeProf, String departamento){

        this.idProfessor = idProfessor;
        this.nomeProf = nomeProf;
        this.departamento = departamento;


        professores.add(this);
    }

    static Professor buscaProf(int prof) {
        for(Professor professor : professores) {
            if (prof == professor.idProfessor) {
                return professor;
            }
        }

        return null;
    }
    static ArrayList<Professor> buscaProfessorPorCurso(int idCurso) {
        ArrayList<Professor> ProfessorPorCurso = new ArrayList<Professor>();

        for (Professor professor : professores) {
            if (idCurso == professor.idProfessor) {
                ProfessorPorCurso.add(professor);
            }
        }

        return ProfessorPorCurso;
    }
}
