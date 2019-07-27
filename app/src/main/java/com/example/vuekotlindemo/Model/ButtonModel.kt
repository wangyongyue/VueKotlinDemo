package com.example.vuekotlindemo.Model

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.vue_kotlin.RHolder
import com.example.vue_kotlin.Router
import com.example.vue_kotlin.Vue
import com.example.vue_kotlin.VueData
import com.example.vuekotlindemo.*

class ButtonModel: Vue() {

    override fun v_viewController(): Class<Any>? {
        return Main2Activity::class.java as Class<Any>
    }

    override fun v_start() {
        super.v_start()

        var items = mutableListOf<VueData>()
        for (i in 1..12){
            items.add(ButtonData("button$i"))
        }
        this.v_array(arrayID,{

            return@v_array items
        })
        this.v_index(indexID,{ it:Int ->

            val data = items.elementAt(it) as ButtonData

            if (data.v_identifier == 0){

                Toast.makeText(Router.instance.topActivity(),"left", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(Router.instance.topActivity(),"right", Toast.LENGTH_SHORT).show()

            }

        })


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

               v_to()


            }
            rightButon.setOnClickListener {

                model?.v_identifier = 1

                v_to()

            }



        }

    }

}