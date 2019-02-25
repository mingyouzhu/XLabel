# XLabel

###引入




####使用教程
MainActivity.kt
```
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

```

activity_main.xml
`
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

    <com.onlly.soft.lib.XLabelView
            android:id="@+id/xlabel_demo"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:layout_constraintStart_toStartOf="parent"
            android:layout_marginStart="8dp"
            android:layout_marginTop="8dp"
            app:lineSpacing="12.0dip"
            app:tagSpacing="12.0dip"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            android:layout_marginEnd="8dp"/>

</android.support.constraint.ConstraintLayout>
`
