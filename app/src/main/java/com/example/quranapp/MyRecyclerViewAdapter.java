package com.example.quranapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyVH> {

    List<TRanslation> transList;
    private int rowLayout;
    private Context mcontext;
    private OnItemClickListener clickListener;
    public MyRecyclerViewAdapter(List<TRanslation> friendsList,int rowLayout,Context context) {
        this.rowLayout=rowLayout;
        this.mcontext=context;
        this.transList = friendsList;
    }
    public MyRecyclerViewAdapter(List<TRanslation> friendsList) {
        this.transList = friendsList;
    }
    @NonNull
    @Override
    public  MyRecyclerViewAdapter.MyVH onCreateViewHolder(ViewGroup viewGroup,int position)
    {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,viewGroup,false);
        return new MyVH(v);
    }

//    @NonNull
//    @Override
//    public MyRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.translationcustomizedview, parent, false);
//        return new MyVH(itemView);
//    }
 public void setClickListener(OnItemClickListener itemClickListener)
 {
     this.clickListener=itemClickListener;
 }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyVH holder, int position) {
        holder.data=transList.get(position);
        holder.english.setText(holder.data.getEnglish());
        holder.urdu.setText(String.valueOf(holder.data.getUrdu()));

    }

    @Override
    public int getItemCount() {
        return transList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView english;
        TextView urdu;
        TRanslation data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            english = itemView.findViewById(R.id.englishtrans);
            urdu = itemView.findViewById(R.id.urdutrans);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view)
        {
            if(clickListener!=null) clickListener.onClick(view,getAdapterPosition());
        }
    }
}
