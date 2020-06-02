package com.example.proyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.model.Billetes;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context ctxt;
    private List<Billetes> billetesList;
    public OnItemClickListener mlistener;

    public interface OnItemClickListener{
        void onItemClick(int position);
            }
            public void setOnItemClickListener(OnItemClickListener listener){
        mlistener=listener;

            }

    public Adapter(Context ctxt, List<Billetes> billetesList) {
        this.ctxt = ctxt;
        this.billetesList = billetesList;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        LayoutInflater inflater=LayoutInflater.from(ctxt);
        View v =  inflater.inflate(R.layout.listview_item, null);

        return new Adapter.MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
     Billetes b=billetesList.get(position);
     String nombre=b.getS();
     String fech=b.getFecha();
     holder.textdest.setText(nombre);
     holder.textfec.setText(fech);
     int opc=b.getPagado();
     if(opc==0){
         holder.textPay.setText("Pagar al subir");
     }else{
         holder.textPay.setText("Pagado con GPay");
     }

    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView textdest;
        TextView textfec;
        TextView textPay;
        public MyViewHolder(View v) {
            super(v);
           textdest=v.findViewById(R.id.txtBillnombre);
           textfec=v.findViewById(R.id.txtBillfecha);
           textPay=v.findViewById(R.id.txtBillpagado);
           v.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(mlistener!=null){
                       int position=getAdapterPosition();
                       if(position!=RecyclerView.NO_POSITION){
                           mlistener.onItemClick(position);
                       }
                   }
               }
           });
        }
    }

    @Override
    public int getItemCount() {
        return billetesList.size();
    }
}
