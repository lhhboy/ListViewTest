package com.lhh.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter {
    private int resourceId;
    //重写了父类一组构造函数，上下文，listview的子项布局id和数据都传进来
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
//重写getViwe()方法，这个方法在每个子被滚动到屏幕内的时候会被调用。
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //通过getIitem（）方法获得当前项的Fruit实例
        Fruit fruit= (Fruit) getItem(position);
        //用LayoutInflater来为这个子项加载我们传入的布局，第三个参数指定成false，
        // 表示让我们在父布局中声明的layout属性生效，但不为这个View添加父布局，因为一旦有了父布局之后，
        // 它就不能添加到ListView中了。（标准写法）
        View view ;
        ViewHolder viewHolder;
        if(convertView == null){
          view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
          viewHolder = new ViewHolder();
          viewHolder.fruitImage = view.findViewById(R.id.fruit_image);
          viewHolder.fruitName = view.findViewById(R.id.fruit_name);
          view.setTag(viewHolder);//将ViewHolder储存在View中
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
      //  View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
       /* ImageView fruitImage= view.findViewById(R.id.fruit_image);
        TextView fruitName=view.findViewById(R.id.fruit_name);
        fruitName.setText(fruit.getName());
        fruitImage.setImageResource(fruit.getImageId());*/
        return view;
    }

   class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
