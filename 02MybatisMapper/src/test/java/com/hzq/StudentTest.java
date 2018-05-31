package com.hzq;
import com.hzq.bean.Student;
import com.hzq.dao.StudentDao;
import com.hzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class StudentTest {

    StudentDao dao = null;
    SqlSession session=null;
    Logger log = Logger.getLogger(StudentTest.class);

    @Before
    public void before() {
        session= SessionFactoryUtil.getSession();
        dao=session.getMapper(StudentDao.class);

    }
    @After
    public void after(){
        session.close();
    }
    @Test
    public void addStudent() {
        Student student = new Student(55, "小黑");
        log.debug("insert之前的编号" + student.getId());
        dao.addStudent(student);
        log.debug("insert之后的编号" + student.getId());

    }

    @Test
    public void addStudentByCache() {
        Student student = new Student(55, "小黑111");
        log.debug("insert之前的编号" + student.getId());
        dao.addStudentByCache(student);
        log.debug("insert之后的编号" + student.getId());
        session.commit();
    }

    /*
    删除数据库
     */
    @Test
    public void deleteStudent() {
        dao.deleteStudent(12);
        session.commit();
    }

    /*
    修改数据库
     */
    @Test
    public void updateStudent() {
        Student student = new Student(8, "哈哈111", 33);
        dao.updateStudent(student);
        session.commit();
    }
    /*
      id查询
     */
    @Test
    public void findById() {

    Student student=dao.findById(4);
    log.trace(student);


    }
    /*
    List 集合
     */
    @Test
    public  void listStudent(){
        List<Student> student=dao.findAll();
        log.debug(student);
    }
    /*
    map集合
     */
    @Test
    public  void mapStudent(){
        List<Map<String,Object>> students=dao.findAllStu();
        log.trace(students.size());
       // log.debug(students.get("嘿嘿"));
    }
    @Test
    public void selectByName(){
        List<Student> students=dao.selectByName("哈哈");
        log.trace(students);
    }
    /**
     * 数字平方的位数等于自身
     * 0   0
     * 1   1
     * 2    4
     * 3    9
     * 4    16
     * 5    25
     * 6    36
     * 7    49
     * 8     64
     * 9      81
     */
    @Test
    public void test06(){
        int a =1000000;


        for ( int i=0;i<a;i++){
            int n=i*i;
            int m=n%10;
            if(m!=0&m!=1&m!=5&m!=6){
                continue;
            }
            if(n%10==i||n%100==i||n%1000==i||n%10000==i||n%100000==i||n%1000000==i){
                System.out.println(i);
            }
        }
    }
    @Test
    public void test07(){
        for(int i=0;i<5;i++){
            for(int j=0;j<9-i;j++)
                System.out.print(" ");
            for (int n=0;n<i+1;n++)
                System.out.print("* ");
            System.out.println("");
        }

    }

    /**
     *      A
     *     ABA
     *    ABCBA
     *   ABCDBCA
     *  ABCDEDCBA
     * ABCDEFEDCBA
     */
    @Test
    public void test08(){
        System.out.println("     A");  //行数 1 2 3 4 5 6
        System.out.println("    ABA"); //空格 5 4 3 2 1 0
        System.out.println("   ABCBA");//行数 1 2 3 4 5 6
        System.out.println("  ABCDBCA");//左边1 2 3 4 5 6
        System.out.println(" ABCDEDCBA");//右边0 1 2 3 4 5
        System.out.println("ABCDEFEDCBA");
        int n=6;
        for(int i=0;i<n;i++){//控制行数
            for(int j=0;j<n-i;j++)//控制空格
                System.out.print(" ");
            for(int c=0;c<=i;c++)
                System.out.print((char)('A'+c));
            for(int m=i-1;m>=0;m--)
                System.out.print((char)('A'+m));
                System.out.println();

        }
    }

    /**
     * 一刀切法 上式事前格式格式
     * "String a="ab cd,   bc,de ac""
     * 获取每个字符串
     */
    @Test
    public void test09(){
        String a="ab cd,bc,de ac";
        String result=" ";
        a+=",";

        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
                if(c==' '||c==','){
                    System.out.print(result);
                    result=" ";
                }else {
                   result+=c;
                }
        }
    }

    /**
     * 把字符串 String a="abcde"
     * 变成  a,b,c,d,e
     */
    @Test
    public void test10(){
        String a="abcde";
        String result="";

        for(int i=0;i<a.length();i++){
            result+=","+a.charAt(i);
        }
        System.out.println(result.substring(1));

    }
    //判断字符串中是否有相同的字母
    @Test
    public void tets11(){
    String str="abcdefgha";
    //假设修正法
        boolean flag=false;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(str.lastIndexOf(c)!=i){
                flag=true;
                break;
            }
        }
        System.out.println(flag);
    }

    /**
     * 8576
     * 求数字黑洞
     */
    @Test
    public void test12() {
        String str = "8112";

        for (; ; ) {
            char[] s = str.toCharArray();
      /*  num=str.compareTo(str);*/
            Arrays.sort(s);
            int max = 0;
            int min = 0;
            for (int i = 0; i < str.length(); i++) {
                min = min * 10 + (s[i] - '0');
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                max = max * 10 + (s[i] - '0');
            }
            int m = max - min;
            System.out.println(m);
            if(m==6174){
                break;
            }
            str = m + "";
        }
    }
    /**
     * 任意进制之间的转换
     * String str="20011002"
     */
    @Test
    public void test13(){
        String str="20011002";
        int num=0;
        for (int i=0;i<str.length();i++) {
             int c = str.charAt(i);
            num=num*3+c-'0';
        }
        System.out.println(num);
        String res="";
        for(;;) {
            if (num== 0)
                break;
            res=num%5+res;
            num=num/5;
        }
        System.out.println(res);
    }
    /**
     * String st
     */
    @Test
    public void test14(){
        String str="abc bcd  dvf asd   end";
        String[] slip=str.split(" {1,}");
        String[] slip1=str.split(" +");
        for(int i=0;i<slip.length;i++){
            System.out.println(slip[i]);
        }

    }

    /**
     * AS12
     * ASD65535
     * 字母最多出现三次数字最多五位
     * 正则表达式小括号括起来是表示正则的子组后期用$符号获取
     */
    @Test
    public void test15(){
        String str="AS12";
        boolean flag=str.matches("[A-Z]{1,3}[0-9]{1,5}");
        System.out.println(flag);
    }
    @Test
    public void test16(){
        String str="aaaasss 2018-05-09 sad asada";
        String str1=str.replaceAll("([0-9]{4})-([0-9]{2})-([0-9]{2})","$2/$3 $1年");
        System.out.println(str1);
    }





}