package dika.wardani.bareksaperbandingantest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import dika.wardani.bareksaperbandingantest.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private fun initView() {
        navController = findNavController(R.id.main_nav_host_fragment)
    }

    override fun onBackPressed() {
        if (navController.previousBackStackEntry != null) {
            when(navController.currentDestination?.id) {
                R.id.perbandinganFragment -> super.onBackPressed()
                else -> navController.navigateUp()
            }
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

}