package com.riswan.foodlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Context context;
    FoodAdapter foodAdapter;
    ArrayList<Food> foodList;
    Food foodModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        foodList = new ArrayList<>();

        foodPopulate();

        foodAdapter = new FoodAdapter(this, foodList);
        listView.setAdapter(foodAdapter);


    }

    private void foodPopulate () {
        foodModel = new Food();
        foodModel.setName("gado gado");
        foodModel.setHarga(10000);
        foodList.add(foodModel);

        foodModel = new Food();
        foodModel.setName("Keredeok");
        foodModel.setHarga(10000);
        foodList.add(foodModel);

        foodModel = new Food();
        foodModel.setName("Ketoprak");
        foodModel.setHarga(10000);
        foodList.add(foodModel);
    }

    public class FoodAdapter extends BaseAdapter {

         Context context; //context
         ArrayList<Food> foodList;
         Food foodModel;
         LayoutInflater layoutInflater;


        public FoodAdapter(Context context, ArrayList<Food> foodList) {
            this.context = context;
            this.foodList = foodList;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return foodList.size();
        }

        @Override
        public Object getItem(int i) {
            return foodList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View rowView = view;
            if(rowView == null) {
                rowView = layoutInflater.inflate(R.layout.food_list, null, true);
            }

            TextView tvName = rowView.findViewById(R.id.tvName);
            TextView tvPrice = rowView.findViewById(R.id.tvPrice);

            foodModel = foodList.get(i);

            tvName.setText(foodModel.getName());
            tvPrice.setText(Integer.toString(foodModel.getHarga()));

            return rowView;
        }
    }
}
