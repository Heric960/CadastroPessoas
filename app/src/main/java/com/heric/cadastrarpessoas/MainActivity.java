package com.heric.cadastrarpessoas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNome, editIdade, editEndereco;
    private Button btnSalvar;

    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        editNome = findViewById(R.id.editNome);
        editIdade = findViewById(R.id.editIdade);
        editEndereco = findViewById(R.id.editEndereco);
        btnSalvar = findViewById(R.id.btnSalvar);

        Button btnInfo = findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SobreActivity.class);
                startActivity(intent);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editNome.getText().toString();
                String idade = editIdade.getText().toString();
                String endereco = editEndereco.getText().toString();

                
                Intent intent = new Intent(MainActivity.this, ConfirmacaoActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("idade", idade);
                intent.putExtra("endereco", endereco);
                startActivity(intent);
            }
        });
    }
}