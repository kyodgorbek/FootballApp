package yodgorbekkomilov.edgar.footballapp

import android.app.Activity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import yodgorbekkomilov.edgar.footballapp.databinding.ActivityMainBinding
import yodgorbekkomilov.edgar.footballapp.di.module.ViewModelFactory
import yodgorbekkomilov.edgar.footballapp.ui.FootballListViewModel



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: FootballListViewModel
    private var errorSnackbar: Snackbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(FootballListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }

    }
