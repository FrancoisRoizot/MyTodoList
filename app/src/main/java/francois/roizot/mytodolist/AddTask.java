package francois.roizot.mytodolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by froizot on 01/03/2017.
 */
public class AddTask extends Activity implements View.OnClickListener {

    private Button addTask;
    private EditText myNewTask;
    private ArrayListSingleton arrayListSingleton = ArrayListSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        addTask = (Button) findViewById(R.id.addTask);
        addTask.setOnClickListener(this);
        myNewTask = (EditText) findViewById(R.id.myNewTask);
        Log.i("plop", arrayListSingleton.getItems().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addTask :
                this.arrayListSingleton.addItem(myNewTask.getText().toString());
                activiteTerminee(true);
                break;
        }
    }

    private void activiteTerminee(boolean resultat){
        if (resultat){
            Intent fermetureMonActivite = new Intent();
            setResult(RESULT_OK,fermetureMonActivite);
        }else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}
