/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.edu.unyt.dao.interfaces.impl;

import al.edu.unyt.dao.interfaces.DepartmentDao;
import al.edu.unyt.rest.model.Department;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author elton.ballhysa
 */
public class DepartmentDaoImpl implements DepartmentDao {

    public static final String BASE_URI = "http://localhost:8080/rs-RegistryServiceAPI/rest/";

    @Override
    public List<Department> findAll() {
        return ClientBuilder
                .newClient()
                .target(BASE_URI)
                .path("departments")
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<Department>>() {});
    }

    @Override
    public Department find(String departmentCode) {
        return ClientBuilder
                .newClient()
                .target(BASE_URI)
                .path("departments")
                .path(departmentCode)
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Department.class);
    }

    @Override
    public void insert(Department model) {
        Response response = ClientBuilder.newClient()
                .target(BASE_URI)
                .path("departments")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(model, MediaType.APPLICATION_JSON));
        boolean success = response.getStatus() >= 200 && response.getStatus() <= 299;
        System.out.println((success ? "OK" : "NOK") + ", status=" + response.getStatus());
        if (! success)
            throw new RuntimeException("insert failed: " + response);
    }

    @Override
    public void update(Department model) {
        Response response = ClientBuilder.newClient()
                .target(BASE_URI)
                .path("departments")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(model, MediaType.APPLICATION_JSON));
    }

    @Override
    public void remove(String departmentCode) {
        Response response = ClientBuilder.newClient()
                .target(BASE_URI)
                .path("departments")
                .path(departmentCode)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }
    
}
