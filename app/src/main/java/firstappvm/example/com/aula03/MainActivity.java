package firstappvm.example.com.aula03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // Associando labels aos components da view //

    Switch bgTema;
    EditText nome, sobrenome;
    Button btOK;
    Button btCancelar;
    TextView erro;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligando as variaveis locais aos componentes da view //

        bgTema = findViewById(R.id.switchBG);
        nome = findViewById(R.id.editTextNome);
        sobrenome = findViewById(R.id.editTextSobrenome);
        btOK = findViewById(R.id.buttonOk);
        btCancelar = findViewById(R.id.buttonCancelar) ;
        erro = findViewById(R.id.msgErro) ;
        constraintLayout = findViewById(R.id.cl);

        // criando - setando click listener na View //

        bgTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bgTema.isChecked()){
                    constraintLayout.setBackgroundResource(R.drawable.art1);
                }
                else{
                    constraintLayout.setBackgroundResource(R.drawable.art3);
                }
            }
        });


        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Mensagem de erro caso não seja digitado nome ou sobrenome, caso contrario prossegue //

                if (nome.getText().toString().isEmpty() | sobrenome.getText().toString().isEmpty()){
                    erro.setText("É necessario preencher os dois campos.");
                }
                else {
                    Intent it = new Intent(getApplicationContext(), ResultadoActivity.class);
                    Bundle pacote = new Bundle();
                    pacote.putString("nome", nome.getText().toString());
                    pacote.putString("sobrenome", sobrenome.getText().toString());
                    it.putExtras(pacote);
                    startActivity((it), pacote);
                }

            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}



