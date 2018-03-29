package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Context;
import android.content.Intent;

/**
 * Created by student on 29.03.2018.
 */

class ProcessingThread extends Thread {

    private Context context;

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        Intent intent = new Intent();

        intent.setAction("instr");
        intent.putExtra("")
    }
}
