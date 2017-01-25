package br.com.devmarques.bltnotas.notas.Fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.devmarques.bltnotas.notas.R;
import br.com.devmarques.bltnotas.notas.classnotas.Dadosnotas;
import br.com.devmarques.bltnotas.notas.dao.NotasDao;

/**
 * Created by Roger on 11/01/2017.
 */

public class Fragment_editar extends Fragment {

    EditText Nota1EditText, NomeMateriaEdit, PesoEditText1
            ,Peso2Edit,Peso3Edit,Peso4Edit, Nota2Edit,Nota3Edit,Nota4Edit,Media, Maxima;
    TextView Dois, Tres,Quatro, resultado;

    RelativeLayout nota2,nota3,nota4;
    RelativeLayout texto2, texto3, texto4;

    Button salvarAltera;



    NotasDao dao;
    Dadosnotas dadosnotas;
    Long id ;
    String NomeMateria1 ;
    double ValorNota1,ValorNota2,ValorNota3,ValorNota4 ;
    double Peso1,Peso2,Peso3,Peso4, MediaS , MaximaS;
    double Resultado;
    String ssss;
    View Root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Root =  inflater.inflate(R.layout.fragmentoeditar, container, false);
        // setando caminhos (ids) dos elementos.
        IdsCaminhos();

        // pegando elementro da lista.
        id = getArguments().getLong("id");

        NomeMateria1 = getArguments().getString("NomeMateria");

        ValorNota1 = getArguments().getDouble("ValorNota1");
        Peso1 = getArguments().getDouble("Peso1");

        ValorNota2 = getArguments().getDouble("ValorNota2");
        Peso2 = getArguments().getDouble("Peso2");

        ValorNota3 = getArguments().getDouble("ValorNota3");
        Peso3 = getArguments().getDouble("Peso3");

        ValorNota4 = getArguments().getDouble("ValorNota4");
        Peso4 = getArguments().getDouble("Peso4");

        MediaS = getArguments().getDouble("Media");
        MaximaS = getArguments().getDouble("Maxima");

        Toast.makeText(getContext(), String.valueOf(Peso1), Toast.LENGTH_SHORT).show();

        NomeMateriaEdit.setText(NomeMateria1);
        Nota1EditText.setText(String.valueOf(ValorNota1));
        PesoEditText1.setText(String.valueOf(Peso1));

        Nota2Edit.setText(String.valueOf(ValorNota2));
        Peso2Edit.setText(String.valueOf(Peso2));

        Nota3Edit.setText(String.valueOf(ValorNota3));
        Peso3Edit.setText(String.valueOf(Peso3));

        Nota4Edit.setText(String.valueOf(ValorNota4));
        Peso4Edit.setText(String.valueOf(Peso4));

        Media.setText(String.valueOf(MediaS));
        Maxima.setText(String.valueOf(MaximaS));

        ssss = getArguments().getString("numNotas");

        switch (ssss) {

            case "2":
                Ativagone();
                texto2.setVisibility(View.VISIBLE);
                nota2.setVisibility(View.VISIBLE);

                break;

            case "3":
                Ativagone();
                texto2.setVisibility(View.VISIBLE);
                texto3.setVisibility(View.VISIBLE);

                nota2.setVisibility(View.VISIBLE);
                nota3.setVisibility(View.VISIBLE);

                break;

            case "4":
                nota2.setVisibility(View.VISIBLE);
                nota3.setVisibility(View.VISIBLE);
                nota4.setVisibility(View.VISIBLE);

                texto2.setVisibility(View.VISIBLE);
                texto3.setVisibility(View.VISIBLE);
                texto4.setVisibility(View.VISIBLE);


                break;

            default:
                Ativagone();
                break;
        }

