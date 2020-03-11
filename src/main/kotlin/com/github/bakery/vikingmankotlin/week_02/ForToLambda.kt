package com.github.bakery.vikingmankotlin.week_02


fun forloop(targets: Iterable<String>)= targets
        .asSequence()
        .filter { it.isNotEmpty() }
        .map { it.first() }
        .joinToString()



