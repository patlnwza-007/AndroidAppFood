package app.ubu.lab10;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.ubu.lab10.model.Food;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);   // ใน activity_main ต้องมี RecyclerView id = my_recycler_view

        // ---- RecyclerView ----
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // ---- สร้างข้อมูลตัวอย่าง ----
        List<Food> foods = new ArrayList<>();

        Food food = new Food();
        food.setFood_name("หมูกรอบ");
        food.setFood_image("https://www.wongnai.com/photos/0800c190f23841fa9beae6f31d4bfa51/600/400");
        food.setFood_price(30);
        foods.add(food);

        Food food2 = new Food();
        food2.setFood_name("หมี่");
        food2.setFood_image("https://picsum.photos/seed/food2/600/400");
        food2.setFood_price(35);
        foods.add(food2);

        // ---- ผูก Adapter ----
        mAdapter = new MyAdapter(foods, this);
        recyclerView.setAdapter(mAdapter);
    }
}
