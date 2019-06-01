package com.example.vuekotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.example.vue_kotlin.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addActivity()

        var arrayVue = Vue()

        var holders = mapOf<Int,String>(
            R.layout.layout_item to RUserViewHolder::class.java.toString()
        )


        recyler.layoutManager = LinearLayoutManager(this)
        var ad =  RAdapter(holders)
        ad.v_list(arrayVue)
        recyler.adapter = ad

        arrayVue.v_list(true,{

            var items = mutableListOf<VueData>()
            for (i in 1..12){
                items.add(UserData("今天下雨了$i"))
            }

            return@v_list items
        })

        ad.v_didSelect {

            Router.push(Main2.getActivity(),Main2.toString())

        }




    }

    override fun onDestroy() {
        super.onDestroy()
        removeActivity()
    }
}
class UserData(var name:String): VueData {

    override val layoutIdentity: Int
        get() = R.layout.layout_item

    override var v_identifier: Int = 0



}
class RUserViewHolder(viewItem: View) : RHolder(viewItem){

    val textView: TextView = viewItem.findViewById(R.id.text)

    override fun setData(item: VueData){

        if (item is UserData){

            var model = item as? UserData
            textView.setText(model?.name)


            textView.setOnClickListener {

                model?.v_identifier = 1

                v_selectOb.v_on?.invoke()

            }

        }

    }

}
