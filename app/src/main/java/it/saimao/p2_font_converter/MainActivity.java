package it.saimao.p2_font_converter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton rbZg2Uni, rbUni2Zg;
    private EditText etInput, etOutput;
    private Button btConvert, btCopy, btClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        initListeners();
    }

    private void initListeners() {
        rbUni2Zg.setOnCheckedChangeListener((buttonView, isChecked) -> Toast.makeText(MainActivity.this, "Uni 2 Zg is checked " + isChecked, Toast.LENGTH_SHORT).show());

        rbZg2Uni.setOnCheckedChangeListener((buttonView, isChecked) -> Toast.makeText(MainActivity.this, "Zg 2 Uni is checked " + isChecked, Toast.LENGTH_SHORT).show());

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = etInput.getText().toString();
                etOutput.setText(inputText);
            }
        });

    }

    private void initUi() {
        rg = findViewById(R.id.rg_fonts);
        rbZg2Uni = findViewById(R.id.rb_zg2uni);
        rbUni2Zg = findViewById(R.id.rb_uni2zg);
        etInput = findViewById(R.id.et_input);
        etOutput = findViewById(R.id.et_output);
        btClear = findViewById(R.id.bt_clear);
        btCopy = findViewById(R.id.bt_copy);
        btConvert = findViewById(R.id.bt_convert);
    }
}