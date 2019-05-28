package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dbs, uob, ocbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.dbs);
        uob = findViewById(R.id.uob);
        ocbc = findViewById(R.id.ocbc);

        registerForContextMenu(dbs);
        registerForContextMenu(uob);
        registerForContextMenu(ocbc);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == dbs.getId()) {
            menu.add(0,0,0, getString(R.string.website));
            menu.add(0,1,0, getString(R.string.contact));
        } else if (v.getId() == ocbc.getId()) {
            menu.add(0,2,0, getString(R.string.website));
            menu.add(0,3,0, getString(R.string.contact));
        } else if (v.getId() == uob.getId()) {
            menu.add(0, 4, 0, getString(R.string.website));
            menu.add(0, 5, 0, getString(R.string.contact));
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            //Toast.makeText(MainActivity.this, "Hello world", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbs_web)));
            startActivity(i);
            return true;
        } else if (item.getItemId() == 1) {
            //Toast.makeText(MainActivity.this, "Hello world2", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbs_phone)));
            startActivity(i);
            return true;
        } else if (item.getItemId() == 2) {
            //Toast.makeText(MainActivity.this, "Hello world3", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbc_web)));
            startActivity(i);
            return true;
        } else if (item.getItemId() == 3) {
            //Toast.makeText(MainActivity.this, "Hello world5", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbc_phone)));
            startActivity(i);
            return true;
        } else if (item.getItemId() == 4) {
            //Toast.makeText(MainActivity.this, "Hello world6", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uob_web)));
            startActivity(i);
            return true;
        } else if (item.getItemId() == 5) {
            //Toast.makeText(MainActivity.this, "Hello world7", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uob_phone)));
            startActivity(i);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Chinese");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 0:
                uob.setText(getString(R.string.uob));
                dbs.setText(getString(R.string.dbs));
                ocbc.setText(getString(R.string.ocbc));
                return true;
            case 1:
                uob.setText(getString(R.string.uob_chi));
                dbs.setText(getString(R.string.dbs_chi));
                ocbc.setText(getString(R.string.ocbc_chi));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
