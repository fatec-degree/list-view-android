package br.com.fatec.listadefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonAdicionar;
    private EditText editTextNomeFilme;
    private ListView listViewFilme;
    private List<String> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        associaComponentes();

        this.buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Passo 1: Adicionar itens ao array;
                filmes.add(editTextNomeFilme.getText().toString());
                editTextNomeFilme.setText("");

                // Passo 2: Definir o Adapter
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, filmes);

                // Passo 3: Associar o adapter ao ListView
                listViewFilme.setAdapter(adapter);
            }
        });
    }

    public void associaComponentes() {
        this.buttonAdicionar = findViewById(R.id.buttonAdicionar);
        this.editTextNomeFilme = findViewById(R.id.editTextNomeFilme);
        this.listViewFilme = findViewById(R.id.listViewFilme);
    }
}