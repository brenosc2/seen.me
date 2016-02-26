package com.example.breno.seenme;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TelaCadastrados extends Activity {
    private ListaDeItens listaDeItens = new ListaDeItens();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrados);

        ListView listview = (ListView) findViewById(R.id.listaDeItensCadastrados);
        ArrayAdapter<ItemCultural> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, listaDeItens.getListaDeItens());

        listview.setAdapter(arrayAdapter);
    }
}