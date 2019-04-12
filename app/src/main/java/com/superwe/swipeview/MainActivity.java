package com.superwe.swipeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);

        TextAdapter textAdapter = new TextAdapter(this);
        textAdapter.setItems(init());
        listView.setAdapter(textAdapter);
    }

    private List<TextWord> init(){
        List<TextWord> words = new ArrayList<>();
        for (int i =0; i< 30; i++){
            TextWord textWord = new TextWord();
            textWord.setId(i);
            textWord.setText("文字"+i);

            words.add(textWord);
        }
        return words;
    }
}
