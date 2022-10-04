package mao.android_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mao.android_gridview.adapter.GridViewAdapter2;
import mao.android_gridview.entity.GridViewInfo;

public class MainActivity6 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        GridView gridView = findViewById(R.id.GridView);

        List<GridViewInfo> list = new ArrayList<>(100);
        for (int i = 1; i <= 1000; i++)
        {
            GridViewInfo gridViewInfo = new GridViewInfo()
                    .setTitle("标题" + i)
                    .setIcon(R.drawable.img)
                    .setContent("内容" + i + "..............");

            list.add(gridViewInfo);
        }

        GridViewAdapter2 gridViewAdapter = new GridViewAdapter2(this, list);

        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                toastShow("第" + (position + 1) + "个被点击了");
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                new AlertDialog.Builder(MainActivity6.this)
                        .setTitle("删除提示")
                        .setMessage("是否删除第" + (position + 1) + "个？")
                        .setPositiveButton("确定删除", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                list.remove(position);
                                gridViewAdapter.notifyDataSetChanged();
                                toastShow("已删除");
                            }
                        })
                        .setNeutralButton("取消", null)
                        .create()
                        .show();
                return true;
            }
        });
    }

    /**
     * 显示消息
     *
     * @param message 消息
     */
    private void toastShow(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}