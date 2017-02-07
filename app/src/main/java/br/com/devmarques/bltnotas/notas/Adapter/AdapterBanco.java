package br.com.devmarques.bltnotas.notas.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.devmarques.bltnotas.notas.Fragmentos.Fragment_editar;
import br.com.devmarques.bltnotas.notas.Fragmentos.Fragmento_Lista;
import br.com.devmarques.bltnotas.notas.R;
import br.com.devmarques.bltnotas.notas.classnotas.Dadosnotas;
import br.com.devmarques.bltnotas.notas.dao.NotasDao;

public class AdapterBanco extends RecyclerView.Adapter<AdapterBanco.ViewHolder> {

    ArrayList<Dadosnotas> recebedados = new ArrayList<Dadosnotas>();
    Context context;


    public AdapterBanco(ArrayList<Dadosnotas> dadosList, Context  context) {
        this.context = context;
        this.recebedados = dadosList;
    }



    @Override
    public AdapterBanco.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final AdapterBanco.ViewHolder holder, final int position) {
        final Dadosnotas dadosnotas = recebedados.get(position);

        holder.nomemat.setText(dadosnotas.getNomemateria());

        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_editar fragment_editar = new Fragment_editar();
                FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                //

                // jogar todos valores do dados notas depois.
                Bundle args = new Bundle();
                args.putLong("id" , dadosnotas.getId());

                args.putString("numNotas", dadosnotas.getQtdsNotas());

                args.putString("NomeMateria" , dadosnotas.getNomemateria());

                args.putDouble("ValorNota1" , dadosnotas.getValornota());
                args.putDouble("Peso1" , dadosnotas.getPeso());

                args.putDouble("ValorNota2" , dadosnotas.getValornota2());
                args.putDouble("Peso2" , dadosnotas.getPeso2());

                args.putDouble("ValorNota3" , dadosnotas.getValornota3());
                args.putDouble("Peso3" , dadosnotas.getPeso3());

                args.putDouble("ValorNota4" , dadosnotas.getValornota4());
                args.putDouble("Peso4" , dadosnotas.getPeso4());

                args.putDouble("Media" , dadosnotas.getMedia());
                args.putDouble("Maxima" , dadosnotas.getMaxima());
                //
                fragment_editar.setArguments(args);
                // fim

                ft.replace(R.id.fragment_framer, fragment_editar);
                ft.commit();


            }
        });


        holder.deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // caixa de dialogo.
                new AlertDialog.Builder(context)
                        .setMessage("Deseja apagar?"+ "-"+ dadosnotas.getNomemateria())
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                holder.load_apagar.setVisibility(View.VISIBLE);
                                NotasDao dao = new NotasDao(context);
                                dao.Deletar(dadosnotas);

                                Fragmento_Lista fragmento_lista = new Fragmento_Lista();
                                FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.fragment_framer, fragmento_lista);
                                ft.commit();
                            }
                        })
                        .setNegativeButton("Não", null)
                        .show();
                holder.load_apagar.setVisibility(View.GONE);
            }
        });


        holder.nomemat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // chamando fragmento na classe
                String test = dadosnotas.getQtdsNotas();

                switch (test){
                    case "1":
                        Snackbar.make(view,
                                "Sua média: " + String.valueOf(String.format("%.02f",dadosnotas.getResultado())) +
                                        " | Nota 1: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota()))
                                , Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;


                    case "2":
                        Snackbar.make(view,
                                "Sua média: " + String.valueOf(String.format("%.02f",dadosnotas.getResultado())) +
                                        " | Nota 1: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota())) +
                                        " | Nota 2: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota2()))
                                , Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;

                    case "3":
                        Snackbar.make(view,
                                "Sua média: " + String.valueOf(String.format("%.02f",dadosnotas.getResultado())) +
                                        " | Nota 1: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota())) +
                                        " | Nota 2: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota2())) +
                                        " | Nota 3: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota3()))
                                , Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case "4":
                        Snackbar.make(view,
                                "Sua média: " + String.valueOf(String.format("%.02f",dadosnotas.getResultado())) +
                                        " | Nota 1: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota())) +
                                        " | Nota 2: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota2())) +
                                        " | Nota 3: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota3())) +
                                        " | Nota 4: " + String.valueOf(String.format("%.02f",dadosnotas.getValornota4()))
                                , Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;

                    default:

                        break;

                }


                //Toast.makeText(getContext(context), String.valueOf(String.format("%.02f",dadosnotas.getResultado())) , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return recebedados.size();
    }

    private Context getContext(Context context) {
        return context;
    }

    /* @Override
    public int getItemCount() {
        return receberImg.size();
    }


    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nomemat;

        ImageButton editar;
        ImageButton deletar;
        ProgressBar load_apagar;


        public ViewHolder(View itemView) {
            super(itemView);

            load_apagar = (ProgressBar) itemView.findViewById(R.id.contato_progressBar);
            deletar = (ImageButton) itemView.findViewById(R.id.deletar);
            editar = (ImageButton) itemView.findViewById(R.id.editar);
            nomemat = (TextView) itemView.findViewById(R.id.materiaexsss);

        }
    }
}
