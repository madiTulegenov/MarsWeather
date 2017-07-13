package com.marsttudio.marsweather

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

/**
 * Created by marsstudio on 13.07.17.
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        val fragmentManager: FragmentManager = supportFragmentManager
        var fragment: Fragment? = fragmentManager.findFragmentById(R.id.container)
        if(fragment == null){
            fragment = getFragment()
            fragmentManager.beginTransaction()
                    .add(R.id.container,fragment)
                    .commit()
        }
    }

    abstract fun  getFragment(): Fragment?

    @LayoutRes
    abstract fun getLayout(): Int
}