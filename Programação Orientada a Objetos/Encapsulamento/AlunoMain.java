package Exemplos;

public class AlunoMain {

	public static void main(String[] args) {
		Aluno aluno = new Aluno("Yuri", 6, 5, 9);
		
		
		System.out.println("Notas");
		System.out.println(aluno.getNome());
		System.out.println(aluno.getNota1());
		System.out.println(aluno.getNota2());
		System.out.println(aluno.getNota3());
		
		System.out.println("Media Da Yuri: " + aluno.calculaMedia());
		
		aluno.setNome("Angela");
		aluno.setNota1(6);
		aluno.setNota2(7);
		aluno.setNota3(9);
		
		System.out.println("Notas");
		System.out.println(aluno.getNome());
		System.out.println(aluno.getNota1());
		System.out.println(aluno.getNota2());
		System.out.println(aluno.getNota3());
		
		System.out.println("Media Da Angela: " + aluno.calculaMedia());
		
	}

}
