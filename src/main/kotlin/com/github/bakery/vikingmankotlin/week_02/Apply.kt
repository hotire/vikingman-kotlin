package com.github.bakery.vikingmankotlin.week_02

import org.springframework.validation.BindException


fun User.validate() = BindException(this, User::class.qualifiedName.orEmpty())
        .apply {
               if (name.isEmpty()) {
                   this.rejectValue("name", "", "name is empty")
               }
               if (age <= 0) {
                   this.rejectValue("age", "", "age is less than 0")
               }
        }


