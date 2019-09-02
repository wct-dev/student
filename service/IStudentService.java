package com.briup.service;

import java.util.Collection;

import com.briup.exception.StudentException;
import com.briup.pojo.Student;
/**
 * 
 * @author Elvira
 *
 */
public interface IStudentService {
	
	void login(String username, String password) throws StudentException;
	/**
	 * 
	 * @return LCuccess:true  LFalse:false
	 * @throws StudentException
	 * @throws Exception 
	 */
	boolean isLogin() throws StudentException;
	/**
	 * ÍË³öµÇÂ¼
	 * @throws StudentException
	 * @throws Exception 
	 */
	void logout() throws StudentException;
	
	void addStudent(Student student) throws StudentException;
	
	void removeStudentById(String id) throws StudentException;
	
	void removeAllStudent() throws StudentException;
	
	void updateStudentById(Student student) throws StudentException;
	
	Student queryStudentById(String id) throws StudentException;
	
	Collection<Student> queryAllStudent() throws StudentException;

	void exitSystem() throws StudentException;
}
