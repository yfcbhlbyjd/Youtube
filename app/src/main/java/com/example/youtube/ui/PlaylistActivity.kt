package com.example.youtube.ui

import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.MainActivity
import com.example.youtube.base.BaseActivity
import com.example.youtube.base.BaseViewModel
import com.example.youtube.databinding.ActivityPlaylistBinding


class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, BaseViewModel>() {

    private lateinit var viewModel: PlaylistViewModel


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
    return ActivityPlaylistBinding.inflate(layoutInflater)
}

    override fun setUI() {
        viewModel = ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun setupLiveData() {
        viewModel.playlist().observe(this) {
            Toast.makeText(this, Toast.LENGTH_LONG).show()
        }
    }

    override fun checkInternet() {
    }

    override fun initClickListener() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
            Toast.makeText(this, Toast.LENGTH_LONG).show()
        }
    }


}
