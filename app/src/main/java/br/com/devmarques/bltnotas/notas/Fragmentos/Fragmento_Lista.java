package br.com.devmarques.bltnotas.notas.Fragmentos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.devmarques.bltnotas.notas.Adapter.AdapterBanco;
import br.com.devmarques.bltnotas.notas.R;
import br.com.devmarques.bltnotas.notas.classnotas.Dadosnotas;
import br.com.devmarques.bltnotas.notas.dao.NotasDao;

/**
 * Created by Roger on 10/01/2017.
 */

public class Fragmento_Lista extends Fragment{

    private ArrayList<Dadosnotas> dadoslist = new ArrayList<Dadosnotas>();
    NotasDao notasDao;
    private  RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View Root = inflater.inflate(R.layout.fragmento_lista, container, false);

        notasDao = new NotasDao(getContext());
        dadoslist = notasDao.buscaContatos();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView = (RecyclerView) Root.findViewById(R.id.my_recyvlerview2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AdapterBanco(dadoslist, getContext()));


        FloatingActionButton fab = (FloatingActionButton) Root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragmento_CadastrarNts fragmento_cadastrarNts = new Fragmento_CadastrarNts();
                FragmentTransaction ft = ((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_framer, fragmento_cadastrarNts);
                ft.commit();

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });



        return Root;
    }


}
