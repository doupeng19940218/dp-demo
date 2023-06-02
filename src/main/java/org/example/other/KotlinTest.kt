package com.ecovacs.adminmgr.controller

class Greeter(val name: String) {
    fun greet() {
        println("Hello, $name")
    }

    fun max(a: Int, b: Int): Int {
        return maxOf(a, b)
    }
}


fun main(args: Array<String>) {
//    Greeter("World!").greet()          // 创建一个对象不用 new 关键字
//    println(Greeter("World!").max(2, 3))

//    var age: String? = "23"
////抛出空指针异常
//    val ages = age!!.toInt()
////不做处理返回 null
//    val ages1 = age?.toInt()
////age为空返回-1
//    val ages2 = age?.toInt() ?: -1

//    val x = 1;
//    when (x) {
//        in 1..2 -> print("x is odd")
//        else -> print("x is funny")
//    }
    Runoob().foo()

    var allByDefault: Int?


}

class Runoob() {
    fun foo() = print("Foo")  // 成员函数
}
class Person {

    var lastName: String = "zhang"
        get() = field.uppercase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set
}

open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    override abstract fun f()
}
