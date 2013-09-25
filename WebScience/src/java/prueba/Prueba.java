/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.google.code.ckJsfEditor.Config;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos
 */
@Named(value = "prueba")
@SessionScoped
public class Prueba implements Serializable {

    private Config config;
    private String contenido;
    /**
     * Creates a new instance of Prueba
     */
    public Prueba() {

        config = new Config();
        config.filebrowserBrowseUrl("http://localhost/RepoGiibPortal/kcfinder/browse.php");
        config.filebrowserImageBrowseUrl("http://localhost/RepoGiibPortal/kcfinder/browse.php?type=images");
        config.filebrowserFlashBrowseUrl("http://localhost/RepoGiibPortal/kcfinder/browse.php?type=flash");
        config.filebrowserUploadUrl("http://localhost/RepoGiibPortal/kcfinder/upload.php?type=files");
        config.filebrowserImageUploadUrl("http://localhost/RepoGiibPortal/kcfinder/upload.php?type=images");
        config.filebrowserFlashUploadUrl("http://localhost/RepoGiibPortal/kcfinder/upload.php?type=flash");

    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
}
