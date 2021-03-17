/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alfonso Felix
 */
public class FabricaDatos {

    private static IDatos datos;

    public static IDatos getFachada() {
        if (datos == null) {
            EntityManager em;
            EntityManagerFactory managerFactory
                    = Persistence.createEntityManagerFactory("RESTService_Equipo0PU");
            em = managerFactory.createEntityManager();
            datos = new FDatos(em);
        }
        return datos;
    }
}
