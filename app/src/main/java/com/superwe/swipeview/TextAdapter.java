package com.superwe.swipeview;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.superwe.swipeview.base.adapter.BaseListAdapter;

/**
 * Created by Administrator on 2019/4/12.
 */
@SuppressWarnings("ResourceType")
public class TextAdapter extends BaseListAdapter<TextWord>{
    public TextAdapter(Context context) {
        super(context);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup parent, int viewType) {
        SwipeMenuLayout swipeMenuLayout = new SwipeMenuLayout(getContext());
        swipeMenuLayout.setIos(false);

        swipeMenuLayout.setSwipeEnable(true);

        TextView text = new TextView(getContext());
        text.setId(0);
        LinearLayout.LayoutParams text_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp2px(50));
        text_params.setMargins(dp2px(5), 0, dp2px(5), 0);
        text.setGravity(Gravity.CENTER_VERTICAL);
        text.setTextSize(dp2px(6));
        text.getPaint().setFakeBoldText(true);
        text.setLayoutParams(text_params);

        TextView edit = new TextView(getContext());
        LinearLayout.LayoutParams edit_params = new LinearLayout.LayoutParams(dp2px(80), dp2px(50));
        edit.setId(2);
        edit.setGravity(Gravity.CENTER_VERTICAL);
        edit.setTextSize(dp2px(6));
        edit.getPaint().setFakeBoldText(true);
        edit.setLayoutParams(edit_params);

        TextView del = new TextView(getContext());
        LinearLayout.LayoutParams del_params = new LinearLayout.LayoutParams(dp2px(50), dp2px(50));
        del.setId(1);
        del.setGravity(Gravity.CENTER_VERTICAL);
        del.setTextSize(dp2px(6));
        del.getPaint().setFakeBoldText(true);
        del.setLayoutParams(del_params);

        swipeMenuLayout.addView(text);
        swipeMenuLayout.addView(edit);
        swipeMenuLayout.addView(del);
        return swipeMenuLayout;
    }

    @Override
    public ViewHolder<TextWord> onCreateViewHolder(View view, int viewType) {
        return new TextViewHolder(view, this);
    }

    public class TextViewHolder extends ViewHolder<TextWord>{

        private TextView text;
        private TextView edit;
        private TextView del;

        public TextViewHolder(View view, BaseListAdapter<TextWord> baseListAdapter) {
            super(view, baseListAdapter);
        }

        @Override
        public void onInitialize() {
            text = mItemView.findViewById(0);
            del = mItemView.findViewById(1);
            edit = mItemView.findViewById(2);
        }

        @Override
        public void onBind(final int position, int viewType) {
            TextWord textWord = getItem(position);
            text.setText(textWord.getText());
            del.setText("删除");
            del.setBackgroundColor(Color.RED);
            del.setTextColor(Color.WHITE);
            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getmItems().remove(position);
                    SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) mItemView;
                    swipeMenuLayout.quickClose();
                    notifyDataSetChanged();
                }
            });

            edit.setText("编辑");
            edit.setTextColor(Color.WHITE);
            edit.setBackgroundColor(Color.GREEN);
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                    SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) mItemView;
                    swipeMenuLayout.quickClose();
                    Toast.makeText(getContext(), "编辑", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
