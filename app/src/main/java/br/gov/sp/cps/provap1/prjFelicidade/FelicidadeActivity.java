package br.gov.sp.cps.provap1.prjFelicidade;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.provap1.R;
import br.gov.sp.cps.provap1.prjIMC.ResultadoImcActivity;

public class FelicidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_felicidade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutFelicidade), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCalcularFelicidade = findViewById(R.id.btnCalcularFelicidade);
        Button btnVoltarMenuPrincipal = findViewById(R.id.btnVoltarMenuPrincipal);



        btnCalcularFelicidade.setOnClickListener(v -> {
            RadioButton rbSono1 = findViewById(R.id.rbSono1);
            RadioButton rbSono2 = findViewById(R.id.rbSono2);
            RadioButton rbSono3 = findViewById(R.id.rbSono3);

            RadioButton rbEstresse1 = findViewById(R.id.rbEstresse1);
            RadioButton rbEstresse2 = findViewById(R.id.rbEstresse2);
            RadioButton rbEstresse3 = findViewById(R.id.rbEstresse3);

            int S = 0;
            int E = 0;

            if (rbSono1.isChecked()) S = 1;
            else if (rbSono2.isChecked()) S = 3;
            else if (rbSono3.isChecked()) S = 2;

            if (rbEstresse1.isChecked()) E = 3;
            else if (rbEstresse2.isChecked()) E = 2;
            else if (rbEstresse3.isChecked()) E = 1;

            double felicidade = ((S + E) / 6.0) * 10;

            String classificacao;

            if (felicidade <= 2.0)
                classificacao = "Muito Baixa";
            else if (felicidade <= 4.0)
                classificacao = "Baixa";
            else if (felicidade <= 6.0)
                classificacao = "Moderada";
            else if (felicidade <= 8.0)
                classificacao = "Alta";
            else
                classificacao = "Plena";


            Intent intent = new Intent(this, ResultadoFelicidadeActivity.class);
            intent.putExtra("classificacao", classificacao);
            intent.putExtra("felicidade", felicidade);
            startActivity(intent);
        });

        btnVoltarMenuPrincipal.setOnClickListener(v -> {
            finish();
        });
    }
}