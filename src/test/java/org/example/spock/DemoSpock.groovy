package org.example.spock

import lombok.Data
import spock.lang.Specification


/**
 * @author walker.dou
 */
class DemoSpock extends Specification {
    def demo1() {

        when:
        def a = 1 + 1

        then:
        a == 2
    }

    def demo2() {
        given:
        def list = new ArrayList()

        when:
        list.add("1")
        list.add("2")
        list.add("3")

        then:
        list.size() == 3

        and:
        println "大家好"

        expect:
        list.add("4")
        list.size() == 4
    }

    def demo3() {
        expect:
        c == Math.max(a, b)

        where:
        c | b | a
        2 | 2 | 1
        4 | 3 | 4

    }

    def "最大数单元测试"() {
        given: "准备环境数据"
        int i = 1, j = 3;

        when: "待验证函数"
        int result = Math.max(i, j);

        then: "结果验证"
        result == 3;
    }

    def "批量复杂结果验证"() {

        setup: "类环境"
        PersonService service = new PersonService();

        when: "数据准备及函数执行"
        Person person = new Person(name: personName, yearOfBirth: personYear);
        //设置标签
        person.setLabel(service.getLabel(person));

        then: "验证方式"
        person.toString() == personInfo;
        person.label == personLabel;

        where: "批量输入,输出参数"
        personName | personYear || personInfo     | personLabel
        "张三"       | "1985"     || "张三,1985,80后"  | "80后"
        "Tom"      | "2001"     || "Tom,2001,00后" | "00后"
        "王五"       | "2011"     || "王五,2011,10后"  | "10后"
    }

    def "MOCK批量复杂结果验证"() {
        setup: "类环境"
        //mock PersonService
        PersonService service = Mock(PersonService);

        when: "数据准备及函数执行"
        Person person = new Person(name: personName, yearOfBirth: personYear);
        //覆盖getLabel方法实现,>>表示定义或返回方法结果
        service.getLabel(_) >> { Person p -> p.getYearOfBirth() + "出生" }
        //设置标签
        person.setLabel(service.getLabel(person));

        then: "验证方式"
        person.toString() == personInfo
        person.label == personLabel

        where: "批量输入,输出参数"
        personName | personYear || personInfo       | personLabel
        "张三"       | "1985"     || "张三,1985,1985出生" | "1985出生"
    }


}

@Data
class Person {
    private String name;
    private String yearOfBirth;
    private String label;

    public String toString() {
        return String.join(",", name, yearOfBirth, label);
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getYearOfBirth() {
        return yearOfBirth
    }

    void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth
    }

    String getLabel() {
        return label
    }

    void setLabel(String label) {
        this.label = label
    }
}

class PersonService {
    public String getLabel(Person person) {
        return Optional.ofNullable(person)
                .filter(p -> Objects.nonNull(p.getYearOfBirth()) && p.getYearOfBirth().length() == 4)
                .map(p -> p.getYearOfBirth().substring(2, 3) + "0后").orElse("");
    }
}

