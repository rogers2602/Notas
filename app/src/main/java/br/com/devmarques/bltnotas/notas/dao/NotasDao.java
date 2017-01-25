package br.com.devmarques.bltnotas.notas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import br.com.devmarques.bltnotas.notas.classnotas.Dadosnotas;

/**
 * Created by Roger on 09/01/2017.
 */

public class NotasDao {

    Context context;
    BancoDados dao;

    private static final String BANCONOME = "Notas";


    public NotasDao(Context context) {
        this.context = context;
    }


    public long Insere (Dadosnotas dadosnotas){
        dao = new BancoDados(context);
        SQLiteDatabase db = dao.getWritableDatabase();
        ContentValues dados = PegaDadosNotas(dadosnotas);
        long inserir = db.insert(BANCONOME, null, dados);

        db.close();
        Log.i(BANCONOME,inserir+ "");
        return inserir;
    }

    // busca todas linhas do banco notas
    public ArrayList<Dadosnotas> buscaContatos(){
        String sql = "SELECT * FROM " + BANCONOME;
        dao = new BancoDados(context);
        SQLiteDatabase db = dao.getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        ArrayList<Dadosnotas> dadosNotas = new ArrayList<Dadosnotas>();
        while (c.moveToNext()){
            Dadosnotas dadosNts = new Dadosnotas();
            dadosNts.setId(c.getInt(c.getColumnIndex("id")));
            dadosNts.setNomemateria(c.getString(c.getColumnIndex("nomemateria")));

            dadosNts.setQtdsNotas(c.getString(c.getColumnIndex("qtdnotas")));

            dadosNts.setMaxima(c.getDouble(c.getColumnIndex("maxima")));
            dadosNts.setMedia(c.getDouble(c.getColumnIndex("media")));

            dadosNts.setValornota(c.getDouble(c.getColumnIndex("nota1")));
            dadosNts.setPeso(c.getDouble(c.getColumnIndex("peso1")));

            dadosNts.setValornota2(c.getDouble(c.getColumnIndex("nota2")));
            dadosNts.setPeso2(c.getDouble(c.getColumnIndex("peso2")));

            dadosNts.setValornota3(c.getDouble(c.getColumnIndex("nota3")));
            dadosNts.setPeso3(c.getDouble(c.getColumnIndex("peso3")));

            dadosNts.setValornota4(c.getDouble(c.getColumnIndex("nota4")));
            dadosNts.setPeso4(c.getDouble(c.getColumnIndex("peso4")));

            dadosNts.setResultado(c.getDouble(c.getColumnIndex("resultado")));
            dadosNotas.add(dadosNts);
        }
        c.close();
        return dadosNotas;

    }

    // altera tras os dados do item selecionado na lista.
    public void alterar(Dadosnotas dadosnotas){
        dao = new BancoDados(context);
        SQLiteDatabase db = dao.getWritableDatabase();
        ContentValues dados = PegaDadosNotas(dadosnotas);
        String[] params = {String.valueOf(dadosnotas.getId())};
        db.update("Notas", dados, "id=?", params);
    }

    public void Deletar(Dadosnotas dadosnotas){
        dao = new BancoDados(context);
        SQLiteDatabase db = dao.getWritableDatabase();
        String whereClause = "id=?";
        String[] whereArgs = new String[]{String.valueOf(dadosnotas.getId())};
        db.delete(BANCONOME, whereClause, whereArgs);
        db.close();
    }

    // inserindo usado por vários metodos....
    public ContentValues PegaDadosNotas (Dadosnotas dadosnotas){

        ContentValues dados = new ContentValues();
        dados.put("nomemateria", dadosnotas.getNomemateria());

        dados.put("qtdnotas", dadosnotas.getQtdsNotas());
        dados.put("maxima", dadosnotas.getMaxima());
        dados.put("media", dadosnotas.getMedia());


        dados.put("nota1", dadosnotas.getValornota());
        dados.put("peso1", dadosnotas.getPeso());
        dados.put("nota2", dadosnotas.getValornota2());
        dados.put("peso2", dadosnotas.getPeso2());
        dados.put("nota3", dadosnotas.getValornota3());
        dados.put("peso3", dadosnotas.getPeso3());
        dados.put("nota4", dadosnotas.getValornota4());
        dados.put("peso4", dadosnotas.getPeso4());
        dados.put("resultado", dadosnotas.getResultado());

        return dados;
    }

}
