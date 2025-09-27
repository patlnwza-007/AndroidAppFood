package app.ubu.lab10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.ubu.lab10.model.Food;
//ตัวเมนจะส่งภาพมาให้ myadapter มาแสดงภาพให้ ประมาณว่า myadapter เป็นคนกลาง ระหว่าง main และ viewholder
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // === global variables ===
    private List<Food> values;
    private Context context;   // รับ MainActivity context มาจาก MyAdapter

    // === constructor ===
    public MyAdapter(List<Food> values, Context context) {
        this.values = values;
        this.context = context;
    }

    // === INNER class ViewHolder ===
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgView;
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            imgView   = v.findViewById(R.id.icon);
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
        }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Food food = values.get(position);

        holder.txtHeader.setText(food.getFood_name());
        holder.txtFooter.setText(food.getFood_price() + " บาท"); // ในรูปมีต่อท้ายหน่วย

        // โหลดรูปใส่ ImageView ด้วย Glide
        Glide.with(context)
                .load(food.getFood_image())
                .into(holder.imgView);

        // คลิกรูปแล้วขึ้น Toast ชื่ออาหาร
        holder.imgView.setOnClickListener(v -> {
            Toast toast = Toast.makeText(context, food.getFood_name(), Toast.LENGTH_SHORT);
            toast.show();
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
