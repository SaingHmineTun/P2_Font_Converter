package it.saimao.p2_font_converter;

import android.os.Bundle;
import android.widget.CompoundButton;
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

    }

    private void initUi() {
        rg = findViewById(R.id.rg_fonts);
        rbZg2Uni = findViewById(R.id.rb_zg2uni);
        rbUni2Zg = findViewById(R.id.rb_uni2zg);
    }
}