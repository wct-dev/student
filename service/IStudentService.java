package com.briup.service;

import java.util.Collection;

import com.briup.exception.StudentException;
import com.briup.pojo.Student;
/**
 * 接口
 * @author Elvira
 *
 */
public interface IStudentService {
	/**
	 * 根据用户名密码去登录
	 * @param username 用户名
	 * @param password 密码
	 * @throws StudentException
	 */
	void login(String username, String password) throws StudentException;
	/**
	 * 判断用户是否登录
	 * @return 登录成功 true 未登录 false
	 * @throws StudentException
	 */
	boolean isLogin() throws StudentException;
	/**
	 * 注销账户
	 * @throws StudentException
	 */
	void logout() throws StudentException;
	/**
	 * 添加一条学生信息
	 * @throws StudentException
	 */
	void addStudent(Student student) throws StudentException;
	/**
	 * 删除一条学生信息
	 * @throws StudentException
	 */
	void removeStudentById(String id) throws StudentException;
	/**
	 * 删除所有学生信息
	 * @throws StudentException
	 */
	void removeAllStudent() throws StudentException;
	/**
	 * 修改一条学生信息
	 * @throws StudentException
	 */
	void updateStudentById(Student student) throws StudentException;
	/**
	 * 查询一条学生信息
	 * @return 根据id查询到的学生信息
	 * @throws StudentException
	 */
	Student queryStudentById(String id) throws StudentException;
	/**
	 * 查询所有学生信息
	 * @return 所有学生信息
	 * @throws StudentException
	 */
	Collection<Student> queryAllStudent() throws StudentException;
	/**
	 * 退出系统
	 * @throws StudentException
	 */
	void exitSystem() throws StudentException;
}
