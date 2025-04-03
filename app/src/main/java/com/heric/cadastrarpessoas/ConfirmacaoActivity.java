package com.heric.cadastrarpessoas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacaoActivity extends AppCompatActivity {

    private TextView textNome, textIdade, textEndereco;
    private Button btnSim, btnNao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        // Ligação com os componentes do layout
        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);
        textEndereco = findViewById(R.id.textEndereco);
        btnSim = findViewById(R.id.btnSim);
        btnNao = findViewById(R.id.btnNao);

        // Receber os dados da tela anterior
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String idade = intent.getStringExtra("idade");
        String endereco = intent.getStringExtra("endereco");

        // Exibir os dados na tela
        textNome.setText("Nome: " + nome);
        textIdade.setText("Idade: " + idade);
        textEndereco.setText("Endereço: " + endereco);

        // Botão "Sim" - Salvar os dados e voltar para a tela inicial
        btnSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConfirmacaoActivity.this, "Cadastro salvo com sucesso!", Toast.LENGTH_LONG).show();

                // Retorna para a tela inicial e limpa os campos
                Intent intent = new Intent(ConfirmacaoActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        // Botão "Não" - Voltar para editar os dados
        btnNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmacaoActivity.this, MainActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("idade", idade);
                intent.putExtra("endereco", endereco);
                startActivity(intent);
                finish();
            }
        });
    }
}
