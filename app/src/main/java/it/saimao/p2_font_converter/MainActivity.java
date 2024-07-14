package it.saimao.p2_font_converter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
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
    private Typeface zgFont, uniFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zgFont = getResources().getFont(R.font.zawgyi_one);
        uniFont = getResources().getFont(R.font.pyidaungsu);
        initUi();
        initListeners();
    }

    private void initListeners() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_uni2zg) {
                    etInput.setTypeface(uniFont);
                    etOutput.setTypeface(zgFont);
                } else {
                    etInput.setTypeface(zgFont);
                    etOutput.setTypeface(uniFont);
                }
            }
        });

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();
                String output;
                if (rbZg2Uni.isChecked()) {
                    // Zawgyi to Unicode
                    output = Rabbit.zg2uni(input);
                } else {
                    // Unicode to Zawgyi
                    output = Rabbit.uni2zg(input);
                }
                etOutput.setText(output);
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInput.getText().clear();
                etOutput.getText().clear();
            }
        });

        btCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String output = etOutput.getText().toString();
                if (!output.isEmpty()) {
                    // Copy text
                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("font_converter", output);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(), "Output text copied!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No output text to copy!", Toast.LENGTH_SHORT).show();
                }

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