package com.onlly.soft.xlabel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.onlly.soft.lib.XLabelModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            xlabel_demo.clear()
        }

        button2.setOnClickListener {
            init()
        }
    }

    fun init(){
        val array = arrayOf(
            XLabelBean(1,"三至松鼠"),
            XLabelBean(2,"女士透明小内裤"),
            XLabelBean(3,"西装"),
            XLabelBean(4,"拖鞋"),
            XLabelBean(5,"领带"),
            XLabelBean(6,"大裤衩"),
            XLabelBean(7,"牛仔裤")
        )
        xlabel_demo.initData(this@MainActivity,array.toList())
        xlabel_demo.setItemClickListener {
            Toast.makeText(this@MainActivity,"你点击了${it.onGetName()}",Toast.LENGTH_LONG).show()
        }
    }

    class XLabelBean(val id:Int?,val nickName:String):XLabelModel(){
        override fun onGetName(): String {
            return nickName
        }
    }
}
