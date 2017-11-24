package mamadou.makadji.fr.gestioncourses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button btn_ajouter;
    private Button btn_effacer;
    private int i=1;
    private ArrayList listes = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        btn_ajouter = (Button) findViewById(R.id.button_ajouter);
        btn_effacer = (Button) findViewById(R.id.button_effacer);
        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listes.add(new ListeCourse("Liste"+ " "+i).toString());
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listes);
                listView.setAdapter(adapter);
                i++;
            }
        });
        btn_effacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listes.removeAll(listes);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listes);
                listView.setAdapter(adapter);
                i=1;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CoursesActivity.class);
                String item = ((TextView) view).getText().toString();
                intent.putExtra("liste",item);
                startActivity(intent);
            }
        });
    }
}
