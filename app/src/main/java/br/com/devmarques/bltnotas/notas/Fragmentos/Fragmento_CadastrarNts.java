package br.com.devmarques.bltnotas.notas.Fragmentos;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.devmarques.bltnotas.notas.R;
import br.com.devmarques.bltnotas.notas.classnotas.Dadosnotas;
import br.com.devmarques.bltnotas.notas.dao.NotasDao;

/**
 * Created by Roger on 10/01/2017.
 */

public class Fragmento_CadastrarNts extends Fragment {

    EditText Nota1EditText, NomeMateriaEdit, PesoEditText1
            ,Peso2Edit,Peso3Edit,Peso4Edit, Nota2Edit,Nota3Edit,Nota4Edit, Media, Maxima;
    TextView Dois, Tres,Quatro, resultado;
    private String clickeds ="0";

    RelativeLayout nota2,nota3,nota4;
    RelativeLayout texto2, texto3, texto4;

    Button salvarAltera;
    Button button1;

    NotasDao dao;
    Dadosnotas dadosnotas;

    View Root;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        Root = inflater.inflate(R.layout.fragmento_cadastrarmt, container, false);

        IdsCaminhos();
        Ativagone();
        dadosnotas = new Dadosnotas();


        button1 = (Button) Root.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getContext(), button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.menubutton, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        String clicked = (String) item.getTitle();

                        setClickeds((String) item.getTitle());

