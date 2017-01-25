package br.com.devmarques.bltnotas.notas.Fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.devmarques.bltnotas.notas.R;

/**
 * Created by Roger on 10/01/2017.
 */

public class Fragment_Main extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Root = inflater.inflate(R.layout.fragmento_inicio, container, false);






        return Root;
    }
}
