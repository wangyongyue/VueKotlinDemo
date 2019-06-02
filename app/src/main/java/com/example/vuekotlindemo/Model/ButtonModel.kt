package com.example.vuekotlindemo.Model

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.vue_kotlin.RHolder
import com.example.vue_kotlin.Router
import com.example.vue_kotlin.Vue
import com.example.vue_kotlin.VueData
import com.example.vuekotlindemo.Main2Activity
import com.example.vuekotlindemo.Main2Interface
import com.example.vuekotlindemo.R

class ButtonModel: Main2Interface {

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
                items.add(ButtonData("button$i"))
            }

            return@v_list items
        })
        indexVue.v_index {


            val data = arrayVue.v_list?.elementAt(it) as ButtonData

            if (data.v_identifier == 0){

                Toast.makeText(Router.instance.topActivity(),"left", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(Router.instance.topActivity(),"right", Toast.LENGTH_SHORT).show()

            }

        }
    }


}
class ButtonData(var name:String): VueData {

    override val layoutIdentity: Int
        get() = R.layout.layout_button

    override var v_identifier: Int = 0



}
class RButtonViewHolder(viewItem: View) : RHolder(viewItem){

    val leftButon: Button = viewItem.findViewById(R.id.left)
    val rightButon: Button = viewItem.findViewById(R.id.right)

    override fun setData(item: VueData){

        if (item is ButtonData){

            var model = item as? ButtonData

            leftButon.setOnClickListener {
                model?.v_identifier = 0

                v_selectOb.v_on?.invoke()


            }
            rightButon.setOnClickListener {

                model?.v_identifier = 1

                v_selectOb.v_on?.invoke()

            }



        }

    }

}