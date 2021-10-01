package org.ova_api.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
public class OvaController {
    private final JdbcTemplate jdbc;
    private EntityManager entityManager;
    public OvaController(DataSource dt){
        this.jdbc = new JdbcTemplate(dt);
    }

    @RequestMapping(value = "/ova", method = RequestMethod.POST)
    @ResponseBody
    public String createOva(@RequestBody String user, HttpServletResponse response) throws IOException {


        try {

            JSONObject jsonObj = new JSONObject(user);
            System.out.println(jsonObj);
            jdbc.update("INSERT INTO `ovas` (`id`, `titulo`, `descripcion`, `idioma`, `palabras_Clave`, `autor`, `entidad`, `version`, `fecha`, `formato`, `instrucciones`, `requerimientos`, `costo`, `derechos`, `uso`, `are_id`, `nuc_id`, `use_id`, `archivo`, `created_at`, `updated_at`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",jsonObj.getInt("id"),jsonObj.getString("titulo"),jsonObj.getString("descripcion"),jsonObj.getString("idioma"),jsonObj.getString("palabras_clave"),jsonObj.getString("autor"),jsonObj.getString("entidad"),jsonObj.getInt("version"),jsonObj.getString("fecha"),jsonObj.getString("formato"),jsonObj.getString("instrucciones"),jsonObj.getString("requerimientos"),jsonObj.getInt("costo"),jsonObj.getString("derechos"),jsonObj.getString("uso"),jsonObj.getInt("are_id"),jsonObj.getInt("nuc_id"),jsonObj.getInt("use_id"),jsonObj.getString("archivo"),jsonObj.getString("created_at"),jsonObj.getString("created_at"));
            System.out.println("llego aqui");
            return user;
        } catch (Exception e) {

            response.addHeader("errMsg", "Nombre de usuario en uso");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return "";
        }

    }

}
