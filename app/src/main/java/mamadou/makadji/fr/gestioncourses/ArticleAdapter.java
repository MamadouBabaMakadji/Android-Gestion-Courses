package mamadou.makadji.fr.gestioncourses;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MBM on 22/02/2017.
 */

public class ArticleAdapter extends ArrayAdapter<String> {
    List icons=new ArrayList<Integer>();
    List nomArticle= new ArrayList<String>();
    Activity context;
    public ArticleAdapter(Activity context, List<String>nomArticle, List<Integer>icons) {
        super(context, R.layout.row_article, nomArticle);
        this.nomArticle=nomArticle;
        this.icons = icons;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.row_article, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView2);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView2);
        txtTitle.setText(nomArticle.get(position).toString());
        int []img = {R.drawable.avocado,R.drawable.icecream,R.drawable.chili};
        imageView.setImageResource(img[position]);
        return rowView;
    }
}
