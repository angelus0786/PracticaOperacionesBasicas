package itsmt.practicaoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText numero1, numero2;
    Button btnSuma,btnResta,btnMultiplica,btnDivide;
    TextView resultado;
    int num1,num2;
    Operacion op=null;

    public void vincular(){
        numero1 =  findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        btnSuma = findViewById(R.id.btn_suma);
        btnResta = findViewById(R.id.btn_resta);
        btnMultiplica = findViewById(R.id.btn_multiplica);
        btnDivide = findViewById(R.id.btn_divide);
        resultado = findViewById(R.id.resultado);

        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMultiplica.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

    }
    public void obtenerDatos(){
        if (valida()){
            num1 = Integer.parseInt(numero1.getText().toString());
            num2 = Integer.parseInt(numero2.getText().toString());
         }
    }

    public boolean valida(){
        boolean bandera=false;
        if (numero1.getText().toString().isEmpty()
                || numero2.getText().toString().isEmpty()){
            bandera=false;
        }else{
            bandera=true;
        }
        return bandera;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vincular();
    }

    @Override
    public void onClick(View view) {
        double res=0;
        obtenerDatos();
        op = new Operacion(num1,num2);
    switch (view.getId()){

        case  R.id.btn_suma:
            res = op.sumar();
            Toast.makeText(getApplicationContext(),"click num1:"+num1+" ,num2:"+num2,Toast.LENGTH_LONG).show();
            break;
        case  R.id.btn_resta:
            res = op.restar();
            break;
        case  R.id.btn_multiplica:
            res = op.multiplicar();
            break;
        case  R.id.btn_divide:
            res = op.dividir();
            break;
    }
    resultado.setText(String.valueOf(res));

    }
}