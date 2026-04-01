package br.gov.sp.cps.provap1.prjFelicidade;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.provap1.R;

public class ResultadoFelicidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado_felicidade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutResultado), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String classificacao = getIntent().getStringExtra("classificacao");
        double felicidade = getIntent().getDoubleExtra("felicidade", 0);

        TextView txtResultadoFelicidade = findViewById(R.id.txtResultadoFelicidade);
        TextView txtResultadoClassificacao = findViewById(R.id.txtResultadoClassificacao);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        txtResultadoFelicidade.setText(String.format("Pontuação: %.2f", felicidade));
        txtResultadoClassificacao.setText(classificacao);

        btnVoltar.setOnClickListener(v -> finish());


    }
}