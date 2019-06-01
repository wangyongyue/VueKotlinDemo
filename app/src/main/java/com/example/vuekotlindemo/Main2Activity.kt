package com.example.vuekotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.vue_kotlin.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_item.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        addActivity()


        val listener = Class.forName(this.className).getConstructor().newInstance() as Main2Interface


        var holders = mapOf<Int,String>(
            R.layout.layout_item to RUserViewHolder::class.java.toString()
        )

        recyler.layoutManager = LinearLayoutManager(this)
        var ad = RAdapter(holders)
        ad.v_list(listener.arrayVue)
        ad.v_index(listener.indexVue)
        recyler.adapter = ad

        listener.startListen()



    }
    override fun onDestroy() {
        super.onDestroy()
        removeActivity()
    }
}

interface Main2Interface{

    val arrayVue:Vue
    val indexVue:Vue
    fun startListen()

}


class Main2:Main2Interface{

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
               items.add(UserData("今天晴朗$i"))
           }

           return@v_list items
       })
        indexVue.v_index {

            Toast.makeText(Router.instance.topActivity(),"$it", Toast.LENGTH_SHORT).show()

        }
    }


}
