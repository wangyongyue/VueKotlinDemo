package com.example.vuekotlindemo.Model

import android.widget.Toast
import com.example.vue_kotlin.Router
import com.example.vue_kotlin.Vue
import com.example.vue_kotlin.VueData
import com.example.vuekotlindemo.Main2Activity
import com.example.vuekotlindemo.Main2Interface
import com.example.vuekotlindemo.UserData

class TextModel: Main2Interface {

    override val arrayVue: Vue = Vue()
    override val indexVue: Vue = Vue()

    companion object{

        fun getActivity(): Class<Any>{

            return Main2Activity::class.java as Class<Any>
        }

    }

    override fun startListen() {

        arrayVue.v_list(false,{


            var items = mutableListOf<VueData>()
            for (i in 1..12){
                items.add(UserData("text$i"))
            }

            return@v_list items
        })
        indexVue.v_index {

            Toast.makeText(Router.instance.topActivity(),"$it", Toast.LENGTH_SHORT).show()

        }
    }


}