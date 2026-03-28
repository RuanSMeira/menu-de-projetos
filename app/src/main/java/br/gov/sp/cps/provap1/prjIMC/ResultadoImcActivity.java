package br.gov.sp.cps.provap1.prjIMC;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.provap1.R;

public class ResultadoImcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        int layoutId = getIntent().getIntExtra("layout_escolhido", R.layout.activity_resultado_imc2);
        setContentView(layoutId);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtNome = findViewById(R.id.txtExibirNome);
        TextView txtPeso = findViewById(R.id.txtExibirPeso);
        TextView txtAltura = findViewById(R.id.txtExibirAltura);
        TextView txtResultado = findViewById(R.id.txtValorImc);
        Button btnVoltar = findViewById(R.id.btnVoltarMenu);


        String nome = getIntent().getStringExtra("nome");
        double peso = getIntent().getDoubleExtra("peso", 0);
        double altura = getIntent().getDoubleExtra("altura", 0);
        double imc = getIntent().getDoubleExtra("imc", 0);


        txtNome.setText("Nome: " + nome);
        txtPeso.setText("Peso: " + String.format("%.2f kg", peso));
        txtAltura.setText("Altura: " + String.format("%.2f m", altura));
        txtResultado.setText("IMC: " + String.format("%.2f", imc));

        btnVoltar.setOnClickListener(v -> finish());
    }
}