package br.gov.sp.cps.provap1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MegasenaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_megasena);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnVoltarMenuPrincipal = findViewById(R.id.btnVoltarMenuPrincipal);

        btnVoltarMenuPrincipal.setOnClickListener(v -> {
            finish();
        });
    }

    public TextView[] gerarLista(){
        TextView txtNum1 = findViewById(R.id.txtNum1);
        TextView txtNum2 = findViewById(R.id.txtNum2);
        TextView txtNum3 = findViewById(R.id.txtNum3);
        TextView txtNum4 = findViewById(R.id.txtNum4);
        TextView txtNum5 = findViewById(R.id.txtNum5);
        TextView txtNum6 = findViewById(R.id.txtNum6);

        return new TextView[]{txtNum1, txtNum2, txtNum3, txtNum4, txtNum5, txtNum6};
    }

    public void sorteioNumeros(View view){
        TextView[] textViews = gerarLista();
        int[] numeros = new int[6];

        for (int i = 0; i < numeros.length; i++) {

            int numeroSorteado;
            boolean repetido;

            do {
                numeroSorteado = (int) (Math.random() * 60) + 1;
                repetido = false;


                for (int j = 0; j < i; j++) {
                    if (numeros[j] == numeroSorteado) {
                        repetido = true;
                        break;
                    }
                }

            } while (repetido);

            numeros[i] = numeroSorteado;
            textViews[i].setText(String.valueOf(numeroSorteado));
        }
    }

    public void limparNumeros(View view) {
        TextView[] textViews = gerarLista();

        for (int i = 0; i < textViews.length; i++) {
            if (!textViews[i].getText().toString().equals("--")) {
                textViews[i].setText("--");
            }
        }
    }

}