                        switch (clicked) {

                    case "2":
                        Ativagone();
                        texto2.setVisibility(View.VISIBLE);
                        nota2.setVisibility(View.VISIBLE);
                        dadosnotas.setQtdsNotas("2");
                        break;

                    case "3":
                        Ativagone();
                        texto2.setVisibility(View.VISIBLE);
                        texto3.setVisibility(View.VISIBLE);

                        nota2.setVisibility(View.VISIBLE);
                        nota3.setVisibility(View.VISIBLE);

                        dadosnotas.setQtdsNotas("3");
                        break;

                    case "4":
                        nota2.setVisibility(View.VISIBLE);
                        nota3.setVisibility(View.VISIBLE);
                        nota4.setVisibility(View.VISIBLE);

                        texto2.setVisibility(View.VISIBLE);
                        texto3.setVisibility(View.VISIBLE);
                        texto4.setVisibility(View.VISIBLE);

                        dadosnotas.setQtdsNotas("4");
                        break;

                    default:

                        Ativagone();
                        break;
                }


                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });




        salvarAltera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Nota1EditText.getText().length() == 0){
                    //Nota1EditText.setText("0");
                    Snackbar.make(view,"A nota é Obrigatória!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }

                switch (clickeds) {

                    case "2":
                        if (Nota2Edit.getText().length() == 0){
                            //Nota1EditText.setText("0");
                            Snackbar.make(view,"A nota é Obrigatória!", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            return;
                        }

                        break;

                    case "3":

                        if (Nota3Edit.getText().length() == 0 || Nota2Edit.getText().length() == 0){
                            //Nota1EditText.setText("0");
                            Snackbar.make(view,"A nota é Obrigatória!", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            return;
                        }

                        break;

                    case "4":
                        if (Nota4Edit.getText().length() == 0 ||Nota3Edit.getText().length() == 0 || Nota2Edit.getText().length() == 0){
                            //Nota1EditText.setText("0");
                            Snackbar.make(view,"A nota é Obrigatória!", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            return;
                        }
                        break;

                    default:

                        break;

                }

                if ((Media.getText().length() == 0) && (Maxima.getText().length() == 0)){
                    Snackbar.make(view,"A Média e Máxima são requeridas.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }


                if (!(Nota1EditText.getText().length() == 0)){

                    // ################### if dos pesos ##################
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
                float conversaont1 = (float) (Double.parseDouble(PesoEditText1.getText().toString())* 0.1);
                float conversaont2 = (float) (Double.parseDouble(Peso2Edit.getText().toString())* 0.1);
                float conversaont3 = (float) (Double.parseDouble(Peso3Edit.getText().toString())* 0.1);
                float conversaont4 = (float) (Double.parseDouble(Peso4Edit.getText().toString())* 0.1);
                //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

                    // dados  QTDS NOTAS
                    if (dadosnotas.getQtdsNotas() == null) {
                        dadosnotas.setQtdsNotas("1");
                    }
                    Toast.makeText(getContext(), dadosnotas.getQtdsNotas(), Toast.LENGTH_SHORT);
                    // Disciplina
                    dadosnotas.setNomemateria(NomeMateriaEdit.getText().toString());
                    // Notas
                    dadosnotas.setValornota(Double.parseDouble(Nota1EditText.getText().toString()));
                    if (Nota2Edit.getText().length() == 0){
                        Nota2Edit.setText("0");
                    }
                    if (Nota3Edit.getText().length() == 0){
                        Nota3Edit.setText("0");
                    }
                    if (Nota4Edit.getText().length() == 0){
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


                    // Resultado
                    dadosnotas.setResultado((Double.parseDouble(Nota1EditText.getText().toString()) * (conversaont1)) +
                    + (Double.parseDouble(Nota2Edit.getText().toString()) * (conversaont2))
                    + (Double.parseDouble(Nota3Edit.getText().toString()) * (conversaont3))
                    + (Double.parseDouble(Nota4Edit.getText().toString()) * (conversaont4))
                    );



                dao = new NotasDao(getContext());
                    SalvarInserir();
                }



                /*dadosnotas.setPeso(getValor2());
                dadosnotas.setValornota(getValor1());
                dadosnotas.setNomemateria(NomeMateriaEdit.getText().toString());
                dadosnotas.setResultado((getValor1()*(conversao)));*/


                //double temp = (getValor1()*(conversao));

        /*

        String test = String.format("%.02f", dadosnotas.getResultado());

        resul.setText("Matéria:" +dadosnotas.getNomemateria()+ "\n" +
                "Valor nota Ponderada:" + test + "\n" +
                "Peso:"+ dadosnotas.getPeso()+ "\n" +
                "Valor:" +dadosnotas.getValornota() + "\n" +
                "");*/





            }
        });


        return Root;
    }



    public void SalvarInserir(){
        if (dao.Insere(dadosnotas) > 0){
            Toast.makeText(getContext(), "salvo com sucesso", Toast.LENGTH_LONG).show();

        }else {
            View view = new View(getContext());
            Snackbar.make(view, "erro", Snackbar.LENGTH_LONG).show();
        }
    }

    public String getClickeds() {
        return clickeds;
    }

    public void setClickeds(String clickeds) {
        this.clickeds = clickeds;
    }

    public void IdsCaminhos(){

        NomeMateriaEdit = (EditText) Root.findViewById(R.id.editText1materiaedit1);
        // notas
        Nota1EditText = (EditText) Root.findViewById(R.id.nota1edit1);
        Nota2Edit = (EditText) Root.findViewById(R.id.nota2edit1);
        Nota3Edit = (EditText) Root.findViewById(R.id.nota3edit1);
        Nota4Edit = (EditText) Root.findViewById(R.id.nota4edit1);

        // pesos
        PesoEditText1 = (EditText) Root.findViewById(R.id.peso1edit1);
        Peso2Edit = (EditText) Root.findViewById(R.id.peso2edit1);
        Peso3Edit = (EditText) Root.findViewById(R.id.peso3edit1);
        Peso4Edit = (EditText) Root.findViewById(R.id.peso4edit1);

        // &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

        // nome das notas;
        Dois = (TextView) Root.findViewById(R.id.textnota2ed1);
        Tres = (TextView) Root.findViewById(R.id.textnota3ed1);
        Quatro = (TextView) Root.findViewById(R.id.textnota4ed1);


        //Nota caixa
        nota2 = (RelativeLayout) Root.findViewById(R.id.Caixa1ed1);
        nota3 = (RelativeLayout) Root.findViewById(R.id.Caixa2ed1);
        nota4 = (RelativeLayout) Root.findViewById(R.id.Caixa3ed1);

        // texto caixa
        texto2 = (RelativeLayout) Root.findViewById(R.id.TextCx11);
        texto3 = (RelativeLayout) Root.findViewById(R.id.TextCx21);
        texto4 = (RelativeLayout) Root.findViewById(R.id.TextCx31);

        // resultado e salvar.
        resultado = (TextView) Root.findViewById(R.id.resultadoedit11);
        salvarAltera = (Button) Root.findViewById(R.id.salvaraltera1);

        // media e maxima
        Media = (EditText) Root.findViewById(R.id.Media);
        Maxima = (EditText) Root.findViewById(R.id.Maxima);
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
