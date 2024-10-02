import java.util.ArrayList;

public class Aluno {
    
    int idCurso;
    int idAluno;
    String nomeAluno, dt_nascAluno, CPFaluno;

        static ArrayList<Aluno> alunos = new ArrayList<>();


    public Aluno(int idAluno, String nomeAluno, String dt_nascAluno, String CPFaluno, int idCurso){

        this.idAluno =  idAluno;
        this.nomeAluno = nomeAluno;
        this.dt_nascAluno = dt_nascAluno;
        this.CPFaluno = CPFaluno;
        this.idCurso = idCurso;

        alunos.add(this);

    }

    static ArrayList<Aluno> buscaAlunoNoCurso(int idCurso) {
        ArrayList<Aluno> AlunoNoCurso = new ArrayList<Aluno>();

        for (Aluno aluno : alunos) {
            if (idCurso == aluno.idAluno) {
                AlunoNoCurso.add(aluno);
            }
        }

        return AlunoNoCurso;
    }

}
