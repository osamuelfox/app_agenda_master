package dev.samuel.teste.agenda.view.principal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dev.samuel.teste.agenda.R;
import dev.samuel.teste.agenda.controller.EventoDAO;
import dev.samuel.teste.agenda.model.Evento;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        EventoDAO dao = new EventoDAO();

        EditText tituloEvent = findViewById(R.id.edit_nome_evento);
        EditText descricaoEvent = findViewById(R.id.edit_descricao_evento);
        Button salvar = findViewById(R.id.bt_Salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventActivity.this, "Salvar", Toast.LENGTH_SHORT).show();

                String nome = tituloEvent.getText().toString();
                String descricao = descricaoEvent.getText().toString();

                Evento criarEvento = new Evento(nome,descricao);

                dao.salva(criarEvento);

                finish();

            }
        });

    }
}