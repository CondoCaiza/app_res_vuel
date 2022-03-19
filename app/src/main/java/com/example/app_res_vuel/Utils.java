package com.example.app_res_vuel;

import com.example.app_res_vuel.service.APIClient;
import com.example.app_res_vuel.service.IPersonaService;
import com.example.app_res_vuel.service.IReservaService;
import com.example.app_res_vuel.service.IUsuarioService;

public class Utils {
    public static IUsuarioService getAPIUser() {
        return APIClient.getAPIClient().create(IUsuarioService.class);
    }
    public static IPersonaService getAPIPer() {
        return APIClient.getAPIClient().create(IPersonaService.class);
    }
    public static IReservaService getAPIRes() {
        return APIClient.getAPIClient().create(IReservaService.class);
    }
}
