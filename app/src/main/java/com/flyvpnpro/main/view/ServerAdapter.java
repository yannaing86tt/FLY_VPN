package com.flyvpnpro.main.view;

import android.content.Context;
import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flyvpnpro.official.R;
import java.util.ArrayList;
import java.util.HashMap;
import com.flyvpnpro.second.config.Settings;
import com.flyvpnpro.main.activities.BaseActivity;
import com.flyvpnpro.main.MainApp;


public class ServerAdapter extends RecyclerView.Adapter<ServerAdapter.MyViewHolder> {

     ArrayList<HashMap<String, String>> data;
    HashMap<String, String> resultp;
    
    private Context cont;
    
    private static boolean isServer = false;

    private static int defpos = 0;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView country;
        public ImageView flag;
        public LinearLayout ll;
        private TextView info;
        private ImageView free;
        private ImageView vipp;

        public MyViewHolder(View view) {
            super(view);
            ll = (LinearLayout) itemView.findViewById(R.id.serverListLayout);
            country = (TextView) itemView.findViewById(R.id.imageNameSpinner);
            flag = (ImageView) itemView.findViewById(R.id.imageIconSpinner);
            info = (TextView) itemView.findViewById(R.id.infoSpinner);
            free = (ImageView) itemView.findViewById(R.id.free);
            vipp = (ImageView) itemView.findViewById(R.id.vip);
            
            }
    }

    public ServerAdapter(Context c, boolean isServer, int defpos, ArrayList<HashMap<String, String>> arraylist) {
        data = arraylist;
        cont = c;
        this.isServer = isServer;
        this.defpos = defpos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.layout_spinner_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      
        resultp = data.get(position);
        if (defpos == position) {
            holder.ll.setBackgroundResource(R.drawable.selected_server_bg);
            holder.country.setTextColor(Color.parseColor("#ff73ec47"));            
            holder.info.setTextColor(Color.parseColor("#ff73ec47"));
            // myViewHolder2.location.setTextColor(ContextCompat.getColor(r0.context, 2131361893));
        } else {
            holder.ll.setBackgroundColor(Color.TRANSPARENT);
//            if (new Settings(MainApp.getApp()).getModoNoturno().equals("off")) {
                holder.country.setTextColor(Color.parseColor("#FFFFFF"));
                holder.info.setTextColor(Color.parseColor("#FFDA0A"));
      /*      } else {
                holder.country.setTextColor(Color.parseColor("#FFFFFF"));
                holder.info.setTextColor(Color.parseColor("#FFDA0A"));
            } // myViewHolder2.location.setTextColor(ContextCompat.getColor(r0.context, 2131361895));
        } */
        }
        holder.country.setText(resultp.get("COUNTRY"));
        holder.info.setText(this.resultp.get("INFO"));
        
        try {
            String str = resultp.get("FLAG");
            String name = resultp.get("COUNTRY").toLowerCase();

            if(isServer){
                if (str.contains("sg")) {
                    holder.flag.setImageResource(R.drawable.sg);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("us")) {
                    holder.flag.setImageResource(R.drawable.us);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("uk")) {
                    holder.flag.setImageResource(R.drawable.uk);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("jp")) {
                    holder.flag.setImageResource(R.drawable.jp);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("tl")) {
                    holder.flag.setImageResource(R.drawable.tl);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("th")) {
                    holder.flag.setImageResource(R.drawable.th);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("ph")) {
                    holder.flag.setImageResource(R.drawable.ph);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("kr")) {
                    holder.flag.setImageResource(R.drawable.kr);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("ca")) {
                    holder.flag.setImageResource(R.drawable.ca);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }
                }else if (str.contains("ch")) {
                    holder.flag.setImageResource(R.drawable.ch);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }  
                }else if (str.contains("de")) {
                    holder.flag.setImageResource(R.drawable.de);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    } 
                }else if (str.contains("fr")) {
                    holder.flag.setImageResource(R.drawable.fr);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }      
                }else if (str.contains("hk")) {
                    holder.flag.setImageResource(R.drawable.hk);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }   
                }else if (str.contains("id")) {
                    holder.flag.setImageResource(R.drawable.id);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }  
                }else if (str.contains("in")) {
                    holder.flag.setImageResource(R.drawable.in);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    } 
                }else if (str.contains("lb")) {
                    holder.flag.setImageResource(R.drawable.lb);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }    
                }else if (str.contains("mm")) {
                    holder.flag.setImageResource(R.drawable.mm);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    } 
                }else if (str.contains("pt")) {
                    holder.flag.setImageResource(R.drawable.pt);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }   
                }else if (str.contains("tk")) {
                    holder.flag.setImageResource(R.drawable.tk);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }      
               }else if (str.contains("tw")) {
                    holder.flag.setImageResource(R.drawable.tw);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }     
                 }else if (str.contains("uo")) {
                    holder.flag.setImageResource(R.drawable.uo);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }   
                }else if (str.contains("vt")) {
                    holder.flag.setImageResource(R.drawable.vt);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }    
                }else if (str.contains("at")) {
                    holder.flag.setImageResource(R.drawable.at);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    } 
                }else if (str.contains("br")) {
                    holder.flag.setImageResource(R.drawable.br);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }       
                }else if (str.contains("kh")) {
                    holder.flag.setImageResource(R.drawable.kh);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }   
                }else if (str.contains("pl")) {
                    holder.flag.setImageResource(R.drawable.pl);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }     
                 }else if (str.contains("nl")) {
                    holder.flag.setImageResource(R.drawable.nl);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                    }   
                    
                }else if (str.contains("ie")) {
                    holder.flag.setImageResource(R.drawable.ie);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                        
                        
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                        
                    }
                    
                }else if (str.contains("in")) {
                    holder.flag.setImageResource(R.drawable.in);
                    if (name.contains("vip")) {
                        holder.vipp.setVisibility(View.VISIBLE);
                        holder.free.setVisibility(View.GONE);
                        
                        
                    } else {
                        holder.vipp.setVisibility(View.GONE);
                        holder.free.setVisibility(View.VISIBLE);
                        
                    }       
                    
                } else {
                    holder.flag.setImageResource(R.drawable.icons);
                    holder.vipp.setVisibility(View.GONE);
                    holder.free.setVisibility(View.GONE);
                    
                    }  
                }
                
        } catch(Exception e) {
            //Toast.makeText(c, e.getMessage(), 1).show();
        }
    }

    @Override
    public int getItemCount() {
       return data.size();
        //return 0;
    }
}

