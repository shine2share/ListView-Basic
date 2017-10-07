package come.wordpress.share2study.oop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    List<String> courses;
    EditText edtMonHoc;
    Button btnAdd, btnRemove, btnUpdate;
    int location = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView) findViewById(R.id.lvMonHoc);
        edtMonHoc = (EditText) findViewById(R.id.edtMonHoc);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        courses = new ArrayList<>();

        courses.add("Android");
        courses.add("Java");
        courses.add("Python");
        courses.add("PHP");
        courses.add("Ruby");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, courses);
        lvMonHoc.setAdapter(arrayAdapter);
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonHoc.setText(courses.get(i));
                location = i;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monHoc = edtMonHoc.getText().toString();
                courses.add(monHoc);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courses.set(location, edtMonHoc.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courses.remove(location);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
