package francois.roizot.mytodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by froizot on 01/03/2017.
 */
public class TodoActivity extends Activity implements View.OnClickListener {
    private Button navigateBtn;
    private Button emptyListBtn;
    private ListView myListView;
    private ArrayListSingleton arrayListSingleton = ArrayListSingleton.getInstance();
    private static final int MON_ACTIVITE_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);
        myListView = (ListView) findViewById(R.id.myListView);
        this.myListView.setAdapter(new ArrayAdapter(getApplicationContext(), R.layout.my_list_view, arrayListSingleton.getItems()));
        navigateBtn = (Button) findViewById(R.id.navigateBtn);
        navigateBtn.setOnClickListener(this);
        emptyListBtn = (Button) findViewById(R.id.emptyListBtn);
        emptyListBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigateBtn :
                startMonActivite();
                break;

            case R.id.emptyListBtn :
                this.arrayListSingleton.empty();
                break;
        }
        this.myListView.invalidateViews();
    }

    private void startMonActivite(){
        Intent myIntent = new Intent(getApplicationContext(), AddTask.class);
        startActivityForResult(myIntent, MON_ACTIVITE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MON_ACTIVITE_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                String s = data.getStringExtra("etat");
                arrayListSingleton = ArrayListSingleton.getInstance();
                this.myListView.invalidateViews();
            }
        }
    }
}
