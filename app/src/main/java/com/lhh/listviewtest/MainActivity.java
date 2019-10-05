package com.lhh.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private ArrayList data = new ArrayList();
//    ListView listView;
    private List<Fruit> fruitList=new ArrayList<>();
//    ArrayAdapter<String> adapter;
    FruitAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        adapter2=new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView=findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit=fruitList.get(i);
                Toast.makeText(MainActivity.this,"这是"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(adapter2);
        //初始化数据
//        for (int i = 0;i<30;i++){
//            data.add("数据" + i);
//        }
       /* adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/
    }

    private void initFruits() {
        for(int i= 0;i<2;i++){
            Fruit apple =new Fruit("apple",R.drawable.ic_launcher_background);
            fruitList.add(apple);
            Fruit apple2 =new Fruit("apple2",R.drawable.ic_launcher_foreground);
            fruitList.add(apple2);
        }
    }

    public void onViewClick(View view){
        Fruit apple2 =new Fruit("apple",R.drawable.ic_launcher_foreground);
        fruitList.add(apple2);
        //data.add("测试");
        adapter2.notifyDataSetChanged();
    }
}