        salvarAltera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float conversao1 = (float) (Double.parseDouble(PesoEditText1.getText().toString()) * 0.1);
                if (Nota1EditText.getText().length() == 0) {
                    //Nota1EditText.setText("0");
                    Snackbar.make(view, "A nota é Obrigatória!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }

                String s = getArguments().getString("numNotas");
                switch (s) {

                    case "2":
                        if (Nota2Edit.getText().length() == 0) {
                            //Nota1EditText.setText("0");
                            Snackbar.make(view, "A nota é Obrigatória!", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            return;
                        }

                        break;

                    case "3":

                        if (Nota3Edit.getText().length() == 0 || Nota2Edit.getText().length() == 0) {
                            //Nota1EditText.setText("0");
                            Snackbar.make(view, "A nota é Obrigatória!", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            return;
                        }

                        break;

                    case "4":
                        if (Nota4Edit.getText().length() == 0 || Nota3Edit.getText().length() == 0 || Nota2Edit.getText().length() == 0) {
                            //Nota1EditText.setText("0");
                            Snackbar.make(view, "A nota é Obrigatória!", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            return;
                        }
                        break;

                    default:

                        break;

                }

                if (Media.getText().length() == 0 && Maxima.getText().length() == 0) {
                    Snackbar.make(view, "A Média e Máxima são requeridas.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


                if (!(Nota1EditText.getText().length() == 0)) {

                    dao = new NotasDao(getContext());
                    dadosnotas = new Dadosnotas();

                    if (PesoEditText1.getText().length() == 0){
                        PesoEditText1.setText("10");
                    }
                    if (Peso2Edit.getText().length() == 0){
                        Peso2Edit.setText("10");
                    }
                    if (Peso3Edit.getText().length() == 0){
                        Peso3Edit.setText("10");
                    }
                    if (Peso4Edit.getText().length() == 0){
                        Peso4Edit.setText("10");
                    }

                    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Conversão &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                    float conversaont1 = (float) (Double.parseDouble(PesoEditText1.getText().toString()) * 0.1);
                    float conversaont2 = (float) (Double.parseDouble(Peso2Edit.getText().toString()) * 0.1);
                    float conversaont3 = (float) (Double.parseDouble(Peso3Edit.getText().toString()) * 0.1);
                    float conversaont4 = (float) (Double.parseDouble(Peso4Edit.getText().toString()) * 0.1);
                    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

                    // Disciplina
                    String ss = NomeMateriaEdit.getText().toString();
                    dadosnotas.setNomemateria(ss);
                    // Notas
                    dadosnotas.setValornota(Double.parseDouble(Nota1EditText.getText().toString()));
                    if (Nota2Edit.getText().length() == 0) {
                        Nota2Edit.setText("0");
                    }
                    if (Nota3Edit.getText().length() == 0) {
                        Nota3Edit.setText("0");
                    }
                    if (Nota4Edit.getText().length() == 0) {
                        Nota4Edit.setText("0");
                    }
                    dadosnotas.setValornota2(Double.parseDouble(Nota2Edit.getText().toString()));
                    dadosnotas.setValornota3(Double.parseDouble(Nota3Edit.getText().toString()));
                    dadosnotas.setValornota4(Double.parseDouble(Nota4Edit.getText().toString()));

                    // peso já setado encima automático ou get
                    dadosnotas.setPeso(Double.parseDouble(PesoEditText1.getText().toString()));
                    dadosnotas.setPeso2(Double.parseDouble(Peso2Edit.getText().toString()));
                    dadosnotas.setPeso3(Double.parseDouble(Peso3Edit.getText().toString()));
                    dadosnotas.setPeso4(Double.parseDouble(Peso4Edit.getText().toString()));
                    //Media e máxima
                    dadosnotas.setMedia(Double.parseDouble(Media.getText().toString()));
                    dadosnotas.setMaxima(Double.parseDouble(Maxima.getText().toString()));

                    //set qtd
                    dadosnotas.setQtdsNotas(ssss);
                    // Resultado
                    dadosnotas.setResultado((Double.parseDouble(Nota1EditText.getText().toString()) * (conversaont1)) +
                            +(Double.parseDouble(Nota2Edit.getText().toString()) * (conversaont2))
                            + (Double.parseDouble(Nota3Edit.getText().toString()) * (conversaont3))
                            + (Double.parseDouble(Nota4Edit.getText().toString()) * (conversaont4))
                    );

                    dadosnotas.setId(id);

                    Alterar();

                }
            }});


        return Root;

    }

    public void Alterar(){
        dao.alterar(dadosnotas);
        Toast.makeText(getContext(), "alterado com sucesso", Toast.LENGTH_LONG).show();
    }

    public void IdsCaminhos(){

        NomeMateriaEdit = (EditText) Root.findViewById(R.id.MateriaText);
        // notas
        Nota1EditText = (EditText) Root.findViewById(R.id.nota1edit);
        Nota2Edit = (EditText) Root.findViewById(R.id.nota2edit);
        Nota3Edit = (EditText) Root.findViewById(R.id.nota3edit);
        Nota4Edit = (EditText) Root.findViewById(R.id.nota4edit);

        // pesos
        PesoEditText1 = (EditText) Root.findViewById(R.id.peso1edit);
        Peso2Edit = (EditText) Root.findViewById(R.id.peso2edit);
        Peso3Edit = (EditText) Root.findViewById(R.id.peso3edit);
        Peso4Edit = (EditText) Root.findViewById(R.id.peso4edit);

        // &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

        // nome das notas;
        Dois = (TextView) Root.findViewById(R.id.textnota2ed);
        Tres = (TextView) Root.findViewById(R.id.textnota3ed);
        Quatro = (TextView) Root.findViewById(R.id.textnota4ed);


        //Nota caixa
        nota2 = (RelativeLayout) Root.findViewById(R.id.Caixa1ed);
        nota3 = (RelativeLayout) Root.findViewById(R.id.Caixa2ed);
        nota4 = (RelativeLayout) Root.findViewById(R.id.Caixa3ed);

        // texto caixa
        texto2 = (RelativeLayout) Root.findViewById(R.id.TextCx1);
        texto3 = (RelativeLayout) Root.findViewById(R.id.TextCx2);
        texto4 = (RelativeLayout) Root.findViewById(R.id.TextCx3);

        // resultado e salvar.
        resultado = (TextView) Root.findViewById(R.id.resultadoedit1);
        salvarAltera = (Button) Root.findViewById(R.id.salvaraltera);

        // media e maxima
        Media = (EditText) Root.findViewById(R.id.Mediaedit);
        Maxima = (EditText) Root.findViewById(R.id.Maximaedit);

    }

    public void Ativagone(){
        /* nota2,nota3,nota4;
    RelativeLayout texto2, texto3, texto4;*/

        nota2.setVisibility(View.GONE);
        nota3.setVisibility(View.GONE);
        nota4.setVisibility(View.GONE);

        texto2.setVisibility(View.GONE);
        texto3.setVisibility(View.GONE);
        texto4.setVisibility(View.GONE);

    }

}
