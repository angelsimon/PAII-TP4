package com.grupo06.tp04.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.grupo06.tp04.R;
import com.grupo06.tp04.adapters.CategoriaSpinnerAdapter;
import com.grupo06.tp04.models.ArticuloModel;
import com.grupo06.tp04.models.CategoriaModel;
import com.grupo06.tp04.system.helpers.ArticuloInsertAsync;
import com.grupo06.tp04.system.helpers.CategoriaSelectAllAsync;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarFragment extends Fragment {

    private Spinner cbxCategorias;
    private CategoriaSpinnerAdapter adaptador;
    private EditText txtID, txtNombre, txtStock;
    private Button btnAgregar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public AgregarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment AgregarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarFragment newInstance(String param1) {
        AgregarFragment fragment = new AgregarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            bindControls(view);
            CategoriaSelectAllAsync task = new CategoriaSelectAllAsync(this.getContext(), view);
            task.execute();
            cbxCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            btnAgregar.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        ArticuloInsertAsync task = new ArticuloInsertAsync(view.getContext(), getView(), bindData());
                        task.execute();
                    } catch (Exception ex) {
                        Toast.makeText(view.getContext(), "No se pudo agregar el artículo", Toast.LENGTH_LONG).show();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Toast.makeText(this.getContext(), "Agregar Fragment", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_agregar, container, false);
    }
    private void bindControls(View view){
        txtID = (EditText)view.findViewById(R.id.txtID);
        txtNombre = (EditText)view.findViewById(R.id.txtNombre);
        txtStock = (EditText)view.findViewById(R.id.txtStock);
        cbxCategorias = (Spinner) view.findViewById(R.id.cbxCategoria);
        btnAgregar = (Button) view.findViewById(R.id.btnAgregar);
    }

    private ArticuloModel bindData(){
        ArticuloModel reg = new ArticuloModel();
        try {
            reg.setId(Long.parseLong(txtID.getText().toString()));
            reg.setNombre(txtNombre.getText().toString());
            if (reg.getNombre().length() == 0){
                throw new Exception();
            }
            reg.setStock(Integer.parseInt(txtStock.getText().toString()));
            CategoriaModel cat = (CategoriaModel) cbxCategorias.getSelectedItem();
            reg.setIdCategoria(cat.getId());
        }
        catch (Exception e){
            Toast.makeText(this.getContext(), "Verifique de completar todos los campos", Toast.LENGTH_LONG).show();
        }
        return reg;
    }

}