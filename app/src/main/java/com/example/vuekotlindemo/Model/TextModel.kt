package com.example.vuekotlindemo.Model

import android.widget.Toast
import com.example.vue_kotlin.Router
import com.example.vue_kotlin.Vue
import com.example.vue_kotlin.VueData
import com.example.vuekotlindemo.*

class TextModel:  Vue() {

    override fun v_viewController(): Class<Any>? {
        return Main2Activity::class.java as Class<Any>
    }

    override fun v_start() {
        super.v_start()

        var items = mutableListOf<VueData>()
        for (i in 1..12){
            items.add(UserData("text$i"))
        }
        this.v_array(arrayID,{

            return@v_array items
        })
        this.v_index(indexID,{ it:Int ->


        })


    }


}