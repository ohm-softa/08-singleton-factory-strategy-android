package de.thro.inf.prg3.a08.service;

import de.thro.inf.prg3.a08.api.OpenMensaAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Peter Kurfer
 */

public class OpenMensaAPIService {
    private static final OpenMensaAPIService ourInstance = new OpenMensaAPIService();
    private final OpenMensaAPI mensaApiInstance;

    public static OpenMensaAPIService getInstance() {
        return ourInstance;
    }

    private OpenMensaAPIService() {
        Retrofit retrofit = new Retrofit.Builder()
                /* no type adapters are required so the default GSON converter is fine */
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://openmensa.org/api/v2/")
                .build();

        mensaApiInstance = retrofit.create(OpenMensaAPI.class);
    }

    public OpenMensaAPI getApi() {
        return mensaApiInstance;
    }
}
