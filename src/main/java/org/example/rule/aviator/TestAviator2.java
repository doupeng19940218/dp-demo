package org.example.rule.aviator;

/**
 * @program: flinkcep
 * @description:
 * @author: Mr.Wang
 * @create: 2020-11-30 18:04
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestAviator2 {
    int i;
    float f;
    Date date;

    public TestAviator2(final int i, final float f, final Date date) {
        this.i = i;
        this.f = f;
        this.date = date;
    }

    public int getI() {
        return this.i;
    }

    public void setI(final int i) {
        this.i = i;
    }

    public float getF() {
        return this.f;
    }

    public void setF(final float f) {
        this.f = f;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public static void main(final String[] args) {

        String  aaa = "{\n" +
                "\t\"name\": \"桔子桑\",\n" +
                "\t\"sex\": \"男\",\n" +
                "\t\"age\": 18,\n" +
                "\t\"grade\": {\n" +
                "\t\t\"gname\": \"1\",\n" +
                "\t\t\"gdesc\": \"初三年级八班\"\n" +
                "\t}\n" +
                "}";

        Map<String, Object> env2 = new HashMap<String, Object>();
        env2.put("aa",JSON.parseObject(aaa));
        System.out.println("========> "+AviatorEvaluator.execute("aa.grade.gname==\"1\"", env2));

        TestAviator2 foo = new TestAviator2(100, 3.14f, new Date());
        Map<String, Object> env = new HashMap<String, Object>();


        env.put("foo", foo);
        System.out.println(AviatorEvaluator.execute("'foo.i = '+foo.i", env));
        System.out.println(AviatorEvaluator.execute("'foo.f = '+foo.f", env));
        System.out.println(AviatorEvaluator.execute("'foo.date.year = '+ (foo.date.year+1990)", env));
        String expression = "a>b";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a",2);
        map.put("b",1);
        Expression execute =   AviatorEvaluator.compile(expression);
        Object execute1 = execute.execute(map);


        String valueStr ="a=='443b6ea6bc117c'&&b=='4'&&c=='/publicLog/appAttack'";
//        JSONObject valueStrJson = strToMap(valueStr);
        Expression expressionBean = AviatorEvaluator.compile(valueStr,true);
        for (int i = 0; i < 1; i++) {
            long start = System.currentTimeMillis();

//            Expression expressionBean = AviatorEvaluator.compile(valueStr);
            // 转成Map格式
//        Map<String, Object> logCompareMap = JSON.parseObject(logBeanStr, Map.class);
            Map<String, Object> logCompareMap = new HashMap<String, Object>();
            logCompareMap.put("a","443b6ea6bc117c");
            logCompareMap.put("b","4");
            logCompareMap.put("c","/publicLog/appAttack");
            logCompareMap.put("d","aaaa");
            Boolean eventFlag = (Boolean) expressionBean.execute(logCompareMap);
            System.out.println("eventFlag = " + eventFlag);
            long end = System.currentTimeMillis();
            System.out.println("end = " + (end-start));
        }


    }

    public static JSONObject strToMap(String valueListStr) {
        JSONObject returnJson = new JSONObject();
        if (valueListStr.startsWith("(") && valueListStr.endsWith(")")) {
            String valueListStrSub = valueListStr.substring(1);
            String conditionValueStr = valueListStrSub.substring(0, valueListStrSub.length() - 1)
                    .replaceAll("&&", "\001")
                    .replaceAll("\\|\\|", "\001")
                    .replaceAll("'", "");


            String[] keyValueList = conditionValueStr.split("\001");
            try {
                for (String keyValueStr : keyValueList) {

                    //这里只需要将数组里面包含 '=='的数据带入接口方法
                    if (keyValueStr.contains("==")) {
                        String[] keyValues = keyValueStr.split("==");
                        if (keyValues.length > 1) {
                            returnJson.put(keyValues[0], keyValues[1]);
                        } else {
                            returnJson.put(keyValues[0], "");
                        }

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }


        return returnJson;
    }

}
