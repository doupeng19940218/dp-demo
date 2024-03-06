package org.example.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import lombok.SneakyThrows;
import org.example.entity.Convertor;
import org.example.entity.DemoDTO;
import org.example.entity.User;
import org.example.other.DogIntroductionAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author walker.dou
 */
@RestController
@RequestMapping("/test")
public class TestController implements ApplicationContextAware {
    public static final String CODE = "{$1.setA(\"i am changed\");}";

//    @CreateCache(expire = 5, timeUnit = TimeUnit.MINUTES, name = "user")
    private Cache<String, User> userCache;
    ApplicationContext applicationContext;

    @RequestMapping("IntroductionInterceptor")
    public void testIntroductionInterceptor() {
        final DogIntroductionAdvisor.Dog dog = applicationContext.getBean(DogIntroductionAdvisor.Dog.class);
        dog.run();
        System.out.println("Animal.class.isAssignableFrom(dog.getClass()) = " + DogIntroductionAdvisor.Animal.class.isAssignableFrom(dog.getClass()));
        DogIntroductionAdvisor.Animal animal = (DogIntroductionAdvisor.Animal) dog;
        animal.eat();
    }
    @RequestMapping
    @ResponseBody
    public String getTest(HttpServletRequest request) {
        String age = request.getParameter("age");
        System.out.println("age=" + age);
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String age1 = request.getParameter("age");
            System.out.println("age1=" + age1);
        }).start();
        return "success";
    }

    @RequestMapping("/getTest2")
    @ResponseBody
    public String getTest2(HttpServletRequest request) {
        String age = request.getParameter("age");
        System.out.println("age=" + age);
        new Thread(() -> {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String age1 = request.getParameter("age");
            System.out.println("age1=" + age1);
        }).start();
        return "success";
    }


    @RequestMapping("/jetCache")
    @ResponseBody
    public User jetCache(HttpServletRequest request) {
        final User instance = User.instance();
        userCache.put(instance.getName(), instance);
        return instance;
    }

    @RequestMapping("/getJetCache")
    @ResponseBody
    public User getJetCache(HttpServletRequest request) {
        return userCache.get("dp");
    }

    @GetMapping("javassist")
    @SneakyThrows
    public void javassist() {
        final DemoDTO demoDTO = new DemoDTO();
        new Convertor().doConvert(demoDTO);
        System.out.println(demoDTO.getA());

        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("com.example.entity.ConvertorImpl");
        ctClass.setSuperclass(pool.get(Convertor.class.getCanonicalName()));

        CtConstructor ctConstructor = new CtConstructor(null, ctClass);
        ctConstructor.setBody("{}");
        ctClass.addConstructor(ctConstructor);

        CtMethod aSetMethod = new CtMethod(pool.get(void.class.getCanonicalName()), "doConvert", pool.get(new String[]{DemoDTO.class.getCanonicalName()}), ctClass);
        aSetMethod.setModifiers(Modifier.PUBLIC);
        aSetMethod.setBody(CODE);
        ctClass.addMethod(aSetMethod);
        ctClass.detach();
        Class<?> clazz = ctClass.toClass();
        Constructor<?> constructor = clazz.getConstructor(null);

        Convertor d = (Convertor) constructor.newInstance(null);
        final DemoDTO demoDTO1 = new DemoDTO();
        d.doConvert(demoDTO1);
        System.out.println(demoDTO1.getA());


    }

    public static void testTime() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("1900-01-01 08:02:00");
        System.out.println(simpleDateFormat.format(date));

//
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date3 = simpleDateFormat3.parse("1200-01-01 08:00:00");
        System.out.println(simpleDateFormat3.format(date3));
    }

    public static void date1927() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String str3 = "1927-12-31  23:54:07";
        String str4 = "1927-12-31  23:54:08";
        Date sDt3 = sf.parse(str3);
        Date sDt4 = sf.parse(str4);
        long ld3 = sDt3.getTime() / 1000;
        long ld4 = sDt4.getTime() / 1000;
        System.out.println(ld4 - ld3);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
