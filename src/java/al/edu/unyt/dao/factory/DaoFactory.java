/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.edu.unyt.dao.factory;

import al.edu.unyt.dao.interfaces.DepartmentDao;
import al.edu.unyt.dao.interfaces.impl.DepartmentDaoImpl;

/**
 *
 * @author elton.ballhysa
 */
public class DaoFactory {
    
    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoImpl();
    }
    
}
