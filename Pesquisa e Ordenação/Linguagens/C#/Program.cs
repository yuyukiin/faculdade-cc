// See https://aka.ms/new-console-template for more information
using OrdenacaoDeObjetos;
using System.ComponentModel;

Aluno a1 = new Aluno("Alex", 50);
Aluno a2 = new Aluno("Dudu", 20);

Console.WriteLine(a2.CompareTo(a1));

List<Aluno> alunos = new List<Aluno>();
alunos.Add(new Aluno("Tei", 19));
alunos.Add(new Aluno("Gabriel", 23));
alunos.Add(new Aluno("Dudu", 20));
alunos.Add(new Aluno("Alex", 22));
alunos.Add(new Aluno("Brunim levanti", 20));
alunos.Add(new Aluno("Brunim nao levanti", 20));

//Metodo CompareTo
//alunos.Sort();
//alunos = alunos.OrderBy(a => a.Nome).ThenBy(a => a.Idade).ToList();

////Metodo Pente
//Ordenacao.pente(alunos);

foreach (var item in alunos)
{
    Console.WriteLine(item);
}
