package org.techtown.block

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        normalButton.setOnClickListener {
            var person1: Person? = Person()
            person1?.name = "홍길동"
            person1?.age = 20
            person1?.mobile = "010-123-4567"
        }

        applyButton.setOnClickListener {
            val person1 = Person().apply {
                name = "홍길동"
                age = 20
                mobile = "010-123-4444"

                val info = toString()
                showToast("새로 만든 사람 -> ${info}")
            }
        }

        withButton.setOnClickListener {
            val person1 = Person("홍길동", 20, "011-123-4683")
            with(person1) {
                showToast("이름 : $name")
                showToast("나이 : $age")
                showToast("전화번호 : $mobile")
            }
        }

        letButton.setOnClickListener {
            var person1 : Person? = null
            var create = false
            if (create) {
                person1 = Person("홍길동", 20, "010-222-3445")
            }

            var info = person1?.toString()
            showToast("사람 : $info")

            person1?.let {
                showToast("이름 : ${it.name}")
                showToast("나이 : ${it.age}")
                showToast("전화번호 : ${it.mobile}")
            } ?: run {
            showToast("사람이 null 입니다.")
            }
        }

        runButton.setOnClickListener {
            val person1 = Person("홍길동", 20, "010-1234-3454")
            val result: Boolean = person1.run {
                if (name != null) {
                    showToast("이름 : $name")
                    true
                }else{
                    false
                }
            }
            showToast("결과: ${result}")
        }

        alsoButton.setOnClickListener {
            val person1 = Person()
            val person2 = person1.also {
                showToast("name 속성 값이 null 입니다.")
                it.name = "홍길동"
            }
        }
    }

    fun showToast(message: String ) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

data class Person(var name:String? = null,
                  var age:Int? = null,
                  var mobile:String? = null) {
    override fun toString(): String {
        return "Person [${name}, ${age}, ${mobile}]"
    }
}