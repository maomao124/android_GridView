package mao.android_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import mao.android_gridview.adapter.GridViewAdapter;
import mao.android_gridview.entity.GridViewInfo;

public class MainActivity2 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        GridView gridView = findViewById(R.id.GridView);

        List<GridViewInfo> list = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++)
        {
            GridViewInfo gridViewInfo = new GridViewInfo()
                    .setTitle("标题" + i)
                    .setIcon(R.drawable.img)
                    .setContent("内容" + i + "..............");

            list.add(gridViewInfo);
        }

        GridViewAdapter gridViewAdapter = new GridViewAdapter(this, list);

        gridView.setAdapter(gridViewAdapter);
    }
}