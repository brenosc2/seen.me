package com.example.breno.seenme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class TelaCadastraLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText nomeDoLivro, genero, ano, autor, descricao, idioma, editora, edicao;
        Button cadastrar;
        final RatingBar avaliacao;
        final Spinner spinnerLivro;
        final CheckBox checkBoxLivro;

        final RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastra_livro);

        cadastrar = (Button) findViewById(R.id.btnCadastrarLivro);
        nomeDoLivro = (EditText) findViewById(R.id.nomeDoLivro);
        genero = (EditText) findViewById(R.id.genero);
        ano = (EditText) findViewById(R.id.ano);
        autor = (EditText) findViewById(R.id.autor);
        descricao = (EditText) findViewById(R.id.descricao);
        idioma = (EditText) findViewById(R.id.idioma);
        avaliacao = (RatingBar) findViewById(R.id.avaliacao);
        editora = (EditText) findViewById(R.id.editora);
        edicao = (EditText) findViewById(R.id.edicao);
        spinnerLivro = (Spinner) findViewById(R.id.spinnerLivro);
        checkBoxLivro = (CheckBox) findViewById(R.id.checkBoxLivro);
        final Intent retornaMainActivity = new Intent(getApplicationContext(), MainActivity.class);

        checkBoxLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxLivro.isChecked()){
                    avaliacao.setVisibility(View.VISIBLE);
                }else{
                    avaliacao.setVisibility(View.INVISIBLE);
                }
            }
        });

        cadastrar.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        regraDeNegocioSingleton.cadastrarLivro(nomeDoLivro.getText().toString(), genero.getText().toString(), ano.getText().toString(),
                                autor.getText().toString(), descricao.getText().toString(), idioma.getText().toString(), editora.getText().toString(),
                                edicao.getText().toString(), avaliacao.getRating(), spinnerLivro.getSelectedItemPosition()+1, checkBoxLivro.isChecked());
                        startActivity(retornaMainActivity);
                    }
                });
    }
}