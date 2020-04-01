package com.github.bakery.vikingmankotlin.week_05

import java.lang.annotation.Inherited
import java.security.MessageDigest
import kotlin.reflect.KProperty
import kotlin.reflect.full.declaredMemberProperties

fun String.sha256(): String {
    return hashString(this, "SHA-256")
}

private fun hashString(input: String, algorithm: String): String {
    return MessageDigest
            .getInstance(algorithm)
            .digest(input.toByteArray())
            .fold("", { str, it -> str + "%02x".format(it) })
}

interface HashAware {
    @Inherited
    @Retention
    @Target(AnnotationTarget.PROPERTY)
    annotation class HashCode(val order: Int)

    public fun findAnnotation(kProperty: KProperty<*>) : HashCode? {
        // TODO findAnnotation HashCode
        return null
    }

    fun hasAnnotation(kProperty: KProperty<*>): Boolean {
        // TODO hasAnnotation HashCode
        return false
    }
    fun getHash() : String {
        // TODO 클래스의 모든 프로퍼티의 값을 getPrefix + value + order 형태 String 으로 생성하고의 List 로 모으고 joinToString -> sha256 리턴한다.
        /**
         * ex) Person / PersonHashAware
         * Person 의 프로퍼티는 name / age / address 가 있다.
         * 하지만 HashCode가 붙은 프로퍼티는 name / age 뿐이다.
         *
         * Person("hotire", "22") 일 경우
         *
         * person + hotire + 1
         * person + 22 + 2
         *
         * 의 형태로 String이 만들어 지고 List로 모으고 joinToString을 하면 "personhotire1 person222" 의 형태로 만들어지고 personhotire1 person222의 sha256를 리턴한다.
         *
         */
        return ""
    }

    fun getPrefix() : String = this::class.simpleName ?: ""

}
interface PersonHashAware : HashAware {
    @HashAware.HashCode(1)
    val name : String
    @HashAware.HashCode(2)
    val age: Int
}

class Person(override val name: String, override val age: Int) : PersonHashAware {
    lateinit var address : String
    override fun getPrefix() : String = "person"
}