package mamadou.makadji.fr.gestioncourses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static mamadou.makadji.fr.gestioncourses.R.layout.row_article;

public class CoursesActivity extends AppCompatActivity {

    private String listeName;
    private String heure;
    ListView listView;
    Button btn_ajouter;
    Button btn_effacer;
    int i=1;
    List courseName = new ArrayList<String>();
    private List images = new ArrayList<Integer>();
    private List articleName = new ArrayList<String>();
    int [] icons = {R.drawable.avocado,R.drawable.icecream,R.drawable.chili};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        Intent intent = getIntent();
        listeName = intent.getStringExtra("liste");
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
        Date date = new Date();
        heure = date.toString();
        textView.setText(listeName);
        textViewDate.setText(heure);
        listView = (ListView) findViewById(R.id.listView);
        btn_ajouter = (Button) findViewById(R.id.button_ajouter);
        btn_effacer = (Button) findViewById(R.id.button_effacer);
        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                images.add(new Article(icons[i]));
                Article article = new Article("Article "+i);
                articleName.add(article.getNom());
                ArticleAdapter adapter = new ArticleAdapter(CoursesActivity.this,articleName,images);
                listView.setAdapter(adapter);
                i++;
            }
        });
        btn_effacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                images.removeAll(images);
                articleName.removeAll(articleName);
                ArticleAdapter adapter = new ArticleAdapter(CoursesActivity.this,articleName,images);
                listView.setAdapter(adapter);
                i=1;
            }
        });
    }
}
