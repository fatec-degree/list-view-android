package br.com.fatec.listadefilmes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
                // Passo 1: Atualizar o array;
                filmes.add(editTextNomeFilme.getText().toString());
                editTextNomeFilme.setText("");
                atualizarListView();
            }
        });

        this.listViewFilme.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int posicao, long l) {
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setMessage("Deseja realmente excluir o item?");
                msg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        filmes.remove(posicao);
                        atualizarListView();
                    }
                });
                msg.setNegativeButton("Não", null);
                msg.show();
                return false;
            }
        });
    }

    private void atualizarListView() {
        // Passo 2: Definir o Adapter
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, filmes);
        // Passo 3: Associar o adapter ao ListView
        listViewFilme.setAdapter(adapter);
    }

    public void associaComponentes() {
        this.buttonAdicionar = findViewById(R.id.buttonAdicionar);
        this.editTextNomeFilme = findViewById(R.id.editTextNomeFilme);
        this.listViewFilme = findViewById(R.id.listViewFilme);
    }
}