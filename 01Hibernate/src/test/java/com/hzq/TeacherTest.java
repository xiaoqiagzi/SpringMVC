package com.hzq;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;
import com.hzq.bean.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class TeacherTest {
    Transaction transaction=null;//定义在这里使用
    Session session=null;
    @Before
    public void before(){
        //01.读取核心配置文件 configure()底层就是加载了/hibernate.cfg.xml
        Configuration configuration =new Configuration().configure();
        //02.创建会话工厂 sessionFactory
        SessionFactory factory=configuration.buildSessionFactory();
        //03创建会话session
        session=factory.openSession();
        //04开启事务
        transaction=session.beginTransaction();
    }
    @After
    public void after(){
        //07提交事务
        transaction.commit();
        //08关闭会话
        session.close();
    }
    /**
     * 新增教师信息
     */
    @Test
    public void addTeacher(){
        //创建treacher对象
        Teacher teacher=new Teacher();
        teacher.setId(1);
        teacher.setName("李逵");
        //持久化操作
        System.out.println("************");
        session.save(teacher);
        System.out.println("*************");
        //factory.close();
    }
    @Test
    public void delTeacher(){
        Teacher teacher=new Teacher();
        teacher.setId(1);
        System.out.println("************");
        session.delete(teacher);
        System.out.println("*************");

    }
    @Test
    public void  updateTeacher(){
        //创建需要修改的对象
        Teacher teacher=new Teacher();
        teacher.setId(1);
        teacher.setName("李寻欢");
        System.out.println("***********************");
        //修改
        session.update(teacher);
        System.out.println("***********************");
    }
    /**
     * 从数据库中查询指定id的信息
     *   get和load的区别
     *   get：
     *     01.在get()立即产生sql语句
     *     02.首先会去hibernate的1级缓存（session）中查询有没有对应的数据，
     *        如果用，直接返回,不去访问数据库，
     *        如果没有，而且我们配置了2级缓存，那么会去2级缓存中查询，
     *        如果2级缓存没有数据，就去访问数据库。
     *     03.如果数据库中有对应的数据 直接返回
     *        数据库中没有对应的数据，则返回null
     */
    @Test
    public void getTeacher(){
        System.out.println("********************");
        Teacher teacher= (Teacher) session.get(Teacher.class,2);
        System.out.println("*********************");
        System.out.println(teacher);
    }
    /**
     * 验证get会把查询到的数据放进session缓存中
     */
    @Test
    public void getTeacherSession(){
        System.out.println("********************");
        Teacher teacher1= (Teacher) session.get(Teacher.class,2);

        System.out.println("111111111111");
        Teacher teacher2= (Teacher) session.get(Teacher.class,2);
        System.out.println(teacher2);
        System.out.println("*********************");

    }
    /**
     * load： 懒加载
     *   01.不会在load的时候 产生sql语句，
     *      用户需要的时候产生
     *  02.首先会去hibernate的1级缓存（session）中查询有没有对应的数据，
     *        如果用，直接返回,不去访问数据库，
     *        如果没有，而且我们配置了2级缓存，那么会去2级缓存中查询，
     *        如果2级缓存没有数据，就去访问数据库。
     *  03.如果数据库中有对应的数据 直接返回
     *        数据库中没有对应的数据，则抛出ObjectNotFoundException
     */
    /**
     * load也可以使用立即加载
     *  去对应类所在的hbm.xml文件中的class节点上 增加  lazy="false"  立即加载
     *  默认lazy="true"
     */
    @Test
    public void loadTeacherSession(){
        Teacher teacher= (Teacher) session.load(Teacher.class,2);//没有sql语句
        System.out.println("*****************************");
        System.out.println(teacher);
        System.out.println("*****************************");

    }
    /**
     * evict  从session中清除指定的对象
     */
    @Test
    public void evictTeacher(){
        Teacher teacher= (Teacher) session.get(Teacher.class,1);
        Teacher teacher1= (Teacher) session.get(Teacher.class,2);
        System.out.println("*******************");
        session.evict(teacher);
        teacher= (Teacher) session.get(Teacher.class,1);

    }
    /**
     * clear  从session中清空所有对象
     */
    @Test
    public void  clearTeacher(){
        Teacher teacher1= (Teacher) session.get(Teacher.class,1);
        Teacher teacher2= (Teacher) session.get(Teacher.class,2);
        System.out.println("**********************************************");
        //清空所有对象
        session.clear();
        teacher1= (Teacher) session.get(Teacher.class,1); //再次查询
        teacher2= (Teacher) session.get(Teacher.class,2); //再次查询
    }
    /**
     * HQL: hibernate query language
     * 之前的sql:  查询教师表中的所有
     *    select * from  teacher; (表名)
     * 之前的hql:  查询教师表中的所有
     *   from  Teacher（类名）
     */
    @Test
    public void testList(){
        //书写HQL语句
        String hql="from Teacher";
        //创建query对象
        Query query=session.createQuery(hql);
        //查询所有
        List<Teacher> list=query.list();
        System.out.println("********************");
        for(Teacher t:list){
            System.out.println(t);
        }
    }
    @Test
    public void testIterator(){
        //书写HQL语句
        String hql="from Teacher";
        //创建query语句
        Query query=session.createQuery(hql);
        //查询所有
        Iterator<Teacher> iterator=query.iterate();
        System.out.println("*************");
        while (iterator.hasNext()){
            Teacher teacher=iterator.next();
            System.out.println(teacher);
        }
    }
    @Test
    public void testHql() {
        String hql = "from  Teacher";  // 底层会转换成 select * from teacher;
        //创建query对象
        Query query = session.createQuery(hql);
        //执行查询语句
        System.out.println("******************");
        List<Teacher> list = query.list();  //会把查询的数据放进缓存中
        for (Teacher t : list) {
            System.out.println(t);
        }
        list = query.list();  //再次查询   不走缓存  再次查询数据库
        for (Teacher t : list) {
            System.out.println(t);
        }
        //清除缓存
        session.clear();
        for (Teacher t:list) {
            System.out.println(t);
        }
        }
    @Test
    public void testList2() {
        String hql = "from  Teacher";  // 底层会转换成 select * from teacher;
        //创建query对象
        Query query = session.createQuery(hql);
        //执行查询语句
        System.out.println("******************");
        List<Teacher> list = query.list();  //会把查询的数据放进缓存中
        for (Teacher t : list) {
            System.out.println(t);
        }
        System.out.println(session.get(Teacher.class,1));  // 证明list获取的数据确实放进缓存中
    }

    @Test
    public  void  testIterator2() {
        String hql = "from  Teacher";  //书写hql语句
        Query query = session.createQuery(hql);  //创建query对象
        Iterator<Teacher> iterator = query.iterate();  //通过query对象执行iterate查询
        System.out.println("*******************************");
        while (iterator.hasNext()) {  //遍历结果集
            Teacher teacher = iterator.next(); //会那id去数据库中查询一次
            System.out.println(teacher);
        }
        //清理缓存   session.clear();
        iterator = query.iterate();  //通过query对象执行iterate查询
        while (iterator.hasNext()) {  //遍历结果集
            Teacher teacher = iterator.next();
            System.out.println(teacher);
        }

    }
    @Test
    public  void  testIterator4(){
        String  hql="from  Teacher";  //书写hql语句
        Query query=  session.createQuery(hql);  //创建query对象
        Iterator<Teacher> iterator= query.iterate();  //通过query对象执行iterate查询
        System.out.println("*******************************");
        while (iterator.hasNext()){  //遍历结果集
            System.out.println("===================================");
            Teacher teacher=   iterator.next();
            System.out.println(teacher);
        }
        //清理缓存
        iterator= query.iterate();  //通过query对象执行iterate查询
        while (iterator.hasNext()){  //遍历结果集
            Teacher teacher=   iterator.next();
            System.out.println(teacher);
        }

    }


    /**
     * 验证
     * 如果缓存中没有数据 iterator回去查询数据库
     */
    @Test
    public  void  testIterator3() {
        //先从数据库中获取两条数据
        Teacher teacher1 = (Teacher) session.get(Teacher.class, 1); //1
        Teacher teacher2 = (Teacher) session.get(Teacher.class, 3); //1
        //现在为止  缓存中有两条数据  oid  分别是 1  3
        Query query = session.createQuery("from  Teacher");
        Iterator<Teacher> it = query.iterate(); //1
        while (it.hasNext()) {
            Teacher teacher = it.next();
            System.out.println(teacher); //1
        }
    }

    }
/**
 * list和iterator的区别
 * 相同点:
 *     01.都是从数据库中获取数据的集合!
 *     02.都会把数据放进缓存中
 * list:
 *    01.无论缓存中是否有数据，都会从数据库中查询（不走缓存）
 *    02.执行list一次，生成一次select语句
 * iterator：
 *     01.如果数据库中有N条数据，那么会产生N+1条select语句
 *     02.第一个select语句是从数据库中查询所有的数据的id
 *       id要作为OID  缓存的依据
 *     03.无论如何都需要执行一条sql语句就是查询所有的id
 *        query.iterate()
 *     04.iterator.next()产生的sql就是数据库中数据的数量
 * iterator能够利用懒加载和缓存的机制来提高查询效率！
 * 第一条语句就是从数据库中获取所有的id，保存在缓存中，
 * 便于下次查询！ 只有缓存中不存在数据时，才会去查询数据库！
 * iterator使用于开启二级缓存的情况！
 */

