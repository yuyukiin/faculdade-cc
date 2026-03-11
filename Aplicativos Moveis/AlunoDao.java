package com.example.exemplocrud1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public AlunoDao(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("cpf", aluno.getCpf());
        values.put("curso", aluno.getCurso());
        values.put("endereco", aluno.getEndereco());
        values.put("telefone", aluno.getTelefone());

        return banco.insert("aluno", null, values);
    }

    public List<Aluno> obterTodos() {
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = banco.query("aluno", new String[]{"id", "nome", "cpf", "curso", "endereco", "telefone"},
                null, null, null, null, null);

        while (cursor.moveToNext()) {
            Aluno a = new Aluno();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setCpf(cursor.getString(2));
            a.setCurso(cursor.getString(3));
            a.setEndereco(cursor.getString(4));
            a.setTelefone(cursor.getString(5));
            alunos.add(a);
        }
        cursor.close();
        return alunos;
    }

    public boolean validaCpf(String CPF) {
        CPF = CPF.replaceAll("[^0-9]", "");

        if (CPF.length() != 11) {
            return false;
        }

        if (CPF.matches("(\\d)\\1{10}")) {
            return false;
        }

        char dig10, dig11;
        int soma, num, peso, resto;

        try {
            soma = 0;
            peso = 10;
            for (int i = 0; i < 9; i++) {
                num = CPF.charAt(i) - 48;
                soma = soma + (num * peso);
                peso = peso - 1;
            }
            resto = 11 - (soma % 11);
            dig10 = (resto < 2) ? '0' : (char) ((11 - resto) + '0');

            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                num = CPF.charAt(i) - 48;
                soma = soma + (num * peso);
                peso = peso - 1;
            }
            resto = 11 - (soma % 11);
            dig11 = (resto < 2) ? '0' : (char) ((11 - resto) + '0');

            return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean cpfExistente(String cpf) {
        Cursor cursor = banco.query("aluno", new String[]{"cpf"}, "cpf = ?", new String[]{cpf}, null, null, null);
        boolean existe = cursor.getCount() > 0;
        cursor.close();
        return existe;
    }

    public boolean validaTelefone(String telefone) {
        telefone = telefone.replaceAll("[^0-9]", "");
        return telefone.length() >= 10 && telefone.length() <= 11;
    }
}