package com.core.polo.Manager;

// CÓDIGO EXTRAIDO DE https://github.com/BetTD/CorumCore/blob/master/src/main/java/wtf/eugenio/corumcore/managers/DiscordManager.java


import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DiscordManager {
    public static void sendStartWebhook() { sendWebhook("**El servidor se ha iniciado.**", 1437014); }

    public static void sendStoppingWebhook() { sendWebhook("**El servidor se está apagando.**", 15542298); }

    private static void sendWebhook(String msg, int color) {
        URL webhooklink;
        try {
            webhooklink = new URL("pon el webhook aquí que me da pereza poner un config.yml");
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                df.setTimeZone(TimeZone.getTimeZone("UTC"));
                String timestamp = df.format(new Date());
                HttpURLConnection http = (HttpURLConnection) webhooklink.openConnection();
                http.addRequestProperty("Content-Type", "application/json");
                http.addRequestProperty("User-Agent", "Basic-Core/");
                http.setDoOutput(true);
                http.setRequestMethod("POST");

                JSONObject obj = new JSONObject();

                List<JSONObject> embeds = new ArrayList<>();
                JSONObject objEmbed = new JSONObject();
                objEmbed.put("type", "rich");
                objEmbed.put("title", "Cambio de estado");
                objEmbed.put("description", msg);
                objEmbed.put("color", color);
                objEmbed.put("timestamp", timestamp);
                objEmbed.put("footer", new JSONObject().put("text", "ip"));
                embeds.add(objEmbed);

                obj.put("embeds", embeds);

                OutputStream out = http.getOutputStream();
                out.write(obj.toString().getBytes(StandardCharsets.UTF_8));
                out.flush();
                out.close();
                http.getInputStream().close();
                http.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}