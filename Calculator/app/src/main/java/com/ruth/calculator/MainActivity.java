package com.ruth.calculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	
	private Button zero,um,dois,tres,quatro,cinco,seis,sete,oito,nove,ponto,limpar,divisao,multiplicacao,subtracao,adcao,igual;
	private TextView txtExpressao,txtResultado;
	private ImageView backspace;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		IniciarComponentes();
		
		zero.setOnClickListener(this);
		um.setOnClickListener(this);
		dois.setOnClickListener(this);
		tres.setOnClickListener(this);
		quatro.setOnClickListener(this);
		cinco.setOnClickListener(this);
		seis.setOnClickListener(this);
		sete.setOnClickListener(this);
		oito.setOnClickListener(this);
		nove.setOnClickListener(this);
		ponto.setOnClickListener(this);
		divisao.setOnClickListener(this);
		subtracao.setOnClickListener(this);
		adcao.setOnClickListener(this);
		multiplicacao.setOnClickListener(this);
		
		limpar.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
				txtExpressao.setText("");
				txtResultado.setText("");
			}
		});
		
		backspace.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
				TextView expressao = findViewById(R.id.txt_expressao);
				String string = expressao.getText().toString();
				
				if(!string.isEmpty()){
					
					byte var0 = 0;
					int var1 = string.length()-1;
					String txtExpressao = string.substring(var0,var1);
					expressao.setText(txtExpressao);
					
				}
				
				txtResultado.setText("");
			}
		});
		
		igual.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
				try{
					
					Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
					double resultado = expressao.evaluate();
					long longResult = (long) resultado;

					if(resultado == (double)longResult){
						txtResultado.setText((CharSequence) String.valueOf(longResult));

					}else{
						txtResultado.setText((CharSequence) String.valueOf(resultado));
					}
				}catch(Exception e){
					
				}
			}
		});
    }
    
	private void IniciarComponentes(){
		zero=findViewById(R.id.zero);
		um=findViewById(R.id.um);
		dois=findViewById(R.id.dois);
		tres=findViewById(R.id.tres);
		quatro=findViewById(R.id.quatro);
		cinco=findViewById(R.id.cinco);
		seis=findViewById(R.id.seis);
		sete=findViewById(R.id.sete);
		oito=findViewById(R.id.oito);
		nove=findViewById(R.id.nove);
		ponto=findViewById(R.id.ponto);
		limpar=findViewById(R.id.bt_limpar);
		divisao=findViewById(R.id.divisao);
		multiplicacao=findViewById(R.id.multiplicacao);
		subtracao=findViewById(R.id.subtracao);
		adcao=findViewById(R.id.adcao);
		igual=findViewById(R.id.igual);
		txtExpressao=findViewById(R.id.txt_expressao);
		txtResultado=findViewById(R.id.txt_resultado);
		backspace=findViewById(R.id.backspace);
		
	}
	
	public void AcrescentarUmaExpressao(String string,boolean limpar_dados){
		
		if(txtResultado.getText().equals("")){
			txtExpressao.setText(" ");
		}
		
		if(limpar_dados){
			txtResultado.setText(" ");
			txtExpressao.append(string);
			
		}else{
			txtExpressao.append(txtResultado.getText());
			txtExpressao.append(string);
			txtResultado.setText(" ");
		}
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case  R.id.zero:
				AcrescentarUmaExpressao("0",true);
				break;
				
			case R.id.um:
				AcrescentarUmaExpressao("1",true);
				break;
				
			case  R.id.dois:
				AcrescentarUmaExpressao("2",true);
				break;

			case R.id.tres:
				AcrescentarUmaExpressao("3",true);
				break;
				
			case  R.id.quatro:
				AcrescentarUmaExpressao("4",true);
				break;

			case R.id.cinco:
				AcrescentarUmaExpressao("5",true);
				break;

			case  R.id.seis:
				AcrescentarUmaExpressao("6",true);
				break;

			case R.id.sete:
				AcrescentarUmaExpressao("7",true);
				break;
				
			case  R.id.oito:
				AcrescentarUmaExpressao("8",true);
				break;

			case R.id.nove:
				AcrescentarUmaExpressao("9",true);
				break;

			case  R.id.ponto:
				AcrescentarUmaExpressao(".",true);
				break;

			case R.id.divisao:
				AcrescentarUmaExpressao("/",false);
				break;
				
			case R.id.adcao:
				AcrescentarUmaExpressao("+",false);
				break;
				
			case R.id.multiplicacao:
				AcrescentarUmaExpressao("*",false);
				break;

			case R.id.subtracao:
				AcrescentarUmaExpressao("-",false);
				break;
		}
	}

}
