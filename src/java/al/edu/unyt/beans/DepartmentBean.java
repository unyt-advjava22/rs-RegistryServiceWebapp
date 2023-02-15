/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.edu.unyt.beans;

import al.edu.unyt.dao.factory.DaoFactory;
import al.edu.unyt.dao.interfaces.DepartmentDao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;
import al.edu.unyt.rest.model.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author elton.ballhysa
 */
@Named("departmentBean")
@RequestScoped
public class DepartmentBean {
    
    private String code;
    private String name;
    
    private final DepartmentDao departmentDao;
    
    public DepartmentBean() {
        departmentDao = DaoFactory.createDepartmentDao();
    }
   
    public void load() {
        Department department = departmentDao.find(code);
        name = department.getName();
    }

    public String insert() {
        Department department = new Department();
        department.setCode(code);
        department.setName(name);
        try {
            departmentDao.insert(department);
            return "index";
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "new";
        }
    }
    
    public String update() {
        Department department = new Department();
        department.setCode(code);
        department.setName(name);
        try {
            departmentDao.update(department);
            return "index";
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "edit";
        }
    }

    public String delete() {
        try {
            departmentDao.remove(code);
            return "index";
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "edit";
        }
    }

    public List<Department> getDepartments() {
        return departmentDao.findAll();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
