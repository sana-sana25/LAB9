package com.example.projetws.network;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    private static VolleySingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    // Constructeur privé (pattern Singleton)
    private VolleySingleton(Context context) {
        ctx = context.getApplicationContext();
        requestQueue = getRequestQueue();
    }

    // Instance unique
    public static synchronized VolleySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new VolleySingleton(context);
        }
        return instance;
    }

    // Getter RequestQueue
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx);
        }
        return requestQueue;
    }

    // Ajouter une requête à la file
    public <T> void addToRequestQueue(com.android.volley.Request<T> req) {
        getRequestQueue().add(req);
    }
}