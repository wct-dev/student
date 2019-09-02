package com.briup.main;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.briup.exception.StudentException;
import com.briup.pojo.Student;
import com.briup.service.IStudentService;
import com.briup.service.impl.StudentServiceImpl;

public class Application {
	private IStudentService service = new StudentServiceImpl();

	public void showPage() {
		System.out.println("💗💗💗💗💗💗💗💗💗💗💗💗💗💗💗💗💗");
		System.out.println("******* 学生管理系统   *******");
		System.out.println("*******1.新增学生信息*******");
		System.out.println("*******2.删除单个学生*******");
		System.out.println("*******3.删除所有学生*******");
		System.out.println("*******4.修改学生信息*******");
		System.out.println("*******5.查询单个学生*******");
		System.out.println("*******6.查询所有学生*******");
		System.out.println("*******7.管理员登录    *******");
		System.out.println("*******8.管理员登出    *******");
		System.out.println("*******9.退出系统        *******");
		System.out.println("💗💗💗💗💗💗💗💗💗💗💗💗💗💗💗💗💗");
	}

	@SuppressWarnings("resource")
	public void start() throws Exception {
		Scanner sc = new Scanner(System.in);

		while (true) {
		showPage();
			int key = sc.nextInt();
			switch (key) {
			case 1:
				try {
					if (!service.isLogin()) {
						System.out.println("请先登录");
						break;
					}
					System.out.println("请按照以下格式进行输入");
					System.out.println("学号:姓名:分数:性别");
					sc = new Scanner(System.in);
					String[] split = sc.nextLine().split(":");
					Student student = new Student();
					student.setId(split[0]);
					student.setName(split[1]);
					student.setScore(Double.parseDouble(split[2]));
					student.setGender(split[3]);
					service.addStudent(student);
					System.out.println("添加成功");
					break;
				} catch (RuntimeException e) {
					System.out.println("请输入正确的学生信息");
				}
				break;
			case 2:
				try {
					if (!service.isLogin()) {
						System.out.println("请先登录 ");
						break;
					}
					System.out.println("输入想要删除的学生学号");
					sc = new Scanner(System.in);
					String cc = sc.nextLine();
					service.removeStudentById(cc);
					System.out.println("删除成功");
					break;
				} catch (RuntimeException e1) {
					System.out.println("请输入正确的学生信息");
				}
				break;
			case 3:
				if (!service.isLogin()) {
					System.out.println("请先登录 ");
					break;
				}
				service.removeAllStudent();
				break;
			case 4:
				try {
					if (!service.isLogin()) {
						System.out.println("请先登录 ");
						break;
					}
					System.out.println("请按照以下格式进行输入");
					System.out.println("学号:姓名:分数:性别");
					sc = new Scanner(System.in);
					String[] spl = sc.nextLine().split(":");
					Student student1 = new Student();
					student1.setId(spl[0]);
					student1.setName(spl[1]);
					student1.setScore(Double.parseDouble((spl[2])));
					student1.setGender(spl[3]);
					service.updateStudentById(student1);
					System.out.println("更新成功");
					break;
				} catch (RuntimeException e1) {
					System.out.println("请输入正确的修改信息");
				}
				break;
			case 5:
				try {
					if (!service.isLogin()) {
						System.out.println("请先登录 ");
						break;
					}
					System.out.println("输入想要查询的学生学号");
					sc = new Scanner(System.in);
					String qu = sc.nextLine();
					System.out.println("-----------------------------");
					System.out.println("学号\t姓名\t分数\t性别");
					StringBuilder string = new StringBuilder();
					Student st = service.queryStudentById(qu);
					string.append(st.getId()).append("\t").append(st.getName()).append("\t").append(st.getScore())
							.append("\t").append(st.getGender());
					System.out.println(string);
					System.out.println("-----------------------------");
					break;
				} catch (RuntimeException e1) {
					System.out.println("请输入正确的学生信息");
				}
				break;
			case 6:
				if (!service.isLogin()) {
					System.out.println("请先登录 ");
					break;
				}
				Collection<Student> coll = service.queryAllStudent();

				System.out.println("-----------------------------");
				System.out.println("学号\t姓名\t分数\t性别");
				for (Student str : coll) {
					if (str == null) {
						continue;
					}
					StringBuilder string = new StringBuilder();
					
					string.append(str.getId()).append("\t").append(str.getName()).append("\t").append(str.getScore())
							.append("\t").append(str.getGender());
					System.out.println(string);

				}
				System.out.println("-----------------------------");
				break;
			case 7:
				try {
					System.out.println("请按照以下格式进行输入");
					System.out.println("用户名:密码");
					sc = new Scanner(System.in);
					String[] us = sc.nextLine().split(":");
					service.login(us[0], us[1]);
					System.out.println("登录成功");
					break;
				} catch (Exception e) {
					System.out.println("请输入正确的用户名与密码");
				}
				break;
			case 8:
				service.logout();
				System.out.println("成功注销");
				break;
			case 9:
				service.logout();
				service.exitSystem();
				System.out.println("系统成功关闭，欢迎下次使用！");
				System.exit(-1);
				break;
			default:
				System.out.println("请输入正确的数字");
				break;
			}

		}

	}

	public static void main(String[] args) throws Exception {
		new Application().start();

	}
}
