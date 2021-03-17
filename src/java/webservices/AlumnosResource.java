package webservices;

import datos.FabricaDatos;
import datos.IDatos;
import entities.Alumno;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Alfonso Felix
 */
@Path("alumnos")
public class AlumnosResource {

    private final IDatos datos;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public AlumnosResource() {
        datos = FabricaDatos.getFachada();
    }

    /**
     * Retrieves representation of an instance of webservices.AlumnosResource
     *
     * @return an instance of entities.Alumno
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alumno> getAlumnos() {
        return datos.consultarAlumnos();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno getAlumnos(@PathParam("id") int id) {
        return datos.consultarAlumno(id);
    }
    
    @GET
    @Path("/datos")
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno getAlumnos(
        @QueryParam("matricula") String matricula) {
        return datos.consultarAlumno(matricula);
    }

    /**
     * PUT method for updating or creating an instance of AlumnosResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response putAlumno(@PathParam("id") int id, Alumno alumno) {
        try {
            alumno.setId(id);
            datos.guardarAlumno(alumno);
            return Response.status(200).entity("actualizado").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postAlumno(Alumno alumno) {
        try {
            Alumno a = datos.guardarAlumno(alumno);
            return Response.status(200).entity(a).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteAlumno(@PathParam("id") int id) {
        try {
            datos.eliminarAlumno(id);
            return Response.status(200).entity("eliminado").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
