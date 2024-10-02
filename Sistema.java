import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

     public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

         ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();

        int opcao = 0;

        // int idAluno, idCurso, idProfessor, cargaHrsCurso;
        // String nomeAluno, nomeProf, nomeCurso, departamento, dt_nascAluno, CPFaluno;

        do{
            System.out.println("Menu De Sistema de Notas:");
            System.out.println("[1] - Cadastrar Professor.");
            System.out.println("[2] - Cadastrar Curso.");
            System.out.println("[3] - Cadastrar Aluno.");
            System.out.println("[4] - Listar Professor.");
            System.out.println("[5] - Listar Curso.");
            System.out.println("[6] - Listar Aluno.");
            System.out.println("[7] - Encerrar Programa.");
            System.out.print("Digite a opção desejada: "); // Menu de opções
            opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário

            switch (opcao) {
                case 1:
                try{
                    System.out.println("Cadastrar Professor.");
                    System.out.println("Digite o ID do Professor:");
                    int idProfessor = scanner.nextInt();
                    System.out.println("Digite o nome do Professor.");
                    String nomeProf = scanner.next();
                    System.out.println("Digite o departamento do Professor.");
                    String departamento = scanner.next();
                    Professor Professor = new Professor(idProfessor, nomeProf, departamento);
                    professores.add(Professor);
                    break;
                    }catch (Exception e) {
                        System.out.println("Erro ao incluir Professor");
                    }

                case 2:
                try{
                    System.out.println("Cadastrar Curso.");
                    System.out.println("Digite o ID da Curso:");
                    int idCurso = scanner.nextInt();
                    System.out.println("Digite o nome do Curso.");
                    String nomeCurso = scanner.next();
                    System.out.println("Digite a carga horaria do Curso:");
                    int cargaHrsCurso = scanner.nextInt();
                    System.out.println("Digite o ID do Professor:");
                    int idProfessor = scanner.nextInt();
                    Curso Curso = new Curso(idCurso,nomeCurso,cargaHrsCurso,idProfessor);
                    cursos.add(Curso);
                    break;
                    }catch (Exception e) {
                        System.out.println("Erro ao incluir Curso");
                    }

                case 3:
                try{
                    System.out.println("Cadastrar Aluno.");
                    System.out.println("Digite o ID do Aluno:");
                    int idAluno = scanner.nextInt();
                    System.out.println("Digite o nome do Aluno.");
                    String nomeAluno = scanner.next();
                    System.out.println("Digite a data de nascimento do Aluno.");
                    String dt_nascAluno = scanner.next();
                    System.out.println("Digite o CPF do Aluno.");
                    String CPFaluno = scanner.next();
                    System.out.println("Digite o ID do Curso:");
                    int idCurso = scanner.nextInt();
                    Curso cursoAluno = cursos.get(idCurso);
                    Aluno Aluno = new Aluno(idAluno, nomeAluno, dt_nascAluno, CPFaluno, idCurso);
                    alunos.add(Aluno);
                    break;
                    }catch (Exception e) {
                        System.out.println("Erro ao incluir Aluno");
                    }

                case 4:
                    System.out.println("\nListar Professor:");
                    System.out.println("Professores Cadastrados:");
                    
                    if (professores.isEmpty()) {
                        System.out.println("\nNenhum Professor cadastrado.");
                        return;
                    }

                    for (Professor professorPrint : professores) {
                        System.out.println(" Nome: " + professorPrint.nomeProf + "Departamento: " + professorPrint.departamento);
                        System.out.println("Cursos associados: ");
                        ArrayList<Curso> cursosPorProfessor = Curso.buscaCursoPorProfessor(professorPrint.idProfessor);
                        for (Curso cursoPrint : cursosPorProfessor) {
                            System.out.println(cursoPrint.nomeCurso);
                        }
                        System.out.println("\n");
                    }break;

                case 5:
                    System.out.println("Listar Cursos.");
                    System.out.println("Cursos Cadastrados:");
                    
                    if (cursos.isEmpty()) {
                        System.out.println("\nNenhum Curso cadastrado.");
                        return;
                    }
                    for (Curso cursoPrint : cursos) {
                        System.out.println(" Nome: " + cursoPrint.nomeCurso + "Carga Horaria: " + cursoPrint.cargaHrsCurso);
                        System.out.println("Professores associados: ");
                        ArrayList<Professor> ProfessorPorCurso = Professor.buscaProfessorPorCurso(cursoPrint.idCurso);
                        for (Professor professorPrint : ProfessorPorCurso) {
                            System.out.println(professorPrint.nomeProf);
                        }
                    }break;

                case 6:
                    System.out.println("Listar Alunos.");
                    System.out.println("Alunos Cadastrados:");
                    
                    if (cursos.isEmpty()) {
                        System.out.println("\nNenhum Aluno cadastrado.");
                        return;
                    }
                    for (Aluno alunoPrint : alunos) {
                        System.out.println(" Nome: " + alunoPrint.nomeAluno + "Data Nascimento: " + alunoPrint.dt_nascAluno + "CPF: " + alunoPrint.CPFaluno);
                        System.out.println("Curso associado a aluno: ");
                        ArrayList<Aluno> AlunoNoCurso = Aluno.buscaAlunoNoCurso(alunoPrint.idCurso);
                        for (Aluno cursoPrint : AlunoNoCurso) {
                            System.out.println(alunoPrint.nomeAluno);
                        }
                    }break;

                case 7:
                    System.out.println("Encerrando o Programa.");
                    break;

                default:
                System.out.println("Opção Invalida.");
                    break;
            }
            
        }while(opcao !=7);

        scanner.close();
    }
}
