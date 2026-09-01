package jp.ac.meijou.android.s251205044;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s251205044.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        TextView text = findViewById(R.id.text);
//        text.setText("Kageyama");
//        text.setText(R.string.text2);
//        binding.text.setText(R.string.text2);

        binding.button.setOnClickListener(view -> {
//            binding.text.setText(R.string.name);
//            binding.text.setText(R.string.text2);
            var text = binding.editTextText.getText().toString();
            binding.text.setText(text);
        });

        prefDataStore = PrefDataStore.getInstance(this);

        prefDataStore.getString("name")
                .ifPresent(name -> {
//                        binding.text.setText(name)
                    if("a".equals(name)){
                        binding.text.setText("Aの画像");
                        binding.imageView.setImageResource(R.drawable.ic_android);
                    }
                    else if("b".equals(name)){
                        binding.text.setText("Bの画像");
                        binding.imageView.setImageResource(R.drawable.ic_add_location);
                    }
                    else {
                        binding.text.setText("知らない画像");
                    }
                });

        binding.saveButton.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            if("a".equals(text)){
                binding.imageView.setImageResource(R.drawable.ic_android);
            }
            else if("b".equals(text)){
                binding.imageView.setImageResource(R.drawable.ic_add_location);
            }
            else {
                text = "unknown";
            }
            prefDataStore.setString("name", text);
        });

//        binding.editTextText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                // テキストが更新される直前に呼ばれる
//                }
//                @Override
//                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                // 文字を1 つ入力された時に呼ばれる
//                }
//                @Override public void afterTextChanged(Editable editable) {
//                // テキストが更新されたあとに呼ばれる
//                binding.text.setText(editable.toString());
//            }
//        });
    }
}