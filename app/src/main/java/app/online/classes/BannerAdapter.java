package app.online.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.online.classes.bean.BannerBean;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerView>
{
    Context context;
    ArrayList<BannerBean> bannerBean;

    public BannerAdapter(Context context, ArrayList<BannerBean> bannerBean)
    {
        this.context = context;
        this.bannerBean = bannerBean;
    }

    @NonNull
    @Override
    public BannerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new BannerView(LayoutInflater.from(context).inflate(R.layout.layout_banner,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BannerView holder, final int position)
    {
        holder.txtTitle.setText(bannerBean.get(position).getBanner_title());
        holder.txtDescription.setText(bannerBean.get(position).getDescription());
        if(bannerBean.get(position).getBanner_color().equals("0"))
        {
            holder.crdBanner.setBackgroundColor(context.getResources().getColor(R.color.colorRed));
        }else
        {
            holder.crdBanner.setBackgroundColor(context.getResources().getColor(R.color.colorGreen));
        }
        holder.btnDetail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ((MainActivity)context).gotoNext(Integer.valueOf(bannerBean.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return bannerBean.size();
    }

    public class BannerView extends RecyclerView.ViewHolder
    {
        TextView txtTitle,txtDescription;
        Button btnDetail;
        CardView crdBanner;
        public BannerView(@NonNull View itemView)
        {
            super(itemView);
            txtTitle=(TextView)itemView.findViewById(R.id.txtTitle);
            txtDescription=(TextView)itemView.findViewById(R.id.txtDescription);
            btnDetail=(Button)itemView.findViewById(R.id.btnDetail);
            crdBanner=(CardView)itemView.findViewById(R.id.crdBanner);
        }
    }
}
